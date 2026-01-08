API client TypeScript (axios) généré pour le service CV.

Utilisation rapide:

```ts
import { ApiClient, CVsApi } from './api-ms-cv/js-client';

const client = new ApiClient({ basePath: 'http://localhost:8082/api', getAccessToken: () => '' });
const cvs = new CVsApi(client);

// Exemple: lister tous les CVs
cvs.getAllCVs().then(list => console.log(list));
```

Regénérer: maintenir `frontend/src/api-ms-cv/ms-cv.yaml` à jour puis regénérer avec OpenAPI Generator si vous préférez la sortie officielle.
