## Product

Les Product possèdent tous un id unique, et son lié aux typeProduct par une clé étrangère.

### Schéma de l'objet Product

```json
{
  "id_product": 1,
  "name": "Nom du product",
  "description": "Description du product",
  "prix": "prix sous format 0.0",
  "id_typeProduct": "Id du type de product auquelle on veut l'associer"
}
```

### Les routes de l'API pour les products

Pour récupérer une liste de product dans la base :</br>
method : **[GET]**</br>
url : `localhost:8081/api/product`</br>

Pour récupérer un product dans la base :</br>
method : **[GET]**</br>
url : `localhost:8081/api/product/{idDuProductSouhaiter}`</br>

Pour récupérer un product dans la base à partir de son attribut name(la recherche
partial est possible):</br>
method : **[GET]**</br>
url : `localhost:8081/api/product/search/{NameRechercher}`</br>

Pour affecter à un product un typeProduct.</br>
method : **[PUT]** </br>
url : `localhost:8081/api/product/{idDuProduct}/position/{idDutypeProduct}`</br>

Modifier intégralement un product l'id est requis afin de savoir le quel modifier</br>
method : **[PUT]** </br>
url : `localhost:8081/api/product`</br>
Body:</br>
```json
{
    "id_product": 1,
    "name": "Nom du product",
    "description": "Description du product",
    "prix": "prix sous format 0.0",
    "id_typeProduct": "Id du type de product auquelle on veut l'associer"
}
```

Pour ajouter un product dans la base :</br>
method : **[POST]**</br>
url : `localhost:8081/api/product`</br>
Body :</br>
//Pas besoin de mettre d'id il est générer automatiquement</br>

```json
{
  "name": "Nom du product",
  "description": "Description du product",
  "prix": "prix sous format 0.0", 
  "id_typeProduct": "Id du type de product auquelle on veut l'associer"
}
```

Pour supprimer une product de la base :</br>
Régle : Une product ne peut être supprimer si un truc y va</br>
method : **[DELETE]**</br>
url : `localhost:8081/api/product/{ideDuProduct}`</br>
