CREATE DATABASE university;

USE university;

CREATE TABLE students
(
	code integer AUTO_INCREMENT,
	firstname varchar(100) NOT NULL,
	lastname varchar(100) NOT NULL,
	birthdate date NOT NULL,
	CONSTRAINT pk_students PRIMARY KEY (code)
);