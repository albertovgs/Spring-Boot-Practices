# CRUD de Productos - Spring Boot

## Descripción
Aplicación Spring Boot que implementa un CRUD (Create, Read, Update, Delete) básico para la gestión de productos. Es un proyecto de demostración que utiliza Spring Boot 3.5.6 con Java 17.

## Tecnologías Utilizadas
- **Spring Boot 3.5.6**
- **Java 17**
- **Spring Data JPA** - Para persistencia de datos
- **Spring Web** - Para crear APIs REST
- **Spring Boot Actuator** - Para monitoreo y métricas
- **H2 Database** - Base de datos en memoria para desarrollo
- **Maven** - Gestión de dependencias

## Estructura del Proyecto

```
src/main/java/alberto/vgs/crud/
├── CrudApplication.java          # Clase principal de la aplicación
├── controller/
│   └── ProductController.java    # Controlador REST para productos
├── entity/
│   └── Product.java             # Entidad JPA del producto
├── repository/
│   └── ProductRepository.java   # Repositorio JPA para productos
└── services/
    └── ProductService.java      # Lógica de negocio para productos
```

## Modelo de Datos

### Entidad Product
La entidad `Product` representa un producto con los siguientes atributos:

- `id` (Long): Identificador único, generado automáticamente
- `name` (String): Nombre del producto
- `description` (String): Descripción del producto
- `price` (Double): Precio del producto

## API REST Endpoints

La aplicación expone los siguientes endpoints REST bajo la ruta base `/api/products`:

### Obtener todos los productos
```http
GET /api/products/all
```
**Respuesta**: Lista de todos los productos

### Obtener producto por ID
```http
GET /api/products/{id}
```
**Parámetros**: 
- `id` (Long): ID del producto
**Respuesta**: Producto encontrado o 404 si no existe

### Crear nuevo producto
```http
POST /api/products
```
**Body**: JSON con los datos del producto
```json
{
  "name": "Nombre del producto",
  "description": "Descripción del producto",
  "price": 99.99
}
```
**Respuesta**: Producto creado con su ID asignado

### Actualizar producto
```http
PUT /api/products/{id}
```
**Parámetros**: 
- `id` (Long): ID del producto a actualizar
**Body**: JSON con los nuevos datos del producto
**Respuesta**: Producto actualizado

### Eliminar producto
```http
DELETE /api/products/{id}
```
**Parámetros**: 
- `id` (Long): ID del producto a eliminar
**Respuesta**: 204 No Content si se elimina correctamente

## Configuración

### Base de Datos
La aplicación utiliza H2 como base de datos en memoria. La configuración se encuentra en `application.properties`:

```properties
spring.application.name=crud
```

Para acceder a la consola de H2 (en desarrollo), visita: `http://localhost:8080/h2-console`

## Cómo Ejecutar

### Prerrequisitos
- Java 17 o superior
- Maven 3.6 o superior

### Ejecución
1. Clonar el repositorio
2. Navegar al directorio del proyecto
3. Ejecutar con Maven:
```bash
./mvnw spring-boot:run
```

O compilar y ejecutar el JAR:
```bash
./mvnw clean package
java -jar target/crud-0.0.1-SNAPSHOT.jar
```

La aplicación estará disponible en `http://localhost:8080`

## Ejemplos de Uso

### Crear un producto
```bash
curl -X POST http://localhost:8080/api/products \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Laptop",
    "description": "Laptop para desarrollo",
    "price": 1299.99
  }'
```

### Obtener todos los productos
```bash
curl http://localhost:8080/api/products/all
```

### Obtener un producto específico
```bash
curl http://localhost:8080/api/products/1
```

### Actualizar un producto
```bash
curl -X PUT http://localhost:8080/api/products/1 \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Laptop Gaming",
    "description": "Laptop para gaming y desarrollo",
    "price": 1599.99
  }'
```

### Eliminar un producto
```bash
curl -X DELETE http://localhost:8080/api/products/1
```

## Arquitectura

El proyecto sigue el patrón de arquitectura en capas:

1. **Capa de Presentación** (`ProductController`): Maneja las peticiones HTTP y respuestas
2. **Capa de Servicio** (`ProductService`): Contiene la lógica de negocio
3. **Capa de Persistencia** (`ProductRepository`): Maneja el acceso a datos
4. **Capa de Modelo** (`Product`): Define las entidades del dominio

## Monitoreo

La aplicación incluye Spring Boot Actuator para monitoreo. Los endpoints de actuator están disponibles en:
- `http://localhost:8080/actuator/health` - Estado de la aplicación
- `http://localhost:8080/actuator/info` - Información de la aplicación

## Notas de Desarrollo

- La base de datos H2 es volátil y se reinicia con cada ejecución de la aplicación
- Para producción, se recomienda cambiar a una base de datos persistente como PostgreSQL o MySQL
- El proyecto incluye manejo básico de errores con excepciones `RuntimeException`

## Autor
Alberto VGS

## Licencia
Proyecto de demostración - Spring Boot CRUD