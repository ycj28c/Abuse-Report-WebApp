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
-- Table structure for table `decision`
--

DROP TABLE IF EXISTS `decision`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `decision` (
  `PK_decision` int(11) NOT NULL AUTO_INCREMENT,
  `reportid` varchar(45) DEFAULT NULL,
  `investigationid` varchar(45) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `attacholdname` varchar(100) DEFAULT NULL,
  `attachnewname` varchar(100) DEFAULT NULL,
  `attachpath` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`PK_decision`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `decision`
--

LOCK TABLES `decision` WRITE;
/*!40000 ALTER TABLE `decision` DISABLE KEYS */;
INSERT INTO `decision` VALUES (4,'55','55','ffffff','forms_received.gif','ff30d863-53d6-42ea-ba19-4dbf934e31a5','upload\\\\decisionff30d863-53d6-42ea-ba19-4dbf934e31a5'),(5,'66','66','dfdfription','email_initiator.gif','5c00fefb-00ee-4b5d-be82-9a733c8b8a2c.gif','upload\\\\decision\\5c00fefb-00ee-4b5d-be82-9a733c8b8a2c.gif'),(6,'66','66','input description','email_initiator.gif','a1a5acf5-9ee3-4ac2-a9d9-11dfd5c8a6c3.gif','upload\\\\decision\\a1a5acf5-9ee3-4ac2-a9d9-11dfd5c8a6c3.gif'),(7,'77','77','input descrsdfsfiption','forms_distributed.gif','29e55558-abee-45ea-ab0c-b491879ef5f7.gif','upload\\\\decision\\29e55558-abee-45ea-ab0c-b491879ef5f7.gif'),(8,'11','22','input description','','0af94cbd-c05e-41f0-aec0-aab0f925070b.','upload\\\\decision\\0af94cbd-c05e-41f0-aec0-aab0f925070b.'),(9,'23','42','input description','','71bdc4b7-ca4c-4914-8907-1b6bbbe0f125.','upload\\\\decision\\71bdc4b7-ca4c-4914-8907-1b6bbbe0f125.'),(10,'11','32','input description','','9c42f8c1-8c9c-48ca-b625-08eb06fd9b66.','upload\\\\decision\\9c42f8c1-8c9c-48ca-b625-08eb06fd9b66.'),(11,'11','25','input description','','3cf66db8-2ea9-4183-86f8-3dbdc4de0d40.','upload\\\\decision\\3cf66db8-2ea9-4183-86f8-3dbdc4de0d40.'),(12,'22','24','input description','','',''),(13,'22','24','input description','','',''),(14,'355','123','','','',''),(15,'34','554','','','',''),(16,'111','433','','','',''),(17,'111','433','','','',''),(18,'2','321','ccccccccccccccc','ended_review_or_form.gif','b547f111-ec15-4595-b07d-5cc18aaafbce.gif','upload\\\\decision\\b547f111-ec15-4595-b07d-5cc18aaafbce.gif'),(19,'2','321','ccccccccccccccc','','',''),(20,'444','321','','','','');
/*!40000 ALTER TABLE `decision` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-04-01 23:51:01
