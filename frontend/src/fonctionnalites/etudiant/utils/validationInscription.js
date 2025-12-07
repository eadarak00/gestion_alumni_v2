/**
 * Validation de l'email
 */
export const validerEmail = (email) => {
  const regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  return regex.test(email);
};

/**
 * Validation du téléphone sénégalais
 */
export const validerTelephone = (telephone) => {
  const regex = /^(\+221|00221)?[7][05678]\d{7}$/;
  return regex.test(telephone);
};

/**
 * Validation du mot de passe (minimum 8 caractères)
 */
export const validerMotDePasse = (motDePasse) => {
  return motDePasse && motDePasse.length >= 8;
};

/**
 * Génère un username automatiquement à partir du nom et prénom
 */
export const genererUsername = (nom, prenom) => {
  const nomClean = nom.trim().toLowerCase().replace(/\s+/g, '');
  const prenomClean = prenom.trim().toLowerCase().replace(/\s+/g, '');
  const randomNum = Math.floor(Math.random() * 1000);
  return `${prenomClean}.${nomClean}${randomNum}`;
};

/**
 * Validation complète du formulaire d'inscription
 */
export const validerFormulaireInscription = (formData) => {
  const erreurs = {};

  // Validation du nom
  if (!formData.nom || formData.nom.trim() === '') {
    erreurs.nom = 'Le nom est requis';
  }

  // Validation du prénom
  if (!formData.prenom || formData.prenom.trim() === '') {
    erreurs.prenom = 'Le prénom est requis';
  }

  // Validation de l'email
  if (!formData.email || !validerEmail(formData.email)) {
    erreurs.email = 'Email invalide';
  }

  // Username sera généré automatiquement si absent
  // Pas besoin de le valider ici

  // Validation du mot de passe
  if (!formData.motDePasse || !validerMotDePasse(formData.motDePasse)) {
    erreurs.motDePasse = 'Le mot de passe doit contenir au moins 8 caractères';
  }

  // Validation de la confirmation du mot de passe
  if (formData.motDePasse !== formData.confirmationMotDePasse) {
    erreurs.confirmationMotDePasse = 'Les mots de passe ne correspondent pas';
  }

  // Validation du téléphone
  if (!formData.telephone || !validerTelephone(formData.telephone)) {
    erreurs.telephone = 'Numéro de téléphone invalide (ex: +221771234567)';
  }

  // Validation du numéro de carte étudiant
  if (!formData.numeroCarteEtudiant || formData.numeroCarteEtudiant.trim() === '') {
    erreurs.numeroCarteEtudiant = 'Le numéro de carte étudiant est requis';
  }

  // Validation de la filière
  if (!formData.filiere || formData.filiere.trim() === '') {
    erreurs.filiere = 'La filière est requise';
  }

  // Validation du niveau
  if (!formData.niveau || formData.niveau.trim() === '') {
    erreurs.niveau = 'Le niveau est requis';
  }

  // Validation des conditions d'utilisation
  if (!formData.accepteConditions) {
    erreurs.accepteConditions = "Vous devez accepter les conditions d'utilisation";
  }

  return {
    valide: Object.keys(erreurs).length === 0,
    erreurs
  };
};