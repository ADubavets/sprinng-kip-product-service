DROP TABLE if exists users_roles;
DROP TABLE if exists role;
DROP TABLE if exists users;
DROP TABLE if exists phones;
DROP TABLE if exists employee;
DROP TABLE if exists calendar;
DROP TABLE if exists status;
DROP TABLE if exists contracts;
DROP TABLE if exists customers;
DROP TABLE if exists warehouse;

CREATE TABLE role(id INT PRIMARY KEY AUTO_INCREMENT,
                  name TEXT NOT NULL);

CREATE TABLE users(id INT PRIMARY KEY AUTO_INCREMENT,
                   username TEXT NOT NULL,
                   password TEXT NOT NULL,
                   email TEXT NOT NULL,
                   first_name TEXT NOT NULL,
                   last_name TEXT NOT NULL,
                   enabled boolean default false);

CREATE TABLE users_roles(user_id integer NOT NULL,
                         role_id integer NOT NULL);

CREATE TABLE phones(id INT PRIMARY KEY AUTO_INCREMENT,
                    phone TEXT NOT NULL);

CREATE TABLE customers(id INT PRIMARY KEY AUTO_INCREMENT,
                       firm TEXT NOT NULL,
                       address TEXT NOT NULL,
                       email TEXT,
                       telephone TEXT,
                       leaderManager TEXT);

CREATE TABLE contracts(id INT PRIMARY KEY AUTO_INCREMENT,
                       number TEXT NOT NULL,
                       contract_date DATE NOT NULL,
                       cipher TEXT NOT NULL,
                       customer_id integer NOT NULL,
                       term INTEGER NOT NULL,
                       calendar_id integer NOT NULL,
                       status_id INTEGER NOT NULL,
                       startDate DATE,
                       finishDate DATE,
                       note TEXT);

CREATE TABLE calendar(id INT PRIMARY KEY AUTO_INCREMENT,
                      name TEXT NOT NULL);

CREATE TABLE status(id INT PRIMARY KEY AUTO_INCREMENT,
                      name TEXT NOT NULL);

CREATE TABLE employee(id INT PRIMARY KEY AUTO_INCREMENT,
                   name TEXT NOT NULL,
                   job TEXT NOT NULL,
                   telephone TEXT NOT NULL,
                   email TEXT,
                   firm_id INTEGER NOT NULL);
