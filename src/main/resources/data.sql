-- Insertar roles
INSERT INTO roles (nombre) VALUES ('ROLE_ADMIN');
INSERT INTO roles (nombre) VALUES ('ROLE_USER');

-- Insertar usuario administrador (contraseña: admin123)
INSERT INTO usuarios (username, password, nombre, apellido, email, enabled) 
VALUES ('admin', '$2a$10$PaSEt217DPmbCfdnM74zheogJH1KBOY.8.8pW.RqfWcPvgo.vifrW', 'Administrador', 'Sistema', 'admin@sistema.com', true);

-- Insertar usuario normal (contraseña: user123)
INSERT INTO usuarios (username, password, nombre, apellido, email, enabled) 
VALUES ('user', '$2a$10$7kkEnkSy7dmss2e7LwWIhu9YyY/iSOvsFE4OEtFvp8SUYJxBtJwt2', 'Usuario', 'Normal', 'user@sistema.com', true);

-- Asignar roles a usuarios
INSERT INTO usuarios_roles (usuario_id, rol_id) VALUES (1, 1); -- admin -> ROLE_ADMIN
INSERT INTO usuarios_roles (usuario_id, rol_id) VALUES (2, 2); -- user -> ROLE_USER

-- Insertar items de ejemplo
INSERT INTO items (nombre, descripcion, precio, categoria, disponible) 
VALUES ('Laptop HP', 'Laptop HP Pavilion 15 pulgadas', 12999.99, 'Electrónica', true);

INSERT INTO items (nombre, descripcion, precio, categoria, disponible) 
VALUES ('Smartphone Samsung', 'Samsung Galaxy S21', 9999.99, 'Electrónica', true);

INSERT INTO items (nombre, descripcion, precio, categoria, disponible) 
VALUES ('Audífonos Sony', 'Audífonos inalámbricos con cancelación de ruido', 2499.99, 'Electrónica', true);

INSERT INTO items (nombre, descripcion, precio, categoria, disponible) 
VALUES ('Teclado Mecánico', 'Teclado mecánico para gaming', 1299.99, 'Accesorios', true);

INSERT INTO items (nombre, descripcion, precio, categoria, disponible) 
VALUES ('Mouse Logitech', 'Mouse inalámbrico ergonómico', 599.99, 'Accesorios', true);

INSERT INTO items (nombre, descripcion, precio, categoria, disponible) 
VALUES ('Monitor LG', 'Monitor LG 27 pulgadas 4K', 5999.99, 'Electrónica', false);

INSERT INTO items (nombre, descripcion, precio, categoria, disponible) 
VALUES ('Impresora Epson', 'Impresora multifuncional a color', 3499.99, 'Oficina', true);

INSERT INTO items (nombre, descripcion, precio, categoria, disponible) 
VALUES ('Disco Duro Externo', 'Disco duro externo 1TB', 1199.99, 'Almacenamiento', true);

INSERT INTO items (nombre, descripcion, precio, categoria, disponible) 
VALUES ('Memoria USB', 'Memoria USB 64GB', 299.99, 'Almacenamiento', true);

INSERT INTO items (nombre, descripcion, precio, categoria, disponible) 
VALUES ('Tablet iPad', 'Apple iPad Pro 11 pulgadas', 14999.99, 'Electrónica', false);