# RlesApi

All URIs are relative to *http://localhost:8081/api-users/v1*

|Method | HTTP request | Description|
|------------- | ------------- | -------------|
|[**createRole**](#createrole) | **POST** /roles | Créer un nouveau rôle|
|[**getAllRoles**](#getallroles) | **GET** /roles | Récupérer tous les rôles|
|[**getRoleById**](#getrolebyid) | **GET** /roles/{id} | Récupérer un rôle par son ID|
|[**softDeleteRole**](#softdeleterole) | **DELETE** /roles/{id} | Supprimer logiquement un rôle|
|[**updateRole**](#updaterole) | **PUT** /roles/{id} | Mettre à jour un rôle existant|

# **createRole**
> RoleResponseDTO createRole(roleRequestDTO)

Crée un nouveau rôle dans le système

### Example

```typescript
import {
    RlesApi,
    Configuration,
    RoleRequestDTO
} from './api';

const configuration = new Configuration();
const apiInstance = new RlesApi(configuration);

let roleRequestDTO: RoleRequestDTO; //

const { status, data } = await apiInstance.createRole(
    roleRequestDTO
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **roleRequestDTO** | **RoleRequestDTO**|  | |


### Return type

**RoleResponseDTO**

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**201** | Rôle créé avec succès |  -  |
|**400** | Données invalides |  -  |
|**409** | Un rôle avec le même nom existe déjà |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getAllRoles**
> Array<RoleResponseDTO> getAllRoles()

Retourne la liste de tous les rôles disponibles dans le système

### Example

```typescript
import {
    RlesApi,
    Configuration
} from './api';

const configuration = new Configuration();
const apiInstance = new RlesApi(configuration);

const { status, data } = await apiInstance.getAllRoles();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**Array<RoleResponseDTO>**

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Liste des rôles récupérée avec succès |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getRoleById**
> RoleResponseDTO getRoleById()

Retourne les détails d\'un rôle spécifique

### Example

```typescript
import {
    RlesApi,
    Configuration
} from './api';

const configuration = new Configuration();
const apiInstance = new RlesApi(configuration);

let id: number; // (default to undefined)

const { status, data } = await apiInstance.getRoleById(
    id
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**number**] |  | defaults to undefined|


### Return type

**RoleResponseDTO**

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Rôle trouvé |  -  |
|**404** | Rôle non trouvé |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **softDeleteRole**
> softDeleteRole()

Effectue une suppression logique (soft delete) d\'un rôle

### Example

```typescript
import {
    RlesApi,
    Configuration
} from './api';

const configuration = new Configuration();
const apiInstance = new RlesApi(configuration);

let id: number; // (default to undefined)

const { status, data } = await apiInstance.softDeleteRole(
    id
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**number**] |  | defaults to undefined|


### Return type

void (empty response body)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**204** | Rôle supprimé logiquement avec succès |  -  |
|**404** | Rôle non trouvé |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **updateRole**
> RoleResponseDTO updateRole(roleRequestDTO)

Met à jour les informations d\'un rôle

### Example

```typescript
import {
    RlesApi,
    Configuration,
    RoleRequestDTO
} from './api';

const configuration = new Configuration();
const apiInstance = new RlesApi(configuration);

let id: number; // (default to undefined)
let roleRequestDTO: RoleRequestDTO; //

const { status, data } = await apiInstance.updateRole(
    id,
    roleRequestDTO
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **roleRequestDTO** | **RoleRequestDTO**|  | |
| **id** | [**number**] |  | defaults to undefined|


### Return type

**RoleResponseDTO**

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Rôle mis à jour avec succès |  -  |
|**400** | Données invalides |  -  |
|**404** | Rôle non trouvé |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

