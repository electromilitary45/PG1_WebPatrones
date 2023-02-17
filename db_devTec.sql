-------- comandos DANGER-------
drop database  dev_tech;

-- Creacion de database--
Create database dev_tech;
use dev_tech;

----
CREATE TABLE usuarios (
  idUsuario INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(20) not null,
  primApellido VARCHAR(20) not null,
  segApellido VARCHAR(20) not null,
  correo VARCHAR(60) not null UNIQUE ,
  contrasena VARCHAR(50) CHECK (LENGTH(contrasena) >= 8) not null ,
  rol ENUM('cliente', 'administrador') not null,
  numTelefono VARCHAR (8) CHECK(LENGTH(numTelefono)=8) not null,
  status ENUM('activo', 'inactivo')  default 'activo' not null
);

CREATE TABLE servicio (
  idServicio  INT PRIMARY KEY AUTO_INCREMENT not null,
  status ENUM('activo', 'inactivo')  default 'activo' not null,
  nombreServicio VARCHAR(30) not null,
  descripción VARCHAR(255) not null,
  precio BIGINT not null
);

CREATE TABLE cita(
  idCita INT PRIMARY KEY AUTO_INCREMENT not null,
  idUsuario INT  not null,
  fecha_cita DATE not null,
  hora_cita TIME not null,
  fechaRechazada DATE null,
  URLMapa VARCHAR(255)null,
  status ENUM('pendiente', 'aceptada', 'rechazada') default 'pendiente' not null,
  FOREIGN KEY (idUsuario) REFERENCES usuarios(idUsuario)
);

CREATE TABLE cita_servicios (
  idCita INT not NULL,
  idServicio  INT not NULL,
  PRIMARY KEY (idCita,  idServicio),
  FOREIGN KEY (idCita) REFERENCES cita(idCita),
  FOREIGN KEY (idServicio) REFERENCES servicio (idServicio)
);

CREATE TABLE facturas (
  idFactura INT PRIMARY KEY AUTO_INCREMENT,
  idCita INT,
  fecha_factura DATE,
  total DECIMAL(10,2),
  FOREIGN KEY (idCita) REFERENCES cita(idCita)
);

----- CONSULTAS USUARIOS ----
SELECT * FROM usuarios;

----- CONSULTAS SERVICIOS ----
SELECT * FROM servicio;

----- CONSULTAS CITAS ----
SELECT * FROM cita;

------------------------------
----- INSERT USUARIOS ----

insert into usuarios (nombre, primApellido,segApellido,correo, contrasena,rol,numTelefono,status) 
values ('Derek','Leiva','Villalobos','electronico@gmail.com','asd123asd123ads','cliente','88884444','activo');

----- INSERT SERVICIOS ----
insert INTO servicio (nombreServicio, descripción, precio) values ('Cambio de pasta termica','Cambio de pasta terminca para computadora, puede ser Laptop o Desktop', 1000);

----- INSERT CITAS ----
insert into cita (idUsuario, fecha_cita, hora_cita, URLMapa) values (1,'2021-05-20','10:00:00','https://www.google.com/maps/place/cargo');

update cita set URLMapa='alo' WHERE idCita=1;
