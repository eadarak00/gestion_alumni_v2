import { UtilisateursApi } from "../../api-ms-user/js-client";
import apiClient, { msUserConfiguration } from "../../utils/apiConfig";

const userApi = new UtilisateursApi(msUserConfiguration, undefined, apiClient);

export const userService = {
  /**
   * GET /utilisateurs?actif&deleted&page&size&sort
   */
  getAllUsers: async (filters = {}) => {
    console.log("👥 [USER] Récupération utilisateurs (filtrés):", {
      actif: filters.actif,
      deleted: filters.deleted,
      page: filters.page,
      size: filters.size,
      sort: filters.sort,
    });

    try {
      const { data } = await userApi.getAllUtilisateursFiltered(
        filters.actif,
        filters.deleted,
        filters.page,
        filters.size,
        filters.sort
      );

      console.log("✅ [USER] Utilisateurs récupérés (filtrés):", {
        totalElements: data?.totalElements,
        totalPages: data?.totalPages,
        size: data?.size,
        number: data?.number,
        count: data?.content?.length,
      });

      return data;
    } catch (error) {
      console.error("❌ [USER] Erreur récupération utilisateurs (filtrés):", error);
      throw error;
    }
  },

  getActiveUsers: async () => {
    console.log("👥 [USER] Récupération utilisateurs actifs...");

    try {
      const { data } = await userApi.getAllUtilisateursFiltered(true, false, 0, 10, "nom,asc");

      console.log("✅ [USER] Utilisateurs actifs récupérés:", {
        totalElements: data?.totalElements,
        count: data?.content?.length,
      });

      return data;
    } catch (error) {
      console.error("❌ [USER] Erreur récupération utilisateurs actifs:", error);
      throw error;
    }
  },

  getUserByEmail: async (email) => {
    console.log("🔎 [USER] Recherche utilisateur par email:", { email });

    try {
      const { data } = await userApi.getUtilisateurByEmail(email);

      console.log("✅ [USER] Utilisateur trouvé:", {
        email: data?.email,
        id: data?.id,
        role: data?.role,
        username: data?.username,
      });

      return data;
    } catch (error) {
      console.error(`❌ [USER] Utilisateur non trouvé pour ${email}:`, error);
      throw error;
    }
  },

  checkEmailExists: async (email) => {
    console.log("📩 [USER] Vérification existence email:", { email });

    try {
      const { data } = await userApi.emailExists(email);

      console.log("✅ [USER] Résultat vérification email:", { email, exists: data });
      return data;
    } catch (error) {
      console.error(`❌ [USER] Erreur vérification email ${email}:`, error);
      throw error;
    }
  },

  checkUsernameExists: async (username) => {
    console.log("🆔 [USER] Vérification existence username:", { username });

    try {
      const { data } = await userApi.usernameExists(username);

      console.log("✅ [USER] Résultat vérification username:", { username, exists: data });
      return data;
    } catch (error) {
      console.error(`❌ [USER] Erreur vérification username ${username}:`, error);
      throw error;
    }
  },

  searchAlumni: async (filters = {}) => {
    console.log("🎓 [USER] Recherche alumni:", {
      entreprise: filters.entreprise,
      profession: filters.profession,
      nom: filters.nom,
      prenom: filters.prenom,
    });

    try {
      const { data } = await userApi.searchAlumni(
        filters.entreprise,
        filters.profession,
        filters.nom,
        filters.prenom
      );

      console.log("✅ [USER] Résultat recherche alumni:", {
        count: Array.isArray(data) ? data.length : 0,
      });

      return data;
    } catch (error) {
      console.error("❌ [USER] Erreur recherche alumni:", error);
      throw error;
    }
  },

  // Endpoints NON présents
  getUserById: async () => {
    console.warn("⚠️ [USER] getUserById appelé mais non disponible dans le contrat OpenAPI.");
    throw new Error("Endpoint getUtilisateurById non défini dans le contrat OpenAPI.");
  },
  updateUser: async () => {
    console.warn("⚠️ [USER] updateUser appelé mais non disponible dans le contrat OpenAPI.");
    throw new Error("Endpoint updateUtilisateur non défini dans le contrat OpenAPI.");
  },
  deleteUser: async () => {
    console.warn("⚠️ [USER] deleteUser appelé mais non disponible dans le contrat OpenAPI.");
    throw new Error("Endpoint deleteUtilisateur non défini dans le contrat OpenAPI.");
  },
};

export default userService;
