import axios from "axios";
import { Configuration } from "../api-ms-cv-v2/js-client";

export const MS_CV_V2_BASE_URL = "http://localhost:8088/api-ms-cv2/v1";

/**
 * Axios instance for ms-cv-v2 microservice
 */
export const msCvV2Client = axios.create({
  baseURL: MS_CV_V2_BASE_URL,
  timeout: Number(60000),
  headers: {
    "Content-Type": "application/json",
    Accept: "application/json",
  },
});

/**
 * Configuration for OpenAPI generated client
 * Uses the same token from localStorage as ms-user
 */
export const msCvV2Configuration = new Configuration({
  basePath: MS_CV_V2_BASE_URL,
  accessToken: async () => localStorage.getItem("accessToken") || "",
});

export default msCvV2Client;
