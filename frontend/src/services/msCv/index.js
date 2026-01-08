import {
  Configuration,
  CVsApi,
  ExperiencesApi,
  FormationsApi,
  CompetencesApi,
  LanguesParleesApi,
  CertificationsApi,
} from '../../api-ms-cv/js-client'
import * as tokenManager from '../../utils/tokenManager'

let service = null

function resolveToken() {
  if (!tokenManager) return undefined
  if (typeof tokenManager.getToken === 'function') return tokenManager.getToken()
  if (tokenManager.default && typeof tokenManager.default.getToken === 'function') return tokenManager.default.getToken()
  return undefined
}

function createService(opts = {}) {
  const basePath = opts.basePath || 'http://localhost:8082/api'
  const config = new Configuration({ basePath, accessToken: resolveToken })

  const svc = {
    configuration: config,
    cvsApi: new CVsApi(config),
    experiencesApi: new ExperiencesApi(config),
    formationsApi: new FormationsApi(config),
    competencesApi: new CompetencesApi(config),
    languesParleesApi: new LanguesParleesApi(config),
    certificationsApi: new CertificationsApi(config),
    basePath,
  }

  service = svc
  return svc
}

export function configureService(opts = {}) {
  if (!service) return createService(opts)
  if (opts.basePath) service.basePath = opts.basePath
  return service
}

export function getService() {
  if (!service) service = createService()
  return service
}

export function resetService() {
  service = null
}

export default getService
