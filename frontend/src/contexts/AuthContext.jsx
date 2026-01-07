// import { createContext, useState, useEffect } from "react";
// import { authService } from "../services/msUser/authService";
// import { tokenManager } from "../utils/tokenManager";
// import { setAuthToken } from "../utils/apiConfig";
// import { handleApiError } from "../utils/errorHandler";

// export const AuthContext = createContext(null);

// export const AuthProvider = ({ children }) => {
//   const [user, setUser] = useState(() => tokenManager.getUser() || null);
//   const [loading, setLoading] = useState(true);
//   const [isAuthenticated, setIsAuthenticated] = useState(
//     !!tokenManager.getAccessToken()
//   );

//   // Initialisation au démarrage
//   useEffect(() => {
//     const initAuth = () => {
//       const token = tokenManager.getAccessToken();
//       const savedUser = tokenManager.getUser();

//       if (token && savedUser) {
//         setAuthToken(token);
//         setUser(savedUser);
//         setIsAuthenticated(true);
//       } else {
//         setAuthToken(null);
//         setUser(null);
//         setIsAuthenticated(false);
//       }

//       setLoading(false);
//     };

//     initAuth();
//   }, []);

//   const login = async (email, motDePasse) => {
//     try {
//       const response = await authService.login(email, motDePasse);

//       // authService a déjà stocké les tokens dans localStorage
//       tokenManager.setAccessToken(response.accessToken);
//       tokenManager.setRefreshToken(response.refreshToken);
//       tokenManager.setUser(response.user);

//       setAuthToken(response.accessToken);
//       setUser(response.user);
//       setIsAuthenticated(true);

//       return {
//         success: true,
//         user: response.user,
//         tokens: {
//           accessToken: response.accessToken,
//           refreshToken: response.refreshToken,
//         },
//       };
//     } catch (error) {
//       const errorInfo = handleApiError(error);
//       throw errorInfo;
//     }
//   };

//   const logout = async () => {
//     try {
//       const refreshToken = tokenManager.getRefreshToken();
//       if (refreshToken) {
//         await authService.logout(refreshToken);
//       }
//     } catch (error) {
//       // on ignore l'erreur serveur de logout, le nettoyage local se fait quand même
//     } finally {
//       tokenManager.clearAll();
//       setAuthToken(null);
//       setUser(null);
//       setIsAuthenticated(false);
//     }
//   };

//   const refreshAccessToken = async () => {
//     try {
//       const refreshToken = tokenManager.getRefreshToken();
//       if (!refreshToken) {
//         throw new Error("No refresh token available");
//       }

//       const response = await authService.refreshToken(refreshToken);

//       tokenManager.setAccessToken(response.accessToken);
//       tokenManager.setRefreshToken(response.refreshToken);
//       setAuthToken(response.accessToken);

//       return response.accessToken;
//     } catch (error) {
//       await logout();
//       throw error;
//     }
//   };

//   const fetchCompleteUserProfile = async () => {
//     if (!user?.email) return user;
//     try {
//       // À implémenter plus tard si tu ajoutes un endpoint de profil
//       return user;
//     } catch (error) {
//       return user;
//     }
//   };

//   const userRole = user?.role || null;

//   const value = {
//     user,
//     loading,
//     isAuthenticated,
//     userRole,
//     isAlumni: userRole === "ALUMNI",
//     isEtudiant: userRole === "ETUDIANT",
//     login,
//     logout,
//     refreshAccessToken,
//     fetchCompleteUserProfile,
//   };

//   return <AuthContext.Provider value={value}>{children}</AuthContext.Provider>;
// };


import { createContext, useState, useEffect } from "react";
import { authService } from "../services/msUser/authService";
import userService from "../services/msUser/userService";
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
  const [profileCompleted, setProfileCompleted] = useState(true);

  // Fonction pour vérifier si le profil est complet
  const checkProfileCompleteness = (userData) => {
    if (!userData) return true;
    
    if (userData.role === 'ALUMNI') {
      return !!(userData.profession && userData.entreprise);
    }
    
    if (userData.role === 'ETUDIANT') {
      return !!(userData.numeroEtudiant && userData.filiere && userData.niveau);
    }
    
    return true;
  };

  useEffect(() => {
    const initAuth = () => {
      const token = tokenManager.getAccessToken();
      const savedUser = tokenManager.getUser();

      if (token && savedUser) {
        setAuthToken(token);
        setUser(savedUser);
        setIsAuthenticated(true);
        
        // Vérifier si le profil est complet
        const isComplete = checkProfileCompleteness(savedUser);
        setProfileCompleted(isComplete);
      } else {
        setAuthToken(null);
        setUser(null);
        setIsAuthenticated(false);
        setProfileCompleted(true);
      }

      setLoading(false);
    };

    initAuth();
  }, []);

  const login = async (email, motDePasse) => {
    try {
      const response = await authService.login(email, motDePasse);

      tokenManager.setAccessToken(response.accessToken);
      tokenManager.setRefreshToken(response.refreshToken);
      tokenManager.setUser(response.user);

      setAuthToken(response.accessToken);
      setUser(response.user);
      setIsAuthenticated(true);
      
      // Vérifier si le profil est complet après login
      const isComplete = checkProfileCompleteness(response.user);
      setProfileCompleted(isComplete);

      return {
        success: true,
        user: response.user,
        tokens: {
          accessToken: response.accessToken,
          refreshToken: response.refreshToken,
        },
        profileCompleted: isComplete,
      };
    } catch (error) {
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
      // ignore
    } finally {
      tokenManager.clearAll();
      setAuthToken(null);
      setUser(null);
      setIsAuthenticated(false);
      setProfileCompleted(true);
    }
  };

  const refreshAccessToken = async () => {
    try {
      const refreshToken = tokenManager.getRefreshToken();
      if (!refreshToken) throw new Error("No refresh token available");

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

  const updateUser = (nextUser) => {
    setUser(nextUser);
    tokenManager.setUser(nextUser);
    
    // Re-vérifier si le profil est complet après mise à jour
    const isComplete = checkProfileCompleteness(nextUser);
    setProfileCompleted(isComplete);
  };

  const reloadUserFromApi = async () => {
    if (!user?.email) return null;
    try {
      const fullUser = await userService.getUserByEmail(user.email);
      const merged = { ...user, ...fullUser };
      updateUser(merged);
      return merged;
    } catch {
      return null;
    }
  };

  // Fonction spécifique pour mettre à jour l'état du profil après complétion
  const markProfileAsCompleted = (profileData) => {
    const updatedUser = { 
      ...user, 
      ...profileData,
      profileCompleted: true 
    };
    updateUser(updatedUser);
  };

  const userRole = user?.role || null;

  const value = {
    user,
    loading,
    isAuthenticated,
    userRole,
    isAlumni: userRole === "ALUMNI",
    isEtudiant: userRole === "ETUDIANT",
    profileCompleted, // Ajouté
    login,
    logout,
    refreshAccessToken,
    updateUser,
    reloadUserFromApi,
    markProfileAsCompleted, // Nouvelle fonction
  };

  return <AuthContext.Provider value={value}>{children}</AuthContext.Provider>;
};
