// import ApiClient from '../api-ms-user/js-client/src/ApiClient';

// const apiClient = new ApiClient();
// apiClient.basePath = 'http://localhost:8088/api/v1';

// // Fonction pour ajouter le token JWT aux requêtes

// export const setAuthToken = (token) => {
//   if (token) {
//     apiClient.authentications.bearerAuth.accessToken = token;
//   } else {
//     delete apiClient.authentications.bearerAuth.accessToken;
//   }
// };

// export default apiClient;



// gestion_alumni_v2/frontend/src/utils/apiConfig.js
import ApiClient from '../api-ms-user/js-client/src/ApiClient';

/**
 * Configuration centralisée de l'API
 * Tous les changements d'URL se font ici uniquement
 */

// Base URL centralisée - À modifier selon l'environnement
const API_BASE_URL = process.env.REACT_APP_API_BASE_URL || 'http://localhost:8088/api-users/v1';

// Création d'une nouvelle instance du client API
const apiClient = new ApiClient();
apiClient.basePath = API_BASE_URL;

// Configuration du timeout (60 secondes par défaut)
apiClient.timeout = process.env.REACT_APP_API_TIMEOUT || 60000;

// Configuration des headers par défaut
apiClient.defaultHeaders = {
  'Content-Type': 'application/json',
  'Accept': 'application/json'
};

/**
 * Configure le token d'authentification Bearer
 * @param {string} token - Le token JWT
 */
export const setAuthToken = (token) => {
  if (token) {
    apiClient.authentications.bearerAuth.accessToken = token;
  } else {
    delete apiClient.authentications.bearerAuth.accessToken;
  }
};

/**
 * Récupère le token depuis le localStorage et le configure
 */
export const loadAuthToken = () => {
  const token = localStorage.getItem('accessToken');
  if (token) {
    setAuthToken(token);
  }
};

// Charger le token au démarrage
loadAuthToken();

export { API_BASE_URL };
export default apiClient;