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
-- Table structure for table `disposition`
--

DROP TABLE IF EXISTS `disposition`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `disposition` (
  `PK_disposition` int(11) NOT NULL AUTO_INCREMENT,
  `reportid` varchar(45) DEFAULT NULL,
  `investigationid` varchar(45) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `attacholdname` varchar(100) DEFAULT NULL,
  `attachnewname` varchar(100) DEFAULT NULL,
  `attachpath` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`PK_disposition`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `disposition`
--

LOCK TABLES `disposition` WRITE;
/*!40000 ALTER TABLE `disposition` DISABLE KEYS */;
INSERT INTO `disposition` VALUES (1,'11','22','sdfsdfiption','disposition','1062f2a5-877b-4e9e-8eaa-86cce8a9d4b5','disposition'),(2,'33','33','aaaaaaa','disposition','2b4c2411-3af7-4e16-adcb-27889957b9f2','disposition'),(3,'44','44','ccccccccc','disposition','1b332a60-0080-4c9c-bc37-9ac586542d38','disposition'),(4,'55','55','sdfsdf','email_all.gif','9303f08e-9ee0-4a12-b157-3e920f0310a9','upload\\\\disposition9303f08e-9ee0-4a12-b157-3e920f0310a9'),(5,'66','66','ccxvxv','email_all.gif','8ab587d7-62cc-40d0-bd18-f3f73b00dd4b.gif','upload\\\\disposition\\8ab587d7-62cc-40d0-bd18-f3f73b00dd4b.gif'),(6,'66','66','input description','email_initiator.gif','76106cfc-d77a-4ce4-a54b-0897fb96d1d9.gif','upload\\\\disposition\\76106cfc-d77a-4ce4-a54b-0897fb96d1d9.gif'),(7,'77','77','input descrsdfsdfiption','email_all.gif','ea2d7794-728c-4fd5-b907-af50820242f4.gif','upload\\\\disposition\\ea2d7794-728c-4fd5-b907-af50820242f4.gif'),(8,'11','22','input description','','a430c07d-469d-47c2-b6bb-adaa2ad771cd.','upload\\\\disposition\\a430c07d-469d-47c2-b6bb-adaa2ad771cd.'),(9,'23','42','input description','','a30e554a-0ae1-400e-a7c7-ad98207cbcf6.','upload\\\\disposition\\a30e554a-0ae1-400e-a7c7-ad98207cbcf6.'),(10,'11','32','input description','','852e2567-cf57-412c-b4c5-706e3fac69a5.','upload\\\\disposition\\852e2567-cf57-412c-b4c5-706e3fac69a5.'),(11,'11','25','input description','','a52b0b07-518b-4df1-b991-3cc522505639.','upload\\\\disposition\\a52b0b07-518b-4df1-b991-3cc522505639.'),(12,'22','24','input description','','',''),(13,'22','24','input description','','',''),(14,'355','123','','','',''),(15,'34','554','','','',''),(16,'111','433','','','',''),(17,'111','433','','','',''),(18,'2','321','dfsdf','email_initiator.gif','5aa44218-04de-47ee-91b8-6659d7caf1aa.gif','upload\\\\disposition\\5aa44218-04de-47ee-91b8-6659d7caf1aa.gif'),(19,'2','321','dfsdf','','',''),(20,'444','321','','','','');
/*!40000 ALTER TABLE `disposition` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-04-01 23:51:05
