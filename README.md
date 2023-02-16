# Application Web de Gestion des restaurants par villes et par zones

### Principaux concepts théoriques: 
-   Conception et Developement d’une application Web de gestion des villes,restaurants et zone. (Partie Backend)

#### Partie Frontend

Dépot : https://github.com/laasri-Mohamed/RestoWhere



#### Technologies utilisées:
-Le framework Spring Boot pour la partie back-end du projet réalisée en Java
-MySQL pour la base de données
-Java


#### Description

Gestion des flux :
-Gestion des monuments(identifiant,nom,longitude,lattitude,photo,ville)
-Gestion des villes(identifiant,nom,longitude,latitude,zone)
-Gestion des zones(identifiant,nom,longitude,latitude,ville)
-Gestion de l'authentification par un token Bearer JWT


#### Conception UML

Voici la conception UML de notre application
*4.1* Diagramme de cas d'utilisation  | *4.2* Diagramme de classe 
:------------:|:---------------:
![Imgur](https://imgur.com/KaoLMww.jpg)  |  ![Imgur](https://imgur.com/1f142Wd.jpg) 
#### Architecture de l'application

Voici l'architecture générale de notre application
*5.1* Architecture générale
:------------:
![Imgur](https://imgur.com/7qTCmgc.jpg) 


### Outils de développement
-IDE : Eclipse
-Gestion de dépendences : Maven

### Comment utiliser cette application ?
Pour utiliser cette application, il suffit juste de modifier le fichier 'application.properties' pour mettre le nom de choix votre base de donnée et les coordonées d'accès à la base de données à savoir le 'username' et le 'password'.
# Aperçu de la partie Admin
SideBarre  |  Restaurants | Spécialités
:-------------:|:----------------:|:----------------:
![Imgur](https://imgur.com/Re3jnNz.jpg)  | ![Imgur](https://imgur.com/Jgqw5a5.jpg) | ![Imgur](https://imgur.com/SdhyaTU.jpg)
Villes  |  Zones | Séries
:-------------:|:----------------:|:----------------:
![Imgur](https://imgur.com/NPNnKK3.jpg)  | ![Imgur](https://imgur.com/g1ncG8M.jpg) | ![Imgur](https://imgur.com/gbPU7ek.jpg)
Spécialité du restaurant  |  Photos | Statistiques
:-------------:|:----------------:
![Imgur](https://imgur.com/Ju6AOL9.jpg)  | ![Imgur](https://imgur.com/ifa2QYz.jpg) | ![Imgur](https://imgur.com/vOSOsyr.jpg)
