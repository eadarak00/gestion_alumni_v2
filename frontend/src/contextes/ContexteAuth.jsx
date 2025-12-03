import React, { createContext, useContext, useState, useEffect } from 'react';
import axiosInstance from '../services/axios';
import config from '../config/config';

const ContexteAuth = createContext(null);

export const useAuth = () => {
  const context = useContext(ContexteAuth);
  if (!context) {
    throw new Error('useAuth doit être utilisé dans un AuthProvider');
  }
  return context;
};

export const AuthProvider = ({ children }) => {
  const [utilisateur, setUtilisateur] = useState(null);
  const [accessToken, setAccessToken] = useState(null);
  const [refreshToken, setRefreshToken] = useState(null);
  const [authentifie, setAuthentifie] = useState(false);
  const [chargement, setChargement] = useState(true);

  // -------------------------------
  // Au chargement : vérifier le token
  // -------------------------------
  useEffect(() => {
    const access = localStorage.getItem('accessToken');
    const refresh = localStorage.getItem('refreshToken');
    const user = localStorage.getItem('utilisateur');

    if (access && refresh && user) {
      setAccessToken(access);
      setRefreshToken(refresh);
      setUtilisateur(JSON.parse(user));
      setAuthentifie(true);

      // Vérifier si l’access token est valide
      verifierToken(access);
    }

    setChargement(false);
  }, []);

  // -------------------------------
  // Vérification du token (contrat)
  // -------------------------------
  const verifierToken = async (token) => {
    try {
      await axiosInstance.post(config.endpoints.AUTH.VALIDATE_TOKEN, { token });
    } catch (err) {
      // Token expiré → essayer refresh
      await rafraichirToken();
    }
  };

  // -------------------------------
  // Login conforme au contrat
  // -------------------------------
  const connecter = async (donnees) => {
    const { utilisateur, accessToken, refreshToken } = donnees;

    localStorage.setItem('accessToken', accessToken);
    localStorage.setItem('refreshToken', refreshToken);
    localStorage.setItem('utilisateur', JSON.stringify(utilisateur));

    setUtilisateur(utilisateur);
    setAccessToken(accessToken);
    setRefreshToken(refreshToken);
    setAuthentifie(true);
  };

  // -------------------------------
  // Refresh Token
  // -------------------------------
  const rafraichirToken = async () => {
    try {
      const response = await axiosInstance.post(
        config.endpoints.AUTH.REFRESH_TOKEN,
        { refreshToken }
      );

      const newAccess = response.data.accessToken;

      setAccessToken(newAccess);
      localStorage.setItem('accessToken', newAccess);

      return newAccess;
    } catch (err) {
      // Refresh expiré → déconnecter
      deconnecter();
      return null;
    }
  };

  // -------------------------------
  // Déconnexion conforme contrat
  // -------------------------------
  const deconnecter = async () => {
    try {
      await axiosInstance.post(config.endpoints.AUTH.DECONNEXION, {
        refreshToken,
      });
    } catch (err) {
      console.warn("Erreur lors de la déconnexion serveur (ignore) : ", err);
    }

    localStorage.removeItem('accessToken');
    localStorage.removeItem('refreshToken');
    localStorage.removeItem('utilisateur');

    setAccessToken(null);
    setRefreshToken(null);
    setUtilisateur(null);
    setAuthentifie(false);
  };

  // Valeurs exposées
  const valeur = {
    utilisateur,
    accessToken,
    refreshToken,
    authentifie,
    chargement,
    connecter,
    deconnecter,
    rafraichirToken,
  };

  return (
    <ContexteAuth.Provider value={valeur}>
      {children}
    </ContexteAuth.Provider>
  );
};

export default ContexteAuth;
