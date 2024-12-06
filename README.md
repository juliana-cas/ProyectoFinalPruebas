Instrucciones para ejecutar el proyecto:


Ejecutar las siguientes líneas en SQL shell (psql):

para acceder: 
Server [localhost]: localhost
Database [postgres]: postgres 
Port [5432]: 5432 
Username [postgres]: postgres 
Contraseña para usuario postgres: postgres

para crear la base de datos: CREATE DATABASE tasks;
para acceder a la base de datos creada: \c tasks

para crear la tabla de tasks:CREATE TABLE task (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    completed BOOLEAN DEFAULT FALSE
);

para ver las tablas generadas: \dt

para ingresar datos: INSERT INTO tasks (title, description, completed) 
VALUES ('Mi nueva tarea', 'Descripción breve', false);

para ver los datos ingresados: SELECT * FROM tasks;


Para las pruebas de integracion:

ejecutar TaskIntegrationTest

Para las prueba unitarias: 
ejecutar TaskControllerTest 

Para la prueba de bd:
ejecutar DatabaseConnectionTest 

Para las pruebas de API:
ejecutar TaskControllerAPITest
