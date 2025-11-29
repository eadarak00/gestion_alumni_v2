import React from 'react';
import InscriptionEtudiant from '../fonctionnalites/etudiant/pages/InscriptionEtudiant';
import ConnexionEtudiant from '../fonctionnalites/etudiant/pages/ConnexionEtudiant';
import ConditionsUtilisation from '../fonctionnalites/etudiant/pages/ConditionsUtilisation';

const RoutesApp = () => {
  const pathname = globalThis.location.pathname;

  if (pathname === '/' || pathname === '/inscription') {
    return <InscriptionEtudiant />;
  }
  if (pathname === '/connexion') {
    return <ConnexionEtudiant />;
  }
  if (pathname === '/ConditionsUtilisation') {
    return <ConditionsUtilisation />;
  }
 
  return (
    <div className="min-h-screen bg-gray-50 flex items-center justify-center">
      <div className="text-center">
        <h1 className="text-4xl font-bold text-gray-900 mb-4">404</h1>
        <p className="text-gray-600 mb-4">Page non trouvée</p>
        <a href="/" className="text-emerald-600 hover:underline">
          Retour à l'accueil
        </a>
      </div>
    </div>
  );
};

export default RoutesApp;