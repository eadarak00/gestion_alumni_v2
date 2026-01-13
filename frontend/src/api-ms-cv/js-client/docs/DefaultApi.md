# DefaultApi

All URIs are relative to *http://localhost:8072/api-ms-cv2/v1*

|Method | HTTP request | Description|
|------------- | ------------- | -------------|
|[**createCv**](#createcv) | **POST** /cvs | Create a new CV|
|[**createTemplate**](#createtemplate) | **POST** /templates | Create a new template|
|[**deleteCv**](#deletecv) | **DELETE** /cvs/{id} | Delete a CV|
|[**deleteTemplate**](#deletetemplate) | **DELETE** /templates/{id} | Delete a template|
|[**downloadCvPdf**](#downloadcvpdf) | **GET** /cvs/{id}/pdf | Download CV as PDF|
|[**getAllTemplates**](#getalltemplates) | **GET** /templates | Get all templates|
|[**getCvById**](#getcvbyid) | **GET** /cvs/{id} | Get CV by ID|
|[**getMyCvs**](#getmycvs) | **GET** /cvs/me | Get My CVs|
|[**getTemplateById**](#gettemplatebyid) | **GET** /templates/{id} | Get template by ID|
|[**updateCv**](#updatecv) | **PUT** /cvs/{id} | Update a CV|
|[**updateTemplate**](#updatetemplate) | **PUT** /templates/{id} | Update a template|

# **createCv**
> CvResponseDTO createCv(cvRequestDTO)


### Example

```typescript
import {
    DefaultApi,
    Configuration,
    CvRequestDTO
} from './api';

const configuration = new Configuration();
const apiInstance = new DefaultApi(configuration);

let cvRequestDTO: CvRequestDTO; //

const { status, data } = await apiInstance.createCv(
    cvRequestDTO
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **cvRequestDTO** | **CvRequestDTO**|  | |


### Return type

**CvResponseDTO**

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**201** | CV created successfully |  -  |
|**401** | Unauthorized |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **createTemplate**
> TemplateResponseDTO createTemplate(templateRequestDTO)


### Example

```typescript
import {
    DefaultApi,
    Configuration,
    TemplateRequestDTO
} from './api';

const configuration = new Configuration();
const apiInstance = new DefaultApi(configuration);

let templateRequestDTO: TemplateRequestDTO; //

const { status, data } = await apiInstance.createTemplate(
    templateRequestDTO
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **templateRequestDTO** | **TemplateRequestDTO**|  | |


### Return type

**TemplateResponseDTO**

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**201** | Template created successfully |  -  |
|**401** | Unauthorized |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **deleteCv**
> deleteCv()


### Example

```typescript
import {
    DefaultApi,
    Configuration
} from './api';

const configuration = new Configuration();
const apiInstance = new DefaultApi(configuration);

let id: number; // (default to undefined)

const { status, data } = await apiInstance.deleteCv(
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
|**204** | CV deleted successfully |  -  |
|**401** | Unauthorized |  -  |
|**404** | CV not found |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **deleteTemplate**
> deleteTemplate()


### Example

```typescript
import {
    DefaultApi,
    Configuration
} from './api';

const configuration = new Configuration();
const apiInstance = new DefaultApi(configuration);

let id: number; // (default to undefined)

const { status, data } = await apiInstance.deleteTemplate(
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
|**204** | Template deleted successfully |  -  |
|**401** | Unauthorized |  -  |
|**404** | Template not found |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **downloadCvPdf**
> File downloadCvPdf()


### Example

```typescript
import {
    DefaultApi,
    Configuration
} from './api';

const configuration = new Configuration();
const apiInstance = new DefaultApi(configuration);

let id: number; // (default to undefined)

const { status, data } = await apiInstance.downloadCvPdf(
    id
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**number**] |  | defaults to undefined|


### Return type

**File**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/pdf


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | PDF file |  -  |
|**404** | CV not found |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getAllTemplates**
> Array<TemplateResponseDTO> getAllTemplates()


### Example

```typescript
import {
    DefaultApi,
    Configuration
} from './api';

const configuration = new Configuration();
const apiInstance = new DefaultApi(configuration);

const { status, data } = await apiInstance.getAllTemplates();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**Array<TemplateResponseDTO>**

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | List of templates |  -  |
|**401** | Unauthorized |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getCvById**
> CvResponseDTO getCvById()


### Example

```typescript
import {
    DefaultApi,
    Configuration
} from './api';

const configuration = new Configuration();
const apiInstance = new DefaultApi(configuration);

let id: number; // (default to undefined)

const { status, data } = await apiInstance.getCvById(
    id
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**number**] |  | defaults to undefined|


### Return type

**CvResponseDTO**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | CV found |  -  |
|**404** | CV not found |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getMyCvs**
> Array<CvResponseDTO> getMyCvs()


### Example

```typescript
import {
    DefaultApi,
    Configuration
} from './api';

const configuration = new Configuration();
const apiInstance = new DefaultApi(configuration);

const { status, data } = await apiInstance.getMyCvs();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**Array<CvResponseDTO>**

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | List of user\&#39;s CVs |  -  |
|**401** | Unauthorized |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getTemplateById**
> TemplateResponseDTO getTemplateById()


### Example

```typescript
import {
    DefaultApi,
    Configuration
} from './api';

const configuration = new Configuration();
const apiInstance = new DefaultApi(configuration);

let id: number; // (default to undefined)

const { status, data } = await apiInstance.getTemplateById(
    id
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**number**] |  | defaults to undefined|


### Return type

**TemplateResponseDTO**

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Template found |  -  |
|**401** | Unauthorized |  -  |
|**404** | Template not found |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **updateCv**
> CvResponseDTO updateCv(cvRequestDTO)


### Example

```typescript
import {
    DefaultApi,
    Configuration,
    CvRequestDTO
} from './api';

const configuration = new Configuration();
const apiInstance = new DefaultApi(configuration);

let id: number; // (default to undefined)
let cvRequestDTO: CvRequestDTO; //

const { status, data } = await apiInstance.updateCv(
    id,
    cvRequestDTO
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **cvRequestDTO** | **CvRequestDTO**|  | |
| **id** | [**number**] |  | defaults to undefined|


### Return type

**CvResponseDTO**

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | CV updated successfully |  -  |
|**401** | Unauthorized |  -  |
|**404** | CV not found |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **updateTemplate**
> TemplateResponseDTO updateTemplate(templateRequestDTO)


### Example

```typescript
import {
    DefaultApi,
    Configuration,
    TemplateRequestDTO
} from './api';

const configuration = new Configuration();
const apiInstance = new DefaultApi(configuration);

let id: number; // (default to undefined)
let templateRequestDTO: TemplateRequestDTO; //

const { status, data } = await apiInstance.updateTemplate(
    id,
    templateRequestDTO
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **templateRequestDTO** | **TemplateRequestDTO**|  | |
| **id** | [**number**] |  | defaults to undefined|


### Return type

**TemplateResponseDTO**

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Template updated successfully |  -  |
|**401** | Unauthorized |  -  |
|**404** | Template not found |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

