import { useContext } from 'react';
import { AuthContext } from '../contexts/AuthContext';

export const useAuth = () => {
  const context = useContext(AuthContext);

  if (!context) {
    throw new Error('useAuth must be used within an AuthProvider');
  }

  // S'assurer que le contexte expose toutes ces valeurs clés
  const {
    user,
    isAuthenticated,
    userRole,
    isAlumni,
    isEtudiant,
    login,
    logout,
    loading,
  } = context;

  return {
    user,
    isAuthenticated,
    userRole,
    isAlumni,
    isEtudiant,
    login,
    logout,
    loading,
  };
};
