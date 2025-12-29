# UtilisateursApi

All URIs are relative to *http://localhost:8081/api/v1*

|Method | HTTP request | Description|
|------------- | ------------- | -------------|
|[**emailExists**](#emailexists) | **GET** /utilisateurs/exists/email/{email} | Vérifier si un email existe|
|[**getAllUtilisateursFiltered**](#getallutilisateursfiltered) | **GET** /utilisateurs | Lister et filtrer les utilisateurs|
|[**getUtilisateurByEmail**](#getutilisateurbyemail) | **GET** /utilisateurs/email/{email} | Récupérer un utilisateur par email|
|[**searchAlumni**](#searchalumni) | **GET** /alumni/search | Recherche avancée des alumni|
|[**usernameExists**](#usernameexists) | **GET** /utilisateurs/exists/username/{username} | Vérifier si un username existe|

# **emailExists**
> boolean emailExists()

Vérifie si un email est déjà utilisé dans le système

### Example

```typescript
import {
    UtilisateursApi,
    Configuration
} from './api';

const configuration = new Configuration();
const apiInstance = new UtilisateursApi(configuration);

let email: string; // (default to undefined)

const { status, data } = await apiInstance.emailExists(
    email
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **email** | [**string**] |  | defaults to undefined|


### Return type

**boolean**

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Résultat de la vérification |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getAllUtilisateursFiltered**
> GetAllUtilisateursFiltered200Response getAllUtilisateursFiltered()

Permet de lister les utilisateurs avec pagination, filtre par actif et filtre par suppression (soft delete). 

### Example

```typescript
import {
    UtilisateursApi,
    Configuration
} from './api';

const configuration = new Configuration();
const apiInstance = new UtilisateursApi(configuration);

let actif: boolean; //Filtre sur l\'état d\'activation du compte (optional) (default to undefined)
let deleted: boolean; //Filtre sur l\'état de suppression logique (soft delete) (optional) (default to undefined)
let page: number; // (optional) (default to undefined)
let size: number; // (optional) (default to undefined)
let sort: string; //Format: champ,ordre (asc|desc) (optional) (default to undefined)

const { status, data } = await apiInstance.getAllUtilisateursFiltered(
    actif,
    deleted,
    page,
    size,
    sort
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **actif** | [**boolean**] | Filtre sur l\&#39;état d\&#39;activation du compte | (optional) defaults to undefined|
| **deleted** | [**boolean**] | Filtre sur l\&#39;état de suppression logique (soft delete) | (optional) defaults to undefined|
| **page** | [**number**] |  | (optional) defaults to undefined|
| **size** | [**number**] |  | (optional) defaults to undefined|
| **sort** | [**string**] | Format: champ,ordre (asc|desc) | (optional) defaults to undefined|


### Return type

**GetAllUtilisateursFiltered200Response**

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Résultats de la recherche filtrée |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getUtilisateurByEmail**
> UtilisateurResponseDTO getUtilisateurByEmail()

Retourne les informations d\'un utilisateur par son email

### Example

```typescript
import {
    UtilisateursApi,
    Configuration
} from './api';

const configuration = new Configuration();
const apiInstance = new UtilisateursApi(configuration);

let email: string; // (default to undefined)

const { status, data } = await apiInstance.getUtilisateurByEmail(
    email
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **email** | [**string**] |  | defaults to undefined|


### Return type

**UtilisateurResponseDTO**

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Utilisateur trouvé |  -  |
|**404** | Utilisateur non trouvé |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **searchAlumni**
> Array<AlumniResponseDTO> searchAlumni()

Permet de rechercher des alumni à l\'aide de filtres optionnels par entreprise et profession. 

### Example

```typescript
import {
    UtilisateursApi,
    Configuration
} from './api';

const configuration = new Configuration();
const apiInstance = new UtilisateursApi(configuration);

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

# **usernameExists**
> boolean usernameExists()

Vérifie si un username est déjà utilisé dans le système

### Example

```typescript
import {
    UtilisateursApi,
    Configuration
} from './api';

const configuration = new Configuration();
const apiInstance = new UtilisateursApi(configuration);

let username: string; // (default to undefined)

const { status, data } = await apiInstance.usernameExists(
    username
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **username** | [**string**] |  | defaults to undefined|


### Return type

**boolean**

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Résultat de la vérification |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

