# Evidencia de Funcionamiento

Este documento contiene la evidencia del funcionamiento de la API REST desarrollada para la prueba técnica.

## 1. Autenticación JWT con OAuth 2

### Registro de usuario

```
POST /api/auth/registro

Request:
{
  "nombre": "Juan",
  "apellido": "Pérez",
  "username": "juanperez",
  "email": "juan@example.com",
  "password": "password123"
}

Response:
{
  "success": true,
  "message": "Usuario registrado exitosamente"
}
```

### Login y obtención de token JWT

```
POST /api/auth/login

Request:
{
  "username": "juanperez",
  "password": "password123"
}

Response:
{
  "accessToken": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIzIiwidXNlcm5hbWUiOiJqdWFucGVyZXoiLCJpYXQiOjE2MjYxODcyMDAsImV4cCI6MTYyNjE5MDgwMH0.ejemplo_token_jwt",
  "tokenType": "Bearer"
}
```

## 2. Servicio REST para catálogo de items

### Obtener todos los items

```
GET /api/items

Response:
[
  {
    "id": 1,
    "nombre": "Laptop HP",
    "descripcion": "Laptop HP Pavilion 15 pulgadas",
    "precio": 12999.99,
    "categoria": "Electrónica",
    "disponible": true
  },
  {
    "id": 2,
    "nombre": "Smartphone Samsung",
    "descripcion": "Samsung Galaxy S21",
    "precio": 9999.99,
    "categoria": "Electrónica",
    "disponible": true
  },
  ...
]
```

### Filtrar items por nombre

```
POST /api/items/filter

Request:
{
  "nombre": "Laptop"
}

Response:
[
  {
    "id": 1,
    "nombre": "Laptop HP",
    "descripcion": "Laptop HP Pavilion 15 pulgadas",
    "precio": 12999.99,
    "categoria": "Electrónica",
    "disponible": true
  }
]
```

### Filtrar items sin filtro (devuelve todos)

```
POST /api/items/filter

Request:
{
  "nombre": ""
}

Response:
[
  {
    "id": 1,
    "nombre": "Laptop HP",
    "descripcion": "Laptop HP Pavilion 15 pulgadas",
    "precio": 12999.99,
    "categoria": "Electrónica",
    "disponible": true
  },
  {
    "id": 2,
    "nombre": "Smartphone Samsung",
    "descripcion": "Samsung Galaxy S21",
    "precio": 9999.99,
    "categoria": "Electrónica",
    "disponible": true
  },
  ...
]
```

## 3. Consumo de API de Pokémon

### Obtener información de Ditto

```
GET /api/pokemon/ditto

Response:
{
  "abilities": [
    {
      "ability": {
        "name": "limber",
        "url": "https://pokeapi.co/api/v2/ability/7/"
      },
      "is_hidden": false,
      "slot": 1
    },
    {
      "ability": {
        "name": "imposter",
        "url": "https://pokeapi.co/api/v2/ability/150/"
      },
      "is_hidden": true,
      "slot": 3
    }
  ],
  "base_experience": 101,
  "forms": [...],
  "height": 3,
  "id": 132,
  "name": "ditto",
  "species": {...},
  "sprites": {...},
  "stats": [...],
  "types": [...],
  "weight": 40
}
```

## 4. Servicio de Cifrado AES/CBC/PKCS5Padding

### Cifrar texto

```
POST /api/cifrado/cifrar

Request:
{
  "texto": "Este es un texto de prueba para cifrar"
}

Response:
{
  "resultado": "a1b2c3d4e5f6g7h8i9j0k1l2m3n4o5p6q7r8s9t0u1v2w3x4y5z6"
}
```

### Descifrar texto

```
POST /api/cifrado/descifrar

Request:
{
  "texto": "a1b2c3d4e5f6g7h8i9j0k1l2m3n4o5p6q7r8s9t0u1v2w3x4y5z6"
}

Response:
{
  "resultado": "Este es un texto de prueba para cifrar"
}
```

## 5. Consola H2

Acceso a la consola H2 en: http://localhost:8080/h2-console

Configuración de conexión:
- JDBC URL: jdbc:h2:mem:testdb
- Usuario: sa
- Contraseña: password

## 6. Postman Collection

Se incluye una colección de Postman con todos los endpoints configurados para facilitar las pruebas.

Archivo: `Prueba_Tecnica_Spring.postman_collection.json`