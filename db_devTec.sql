-------- comandos DANGER-------
drop SCHEMA  dev_tech;
drop table dev_tech.usuario;
drop table dev_tech.facturas;
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
  status bool,
  PRIMARY KEY (`id_Usuario`)
  );



CREATE TABLE dev_tech.servicio (
  id_Servicio  INT PRIMARY KEY AUTO_INCREMENT not null,
  imagen varchar(256),
  status bool,
  nombre_Servicio VARCHAR(30) not null,
  descripcion VARCHAR(255) not null,
  precio BIGINT not null
);

CREATE TABLE dev_tech.cita(
  id_Cita INT PRIMARY KEY AUTO_INCREMENT not null,
  id_Usuario INT  not null,
  id_Servicio int not null,
  fecha_Cita DATE not null,
  hora_Cita TIME not null,
  fecha_Rechazada DATE null,
  url_Mapa VARCHAR(255)null,
  status VARCHAR(15) default 'pendiente' not null, /*--pendiente, aceptada, rechazada*/
  FOREIGN KEY (id_Usuario) REFERENCES dev_tech.usuario(id_Usuario),
  FOREIGN KEY (id_Servicio) REFERENCES dev_tech.servicio(id_Servicio)
)

ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_eo_0900_ai_ci;

/*CREATE TABLE cita_servicios (
  idCita INT not NULL,
  idServicio  INT not NULL,
  PRIMARY KEY (idCita,  idServicio),
  FOREIGN KEY (idCita) REFERENCES cita(idCita),
  FOREIGN KEY (idServicio) REFERENCES servicio (idServicio)
);*/

/*
CREATE TABLE dev_tech.facturas (
  id_Factura INT PRIMARY KEY AUTO_INCREMENT,
  id_Cita INT not null,
  fecha_Factura DATE,
  total DECIMAL(10,2),
  FOREIGN KEY (id_Cita) REFERENCES cita(id_Cita)
);
*/

 

----- CONSULTAS USUARIOS ----
SELECT * FROM dev_tech.usuario;

----- CONSULTAS SERVICIOS ----
SELECT * FROM dev_tech.servicio;

----- CONSULTAS CITAS ----
SELECT * FROM dev_tech.cita;

------------------------------
----- INSERT USUARIOS ----

insert into dev_tech.usuario (nombre, primapellido,segapellido,correo, contrasena,rol,numtelefono,status) 
values ('Derek','Leiva','Villalobos','electronico@gmail.com','asd123asd123ads','cliente','88884444',1);

insert into usuario (nombre, primApellido,segApellido,correo, contrasena,rol,numTelefono,status) 
values ('Sebastian','Cerdas','Cedeño','sebas.cc22@gmail.com','sebas2207','administrador','72097414',1);

----- INSERT SERVICIOS ----
insert INTO servicio (status, nombre_Servicio, descripcion, precio,imagen) values (1, 'Cambio de pasta termica','Cambio de pasta terminca para computadora, puede ser Laptop o Desktop', 1000,"https://i0.wp.com/radiocitycba.com.ar/wp-content/uploads/2023/03/Pasta-termica-grafica-930x487-1.webp?resize=768%2C402&ssl=1");
insert INTO servicio (status, nombre_Servicio, descripcion, precio,imagen) values (1, 'Cambio de memorias Ram','Cambio de memorias de ram para computadora, puede ser Laptop o Desktop', 1000,"https://cdn.computerhoy.com/sites/navi.axelspringer.es/public/media/image/2017/09/memoria-ram-pc.jpg?tf=3840x");

update servicio set nombre_Servicio = "Cambio de Memorias Ram" where id_Servicio=2;

----- INSERT CITAS ----
insert into cita(id_Usuario, id_Servicio, fecha_Cita, hora_Cita, url_Mapa, status) values (1,1,'2021-05-20','10:00:00','https://www.google.com/maps/place/cargo', 'pendiente');
insert into cita(id_Usuario, id_Servicio, fecha_Cita, hora_Cita, url_Mapa, status) values (2,1,'2023-07-22','9:30:00','https://www.google.com/maps/place/cargo', 'pendiente');
insert into cita(id_Usuario, id_Servicio, fecha_Cita, hora_Cita, url_Mapa, status) values (1,1,'2021-05-20','10:00:00','https://www.google.com/maps/place/cargo', 'pendiente');

update cita set URLMapa='alo' WHERE idCita=1;