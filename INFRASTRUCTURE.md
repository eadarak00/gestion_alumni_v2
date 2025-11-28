# Infrastructure du Projet : Gestion des Alumnis

Ce document détaille l'architecture technique et l'infrastructure mise en place pour le projet **Gestion des Alumnis**.

## 1. Architecture Globale

Le projet repose sur une architecture **Microservices** afin de garantir modularité, scalabilité et maintenabilité.

### Schéma de principe
*   **Clients** (Web/Mobile) -> **API Gateway** -> **Microservices** -> **Base de Données**

## 2. Stack Technique

*   **Langage & Framework** : Java 17, Spring Boot 3.x
*   **Base de données** : MariaDB (Une base de données par service ou schémas séparés)
*   **Communication** :
    *   Synchrone : REST (OpenFeign)
    *   Asynchrone : RabbitMQ ou Kafka (pour les événements)
*   **Sécurité** : Spring Security, JWT (JSON Web Tokens)
*   **Conteneurisation** : Docker, Docker Compose
*   **Build Tool** : Maven

## 3. Services d'Infrastructure (Core)

Ces services techniques sont indispensables au fonctionnement de l'écosystème microservices.

### 3.1. Config Server (`ms-config`)
*   **Rôle** : Centralise la configuration de tous les microservices.
*   **Fonctionnalité** : Distribue les fichiers de configuration (application.yml) au démarrage des services. Permet de modifier la configuration sans redéployer tout le code (via refresh).
*   **Port par défaut** : 8888

### 3.2. Discovery Server (`ms-discovery`)
*   **Technologie** : Netflix Eureka.
*   **Rôle** : Annuaire des services.
*   **Fonctionnalité** : Chaque microservice s'enregistre auprès de lui ("Je suis ms-user à l'adresse X"). La Gateway l'interroge pour savoir où router les requêtes.
*   **Port par défaut** : 8761

### 3.3. API Gateway (`ms-gateway`)
*   **Technologie** : Spring Cloud Gateway.
*   **Rôle** : Point d'entrée unique de l'application.
*   **Fonctionnalités** :
    *   Routage des requêtes vers les bons microservices.
    *   Gestion de la sécurité (vérification basique des tokens).
    *   Rate limiting, Load balancing.
*   **Port par défaut** : 8080

## 4. Microservices Métiers

Ces services implémentent la logique fonctionnelle de l'application.

### 4.1. Service Utilisateur (`ms-user`)
*   **Priorité** : 1
*   **Rôle** : Gestion des comptes et de l'authentification.
*   **Fonctionnalités** :
    *   Inscription / Connexion (Génération JWT).
    *   Gestion des profils (Étudiant, Alumni, Admin).
    *   Sécurisation des mots de passe.

### 4.2. Service CV (`ms-cv`)
*   **Priorité** : 2
*   **Rôle** : Gestion des curriculum vitæ.
*   **Fonctionnalités** :
    *   CRUD des CVs (Expériences, Formations, Compétences).
    *   Upload de documents (PDF).
    *   Gestion de la visibilité des CVs.

### 4.3. Service Invitation (`ms-invitation`)
*   **Priorité** : 3
*   **Rôle** : Gestion du réseau et des connexions.
*   **Fonctionnalités** :
    *   Envoi d'invitations par email ou lien.
    *   Acceptation / Refus des demandes de connexion.

### 4.4. Service Publication (`ms-publication`)
*   **Priorité** : 4
*   **Rôle** : Gestion du contenu partagé.
*   **Fonctionnalités** :
    *   Création de posts (Offres d'emploi, Événements, Actualités).
    *   Fil d'actualité.

### 4.5. Service Analytics & Admin (`ms-analytics`)
*   **Priorité** : 5
*   **Rôle** : Tableau de bord et statistiques.
*   **Fonctionnalités** :
    *   Agrégation de données (Nombre d'inscrits, activité).
    *   Monitoring de la plateforme.
    *   Rapports pour l'administrateur.

### 4.6. Service Messagerie (`ms-messagerie`)
*   **Priorité** : 6
*   **Rôle** : Communication directe.
*   **Fonctionnalités** :
    *   Chat en temps réel ou différé entre utilisateurs.
    *   Historique des conversations.

## 5. Stratégie de Communication

### 5.1. Synchrone (REST)
Utilisé pour les opérations nécessitant une réponse immédiate.
*   *Exemple* : La Gateway appelle `ms-user` pour valider un token.
*   **Outil** : Spring Cloud OpenFeign.

### 5.2. Asynchrone (Event-Driven)
Utilisé pour découpler les services et gérer les tâches de fond.
*   *Exemple* : `ms-user` émet un événement `USER_CREATED` -> `ms-analytics` met à jour les stats et `ms-invitation` envoie un email de bienvenue.
*   **Outil** : RabbitMQ (recommandé pour sa simplicité) ou Kafka.

## 6. Déploiement (Docker)

Chaque microservice disposera de son propre `Dockerfile`.
Un fichier `docker-compose.yml` à la racine permettra d'orchestrer l'ensemble de l'infrastructure :
1.  Bases de données (PostgreSQL)
2.  Broker de messages (RabbitMQ/Kafka)
3.  Config Server
4.  Discovery Server
5.  Microservices Métiers
6.  Gateway