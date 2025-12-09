import ApiClient from '../api-ms-user/js-client/src/ApiClient';

const apiClient = new ApiClient();
apiClient.basePath = 'http://localhost:8088/api/v1';

export const setAuthToken = (token) => {
  if (token) {
    apiClient.authentications.bearerAuth.accessToken = token;
  } else {
    delete apiClient.authentications.bearerAuth.accessToken;
  }
};

export default apiClient;
