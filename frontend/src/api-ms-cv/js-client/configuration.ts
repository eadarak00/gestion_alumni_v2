import axios, { AxiosInstance } from 'axios';

export interface Configuration {
  basePath?: string;
  getAccessToken?: () => string | Promise<string>;
  headers?: Record<string, string>;
}

export const DEFAULT_BASE_PATH = 'http://localhost:8082/api';

export class ApiClient {
  axios: AxiosInstance;
  constructor(public config: Configuration = {}) {
    this.axios = axios.create({ baseURL: config.basePath || DEFAULT_BASE_PATH, headers: config.headers });
  }

  async request<T>(opts: { method: 'get' | 'post' | 'put' | 'delete' | 'patch'; path: string; data?: any; params?: any; headers?: Record<string, string> }): Promise<T> {
    const token = this.config.getAccessToken ? await this.config.getAccessToken() : undefined;
    const reqHeaders = { ...(opts.headers || {}), ...(token ? { Authorization: `Bearer ${token}` } : {}) };
    const resp = await this.axios.request<T>({ method: opts.method, url: opts.path, data: opts.data, params: opts.params, headers: reqHeaders });
    return resp.data as T;
  }
}
