import AuthentificationApi from '../../api-ms-user/js-client/src/api/AuthentificationApi';
import RlesApi from '../../api-ms-user/js-client/src/api/RlesApi';
import LoginRequest from '../../api-ms-user/js-client/src/model/LoginRequest';
import RefreshRequest from '../../api-ms-user/js-client/src/model/RefreshRequest';
import UtilisateurRequestDTO from '../../api-ms-user/js-client/src/model/UtilisateurRequestDTO';
import apiClient from '../../utils/apiConfig';

const authApi = new AuthentificationApi(apiClient);
const rolesApi = new RlesApi(apiClient);
const API_BASE_URL = 'http://localhost:8088/api/v1';

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
   * Connexion utilisateur
   */
  login: async (email, motDePasse) => {
    try {
      const response = await fetch(`${API_BASE_URL}/auth/connecter`, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
          Accept: 'application/json',
        },
        body: JSON.stringify({ email, motDePasse }),
      });

      if (!response.ok) {
        throw new Error(`HTTP ${response.status}`);
      }

      const data = await response.json();

      // Stocker tokens bruts
      if (data.accessToken) {
        localStorage.setItem('accessToken', data.accessToken);
      }
      if (data.refreshToken) {
        localStorage.setItem('refreshToken', data.refreshToken);
      }

      // Décoder JWT
      const decoded = decodeJWT(data.accessToken);

      // Mapper le rôle JWT → rôle applicatif
      const roleLibelle = mapJwtRoleToAppRole(decoded, email);

      const user = {
        id: decoded?.uid || decoded?.sub || null,
        email: decoded?.email || decoded?.sub || email,
        nom: decoded?.nom || '',
        prenom: decoded?.prenom || '',
        role: roleLibelle,               // 'ALUMNI' | 'ETUDIANT' | 'USER'
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
      return data;
    } catch (error) {
      console.error('❌ Login échoué:', error);
      throw error;
    }
  },

  /**
   * Inscription d'un utilisateur
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
          reject(error);
        } else {
          resolve(data);
        }
      });
    });
  },

  /**
   * Rafraîchir le token JWT
   */
  refreshToken: async (refreshToken) => {
    try {
      const response = await fetch(`${API_BASE_URL}/auth/refresh`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ refreshToken }),
      });

      if (!response.ok) {
        localStorage.removeItem('accessToken');
        localStorage.removeItem('refreshToken');
        localStorage.removeItem('user');
        throw new Error(`HTTP ${response.status}`);
      }

      const data = await response.json();
      if (data.accessToken) {
        localStorage.setItem('accessToken', data.accessToken);
      }
      if (data.refreshToken) {
        localStorage.setItem('refreshToken', data.refreshToken);
      }

      return data;
    } catch (error) {
      localStorage.removeItem('accessToken');
      localStorage.removeItem('refreshToken');
      localStorage.removeItem('user');
      throw error;
    }
  },

  /**
   * Déconnexion utilisateur
   */
  logout: async () => {
    try {
      const refreshToken = localStorage.getItem('refreshToken');
      if (refreshToken) {
        await fetch(`${API_BASE_URL}/auth/deconnecter`, {
          // attention: path conforme à ton OpenAPI
          method: 'POST',
          headers: { 'Content-Type': 'application/json' },
          body: JSON.stringify({ refreshToken }),
        });
      }
    } catch (error) {
      console.warn('Logout serveur échoué:', error);
    } finally {
      localStorage.removeItem('accessToken');
      localStorage.removeItem('refreshToken');
      localStorage.removeItem('user');
    }
  },

  isAuthenticated: () => {
    return !!localStorage.getItem('accessToken');
  },

  getAccessToken: () => {
    return localStorage.getItem('accessToken');
  },

  getRefreshToken: () => {
    return localStorage.getItem('refreshToken');
  },

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
