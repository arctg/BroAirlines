-- MySQL dump 10.13  Distrib 5.5.43, for debian-linux-gnu (i686)
--
-- Host: localhost    Database: broairlines
-- ------------------------------------------------------
-- Server version       5.5.43-0+deb8u1-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `airplanes`
--

DROP TABLE IF EXISTS `airplanes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `airplanes` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `numofseats` int(3) DEFAULT '0',
  `vendorname` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `airplanes`
--

LOCK TABLES `airplanes` WRITE;
/*!40000 ALTER TABLE `airplanes` DISABLE KEYS */;
INSERT INTO `airplanes` VALUES (1,99,'An-158'),(2,80,'An-148'),(3,420,'Airbus A340-200'),(4,467,'Boeing 747-8'),(5,174,'Boeing 707'),(6,10,'Broiler-747');
/*!40000 ALTER TABLE `airplanes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cities`
--

DROP TABLE IF EXISTS `cities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cities` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `cname` varchar(255) NOT NULL,
  `regions_Id` int(11) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `fk_cities_regions1_idx` (`regions_Id`),
  CONSTRAINT `fk_cities_regions1` FOREIGN KEY (`regions_Id`) REFERENCES `regions` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cities`
--

LOCK TABLES `cities` WRITE;
/*!40000 ALTER TABLE `cities` DISABLE KEYS */;
INSERT INTO `cities` VALUES (1,'Белая Церковь',1),(2,'Бердянск',2),(3,'Броды',3),(4,'Винница',4),(5,'Геническ',5),(6,'Гостомель',1),(7,'Днепропетровск',6),(8,'Донецк',7),(9,'Драбов',8),(10,'Житомир',9),(11,'Запорожье',2),(12,'Ивано-Франковск',10),(13,'Измаил',11),(14,'Каменец-Подольский',12),(15,'Киев',1),(16,'Кировоград',13),(17,'Коломыя',10),(18,'Конотоп',14),(19,'Краматорск',7),(20,'Кременчуг',15),(21,'Кривой Рог',6),(22,'Лиманское',11),(23,'Луганск',16),(24,'Луцк',17),(25,'Львов',3),(26,'Мариуполь',7),(27,'Мелитополь',2),(28,'Миргород',15),(29,'Нежин',18),(30,'Николаев',19),(31,'Одесса',11),(32,'Петровское',16),(33,'Подгородное',6),(34,'Полтава',15),(35,'Ровно',20),(36,'Северодонецк',16),(37,'Семеновка',18),(38,'Староконстантинов',12),(39,'Стрый',3),(40,'Сумы',14),(41,'Тернополь',21),(42,'Ужгород',22),(43,'Узин',1),(44,'Харьков',23),(45,'Херсон',5),(46,'Хмельницкий',12),(47,'Цунев',3),(48,'Черкассы',8),(49,'Чернигов',18),(50,'Черновцы',24),(51,'Чугуев',23);
/*!40000 ALTER TABLE `cities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clients`
--

DROP TABLE IF EXISTS `clients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clients` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `fname` varchar(32) NOT NULL,
  `lname` varchar(32) NOT NULL,
  `passwd` varchar(32) NOT NULL,
  `phone` varchar(12) NOT NULL,
  `email` varchar(32) NOT NULL,
  `admin` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`Id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clients`
--

LOCK TABLES `clients` WRITE;
/*!40000 ALTER TABLE `clients` DISABLE KEYS */;
INSERT INTO `clients` VALUES (1,'Dennis','Kryachko','2654d1a3f16bf62ddc4f91fa3ec9377','0937631973','duran@irpin.com',1),(2,'Tommy L.','Jones','202cb962ac5975b964b7152d234b70','0936026000','tom@gmail.com',0),(3,'Борис','Моисеев','202cb962ac5975b964b7152d234b70','0666666666','boris@cool.boy',0),(4,'Vitaly','Nizhegorodov','202cb962ac5975b964b7152d234b70','0937645513','vitaly@gmail.com',0),(5,'Bruce','Willis','202cb962ac5975b964b7152d234b70','09344445588','bruce@gmail.com',0);
/*!40000 ALTER TABLE `clients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flights`
--

DROP TABLE IF EXISTS `flights`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `flights` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `cretime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `flightdate` timestamp NULL DEFAULT NULL,
  `price` int(11) DEFAULT '0',
  `airplanes_Id` int(11) NOT NULL,
  `fly_from` int(11) NOT NULL,
  `fly_to` int(11) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `fk_flights_airplanes1_idx` (`airplanes_Id`),
  KEY `fk_flights_cities1_idx` (`fly_to`),
  KEY `fk_flights_cities2_idx` (`fly_from`),
  CONSTRAINT `fk_flights_airplanes1` FOREIGN KEY (`airplanes_Id`) REFERENCES `airplanes` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_flights_cities1` FOREIGN KEY (`fly_to`) REFERENCES `cities` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_flights_cities2` FOREIGN KEY (`fly_from`) REFERENCES `cities` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flights`
--

LOCK TABLES `flights` WRITE;
/*!40000 ALTER TABLE `flights` DISABLE KEYS */;
INSERT INTO `flights` VALUES (1,'2015-05-29 12:07:25','2015-06-23 21:00:00',4000000,6,5,15),(2,'2015-05-29 12:11:51','2015-06-25 21:00:00',8000000,5,30,51),(3,'2015-05-29 23:23:25','2015-07-14 21:00:00',6000000,4,3,25),(4,'2015-06-01 21:04:59','2015-08-26 21:00:00',3000000,6,14,25),(5,'2015-06-02 10:01:23','2015-06-16 21:00:00',1000000,4,6,1),(6,'2015-06-02 10:11:01','2015-06-17 21:00:00',2340000,1,7,1),(7,'2015-06-02 10:16:52','2015-06-17 20:14:00',2340000,1,9,1),(8,'2015-06-02 14:04:58','2015-06-21 21:00:00',3870000,3,5,15),(9,'2015-06-03 09:31:43','2015-06-23 19:13:00',4600000,5,5,15),(10,'2015-06-03 09:33:23','2015-06-24 09:31:00',1200000,6,5,15),(11,'2015-06-03 21:33:39','2015-06-24 09:12:00',6660000,3,3,13),(12,'2015-06-03 21:47:06','2015-06-23 21:00:00',6660000,4,15,8),(13,'2015-06-05 10:15:52','2015-06-16 21:00:00',500000,1,15,31),(14,'2015-06-05 10:17:25','2015-06-16 21:00:00',500000,1,15,31),(15,'2015-06-05 10:19:27','2015-06-15 21:00:00',50000,1,15,31),(16,'2015-06-05 10:21:41','2015-06-16 21:00:00',300000,5,15,31),(17,'2015-06-05 10:40:34','2015-06-05 19:30:00',1300000,4,15,31),(18,'2015-06-06 10:07:53','2015-07-22 10:30:00',2000000,6,25,15),(19,'2015-06-06 18:08:00','2015-06-24 11:55:00',300000,6,15,34),(20,'2015-06-06 18:09:27','2015-06-25 12:43:00',335000,6,15,34),(21,'2015-06-06 18:12:37','2015-06-23 15:13:00',851300,6,15,34),(22,'2015-06-07 18:47:00','2015-09-23 19:12:00',1200000,6,1,2),(23,'2015-06-10 13:32:29','2015-06-18 21:00:00',4000000,6,15,31),(24,'2015-06-11 18:08:35','2015-06-22 21:00:00',8000000,6,10,11),(25,'2015-06-11 18:20:08','2015-06-30 21:00:00',9000000,6,4,11),(26,'2015-06-12 15:32:25','2015-06-24 10:14:00',8000000,6,15,43);
/*!40000 ALTER TABLE `flights` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `flights_Id` int(11) NOT NULL,
  `clients_Id` int(11) NOT NULL,
  `laggage` tinyint(1) DEFAULT '0',
  `datetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `priboard` tinyint(1) NOT NULL DEFAULT '0',
  `orderprice` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `fk_orders_flights1_idx` (`flights_Id`),
  KEY `fk_orders_clients1_idx` (`clients_Id`),
  CONSTRAINT `fk_orders_clients1` FOREIGN KEY (`clients_Id`) REFERENCES `clients` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_orders_flights1` FOREIGN KEY (`flights_Id`) REFERENCES `flights` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (13,5,3,0,'2015-06-04 23:15:59',1,12367),(15,9,3,0,'2015-06-04 23:27:26',0,46707),(21,5,2,1,'2015-06-05 09:17:27',1,13883),(23,1,1,1,'2015-06-06 09:02:06',1,55300),(25,5,3,1,'2015-06-06 17:46:49',1,14246),(26,21,1,1,'2015-06-06 18:13:23',1,12013),(27,22,1,1,'2015-06-07 18:47:28',1,18416),(28,13,4,1,'2015-06-08 16:59:15',1,8840),(29,15,1,0,'2015-06-09 18:22:30',0,551),(31,24,1,0,'2015-06-11 18:25:39',0,80000),(32,26,5,1,'2015-06-12 15:34:39',1,83500);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `regions`
--

DROP TABLE IF EXISTS `regions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `regions` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `rname` varchar(255) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `rname_UNIQUE` (`rname`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `regions`
--

LOCK TABLES `regions` WRITE;
/*!40000 ALTER TABLE `regions` DISABLE KEYS */;
INSERT INTO `regions` VALUES (4,'Винницкая'),(17,'Волынская'),(6,'Днепропетровская'),(7,'Донецкая'),(9,'Житомирская'),(22,'Закарпатская'),(2,'Запорожская'),(10,'Ивано-Франковская'),(1,'Киевская'),(13,'Кировоградская'),(16,'Луганская'),(3,'Львовская'),(19,'Николаевская'),(11,'Одесская'),(15,'Полтавская'),(20,'Ровенская'),(14,'Сумская'),(21,'Тернопольская'),(23,'Харьковская'),(5,'Херсонская'),(12,'Хмельницкая'),(8,'Черкасская'),(18,'Черниговская'),(24,'Черновицкая');
/*!40000 ALTER TABLE `regions` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-06-12 19:50:26
