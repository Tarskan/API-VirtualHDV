## Connexion

Les connexions sont des objets simple

### Schéma de l'objet Connexion

```json
{
  "pseudo": "pseudo de l'utilisateur",
  "password": "mot de passe de l'utilisateur"
}
```

### Les routes de l'API pour les Connexion
Pour se connecter (attention c'est une sécurité vétuste):</br>
method : **[POST]**</br>
url : `localhost:8081/api/connexion`</br>
Body :</br>

```json
{
  "pseudo": "pseudo de l'utilisateur",
  "password": "mot de passe de l'utilisateur"
}
```