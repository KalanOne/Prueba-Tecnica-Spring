# Prueba Técnica Spring Boot

Este proyecto es una API REST desarrollada con Spring Boot que implementa las siguientes características:

- Autenticación mediante JWT y OAuth 2
- Servicio REST para gestionar un catálogo de items
- Consumo de la API de Pokémon
- Servicio de cifrado con AES/CBC/PKCS5Padding

## Tecnologías utilizadas

- Java 11
- Spring Boot 2.5.5
- Spring Security
- H2 Database
- JPA
- Maven

## Requisitos previos

- JDK 11
- Maven 3.6+

## Cómo ejecutar el proyecto

1. Clonar el repositorio
2. Navegar al directorio del proyecto
3. Ejecutar el siguiente comando:

```bash
mvn spring-boot:run
```

La aplicación estará disponible en: [http://localhost:8080](http://localhost:8080)

---

## Endpoints disponibles

### Autenticación

- **POST /api/auth/registro**: Registrar un nuevo usuario
- **POST /api/auth/login**: Iniciar sesión y obtener token JWT
- **GET /oauth2/authorization/google**: Iniciar autenticación OAuth2 con Google

  > **Nota**: Este endpoint no es ejecutable directamente desde Postman. Para visualizar el flujo completo de autenticación con Google OAuth2 es necesario abrirlo en un navegador.

### Catálogo de Items

- **GET /api/items**: Obtener todos los items
- **GET /api/items/{id}**: Obtener un item por ID
- **POST /api/items/filter**: Filtrar items por diferentes criterios
- **POST /api/items**: Crear un nuevo item
- **PUT /api/items/{id}**: Actualizar un item existente
- **DELETE /api/items/{id}**: Eliminar un item

### Pokémon API

- **GET /api/pokemon/ditto**: Obtener información de Ditto
- **GET /api/pokemon/{name}**: Obtener información de un Pokémon por nombre

### Servicio de Cifrado

- **POST /api/cifrado/cifrar**: Cifrar un texto
- **POST /api/cifrado/descifrar**: Descifrar un texto

---

## Variables de entorno en Postman

Esta colección utiliza una variable de entorno llamada `token`. En algunos entornos puede funcionar sin definirla manualmente, pero si se presentan errores de autorización o acceso denegado, es posible que necesites crear un entorno en Postman y agregar manualmente la variable `token` con el valor del JWT.

---

## Ejemplos de uso

> ⚠️ _Se omite el ejemplo de OAuth2 porque debe ejecutarse en el navegador_

### POST /api/auth/registro

```json
{
  "nombre": "Juan",
  "apellido": "Pérez",
  "username": "juanperez",
  "email": "juan@example.com",
  "password": "password123"
}
```

### POST /api/auth/login

```json
{
  "username": "juanperez",
  "password": "password123"
}
```

### POST /api/items/filter

```json
{
  "nombre": "Laptop"
}
```

### POST /api/items

```json
{
  "nombre": "Nuevo Item",
  "descripcion": "Descripción del nuevo item",
  "precio": 999.99,
  "categoria": "Nueva Categoría",
  "disponible": true
}
```

### PUT /api/items/1

```json
{
  "nombre": "Item Actualizado",
  "descripcion": "Descripción actualizada",
  "precio": 1299.99,
  "categoria": "Categoría Actualizada",
  "disponible": true
}
```

### POST /api/cifrado/cifrar

```json
{
  "texto": "Texto a cifrar"
}
```

### POST /api/cifrado/descifrar

```json
{
  "texto": "Texto a cifrar"
}
```

---

## Mensajes de error

En caso de errores, la API puede devolver respuestas como la siguiente:

```json
{
  "timestamp": "2025-07-11T20:24:44.547+00:00",
  "status": 500,
  "error": "Internal Server Error",
  "trace": "java.lang.RuntimeException: El nombre de usuario ya existe\r\n\tat ... ...",
  "message": "El nombre de usuario ya existe",
  "path": "/api/auth/registro"
}
```

Para errores `404`, es posible que no se retorne contenido en el cuerpo, solo el código HTTP correspondiente. Esto es un comportamiento esperado y no afecta la funcionalidad de la API.

---

## Acceso a la base de datos H2

La consola de H2 está disponible en: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

Datos de conexión:

- JDBC URL: jdbc\:h2\:mem\:testdb
- Usuario: `sa`
- Contraseña: `password`

---

## Usuarios predefinidos

1. **Administrador**

   - Username: `admin`
   - Password: `admin123`

2. **Usuario normal**

   - Username: `user`
   - Password: `user123`
