import React from 'react';
import logoUasz from "../../assets/logos/uasz.jpg";
import { Check, Fingerprint } from 'lucide-react';

const avantages = [
  "CV d'Exception - Créez un profil qui impressionne",
  "Réseau d'Influence - Connectez avec des alumni inspirants",
  "Mentorat Privilégié - Bénéficiez de conseils experts",
  "Opportunités VIP - Accédez à des offres et formations exclusives"
];

const CarteInformationFigma = () => (
  <div className="bg-white rounded-3xl shadow-lg overflow-hidden w-full max-w-lg border border-neutral-100">
    {/* Logo UASZ centré */}
    <div className="flex flex-col items-center pt-8 pb-0">
      <img
        src={logoUasz}
        alt="Logo UASZ"
        className="h-30 w-30 object-contain mb-3"
      />
      <div className="w-full h-8 bg-emerald-600 rounded-b-2xl mb-10" />
    </div>
    
    <div className="flex flex-col items-center px-10 pb-10">
      <div className="w-36 h-36 mb-8 relative flex items-center justify-center">
        <div className="absolute inset-0 rounded-2xl border-4 border-emerald-100 bg-emerald-50 flex items-center justify-center" />
        <Fingerprint size={80} className="text-emerald-600 z-10" strokeWidth={1.5} />
        <div className="absolute -top-2 -right-3 w-6 h-6 bg-emerald-600 rounded-full border-4 border-white"></div>
        <div className="absolute -bottom-3 -left-3 w-6 h-6 bg-emerald-600 rounded-full opacity-50"></div>
      </div>
      
      <h3 className="text-2xl font-bold text-gray-900 text-center mb-3">
        Propulsez Votre Carrière avec Notre Communauté Alumni
      </h3>
      
      <div className="w-full space-y-4 mt-8">
        {/* CORRECTION : Utilisation de la chaîne de caractères 'avantage' comme clé */}
        {avantages.map((avantage) => ( 
          <div key={avantage} className="flex items-start gap-4">
            <div className="flex-shrink-0 w-6 h-6 rounded-full bg-emerald-600 flex items-center justify-center mt-0.5">
              <Check size={16} className="text-white" strokeWidth={3} />
            </div>
            <p className="text-base text-gray-700 flex-1 leading-relaxed">{avantage}</p>
          </div>
        ))}
      </div>
    </div>
  </div>
);

export default CarteInformationFigma;