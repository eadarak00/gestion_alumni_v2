# AuthentificationApi

All URIs are relative to *http://localhost:8081/api-users/v1*

|Method | HTTP request | Description|
|------------- | ------------- | -------------|
|[**inscrire**](#inscrire) | **POST** /auth/inscrire | Inscrire un nouvel Utilisateur|
|[**login**](#login) | **POST** /auth/connecter | Connexion utilisateur|
|[**logout**](#logout) | **POST** /auth/deconnecter | Déconnexion utilisateur|
|[**refresh**](#refresh) | **POST** /auth/refresh | Rafraîchir le token JWT|

# **inscrire**
> UtilisateurResponseDTO inscrire(utilisateurRequestDTO)

Crée un nouveau compte utilisateur

### Example

```typescript
import {
    AuthentificationApi,
    Configuration,
    UtilisateurRequestDTO
} from './api';

const configuration = new Configuration();
const apiInstance = new AuthentificationApi(configuration);

let utilisateurRequestDTO: UtilisateurRequestDTO; //

const { status, data } = await apiInstance.inscrire(
    utilisateurRequestDTO
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **utilisateurRequestDTO** | **UtilisateurRequestDTO**|  | |


### Return type

**UtilisateurResponseDTO**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**201** | Utilisateur inscrit avec succès |  -  |
|**400** | Données invalides |  -  |
|**409** | Email, username ou numéro de carte déjà utilisé |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **login**
> TokenResponse login(loginRequest)

Authentifie un utilisateur et retourne un token JWT

### Example

```typescript
import {
    AuthentificationApi,
    Configuration,
    LoginRequest
} from './api';

const configuration = new Configuration();
const apiInstance = new AuthentificationApi(configuration);

let loginRequest: LoginRequest; //

const { status, data } = await apiInstance.login(
    loginRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **loginRequest** | **LoginRequest**|  | |


### Return type

**TokenResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Connexion réussie |  -  |
|**401** | Identifiants invalides |  -  |
|**403** | Compte inactif ou supprimé |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **logout**
> logout(refreshRequest)

Déconnecte l\'utilisateur et invalide le refresh token

### Example

```typescript
import {
    AuthentificationApi,
    Configuration,
    RefreshRequest
} from './api';

const configuration = new Configuration();
const apiInstance = new AuthentificationApi(configuration);

let refreshRequest: RefreshRequest; //

const { status, data } = await apiInstance.logout(
    refreshRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **refreshRequest** | **RefreshRequest**|  | |


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
|**204** | Déconnexion réussie |  -  |
|**401** | Non authentifié |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **refresh**
> TokenResponse refresh(refreshRequest)

Permet de renouveler un token JWT expiré en utilisant le refresh token

### Example

```typescript
import {
    AuthentificationApi,
    Configuration,
    RefreshRequest
} from './api';

const configuration = new Configuration();
const apiInstance = new AuthentificationApi(configuration);

let refreshRequest: RefreshRequest; //

const { status, data } = await apiInstance.refresh(
    refreshRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **refreshRequest** | **RefreshRequest**|  | |


### Return type

**TokenResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Token rafraîchi avec succès |  -  |
|**401** | Refresh token invalide ou expiré |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

