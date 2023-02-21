create database banco_1pm;
use banco_1pm;

create table direccion(
	id_direccion int primary key auto_increment,
    calle varchar(30),
    numero varchar(20),
    colonia varchar(30)
);

create table cliente(
	id_cliente int primary key auto_increment,
    nombres varchar(50) not null,
    apellido_paterno varchar(50) not null,
    apellido_materno varchar(50) ,
    fecha_nacimiento date not null,
    #edad int ,
    id_direccion int,
    foreign key(id_direccion) references direccion(id_direccion)	
);

create table cuenta(
	numero_cuenta int primary key auto_increment,
    fecha_apertura date not null, 
    saldo decimal(16,4) unsigned ,
    estado enum('Vigente','Cancelada'),
    id_cliente int not null,
    foreign key(id_cliente) references cliente(id_cliente)
);

create table transferencia(
	id int primary key auto_increment,
    fecha_hora datetime not null,
    id_CuentaClienteOrigen int not null,
    id_CuentaClienteDestino int not null,
    monto decimal(16,4) unsigned,
	foreign key(id_CuentaClienteOrigen) references cuenta(numero_cuenta),
    foreign key(id_CuentaClienteDestino) references cuenta(numero_cuenta)
);



create table retiro(
	folio int primary key auto_increment,
    contraseña varchar(400) not null,
	estado enum('Cobrado','No cobrado'),
    fecha_hora datetime not null,
    numero_cuenta int not null,
    monto decimal (16,4) ,
    foreign key(numero_cuenta) references cuenta(numero_cuenta)   
);