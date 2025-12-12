import ValidationApi from '../../api-ms-user/js-client/src/api/ValidationApi';
import CodeValidationRequestDTO from '../../api-ms-user/js-client/src/model/CodeValidationRequestDTO';
// import CodeValidationCheckDTO from '../../api-ms-user/js-client/src/model/CodeValidationCheckDTO';
import apiClient from '../../utils/apiConfig';

const validationApi = new ValidationApi(apiClient);
const API_BASE_URL = 'http://localhost:8088/api/v1';

export const validationService = {
  sendValidationCode: (email) => {
    // Utiliser l'API générée pour l'envoi (ça fonctionne)
    return new Promise((resolve, reject) => {
      const codeRequest = new CodeValidationRequestDTO(email);
      validationApi.envoyerCode(codeRequest, (error, data, response) => {
        if (error) reject(error);
        else resolve();
      });
    });
  },

  

  verifyValidationCode: (email, code) => {
    // Pour la vérification, utiliser fetch directement
    return new Promise((resolve, reject) => {
      fetch(`${API_BASE_URL}/validation/verifier`, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
          'Accept': 'text/plain, */*'
        },
        body: JSON.stringify({ email, code })
      })
      .then(async (response) => {
        const text = await response.text();
        
        // Debug logging
        console.log('=== VALIDATION RESPONSE ===');
        console.log('Status:', response.status);
        console.log('Text:', text);
        console.log('OK:', response.ok);
        console.log('===========================');
        
        if (response.ok) {
          // L'API retourne une string simple, pas du JSON
          resolve(text || 'Validation réussie');
        } else {
          // Essayer de comprendre l'erreur
          let errorMsg = `Code invalide (${response.status})`;
          
          if (text) {
            try {
              // Peut-être que l'erreur est en JSON
              const errorJson = JSON.parse(text);
              errorMsg = errorJson.message || errorJson;
            } catch {
              // Sinon utiliser le texte brut
              errorMsg = text;
            }
          }
          
          reject(new Error(errorMsg));
        }
      })
      .catch((error) => {
        console.error('Network error:', error);
        reject(new Error('Erreur réseau. Vérifiez votre connexion.'));
      });
    });
  }
};