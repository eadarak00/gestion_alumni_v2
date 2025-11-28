# Projet : Gestion des Alumnis

## 1. Présentation générale

### 1.1 Contexte
Le projet **Gestion des Alumnis** a pour objectif de mettre en relation les **anciens étudiants (alumnis)** et les **étudiants actuels** d’un établissement afin de renforcer le réseau professionnel et académique.  
La plateforme permet le **partage d’expériences**, la **diffusion d’opportunités** (emplois, formations, événements) et la **communication directe** entre membres.

### 1.2 Objectifs principaux
- Créer un **réseau social académique et professionnel** autour des alumnis.  
- Offrir aux étudiants un **accès simplifié aux opportunités** et à l’expérience de leurs aînés.  
- Donner aux alumnis un **espace pour partager** et **interagir** avec la nouvelle génération.  
- Permettre à l’administrateur de **superviser et animer la communauté**.


## 2. Acteurs de la plateforme

### 2.1 Étudiant
- Accède à la plateforme via un compte utilisateur.  
- Dispose d’un espace personnel pour créer et gérer son **CV**.  
- Peut inviter des alumni ou des étudiants à rejoindre la plateforme.  
- Peut **rechercher** un alumni et **échanger des messages**.  

### 2.2 Alumni
- Accède à la plateforme via un compte alumni.  
- Peut consulter et télécharger (sur demande) le **CV d’un étudiant**.  
- Peut **rechercher**, **inviter** et **échanger** avec d’autres alumni.  
- Peut **partager des informations** : offres d’emploi, formations, événements, etc.  

### 2.3 Administrateur
- Dispose d’un accès à un **tableau de bord de supervision**.  
- Peut **gérer les comptes utilisateurs** (étudiants, alumni).  
- Peut **inviter des alumni** à rejoindre la plateforme pour élargir le réseau.  
- Peut **consulter les CV** des étudiants.  
- Assure la **modération** et le **suivi** des activités sur la plateforme.  


## 3. Fonctionnalités clés

| Fonctionnalité                                  | Étudiant           | Alumni               | Administrateur    |
|-------------------------------------------------|--------------------|----------------------|-------------------|
| Authentification (connexion / déconnexion)      | ✔️                 | ✔️                   | ✔️                |
| Création et gestion de CV                       | ✔️                 | ❌                   | ✔️ (consultation) |
| Téléchargement de CV                            | ✔️ (son propre CV) | ✔️ (sur demande)     | ✔️                |
| Recherche d’utilisateurs (étudiant / alumni)    | ✔️                 | ✔️                   | ✔️                |
| Invitation d’utilisateurs                       | ✔️                 | ✔️                   | ✔️                |
| Envoi de messages                               | ✔️                 | ✔️                   | ✔️ (modération)   |
| Partage d’informations (offres, formations,...) | ❌                 | ✔️                   | ✔️ (validation)   |
| Accès à un tableau de bord                      | ❌                 | ❌                   | ✔️                |
| Monitoring et supervision                       | ❌                 | ❌                   | ✔️                |

## 4. Architecture logicielle

### 4.1 Type d’architecture
**Architecture microservices**, afin d’assurer :
- Une **modularité** du code (chaque service est indépendant).  
- Une **scalabilité** facilitée (mise à l’échelle d’un service spécifique).  
- Une **résilience** et une **maintenabilité** accrues.  

### 4.2 Microservices prévus
1. **Service Utilisateur** : gestion des profils étudiants, alumni et administrateurs.  
2. **Service CV** : création, consultation et téléchargement de CV.  
3. **Service Messagerie** : gestion des échanges entre utilisateurs.  
4. **Service Invitation** : envoi et gestion des invitations.  
5. **Service Publication** : gestion des offres, formations et événements.  
6. **Service Administration** : gestion des accès, monitoring et statistiques.  


## 5. Méthodologie de développement

### 5.1 Approche
Le projet suit une **méthodologie Agile (Scrum)**, basée sur :
- Des **sprints** de 2 à 4 semaines.  
- Des **revues de sprint** pour la validation fonctionnelle.  
- Des **rétrospectives** pour améliorer le processus.  
- Une **priorisation** continue des fonctionnalités selon les besoins métiers.  

### 5.2 Outils de gestion Agile
- **Jira**  pour la gestion des tâches et user stories.  
- **GitHub Projects** pour le suivi collaboratif.  
- **Daily meetings** pour synchroniser les membres de l’équipe.  


## 6. Technologies et outils

| Domaine                     | Technologies                                      |
|-----------------------------|---------------------------------------------------|
| Backend                     | Spring Boot (Java 17), architecture microservices |
| Frontend                    | React ou Angular                                  |
| Base de données             | PostgreSQL                                        |
| Sécurité                    | Spring Security, JWT                              |
| API                         | REST, OpenAPI / Swagger                           |
| Communication interservices | REST                                              |
| Déploiement                 | Docker, Docker Compose                            |
| Gestion du code             | Git, GitHub                                       |
| Documentation               | Markdown (`/documentation` branch), OpenAPI       |

## 7. Gestion des branches Git

| Branche         | Rôle                                                           |
|-----------------|----------------------------------------------------------------|
| `main`          | Branche principale contenant la version stable du projet       |
| `develop`       | Branche d’intégration des nouvelles fonctionnalités            |
| `feature/*`     | Branches de développement spécifiques (une par fonctionnalité) |
| `documentation` | Contient toute la documentation technique et fonctionnelle     |


**Document rédigé pour la branche `documentation` du projet _Gestion des Alumnis_.**