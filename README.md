#  ClientTerrainApp

**ClientTerrainApp** est une application Java de gestion de clients et de terrains. Elle permet d’ajouter, afficher, modifier et supprimer des clients depuis une interface graphique connectée à une base de données MySQL.

---

##  Structure du projet

- `Client.java` : classe représentant un client, avec méthodes de gestion (CRUD).
- `Database.java` : classe de connexion à la base de données MySQL.
- `ClientTerrainApp.java` : point d'entrée principal de l'application, lance le tableau de bord (`Dashboard`).
- (Autres fichiers potentiels : `Dashboard.java`, `Login.java`, interfaces Swing, etc.)

---

##  Fonctionnalités principales

-  Ajouter un client
-  Supprimer un client
-  Modifier les informations d’un client
-  Lister tous les clients (à partir de la base de données)
-  Connexion à une base MySQL via JDBC

---

##  Base de données

- Nom de la base : `clientterrain`
- Table principale : `client`

###  Exemple de structure SQL pour la table `client` :

```sql
CREATE TABLE client (
  id_client INT AUTO_INCREMENT PRIMARY KEY,
  nom_client VARCHAR(255),
  tel_client INT,
  adr_client VARCHAR(255)
);
