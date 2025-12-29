import { UtilisateursApi } from "../../api-ms-user/js-client";
import apiClient, { msUserConfiguration } from "../../utils/apiConfig";

const userApi = new UtilisateursApi(msUserConfiguration, undefined, apiClient);

export const userService = {
  /**
   * GET /utilisateurs?actif&deleted&page&size&sort
   */
  getAllUsers: async (filters = {}) => {
    try {
      const { data } = await userApi.getAllUtilisateursFiltered(
        filters.actif,
        filters.deleted,
        filters.page,
        filters.size,
        filters.sort
      );
      return data;
    } catch (error) {
      console.error("❌ Erreur récupération utilisateurs:", error);
      throw error;
    }
  },

  getActiveUsers: async () => {
    try {
      const { data } = await userApi.getAllUtilisateursFiltered(true, false, 0, 10, "nom,asc");
      return data;
    } catch (error) {
      console.error("❌ Erreur récupération utilisateurs actifs:", error);
      throw error;
    }
  },

  getUserByEmail: async (email) => {
    try {
      const { data } = await userApi.getUtilisateurByEmail(email);
      return data;
    } catch (error) {
      console.error(`❌ Utilisateur non trouvé pour ${email}:`, error);
      throw error;
    }
  },

  checkEmailExists: async (email) => {
    try {
      const { data } = await userApi.emailExists(email);
      return data;
    } catch (error) {
      console.error(`❌ Erreur vérification email ${email}:`, error);
      throw error;
    }
  },

  checkUsernameExists: async (username) => {
    try {
      const { data } = await userApi.usernameExists(username);
      return data;
    } catch (error) {
      console.error(`❌ Erreur vérification username ${username}:`, error);
      throw error;
    }
  },

  searchAlumni: async (filters = {}) => {
    try {
      const { data } = await userApi.searchAlumni(
        filters.entreprise,
        filters.profession,
        filters.nom,
        filters.prenom
      );
      return data;
    } catch (error) {
      console.error("❌ Erreur recherche alumni:", error);
      throw error;
    }
  },

  // Endpoints NON présents
  getUserById: async () => {
    throw new Error("Endpoint getUtilisateurById non défini dans le contrat OpenAPI.");
  },
  updateUser: async () => {
    throw new Error("Endpoint updateUtilisateur non défini dans le contrat OpenAPI.");
  },
  deleteUser: async () => {
    throw new Error("Endpoint deleteUtilisateur non défini dans le contrat OpenAPI.");
  },
};

export default userService;
