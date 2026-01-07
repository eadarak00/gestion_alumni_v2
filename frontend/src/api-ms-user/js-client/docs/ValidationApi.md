# ValidationApi

All URIs are relative to *http://localhost:8081/api/v1*

|Method | HTTP request | Description|
|------------- | ------------- | -------------|
|[**envoyerCode**](#envoyercode) | **POST** /validation/envoyer | Envoyer un code de validation|
|[**verifierCode**](#verifiercode) | **POST** /validation/verifier | Vérifier un code de validation|

# **envoyerCode**
> envoyerCode(codeValidationRequestDTO)

Génère et envoie un code de validation par email

### Example

```typescript
import {
    ValidationApi,
    Configuration,
    CodeValidationRequestDTO
} from './api';

const configuration = new Configuration();
const apiInstance = new ValidationApi(configuration);

let codeValidationRequestDTO: CodeValidationRequestDTO; //

const { status, data } = await apiInstance.envoyerCode(
    codeValidationRequestDTO
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **codeValidationRequestDTO** | **CodeValidationRequestDTO**|  | |


### Return type

void (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**201** | Code envoyé avec succès |  -  |
|**400** | Email invalide |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **verifierCode**
> string verifierCode(codeValidationCheckDTO)

Valide un code fourni par l\'utilisateur

### Example

```typescript
import {
    ValidationApi,
    Configuration,
    CodeValidationCheckDTO
} from './api';

const configuration = new Configuration();
const apiInstance = new ValidationApi(configuration);

let codeValidationCheckDTO: CodeValidationCheckDTO; //

const { status, data } = await apiInstance.verifierCode(
    codeValidationCheckDTO
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **codeValidationCheckDTO** | **CodeValidationCheckDTO**|  | |


### Return type

**string**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Code validé avec succès |  -  |
|**400** | Code invalide ou expiré |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

