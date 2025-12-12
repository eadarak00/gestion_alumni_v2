# MsUserApiDeGestionDesUtilisateurs.UtilisateursApi

All URIs are relative to *http://localhost:8081/api/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**emailExists**](UtilisateursApi.md#emailExists) | **GET** /utilisateurs/exists/email/{email} | Vérifier si un email existe
[**getAllUtilisateursFiltered**](UtilisateursApi.md#getAllUtilisateursFiltered) | **GET** /utilisateurs | Lister et filtrer les utilisateurs
[**getUtilisateurByEmail**](UtilisateursApi.md#getUtilisateurByEmail) | **GET** /utilisateurs/email/{email} | Récupérer un utilisateur par email
[**searchAlumni**](UtilisateursApi.md#searchAlumni) | **GET** /alumni/search | Recherche avancée des alumni
[**usernameExists**](UtilisateursApi.md#usernameExists) | **GET** /utilisateurs/exists/username/{username} | Vérifier si un username existe



## emailExists

> Boolean emailExists(email)

Vérifier si un email existe

Vérifie si un email est déjà utilisé dans le système

### Example

```javascript
import MsUserApiDeGestionDesUtilisateurs from 'ms_user_api_de_gestion_des_utilisateurs';
let defaultClient = MsUserApiDeGestionDesUtilisateurs.ApiClient.instance;
// Configure Bearer (JWT) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new MsUserApiDeGestionDesUtilisateurs.UtilisateursApi();
let email = "email_example"; // String | 
apiInstance.emailExists(email, (error, data, response) => {
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
 **email** | **String**|  | 

### Return type

**Boolean**

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## getAllUtilisateursFiltered

> GetAllUtilisateursFiltered200Response getAllUtilisateursFiltered(opts)

Lister et filtrer les utilisateurs

Permet de lister les utilisateurs avec pagination, filtre par actif et filtre par suppression (soft delete). 

### Example

```javascript
import MsUserApiDeGestionDesUtilisateurs from 'ms_user_api_de_gestion_des_utilisateurs';
let defaultClient = MsUserApiDeGestionDesUtilisateurs.ApiClient.instance;
// Configure Bearer (JWT) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new MsUserApiDeGestionDesUtilisateurs.UtilisateursApi();
let opts = {
  'actif': true, // Boolean | Filtre sur l'état d'activation du compte
  'deleted': false, // Boolean | Filtre sur l'état de suppression logique (soft delete)
  'page': 0, // Number | 
  'size': 10, // Number | 
  'sort': "nom,asc" // String | Format: champ,ordre (asc|desc)
};
apiInstance.getAllUtilisateursFiltered(opts, (error, data, response) => {
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
 **actif** | **Boolean**| Filtre sur l&#39;état d&#39;activation du compte | [optional] 
 **deleted** | **Boolean**| Filtre sur l&#39;état de suppression logique (soft delete) | [optional] 
 **page** | **Number**|  | [optional] 
 **size** | **Number**|  | [optional] 
 **sort** | **String**| Format: champ,ordre (asc|desc) | [optional] 

### Return type

[**GetAllUtilisateursFiltered200Response**](GetAllUtilisateursFiltered200Response.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## getUtilisateurByEmail

> UtilisateurResponseDTO getUtilisateurByEmail(email)

Récupérer un utilisateur par email

Retourne les informations d&#39;un utilisateur par son email

### Example

```javascript
import MsUserApiDeGestionDesUtilisateurs from 'ms_user_api_de_gestion_des_utilisateurs';
let defaultClient = MsUserApiDeGestionDesUtilisateurs.ApiClient.instance;
// Configure Bearer (JWT) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new MsUserApiDeGestionDesUtilisateurs.UtilisateursApi();
let email = "email_example"; // String | 
apiInstance.getUtilisateurByEmail(email, (error, data, response) => {
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
 **email** | **String**|  | 

### Return type

[**UtilisateurResponseDTO**](UtilisateurResponseDTO.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## searchAlumni

> [AlumniResponseDTO] searchAlumni(opts)

Recherche avancée des alumni

Permet de rechercher des alumni à l&#39;aide de filtres optionnels par entreprise et profession. 

### Example

```javascript
import MsUserApiDeGestionDesUtilisateurs from 'ms_user_api_de_gestion_des_utilisateurs';
let defaultClient = MsUserApiDeGestionDesUtilisateurs.ApiClient.instance;
// Configure Bearer (JWT) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new MsUserApiDeGestionDesUtilisateurs.UtilisateursApi();
let opts = {
  'entreprise': "entreprise_example", // String | Nom de l'entreprise actuelle de l'alumni
  'profession': "profession_example", // String | Profession actuelle de l'alumni (ex: Data Scientist, Médecin...)
  'nom': "nom_example", // String | Le nom de l'Alumni (ex: THIAM, DIOP...) 
  'prenom': "prenom_example" // String | Le prenom de l'Alumni (ex: Khoutbou, Ibrahima...) 
};
apiInstance.searchAlumni(opts, (error, data, response) => {
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
 **entreprise** | **String**| Nom de l&#39;entreprise actuelle de l&#39;alumni | [optional] 
 **profession** | **String**| Profession actuelle de l&#39;alumni (ex: Data Scientist, Médecin...) | [optional] 
 **nom** | **String**| Le nom de l&#39;Alumni (ex: THIAM, DIOP...)  | [optional] 
 **prenom** | **String**| Le prenom de l&#39;Alumni (ex: Khoutbou, Ibrahima...)  | [optional] 

### Return type

[**[AlumniResponseDTO]**](AlumniResponseDTO.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## usernameExists

> Boolean usernameExists(username)

Vérifier si un username existe

Vérifie si un username est déjà utilisé dans le système

### Example

```javascript
import MsUserApiDeGestionDesUtilisateurs from 'ms_user_api_de_gestion_des_utilisateurs';
let defaultClient = MsUserApiDeGestionDesUtilisateurs.ApiClient.instance;
// Configure Bearer (JWT) access token for authorization: bearerAuth
let bearerAuth = defaultClient.authentications['bearerAuth'];
bearerAuth.accessToken = "YOUR ACCESS TOKEN"

let apiInstance = new MsUserApiDeGestionDesUtilisateurs.UtilisateursApi();
let username = "username_example"; // String | 
apiInstance.usernameExists(username, (error, data, response) => {
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
 **username** | **String**|  | 

### Return type

**Boolean**

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

