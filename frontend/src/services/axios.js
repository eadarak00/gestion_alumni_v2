import axios from 'axios';

//  Configuration depuis les variables d'environnement
const axiosInstance = axios.create({
  baseURL: process.env.REACT_APP_API_BASE_URL || 'http://localhost:8088/api',
  timeout: parseInt(process.env.REACT_APP_API_TIMEOUT) || 10000,
  headers: {
    'Content-Type': 'application/json',
  },
});

// Intercepteur pour ajouter le token JWT à chaque requête
axiosInstance.interceptors.request.use(
  (config) => {
    const token = localStorage.getItem('token');
    if (token) {
      config.headers.Authorization = `Bearer ${token}`;
    }

    // Log en développement uniquement
    if (process.env.REACT_APP_ENV === 'development') {
      console.log('🚀 Requête API:', {
        method: config.method?.toUpperCase(),
        url: config.url,
        baseURL: config.baseURL,
        fullURL: `${config.baseURL}${config.url}`,
      });
    }

    return config;
  },
  (error) => {
    console.error('Erreur dans la requête:', error);
    return Promise.reject(error);
  }
);

// Intercepteur pour gérer les réponses et erreurs
axiosInstance.interceptors.response.use(
  (response) => {
    // Log en développement uniquement
    if (process.env.REACT_APP_ENV === 'development') {
      console.log('✅ Réponse API:', {
        status: response.status,
        url: response.config.url,
        data: response.data,
      });
    }
    return response;
  },
  (error) => {
    // Gestion des erreurs d'authentification
    if (error.response?.status === 401) {
      console.warn('Session expirée, redirection vers la connexion');
      localStorage.removeItem('token');
      window.location.href = '/connexion';
    }

    // Log des erreurs en développement
    if (process.env.REACT_APP_ENV === 'development') {
      console.error('Erreur API:', {
        status: error.response?.status,
        message: error.response?.data?.message || error.message,
        url: error.config?.url,
        data: error.response?.data,
      });
    }

    return Promise.reject(error);
  }
);

export default axiosInstance;