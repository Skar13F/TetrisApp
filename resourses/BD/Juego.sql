drop database if exists Juego;
create database Juego;
use Juego;
-- describe jugador;
-- show tables;
-- creación de tablas
create table rol(id_rol int auto_increment primary key, rol varchar(20));
create table usuario(id_usuario int auto_increment primary key, nombre varchar(20), pwd varchar(20));
create table usuario_rol(id_usuario int, id_rol int, FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario) on update cascade on delete cascade, 
	FOREIGN KEY (id_rol) REFERENCES rol(id_rol) on update cascade on delete cascade, primary key (id_usuario,id_rol));
create table jugador(id_jugador int primary key auto_increment, nombre varchar(25), edad int, sexo character, 
	telefono varchar(10), correo varchar(50), direccion varchar(50), puntos int);

-- actualizacion de tablas
alter table usuario add (fecha_creacion datetime, fecha_actualizacion datetime, fecha_eliminacion datetime, id_jugador int, 
	FOREIGN KEY (id_jugador) REFERENCES jugador(id_jugador) on update cascade on delete cascade);
alter table jugador add (fecha_creacion datetime, fecha_actualizacion datetime, fecha_eliminacion datetime);
alter table rol add (fecha_creacion datetime, fecha_actualizacion datetime, fecha_eliminacion datetime);


-- insertar datos en tabla
insert into rol(rol) values('Invitado');
insert into rol(rol) values('Admin');
insert into rol(rol) values('Superadmin');

insert into jugador(nombre, edad, sexo, telefono, correo, direccion, puntos)
	values('juan', 8,'h', 9515648722,'lk@gmail','calle 2',9);    
insert into jugador(nombre, edad, sexo, telefono, correo, direccion, puntos)
	values('pedro', 18,'h', 9515678146,'hjvhj@gmail','calle 2',29);

insert into usuario(nombre,pwd,id_jugador) values('invitado','12354',1);
insert into usuario(nombre,pwd,id_jugador) values('user0','12354',2);
insert into usuario(nombre,pwd,id_jugador) values('user2','1545',2);
insert into usuario(nombre,pwd,id_jugador) values('user3','354564',1);

insert into usuario_rol values(1,1);
insert into usuario_rol values(1,2);
insert into usuario_rol values(2,2);
insert into usuario_rol values(2,3);

-- procedimientos
-- DROP PROCEDURE IF exists insertarRegistro;

DELIMITER //
create procedure insertarRegistro
(
-- in idRol int,
in rol varchar(50)
)
begin insert INTO rol(rol) values(rol);
end //
DELIMITER ;

DELIMITER //
create procedure obtenerRegistro
(
)
begin select * from rol;
end //
DELIMITER ;

-- DROP PROCEDURE IF exists eliminarRegistro;
DELIMITER $
CREATE PROCEDURE eliminarRegistro
(
IN idRolAux INT
)
begin
delete FROM rol where id_rol=idRolAux;
END$
DROP PROCEDURE IF exists buscarRegistro;
DELIMITER $
CREATE PROCEDURE buscarRegistro
(
IN rolAux varchar(20)
)
begin
select * FROM rol where rol=rolAux;
END$

DELIMITER $
CREATE PROCEDURE actualizarRegistro
(
in rolAux varchar(50),
IN idRolAux INT
)
begin
update rol set rol=rolAux where id_rol=idRolAux;
END$









DELIMITER //
create procedure insertarUsuario
(
-- in idRol int,
in nombre varchar(20),
in pwd varchar(20),
in id_jugador int
)
begin insert INTO usuario(nombre,pwd,id_jugador) values(nombre,pwd,id_jugador);
end //
DELIMITER ;

DELIMITER //
create procedure obtenerUsuario
(
)
begin select * from usuario;
end //
DELIMITER ;

-- DROP PROCEDURE IF exists eliminarUsuario;
DELIMITER $
CREATE PROCEDURE eliminarUsuario
(
IN id_usuarioAux INT
)
begin
delete FROM usuario where id_usuario=id_usuarioAux;
END$

DELIMITER $
CREATE PROCEDURE buscarUsuario
(
IN id_usuarioAux INT
)
begin
select * FROM usuario where id_usuario=id_usuarioAux;
END$

-- drop procedure if exists actualizarUsuario;
DELIMITER $
CREATE PROCEDURE actualizarUsuario
(
in nombreAux varchar(20),
in pwdAux varchar(20),
in id_jugadorAux int,
in id_usuarioAux int
)
begin
update usuario set nombre=nombreAux, pwd=pwdAux, id_jugador=id_jugadorAux where id_usuario=id_usuarioAux;
END$

-- buscar usuario por nombre, contraseña y rol
drop procedure if exists buscarUsuarioNCP;
DELIMITER $
CREATE PROCEDURE buscarUsuarioNCP
(
in nombreAux varchar(20),
in pwdAux varchar(20),
in id_rolAux int
)
begin
-- select * FROM usuario where nombre=nombreAux and pwd=pwdAux;
with
x as (select nombre, pwd, usuario_rol.id_rol from usuario inner join usuario_rol inner join rol
	where usuario.id_usuario=usuario_rol.id_usuario and usuario_rol.id_rol=rol.id_rol)
    select nombre, pwd, id_rol from x where nombre=nombreAux and pwd=pwdAux and id_rol=id_rolAux;
END$
use Juego;

show databases;

-- buscar usuario por nombre y cintraseñalter

DELIMITER $
CREATE PROCEDURE buscarUsuarioNombre
(
in nombreAux varchar(20)
)
begin
select * FROM usuario where nombre=nombreAux;
END$
DROP PROCEDURE IF exists insertar_Usuario_rol;
DELIMITER $
CREATE PROCEDURE insertar_Usuario_rol
(
in id_usuarioAux int,
in id_rolAux int
)
begin
	insert INTO usuario_rol(id_usuario,id_rol) values(id_usuarioAux, id_rolAux);
END$


select * from usuario;

-- show databases;