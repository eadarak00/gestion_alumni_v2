import UtilisateursApi from '../../api-ms-user/js-client/src/api/UtilisateursApi';
import apiClient from '../../utils/apiConfig';

// Création d'une instance de l'API utilisateurs avec le client configuré
const userApi = new UtilisateursApi(apiClient);

/**
 * Service utilisateur qui encapsule les appels API
 * Toutes les méthodes retournent des Promises pour une utilisation avec async/await
 */
export const userService = {
  /**
   * Récupère tous les utilisateurs avec filtres optionnels
   * @param {Object} filters - Filtres optionnels (deleted, actif, role, etc.)
   * @returns {Promise} Promesse qui se résout avec les données des utilisateurs
   */
  getAllUsers: (filters = {}) => {
    return new Promise((resolve, reject) => {
      userApi.getAllUtilisateursFiltered(filters, (error, data, response) => {
        if (error) {
          console.error('❌ Erreur lors de la récupération des utilisateurs:', error);
          reject(error);
        } else {
          console.log('✅ Utilisateurs récupérés avec succès:', data);
          resolve(data);
        }
      });
    });
  },

  /**
   * Récupère uniquement les utilisateurs actifs (non supprimés)
   * @returns {Promise} Promesse qui se résout avec les données des utilisateurs actifs
   */
  getActiveUsers: () => {
    return new Promise((resolve, reject) => {
      userApi.getAllUtilisateursFiltered({ deleted: false }, (error, data, response) => {
        if (error) {
          console.error('❌ Erreur lors de la récupération des utilisateurs actifs:', error);
          reject(error);
        } else {
          console.log('✅ Utilisateurs actifs récupérés:', data);
          resolve(data);
        }
      });
    });
  },

  /**
   * Recherche un utilisateur par son ID
   * @param {number} id - L'ID de l'utilisateur
   * @returns {Promise} Promesse qui se résout avec les données de l'utilisateur
   */
  getUserById: (id) => {
    return new Promise((resolve, reject) => {
      userApi.getUtilisateurById(id, (error, data, response) => {
        if (error) {
          console.error(`❌ Erreur lors de la récupération de l'utilisateur ${id}:`, error);
          reject(error);
        } else {
          console.log(`✅ Utilisateur ${id} récupéré:`, data);
          resolve(data);
        }
      });
    });
  },

  /**
   * Recherche un utilisateur par son adresse email
   * @param {string} email - L'adresse email de l'utilisateur à rechercher
   * @returns {Promise} Promesse qui se résout avec les données de l'utilisateur
   */
  getUserByEmail: (email) => {
    return new Promise((resolve, reject) => {
      userApi.getUtilisateurByEmail(email, (error, data, response) => {
        if (error) {
          console.error(`❌ Utilisateur non trouvé pour l'email ${email}:`, error);
          reject(error);
        } else {
          console.log(`✅ Utilisateur trouvé pour l'email ${email}:`, data);
          resolve(data);
        }
      });
    });
  },

  /**
   * Vérifie si une adresse email existe déjà dans le système
   * @param {string} email - L'adresse email à vérifier
   * @returns {Promise} Promesse qui se résout avec un booléen
   */
  checkEmailExists: (email) => {
    return new Promise((resolve, reject) => {
      userApi.emailExists(email, (error, data, response) => {
        if (error) {
          console.error(`❌ Erreur lors de la vérification de l'email ${email}:`, error);
          reject(error);
        } else {
          console.log(`✅ Vérification email ${email}:`, data);
          resolve(data);
        }
      });
    });
  },

  /**
   * Vérifie si un nom d'utilisateur existe déjà dans le système
   * @param {string} username - Le nom d'utilisateur à vérifier
   * @returns {Promise} Promesse qui se résout avec un booléen
   */
  checkUsernameExists: (username) => {
    return new Promise((resolve, reject) => {
      userApi.usernameExists(username, (error, data, response) => {
        if (error) {
          console.error(`❌ Erreur lors de la vérification du username ${username}:`, error);
          reject(error);
        } else {
          console.log(`✅ Vérification username ${username}:`, data);
          resolve(data);
        }
      });
    });
  },

  /**
   * Met à jour un utilisateur
   * @param {number} id - L'ID de l'utilisateur
   * @param {Object} userData - Les données à mettre à jour
   * @returns {Promise} Promesse qui se résout avec les données mises à jour
   */
  updateUser: (id, userData) => {
    return new Promise((resolve, reject) => {
      userApi.updateUtilisateur(id, userData, (error, data, response) => {
        if (error) {
          console.error(`❌ Erreur lors de la mise à jour de l'utilisateur ${id}:`, error);
          reject(error);
        } else {
          console.log(`✅ Utilisateur ${id} mis à jour:`, data);
          resolve(data);
        }
      });
    });
  },

  /**
   * Supprime (soft delete) un utilisateur
   * @param {number} id - L'ID de l'utilisateur à supprimer
   * @returns {Promise} Promesse qui se résout si la suppression réussit
   */
  deleteUser: (id) => {
    return new Promise((resolve, reject) => {
      userApi.deleteUtilisateur(id, (error, data, response) => {
        if (error) {
          console.error(`❌ Erreur lors de la suppression de l'utilisateur ${id}:`, error);
          reject(error);
        } else {
          console.log(`✅ Utilisateur ${id} supprimé`);
          resolve(data);
        }
      });
    });
  }
};

export default userService;