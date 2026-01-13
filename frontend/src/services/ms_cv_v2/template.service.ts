import { 
  DefaultApi, 
  TemplateRequestDTO, 
  TemplateResponseDTO 
} from "../../api-ms-cv-v2/js-client";
import { msCvV2Configuration, msCvV2Client } from "../../utils/msCvV2Config";

// Instance of the generated API client
const templatesApi = new DefaultApi(msCvV2Configuration, undefined, msCvV2Client);

export const templateService = {
  /**
   * Create a new template
   */
  createTemplate: async (template: TemplateRequestDTO): Promise<TemplateResponseDTO> => {
    try {
      const { data } = await templatesApi.createTemplate(template);
      return data;
    } catch (error) {
      throw error;
    }
  },

  /**
   * Get all templates (global and user-specific)
   */
  getAllTemplates: async (): Promise<TemplateResponseDTO[]> => {
    try {
      const { data } = await templatesApi.getAllTemplates();
      return data;
    } catch (error) {
      throw error;
    }
  },

  /**
   * Get a template by ID
   */
  getTemplateById: async (id: number): Promise<TemplateResponseDTO> => {
    try {
      const { data } = await templatesApi.getTemplateById(id);
      return data;
    } catch (error) {
      throw error;
    }
  },

  /**
   * Update an existing template
   */
  updateTemplate: async (id: number, template: TemplateRequestDTO): Promise<TemplateResponseDTO> => {
    try {
      const { data } = await templatesApi.updateTemplate(id, template);
      return data;
    } catch (error) {
      throw error;
    }
  },

  /**
   * Delete a template
   */
  deleteTemplate: async (id: number): Promise<void> => {
    try {
      await templatesApi.deleteTemplate(id);
    } catch (error) {
      throw error;
    }
  },
};

export default templateService;
