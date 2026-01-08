# TokenResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**accessToken** | **string** | Token JWT d\&#39;accès | [optional] [default to undefined]
**refreshToken** | **string** | Token de rafraîchissement | [optional] [default to undefined]
**tokenType** | **string** | Type de token | [optional] [default to 'Bearer']
**expiresInSeconds** | **number** | Durée de validité du token en secondes | [optional] [default to undefined]

## Example

```typescript
import { TokenResponse } from './api';

const instance: TokenResponse = {
    accessToken,
    refreshToken,
    tokenType,
    expiresInSeconds,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
