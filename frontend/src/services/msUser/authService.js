import AuthentificationApi from '../../api-ms-user/js-client/src/api/AuthentificationApi';
import LoginRequest from '../../api-ms-user/js-client/src/model/LoginRequest';
import RefreshRequest from '../../api-ms-user/js-client/src/model/RefreshRequest';
import UtilisateurRequestDTO from '../../api-ms-user/js-client/src/model/UtilisateurRequestDTO';
import apiClient, { setAuthToken } from '../../utils/apiConfig';

// Création de l'instance API
const authApi = new AuthentificationApi(apiClient);

// Fonction pour décoder le JWT
const decodeJWT = (token) => {
  try {
    if (!token) return null;
    const base64Url = token.split('.')[1];
    const base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
    const jsonPayload = decodeURIComponent(
      atob(base64)
        .split('')
        .map((c) => '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2))
        .join('')
    );
    return JSON.parse(jsonPayload);
  } catch (error) {
    console.error('Erreur lors du décodage du JWT:', error);
    return null;
  }
};

// Normalisation du rôle issu du JWT → 'ALUMNI' | 'ETUDIANT' | 'USER'
const mapJwtRoleToAppRole = (decoded, fallbackEmail) => {
  if (!decoded) return 'USER';

  const rawRole =
    (Array.isArray(decoded.roles) && decoded.roles.length > 0 && decoded.roles[0]) ||
    decoded.role ||
    decoded.authorities?.[0] ||
    null;

  let appRole = 'USER';

  if (rawRole === 'ROLE_ALUMNI' || rawRole === 'ALUMNI') {
    appRole = 'ALUMNI';
  } else if (rawRole === 'ROLE_ETUDIANT' || rawRole === 'ETUDIANT') {
    appRole = 'ETUDIANT';
  } else if (fallbackEmail) {
    const lower = fallbackEmail.toLowerCase();
    if (lower.includes('alumni')) appRole = 'ALUMNI';
    if (lower.includes('etudiant')) appRole = 'ETUDIANT';
  }

  return appRole;
};

export const authService = {
  /**
   * Connexion utilisateur - Utilise le client généré
   */
  login: (email, motDePasse) => {
    return new Promise((resolve, reject) => {
      const loginRequest = new LoginRequest(email, motDePasse);

      authApi.login(loginRequest, (error, data, response) => {
        if (error) {
          console.error('❌ Login échoué:', error);
          reject(error);
          return;
        }

        // Stocker les tokens
        if (data.accessToken) {
          localStorage.setItem('accessToken', data.accessToken);
          setAuthToken(data.accessToken); // Configurer l'ApiClient
        }
        if (data.refreshToken) {
          localStorage.setItem('refreshToken', data.refreshToken);
        }

        // Décoder JWT et créer l'objet utilisateur
        const decoded = decodeJWT(data.accessToken);
        const roleLibelle = mapJwtRoleToAppRole(decoded, email);

        const user = {
          id: decoded?.uid || decoded?.sub || null,
          email: decoded?.email || decoded?.sub || email,
          nom: decoded?.nom || '',
          prenom: decoded?.prenom || '',
          role: roleLibelle,
          rawRole:
            (Array.isArray(decoded?.roles) && decoded.roles[0]) ||
            decoded?.role ||
            null,
          username:
            decoded?.preferred_username ||
            decoded?.username ||
            email,
          telephone: decoded?.telephone || decoded?.phone || '',
        };

        localStorage.setItem('user', JSON.stringify(user));
        data.user = user;

        console.log('✅ Login réussi:', { user });
        resolve(data);
      });
    });
  },

  /**
   * Inscription d'un utilisateur - Utilise le client généré
   */
  registerUser: (userData) => {
    return new Promise((resolve, reject) => {
      const utilisateurDTO = new UtilisateurRequestDTO(
        userData.nom,
        userData.prenom,
        userData.email,
        userData.username || userData.email,
        userData.motDePasse,
        userData.telephone,
        userData.role
      );

      authApi.inscrire(utilisateurDTO, (error, data, response) => {
        if (error) {
          console.error('❌ Inscription échouée:', error);
          reject(error);
        } else {
          console.log('✅ Inscription réussie:', data);
          resolve(data);
        }
      });
    });
  },

  /**
   * Rafraîchir le token JWT - Utilise le client généré
   */
  refreshToken: (refreshToken) => {
    return new Promise((resolve, reject) => {
      const refreshRequest = new RefreshRequest(refreshToken || localStorage.getItem('refreshToken'));

      authApi.refresh(refreshRequest, (error, data, response) => {
        if (error) {
          console.error('❌ Refresh token échoué:', error);
          // Nettoyer le localStorage en cas d'erreur
          localStorage.removeItem('accessToken');
          localStorage.removeItem('refreshToken');
          localStorage.removeItem('user');
          setAuthToken(null);
          reject(error);
          return;
        }

        // Mettre à jour les tokens
        if (data.accessToken) {
          localStorage.setItem('accessToken', data.accessToken);
          setAuthToken(data.accessToken);
        }
        if (data.refreshToken) {
          localStorage.setItem('refreshToken', data.refreshToken);
        }

        console.log('✅ Token rafraîchi avec succès');
        resolve(data);
      });
    });
  },

  /**
   * Déconnexion utilisateur - Utilise le client généré
   */
  logout: () => {
    return new Promise((resolve, reject) => {
      const refreshToken = localStorage.getItem('refreshToken');
      
      if (!refreshToken) {
        // Pas de refresh token, juste nettoyer localement
        localStorage.removeItem('accessToken');
        localStorage.removeItem('refreshToken');
        localStorage.removeItem('user');
        setAuthToken(null);
        resolve();
        return;
      }

      const refreshRequest = new RefreshRequest(refreshToken);

      authApi.logout(refreshRequest, (error, data, response) => {
        // Nettoyer le localStorage dans tous les cas
        localStorage.removeItem('accessToken');
        localStorage.removeItem('refreshToken');
        localStorage.removeItem('user');
        setAuthToken(null);

        if (error) {
          console.warn('⚠️ Logout serveur échoué (mais nettoyage local effectué):', error);
          // On ne rejette pas car le nettoyage local est fait
          resolve();
        } else {
          console.log('✅ Déconnexion réussie');
          resolve();
        }
      });
    });
  },

  /**
   * Vérifie si l'utilisateur est authentifié
   */
  isAuthenticated: () => {
    return !!localStorage.getItem('accessToken');
  },

  /**
   * Récupère le token d'accès
   */
  getAccessToken: () => {
    return localStorage.getItem('accessToken');
  },

  /**
   * Récupère le refresh token
   */
  getRefreshToken: () => {
    return localStorage.getItem('refreshToken');
  },

  /**
   * Récupère l'utilisateur courant
   */
  getCurrentUser: () => {
    try {
      const userStr = localStorage.getItem('user');
      return userStr ? JSON.parse(userStr) : null;
    } catch {
      return null;
    }
  },
};

export default authService;