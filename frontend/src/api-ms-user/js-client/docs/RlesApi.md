# MsUserApiDeGestionDesUtilisateurs.RlesApi

All URIs are relative to *http://localhost:8081/api/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createRole**](RlesApi.md#createRole) | **POST** /roles | Créer un nouveau rôle
[**getAllRoles**](RlesApi.md#getAllRoles) | **GET** /roles | Récupérer tous les rôles
[**getRoleById**](RlesApi.md#getRoleById) | **GET** /roles/{id} | Récupérer un rôle par son ID
[**softDeleteRole**](RlesApi.md#softDeleteRole) | **DELETE** /roles/{id} | Supprimer logiquement un rôle
[**updateRole**](RlesApi.md#updateRole) | **PUT** /roles/{id} | Mettre à jour un rôle existant



## createRole

> RoleResponseDTO createRole(roleRequestDTO)

Créer un nouveau rôle

Crée un nouveau rôle dans le système

### Example

```javascript
import MsUserApiDeGestionDesUtilisateurs from 'ms_user_api_de_gestion_des_utilisateurs';
let defaultClient = MsUserApiDeGestionDesUtilisateurs.ApiClient.instance;
// Configure Bearer (JWT) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new MsUserApiDeGestionDesUtilisateurs.RlesApi();
let roleRequestDTO = new MsUserApiDeGestionDesUtilisateurs.RoleRequestDTO(); // RoleRequestDTO | 
apiInstance.createRole(roleRequestDTO, (error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
});
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **roleRequestDTO** | [**RoleRequestDTO**](RoleRequestDTO.md)|  | 

### Return type

[**RoleResponseDTO**](RoleResponseDTO.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## getAllRoles

> [RoleResponseDTO] getAllRoles()

Récupérer tous les rôles

Retourne la liste de tous les rôles disponibles dans le système

### Example

```javascript
import MsUserApiDeGestionDesUtilisateurs from 'ms_user_api_de_gestion_des_utilisateurs';
let defaultClient = MsUserApiDeGestionDesUtilisateurs.ApiClient.instance;
// Configure Bearer (JWT) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new MsUserApiDeGestionDesUtilisateurs.RlesApi();
apiInstance.getAllRoles((error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
});
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**[RoleResponseDTO]**](RoleResponseDTO.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## getRoleById

> RoleResponseDTO getRoleById(id)

Récupérer un rôle par son ID

Retourne les détails d&#39;un rôle spécifique

### Example

```javascript
import MsUserApiDeGestionDesUtilisateurs from 'ms_user_api_de_gestion_des_utilisateurs';
let defaultClient = MsUserApiDeGestionDesUtilisateurs.ApiClient.instance;
// Configure Bearer (JWT) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new MsUserApiDeGestionDesUtilisateurs.RlesApi();
let id = 789; // Number | 
apiInstance.getRoleById(id, (error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
});
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Number**|  | 

### Return type

[**RoleResponseDTO**](RoleResponseDTO.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## softDeleteRole

> softDeleteRole(id)

Supprimer logiquement un rôle

Effectue une suppression logique (soft delete) d&#39;un rôle

### Example

```javascript
import MsUserApiDeGestionDesUtilisateurs from 'ms_user_api_de_gestion_des_utilisateurs';
let defaultClient = MsUserApiDeGestionDesUtilisateurs.ApiClient.instance;
// Configure Bearer (JWT) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new MsUserApiDeGestionDesUtilisateurs.RlesApi();
let id = 789; // Number | 
apiInstance.softDeleteRole(id, (error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully.');
  }
});
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Number**|  | 

### Return type

null (empty response body)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


## updateRole

> RoleResponseDTO updateRole(id, roleRequestDTO)

Mettre à jour un rôle existant

Met à jour les informations d&#39;un rôle

### Example

```javascript
import MsUserApiDeGestionDesUtilisateurs from 'ms_user_api_de_gestion_des_utilisateurs';
let defaultClient = MsUserApiDeGestionDesUtilisateurs.ApiClient.instance;
// Configure Bearer (JWT) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new MsUserApiDeGestionDesUtilisateurs.RlesApi();
let id = 789; // Number | 
let roleRequestDTO = new MsUserApiDeGestionDesUtilisateurs.RoleRequestDTO(); // RoleRequestDTO | 
apiInstance.updateRole(id, roleRequestDTO, (error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
});
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Number**|  | 
 **roleRequestDTO** | [**RoleRequestDTO**](RoleRequestDTO.md)|  | 

### Return type

[**RoleResponseDTO**](RoleResponseDTO.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

