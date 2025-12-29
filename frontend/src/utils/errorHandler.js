export const handleApiError = (error) => {
  if (error.response) {
    const status = error.response.status;
    const data = error.response.body || error.response.text;

    switch (status) {
      case 400:
        return {
          message: data?.message || 'Données invalides. Veuillez vérifier les champs du formulaire.',
          type: 'error'
        };
      case 401:
        return {
          message: 'Session expirée. Veuillez vous reconnecter.',
          type: 'error',
          shouldLogout: true
        };
      case 403:
        return {
          message: 'Accès refusé. Vous n\'avez pas les permissions nécessaires.',
          type: 'error'
        };
      case 404:
        return {
          message: 'Ressource introuvable.',
          type: 'error'
        };
      case 409:
        return {
          message: data?.message || 'Cette ressource existe déjà.',
          type: 'error'
        };
      case 500:
        return {
          message: 'Erreur serveur. Veuillez réessayer plus tard.',
          type: 'error'
        };
      default:
        return {
          message: data?.message || 'Une erreur est survenue. Veuillez réessayer.',
          type: 'error'
        };
    }
  }

  if (error.message) {
    return {
      message: error.message,
      type: 'error'
    };
  }

  return {
    message: 'Erreur réseau. Vérifiez votre connexion internet.',
    type: 'error'
  };
};
