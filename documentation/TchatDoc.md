## Tchat et TchatDTO

Les messages possèdent tous un id unique, et son lié a l'userone qui est le vendeur et 
l'usertwo qui est l'acheteur tous étant une clé étrangére, aussi comme id_advert.

### Schéma de l'objet Tchat

```json
{
  "id_tchat": "id du message",
  "id_userone": "id du vendeur",
  "id_usertwo": "id de l'acheteur",
  "id_advert": "id de l'annonce concerner"
}
```

### Schéma de l'objet TchatDTO
Cette objet sert particuliérement a rassembler toute les informations pour gérer les 
tchats dans la parties front.
```json
{
  "tchat": "Objet tchat",
  "vendor": "Objet contenant les informatons du vendeur",
  "advert": "Objet contenant les informations de l'annonce"
}
```

### Les routes de l'API pour les Tchat
Pour récupérer la liste des messages d'une conversation :</br>
method : **[GET]**</br>
url : `localhost:8081/api/tchat/{id_tchat}`</br>

Modifier intégralement un message l'id est requis afin de savoir le quel modifier</br>
method : **[PUT]** </br>
url : `localhost:8081/api/tchat`</br>
Body:</br>

```json
{
  "id_tchat": "id du tchat",
  "id_userone": "id du vendeur",
  "id_usertwo": "id de l'acheteur",
  "id_advert": "id de l'annonce concerner"
}
```

Ajoute un tchat se fait automatiquement après une vente :</br>
method : **[POST]**</br>
url : `localhost:8081/api/tchat`</br>
Body :</br>

```json
{
  "id_userone": "id du vendeur",
  "id_usertwo": "id de l'acheteur",
  "id_advert": "id de l'annonce concerner"
}
```

Pour supprimer un tchat de la base :</br>
method : **[DELETE]**</br>
url : `localhost:8081/api/tchat/{id_tchat}`</br>