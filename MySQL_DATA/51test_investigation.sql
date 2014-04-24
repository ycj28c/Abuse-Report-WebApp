CREATE DATABASE  IF NOT EXISTS `51test` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `51test`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: 51test
-- ------------------------------------------------------
-- Server version	5.6.16

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
-- Table structure for table `investigation`
--

DROP TABLE IF EXISTS `investigation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `investigation` (
  `PK_investigation` int(11) NOT NULL AUTO_INCREMENT,
  `publiclognumber` varchar(45) NOT NULL,
  `reportid` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `dispositionid` varchar(45) DEFAULT NULL,
  `respondid` varchar(45) DEFAULT NULL,
  `decisionid` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`PK_investigation`),
  UNIQUE KEY `publiclognumber_UNIQUE` (`publiclognumber`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `investigation`
--

LOCK TABLES `investigation` WRITE;
/*!40000 ALTER TABLE `investigation` DISABLE KEYS */;
INSERT INTO `investigation` VALUES (1,'44','44','haha','3','3','3'),(2,'55','55','haha','4','4','4'),(3,'66','66','haha','5','5','5'),(5,'77','77','haha','7','7','7'),(6,'22','11','haha','8','8','8'),(7,'42','23','haha','9','9','9'),(8,'32','11','haha','10','10','10'),(9,'25','11','haha','11','11','11'),(10,'24','22','haha','12','12','12'),(12,'123','355','haha','14','14','14'),(13,'554','34','haha','15','15','15'),(14,'433','111','haha','16','16','16'),(16,'321','2','haha','18','18','18'),(19,'1232','2','haha','21','21','21'),(20,'432','2','haha','22','22','22'),(21,'3214','2','haha','23','23','23'),(22,'2123','2','haha','24','24','24'),(23,'5342','3','haha','25','25','25'),(24,'232','2','haha','26','26','26');
/*!40000 ALTER TABLE `investigation` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-04-24 17:30:37
