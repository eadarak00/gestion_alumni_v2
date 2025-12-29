# EtudiantRequestDTO


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**nom** | **string** | Nom de famille | [default to undefined]
**prenom** | **string** | Prénom | [default to undefined]
**email** | **string** | Adresse email | [default to undefined]
**username** | **string** | Nom d\&#39;utilisateur (optionnel) | [optional] [default to undefined]
**motDePasse** | **string** | Mot de passe | [default to undefined]
**telephone** | **string** | Numéro de téléphone (format Sénégal) | [optional] [default to undefined]
**numeroCarteEtudiant** | **string** | Numéro de carte étudiant | [default to undefined]
**niveau** | **string** | Niveau d\&#39;études | [default to undefined]
**filiere** | **string** | Filière d\&#39;études | [default to undefined]

## Example

```typescript
import { EtudiantRequestDTO } from './api';

const instance: EtudiantRequestDTO = {
    nom,
    prenom,
    email,
    username,
    motDePasse,
    telephone,
    numeroCarteEtudiant,
    niveau,
    filiere,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
