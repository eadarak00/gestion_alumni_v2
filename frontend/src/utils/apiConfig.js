import axios from "axios";
import { Configuration } from "../api-ms-user/js-client";

export const API_BASE_URL =
  process.env.REACT_APP_API_BASE_URL || "http://localhost:8088/api-users/v1";

const apiClient = axios.create({
  baseURL: API_BASE_URL,
  timeout: Number(process.env.REACT_APP_API_TIMEOUT || 60000),
  headers: {
    "Content-Type": "application/json",
    Accept: "application/json",
  },
});

let currentToken = null;

export const setAuthToken = (token) => {
  currentToken = token || null;

  if (token) {
    apiClient.defaults.headers.common.Authorization = `Bearer ${token}`;
  } else {
    delete apiClient.defaults.headers.common.Authorization;
  }
};

export const loadAuthToken = () => {
  const token = localStorage.getItem("accessToken");
  if (token) setAuthToken(token);
};

loadAuthToken();

export const msUserConfiguration = new Configuration({
  basePath: API_BASE_URL,
  accessToken: async () => currentToken || localStorage.getItem("accessToken") || "",
});

export default apiClient;
