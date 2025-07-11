# Evidencia de Funcionamiento

Este documento contiene la evidencia del funcionamiento de la API REST desarrollada para la prueba técnica.

## Autenticación

- **POST /api/auth/registro**: Registrar un nuevo usuario
  ![Post Registro](ScreenShots/Post%20Registro.png)
  <div align="center"><em>Post Registro</em></div>
- **POST /api/auth/login**: Iniciar sesión y obtener token JWT
  ![Post Login](ScreenShots/Post%20Login.png)
  <div align="center"><em>Post Login</em></div>
- **GET /oauth2/authorization/google**: Iniciar autenticación OAuth2 con Google
  | ![Get OAuth2 Pantalla 1 (Navegador)](ScreenShots/Get%20OAuth2%20Pantalla%201%20(Navegador).png) | ![Get OAuth2 Pantalla 1 (Navegador)](ScreenShots/Get%20OAuth2%20Pantalla%202%20(Navegador).png) | ![Get OAuth2 Pantalla 3 Respuesta JWT (Navegador)](ScreenShots/Get%20OAuth2%20Pantalla%203%20Respuesta%20JWT%20(Navegador).png) |
  |:--:|:--:|:--:|
  | <em>Get OAuth2 Pantalla 1 (Navegador)</em> | <em>Get OAuth2 Pantalla 1 (Navegador)</em> | <em>Get OAuth2 Pantalla 3 Respuesta JWT (Navegador)</em> |


## Catálogo de Items

- **GET /api/items**: Obtener todos los items
  ![Get Obetener todos los items](ScreenShots/Get%20Obetener%20todos%20los%20items.png)
  <div align="center"><em>Get Obetener todos los items</em></div>
- **GET /api/items/{id}**: Obtener un item por ID
  ![Get Obtener item por Id](ScreenShots/Get%20Obtener%20item%20por%20Id.png)
  <div align="center"><em>Get Obtener item por Id</em></div>
- **POST /api/items/filter**: Filtrar items por diferentes criterios
  ![Post Filtrar items por nombre](ScreenShots/Post%20Filtrar%20items%20por%20nombre.png)
  <div align="center"><em>Post Filtrar items por nombre</em></div>
- **POST /api/items**: Crear un nuevo item
  ![Post Crear item](ScreenShots/Post%20Crear%20item.png)
  <div align="center"><em>Post Crear item</em></div>
- **PUT /api/items/{id}**: Actualizar un item existente
  ![Put Actualizar item](ScreenShots/Put%20Actualizar%20item.png)
  <div align="center"><em>Put Actualizar item</em></div>
- **DELETE /api/items/{id}**: Eliminar un item
  ![Delete Eliminar item](ScreenShots/Delete%20Eliminar%20item.png)
  <div align="center"><em>Delete Eliminar item</em></div>

## Pokémon API

- **GET /api/pokemon/ditto**: Obtener información de Ditto
  ![Get Obtener Ditto (Pokemon API)](ScreenShots/Get%20Obtener%20Ditto%20(Pokemon%20API).png)
  <div align="center"><em>Get Obtener Ditto (Pokemon API)</em></div>
- **GET /api/pokemon/{name}**: Obtener información de un Pokémon por nombre
  ![Get Obtener Pokemon por nombre (Pokemon API)](ScreenShots/Get%20Obtener%20Pokemon%20por%20nombre%20(Pokemon%20API).png)
  <div align="center"><em>Get Obtener Pokemon por nombre (Pokemon API)</em></div>

## Servicio de Cifrado

- **POST /api/cifrado/cifrar**: Cifrar un texto
  ![Post Cifrar texto](ScreenShots/Post%20Cifrar%20texto.png)
  <div align="center"><em>Post Cifrar texto</em></div>
- **POST /api/cifrado/descifrar**: Descifrar un texto
  ![Post Descifrar texto](ScreenShots/Post%20Descifrar%20texto.png)
  <div align="center"><em>Post Descifrar texto</em></div>