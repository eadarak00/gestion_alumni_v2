# CvRequestDTO


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**templateId** | **number** |  | [default to undefined]
**titreProfil** | **string** |  | [optional] [default to undefined]
**telephone** | **string** |  | [optional] [default to undefined]
**email** | **string** |  | [optional] [default to undefined]
**nom** | **string** |  | [optional] [default to undefined]
**prenom** | **string** |  | [optional] [default to undefined]
**adresse** | **string** |  | [optional] [default to undefined]
**resumeProfil** | **string** |  | [optional] [default to undefined]
**formations** | [**Array&lt;FormationDTO&gt;**](FormationDTO.md) |  | [optional] [default to undefined]
**experiences** | [**Array&lt;ExperienceDTO&gt;**](ExperienceDTO.md) |  | [optional] [default to undefined]
**competences** | [**Array&lt;CompetenceDTO&gt;**](CompetenceDTO.md) |  | [optional] [default to undefined]
**langues** | [**Array&lt;LangueDTO&gt;**](LangueDTO.md) |  | [optional] [default to undefined]
**interets** | [**Array&lt;InteretDTO&gt;**](InteretDTO.md) |  | [optional] [default to undefined]

## Example

```typescript
import { CvRequestDTO } from './api';

const instance: CvRequestDTO = {
    templateId,
    titreProfil,
    telephone,
    email,
    nom,
    prenom,
    adresse,
    resumeProfil,
    formations,
    experiences,
    competences,
    langues,
    interets,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
