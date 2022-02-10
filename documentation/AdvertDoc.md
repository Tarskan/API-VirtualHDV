## Advert

Les Advert possèdent tous un id unique, et son lié aux advertType par une clé étrangère,
aussi comme id_user, soldTo.

### Schéma de l'objet Advert

```json
{
  "id_advert": 1,
  "name": "Nom du advert",
  "description": "Description du advert",
  "prix": "prix sous format 0.0",
  "url": "url générer directement sur le site lorsque l'on s'inscrit",
  "id_adverttype": "Id du type de advert auquelle on veut l'associer",
  "id_user": "Id de l'utilisateur créateur",
  "soldTo": "Id de la personne a qui à était vendu l'objet"
}
```

### Les routes de l'API pour les Advert

Pour récupérer une liste de advert dans la base mais qui ne nous appartiennent pas :</br>
method : **[GET]**</br>
url : `localhost:8081/api/advert/{id_user}`</br>

Pour récupérer un advert dans la base :</br>
method : **[GET]**</br>
url : `localhost:8081/api/advert/index/{id_advert}`</br>

Pour récupérer une liste d'advert mais qui sont des adverts de l'utilisateur dans la 
base :</br>
method : **[GET]**</br>
url : `localhost:8081/api/advert/search/{id_user}`</br>

Pour récupérer une liste d'advert mais qui sont des adverts de l'utilisateur dans la
base et rechercher avec leurs noms de maniére partiel :</br>
method : **[GET]**</br>
url : `localhost:8081/api/advert/search/{id_user}/query/{advertName}`</br>

Pour récupérer une liste d'advert mais qui ne sont pas des adverts de l'utilisateur dans la
base mais rechercher par nom d'annonce :</br>
method : **[GET]**</br>
url : `localhost:8081/api/advert/search/name/{nameAdvert}/without/{id_user}`</br>

Pour récupérer une liste d'advert dans la base à partir mais vendu par l'utilisateur:</br>
method : **[GET]**</br>
url : `localhost:8081/api/advert/sold/{id_user}`</br>

Pour récupérer une liste d'advert dans la base mais acheter par l'utilisateur:</br>
method : **[GET]**</br>
url : `localhost:8081/api/advert/bought/{id_user}`</br>

Pour récupérer une liste d'advert dans la base mais vendu par l'utilisateur
mais rechercher par nom:</br>
method : **[GET]**</br>
url : `localhost:8081/api/advert/sold/{id_user}/query/{advertName}`</br>

Pour récupérer une liste d'advert dans la base mais achet par l'utilisateur
mais rechercher par nom:</br>
method : **[GET]**</br>
url : `localhost:8081/api/advert/bought/{id_user}/query/{advertName}`</br>

Pour affecter à un advert un advertType.</br>
method : **[PUT]** </br>
url : `localhost:8081/api/advert/{id_advert}/advertType/{id_advertType}`</br>

Modifier intégralement un advert l'id est requis afin de savoir le quel modifier</br>
method : **[PUT]** </br>
url : `localhost:8081/api/advert`</br>
Body:</br>

```json
{
  "id_product": 1,
  "name": "Nom du advert",
  "description": "Description du advert",
  "prix": "prix sous format 0.0",
  "url": "url générer directement sur le site lorsque l'on s'inscrit",
  "id_adverttype": "Id du type de advert auquelle on veut l'associer",
  "id_user": "Id de l'utilisateur créateur",
  "soldTo": "Id de la personne a qui à était vendu l'objet"
}
```

Pour ajouter un advert dans la base :</br>
method : **[POST]**</br>
url : `localhost:8081/api/advert`</br>
Body :</br>
//Pas besoin de mettre d'id il est générer automatiquement</br>

```json
{
  "name": "Nom du advert",
  "description": "Description du advert",
  "prix": "prix sous format 0.0",
  "url": "url générer directement sur le site lorsque l'on s'inscrit",
  "id_adverttype": "Id du type de advert auquelle on veut l'associer",
  "id_user": "Id de l'utilisateur créateur",
  "soldTo": "Id de la personne a qui à était vendu l'objet"
}
```
Pour vendre un objet :</br>
method : **[POST]**</br>
url : `localhost:8081/api/advert/sold/{id_advert}/to/{id_user}`</br>

Pour ajouter une image dans la base :</br>
method : **[POST]**</br>
url : `localhost:8081/api/image`</br>
Body : une image MultipartFile</br>
//Ne fonctionne pas</br>

Pour supprimer une advert de la base :</br>
method : **[DELETE]**</br>
url : `localhost:8081/api/advert/{ideDuAdvert}`</br>