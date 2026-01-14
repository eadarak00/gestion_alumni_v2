import { 
  DefaultApi, 
  CvRequestDTO, 
  CvResponseDTO 
} from "../../api-ms-cv-v2/js-client";
import { msCvV2Configuration, msCvV2Client } from "../../utils/msCvV2Config";

// Instance of the generated API client
const cvApi = new DefaultApi(msCvV2Configuration, undefined, msCvV2Client);

export const cvService = {
  /**
   * Create a new CV
   */
  createCv: async (cv: CvRequestDTO): Promise<CvResponseDTO> => {
    try {
      const { data } = await cvApi.createCv(cv);
      return data;
    } catch (error) {
      throw error;
    }
  },

  /**
   * Get all CVs for the current user
   */
  getMyCvs: async (): Promise<CvResponseDTO[]> => {
    try {
      const { data } = await cvApi.getMyCvs();
      return data;
    } catch (error) {
      throw error;
    }
  },

  /**
   * Get a CV by ID
   */
  getCvById: async (id: number): Promise<CvResponseDTO> => {
    try {
      const { data } = await cvApi.getCvById(id);
      return data;
    } catch (error) {
      throw error;
    }
  },

  /**
   * Update an existing CV
   */
  updateCv: async (id: number, cv: CvRequestDTO): Promise<CvResponseDTO> => {
    try {
      const { data } = await cvApi.updateCv(id, cv);
      return data;
    } catch (error) {
      throw error;
    }
  },

  /**
   * Delete a CV
   */
  deleteCv: async (id: number): Promise<void> => {
    try {
      await cvApi.deleteCv(id);
    } catch (error) {
      throw error;
    }
  },

  /**
   * Download CV as PDF
   */
  downloadCvPdf: async (id: number): Promise<File> => {
    try {
      const { data } = await cvApi.downloadCvPdf(id);
      return data;
    } catch (error) {
      throw error;
    }
  },
};

export default cvService;
