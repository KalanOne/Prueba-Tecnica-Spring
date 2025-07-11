# Prueba Técnica Spring Boot

Este proyecto es una API REST desarrollada con Spring Boot que implementa las siguientes características:

- Autenticación mediante JWT con OAuth 2
- Servicio REST para gestionar un catálogo de items
- Consumo de la API de Pokémon
- Servicio de cifrado AES/CBC/PKCS5Padding

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

La aplicación estará disponible en: http://localhost:8080

## Endpoints disponibles

### Autenticación

- **POST /api/auth/registro**: Registrar un nuevo usuario
- **POST /api/auth/login**: Iniciar sesión y obtener token JWT

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

## Ejemplos de uso

### Registro de usuario

```json
POST /api/auth/registro
{
  "nombre": "Juan",
  "apellido": "Pérez",
  "username": "juanperez",
  "email": "juan@example.com",
  "password": "password123"
}
```

### Inicio de sesión

```json
POST /api/auth/login
{
  "username": "juanperez",
  "password": "password123"
}
```

### Filtrar items por nombre

```json
POST /api/items/filter
{
  "nombre": "Laptop"
}
```

### Cifrar texto

```json
POST /api/cifrado/cifrar
{
  "texto": "Texto a cifrar"
}
```

## Acceso a la base de datos H2

La consola de H2 está disponible en: http://localhost:8080/h2-console

Datos de conexión:
- JDBC URL: jdbc:h2:mem:testdb
- Usuario: sa
- Contraseña: password

## Usuarios predefinidos

1. Administrador
   - Username: admin
   - Password: admin123

2. Usuario normal
   - Username: user
   - Password: user123