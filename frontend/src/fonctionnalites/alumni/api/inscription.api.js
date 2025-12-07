import axiosInstance from '../../../services/axios';
import config from '../../../config/config';

/**
 * Inscrire un nouvel alumni
 */
export const inscrireAlumni = async (alumniData) => {
    try {
        console.log('🚀 Appel API inscription alumni:', alumniData);

        const response = await axiosInstance.post(
            config.endpoints.alumni.inscription,
            alumniData
        );

        console.log('✅ Réponse API inscription:', response.data);

        return {
            success: true,
            data: response.data,
            message: response.data.message || 'Inscription réussie'
        };
    } catch (error) {
        console.error('❌ Erreur API inscription:', error.response?.data || error.message);

        return {
            success: false,
            message: error.response?.data?.message || 'Erreur lors de l\'inscription',
            errors: error.response?.data?.errors || {}
        };
    }
};

/**
 * Valider le code de validation reçu par email
 * (Réutilisation de l'endpoint générique)
 */
export const validerCode = async (email, code) => {
    try {
        console.log('🚀 Appel API validation code:', { email, code });

        const response = await axiosInstance.post(
            config.endpoints.validation.valider,
            { email, code }
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
            message: error.response?.data?.message || 'Code invalide ou expiré',
            errors: error.response?.data?.errors || {}
        };
    }
};

/**
 * Renvoyer un nouveau code de validation
 */
export const renvoyerCode = async (email) => {
    try {
        console.log('🚀 Appel API renvoi code:', { email });

        const response = await axiosInstance.post(
            config.endpoints.validation.renvoyer,
            { email }
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

/**
 * Demander la réinitialisation du mot de passe (MOCK)
 */
export const demanderReinitialisationMotDePasse = async (email) => {
    console.log('⚠️ [MOCK] Demande réinitialisation MDP pour:', email);
    await new Promise(resolve => setTimeout(resolve, 1500)); // Simulation latence

    return {
        success: true,
        message: "Si un compte existe avec cet email, vous recevrez un lien de réinitialisation."
    };
};

export default {
    inscrireAlumni,
    validerCode,
    renvoyerCode,
    demanderReinitialisationMotDePasse
};