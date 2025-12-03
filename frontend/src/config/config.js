const config = {
  // Configuration API
  api: {
    baseURL: process.env.REACT_APP_API_BASE_URL || 'http://localhost:8081/api',
    timeout: Number.parseInt(process.env.REACT_APP_API_TIMEOUT) || 10000,
    port: Number.parseInt(process.env.REACT_APP_API_PORT) || 8081,
  },

  // Endpoints centralisés
  endpoints: {
    AUTH: {
      CONNEXION: '/v1/auth/connexion',
      REFRESH_TOKEN: '/v1/auth/refresh-token',
      DECONNEXION: '/v1/auth/deconnexion',
      VALIDATE_TOKEN: '/v1/auth/validate-token',
    },

    INSCRIPTION: {
      ETUDIANT: '/v1/auth/inscription-etudiant',
      ALUMNI: '/v1/auth/inscription-alumni',
    },

    VALIDATION: {
      VALIDER: '/v1/validation/verifier',
      RENVOYER: '/v1/validation/envoyer',
    },

    ALUMNI: {
      SUGGESTIONS: '/v1/alumni/search/suggestions',
      SEARCH: '/v1/alumni/search',
      ADVANCED_SEARCH: '/v1/alumni/search/advanced',
      INDEX: '/v1/alumni/index',
      INDEX_STATUS: '/v1/alumni/index/status',
    },

    UTILISATEURS: {
      ALL: '/v1/utilisateurs',
      ACTIFS: '/v1/utilisateurs/actifs',
    },

    ROLES: {
      ALL: '/v1/roles',
      BY_ID: (id) => `/v1/roles/${id}`,
      UPDATE: (id) => `/v1/roles/${id}`,
    },
  },

  // Messages de retour pour l'UI
  messages: {
    validation: {
      codeExpire: 'Code expiré. Veuillez en demander un nouveau.',
      codeInvalide: 'Code invalide. Veuillez réessayer.',
      codeEnvoye: 'Un nouveau code a été envoyé à votre adresse email.',
      compteValide: 'Votre compte a été validé avec succès !',
    },
    inscription: {
      success: 'Inscription réussie ! Vérifiez votre email pour valider votre compte.',
      error: "Une erreur est survenue lors de l'inscription.",
    },
    auth: {
      invalidCredentials: 'Email ou mot de passe incorrect.',
      accountInactive: 'Votre compte a été désactivé.',
      accountDeleted: "Ce compte n'existe plus.",
      refreshExpired: 'Votre session a expiré. Veuillez vous reconnecter.',
    },
  },

  validation: {
    codeDuree: 10,
    codeLength: 6,
  },

  app: {
    env: process.env.REACT_APP_ENV || 'development',
    frontendURL: process.env.REACT_APP_FRONTEND_URL || 'http://localhost:3000',
    isDevelopment: process.env.REACT_APP_ENV === 'development',
    isProduction: process.env.REACT_APP_ENV === 'production',
  },
};

if (config.app.isDevelopment) {
  console.log('Configuration de l’application chargée :', config);

  if (!config.api.baseURL) {
    console.warn("⚠️ REACT_APP_API_BASE_URL n'est pas défini !");
  }
}

export default config;
