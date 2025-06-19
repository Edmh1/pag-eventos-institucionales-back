# 📅 Backend - Página de Eventos Institucionales

Este proyecto es el backend de una aplicación web para la gestión de eventos institucionales. Está construido con **Spring Boot**, utilizando **JPA** para el acceso a datos, **Swagger** para la documentación de la API y está conectado a una base de datos **PostgreSQL**. El frontend, desarrollado de forma independiente en HTML, CSS y JavaScript, consume esta API REST mediante peticiones AJAX.

---

## 🚀 Tecnologías utilizadas

- Java 17+
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Swagger (OpenAPI 3)
- Maven
- CORS habilitado
- Arquitectura MVC organizada por servicios

---

## 🎯 Funcionalidades principales

- ✅ Registro y login de usuarios (funcionarios y estudiantes)
- ✅ Gestión de eventos institucionales (crear, editar, eliminar, listar)
- ✅ Asignación de roles (funcionario, estudiante, administrador de eventos)
- ✅ Comentarios y likes en eventos
- ✅ Control de acceso según rol
- ✅ Conexión segura entre frontend y backend mediante configuración CORS

---

## 🗂️ Estructura del proyecto

El backend sigue una arquitectura basada en MVC organizada por dominio y servicio:
<br>
src/nombre_servicio
<br>
├── controller/ # Controladores REST
<br>
├── service/ # Lógica de negocio
<br>
├── model/ # Entidades JPA
<br>
├── repository/ # Interfaces JPA
<br>
├── dto/ # Clases de transferencia de datos
<br>
└── config/ # Configuraciones (CORS, Swagger, seguridad, etc.)
 
## 📘 Documentación API

El proyecto incluye documentación automática de la API generada con Swagger.

📄 Accede a la documentación en:  
https://pag-eventos-institucionales-back.onrender.com/swagger-ui/index.html#/

---

## 🌐 Comunicación con el frontend

- Comunicación vía **API REST** con peticiones **AJAX** (JavaScript)
- Frontend desplegado en un dominio distinto
- Configuración **CORS** habilitada para permitir la comunicación entre dominios

---

## 🔐 Seguridad y roles

El sistema diferencia roles mediante su relación en base de datos:

- **Estudiante**
- **Funcionario**
- **Administrador de eventos** (subtipo de funcionario con permisos especiales)

Solo los administradores de eventos pueden crear o modificar eventos.
