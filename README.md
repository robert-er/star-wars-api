# Star Wars API

REST API to import Star Wars people from https://swapi.dev, store in local database and offer additional endpoints.

## Endpoints

* import person from swapi.dev by ID - > GET https://swapi.dev/api/people/{id}/ and store some specific data in local DB (name, height, mass)
* read person from local DB by ID
* read person from local DB by name
* read people from local DB that filter by height lower than max height parameter in application.properties