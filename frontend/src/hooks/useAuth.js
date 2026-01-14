// import { useContext } from 'react';
// import { AuthContext } from '../contexts/AuthContext';

// export const useAuth = () => {
//   const context = useContext(AuthContext);

//   if (!context) {
//     throw new Error('useAuth must be used within an AuthProvider');
//   }

//   const {
//     user,
//     isAuthenticated,
//     userRole,
//     isAlumni,
//     isEtudiant,
//     profileCompleted,
//     login,
//     logout,
//     loading,
//     updateUser,
//     reloadUserFromApi,
//     markProfileAsCompleted,
//   } = context;

//   return {
//     user,
//     isAuthenticated,
//     userRole,
//     isAlumni,
//     isEtudiant,
//     profileCompleted,
//     login,
//     logout,
//     loading,
//     updateUser,
//     reloadUserFromApi,
//     markProfileAsCompleted,
//   };
// };

import { useContext } from 'react';
import { AuthContext } from '../contexts/AuthContext'; 

export const useAuth = () => {
  const context = useContext(AuthContext);

  if (!context) {
    throw new Error('useAuth must be used within an AuthProvider');
  }

  const {
    user,
    isAuthenticated,
    userRole,
    isAlumni,
    isEtudiant,
    profileCompleted,
    login,
    logout,
    loading,
    updateUser,
    reloadUserFromApi,
    markProfileAsCompleted,
  } = context;

  return {
    user,
    isAuthenticated,
    userRole,
    isAlumni,
    isEtudiant,
    profileCompleted,
    login,
    logout,
    loading,
    updateUser,
    reloadUserFromApi,
    markProfileAsCompleted,
  };
};
