-- Creación de la base de datos para BioRoute
CREATE DATABASE IF NOT EXISTS bioroute_db;
USE bioroute_db;

-- Tabla de Clientes
CREATE TABLE IF NOT EXISTS clientes (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    cuit_dni VARCHAR(20) UNIQUE NOT NULL,
    direccion VARCHAR(150)
);

-- Tabla de Productos (para gestión de Stock)
CREATE TABLE IF NOT EXISTS productos (
    id_producto INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    stock_actual INT DEFAULT 0,
    stock_minimo INT DEFAULT 10,
    precio DECIMAL(10,2)
);

-- Tabla de Pedidos (Trazabilidad)
CREATE TABLE IF NOT EXISTS pedidos (
    id_pedido INT AUTO_INCREMENT PRIMARY KEY,
    id_cliente INT,
    fecha_creacion DATETIME DEFAULT CURRENT_TIMESTAMP,
    estado_envio ENUM('Pendiente', 'En Preparacion', 'En Ruta', 'Entregado') DEFAULT 'Pendiente',
    FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente)
);

-- Datos iniciales para que el profe vea que funciona
INSERT INTO clientes (nombre, cuit_dni, direccion) VALUES ('Juan Perez', '20-35444555-9', 'Av. Colon 1200');
INSERT INTO productos (nombre, stock_actual, stock_minimo, precio) VALUES ('Manzanas Orgánicas 1kg', 45, 10, 1200.00);