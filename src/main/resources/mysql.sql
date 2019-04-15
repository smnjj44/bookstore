create database bookstore;

CREATE TABLE `bookstore`.`manager` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));
  
INSERT INTO `bookstore`.`manager` (`id`, `name`, `password`) VALUES ('1', 'admin', 'admin');


CREATE TABLE `bookstore`.`customer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `realname` VARCHAR(45) NULL,
  `nickname` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `mailbox` VARCHAR(45) NULL,
  `address` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));
  
  CREATE TABLE `bookstore`.`book` (
  `bid` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `author` VARCHAR(45) NULL,
  `press` VARCHAR(45) NULL,
  `price` FLOAT NULL,
  `discount` FLOAT NULL,
  `rdate` VARCHAR(45) NULL,
  `type` VARCHAR(45) NULL,
  PRIMARY KEY (`bid`));
