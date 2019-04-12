create database bookstore;

CREATE TABLE `bookstore`.`manager` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));
  
INSERT INTO `bookstore`.`manager` (`id`, `name`, `password`) VALUES ('1', 'admin', 'admin');
