# MsUserApiDeGestionDesUtilisateurs.AuthentificationApi

All URIs are relative to *http://localhost:8081/api/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**inscrire**](AuthentificationApi.md#inscrire) | **POST** /auth/inscrire | Inscrire un nouvel Utilisateur
[**login**](AuthentificationApi.md#login) | **POST** /auth/connecter | Connexion utilisateur
[**logout**](AuthentificationApi.md#logout) | **POST** /auth/deconnecter | Déconnexion utilisateur
[**refresh**](AuthentificationApi.md#refresh) | **POST** /auth/refresh | Rafraîchir le token JWT



## inscrire

> UtilisateurResponseDTO inscrire(utilisateurRequestDTO)

Inscrire un nouvel Utilisateur

Crée un nouveau compte utilisateur

### Example

```javascript
import MsUserApiDeGestionDesUtilisateurs from 'ms_user_api_de_gestion_des_utilisateurs';

let apiInstance = new MsUserApiDeGestionDesUtilisateurs.AuthentificationApi();
let utilisateurRequestDTO = new MsUserApiDeGestionDesUtilisateurs.UtilisateurRequestDTO(); // UtilisateurRequestDTO | 
apiInstance.inscrire(utilisateurRequestDTO, (error, data, response) => {
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
 **utilisateurRequestDTO** | [**UtilisateurRequestDTO**](UtilisateurRequestDTO.md)|  | 

### Return type

[**UtilisateurResponseDTO**](UtilisateurResponseDTO.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## login

> TokenResponse login(loginRequest)

Connexion utilisateur

Authentifie un utilisateur et retourne un token JWT

### Example

```javascript
import MsUserApiDeGestionDesUtilisateurs from 'ms_user_api_de_gestion_des_utilisateurs';

let apiInstance = new MsUserApiDeGestionDesUtilisateurs.AuthentificationApi();
let loginRequest = new MsUserApiDeGestionDesUtilisateurs.LoginRequest(); // LoginRequest | 
apiInstance.login(loginRequest, (error, data, response) => {
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
 **loginRequest** | [**LoginRequest**](LoginRequest.md)|  | 

### Return type

[**TokenResponse**](TokenResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## logout

> logout(refreshRequest)

Déconnexion utilisateur

Déconnecte l&#39;utilisateur et invalide le refresh token

### Example

```javascript
import MsUserApiDeGestionDesUtilisateurs from 'ms_user_api_de_gestion_des_utilisateurs';

let apiInstance = new MsUserApiDeGestionDesUtilisateurs.AuthentificationApi();
let refreshRequest = new MsUserApiDeGestionDesUtilisateurs.RefreshRequest(); // RefreshRequest | 
apiInstance.logout(refreshRequest, (error, data, response) => {
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
 **refreshRequest** | [**RefreshRequest**](RefreshRequest.md)|  | 

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: Not defined


## refresh

> TokenResponse refresh(refreshRequest)

Rafraîchir le token JWT

Permet de renouveler un token JWT expiré en utilisant le refresh token

### Example

```javascript
import MsUserApiDeGestionDesUtilisateurs from 'ms_user_api_de_gestion_des_utilisateurs';

let apiInstance = new MsUserApiDeGestionDesUtilisateurs.AuthentificationApi();
let refreshRequest = new MsUserApiDeGestionDesUtilisateurs.RefreshRequest(); // RefreshRequest | 
apiInstance.refresh(refreshRequest, (error, data, response) => {
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
 **refreshRequest** | [**RefreshRequest**](RefreshRequest.md)|  | 

### Return type

[**TokenResponse**](TokenResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

