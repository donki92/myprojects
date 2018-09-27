CREATE DATABASE  IF NOT EXISTS `web_customer_tracker` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `web_customer_tracker`;
-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: web_customer_tracker
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (6,'Doan','Selmani','doan.selmani@gmail.com'),(7,'Dilan','Selmani','dilan@yahoo.com'),(8,'Estref','Selmani','estref.selmani@gmail.com'),(9,'Pepo',' Pepperoni','marko.caric@link.co.rs');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-09-27 15:19:22
CREATE DATABASE  IF NOT EXISTS `games` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `games`;
-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: games
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `account` (
  `AccountId` int(11) NOT NULL AUTO_INCREMENT,
  `EmployeeId` int(11) NOT NULL,
  `Username` varchar(45) NOT NULL,
  `Password` varchar(45) NOT NULL,
  PRIMARY KEY (`AccountId`),
  KEY `FK_cxlobm9y3i1061jocedcf2wy3` (`EmployeeId`),
  CONSTRAINT `FK_cxlobm9y3i1061jocedcf2wy3` FOREIGN KEY (`EmployeeId`) REFERENCES `employee` (`employeeid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,1,'doan.selmani@gmail.com','1234'),(3,2,'dilan.selmani@gmail.com','1111'),(7,5,'estref.selmani@gmail.com','2222');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `customer` (
  `CustomerID` int(11) NOT NULL AUTO_INCREMENT,
  `PhoneNum` varchar(45) DEFAULT NULL,
  `Name` varchar(45) NOT NULL,
  `Address` varchar(45) NOT NULL,
  PRIMARY KEY (`CustomerID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'065264888','Radenko Backovic','Vojvode Novaka 11'),(2,'063444555','Dino Selmani','Darinke Radovic 5'),(3,'0626663333','John','Jurija Gagarina 14'),(4,'0637126417','Estref Selmani','Zorina 4'),(5,'0653256992','Doan Selmani','Vodovodska drugi deo 18g'),(8,'0646667777','Stefan Gogic','Trgovacka 19');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `employee` (
  `EmployeeID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) NOT NULL,
  `Address` varchar(50) NOT NULL,
  `PositionName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`EmployeeID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'Doan Selmani','Vodovodska drugi deo 18g','Manager'),(2,'Dilan Selmani','Zorina 4','Sales'),(5,'Estref Selmani','Zorina 4','Sales');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `history`
--

DROP TABLE IF EXISTS `history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `history` (
  `ShipmentNum` int(11) NOT NULL AUTO_INCREMENT,
  `CustomerID` int(11) NOT NULL,
  `VideogameId` int(11) NOT NULL,
  `EmployeeId` int(11) NOT NULL,
  `Quantity` int(11) DEFAULT NULL,
  `shipmentDate` date DEFAULT NULL,
  PRIMARY KEY (`ShipmentNum`),
  KEY `FK_mslvhx3mlqv5yvgj0wy5131wm` (`VideogameId`),
  KEY `FK_9n4m1mygftqmktltajucrsvxd` (`EmployeeId`),
  KEY `FK_ea97q9accvvjf1l0s3hywp286` (`CustomerID`),
  CONSTRAINT `FK_9n4m1mygftqmktltajucrsvxd` FOREIGN KEY (`EmployeeId`) REFERENCES `employee` (`employeeid`),
  CONSTRAINT `FK_ea97q9accvvjf1l0s3hywp286` FOREIGN KEY (`CustomerID`) REFERENCES `customer` (`customerid`) ON UPDATE CASCADE,
  CONSTRAINT `FK_mslvhx3mlqv5yvgj0wy5131wm` FOREIGN KEY (`VideogameId`) REFERENCES `videogame` (`videogameid`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `history`
--

LOCK TABLES `history` WRITE;
/*!40000 ALTER TABLE `history` DISABLE KEYS */;
INSERT INTO `history` VALUES (4,3,5,2,2,'2018-08-28'),(5,2,7,2,2,'2018-08-28'),(7,2,5,1,2,'2018-08-28'),(8,1,6,2,1,'2018-08-28'),(10,1,2,1,1,'2018-08-28'),(13,2,6,2,2,'2018-08-29'),(14,2,5,1,2,'2018-08-31'),(15,3,2,1,1,'2018-08-31'),(17,2,19,1,2,'2018-08-31'),(18,2,19,1,1,'2018-09-01'),(21,3,12,2,2,'2018-09-03'),(25,1,23,1,1,'2018-09-07'),(26,4,7,1,2,'2018-09-08'),(29,3,14,2,1,'2018-09-09');
/*!40000 ALTER TABLE `history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `videogame`
--

DROP TABLE IF EXISTS `videogame`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `videogame` (
  `VideogameId` int(11) NOT NULL AUTO_INCREMENT,
  `GameTitle` varchar(50) NOT NULL,
  `Platform` varchar(20) NOT NULL,
  `Price` double NOT NULL,
  `Publisher` varchar(50) NOT NULL,
  `DistributorID` int(11) DEFAULT NULL,
  `ESRBRating` varchar(5) DEFAULT NULL,
  `Quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`VideogameId`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `videogame`
--

LOCK TABLES `videogame` WRITE;
/*!40000 ALTER TABLE `videogame` DISABLE KEYS */;
INSERT INTO `videogame` VALUES (1,'Devil May Cry 4','Xbox 360',40,'CAPCOM',3,'T',92),(2,'Fallout 4','PC',40,'Bethesda',3,'T',91),(5,'Elder Scrolls V: Skyrim','PC',20,'Bethesda',3,'T',89),(6,'God of War 3','PS3',40,'Sony Computer Entertainment',2,'M',89),(7,'The Last of Us','PS3',60,'Sony Computer Entertainment',2,'M',88),(11,'Street Fighter 4','PC',40,'CAPCOM',2,'T',86),(12,'Diablo 3','PC',40,'Blizzard Entertainment',3,'M',89),(13,'Mortal Kombat XI','PS3',40,'Netherrealm Studios',2,'M',91),(14,'Gran Turismo 6','PS3',60,'Sony Computer Entertainment',3,'T',88),(15,'Fortnite (skin pack)','PC',5,'Epic Games',3,'T',86),(16,'Super Smash Bros. WiiU','Wii U',60,'Nintendo',3,'E',99),(17,'The Legend of Zelda: Breath of the Wild','Wii U',60,'Nintendo',3,'T',100),(18,'Donkey Kong Country Returns','Wii U',40,'Nintendo',3,'E',100),(19,'Mario Kart 8','Wii U',60,'Nintendo',3,'E',97),(20,'League of Legends (500RP)','PC',15,'Riot Games',3,'T',1000),(21,'Playstation Plus (1 year)','PS3',60,'Sony Computer Entertainment',3,'T',1000),(23,'Playstation Plus (6 months)','PS3',40,'Sony Computer Entertainment',3,'T',996),(24,'Xenoblade X','Wii U',40,'Nintendo',3,'T',98),(25,'Super Smash Bros. 4','Wii U',60,'Nintendo',3,'E',200),(26,'God of War 4','PS3',40,'Sony Computer Entertainment',2,'M',89);
/*!40000 ALTER TABLE `videogame` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-09-27 15:19:22
