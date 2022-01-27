## User

Les user possèdent tous un id unique.

### Schéma de l'objet User

```json
{
  "id_user": 1,
  "name": "Nom + prenom de l'utilisateur",
  "pseudo": "Pseudo de l'utilisateur",
  "password": "Mot de passe"
}
```

### Les routes de l'api pour les User

Pour récupérer une liste de user dans la base :</br>
method : **[GET]**</br>
url : `localhost:8081/api/user`</br>

Pour récupérer un créneau dans la base :</br>
method : **[GET]**</br>
url : `localhost:8081/api/user/{idDuUserSouhaiter}`</br>

Pour récupérer un advertType dans la base à partir de son attribut name(la recherche
partial est possible):</br>
method : **[GET]**</br>
url : `localhost:8081/api/user/{NameRechercher}`</br>

Modifier intégralement un user l'id est requis afin de savoir le quel modifier</br>
method : **[PUT]** </br>
url : `localhost:8081/api/user`</br>
Body :</br>
```json
{
    "id_user": 1,
    "name": "Nom + prenom de l'utilisateur",
    "pseudo": "Pseudo de l'utilisateur",
    "password": "Mot de passe"
}
```

Pour ajouter un user dans la base :</br>
method : **[POST]**</br>
url : `localhost:8081/api/user`</br>
Body:</br>
//Pas besoin de mettre d'id il est générer automatiquement</br>
```json
{
  "name": "Nom + prenom de l'utilisateur",
  "pseudo": "Pseudo de l'utilisateur",
  "password": "Mot de passe"
}
```

Pour supprimer un user de la base :</br>
method : **[DELETE]**</br>
url : `localhost:8081/api/user/{idDuUser}`</br>












