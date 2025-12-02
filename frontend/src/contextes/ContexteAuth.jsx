import React, { createContext, useContext, useState, useEffect } from 'react';

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
  const [chargement, setChargement] = useState(true);
  const [authentifie, setAuthentifie] = useState(false);

  useEffect(() => {
    const token = localStorage.getItem('token');
    const utilisateurStocke = localStorage.getItem('utilisateur');

    if (token && utilisateurStocke) {
      try {
        setUtilisateur(JSON.parse(utilisateurStocke));
        setAuthentifie(true);
      } catch (error) {
        console.error('Erreur lors de la récupération des données utilisateur', error);
        deconnecter();
      }
    }

    setChargement(false);
  }, []);

  const connecter = (donnees, token) => {
    localStorage.setItem('token', token);
    localStorage.setItem('utilisateur', JSON.stringify(donnees));
    setUtilisateur(donnees);
    setAuthentifie(true);
  };

  const deconnecter = () => {
    localStorage.removeItem('token');
    localStorage.removeItem('utilisateur');
    setUtilisateur(null);
    setAuthentifie(false);
  };

  const valeur = {
    utilisateur,
    authentifie,
    chargement,
    connecter,
    deconnecter
  };

  return (
    <ContexteAuth.Provider value={valeur}>
      {children}
    </ContexteAuth.Provider>
  );
};

export default ContexteAuth;
