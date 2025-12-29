import { ValidationApi } from "../../api-ms-user/js-client";
import apiClient, { msUserConfiguration } from "../../utils/apiConfig";

const validationApi = new ValidationApi(msUserConfiguration, undefined, apiClient);

export const validationService = {
  sendValidationCode: async (email) => {
    console.log("📩 [VALIDATION] Envoi du code de validation...", { email });

    try {
      await validationApi.envoyerCode({ email });

      console.log("✅ [VALIDATION] Code de validation envoyé avec succès.", { email });
      return true;
    } catch (error) {
      console.error("❌ [VALIDATION] Échec envoi code de validation.", { email, error });
      throw error;
    }
  },

  verifyValidationCode: async (email, code) => {
    console.log("🔐 [VALIDATION] Vérification du code...", { email, code });

    try {
      // l'API retourne un string : axios le récupère dans data
      const { data } = await validationApi.verifierCode(
        { email, code },
        { headers: { Accept: "text/plain, */*" } }
      );

      console.log("✅ [VALIDATION] Code vérifié avec succès.", { email, response: data });
      return data;
    } catch (error) {
      console.error("❌ [VALIDATION] Code invalide / erreur vérification.", { email, error });
      throw error;
    }
  },
};

export default validationService;
