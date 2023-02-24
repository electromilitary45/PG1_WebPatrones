-------- comandos DANGER-------
drop SCHEMA  dev_tech;
drop table dev_tech.usuario;

drop user dev_techU;

-------- USUARIOS Y CONTRASENAS DE ACCESO
create user 'dev_techU'@'%' identified by 'clave1234';
grant all privileges on dev_tech.* to 'dev_techU'@'%';
flush privileges;

create user 'usuario_prueba'@'%' identified by 'Usuar1o_Clave.';
grant all privileges on dev_tech.* to 'usuario_prueba'@'%';
flush privileges;

-- Creacion de database--
Create SCHEMA dev_tech;
use dev_tech;



----
CREATE TABLE dev_tech.usuario (
  id_Usuario INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(20) not null,
  primapellido VARCHAR(20) not null,
  segapellido VARCHAR(20) not null,
  correo VARCHAR(60) not null,
  contrasena VARCHAR(50) CHECK (LENGTH(contrasena) >= 8) not null ,
  rol varchar(20) not null,
  numtelefono VARCHAR (8) CHECK(LENGTH(numtelefono)=8) not null,
  status varchar(20) default 'activo' not null,
  PRIMARY KEY (`id_Usuario`))

 ENGINE = InnoDB
 DEFAULT CHARACTER SET = utf8mb4
 COLLATE = utf8mb4_eo_0900_ai_ci;


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
  FOREIGN KEY (id_Usuario) REFERENCES usuarios(id_Usuario)
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
SELECT * FROM dev_tech.usuario;

----- CONSULTAS SERVICIOS ----
SELECT * FROM servicio;

----- CONSULTAS CITAS ----
SELECT * FROM cita;

------------------------------
----- INSERT USUARIOS ----

insert into dev_tech.usuario (nombre, primapellido,segapellido,correo, contrasena,rol,numtelefono,status) 
values ('Derek','Leiva','Villalobos','electronico@gmail.com','asd123asd123ads','cliente','88884444','activo');

insert into usuario (nombre, primApellido,segApellido,correo, contrasena,rol,numTelefono,status) 
values ('Sebastian','Cerdas','Cedeño','sebas.cc22@gmail.com','sebas2207','administrador','72097414','activo');

----- INSERT SERVICIOS ----
insert INTO servicio (nombreServicio, descripción, precio) values ('Cambio de pasta termica','Cambio de pasta terminca para computadora, puede ser Laptop o Desktop', 1000);

----- INSERT CITAS ----
insert into cita (idUsuario, fecha_cita, hora_cita, URLMapa) values (1,'2021-05-20','10:00:00','https://www.google.com/maps/place/cargo');

update cita set URLMapa='alo' WHERE idCita=1;