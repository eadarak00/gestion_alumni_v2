import { UtilisateursApi, AlumnisApi } from "../../api-ms-user/js-client";
import apiClient, { msUserConfiguration } from "../../utils/apiConfig";

const utilisateursApi = new UtilisateursApi(msUserConfiguration, undefined, apiClient);
const alumnisApi = new AlumnisApi(msUserConfiguration, undefined, apiClient);

// Normalise les champs backend -> frontend (surtout ETUDIANT)
const normalizeUserFromApi = (u) => {
  if (!u) return u;

  // Cas ETUDIANT : API renvoie souvent numeroCarteEtudiant
  if (u.role === "ETUDIANT") {
    return {
      ...u,
      // on garantit un alias numeroEtudiant si ton UI l'utilise
      numeroEtudiant: u.numeroEtudiant || u.numeroCarteEtudiant || "",
    };
  }

  return u;
};

export const userService = {
  getAllUsers: async (filters = {}) => {
    const { data } = await utilisateursApi.getAllUtilisateursFiltered(
      filters.actif,
      filters.deleted,
      filters.page,
      filters.size,
      filters.sort
    );
    return data;
  },

  getActiveUsers: async () => {
    const { data } = await utilisateursApi.getAllUtilisateursFiltered(true, false, 0, 10, "nom,asc");
    return data;
  },

  getUserByEmail: async (email) => {
    const { data } = await utilisateursApi.getUtilisateurByEmail(email);
    return normalizeUserFromApi(data);
  },

  checkEmailExists: async (email) => {
    const { data } = await utilisateursApi.emailExists(email);
    return data;
  },

  checkUsernameExists: async (username) => {
    const { data } = await utilisateursApi.usernameExists(username);
    return data;
  },

  searchAlumni: async (filters = {}) => {
    const { data } = await alumnisApi.searchAlumni(
      filters.entreprise,
      filters.profession,
      filters.nom,
      filters.prenom
    );
    return data;
  },

  completeAlumniProfile: async ({ profession, entreprise }) => {
    const payload = { profession, entreprise };
    const { data } = await utilisateursApi.completerProfilAlumni(payload);
    return normalizeUserFromApi(data);
  },

  completeEtudiantProfile: async ({ numeroEtudiant, filiere, niveau }) => {
    const payload = { numeroEtudiant, filiere, niveau };
    const { data } = await utilisateursApi.completerProfilEtudiant(payload);

    // 🔥 Ici le fix important: on normalise la réponse
    return normalizeUserFromApi(data);
  },

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
