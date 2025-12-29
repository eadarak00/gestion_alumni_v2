import { ValidationApi } from "../../api-ms-user/js-client";
import apiClient, { msUserConfiguration } from "../../utils/apiConfig";

const validationApi = new ValidationApi(msUserConfiguration, undefined, apiClient);

export const validationService = {
  sendValidationCode: async (email) => {
    try {
      await validationApi.envoyerCode({ email });
      return true;
    } catch (error) {
      throw error;
    }
  },

  verifyValidationCode: async (email, code) => {
    try {
      // l'API retourne un string : axios le récupère dans data
      const { data } = await validationApi.verifierCode(
        { email, code },
        { headers: { Accept: "text/plain, */*" } }
      );
      return data;
    } catch (error) {
      throw error;
    }
  },
};

export default validationService;
