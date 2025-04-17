/*
 CREATE DATABASE prueba_tecnica;
-- creacion de la base

-- uso de la base
 USE prueba_tecnica;

-- creacion de la tabla clientes
 CREATE TABLE Clientes (
    id INT PRIMARY KEY,
    nombre VARCHAR(100),
    email VARCHAR(100),
    fecha_registro DATE
);

-- creacion de la tabla pedidos

CREATE TABLE Pedidos (
    id INT PRIMARY KEY,
    cliente_id INT,
    monto DECIMAL(10,2),
    fecha_pedido DATE,
    FOREIGN KEY (cliente_id) REFERENCES Clientes(id)
);

-- Insertar clientes
INSERT INTO Clientes (id, nombre, email, fecha_registro) VALUES
(1, 'Juan Perez', 'juan@banco.com', '2022-01-10'),
(2, 'Laura Gomez', 'laura@banco.com', '2022-02-15'),
(3, 'Carlos Ruiz', 'carlos@banco.com', '2022-03-20'),
(4, 'Marta Lopez', 'marta@banco.com', '2022-04-25'),
(5, 'Pedro Mendoza', 'pedro@ebanco.com', '2022-05-30');

-- Insertar pedidos
INSERT INTO Pedidos (id, cliente_id, monto, fecha_pedido) VALUES
(1, 1, 5000.00, '2023-01-05'),
(2, 1, 7000.00, '2023-02-10'),
(3, 2, 12000.00, '2023-03-18'),
(4, 3, 8000.00, '2023-04-22'),
(5, 4, 2000.00, '2023-05-15'),
(6, 5, 3000.00, '2023-06-01'),
(7, 5, 7500.00, '2023-06-20'),
(8, 3, 4000.00, '2023-07-05'),
(9, 2, 8500.00, '2023-08-11'),
(10, 4, 9000.00, '2023-08-30');


SELECT c.nombre, SUM(p.monto) AS total_gastado
FROM Clientes c
JOIN Pedidos p ON c.id = p.cliente_id
GROUP BY c.nombre;


SELECT c.nombre, SUM(p.monto) AS total_gastado
FROM Clientes c
JOIN Pedidos p ON c.id = p.cliente_id
GROUP BY c.nombre
HAVING SUM(p.monto) > 1000;

INSERT INTO Clientes (id, nombre, email, fecha_registro) VALUES
(6, 'Juan felipe', 'juan2@banco.com', '2024-01-11'),
(7, 'Laura palta', 'laura2@banco.com', '2024-02-12');


INSERT INTO Pedidos (id, cliente_id, monto, fecha_pedido) VALUES
(11, 6, 15000.00, '2025-01-05'),
(12, 7, 10000.00, '2025-02-10');

SELECT c.nombre, SUM(p.monto) AS total_gastado
FROM Clientes c
JOIN Pedidos p ON c.id = p.cliente_id
GROUP BY c.nombre;
*/