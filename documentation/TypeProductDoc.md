## Trucks

Les typeProduct possèdent tous un id unique.

### Schéma de l'objet typeProduct

```json
{
  "id_typeProduct": 1,
  "name": "Nom du typeProduct"
}
```

### Les routes de l'API pour les typeProduct

Pour récupérer une liste des typeProduct dans la base.</br>
method : **[GET]**</br>
url : `localhost:8081/api/typeProduct</br>`

Pour récupérer un typeProduct dans la base.</br>
method : **[GET]**</br>
url : `localhost:8081/api/typeProduct/{idDutypeProductSouhaiter}`</br>

Pour récupérer un typeProduct dans la base à partir de son attribut name(la recherche
partial est possible):</br>
method : **[GET]**</br>
url : `localhost:8081/api/typeProduct/{NameRechercher}`</br>

Modifie intégralement un typeProduct, l'id est requis afin de savoir le quel modifier</br>
method : **[PUT]** </br>
url : `localhost:8081/api/typeProduct`</br>
Body:</br>
```json
{
    "id_typeProduct": 1,
    "name": "Nom du typeProduct"
}
```

Pour ajouter un typeProduct dans la base.</br>
method : **[POST]**</br>
url : `localhost:8081/api/typeProduct`</br>
Body:</br>
//Pas besoin de mettre d'id il est générer automatiquement</br>
```json
{
  "name": "Nom du typeProduct"
}
```

Pour supprimer un typeProduct de la base :</br>
method : **[DELETE]**</br>
url : `localhost:8081/api/typeProduct/{idDutypeProduct}`</br>
