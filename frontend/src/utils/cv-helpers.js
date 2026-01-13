// frontend/src/utils/cv-helpers.js

// Fonction pour formater les dates
export const formatDate = (dateString) => {
  if (!dateString) return 'Présent';
  
  try {
    const date = new Date(dateString);
    return date.toLocaleDateString('fr-FR', {
      month: 'long',
      year: 'numeric'
    });
  } catch (error) {
    return dateString;
  }
};

// Fonction pour télécharger un fichier blob
export const downloadFile = (blob, fileName) => {
  const url = window.URL.createObjectURL(blob);
  const link = document.createElement('a');
  link.href = url;
  link.download = fileName;
  document.body.appendChild(link);
  link.click();
  document.body.removeChild(link);
  window.URL.revokeObjectURL(url);
};

// Validation basique des données CV
export const validateCVData = (cvData) => {
  const errors = [];

  if (!cvData.nom?.trim()) {
    errors.push('Le nom est requis');
  }

  if (!cvData.prenom?.trim()) {
    errors.push('Le prénom est requis');
  }

  if (!cvData.email?.trim()) {
    errors.push('L\'email est requis');
  } else if (!/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(cvData.email)) {
    errors.push('Format d\'email invalide');
  }

  if (!cvData.titreProfil?.trim()) {
    errors.push('Le titre du profil est requis');
  }

  return errors;
};

// Créer une structure CV vide
export const createEmptyCV = (userId) => {
  return {
    templateId: 1,
    titreProfil: '',
    nom: '',
    prenom: '',
    email: '',
    telephone: '',
    adresse: '',
    resumeProfil: '',
    formations: [
      {
        diplome: '',
        etablissement: '',
        ville: '',
        anneeDebut: '',
        anneeFin: ''
      }
    ],
    experiences: [
      {
        poste: '',
        entreprise: '',
        ville: '',
        dateDebut: '',
        dateFin: '',
        description: ''
      }
    ],
    competences: [{ nom: '', niveau: 'INTERMEDIAIRE' }],
    langues: [{ nom: 'FRANCAIS', niveau: 'DEBUTANT' }],
    interets: [{ libelle: '' }]
  };
};