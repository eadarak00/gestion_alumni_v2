import { AuthentificationApi } from "../../api-ms-user/js-client";
import apiClient, { msUserConfiguration, setAuthToken } from "../../utils/apiConfig";

// Instance API (typescript-axios)
const authApi = new AuthentificationApi(msUserConfiguration, undefined, apiClient);

// Fonction pour décoder le JWT
const decodeJWT = (token) => {
  try {
    if (!token) return null;
    const base64Url = token.split(".")[1];
    const base64 = base64Url.replace(/-/g, "+").replace(/_/g, "/");
    const jsonPayload = decodeURIComponent(
      atob(base64)
        .split("")
        .map((c) => "%" + ("00" + c.charCodeAt(0).toString(16)).slice(-2))
        .join("")
    );
    return JSON.parse(jsonPayload);
  } catch (error) {
    console.error("Erreur lors du décodage du JWT:", error);
    return null;
  }
};

// Normalisation du rôle issu du JWT → 'ALUMNI' | 'ETUDIANT' | 'USER'
const mapJwtRoleToAppRole = (decoded, fallbackEmail) => {
  if (!decoded) return "USER";

  const rawRole =
    (Array.isArray(decoded.roles) && decoded.roles.length > 0 && decoded.roles[0]) ||
    decoded.role ||
    decoded.authorities?.[0] ||
    null;

  let appRole = "USER";

  if (rawRole === "ROLE_ALUMNI" || rawRole === "ALUMNI") {
    appRole = "ALUMNI";
  } else if (rawRole === "ROLE_ETUDIANT" || rawRole === "ETUDIANT") {
    appRole = "ETUDIANT";
  } else if (fallbackEmail) {
    const lower = fallbackEmail.toLowerCase();
    if (lower.includes("alumni")) appRole = "ALUMNI";
    if (lower.includes("etudiant")) appRole = "ETUDIANT";
  }

  return appRole;
};

export const authService = {
  /**
   * Connexion utilisateur
   */
  login: async (email, motDePasse) => {
    console.log("🔐 [AUTH] Tentative de connexion:", { email });

    try {
      const { data } = await authApi.login({ email, motDePasse });

      // Stocker les tokens
      if (data?.accessToken) {
        localStorage.setItem("accessToken", data.accessToken);
        setAuthToken(data.accessToken);
      }
      if (data?.refreshToken) {
        localStorage.setItem("refreshToken", data.refreshToken);
      }

      // Construire user à partir du JWT
      const decoded = decodeJWT(data?.accessToken);
      const roleLibelle = mapJwtRoleToAppRole(decoded, email);

      const user = {
        id: decoded?.uid || decoded?.sub || null,
        email: decoded?.email || decoded?.sub || email,
        nom: decoded?.nom || "",
        prenom: decoded?.prenom || "",
        role: roleLibelle,
        rawRole:
          (Array.isArray(decoded?.roles) && decoded.roles[0]) ||
          decoded?.role ||
          null,
        username: decoded?.preferred_username || decoded?.username || email,
        telephone: decoded?.telephone || decoded?.phone || "",
      };

      localStorage.setItem("user", JSON.stringify(user));

      console.log("✅ [AUTH] Connexion réussie:", {
        email: user.email,
        role: user.role,
        username: user.username,
      });

      return { ...data, user };
    } catch (error) {
      console.error("❌ [AUTH] Connexion échouée:", error);
      throw error;
    }
  },

  /**
   * Inscription
   */
  registerUser: async (userData) => {
    console.log("📝 [AUTH] Tentative d'inscription:", {
      email: userData?.email,
      role: userData?.role,
    });

    try {
      // On attend UtilisateurRequestDTO
      const payload = {
        nom: userData.nom,
        prenom: userData.prenom,
        email: userData.email,
        username: userData.username || userData.email,
        motDePasse: userData.motDePasse,
        telephone: userData.telephone,
        role: userData.role,
      };

      const { data } = await authApi.inscrire(payload);

      console.log("✅ [AUTH] Inscription réussie:", {
        email: payload.email,
        role: payload.role,
      });

      return data;
    } catch (error) {
      console.error("❌ [AUTH] Inscription échouée:", error);
      throw error;
    }
  },

  /**
   * Refresh token
   */
  refreshToken: async (refreshToken) => {
    console.log("🔁 [AUTH] Tentative de refresh token...");

    try {
      const token = refreshToken || localStorage.getItem("refreshToken");
      const { data } = await authApi.refresh({ refreshToken: token });

      if (data?.accessToken) {
        localStorage.setItem("accessToken", data.accessToken);
        setAuthToken(data.accessToken);
      }
      if (data?.refreshToken) {
        localStorage.setItem("refreshToken", data.refreshToken);
      }

      console.log("✅ [AUTH] Refresh token réussi");
      return data;
    } catch (error) {
      console.error("❌ [AUTH] Refresh token échoué:", error);

      // Nettoyer en cas d'échec
      localStorage.removeItem("accessToken");
      localStorage.removeItem("refreshToken");
      localStorage.removeItem("user");
      setAuthToken(null);

      throw error;
    }
  },

  /**
   * Logout
   */
  logout: async (refreshTokenArg) => {
    console.log("🚪 [AUTH] Tentative de déconnexion...");

    const refreshToken = refreshTokenArg || localStorage.getItem("refreshToken");

    try {
      if (refreshToken) {
        await authApi.logout({ refreshToken });
      }

      console.log("✅ [AUTH] Déconnexion réussie (serveur)");
    } catch (error) {
      console.warn("⚠️ [AUTH] Déconnexion serveur échouée (nettoyage local quand même):", error);
    } finally {
      localStorage.removeItem("accessToken");
      localStorage.removeItem("refreshToken");
      localStorage.removeItem("user");
      setAuthToken(null);

      console.log("🧹 [AUTH] Nettoyage localStorage effectué");
    }
  },

  isAuthenticated: () => !!localStorage.getItem("accessToken"),
  getAccessToken: () => localStorage.getItem("accessToken"),
  getRefreshToken: () => localStorage.getItem("refreshToken"),
  getCurrentUser: () => {
    try {
      const userStr = localStorage.getItem("user");
      return userStr ? JSON.parse(userStr) : null;
    } catch {
      return null;
    }
  },
};

export default authService;
