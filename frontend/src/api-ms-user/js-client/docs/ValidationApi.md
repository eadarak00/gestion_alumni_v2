# MsUserApiDeGestionDesUtilisateurs.ValidationApi

All URIs are relative to *http://localhost:8081/api/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**envoyerCode**](ValidationApi.md#envoyerCode) | **POST** /validation/envoyer | Envoyer un code de validation
[**verifierCode**](ValidationApi.md#verifierCode) | **POST** /validation/verifier | Vérifier un code de validation



## envoyerCode

> envoyerCode(codeValidationRequestDTO)

Envoyer un code de validation

Génère et envoie un code de validation par email

### Example

```javascript
import MsUserApiDeGestionDesUtilisateurs from 'ms_user_api_de_gestion_des_utilisateurs';

let apiInstance = new MsUserApiDeGestionDesUtilisateurs.ValidationApi();
let codeValidationRequestDTO = new MsUserApiDeGestionDesUtilisateurs.CodeValidationRequestDTO(); // CodeValidationRequestDTO | 
apiInstance.envoyerCode(codeValidationRequestDTO, (error, data, response) => {
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
 **codeValidationRequestDTO** | [**CodeValidationRequestDTO**](CodeValidationRequestDTO.md)|  | 

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: Not defined


## verifierCode

> String verifierCode(codeValidationCheckDTO)

Vérifier un code de validation

Valide un code fourni par l&#39;utilisateur

### Example

```javascript
import MsUserApiDeGestionDesUtilisateurs from 'ms_user_api_de_gestion_des_utilisateurs';

let apiInstance = new MsUserApiDeGestionDesUtilisateurs.ValidationApi();
let codeValidationCheckDTO = new MsUserApiDeGestionDesUtilisateurs.CodeValidationCheckDTO(); // CodeValidationCheckDTO | 
apiInstance.verifierCode(codeValidationCheckDTO, (error, data, response) => {
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
 **codeValidationCheckDTO** | [**CodeValidationCheckDTO**](CodeValidationCheckDTO.md)|  | 

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

