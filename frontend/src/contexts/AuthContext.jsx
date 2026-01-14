// import { createContext, useState, useEffect } from "react";
// import { authService } from "../services/msUser/authService";
// import userService from "../services/msUser/userService";
// import { tokenManager } from "../utils/tokenManager";
// import { setAuthToken } from "../utils/apiConfig";
// import { handleApiError } from "../utils/errorHandler";

// export const AuthContext = createContext(null);

// export const AuthProvider = ({ children }) => {
//   const [user, setUser] = useState(() => tokenManager.getUser() || null);
//   const [loading, setLoading] = useState(true);
//   const [isAuthenticated, setIsAuthenticated] = useState(!!tokenManager.getAccessToken());
//   const [profileCompleted, setProfileCompleted] = useState(true);

//   const checkProfileCompleteness = (userData) => {
//     if (!userData) return true;

//     if (userData.role === "ALUMNI") {
//       return !!(userData.profession && userData.entreprise);
//     }

//     if (userData.role === "ETUDIANT") {
//       // ✅ accepte les deux noms (API renvoie souvent numeroCarteEtudiant)
//       const num = userData.numeroEtudiant || userData.numeroCarteEtudiant;
//       return !!(num && userData.filiere && userData.niveau);
//     }

//     return true;
//   };

//   useEffect(() => {
//     const initAuth = async () => {
//       const token = tokenManager.getAccessToken();
//       const savedUser = tokenManager.getUser();

//       if (token && savedUser) {
//         setAuthToken(token);
//         setUser(savedUser);
//         setIsAuthenticated(true);
//         setProfileCompleted(checkProfileCompleteness(savedUser));
//       } else {
//         setAuthToken(null);
//         setUser(null);
//         setIsAuthenticated(false);
//         setProfileCompleted(true);
//       }

//       setLoading(false);
//     };

//     initAuth();
//   }, []);

//   const login = async (email, motDePasse) => {
//     try {
//       const response = await authService.login(email, motDePasse);

//       tokenManager.setAccessToken(response.accessToken);
//       tokenManager.setRefreshToken(response.refreshToken);
//       tokenManager.setUser(response.user);

//       setAuthToken(response.accessToken);
//       setUser(response.user);
//       setIsAuthenticated(true);

//       const isComplete = checkProfileCompleteness(response.user);
//       setProfileCompleted(isComplete);

//       return {
//         success: true,
//         user: response.user,
//         tokens: {
//           accessToken: response.accessToken,
//           refreshToken: response.refreshToken,
//         },
//         profileCompleted: isComplete,
//       };
//     } catch (error) {
//       throw handleApiError(error);
//     }
//   };

//   const logout = async () => {
//     try {
//       const refreshToken = tokenManager.getRefreshToken();
//       if (refreshToken) await authService.logout(refreshToken);
//     } catch {
//       // ignore
//     } finally {
//       tokenManager.clearAll();
//       setAuthToken(null);
//       setUser(null);
//       setIsAuthenticated(false);
//       setProfileCompleted(true);
//     }
//   };

//   const refreshAccessToken = async () => {
//     try {
//       const refreshToken = tokenManager.getRefreshToken();
//       if (!refreshToken) throw new Error("No refresh token available");

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

//   const updateUser = (nextUser) => {
//     setUser(nextUser);
//     tokenManager.setUser(nextUser);
//     setProfileCompleted(checkProfileCompleteness(nextUser));
//   };

//   const reloadUserFromApi = async () => {
//     if (!user?.email) return null;
//     try {
//       const fullUser = await userService.getUserByEmail(user.email);
//       const merged = { ...user, ...fullUser };
//       updateUser(merged);
//       return merged;
//     } catch {
//       return null;
//     }
//   };

//   const markProfileAsCompleted = async (profileData) => {
//     try {
//       let updatedUser;

//       if (user?.role === "ETUDIANT") {
//         updatedUser = await userService.completeEtudiantProfile(profileData);
//       } else if (user?.role === "ALUMNI") {
//         updatedUser = await userService.completeAlumniProfile(profileData);
//       } else {
//         updatedUser = { ...user, ...profileData };
//       }

//       // ✅ si API renvoie numeroCarteEtudiant, userService normalise déjà numeroEtudiant
//       updateUser(updatedUser);
//       return updatedUser;
//     } catch (error) {
//       throw handleApiError(error);
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
//     profileCompleted,
//     login,
//     logout,
//     refreshAccessToken,
//     updateUser,
//     reloadUserFromApi,
//     markProfileAsCompleted,
//   };

//   return <AuthContext.Provider value={value}>{children}</AuthContext.Provider>;
// };


// Gardez exactement votre version actuelle - elle est correcte

import { createContext, useState, useEffect, useCallback } from "react";
import { authService } from "../services/msUser/authService";
import userService from "../services/msUser/userService";
import { tokenManager } from "../utils/tokenManager";
import { setAuthToken } from "../utils/apiConfig";
import { handleApiError } from "../utils/errorHandler";

export const AuthContext = createContext(null);

export const AuthProvider = ({ children }) => {
  const [user, setUser] = useState(null);
  const [loading, setLoading] = useState(true);
  const [isAuthenticated, setIsAuthenticated] = useState(false);
  const [profileCompleted, setProfileCompleted] = useState(true);

  const checkProfileCompleteness = useCallback((userData) => {
    if (!userData) return true;

    if (userData.role === "ALUMNI") {
      return !!(userData.profession && userData.entreprise);
    }

    if (userData.role === "ETUDIANT") {
      const num = userData.numeroEtudiant || userData.numeroCarteEtudiant;
      return !!(num && userData.filiere && userData.niveau);
    }

    return true;
  }, []);

  // ✅ FIX initAuth - Protection contre utilisateur sans email
  useEffect(() => {
    const initAuth = async () => {
      const token = tokenManager.getAccessToken();

      if (token) {
        setAuthToken(token);
        setIsAuthenticated(true);

        try {
          const savedUser = tokenManager.getUser();
          if (savedUser?.email) { // ✅ PROTECTION
            const freshUser = await userService.getUserByEmail(savedUser.email);
            const normalizedUser = {
              ...freshUser,
              profileCompleted: checkProfileCompleteness(freshUser)
            };
            tokenManager.setUser(normalizedUser);
            setUser(normalizedUser);
            setProfileCompleted(normalizedUser.profileCompleted);
          } else {
            // User localStorage corrompu
            tokenManager.clearAll();
            setUser(null);
            setIsAuthenticated(false);
          }
        } catch (error) {
          console.warn("API sync failed:", error);
          const savedUser = tokenManager.getUser();
          if (savedUser) {
            const withStatus = {
              ...savedUser,
              profileCompleted: checkProfileCompleteness(savedUser)
            };
            tokenManager.setUser(withStatus);
            setUser(withStatus);
            setProfileCompleted(withStatus.profileCompleted);
          }
        }
      } else {
        tokenManager.clearAll();
        setUser(null);
        setIsAuthenticated(false);
        setProfileCompleted(true);
      }

      setLoading(false);
    };

    initAuth();
  }, [checkProfileCompleteness]);

  // ✅ FIX login - AWAIT + Protection complète
  const login = async (email, motDePasse) => {
    try {
      console.log('🔐 Login attempt:', { email }); // DEBUG

      // ✅ AWAIT MANQUANT + Gestion d'erreur
      const response = await authService.login(email, motDePasse);

      if (!response?.accessToken || !response?.user) {
        throw new Error('Réponse API incomplète');
      }

      console.log('✅ Login success:', response.user.email); // DEBUG

      tokenManager.setAccessToken(response.accessToken);
      tokenManager.setRefreshToken(response.refreshToken);

      // ✅ Utilise d'ABORD response.user (frais)
      const normalizedUser = {
        ...response.user,
        profileCompleted: checkProfileCompleteness(response.user)
      };

      tokenManager.setUser(normalizedUser);
      setAuthToken(response.accessToken);
      setUser(normalizedUser);
      setIsAuthenticated(true);
      setProfileCompleted(normalizedUser.profileCompleted);

      return {
        success: true,
        user: normalizedUser,
        tokens: {
          accessToken: response.accessToken,
          refreshToken: response.refreshToken,
        },
        profileCompleted: normalizedUser.profileCompleted,
      };
    } catch (error) {
      console.error('❌ Login error:', error);
      throw handleApiError(error);
    }
  };

  const logout = async () => {
    try {
      const refreshToken = tokenManager.getRefreshToken();
      if (refreshToken) await authService.logout(refreshToken);
    } catch {
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
      if (!refreshToken) throw new Error("No refresh token");

      const response = await authService.refreshToken(refreshToken);
      tokenManager.setAccessToken(response.accessToken);
      tokenManager.setRefreshToken(response.refreshToken);
      setAuthToken(response.accessToken);

      const savedUser = tokenManager.getUser();
      if (savedUser?.email) {
        const freshUser = await userService.getUserByEmail(savedUser.email);
        const normalizedUser = {
          ...freshUser,
          profileCompleted: checkProfileCompleteness(freshUser)
        };
        tokenManager.setUser(normalizedUser);
        setUser(normalizedUser);
        setProfileCompleted(normalizedUser.profileCompleted);
      }

      return response.accessToken;
    } catch (error) {
      await logout();
      throw error;
    }
  };

  const updateUser = useCallback((nextUser) => {
    const normalizedUser = {
      ...nextUser,
      profileCompleted: checkProfileCompleteness(nextUser)
    };
    setUser(normalizedUser);
    tokenManager.setUser(normalizedUser);
    setProfileCompleted(normalizedUser.profileCompleted);
  }, [checkProfileCompleteness]);

  const reloadUserFromApi = useCallback(async () => {
    if (!user?.email) return null;
    try {
      const fullUser = await userService.getUserByEmail(user.email);
      updateUser(fullUser);
      return fullUser;
    } catch {
      return null;
    }
  }, [user?.email, updateUser]);

  const markProfileAsCompleted = async (profileData) => {
    try {
      let updatedUser;

      if (user?.role === "ETUDIANT") {
        updatedUser = await userService.completeEtudiantProfile(profileData);
      } else if (user?.role === "ALUMNI") {
        updatedUser = await userService.completeAlumniProfile(profileData);
      } else {
        updatedUser = { ...user, ...profileData };
      }

      updateUser(updatedUser);
      return updatedUser;
    } catch (error) {
      throw handleApiError(error);
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
    profileCompleted,
    login,
    logout,
    refreshAccessToken,
    updateUser,
    reloadUserFromApi,
    markProfileAsCompleted,
  };

  return <AuthContext.Provider value={value}>{children}</AuthContext.Provider>;
};
