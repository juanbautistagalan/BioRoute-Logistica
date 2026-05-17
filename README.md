# BioRoute - Sistema de Gestión Logística y Trazabilidad

Sistema de información para la gestión logística y trazabilidad de alimentos orgánicos.

Proyecto desarrollado como Trabajo Práctico para la materia Seminario de Práctica de Informática — Universidad Siglo 21.

## Tecnologías

- Java (JDK 17+)
- MySQL 8.0
- JDBC (MySQL Connector/J)

## Estructura del proyecto

- `sql/` — Scripts de creación de base de datos, inserción de datos y consultas.
- `src/bioroute/` — Código fuente del prototipo en Java.

## Instalación y ejecución

1. Crear la base de datos ejecutando `sql/01_crear_base.sql` en MySQL.
2. Insertar datos de ejemplo con `sql/02_insertar_datos.sql`.
3. Agregar el driver `mysql-connector-j` al classpath del proyecto.
4. Compilar y ejecutar desde `src/bioroute/Main.java`.

## Base de datos

El sistema utiliza el esquema `bioroute_db` con las siguientes tablas:

- `usuarios` — Usuarios del sistema (Administrativo / Repartidor).
- `clientes` — Clientes de la empresa.
- `productos` — Productos orgánicos con control de stock.
- `pedidos` — Pedidos vinculados a clientes.
- `detalle_pedido` — Productos incluidos en cada pedido.
- `estado_pedido` — Historial de estados para trazabilidad.

## Autor

Juan Bautista Galán — VINFO14627

Universidad Siglo 21 — Seminario de Práctica de Informática — 2026
