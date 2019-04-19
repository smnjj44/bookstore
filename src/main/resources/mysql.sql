create database bookstore;

CREATE TABLE `bookstore`.`manager` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));
  
INSERT INTO `bookstore`.`manager` (`id`, `name`, `password`) VALUES ('1', 'admin', 'admin');


CREATE TABLE `bookstore`.`customer` (
  `cid` INT NOT NULL AUTO_INCREMENT,
  `realname` VARCHAR(45) NULL,
  `nickname` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `mailbox` VARCHAR(45) NULL,
  `address` VARCHAR(45) NULL,
  PRIMARY KEY (`cid`));
  
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

CREATE TABLE `bookstore`.`message` (
  `messageId` INT NOT NULL AUTO_INCREMENT,
  `cid` INT NULL,
  `date` VARCHAR(45) NULL,
  `content` VARCHAR(45) NULL DEFAULT 'null',
  PRIMARY KEY (`messageId`));

CREATE TABLE `bookstore`.`notice` (
  `nid` INT NOT NULL AUTO_INCREMENT,
  `managerName` VARCHAR(45) NULL,
  `content` VARCHAR(45) NULL,
  `createDate` VARCHAR(45) NULL,
  PRIMARY KEY (`nid`));
  
 CREATE TABLE `bookstore`.`order` (
  `oid` int(11) NOT NULL AUTO_INCREMENT,
  `sumPrice` float DEFAULT NULL,
  `content` varchar(45) DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  PRIMARY KEY (`oid`)
) 
