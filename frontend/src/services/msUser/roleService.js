// services/msUser/roleService.js
import RlesApi from '../../api-ms-user/js-client/src/api/RlesApi';
import RoleResponseDTO from '../../api-ms-user/js-client/src/model/RoleResponseDTO';

class RoleService {
  constructor() {
    this.api = new RlesApi();
    this.cache = {
      roles: null,
      mapping: null,
      timestamp: null,
      ttl: 300000 // 5 minutes en ms
    };
  }

  /**
   * Récupère tous les rôles avec cache intelligent
   * @param {boolean} forceRefresh - Force la récupération depuis l'API
   * @returns {Promise<Array<RoleResponseDTO>>}
   */
  async getAllRoles(forceRefresh = false) {
    try {
      // Vérifier le cache
      if (!forceRefresh && this.isCacheValid()) {
        console.log('[RoleService] Retour depuis cache');
        return this.cache.roles;
      }

      console.log('[RoleService] Récupération depuis API');
      
      // Utiliser la méthode générée par OpenAPI
      return new Promise((resolve, reject) => {
        this.api.getAllRoles((error, data, response) => {
          if (error) {
            console.error('[RoleService] Erreur getAllRoles:', error);
            reject(error);
            return;
          }
          
          // Valider les données avec le DTO
          if (data && Array.isArray(data)) {
            // Convertir en instances de RoleResponseDTO
            const roles = data.map(roleData => 
              RoleResponseDTO.constructFromObject(roleData)
            );
            
            // Mettre à jour le cache
            this.updateCache(roles);
            
            resolve(roles);
          } else {
            reject(new Error('Format de réponse invalide'));
          }
        });
      });
      
    } catch (error) {
      console.error('[RoleService] Erreur getAllRoles:', error);
      
      // Fallback au cache même expiré
      if (this.cache.roles) {
        console.warn('[RoleService] Utilisation du cache expiré');
        return this.cache.roles;
      }
      
      throw error;
    }
  }

  /**
   * Récupère un rôle par son ID
   * @param {number} roleId 
   * @returns {Promise<RoleResponseDTO>}
   */
  async getRoleById(roleId) {
    try {
      // Vérifier d'abord dans le cache
      if (this.cache.roles) {
        const cachedRole = this.cache.roles.find(role => role.id === roleId);
        if (cachedRole) return cachedRole;
      }

      console.log(`[RoleService] Récupération rôle ${roleId} depuis API`);
      
      return new Promise((resolve, reject) => {
        this.api.getRoleById(roleId, (error, data, response) => {
          if (error) {
            console.error(`[RoleService] Erreur getRoleById ${roleId}:`, error);
            reject(error);
            return;
          }
          
          if (data) {
            const role = RoleResponseDTO.constructFromObject(data);
            
            // Ajouter au cache
            this.addToCache(role);
            
            resolve(role);
          } else {
            reject(new Error(`Rôle ${roleId} non trouvé`));
          }
        });
      });
      
    } catch (error) {
      console.error(`[RoleService] Erreur getRoleById ${roleId}:`, error);
      throw error;
    }
  }

  /**
   * Crée le mapping ID -> libellé
   * @param {boolean} forceRefresh 
   * @returns {Promise<Object>}
   */
  async getRoleMapping(forceRefresh = false) {
    try {
      if (!forceRefresh && this.cache.mapping && this.isCacheValid()) {
        return this.cache.mapping;
      }

      const roles = await this.getAllRoles(forceRefresh);
      const mapping = {};

      // Créer le mapping
      roles.forEach(role => {
        if (role.id !== undefined && role.libelle) {
          mapping[role.id] = role.libelle;
        }
      });

      // Mettre à jour le cache
      this.cache.mapping = mapping;
      
      // Sauvegarder dans localStorage pour persistance
      this.saveToLocalStorage(mapping);

      return mapping;
      
    } catch (error) {
      console.error('[RoleService] Erreur getRoleMapping:', error);
      
      // Essayer de récupérer depuis localStorage
      const savedMapping = this.loadFromLocalStorage();
      if (savedMapping) {
        console.warn('[RoleService] Utilisation mapping localStorage');
        return savedMapping;
      }
      
      // Retourner mapping vide
      return {};
    }
  }

  /**
   * Obtient le libellé d'un rôle à partir de son identifiant
   * @param {string|number} roleIdentifier 
   * @returns {Promise<string>}
   */
  async getRoleLibelle(roleIdentifier) {
    if (roleIdentifier === null || roleIdentifier === undefined) {
      return 'INCONNU';
    }

    // Si c'est déjà un libellé (non numérique), le normaliser
    if (typeof roleIdentifier === 'string' && !/^\d+$/.test(roleIdentifier)) {
      return roleIdentifier.toUpperCase();
    }

    // Convertir en nombre
    const roleId = Number(roleIdentifier);
    if (isNaN(roleId)) {
      console.warn(`[RoleService] Identifiant de rôle invalide: ${roleIdentifier}`);
      return String(roleIdentifier).toUpperCase();
    }

    try {
      const mapping = await this.getRoleMapping();
      
      // Chercher dans le mapping
      if (mapping[roleId]) {
        return mapping[roleId];
      }

      // Si non trouvé, récupérer depuis l'API
      console.log(`[RoleService] Rôle ${roleId} non trouvé dans cache, recherche API`);
      const role = await this.getRoleById(roleId);
      
      if (role && role.libelle) {
        // Mettre à jour le cache
        mapping[roleId] = role.libelle;
        this.cache.mapping = mapping;
        this.saveToLocalStorage(mapping);
        
        return role.libelle;
      }
      
      return `ROLE_${roleId}`;
      
    } catch (error) {
      console.error(`[RoleService] Erreur getRoleLibelle ${roleId}:`, error);
      return `ROLE_${roleId}`;
    }
  }

  /**
   * Synchronise les rôles avec le backend
   * @returns {Promise<Array<RoleResponseDTO>>}
   */
  async syncRoles() {
    try {
      console.log('[RoleService] Synchronisation des rôles');
      const roles = await this.getAllRoles(true); // Force refresh
      
      // Émettre un événement pour notifier du changement
      if (typeof window !== 'undefined') {
        window.dispatchEvent(new CustomEvent('roles:updated', { 
          detail: { 
            roles,
            timestamp: new Date().toISOString()
          }
        }));
      }
      
      return roles;
      
    } catch (error) {
      console.error('[RoleService] Erreur syncRoles:', error);
      throw error;
    }
  }

  // Méthodes privées de gestion de cache
  isCacheValid() {
    return this.cache.timestamp && 
           (Date.now() - this.cache.timestamp) < this.cache.ttl;
  }

  updateCache(roles) {
    this.cache = {
      roles,
      mapping: null, // Reset pour forcer le recalcul
      timestamp: Date.now()
    };
    
    // Sauvegarder dans localStorage
    try {
      localStorage.setItem('roles_cache', JSON.stringify({
        roles,
        timestamp: Date.now()
      }));
    } catch (error) {
      console.warn('[RoleService] Erreur sauvegarde cache:', error);
    }
  }

  addToCache(role) {
    if (!this.cache.roles) {
      this.cache.roles = [];
    }
    
    // Remplacer ou ajouter le rôle
    const index = this.cache.roles.findIndex(r => r.id === role.id);
    if (index >= 0) {
      this.cache.roles[index] = role;
    } else {
      this.cache.roles.push(role);
    }
    
    this.cache.timestamp = Date.now();
  }

  saveToLocalStorage(mapping) {
    try {
      localStorage.setItem('role_mapping', JSON.stringify(mapping));
      localStorage.setItem('role_mapping_timestamp', Date.now().toString());
    } catch (error) {
      console.warn('[RoleService] Erreur sauvegarde localStorage:', error);
    }
  }

  loadFromLocalStorage() {
    try {
      const mapping = localStorage.getItem('role_mapping');
      const timestamp = localStorage.getItem('role_mapping_timestamp');
      
      if (mapping && timestamp) {
        const cacheAge = Date.now() - parseInt(timestamp, 10);
        if (cacheAge < this.cache.ttl * 24) { // 24 fois le TTL
          return JSON.parse(mapping);
        }
      }
    } catch (error) {
      console.warn('[RoleService] Erreur chargement localStorage:', error);
    }
    
    return null;
  }

  /**
   * Vider le cache (pour les tests ou déconnexion)
   */
  clearCache() {
    this.cache = {
      roles: null,
      mapping: null,
      timestamp: null
    };
    
    try {
      localStorage.removeItem('roles_cache');
      localStorage.removeItem('role_mapping');
      localStorage.removeItem('role_mapping_timestamp');
    } catch (error) {
      console.warn('[RoleService] Erreur nettoyage localStorage:', error);
    }
  }

  /**
   * Configure le token d'authentification
   * @param {string} token 
   */
  setAuthToken(token) {
    if (this.api.apiClient) {
      this.api.apiClient.authentications['bearerAuth'].accessToken = token;
    }
  }
}

// Exporter une instance singleton
export const roleService = new RoleService();