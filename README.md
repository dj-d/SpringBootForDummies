# Spring Boot For Dummies

This project was created to explain the basics of Spring Boot to people who have never used this framework.

## Requirements

- Java >= 17
- JDK >= 17

## Endpoints

| HTTP Method | Endpoint                                | Description                     |
|-------------|-----------------------------------------|---------------------------------|
| GET         | /healthcheck                            | Check endpotin                  |
| GET         | /api/v1/sandwiches                      | Get all sandwiches              |
| GET         | /api/v1/sandwiches/{name}               | Get a sandwich by name          |
| POST        | /api/v1/sandwiches                      | Create a sandwich               |
| PUT         | /api/v1/sandwiches/{name}               | Update a sandwich               |
| PUT         | /api/v1/sandwiches/{name}/price/{price} | Update a sandwich price by name |
| DELETE      | /api/v1/sandwiches/{name}               | Delete a sandwich               |

### Healthcheck

```bash
curl -X GET http://localhost:3000/healthcheck
```

### Get all sandwiches

```bash
curl -X GET http://localhost:3000/api/v1/sandwiches
```

### Get a sandwich by name

```bash
curl -X GET http://localhost:3000/api/v1/sandwiches/{name}
```

### Create a sandwich

```bash
curl -X POST http://localhost:3000/api/v1/sandwiches \
  -H 'Content-Type: application/json' \
  -d '{
    "name": "McToast",
    "price": 1.8,
    "description": "Bontà a tutto tondo",
    "ingredients": ["BREAD", "MEAT", "CHEESE"],
    "allergens": ["EGG", "PEANUT"]
}'
```

### Update a sandwich

```bash
curl -X PUT http://localhost:3000/api/v1/sandwiches/{name} \
  -H 'Content-Type: application/json' \
  -d '{
    "name": "McToast",
    "price": 3,
    "description": "Bontà a tutto tondo",
    "ingredients": ["BREAD", "MEAT"],
    "allergens": ["PEANUT"]
}'
```

### Update a sandwich price by name

```bash
curl -X PUT http://localhost:3000/api/v1/sandwiches/{name}/price/{price}
```

### Delete a sandwich

```bash
curl -X DELETE http://localhost:3000/api/v1/sandwiches/{name}
```

## References

### Links
- [What is an API?](https://www.redhat.com/en/topics/api/what-are-application-programming-interfaces)
- [What is an API REST/](https://www.redhat.com/it/topics/api/what-is-a-rest-api)
- [Maven Repository](https://mvnrepository.com/)
- [Spring Boot - Doc](https://docs.spring.io/spring-boot/docs/current/reference/html/dependency-versions.html)

### Videos
- [What is an API Rest?](https://www.youtube.com/watch?v=-mN3VyJuCjM&pp=ugMICgJpdBABGAE%3D)
- [Rest vs RPC vs GraphQL API](https://www.youtube.com/watch?v=hkXzsB8D_mo&pp=ugMICgJpdBABGAE%3D)