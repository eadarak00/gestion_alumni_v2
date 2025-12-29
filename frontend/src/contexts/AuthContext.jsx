import { createContext, useState, useEffect } from "react";
import { authService } from "../services/msUser/authService";
import { tokenManager } from "../utils/tokenManager";
import { setAuthToken } from "../utils/apiConfig";
import { handleApiError } from "../utils/errorHandler";

export const AuthContext = createContext(null);

export const AuthProvider = ({ children }) => {
  const [user, setUser] = useState(() => tokenManager.getUser() || null);
  const [loading, setLoading] = useState(true);
  const [isAuthenticated, setIsAuthenticated] = useState(
    !!tokenManager.getAccessToken()
  );

  // Initialisation au démarrage
  useEffect(() => {
    const initAuth = () => {
      console.log("🔄 [AUTH] Initialisation du contexte Auth...");

      const token = tokenManager.getAccessToken();
      const savedUser = tokenManager.getUser();

      if (token && savedUser) {
        setAuthToken(token);
        setUser(savedUser);
        setIsAuthenticated(true);

        console.log("✅ [AUTH] Session restaurée depuis localStorage.", {
          email: savedUser?.email,
          role: savedUser?.role,
        });
      } else {
        setAuthToken(null);
        setUser(null);
        setIsAuthenticated(false);

        console.log("ℹ️ [AUTH] Aucune session existante (utilisateur non connecté).");
      }

      setLoading(false);
      console.log("✅ [AUTH] Initialisation terminée.");
    };

    initAuth();
  }, []);

  const login = async (email, motDePasse) => {
    try {
      console.log("🔐 [AUTH] Tentative de connexion...", { email });

      const response = await authService.login(email, motDePasse);

      // authService a déjà stocké les tokens dans localStorage
      tokenManager.setAccessToken(response.accessToken);
      tokenManager.setRefreshToken(response.refreshToken);
      tokenManager.setUser(response.user);

      setAuthToken(response.accessToken);
      setUser(response.user);
      setIsAuthenticated(true);

      console.log("✅ [AUTH] Connexion réussie !", {
        email: response.user?.email,
        role: response.user?.role,
      });

      return {
        success: true,
        user: response.user,
        tokens: {
          accessToken: response.accessToken,
          refreshToken: response.refreshToken,
        },
      };
    } catch (error) {
      console.error("❌ [AUTH] Connexion échouée.", { email, error });
      const errorInfo = handleApiError(error);
      throw errorInfo;
    }
  };

  const logout = async () => {
    console.log("🚪 [AUTH] Déconnexion demandée...");

    try {
      const refreshToken = tokenManager.getRefreshToken();
      if (refreshToken) {
        await authService.logout(refreshToken);
      }
      console.log("✅ [AUTH] Déconnexion côté serveur OK (ou ignorée si erreur).");
    } catch (error) {
      console.error("⚠️ [AUTH] Erreur lors de la déconnexion serveur:", error);
    } finally {
      tokenManager.clearAll();
      setAuthToken(null);
      setUser(null);
      setIsAuthenticated(false);

      console.log("🧹 [AUTH] Session nettoyée (localStorage + état React).");
    }
  };

  const refreshAccessToken = async () => {
    console.log("🔁 [AUTH] Tentative de refresh accessToken...");

    try {
      const refreshToken = tokenManager.getRefreshToken();
      if (!refreshToken) {
        throw new Error("No refresh token available");
      }

      const response = await authService.refreshToken(refreshToken);

      tokenManager.setAccessToken(response.accessToken);
      tokenManager.setRefreshToken(response.refreshToken);
      setAuthToken(response.accessToken);

      console.log("✅ [AUTH] Refresh token OK.");
      return response.accessToken;
    } catch (error) {
      console.error("❌ [AUTH] Refresh token échoué → logout.", error);
      await logout();
      throw error;
    }
  };

  const fetchCompleteUserProfile = async () => {
    if (!user?.email) return user;
    try {
      // À implémenter plus tard si tu ajoutes un endpoint de profil
      return user;
    } catch (error) {
      console.warn("⚠️ [AUTH] Impossible de récupérer le profil complet:", error);
      return user;
    }
  };

  const userRole = user?.role || null;

  const value = {
    user,
    loading,
    isAuthenticated,
    userRole,
    isAlumni: userRole === "ALUMNI",
    isEtudiant: userRole === "ETUDIANT",
    login,
    logout,
    refreshAccessToken,
    fetchCompleteUserProfile,
  };

  return <AuthContext.Provider value={value}>{children}</AuthContext.Provider>;
};
