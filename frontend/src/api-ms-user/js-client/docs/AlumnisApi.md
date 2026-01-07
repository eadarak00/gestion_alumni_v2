# AlumnisApi

All URIs are relative to *http://localhost:8081/api-users/v1*

|Method | HTTP request | Description|
|------------- | ------------- | -------------|
|[**searchAlumni**](#searchalumni) | **GET** /alumni/search | Recherche avancée des alumni|

# **searchAlumni**
> Array<AlumniResponseDTO> searchAlumni()

Permet de rechercher des alumni à l\'aide de filtres optionnels par entreprise et profession. 

### Example

```typescript
import {
    AlumnisApi,
    Configuration
} from './api';

const configuration = new Configuration();
const apiInstance = new AlumnisApi(configuration);

let entreprise: string; //Nom de l\'entreprise actuelle de l\'alumni (optional) (default to undefined)
let profession: string; //Profession actuelle de l\'alumni (ex: Data Scientist, Médecin...) (optional) (default to undefined)
let nom: string; //Le nom de l\'Alumni (ex: THIAM, DIOP...)  (optional) (default to undefined)
let prenom: string; //Le prenom de l\'Alumni (ex: Khoutbou, Ibrahima...)  (optional) (default to undefined)

const { status, data } = await apiInstance.searchAlumni(
    entreprise,
    profession,
    nom,
    prenom
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **entreprise** | [**string**] | Nom de l\&#39;entreprise actuelle de l\&#39;alumni | (optional) defaults to undefined|
| **profession** | [**string**] | Profession actuelle de l\&#39;alumni (ex: Data Scientist, Médecin...) | (optional) defaults to undefined|
| **nom** | [**string**] | Le nom de l\&#39;Alumni (ex: THIAM, DIOP...)  | (optional) defaults to undefined|
| **prenom** | [**string**] | Le prenom de l\&#39;Alumni (ex: Khoutbou, Ibrahima...)  | (optional) defaults to undefined|


### Return type

**Array<AlumniResponseDTO>**

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Liste filtrée des alumni |  -  |
|**400** | Requête invalide |  -  |
|**500** | Erreur interne du serveur |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

