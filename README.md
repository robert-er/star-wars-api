# Star Wars API

REST API to import Star Wars people from https://swapi.dev, store in local database and offer additional endpoints to browse and filter data locally.

## Endpoints

| ENDPOINT | METHOD NAME | DESCRIPTION  |
|----|---| --- |
| `POST` /people/create/{id} | createPerson  | import person from swapi.dev by ID |
| `GET`/people/{id} | getPersonBySwid  | read person from local DB by Star Wars ID |
| `GET` /people/name/{name} | getPersonByName  |  read person from local DB by name |
| `GET`/people/name/sub/{subName} | getPersonBySubstringName | read people from local DB that names fit to substring name |
| `GET` /people/maxheight | getPeopleByMaxHeight | read people from local DB that filter by height lower than max height parameter in application.properties (predefined value = 200) |

At first you need to import at least one person from swapi.dev by using endpoint `POST /people/create/{id}` , then you can use all other endpoints without exceptions.

## Swagger documentation

Available under http://localhost:8080/swagger-ui.html#/

## Technology

`JAVA 11` `SPRING BOOT 2.6.7` `SWAGGER UI 2.9.2` `H2 database` `JUNIT 5` `MOCK MVC`