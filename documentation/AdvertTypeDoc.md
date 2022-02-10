## AdvertType

Les advertType possèdent tous un id unique.

### Schéma de l'objet advertType

```json
{
  "id_adverttype": 1,
  "name": "Nom du AdvertType"
}
```

### Les routes de l'API pour les advertType

Pour récupérer une liste des advertType dans la base.</br>
method : **[GET]**</br>
url : `localhost:8081/api/advertType</br>`

Pour récupérer un advertType dans la base.</br>
method : **[GET]**</br>
url : `localhost:8081/api/advertType/{idDuAdvertTypeSouhaiter}`</br>

Modifie intégralement un advertType, l'id est requis afin de savoir le quel modifier</br>
method : **[PUT]** </br>
url : `localhost:8081/api/advertType`</br>
Body:</br>
```json
{
    "id_adverttype": 1,
    "name": "Nom du AdvertType"
}
```

Pour ajouter un advertType dans la base.</br>
method : **[POST]**</br>
url : `localhost:8081/api/advertType`</br>
Body:</br>
//Pas besoin de mettre d'id il est générer automatiquement</br>
```json
{
  "name": "Nom du AdvertType"
}
```

Pour supprimer un advertType de la base :</br>
method : **[DELETE]**</br>
url : `localhost:8081/api/advertType/{idDuAdvertType}`</br>
