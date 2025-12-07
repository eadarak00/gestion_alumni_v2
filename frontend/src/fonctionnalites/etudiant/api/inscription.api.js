import axiosInstance from '../../../services/axios';
import config from '../../../config/config';

/**
 * Inscription d'un nouvel étudiant
 */
export const inscrireEtudiant = async (etudiantData) => {
  try {
    console.log('🚀 [API] Appel inscription avec:', etudiantData);
    
    const response = await axiosInstance.post(
      config.endpoints.auth.inscription,
      etudiantData
    );

    console.log('✅ [API] Réponse inscription SUCCESS:', response.data);

    // IMPORTANT: Toujours retourner { success: true }
    return {
      success: true,
      data: response.data,
      message: response.data.message || 'Inscription réussie'
    };
  } catch (error) {
    console.error('❌ [API] Erreur inscription:', {
      status: error.response?.status,
      data: error.response?.data,
      message: error.message
    });
    
    return {
      success: false,
      message: error.response?.data?.message || config.messages?.inscription?.error || 'Erreur lors de l\'inscription',
      errors: error.response?.data?.errors || {}
    };
  }
};

/**
 * Valider le code de validation reçu par email
 */
export const validerCode = async (email, code) => {
  try {
    console.log('🚀 Appel API validation code:', { email, code });

    const response = await axiosInstance.post(
      config.endpoints.validation.valider,
      { email, code }  // données dans le body
    );

    console.log('✅ Réponse API validation:', response.data);

    return {
      success: true,
      data: response.data,
      message: response.data.message || 'Code validé avec succès'
    };
  } catch (error) {
    console.error('❌ Erreur API validation:', error.response?.data || error.message);

    return {
      success: false,
      message: error.response?.data?.message || config.messages.validation.codeInvalide || 'Code invalide ou expiré',
      errors: error.response?.data?.errors || {}
    };
  }
};

export const renvoyerCode = async (email) => {
  try {
    console.log('🚀 Appel API renvoi code:', { email });

    const response = await axiosInstance.post(
      config.endpoints.validation.renvoyer,
      { email } // données dans le body
    );

    console.log('✅ Réponse API renvoi code:', response.data);

    return {
      success: true,
      data: response.data,
      message: response.data.message || 'Nouveau code envoyé'
    };
  } catch (error) {
    console.error('❌ Erreur API renvoi code:', error.response?.data || error.message);

    return {
      success: false,
      message: error.response?.data?.message || 'Impossible de renvoyer le code',
      errors: error.response?.data?.errors || {}
    };
  }
};
