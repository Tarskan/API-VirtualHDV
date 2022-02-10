## Message

Les messages possèdent tous un id unique, et son lié a l'user qui la écrit par 
une clé étrangère, aussi comme id_tchat.

### Schéma de l'objet Message

```json
{
  "id_message": "id du message",
  "text": "Message a transmettre",
  "id_user": "id de l'utilisateur qui a écrit",
  "id_tchat": "id de la conversation ou on parle"
}
```

### Les routes de l'API pour les Message
Pour récupérer la liste des messages d'une conversation :</br>
method : **[GET]**</br>
url : `localhost:8081/api/message/{id_tchat}`</br>

Modifier intégralement un message l'id est requis afin de savoir le quel modifier</br>
method : **[PUT]** </br>
url : `localhost:8081/api/message`</br>
Body:</br>

```json
{
  "id_message": "id du message",
  "text": "Message a transmettre",
  "id_user": "id de l'utilisateur qui a écrit",
  "id_tchat": "id de la conversation ou on parle"
}
```

Ajoute un message à la conversation :</br>
method : **[POST]**</br>
url : `localhost:8081/api/message`</br>
Body :</br>

```json
{
  "text": "pseudo de l'utilisateur",
  "id_user": "mot de passe de l'utilisateur",
  "id_tchat": "mot de passe de l'utilisateur"
}
```

Pour supprimer un message de la base :</br>
method : **[DELETE]**</br>
url : `localhost:8081/api/message/{id_message}`</br>