import axios from "axios";

const API_CV_V2_URL = "http://localhost:8088/api-ms-cv2/v1";

// Client Axios dédié pour MS-CV V2
const cvApiClient = axios.create({
    baseURL: API_CV_V2_URL,
    timeout: 60000,
    headers: {
        "Content-Type": "application/json",
        Accept: "application/json",
    },
});

// Intercepteur pour ajouter le token d'authentification
cvApiClient.interceptors.request.use(
    (config) => {
        const token = localStorage.getItem("accessToken");
        if (token) {
            config.headers.Authorization = `Bearer ${token}`;
        }
        return config;
    },
    (error) => Promise.reject(error)
);

export const cvService = {
    // --- CV ---
    createCv: async (cvData) => {
        const { data } = await cvApiClient.post("/cvs", cvData);
        return data;
    },

    getMyCvs: async () => {
        const { data } = await cvApiClient.get("/cvs/me");
        return data;
    },

    getStudentCv: async () => {
        const { data } = await cvApiClient.get("/cvs/me");
        return data && data.length > 0 ? data[0] : null;
    },

    getFullCv: async (cvId) => {
        const { data } = await cvApiClient.get(`/cvs/${cvId}`);
        return data;
    },

    updateCv: async (cvId, cvData) => {
        const { data } = await cvApiClient.put(`/cvs/${cvId}`, cvData);
        return data;
    },

    deleteCv: async (cvId) => {
        await cvApiClient.delete(`/cvs/${cvId}`);
    },

    downloadPdf: async (cvId) => {
        const { data } = await cvApiClient.get(`/cvs/${cvId}/pdf`, {
            responseType: 'blob'
        });
        return data;
    }
};

export default cvService;
