# CvResponseDTO


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **number** |  | [optional] [default to undefined]
**userId** | **number** |  | [optional] [default to undefined]
**prenom** | **string** |  | [optional] [default to undefined]
**nom** | **string** |  | [optional] [default to undefined]
**templateId** | **number** |  | [optional] [default to undefined]
**templateNom** | **string** |  | [optional] [default to undefined]
**titreProfil** | **string** |  | [optional] [default to undefined]
**telephone** | **string** |  | [optional] [default to undefined]
**email** | **string** |  | [optional] [default to undefined]
**adresse** | **string** |  | [optional] [default to undefined]
**resumeProfil** | **string** |  | [optional] [default to undefined]
**createdAt** | **string** |  | [optional] [default to undefined]
**updatedAt** | **string** |  | [optional] [default to undefined]
**formations** | [**Array&lt;FormationResponseDTO&gt;**](FormationResponseDTO.md) |  | [optional] [default to undefined]
**experiences** | [**Array&lt;ExperienceResponseDTO&gt;**](ExperienceResponseDTO.md) |  | [optional] [default to undefined]
**competences** | [**Array&lt;CompetenceResponseDTO&gt;**](CompetenceResponseDTO.md) |  | [optional] [default to undefined]
**langues** | [**Array&lt;LangueResponseDTO&gt;**](LangueResponseDTO.md) |  | [optional] [default to undefined]
**interets** | [**Array&lt;InteretResponseDTO&gt;**](InteretResponseDTO.md) |  | [optional] [default to undefined]

## Example

```typescript
import { CvResponseDTO } from './api';

const instance: CvResponseDTO = {
    id,
    userId,
    prenom,
    nom,
    templateId,
    templateNom,
    titreProfil,
    telephone,
    email,
    adresse,
    resumeProfil,
    createdAt,
    updatedAt,
    formations,
    experiences,
    competences,
    langues,
    interets,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
