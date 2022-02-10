## User

Les user possèdent tous un id unique.

### Schéma de l'objet User

```json
{
  "id_user": 1,
  "first_name": "prenom de l'utilisateur",
  "last_name": "nom de l'utilisateur",
  "adress": "adresse de l'utilisateur",
  "city": "ville de l'utilisateur",
  "email": "email de l'utilisateur",
  "pseudo": "Pseudo de l'utilisateur",
  "password": "Mot de passe",
  "url": "url de l'image de l'utilisateur"
}
```

### Les routes de l'api pour les User

Pour récupérer une liste de user dans la base :</br>
method : **[GET]**</br>
url : `localhost:8081/api/user`</br>

Pour récupérer un user dans la base :</br>
method : **[GET]**</br>
url : `localhost:8081/api/user/{idDuUserSouhaiter}`</br>

Modifier intégralement un user l'id est requis afin de savoir le quel modifier</br>
method : **[PUT]** </br>
url : `localhost:8081/api/user`</br>
Body :</br>
```json
{
    "id_user": 1, 
    "first_name": "prenom de l'utilisateur",
    "last_name": "nom de l'utilisateur",
    "adress": "adresse de l'utilisateur",
    "city": "ville de l'utilisateur",
    "email": "email de l'utilisateur",
    "pseudo": "Pseudo de l'utilisateur",
    "password": "Mot de passe",
    "url": "url de l'image de l'utilisateur"
}
```

Pour ajouter un user dans la base :</br>
method : **[POST]**</br>
url : `localhost:8081/api/user`</br>
Body:</br>
//Pas besoin de mettre d'id il est générer automatiquement</br>
```json
{
  "first_name": "prenom de l'utilisateur",
  "last_name": "nom de l'utilisateur",
  "adress": "adresse de l'utilisateur",
  "city": "ville de l'utilisateur",
  "email": "email de l'utilisateur",
  "pseudo": "Pseudo de l'utilisateur",
  "password": "Mot de passe",
  "url": "url de l'image de l'utilisateur"
}
```

Pour supprimer un user de la base :</br>
method : **[DELETE]**</br>
url : `localhost:8081/api/user/{idDuUser}`</br>












