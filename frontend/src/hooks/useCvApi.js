// src/hooks/useCvApi.jsx
import { useState, useCallback } from 'react';
import MsCvApiService from '../services/msCV/ms-cv-api';

export const useCvApi = () => {
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState(null);
    const api = MsCvApiService;

    const setToken = useCallback((token) => {
        api.setToken(token);
    }, [api]);

    const callApi = useCallback(async (apiCall, options) => {
        setLoading(true);
        setError(null);

        try {
            const result = await apiCall();
            if (options?.onSuccess) options.onSuccess(result);
            return result;
        } catch (err) {
            const error = err instanceof Error ? err : new Error('An unknown error occurred');
            setError(error);
            if (options?.onError) options.onError(error);
            return null;
        } finally {
            setLoading(false);
        }
    }, []);

    // CV Operations
    const createCV = useCallback(async (cvData, options) => {
        return callApi(() => api.createCV(cvData), options);
    }, [callApi, api]);

    const getCVById = useCallback(async (id, options) => {
        return callApi(() => api.getCVById(id), options);
    }, [callApi, api]);

    const getMyCVs = useCallback(async (options) => {
        return callApi(() => api.getMyCVs(), options);
    }, [callApi, api]);

    const updateCV = useCallback(async (id, cvData, options) => {
        return callApi(() => api.updateCV(id, cvData), options);
    }, [callApi, api]);

    const deleteCV = useCallback(async (id, options) => {
        return callApi(() => api.deleteCV(id), options);
    }, [callApi, api]);

    const downloadCVasPDF = useCallback(async (id, options) => {
        return callApi(() => api.downloadCVasPDF(id), options);
    }, [callApi, api]);

    // Template Operations
    const createTemplate = useCallback(async (templateData, options) => {
        return callApi(() => api.createTemplate(templateData), options);
    }, [callApi, api]);

    const getTemplateById = useCallback(async (id, options) => {
        return callApi(() => api.getTemplateById(id), options);
    }, [callApi, api]);

    const getAllTemplates = useCallback(async (options) => {
        return callApi(() => api.getAllTemplates(), options);
    }, [callApi, api]);

    const updateTemplate = useCallback(async (id, templateData, options) => {
        return callApi(() => api.updateTemplate(id, templateData), options);
    }, [callApi, api]);

    const deleteTemplate = useCallback(async (id, options) => {
        return callApi(() => api.deleteTemplate(id), options);
    }, [callApi, api]);

    return {
        loading,
        error,
        setToken,
        createCV,
        getCVById,
        getMyCVs,
        updateCV,
        deleteCV,
        downloadCVasPDF,
        createTemplate,
        getTemplateById,
        getAllTemplates,
        updateTemplate,
        deleteTemplate,
        clearError: () => setError(null)
    };
};

export const useMyCVs = () => {
    const [cvs, setCVs] = useState([]);
    const { getMyCVs, loading, error } = useCvApi();

    const fetchMyCVs = useCallback(async () => {
        const result = await getMyCVs({
            onSuccess: (data) => {
                if (data) setCVs(data);
            }
        });
        return result;
    }, [getMyCVs]);

    return { cvs, fetchMyCVs, loading, error };
};

export const useTemplates = () => {
    const [templates, setTemplates] = useState([]);
    const { getAllTemplates, loading, error } = useCvApi();

    const fetchTemplates = useCallback(async () => {
        const result = await getAllTemplates({
            onSuccess: (data) => {
                if (data) setTemplates(data);
            }
        });
        return result;
    }, [getAllTemplates]);

    return { templates, fetchTemplates, loading, error };
};

export const useCVById = (id) => {
    const [cv, setCV] = useState(null);
    const { getCVById, loading, error } = useCvApi();

    const fetchCV = useCallback(async () => {
        const result = await getCVById(id, {
            onSuccess: (data) => {
                if (data) setCV(data);
            }
        });
        return result;
    }, [getCVById, id]);

    return { cv, fetchCV, loading, error };
};