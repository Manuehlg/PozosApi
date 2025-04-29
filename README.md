# 🌱 API REST – Proyecto Pozos

>   **Módulo Backend** del sistema de gestión y monitoreo de explotaciones y pozos de agua.
>
>   Trabajo de Fin de Grado
>
>   Framework: **Spring Boot 3.4.4**
>
>   Motor de base de datos: **MySQL 8**
>
>   Autor: **Manuel Lemus Gil**

## 📋 Descripción del proyecto

Este proyecto consiste en el desarrollo de un módulo backend para un sistema de gestión y monitoreo de explotaciones y pozos de agua. La API RESTful desarrollada permite la interacción con la base de datos, facilitando la gestión de usuarios, explotaciones agrícolas o industriales, y los pozos de agua asociados. El objetivo principal es proporcionar una herramienta robusta y eficiente para la administración y el seguimiento de los recursos hídricos, lo cual es crucial para la optimización de su uso y la sostenibilidad.

Las operaciones CRUD (Crear, Leer, Actualizar y Borrar) están disponibles para las entidades principales, y las relaciones entre ellas se han definido mediante JPA (Java Persistence API).

## 📦 Estructura del proyecto

El proyecto se organiza en la siguiente estructura de paquetes:

src/main/java/com/proyecpo/pozos/├── controller/    # Controladores REST (Pozo, Explotacion, Usuario)├── entity/        # Entidades JPA├── repository/    # Interfaces JpaRepository└── service/       # Lógica de negocio (servicios)
## 🚀 Cómo ejecutar

### 🛠 Requisitos previos

Para la correcta ejecución de este proyecto, es necesario tener instalado lo siguiente:

* JDK 21
* Maven 3.9+
* MySQL 8+
* Puerto de MySQL habilitado (por defecto `3306`)

### ▶️ Ejecutar con Maven

El proyecto puede ejecutarse utilizando el siguiente comando de Maven:

./mvnw spring-boot:run
También se puede compilar el proyecto y ejecutar el JAR generado:

./mvnw clean installjava -jar target/pozosapi-0.0.1-SNAPSHOT.jar

### 📡 Endpoints principales

La API expone los siguientes endpoints:

| Método | Endpoint | Descripción |
| :----- | :-------------------------- | :-------------------------------------------- |
| GET | /api/usuarios | Obtener usuarios |
| POST | /api/usuarios/login | Iniciar sesión |
| GET | /api/explotaciones/usuario/{id} | Obtener explotaciones de un usuario |
| POST | /api/explotaciones | Crear nueva explotación |
| DELETE | /api/explotaciones/{id} | Eliminar explotación |
| GET | /api/pozos/explotacion/{id} | Obtener pozos de una explotación |
| POST | /api/pozos | Crear nuevo pozo |
| PUT | /api/pozos/{id} | Actualizar pozo |
| DELETE | /api/pozos/{id} | Eliminar pozo |

### 📚 Entidades

El proyecto gestiona las siguientes entidades:

**Usuario**

* id
* email
* password
* Lista de explotaciones

**Explotacion**

* id
* nombre
* ubicacion
* Usuario propietario
* Lista de pozos

**Pozo**

* id
* nombre
* caracteristicas
* Explotacion asociada

### 🧪 Testing y herramientas recomendadas

Para facilitar el testing de la API, se recomienda utilizar Postman. Para la gestión de la base de datos, MySQL Workbench es una herramienta muy útil. Además, se han habilitado los logs de Hibernate para facilitar la depuración, mostrando las consultas SQL y los parámetros utilizados.

### ✍️ Autor

Manuel Lemus Gil
📧 [manuel.lemus@example.com](mailto:manuel.lemus@example.com)
🔗 [GitHub](https://github.com) · [LinkedIn](https://linkedin.com)
