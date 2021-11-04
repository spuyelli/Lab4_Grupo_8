create schema Universidad;

use Universidad;

create table Paises(
id int NOT NULL AUTO_INCREMENT,
descripcion VARCHAR(50),

primary key(id)
);

create table Provincias(
id int NOT NULL AUTO_INCREMENT,
descripcion VARCHAR(50),
idPais int not null,

primary key (id),
foreign key (idPais) references Paises(id)
);

create table Localidades(
id int NOT NULL AUTO_INCREMENT,
descripcion VARCHAR(50),
idProvincia int not null,

primary key (id),
foreign key (idProvincia) references Provincias(id)
);

CREATE TABLE Docentes(
dni int NOT NULL,
legajo int not null unique,
nombre VARCHAR(50) NOT NULL, 
apellido VARCHAR(50)NOT NULL,
fechaNacimiento date NOT NULL,
idNacionalidad int NOT NULL,
domicilio VARCHAR(250) NOT NULL,
idLocalidad int NOT NULL,
email VARCHAR(250) NOT NULL,
telefono int NOT NULL,

primary key (dni),
foreign key (idNacionalidad) references Paises(id),
foreign key (idLocalidad) references Localidades(id)
)AUTO_INCREMENT=1000;

CREATE TABLE Alumnos(
dni int NOT NULL,
legajo int not null unique,
nombre VARCHAR(50) NOT NULL, 
apellido VARCHAR(50)NOT NULL,
fechaNacimiento date NOT NULL,
idNacionalidad int NOT NULL,
domicilio VARCHAR(250) NOT NULL,
idLocalidad int NOT NULL,
email VARCHAR(250) NOT NULL,
telefono int NOT NULL,

primary key (dni),
foreign key (idNacionalidad) references Paises(id),
foreign key (idLocalidad) references Localidades(id)
)AUTO_INCREMENT=2000;

create table admins(
dni int NOT NULL,
nombre VARCHAR(50) NOT NULL, 
apellido VARCHAR(50)NOT NULL,
fechaNacimiento date NOT NULL,
idNacionalidad int NOT NULL,
domicilio VARCHAR(250) NOT NULL,
idLocalidad int NOT NULL,
email VARCHAR(250) NOT NULL,
telefono int NOT NULL,

primary key (dni),
foreign key (idNacionalidad) references Paises(id),
foreign key (idLocalidad) references Localidades(id)
)AUTO_INCREMENT=3000;

create table TiposUsuario(
idTipo INT NOT NULL AUTO_INCREMENT,
descripcion VARCHAR(50),

primary key(idTipo)
);

create table Usuarios(
dni int NOT NULL,
tipoUsuario int NOT NULL,
pass VARCHAR(50) not null,
estado bit NOT NULL,

primary key(dni),
foreign key(dni) references Docentes(dni),
foreign key(dni) references admins(dni),
foreign key(tipoUsuario) references TiposUsuario(idTipo)
);

create table Materias(
id INT NOT NULL AUTO_INCREMENT,
descripcion VARCHAR(50),

primary key (id)
);

create table Cursos(
id INT NOT NULL AUTO_INCREMENT,
idMateria INT NOT NULL,
dniDocente INT NOT NULL,
semestre INT NOT NULL,
anio INT NOT NULL,

primary key(id),
foreign key(idMateria) references Materias(id),
foreign key(dniDocente) references Docentes(dni)
)AUTO_INCREMENT=100;

create table AlumnosXCursos(
dniAlumno INT NOT NULL,
idCurso INT NOT NULL,
parcial_1 decimal,
parcial_2 decimal,
recuperatorio_1 decimal,
recuperatorio_2 decimal,
estadoAprobacion bit,

PRIMARY KEY (dniAlumno, idCurso),
foreign key (dniAlumno) references Alumnos(dni),
foreign key (idCurso) references Cursos(id)
);

create table Carrera(
id INT NOT NULL AUTO_INCREMENT,
descripcion VARCHAR(50),

primary key (id)
);

create table MateriasXCarrera(
idCarrera INT NOT NULL,
idMateria int not null,

primary key (idCarrera, idMateria),
foreign key (idCarrera) references Carrera(id),
foreign key (idMateria) references Materias(id)
);