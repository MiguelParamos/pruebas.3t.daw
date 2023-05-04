drop database if exists bicicletasDAW;
create database bicicletasDAW;

use bicicletasDAW;

create table cliente(
	email varchar(150) primary key,
    password varchar(30) not null,
    telefono int(13),
    nombre varchar(80) not null
);

insert into cliente values('prueba@prueba.es','123123',54647856,'pruebaman');


create table bicicleta(
	marca varchar(50),
    modelo varchar(50),
    problema varchar(500),
    cliente varchar(150),
    primary key(marca,modelo,cliente),
    foreign key (cliente) references cliente(email)
);

create table articulo(
	nombre varchar(70) primary key,
    precio float
);


create table venta(
	cliente varchar(150),
    articulo varchar(70),
    cantidad numeric(3),
    fecha timestamp,
    primary key(fecha,cantidad,articulo,cliente),
    foreign key (cliente) references cliente(email),
    foreign key (articulo) references articulo(nombre)
);

