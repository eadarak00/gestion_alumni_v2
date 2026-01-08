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

const utilisateursApi = new UtilisateursApi(msUserConfiguration, undefined, apiClient);
const alumnisApi = new AlumnisApi(msUserConfiguration, undefined, apiClient);

export const userService = {
  /**
   * GET /utilisateurs?actif&deleted&page&size&sort
   */
  getAllUsers: async (filters = {}) => {
    try {
      const { data } = await utilisateursApi.getAllUtilisateursFiltered(
        filters.actif,
        filters.deleted,
        filters.page,
        filters.size,
        filters.sort
      );
      return data;
    } catch (error) {
      throw error;
    }
  },

  getActiveUsers: async () => {
    try {
      const { data } = await utilisateursApi.getAllUtilisateursFiltered(
        true,
        false,
        0,
        10,
        "nom,asc"
      );
      return data;
    } catch (error) {
      throw error;
    }
  },

  getUserByEmail: async (email) => {
    try {
      const { data } = await utilisateursApi.getUtilisateurByEmail(email);
      return data;
    } catch (error) {
      throw error;
    }
  },

  checkEmailExists: async (email) => {
    try {
      const { data } = await utilisateursApi.emailExists(email);
      return data; // boolean
    } catch (error) {
      throw error;
    }
  },

  checkUsernameExists: async (username) => {
    try {
      const { data } = await utilisateursApi.usernameExists(username);
      return data; // boolean
    } catch (error) {
      throw error;
    }
  },

  /**
   * ✅ Recherche alumni (client généré => AlumnisApi)
   * GET /alumni/search?entreprise&profession&nom&prenom
   */
  searchAlumni: async (filters = {}) => {
    try {
      const { data } = await alumnisApi.searchAlumni(
        filters.entreprise,
        filters.profession,
        filters.nom,
        filters.prenom
      );
      return data; // Array<AlumniResponseDTO>
    } catch (error) {
      throw error;
    }
  },

  /**
   * ✅ Compléter profil alumni (client généré => UtilisateursApi)
   * PUT /utilisateurs/completer-profil/alumni
   * Body: { profession?: string, entreprise?: string }
   */
  completeAlumniProfile: async ({ profession, entreprise }) => {
    try {
      const payload = { profession, entreprise }; // AlumniProfilRequestDTO
      const { data } = await utilisateursApi.completerProfilAlumni(payload);
      return data; // AlumniResponseDTO
    } catch (error) {
      throw error;
    }
  },

  /**
   * ✅ Compléter profil étudiant (client généré => UtilisateursApi)
   * PUT /utilisateurs/completer-profil/etudiant
   * Body: { numeroEtudiant: string, filiere: string, niveau: string }
   *
   */
  completeEtudiantProfile: async ({ numeroEtudiant, filiere, niveau }) => {
    try {
      const payload = { numeroEtudiant, filiere, niveau }; // EtudiantProfilRequestDTO
      const { data } = await utilisateursApi.completerProfilEtudiant(payload);
      return data; // EtudiantResponseDTO
    } catch (error) {
      throw error;
    }
  },

  // Endpoints NON présents (tu peux garder)
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
