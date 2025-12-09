// Importation de l'API générée pour les utilisateurs
// Le chemin est relatif à la position actuelle du fichier
import UtilisateursApi from '../../api-ms-user/js-client/src/api/UtilisateursApi';

// Importation du client API configuré
import apiClient from '../../utils/apiConfig';

// Création d'une instance de l'API utilisateurs en lui passant le client configuré
// Cette instance permettra d'appeler les différentes méthodes d'API
const userApi = new UtilisateursApi(apiClient);

// Service utilisateur qui encapsule les appels API
// Ce service offre une interface simplifiée pour interagir avec le backend
export const userService = {
  /**
   * Récupère tous les utilisateurs
   * @returns {Promise} Promesse qui se résout avec les données des utilisateurs
   * ou se rejette avec une erreur
   */
  /**
   * Récupère tous les utilisateurs
   * @returns {Promise} Promesse qui se résout avec les données des utilisateurs
   * ou se rejette avec une erreur
   */
  getAllUsers: () => {
    return new Promise((resolve, reject) => {
      // Appel à l'API pour obtenir tous les utilisateurs
      // Utilisation de getAllUtilisateursFiltered sans filtre pour tout récupérer
      userApi.getAllUtilisateursFiltered({}, (error, data, response) => {
        if (error) {
          // En cas d'erreur, on rejette la promesse avec l'erreur
          reject(error);
        } else {
          // Si succès, on résout la promesse avec les données
          resolve(data);
        }
      });
    });
  },

  /**
   * Récupère uniquement les utilisateurs actifs (non supprimés)
   * @returns {Promise} Promesse qui se résout avec les données des utilisateurs actifs
   * ou se rejette avec une erreur
   */
  getActiveUsers: () => {
    return new Promise((resolve, reject) => {
      // Appel à l'API pour obtenir les utilisateurs non supprimés
      // Utilisation de getAllUtilisateursFiltered avec le filtre deleted: false
      userApi.getAllUtilisateursFiltered({ deleted: false }, (error, data, response) => {
        if (error) {
          reject(error);
        } else {
          resolve(data);
        }
      });
    });
  },

  /**
   * Recherche un utilisateur par son adresse email
   * @param {string} email - L'adresse email de l'utilisateur à rechercher
   * @returns {Promise} Promesse qui se résout avec les données de l'utilisateur
   * ou se rejette avec une erreur
   */
  getUserByEmail: (email) => {
    return new Promise((resolve, reject) => {
      // Appel à l'API pour rechercher un utilisateur par email
      userApi.getUtilisateurByEmail(email, (error, data, response) => {
        if (error) {
          reject(error);
        } else {
          resolve(data);
        }
      });
    });
  },

  /**
   * Vérifie si une adresse email existe déjà dans le système
   * @param {string} email - L'adresse email à vérifier
   * @returns {Promise} Promesse qui se résout avec un booléen indiquant si l'email existe
   * ou se rejette avec une erreur
   */
  checkEmailExists: (email) => {
    return new Promise((resolve, reject) => {
      // Appel à l'API pour vérifier l'existence de l'email
      userApi.emailExists(email, (error, data, response) => {
        if (error) {
          reject(error);
        } else {
          resolve(data);
        }
      });
    });
  },

  /**
   * Vérifie si un nom d'utilisateur existe déjà dans le système
   * @param {string} username - Le nom d'utilisateur à vérifier
   * @returns {Promise} Promesse qui se résout avec un booléen indiquant si le username existe
   * ou se rejette avec une erreur
   */
  checkUsernameExists: (username) => {
    return new Promise((resolve, reject) => {
      // Appel à l'API pour vérifier l'existence du nom d'utilisateur
      userApi.usernameExists(username, (error, data, response) => {
        if (error) {
          reject(error);
        } else {
          resolve(data);
        }
      });
    });
  }
};