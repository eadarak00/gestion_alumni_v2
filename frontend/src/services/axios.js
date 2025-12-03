import axios from 'axios';
import config from '../config/config';

const axiosInstance = axios.create({
  baseURL: config.api.baseURL,
  timeout: config.api.timeout,
  headers: { 'Content-Type': 'application/json' },
});

// Pour éviter plusieurs refresh simultanés
let isRefreshing = false;
let failedQueue = [];

// Réessaye les requêtes après refresh
const processQueue = (error, token = null) => {
  failedQueue.forEach(prom => {
    if (error) {
      prom.reject(error);
    } else {
      prom.resolve(token);
    }
  });
  failedQueue = [];
};

// 🟩 Intercepteur REQUEST : ajoute accessToken
axiosInstance.interceptors.request.use(
  (configAxios) => {
    const accessToken = localStorage.getItem('accessToken');
    if (accessToken) {
      configAxios.headers.Authorization = `Bearer ${accessToken}`;
    }
    return configAxios;
  },
  (error) => Promise.reject(error)
);

// 🟩 Intercepteur RESPONSE : gère refresh automatiquement
axiosInstance.interceptors.response.use(
  (response) => response,

  async (error) => {
    const originalRequest = error.config;

    // Si token expiré
    if (error.response?.status === 401 && !originalRequest._retry) {
      originalRequest._retry = true;

      // Évite double refresh
      if (isRefreshing) {
        return new Promise(function (resolve, reject) {
          failedQueue.push({ resolve, reject });
        })
          .then((newToken) => {
            originalRequest.headers.Authorization = `Bearer ${newToken}`;
            return axiosInstance(originalRequest);
          })
          .catch((err) => Promise.reject(err));
      }

      isRefreshing = true;

      try {
        const refreshToken = localStorage.getItem('refreshToken');

        const res = await axios.post(
          `${config.api.baseURL}${config.endpoints.AUTH.REFRESH_TOKEN}`,
          { refreshToken }
        );

        const newAccessToken = res.data.accessToken;

        localStorage.setItem('accessToken', newAccessToken);

        axiosInstance.defaults.headers.Authorization = `Bearer ${newAccessToken}`;

        processQueue(null, newAccessToken);

        return axiosInstance(originalRequest);
      } catch (err) {
        processQueue(err, null);

        localStorage.removeItem('accessToken');
        localStorage.removeItem('refreshToken');
        localStorage.removeItem('utilisateur');

        window.location.href = '/connexion';

        return Promise.reject(err);
      } finally {
        isRefreshing = false;
      }
    }

    return Promise.reject(error);
  }
);

export default axiosInstance;
