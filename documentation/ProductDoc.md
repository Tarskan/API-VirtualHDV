## Product

Les Product possèdent tous un id unique, et son lié aux advertType par une clé étrangère.

### Schéma de l'objet Product

```json
{
  "id_product": 1,
  "name": "Nom du advert",
  "description": "Description du advert",
  "prix": "prix sous format 0.0",
  "id_typeProduct": "Id du type de advert auquelle on veut l'associer"
}
```

### Les routes de l'API pour les products

Pour récupérer une liste de advert dans la base :</br>
method : **[GET]**</br>
url : `localhost:8081/api/advert`</br>

Pour récupérer un advert dans la base :</br>
method : **[GET]**</br>
url : `localhost:8081/api/advert/{idDuProductSouhaiter}`</br>

Pour récupérer un advert dans la base à partir de son attribut name(la recherche
partial est possible):</br>
method : **[GET]**</br>
url : `localhost:8081/api/advert/search/{NameRechercher}`</br>

Pour affecter à un advert un advertType.</br>
method : **[PUT]** </br>
url : `localhost:8081/api/advert/{idDuProduct}/position/{idDutypeProduct}`</br>

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
    "id_typeProduct": "Id du type de advert auquelle on veut l'associer"
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
  "id_typeProduct": "Id du type de advert auquelle on veut l'associer"
}
```

Pour supprimer une advert de la base :</br>
Régle : Une advert ne peut être supprimer si un truc y va</br>
method : **[DELETE]**</br>
url : `localhost:8081/api/advert/{ideDuProduct}`</br>
