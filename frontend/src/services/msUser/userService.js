// import { UtilisateursApi } from "../../api-ms-user/js-client";
// import apiClient, { msUserConfiguration } from "../../utils/apiConfig";

// const userApi = new UtilisateursApi(msUserConfiguration, undefined, apiClient);

// export const userService = {
//   /**
//    * GET /utilisateurs?actif&deleted&page&size&sort
//    */
//   getAllUsers: async (filters = {}) => {
//     try {
//       const { data } = await userApi.getAllUtilisateursFiltered(
//         filters.actif,
//         filters.deleted,
//         filters.page,
//         filters.size,
//         filters.sort
//       );

//       return data;
//     } catch (error) {
//       throw error;
//     }
//   },

//   getActiveUsers: async () => {
//     try {
//       const { data } = await userApi.getAllUtilisateursFiltered(
//         true,
//         false,
//         0,
//         10,
//         "nom,asc"
//       );

//       return data;
//     } catch (error) {
//       throw error;
//     }
//   },

//   getUserByEmail: async (email) => {
//     try {
//       const { data } = await userApi.getUtilisateurByEmail(email);
//       return data;
//     } catch (error) {
//       throw error;
//     }
//   },

//   checkEmailExists: async (email) => {
//     try {
//       const { data } = await userApi.emailExists(email);
//       return data;
//     } catch (error) {
//       throw error;
//     }
//   },

//   checkUsernameExists: async (username) => {
//     try {
//       const { data } = await userApi.usernameExists(username);
//       return data;
//     } catch (error) {
//       throw error;
//     }
//   },

//   searchAlumni: async (filters = {}) => {
//     try {
//       const { data } = await userApi.searchAlumni(
//         filters.entreprise,
//         filters.profession,
//         filters.nom,
//         filters.prenom
//       );

//       return data;
//     } catch (error) {
//       throw error;
//     }
//   },

//   // Endpoints NON présents
//   getUserById: async () => {
//     throw new Error("Endpoint getUtilisateurById non défini dans le contrat OpenAPI.");
//   },
//   updateUser: async () => {
//     throw new Error("Endpoint updateUtilisateur non défini dans le contrat OpenAPI.");
//   },
//   deleteUser: async () => {
//     throw new Error("Endpoint deleteUtilisateur non défini dans le contrat OpenAPI.");
//   },
// };

// export default userService;

import { UtilisateursApi, AlumnisApi } from "../../api-ms-user/js-client";
import apiClient, { msUserConfiguration } from "../../utils/apiConfig";

// Instances correctes basées sur le client généré
const utilisateursApi = new UtilisateursApi(msUserConfiguration, undefined, apiClient);
const alumnisApi = new AlumnisApi(msUserConfiguration, undefined, apiClient);

/**
 * Fusionne partiellement l'objet user stocké en localStorage.
 */
const updateStoredUser = (partial) => {
  try {
    const current = localStorage.getItem("user");
    const parsed = current ? JSON.parse(current) : null;

    const merged = { ...(parsed || {}), ...(partial || {}) };
    localStorage.setItem("user", JSON.stringify(merged));

    return merged;
  } catch (e) {
    console.error("updateStoredUser error:", e);
    return null;
  }
};

export const userService = {
  /**
   * GET /utilisateurs?actif&deleted&page&size&sort
   */
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
    const { data } = await utilisateursApi.getAllUtilisateursFiltered(
      true,
      false,
      0,
      10,
      "nom,asc"
    );
    return data;
  },

  getUserByEmail: async (email) => {
    const { data } = await utilisateursApi.getUtilisateurByEmail(email);
    return data;
  },

  checkEmailExists: async (email) => {
    const { data } = await utilisateursApi.emailExists(email);
    return data;
  },

  checkUsernameExists: async (username) => {
    const { data } = await utilisateursApi.usernameExists(username);
    return data;
  },

  /**
   * GET /alumni/search?entreprise&profession&nom&prenom
   * (Dans le client généré, c'est dans AlumnisApi, pas UtilisateursApi)
   */
  searchAlumni: async (filters = {}) => {
    const { data } = await alumnisApi.searchAlumni(
      filters.entreprise,
      filters.profession,
      filters.nom,
      filters.prenom
    );
    return data;
  },

  /**
   * ✅ Compléter profil Alumni
   * PUT /utilisateurs/completer-profil/alumni
   * body: { profession?: string, entreprise?: string }
   */
  completeAlumniProfile: async ({ profession, entreprise }) => {
    const payload = { profession, entreprise };
    const { data } = await utilisateursApi.completerProfilAlumni(payload);

    // data = AlumniResponseDTO
    updateStoredUser({
      profession: data?.profession ?? profession ?? "",
      entreprise: data?.entreprise ?? entreprise ?? "",
      role: data?.role ? String(data.role) : undefined,
      actif: data?.actif,
      deleted: data?.deleted,

      // champs communs
      telephone: data?.telephone,
      nom: data?.nom,
      prenom: data?.prenom,
      email: data?.email,
      username: data?.username,
    });

    return data;
  },

  /**
   * PUT /utilisateurs/completer-profil/etudiant
   * body: { numeroEtudiant: string, filiere: string, niveau: string }
   */
  completeEtudiantProfile: async ({ numeroEtudiant, filiere, niveau }) => {
    const payload = { numeroEtudiant, filiere, niveau };
    const { data } = await utilisateursApi.completerProfilEtudiant(payload);

    // data = EtudiantResponseDTO
    updateStoredUser({
      // attention: le backend renvoie numeroCarteEtudiant (DTO)
      numeroCarteEtudiant: data?.numeroCarteEtudiant ?? numeroEtudiant,
      filiere: data?.filiere ?? filiere,
      niveau: data?.niveau ?? niveau,
      role: data?.role ? String(data.role) : undefined,
      actif: data?.actif,
      deleted: data?.deleted,

      // champs communs
      telephone: data?.telephone,
      nom: data?.nom,
      prenom: data?.prenom,
      email: data?.email,
      username: data?.username,
    });

    return data;
  },


  getStoredUser: () => {
    try {
      const current = localStorage.getItem("user");
      return current ? JSON.parse(current) : null;
    } catch {
      return null;
    }
  },
};

export default userService;
