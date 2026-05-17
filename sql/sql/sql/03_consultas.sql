-- =============================================
-- BioRoute - Consultas SQL de negocio
-- =============================================

USE bioroute_db;

-- 1. Productos por debajo del stock mínimo
SELECT id_producto, nombre, categoria, stock_actual, stock_minimo
FROM productos
WHERE stock_actual <= stock_minimo;

-- 2. Pedidos por cliente con estado actual
SELECT p.id_pedido, c.nombre AS cliente, p.fecha_creacion, p.estado_actual
FROM pedidos p
INNER JOIN clientes c ON p.id_cliente = c.id_cliente
ORDER BY p.fecha_creacion DESC;

-- 3. Trazabilidad completa de un pedido
SELECT ep.estado, ep.fecha_hora, u.nombre_usuario AS responsable
FROM estado_pedido ep
INNER JOIN usuarios u ON ep.id_usuario = u.id_usuario
WHERE ep.id_pedido = 1
ORDER BY ep.fecha_hora ASC;

-- 4. Detalle de un pedido con productos
SELECT dp.id_detalle, pr.nombre AS producto, dp.cantidad,
       pr.precio_unitario, dp.subtotal
FROM detalle_pedido dp
INNER JOIN productos pr ON dp.id_producto = pr.id_producto
WHERE dp.id_pedido = 1;

-- 5. Total facturado por pedido
SELECT dp.id_pedido, c.nombre AS cliente,
       SUM(dp.subtotal) AS total_facturado
FROM detalle_pedido dp
INNER JOIN pedidos p ON dp.id_pedido = p.id_pedido
INNER JOIN clientes c ON p.id_cliente = c.id_cliente
GROUP BY dp.id_pedido, c.nombre;
