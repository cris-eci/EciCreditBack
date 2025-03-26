## EciCredit - Sistema Bancario

Este repositorio contiene el proyecto del sistema bancario EciCredit, una aplicación full-stack para la gestión de facturas y pagos.

### Arquitectura

#### Arquitectura Backend
El backend está construido utilizando una aplicación Spring Boot con MongoDB como base de datos. La arquitectura sigue un enfoque clásico por capas:

- **Capa de Controladores**: Maneja las peticiones HTTP y delega a los servicios
- **Capa de Servicios**: Contiene la lógica de negocio
- **Capa de Repositorios**: Interactúa con la base de datos MongoDB
- **Capa de Modelos**: Contiene los modelos de datos

![Diagrama de Clases](image-1.png)

#### Arquitectura Frontend
El frontend está construido con React y styled-components siguiendo una arquitectura basada en componentes:
- **Servicios**: Capa de comunicación con API (axios)
- **Componentes**: Componentes UI reutilizables
- **Estilos**: Estilizado global con styled-components

### Tecnologías Utilizadas

#### Backend
- Java 17
- Spring Boot 3.4.4
- MongoDB
- JaCoCo para cobertura de código
- Maven para gestión de dependencias

#### Frontend
- React 19
- Axios para comunicación con API
- Styled Components para estilizado
- React Testing Library para pruebas

### Cómo Ejecutar el Proyecto

#### Backend
1. Clonar el repositorio
2. Asegurar tener instalados Java 17 y Maven
3. Navegar al directorio EciCredit-Back
4. Ejecutar `mvn spring-boot:run`

#### Frontend
1. Navegar al directorio ecibank-front
2. Ejecutar `npm install`
3. Ejecutar `npm start`
4. Acceder a la aplicación en http://localhost:3000

### Endpoints de API

El backend proporciona los siguientes endpoints de API:

- `GET /api/bills/user/{userId}` - Obtener todas las facturas de un usuario específico
- `POST /api/bills` - Crear una nueva factura

### Cobertura de Código

El proyecto mantiene una alta cobertura de pruebas utilizando JaCoCo:

![Cobertura de Pruebas](image.png)

### Escenarios de la Aplicación

#### Listado de Facturas de Usuario
La aplicación permite ver todas las facturas asociadas a un ID de usuario. Actualmente, el sistema tiene facturas para el usuario con ID 12345.

![Listado de Facturas de Usuario](image-2.png)

#### Vista de Detalles de Factura
Al seleccionar una factura, los usuarios pueden ver información detallada incluyendo el estado, fecha de creación, monto total y elementos individuales.

En el back solo hay un usuario que es que se vé ahí

![Detalles de Factura](image-3.png)

#### Creación de Nueva Factura
Los usuarios pueden crear nuevas facturas completando la información requerida.

![Creación de Factura](image-4.png)

#### Añadir Elementos a una Factura
La interfaz permite añadir múltiples elementos a una factura antes de enviarla.

![Añadir Elementos](image-5.png)

#### Procesamiento de Transacción
Después del envío, el sistema procesa la transacción y muestra un estado (aprobada/rechazada).

![Transacción Aprobada](image-6.png)

### Despliegue

El backend está desplegado en Azure y accesible en:
https://dragon-ete4agc5byajakbd.canadacentral-01.azurewebsites.net/

crear bill
![alt text](image-4.png)

añadir items
![alt text](image-5.png)

transaction aproved
![alt text](image-6.png)