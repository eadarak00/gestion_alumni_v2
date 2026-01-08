/* Auto-generated minimal TypeScript axios client for MS CV */
import type { ApiClient } from './configuration';

/* ===== Models / Types (from ms-cv.yaml) ===== */
export type TypeTemplate = 'MODERNE' | 'CLASSIQUE' | 'PROFESSIONNEL';
export type Langues = 'FRANCAIS' | 'ANGLAIS' | 'ESPAGNOL' | 'ALLEMAND' | 'ITALIEN' | 'PORTUGAIS' | 'ARABE' | 'CHINOIS' | 'AUTRE';
export type NiveauLangue = 'DEBUTANT' | 'INTERMEDIAIRE' | 'AVANCE' | 'COURANT' | 'NATIF';
export type NiveauCompetence = 'DEBUTANT' | 'INTERMEDIAIRE' | 'AVANCE' | 'EXPERT';
export type CategorieCompetence = 'TECHNIQUE' | 'LINGUISTIQUE' | 'SOFT_SKILLS' | 'AUTRE';

export interface CVRequest {
  titre: string;
  resume?: string;
  photo?: string;
  linkedin?: string;
  github?: string;
  portfolio?: string;
  telephone: string;
  email: string;
  adresse?: string;
  utilisateurId: number;
  template?: TypeTemplate;
}

export interface CVResponse {
  id?: number;
  titre?: string;
  resume?: string;
  photo?: string;
  linkedin?: string;
  github?: string;
  portfolio?: string;
  telephone?: string;
  email?: string;
  adresse?: string;
  utilisateurId?: number;
  template?: TypeTemplate;
  dateCreation?: string;
  dateDerniereModification?: string;
}

export interface CVCompletResponse extends CVResponse {
  experiences?: ExperienceResponse[];
  formations?: FormationResponse[];
  competences?: CompetenceResponse[];
  languesParlees?: LangueParleesResponse[];
  certifications?: CertificationResponse[];
}

export interface ExperienceRequest {
  cvId: number;
  poste: string;
  entreprise: string;
  localisation?: string;
  dateDebut: string;
  dateFin?: string;
  enCours?: boolean;
  description?: string;
}

export interface ExperienceResponse {
  id?: number;
  cvId?: number;
  poste?: string;
  entreprise?: string;
  localisation?: string;
  dateDebut?: string;
  dateFin?: string;
  enCours?: boolean;
  description?: string;
  dateCreation?: string;
  dateDerniereModification?: string;
}

export interface FormationRequest {
  cvId: number;
  diplome: string;
  etablissement: string;
  localisation?: string;
  dateDebut: string;
  dateFin?: string;
  enCours?: boolean;
  description?: string;
}

export interface FormationResponse {
  id?: number;
  cvId?: number;
  diplome?: string;
  etablissement?: string;
  localisation?: string;
  dateDebut?: string;
  dateFin?: string;
  enCours?: boolean;
  description?: string;
  dateCreation?: string;
  dateDerniereModification?: string;
}

export interface CompetenceRequest {
  cvId: number;
  nom: string;
  niveau: NiveauCompetence;
  categorie?: CategorieCompetence;
}

export interface CompetenceResponse {
  id?: number;
  cvId?: number;
  nom?: string;
  niveau?: NiveauCompetence;
  categorie?: CategorieCompetence;
  dateCreation?: string;
  dateDerniereModification?: string;
}

export interface LangueParleesRequest {
  cvId: number;
  langue: Langues;
  niveau: NiveauLangue;
}

export interface LangueParleesResponse {
  id?: number;
  cvId?: number;
  langue?: Langues;
  niveau?: NiveauLangue;
  dateCreation?: string;
  dateDerniereModification?: string;
}

export interface CertificationRequest {
  cvId: number;
  nom: string;
  organisme: string;
  dateObtention: string;
  dateExpiration?: string;
  numeroCredential?: string;
  urlVerification?: string;
}

export interface CertificationResponse {
  id?: number;
  cvId?: number;
  nom?: string;
  organisme?: string;
  dateObtention?: string;
  dateExpiration?: string;
  numeroCredential?: string;
  urlVerification?: string;
  dateCreation?: string;
  dateDerniereModification?: string;
}

export interface PageResponseCVResponse {
  content?: CVResponse[];
  pageNumber?: number;
  pageSize?: number;
  totalElements?: number;
  totalPages?: number;
  last?: boolean;
  first?: boolean;
}

export interface ErrorResponse {
  timestamp?: string;
  status?: number;
  error?: string;
  code?: string;
  message?: string;
  path?: string;
  validationErrors?: Array<{ field?: string; message?: string }>;
}

/* ===== API classes ===== */
export class CVsApi {
  constructor(private client: ApiClient) {}

  creerCV(body: CVRequest): Promise<CVResponse> {
    return this.client.request<CVResponse>({ method: 'post', path: `/cvs`, data: body });
  }

  getAllCVs(): Promise<CVResponse[]> {
    return this.client.request<CVResponse[]>({ method: 'get', path: `/cvs` });
  }

  getAllCVsPage(params?: { page?: number; size?: number; sortBy?: string; direction?: 'ASC' | 'DESC' }): Promise<PageResponseCVResponse> {
    return this.client.request<PageResponseCVResponse>({ method: 'get', path: `/cvs/page`, params });
  }

  getCVById(id: number): Promise<CVResponse> {
    return this.client.request<CVResponse>({ method: 'get', path: `/cvs/${id}` });
  }

  updateCV(id: number, body: CVRequest): Promise<CVResponse> {
    return this.client.request<CVResponse>({ method: 'put', path: `/cvs/${id}`, data: body });
  }

  supprimerCV(id: number): Promise<void> {
    return this.client.request<void>({ method: 'delete', path: `/cvs/${id}` });
  }

  getCVComplet(id: number): Promise<CVCompletResponse> {
    return this.client.request<CVCompletResponse>({ method: 'get', path: `/cvs/${id}/complet` });
  }

  getCVByIdAndUtilisateur(id: number, utilisateurId: number): Promise<CVResponse> {
    return this.client.request<CVResponse>({ method: 'get', path: `/cvs/${id}/utilisateur/${utilisateurId}` });
  }

  getCVsByUtilisateur(utilisateurId: number): Promise<CVResponse[]> {
    return this.client.request<CVResponse[]>({ method: 'get', path: `/cvs/utilisateur/${utilisateurId}` });
  }
}

export class ExperiencesApi {
  constructor(private client: ApiClient) {}

  creerExperience(body: ExperienceRequest): Promise<ExperienceResponse> {
    return this.client.request<ExperienceResponse>({ method: 'post', path: `/experiences`, data: body });
  }

  getExperienceById(id: number): Promise<ExperienceResponse> {
    return this.client.request<ExperienceResponse>({ method: 'get', path: `/experiences/${id}` });
  }

  updateExperience(id: number, body: ExperienceRequest): Promise<ExperienceResponse> {
    return this.client.request<ExperienceResponse>({ method: 'put', path: `/experiences/${id}`, data: body });
  }

  supprimerExperience(id: number): Promise<void> {
    return this.client.request<void>({ method: 'delete', path: `/experiences/${id}` });
  }

  getExperienceByIdAndCvId(id: number, cvId: number): Promise<ExperienceResponse> {
    return this.client.request<ExperienceResponse>({ method: 'get', path: `/experiences/${id}/cv/${cvId}` });
  }

  getExperiencesByCvId(cvId: number): Promise<ExperienceResponse[]> {
    return this.client.request<ExperienceResponse[]>({ method: 'get', path: `/experiences/cv/${cvId}` });
  }

  getExperiencesEnCours(cvId: number): Promise<ExperienceResponse[]> {
    return this.client.request<ExperienceResponse[]>({ method: 'get', path: `/experiences/cv/${cvId}/en-cours` });
  }
}

export class FormationsApi {
  constructor(private client: ApiClient) {}

  creerFormation(body: FormationRequest): Promise<FormationResponse> {
    return this.client.request<FormationResponse>({ method: 'post', path: `/formations`, data: body });
  }

  getFormationById(id: number): Promise<FormationResponse> {
    return this.client.request<FormationResponse>({ method: 'get', path: `/formations/${id}` });
  }

  updateFormation(id: number, body: FormationRequest): Promise<FormationResponse> {
    return this.client.request<FormationResponse>({ method: 'put', path: `/formations/${id}`, data: body });
  }

  supprimerFormation(id: number): Promise<void> {
    return this.client.request<void>({ method: 'delete', path: `/formations/${id}` });
  }

  getFormationByIdAndCvId(id: number, cvId: number): Promise<FormationResponse> {
    return this.client.request<FormationResponse>({ method: 'get', path: `/formations/${id}/cv/${cvId}` });
  }

  getFormationsByCvId(cvId: number): Promise<FormationResponse[]> {
    return this.client.request<FormationResponse[]>({ method: 'get', path: `/formations/cv/${cvId}` });
  }

  getFormationsEnCours(cvId: number): Promise<FormationResponse[]> {
    return this.client.request<FormationResponse[]>({ method: 'get', path: `/formations/cv/${cvId}/en-cours` });
  }
}

export class CompetencesApi {
  constructor(private client: ApiClient) {}

  creerCompetence(body: CompetenceRequest): Promise<CompetenceResponse> {
    return this.client.request<CompetenceResponse>({ method: 'post', path: `/competences`, data: body });
  }

  getCompetenceById(id: number): Promise<CompetenceResponse> {
    return this.client.request<CompetenceResponse>({ method: 'get', path: `/competences/${id}` });
  }

  updateCompetence(id: number, body: CompetenceRequest): Promise<CompetenceResponse> {
    return this.client.request<CompetenceResponse>({ method: 'put', path: `/competences/${id}`, data: body });
  }

  supprimerCompetence(id: number): Promise<void> {
    return this.client.request<void>({ method: 'delete', path: `/competences/${id}` });
  }

  getCompetenceByIdAndCvId(id: number, cvId: number): Promise<CompetenceResponse> {
    return this.client.request<CompetenceResponse>({ method: 'get', path: `/competences/${id}/cv/${cvId}` });
  }

  getCompetencesByCvId(cvId: number): Promise<CompetenceResponse[]> {
    return this.client.request<CompetenceResponse[]>({ method: 'get', path: `/competences/cv/${cvId}` });
  }

  getCompetencesByCategorie(cvId: number, categorie: CategorieCompetence): Promise<CompetenceResponse[]> {
    return this.client.request<CompetenceResponse[]>({ method: 'get', path: `/competences/cv/${cvId}/categorie/${categorie}` });
  }

  getCompetencesByNiveau(cvId: number, niveau: NiveauCompetence): Promise<CompetenceResponse[]> {
    return this.client.request<CompetenceResponse[]>({ method: 'get', path: `/competences/cv/${cvId}/niveau/${niveau}` });
  }
}

export class LanguesParleesApi {
  constructor(private client: ApiClient) {}

  creerLangueParlees(body: LangueParleesRequest): Promise<LangueParleesResponse> {
    return this.client.request<LangueParleesResponse>({ method: 'post', path: `/langues-parlees`, data: body });
  }

  getLangueParleesById(id: number): Promise<LangueParleesResponse> {
    return this.client.request<LangueParleesResponse>({ method: 'get', path: `/langues-parlees/${id}` });
  }

  updateLangueParlees(id: number, body: LangueParleesRequest): Promise<LangueParleesResponse> {
    return this.client.request<LangueParleesResponse>({ method: 'put', path: `/langues-parlees/${id}`, data: body });
  }

  supprimerLangueParlees(id: number): Promise<void> {
    return this.client.request<void>({ method: 'delete', path: `/langues-parlees/${id}` });
  }

  getLangueParleesByIdAndCvId(id: number, cvId: number): Promise<LangueParleesResponse> {
    return this.client.request<LangueParleesResponse>({ method: 'get', path: `/langues-parlees/${id}/cv/${cvId}` });
  }

  getLanguesParleesByCvId(cvId: number): Promise<LangueParleesResponse[]> {
    return this.client.request<LangueParleesResponse[]>({ method: 'get', path: `/langues-parlees/cv/${cvId}` });
  }

  getLanguesParleesByNiveau(cvId: number, niveau: NiveauLangue): Promise<LangueParleesResponse[]> {
    return this.client.request<LangueParleesResponse[]>({ method: 'get', path: `/langues-parlees/cv/${cvId}/niveau/${niveau}` });
  }
}

export class CertificationsApi {
  constructor(private client: ApiClient) {}

  creerCertification(body: CertificationRequest): Promise<CertificationResponse> {
    return this.client.request<CertificationResponse>({ method: 'post', path: `/certifications`, data: body });
  }

  getCertificationById(id: number): Promise<CertificationResponse> {
    return this.client.request<CertificationResponse>({ method: 'get', path: `/certifications/${id}` });
  }

  updateCertification(id: number, body: CertificationRequest): Promise<CertificationResponse> {
    return this.client.request<CertificationResponse>({ method: 'put', path: `/certifications/${id}`, data: body });
  }

  supprimerCertification(id: number): Promise<void> {
    return this.client.request<void>({ method: 'delete', path: `/certifications/${id}` });
  }

  getCertificationByIdAndCvId(id: number, cvId: number): Promise<CertificationResponse> {
    return this.client.request<CertificationResponse>({ method: 'get', path: `/certifications/${id}/cv/${cvId}` });
  }

  getCertificationsByCvId(cvId: number): Promise<CertificationResponse[]> {
    return this.client.request<CertificationResponse[]>({ method: 'get', path: `/certifications/cv/${cvId}` });
  }

  getCertificationsAvecExpiration(cvId: number): Promise<CertificationResponse[]> {
    return this.client.request<CertificationResponse[]>({ method: 'get', path: `/certifications/cv/${cvId}/avec-expiration` });
  }

  getCertificationsPermanentes(cvId: number): Promise<CertificationResponse[]> {
    return this.client.request<CertificationResponse[]>({ method: 'get', path: `/certifications/cv/${cvId}/permanentes` });
  }
}
