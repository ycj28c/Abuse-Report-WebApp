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
-- Table structure for table `respond`
--

DROP TABLE IF EXISTS `respond`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `respond` (
  `PK_respond` int(11) NOT NULL AUTO_INCREMENT,
  `reportid` varchar(45) DEFAULT NULL,
  `investigationid` varchar(45) DEFAULT NULL,
  `content` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`PK_respond`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `respond`
--

LOCK TABLES `respond` WRITE;
/*!40000 ALTER TABLE `respond` DISABLE KEYS */;
INSERT INTO `respond` VALUES (1,'11','22','inputsdfsdfsdf description'),(2,'3','321','dfvdfdf'),(3,'44','44','dddddddddd'),(4,'55','55','ffffff'),(5,'66','66','sdfson'),(6,'66','66','input description'),(7,'77','77','input descsdfsdription'),(8,'11','22','input description'),(9,'23','42','input description'),(10,'11','32','input description'),(11,'11','25','input description'),(12,'22','24','input description'),(13,'22','24','input description'),(14,'355','123','sdf'),(15,'34','554','sdf'),(16,'111','433','sdf'),(17,'111','433','sdf'),(18,'2','321','ccccsdfsdfdddddsdfsdf'),(19,'2','321','dfvdfdf'),(20,'444','321','444'),(21,'2','1232',''),(22,'2','432','gdsdfaaaaaaa'),(23,'2','3214',''),(24,'2','2123',''),(25,'3','5342',''),(26,'2','232','ggggg');
/*!40000 ALTER TABLE `respond` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-04-24 16:03:24
