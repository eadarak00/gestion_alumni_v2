import React, { useState } from 'react';
import CarteInformationFigma from '../../../composants/etudiant/CarteInformationFigma';
import FormulaireInscriptionEtudiant from '../../../composants/etudiant/FormulaireInscriptionEtudiant';
import PageValidationCode from '../../../composants/etudiant/PageValidationCode';

const InscriptionEtudiant = () => {
  const [etapeActuelle, setEtapeActuelle] = useState('formulaire'); // 'formulaire' ou 'validation'
  const [emailValidation, setEmailValidation] = useState('');

  // Appelé quand inscription réussie dans le formulaire
  const handleInscriptionSuccess = (data) => {
    console.log('Inscription réussie :', data);

    // Correction SonarQube : utilisation optional chaining
    if (data?.email) {
      setEmailValidation(data.email);
      setEtapeActuelle('validation');
    }
  };

  // Appelé quand validation du code est réussie
  const handleValidationSuccess = () => {
    // Correction SonarQube : remplacer window par globalThis
    setTimeout(() => {
      globalThis.location.href = '/connexion';
    }, 1500);
  };

  // Retour au formulaire d'inscription
  const handleRetourInscription = () => {
    setEtapeActuelle('formulaire');
    setEmailValidation('');
  };

  // Si on est sur la page de validation, afficher seulement celle-ci
  if (etapeActuelle === 'validation') {
    return (
      <PageValidationCode
        email={emailValidation}
        onValidationSuccess={handleValidationSuccess}
        onRetour={handleRetourInscription}
      />
    );
  }

  // Sinon, afficher le formulaire d'inscription avec la carte
  return (
    <div className="min-h-screen bg-gray-50 py-12 px-4 sm:px-6 lg:px-8">
      <div className="max-w-[1400px] mx-auto">
        <div className="flex flex-col lg:flex-row gap-16 items-center lg:items-start justify-center">
          <div className="w-full lg:w-auto flex-shrink-0 order-2 lg:order-1">
            <CarteInformationFigma />
          </div>
          <div className="w-full lg:w-auto lg:max-w-xl order-1 lg:order-2">
            <FormulaireInscriptionEtudiant onSuccess={handleInscriptionSuccess} />
          </div>
        </div>
      </div>
    </div>
  );
};

export default InscriptionEtudiant;
