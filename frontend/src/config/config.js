const config = {
  // Configuration de l'API
  api: {
    baseURL: process.env.REACT_APP_API_BASE_URL || 'http://localhost:8088/api',
    timeout: Number.parseInt(process.env.REACT_APP_API_TIMEOUT) || 10000,
    port: Number.parseInt(process.env.REACT_APP_API_PORT) || 8088,
  },

  // Configuration de l'application
  app: {
    env: process.env.REACT_APP_ENV || 'development',
    frontendURL: process.env.REACT_APP_FRONTEND_URL || 'http://localhost:3000',
    isDevelopment: process.env.REACT_APP_ENV === 'development',
    isProduction: process.env.REACT_APP_ENV === 'production',
  },

  // Endpoints de l'API
  endpoints: {
    auth: {
      inscription: '/v1/auth/inscription-etudiant',
      connexion: '/v1/auth/connexion',
    },
    validation: {
      valider: '/v1/validation/verifier',
      renvoyer: '/v1/validation/envoyer',
    },
    utilisateurs: {
      all: '/v1/utilisateurs',
      actifs: '/v1/utilisateurs/actifs',
    },
    roles: {
      all: '/v1/roles',
      byId: (id) => `/v1/roles/${id}`,
    },
  },

  // Configuration des messages
  messages: {
    validation: {
      codeExpire: 'Code expiré. Veuillez en demander un nouveau.',
      codeInvalide: 'Code invalide. Veuillez réessayer.',
      codeEnvoye: 'Un nouveau code a été envoyé à votre adresse email.',
      compteValide: 'Votre compte a été validé avec succès !',
    },
    inscription: {
      success: 'Inscription réussie ! Vérifiez votre email pour valider votre compte.',
      error: 'Une erreur est survenue lors de l\'inscription.',
    },
  },

  // Configuration de la validation
  validation: {
    codeDuree: 10, // Durée de validité du code en minutes
    codeLength: 6, // Longueur du code
  },
};

// Validation de la configuration en développement
if (config.app.isDevelopment) {
  console.log('Configuration de l\'application:', config);

  // Vérifier que les variables essentielles sont définies
  if (!config.api.baseURL) {
    console.warn('REACT_APP_API_BASE_URL n\'est pas défini !');
  }
}

export default config;
