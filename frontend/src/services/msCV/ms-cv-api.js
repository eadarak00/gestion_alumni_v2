// src/services/api/ms-cv-api.service.js
import { Configuration, DefaultApi } from '../../api-ms-cv/js-client';

class MsCvApiService {
  static instance = null;
  api = null;
  token = null;

  constructor() {
    const config = new Configuration({
      basePath: process.env.REACT_APP_API_BASE_URL || 'http://localhost:8088/api-ms-cv2/v1',
      accessToken: () => this.token || ''
    });

    this.api = new DefaultApi(config);
  }

  static getInstance() {
    if (!MsCvApiService.instance) {
      MsCvApiService.instance = new MsCvApiService();
    }
    return MsCvApiService.instance;
  }

  setToken(token) {
    this.token = token;
  }

  // ============ CV Operations ============

  async createCV(cvData) {
    try {
      const response = await this.api.createCv(cvData);
      return response.data;
    } catch (error) {
      console.error('Error creating CV:', error);
      throw this.handleError(error);
    }
  }

  async getCVById(id) {
    try {
      const response = await this.api.getCvById(id);
      return response.data;
    } catch (error) {
      console.error(`Error fetching CV ${id}:`, error);
      throw this.handleError(error);
    }
  }

  async getMyCVs() {
    try {
      const response = await this.api.getMyCvs();
      return response.data;
    } catch (error) {
      console.error('Error fetching my CVs:', error);
      throw this.handleError(error);
    }
  }

  async updateCV(id, cvData) {
    try {
      const response = await this.api.updateCv(id, cvData);
      return response.data;
    } catch (error) {
      console.error(`Error updating CV ${id}:`, error);
      throw this.handleError(error);
    }
  }

  async deleteCV(id) {
    try {
      await this.api.deleteCv(id);
    } catch (error) {
      console.error(`Error deleting CV ${id}:`, error);
      throw this.handleError(error);
    }
  }

  async downloadCVasPDF(id) {
    try {
      const response = await this.api.downloadCvPdf(id, {
        responseType: 'blob'
      });
      return response.data;
    } catch (error) {
      console.error(`Error downloading CV ${id} as PDF:`, error);
      throw this.handleError(error);
    }
  }

  // ============ Template Operations ============

  async createTemplate(templateData) {
    try {
      const response = await this.api.createTemplate(templateData);
      return response.data;
    } catch (error) {
      console.error('Error creating template:', error);
      throw this.handleError(error);
    }
  }

  async getTemplateById(id) {
    try {
      const response = await this.api.getTemplateById(id);
      return response.data;
    } catch (error) {
      console.error(`Error fetching template ${id}:`, error);
      throw this.handleError(error);
    }
  }

  async getAllTemplates() {
    try {
      const response = await this.api.getAllTemplates();
      return response.data;
    } catch (error) {
      console.error('Error fetching all templates:', error);
      throw this.handleError(error);
    }
  }

  async updateTemplate(id, templateData) {
    try {
      const response = await this.api.updateTemplate(id, templateData);
      return response.data;
    } catch (error) {
      console.error(`Error updating template ${id}:`, error);
      throw this.handleError(error);
    }
  }

  async deleteTemplate(id) {
    try {
      await this.api.deleteTemplate(id);
    } catch (error) {
      console.error(`Error deleting template ${id}:`, error);
      throw this.handleError(error);
    }
  }

  // ============ Helper Methods ============

  handleError(error) {
    if (error.response) {
      const status = error.response.status;
      const message = error.response.data?.message || error.response.statusText;

      switch (status) {
        case 400:
          return new Error(`Bad Request: ${message}`);
        case 401:
          return new Error('Unauthorized - Please login again');
        case 403:
          return new Error('Forbidden - You do not have permission');
        case 404:
          return new Error('Resource not found');
        case 500:
          return new Error('Server error - Please try again later');
        default:
          return new Error(`Error ${status}: ${message}`);
      }
    } else if (error.request) {
      return new Error('Network error - Please check your connection');
    } else {
      return new Error(error.message || 'Unknown error occurred');
    }
  }
}

export default MsCvApiService.getInstance();