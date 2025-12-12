import { createContext, useState, useEffect } from 'react';
import { authService } from '../services/msUser/authService';
import { tokenManager } from '../utils/tokenManager';
import { setAuthToken } from '../utils/apiConfig';
import { handleApiError } from '../utils/errorHandler';

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
      const token = tokenManager.getAccessToken();
      const savedUser = tokenManager.getUser();

      if (token && savedUser) {
        setAuthToken(token);
        setUser(savedUser);
        setIsAuthenticated(true);
      } else {
        setAuthToken(null);
        setUser(null);
        setIsAuthenticated(false);
      }

      setLoading(false);
    };

    initAuth();
  }, []);

  const login = async (email, motDePasse) => {
    try {
      console.log('Tentative connexion pour:', email);

      const response = await authService.login(email, motDePasse);

      // authService a déjà stocké les tokens dans localStorage
      tokenManager.setAccessToken(response.accessToken);
      tokenManager.setRefreshToken(response.refreshToken);
      tokenManager.setUser(response.user);

      setAuthToken(response.accessToken);
      setUser(response.user);
      setIsAuthenticated(true);

      return {
        success: true,
        user: response.user,
        tokens: {
          accessToken: response.accessToken,
          refreshToken: response.refreshToken,
        },
      };
    } catch (error) {
      console.error('Erreur login dans AuthContext:', error);
      const errorInfo = handleApiError(error);
      throw errorInfo;
    }
  };

  const logout = async () => {
    try {
      const refreshToken = tokenManager.getRefreshToken();
      if (refreshToken) {
        await authService.logout(refreshToken);
      }
    } catch (error) {
      console.error('Erreur lors de la déconnexion:', error);
    } finally {
      tokenManager.clearAll();
      setAuthToken(null);
      setUser(null);
      setIsAuthenticated(false);
    }
  };

  const refreshAccessToken = async () => {
    try {
      const refreshToken = tokenManager.getRefreshToken();
      if (!refreshToken) {
        throw new Error('No refresh token available');
      }

      const response = await authService.refreshToken(refreshToken);

      tokenManager.setAccessToken(response.accessToken);
      tokenManager.setRefreshToken(response.refreshToken);
      setAuthToken(response.accessToken);

      return response.accessToken;
    } catch (error) {
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
      console.warn('Impossible de récupérer le profil complet:', error);
      return user;
    }
  };

  const userRole = user?.role || null;

  const value = {
    user,
    loading,
    isAuthenticated,
    userRole,
    isAlumni: userRole === 'ALUMNI',
    isEtudiant: userRole === 'ETUDIANT',
    login,
    logout,
    refreshAccessToken,
    fetchCompleteUserProfile,
  };

  return <AuthContext.Provider value={value}>{children}</AuthContext.Provider>;
};
