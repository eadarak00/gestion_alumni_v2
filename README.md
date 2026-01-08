# Gestion des Alumnis

Bienvenue sur le dépôt du projet **Gestion des Alumnis**.
Cette application est une plateforme communautaire destinée à mettre en relation les anciens étudiants (Alumnis) et les étudiants actuels pour favoriser l'entraide et l'insertion professionnelle.

## 📚 Documentation

La documentation détaillée du projet est disponible dans les fichiers suivants :

*   **[PROJET.md](./PROJET.md)** : Présentation fonctionnelle, acteurs, user stories et roadmap.
*   **[INFRASTRUCTURE.md](./INFRASTRUCTURE.md)** : Architecture technique, détails des microservices et infrastructure.

## 🚀 Architecture

Le projet repose sur une architecture **Microservices** avec **Spring Boot** et **Spring Cloud**.

### Services Principaux
*   **ms-user** : Gestion des utilisateurs et authentification.
*   **ms-cv** : Gestion des CVs.
*   **ms-invitation** : Gestion du réseau.
*   **ms-publication** : Offres d'emplois et événements.
*   **ms-messagerie** : Chat entre utilisateurs.
*   **ms-analytics** : Dashboard administrateur.

### Infrastructure
*   **Config Server** : Centralisation des configurations.
*   **Discovery Server (Eureka)** : Annuaire des services.
*   **API Gateway** : Point d'entrée unique.

## 🛠️ Prérequis Techniques

*   **Java** : 17
*   **Docker** & **Docker Compose**
*   **Maven**

## 🏁 Démarrage Rapide (Théorique)

1.  **Cloner le dépôt**
    ```bash
    git clone https://github.com/votre-org/gestion-alumni.git
    cd gestion-alumni
    ```

2.  **Lancer l'infrastructure (Bases de données, RabbitMQ, etc.)**
    ```bash
    docker-compose up -d
    ```

3.  **Compiler et lancer les services**
    Chaque microservice peut être lancé individuellement via Maven :
    ```bash
    cd ms-user
    mvn spring-boot:run
    ```

## 👥 Auteurs

Projet réalisé dans le cadre de la formation.
