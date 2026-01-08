# UtilisateursApi

All URIs are relative to *http://localhost:8081/api-users/v1*

|Method | HTTP request | Description|
|------------- | ------------- | -------------|
|[**completerProfilAlumni**](#completerprofilalumni) | **PUT** /utilisateurs/completer-profil/alumni | Compléter son profil alumni|
|[**completerProfilEtudiant**](#completerprofiletudiant) | **PUT** /utilisateurs/completer-profil/etudiant | Compléter son profil étudiant|
|[**emailExists**](#emailexists) | **GET** /utilisateurs/exists/email/{email} | Vérifier si un email existe|
|[**getAllUtilisateursFiltered**](#getallutilisateursfiltered) | **GET** /utilisateurs | Lister et filtrer les utilisateurs|
|[**getUtilisateurByEmail**](#getutilisateurbyemail) | **GET** /utilisateurs/email/{email} | Récupérer un utilisateur par email|
|[**usernameExists**](#usernameexists) | **GET** /utilisateurs/exists/username/{username} | Vérifier si un username existe|

# **completerProfilAlumni**
> AlumniResponseDTO completerProfilAlumni(alumniProfilRequestDTO)

Permet à l\'utilisateur connecté ayant le rôle ALUMNI de compléter son profil avec les informations spécifiques : profession et entreprise. 

### Example

```typescript
import {
    UtilisateursApi,
    Configuration,
    AlumniProfilRequestDTO
} from './api';

const configuration = new Configuration();
const apiInstance = new UtilisateursApi(configuration);

let alumniProfilRequestDTO: AlumniProfilRequestDTO; //

const { status, data } = await apiInstance.completerProfilAlumni(
    alumniProfilRequestDTO
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **alumniProfilRequestDTO** | **AlumniProfilRequestDTO**|  | |


### Return type

**AlumniResponseDTO**

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Profil alumni complété avec succès |  -  |
|**400** | Utilisateur non alumni ou données invalides |  -  |
|**401** | Non authentifié |  -  |
|**403** | Accès interdit |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **completerProfilEtudiant**
> EtudiantResponseDTO completerProfilEtudiant(etudiantProfilRequestDTO)

Permet à l\'utilisateur connecté ayant le rôle ETUDIANT de compléter son profil avec les informations spécifiques : numeroCarteEtudiant, filiere et niveau. 

### Example

```typescript
import {
    UtilisateursApi,
    Configuration,
    EtudiantProfilRequestDTO
} from './api';

const configuration = new Configuration();
const apiInstance = new UtilisateursApi(configuration);

let etudiantProfilRequestDTO: EtudiantProfilRequestDTO; //

const { status, data } = await apiInstance.completerProfilEtudiant(
    etudiantProfilRequestDTO
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **etudiantProfilRequestDTO** | **EtudiantProfilRequestDTO**|  | |


### Return type

**EtudiantResponseDTO**

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Profil étudiant complété avec succès |  -  |
|**400** | Utilisateur non étudiant ou données invalides |  -  |
|**401** | Non authentifié |  -  |
|**403** | Accès interdit |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

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

