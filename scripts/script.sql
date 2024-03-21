-- Eliminar tabla Cita
DROP TABLE Cita;

-- Eliminar tabla Servicios
DROP TABLE Servicios;

-- Eliminar tabla Inventario
DROP TABLE Inventario;

-- Eliminar tabla Contacto
DROP TABLE Contacto;

-- Eliminar tabla Vehiculo sustitucion
DROP TABLE Vehiculo_sustitucion;

-- Eliminar tabla Vehiculo
DROP TABLE Vehiculo;

-- Eliminar tabla Usuario
DROP TABLE Usuario;

-- Eliminar secuencia usuario

Drop sequence SEQ_USUARIO;

-- Eliminar secuencia contacto

Drop sequence SEQ_CONTACTO;

-- Eliminar secuencia cita

Drop sequence SEQ_CITA;

-- Crear secuencia usuario

CREATE SEQUENCE SEQ_USUARIO
START WITH 1
INCREMENT BY 1
MAXVALUE 9999999999999999999
MINVALUE 1
NOCACHE
NOCYCLE;

-- Crear secuencia CONTACTO

CREATE SEQUENCE SEQ_CONTACTO
START WITH 1
INCREMENT BY 1
MAXVALUE 9999999999999999999
MINVALUE 1
NOCACHE
NOCYCLE;

-- Crear secuencia Cita

CREATE SEQUENCE SEQ_CITA
START WITH 1
INCREMENT BY 1
MAXVALUE 9999999999999999999
MINVALUE 1
NOCACHE
NOCYCLE;

-- Crear tabla Usuario
CREATE TABLE Usuario (
    ID_USUARIO VARCHAR2(50) PRIMARY KEY,
    NOMBRE VARCHAR2(100),
    APELLIDO VARCHAR2(100),
    TELEFONO VARCHAR2(20),
    MAIL VARCHAR2(100),
    PASSWD VARCHAR2(50),
    ROL NUMBER(1), 
    CONSTRAINT chk_rol CHECK (ROL IN (0, 1, 2))
);

-- Crear tabla Vehiculo
CREATE TABLE Vehiculo (
    FK_ID_USUARIO VARCHAR2(50),
    MATRICULA VARCHAR2(50) PRIMARY KEY,
    MODELO VARCHAR2(50),
    MARCA VARCHAR2(50),
    CONSTRAINT fk_usuario FOREIGN KEY (FK_ID_USUARIO) REFERENCES Usuario(ID_USUARIO)
);

-- Crear tabla Vehiculo sustitucion
CREATE TABLE Vehiculo_sustitucion (
    MATRICULA VARCHAR2(50) PRIMARY KEY,
    MODELO VARCHAR2(50),
    MARCA VARCHAR2(50),
    PRECIO_POR_DIA NUMBER(10,2),
    URL_IMAGEN VARCHAR2(255)
);

-- Crear tabla Contacto
CREATE TABLE Contacto (
    ID_CONTACTO VARCHAR2(50) PRIMARY KEY,
    NOMBRE VARCHAR2(100),
    CORREO VARCHAR2(100),
    MOTIVO VARCHAR2(200),
    MENSAJE VARCHAR2(500)
);

-- Crear tabla Inventario
CREATE TABLE Inventario (
    ID_PIEZA VARCHAR2(50) PRIMARY KEY,
    CANTIDAD NUMBER,
    PRECIO NUMBER(10,2),
    DESCRIPCION VARCHAR2(255),
    MARCA VARCHAR2(255),
    MODELO VARCHAR2(255),
    URL_IMAGEN VARCHAR2(255)
);

-- Crear tabla Servicios
CREATE TABLE Servicios (
    ID_SERVICIO NUMBER(10,2) PRIMARY KEY,
    NOMBRE VARCHAR2(100),
    MANO_DE_OBRA NUMBER(10,2)
);

-- Crear tabla Cita
CREATE TABLE Cita (
    ID_CITA VARCHAR2(50) PRIMARY KEY,
    FK_ID_USUARIO VARCHAR2(50),
    FK_MATRICULA VARCHAR2(50),
    ENTRADA TIMESTAMP,
    SALIDA TIMESTAMP,
    FK_SERVICIO NUMBER(10,2),
    FK_VEHICULO_REPARACION VARCHAR2(50),
    DESCRIPCION_DE_AVERIA VARCHAR2(500),
    CONSTRAINT fk_usuario_cita FOREIGN KEY (FK_ID_USUARIO) REFERENCES Usuario(ID_USUARIO),
    CONSTRAINT fk_vehiculo FOREIGN KEY (FK_MATRICULA) REFERENCES Vehiculo(MATRICULA),
    CONSTRAINT fk_servicio FOREIGN KEY (FK_SERVICIO) REFERENCES Servicios(ID_SERVICIO),
    CONSTRAINT fk_vehiculo_reparacion FOREIGN KEY (FK_VEHICULO_REPARACION) REFERENCES Vehiculo_sustitucion(MATRICULA)
);

-- Insertar datos Servicios

INSERT INTO Servicios (ID_SERVICIO, NOMBRE, MANO_DE_OBRA) VALUES ('1', 'Cambio de aceite', 2);
INSERT INTO Servicios (ID_SERVICIO, NOMBRE, MANO_DE_OBRA) VALUES ('2', 'Cambio de ruedas', 2);
INSERT INTO Servicios (ID_SERVICIO, NOMBRE, MANO_DE_OBRA) VALUES ('3', 'Cambio de bateria', 1);
INSERT INTO Servicios (ID_SERVICIO, NOMBRE, MANO_DE_OBRA) VALUES ('4', 'Averia mecanica', 4);

-- Insertar datos vehiculo_sustitucion

INSERT INTO VEHICULO_SUSTITUCION (MATRICULA, MODELO, MARCA, PRECIO_POR_DIA,URL_IMAGEN) VALUES ('MAT1234', 'e', 'Honda', 50.00,'../assets/imagenes/honda.jpg');
INSERT INTO VEHICULO_SUSTITUCION (MATRICULA, MODELO, MARCA, PRECIO_POR_DIA,URL_IMAGEN) VALUES ('MAT5678', '5E', 'Renault', 55.00,'../assets/imagenes/e5.jpg');
INSERT INTO VEHICULO_SUSTITUCION (MATRICULA, MODELO, MARCA, PRECIO_POR_DIA,URL_IMAGEN) VALUES ('MAT9012', 'E-Up', 'Volkswagen', 60.00,'../assets/imagenes/eup.jpeg');

-- Insertar datos inventario

INSERT INTO INVENTARIO (ID_PIEZA, CANTIDAD, PRECIO, MARCA, MODELO, DESCRIPCION, URL_IMAGEN) VALUES (1, 15, 20,'Opel','Corsa', 'Aceite para el motor', '../../assets/imagenes/aceiteCoche.jpg');
INSERT INTO INVENTARIO (ID_PIEZA, CANTIDAD, PRECIO, MARCA, MODELO, DESCRIPCION, URL_IMAGEN) VALUES (2, 23, 17.23, '','', 'Liquido anticongelante', '../../assets/imagenes/anticongelante.jpg');
INSERT INTO INVENTARIO (ID_PIEZA, CANTIDAD, PRECIO, MARCA, MODELO, DESCRIPCION, URL_IMAGEN) VALUES (3, 12, 12, '','', 'Filtro de aire', '../../assets/imagenes/filtroCoche.jpg');
INSERT INTO INVENTARIO (ID_PIEZA, CANTIDAD, PRECIO, MARCA, MODELO, DESCRIPCION, URL_IMAGEN) VALUES (4, 7, 70, '','', 'Bateria de coche 70aH 640A', '../../assets/imagenes/bateria.jpg');
INSERT INTO INVENTARIO (ID_PIEZA, CANTIDAD, PRECIO, MARCA, MODELO, DESCRIPCION, URL_IMAGEN) VALUES (5, 18, 64, '','', 'Discos de freno', '../../assets/imagenes/discos.jpg');
INSERT INTO INVENTARIO (ID_PIEZA, CANTIDAD, PRECIO, MARCA, MODELO, DESCRIPCION, URL_IMAGEN) VALUES (6, 32, 27.11, '','', 'Juego de pastillas de freno', '../../assets/imagenes/pastillas.jpg');
INSERT INTO INVENTARIO (ID_PIEZA, CANTIDAD, PRECIO, MARCA, MODELO, DESCRIPCION, URL_IMAGEN) VALUES (7, 64, 102.50, '','', 'Neumaticos Michelin', '../../assets/imagenes/neumaticos.jpg');
commit;