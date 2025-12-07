/**
 * Valide le formulaire d'inscription Alumni
 * @param {Object} formData - Les données du formulaire
 * @returns {Object} - { valide: boolean, erreurs: Object }
 */
export const validerFormulaireInscription = (formData) => {
    const erreurs = {};

    // Validation des champs requis
    const champsRequis = [
        'prenom',
        'nom',
        'email',
        'telephone',
        'profession',
        'entreprise',
        'ville',
        'motDePasse',
        'confirmationMotDePasse'
    ];

    champsRequis.forEach((champ) => {
        if (!formData[champ]) {
            erreurs[champ] = 'Ce champ est obligatoire';
        }
    });

    // Validation Email
    if (formData.email && !/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(formData.email)) {
        erreurs.email = 'Adresse email invalide';
    }

    // Validation Mot de passe
    if (formData.motDePasse) {
        if (formData.motDePasse.length < 8) {
            erreurs.motDePasse = 'Le mot de passe doit contenir au moins 8 caractères';
        }
        // Ajoutez d'autres règles de complexité si nécessaire (Majuscule, Chiffre, etc.)
    }

    // Validation Confirmation Mot de passe
    if (formData.motDePasse !== formData.confirmationMotDePasse) {
        erreurs.confirmationMotDePasse = 'Les mots de passe ne correspondent pas';
    }

    // Validation Conditions
    if (!formData.accepteConditions) {
        erreurs.accepteConditions = 'Vous devez accepter les conditions d\'utilisation';
    }

    // Validation Année Diplôme
    if (formData.anneeDiplome) {
        const annee = parseInt(formData.anneeDiplome, 10);
        const anneeActuelle = new Date().getFullYear();
        if (isNaN(annee) || annee < 1960 || annee > anneeActuelle) {
            erreurs.anneeDiplome = 'Année de diplôme invalide';
        }
    }

    return {
        valide: Object.keys(erreurs).length === 0,
        erreurs
    };
};
