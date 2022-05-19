CREATE DATABASE JDBC_ALEX_EJERCICIO1;
USE JDBC_ALEX_EJERCICIO1;

CREATE TABLE estudiante (
	id VARCHAR(5),
    nombre VARCHAR (50),
    ciudad VARCHAR (50),
    telefono VARCHAR(9),
    fechanacimiento DATE,
    codgrado INT,
    PRIMARY KEY (id));
    
CREATE TABLE grado (
	codgrado INT,
    nombre VARCHAR (50),
    horas INT,
    PRIMARY KEY (codgrado));
    
ALTER TABLE estudiante ADD FOREIGN KEY (codgrado) REFERENCES grado(codgrado);

INSERT INTO estudiante VALUES (1,"Alex","Errenteria","688725282","2022-03-29","1");