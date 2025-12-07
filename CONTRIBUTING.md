# Contribuer au projet Gestion Alumni

Merci de l'intérêt que vous portez au projet **Gestion Alumni** ! Nous accueillons toutes les contributions qui aident à améliorer la plateforme.

Ce document fournit des directives pour contribuer au projet. En participant, vous acceptez de respecter notre Code de Conduite.

## 📋 Table des matières
1. [Prérequis](#1-prérequis)
2. [Installation et Démarrage](#2-installation-et-démarrage)
3. [Architecture du Projet](#3-architecture-du-projet)
4. [Workflow de Développement](#4-workflow-de-développement)
5. [Conventions de Code](#5-conventions-de-code)
6. [Soumettre une Contribution](#6-soumettre-une-contribution)
7. [Signaler un Bug](#7-signaler-un-bug)

---

## 1. Prérequis

Assurez-vous d'avoir installé les outils suivants sur votre machine :

*   [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
*   [Maven 3.9+](https://maven.apache.org/install.html)
*   [Docker & Docker Compose](https://docs.docker.com/compose/install/)
*   [Git](https://git-scm.com/)

## 2. Installation et Démarrage

### Récupérer le code
```bash
git clone https://github.com/<votre-repo>/gestion_alumni.git
cd gestion_alumni
```

### Lancer l'environnement
Le projet utilise Docker Compose pour orchestrer les microservices et les bases de données.

```bash
docker compose up --build
```

Vérifiez l'état des services :
```bash
docker ps
```
> **Note** : Le service `ms-user-db` doit être "healthy" pour que les autres services démarrent correctement.
> Le port interne MariaDB pour les microservices est **3306**.

## 3. Architecture du Projet

Le projet suit une architecture microservices :

```
backend/
├── ms-config/     # Serveur de configuration (Spring Cloud Config)
├── ms-discover/   # Serveur de découverte (Eureka)
├── ms-gateway/    # API Gateway
└── ms-user/       # Service de gestion des utilisateurs
```

*   **Documentation API** : Chaque microservice expose sa documentation via Swagger à l'adresse `http://localhost:<port>/swagger-ui.html` ou `/v3/api-docs`.

## 4. Workflow de Développement

Nous utilisons le workflow **Gitflow** simplifié.

1.  **Synchronisez-vous** avec la branche `develop` :
    ```bash
    git checkout develop
    git pull origin develop
    ```
2.  **Créez une branche** pour votre fonctionnalité ou correctif :
    ```bash
    git checkout -b feature/ma-nouvelle-feature
    # ou
    git checkout -b fix/correction-bug
    ```

## 5. Conventions de Code

### Messages de Commit
Nous suivons la convention **Conventional Commits** :
*   `feat`: Nouvelle fonctionnalité
*   `fix`: Correction de bug
*   `docs`: Documentation
*   `style`: Formatage, points-virgules manquants, etc.
*   `refactor`: Refactoring du code
*   `test`: Ajout ou modification de tests

Exemple :
```
feat(user): ajout de l'authentification par email
```

### Java
*   Respectez les conventions de nommage Java standard.
*   Utilisez `camelCase` pour les variables et méthodes, `PascalCase` pour les classes.
*   Ajoutez de la Javadoc pour les méthodes publiques complexes.
*   Assurez-vous que les tests unitaires passent avant de commiter.

## 6. Soumettre une Contribution

1.  Faites vos modifications et testez-les localement.
2.  Commitez vos changements en suivant les conventions.
3.  Poussez votre branche :
    ```bash
    git push origin feature/ma-nouvelle-feature
    ```
4.  Ouvrez une **Pull Request** (PR) vers la branche `develop`.
5.  Décrivez clairement vos changements dans la PR.

## 7. Signaler un Bug

Si vous trouvez un bug, merci d'ouvrir une issue en précisant :
*   Les étapes pour reproduire le problème.
*   Le comportement attendu vs le comportement observé.
*   Les logs ou captures d'écran pertinents.

Merci de votre contribution !