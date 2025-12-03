import axiosInstance from '../../../services/axios';
import config from '../../../config/config';

/* =======================
   PARTIE 1 : INSCRIPTION
   ======================= */
export const inscrireEtudiant = async (etudiantData) => {
  try {
    console.log('🚀 [API] Appel inscription avec:', etudiantData);
    
    const response = await axiosInstance.post(
      config.endpoints.INSCRIPTION.ETUDIANT,
    );

    console.log('✅ [API] Réponse inscription SUCCESS:', response.data);

    return {
      success: true,
      data: response.data,
      message: response.data.message || config.messages.inscription.success
    };
  } catch (error) {
    console.error('❌ [API] Erreur inscription:', {
      status: error.response?.status,
      data: error.response?.data,
      message: error.message
    });
    
    return {
      success: false,
      message: error.response?.data?.message || config.messages.inscription.error,
      errors: error.response?.data?.errors || {}
    };
  }
};

/* ================================
   PARTIE 2 : VALIDATION DU CODE
   ================================ */
export const validerCode = async (email, code) => {
  try {
    console.log('🚀 Appel API validation code:', { email, code });

    const response = await axiosInstance.post(
      config.endpoints.VALIDATION.VALIDER, // ← Endpoint validation code
      { email, code }
    );

    console.log('✅ Réponse API validation:', response.data);

    return {
      success: true,
      data: response.data,
      message: response.data.message || config.messages.validation.compteValide
    };
  } catch (error) {
    console.error('❌ Erreur API validation:', error.response?.data || error.message);

    return {
      success: false,
      message: error.response?.data?.message || config.messages.validation.codeInvalide,
      errors: error.response?.data?.errors || {}
    };
  }
};

/* ================================
   PARTIE 3 : RENVOI DU CODE
   ================================ */
export const renvoyerCode = async (email) => {
  try {
    console.log('🚀 Appel API renvoi code:', { email });

    const response = await axiosInstance.post(
      config.endpoints.VALIDATION.RENVOYER, 
      { email }
    );

    console.log('✅ Réponse API renvoi code:', response.data);

    return {
      success: true,
      data: response.data,
      message: response.data.message || config.messages.validation.codeEnvoye
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
