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
-- Table structure for table `report_init`
--

DROP TABLE IF EXISTS `report_init`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `report_init` (
  `reportid` int(11) NOT NULL,
  `userid` varchar(45) NOT NULL,
  `username` varchar(45) DEFAULT NULL,
  `time` date DEFAULT NULL,
  `abuserid` int(11) DEFAULT NULL,
  `abusername` varchar(45) DEFAULT NULL,
  `victimid` int(11) DEFAULT NULL,
  `victimname` varchar(45) DEFAULT NULL,
  `frequency` varchar(45) DEFAULT NULL,
  `abusetype` varchar(200) DEFAULT NULL,
  `awareof` varchar(45) DEFAULT NULL,
  `investigatorrisk` varchar(45) DEFAULT NULL,
  `dppchotline` varchar(45) DEFAULT NULL,
  `narrativeform` varchar(300) DEFAULT NULL,
  `risklevel` varchar(300) DEFAULT NULL,
  `resultinginjure` varchar(300) DEFAULT NULL,
  `witness` varchar(300) DEFAULT NULL,
  `caregiverrelationship` varchar(300) DEFAULT NULL,
  `groupid` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`reportid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `report_init`
--

LOCK TABLES `report_init` WRITE;
/*!40000 ALTER TABLE `report_init` DISABLE KEYS */;
INSERT INTO `report_init` VALUES (2,'11111','wenxin','2014-03-10',14555,'Maha',2,'sdf','Daily,Decreasing','Physical,Omission,Emotional,sds','no','fffffdf','sdfsdf','sdff','fsdfs','sdfsd','fsdf','fffffff','1','initiated'),(4,'11111','wenxin','2014-03-11',22222,'ahah',3,'sdfsd','Weekly,Increasing','Omission,Sexual,dssds','yes','no','sds','cccccccc','ddddddddddddd','eeeeeeeeeeeeeee','euuuuuuuuuuuuu','iiiiiiiiiiiiiicccc','2','initiated'),(5,'11111','Maha','2014-04-08',22222,'ggg',2,'sdf','Weekly,Decreasing','Omission,Sexual','yes','no','no','sdf','gggg','cvcxvxc','vxcvxcv','xcvxcvxcv','2','initiated'),(6,'11111','Maha','2014-04-08',22222,'dgert',2,'erter','Weekly,Increasing','Omission','yes','no','no','erwer','werdg','dgdf','werwer','wertttt','1','initiated'),(7,'11111','Maha','2014-04-08',22222,'dfs',2,'dfsdf','Weekly,Decreasing','Sexual','yes','no','no','ggggg','gggg','gg','gg','ggg','1','initiated'),(8,'11111','Maha','2014-04-07',22222,'sdfsfs',2,'sdfsfsdf','Daily,Decreasing','Sexual,Emotional','yes','no','no','ggdsgsdf','vvvv','vvvvvvvvvvvvvvvv','vvvvvvvvvvvvvvvvvvvvvvv','vvvvvvvvvvvvvvvvvvvvvvvvvvvv','1','initiated'),(9,'11111','Maha','2014-04-07',22222,'sdfsfs',2,'sdfsfsdf','Daily,Decreasing','Sexual,Emotional','yes','no','no','ggdsgsdf','vvvv','vvvvvvvvvvvvvvvv','vvvvvvvvvvvvvvvvvvvvvvv','vvvvvvvvvvvvvvvvvvvvvvvvvvvv','1','initiated'),(10,'11111','Maha','2014-04-07',22222,'sdfsfs',2,'sdfsfsdf','Daily,Decreasing','Sexual,Emotional','yes','no','no','ggdsgsdf','vvvv','vvvvvvvvvvvvvvvv','vvvvvvvvvvvvvvvvvvvvvvv','vvvvvvvvvvvvvvvvvvvvvvvvvvvv','1','initiated'),(11,'11111','Maha','2014-04-07',22222,'sdfsfs',2,'sdfsfsdf','Daily,Decreasing','Sexual,Emotional','yes','no','no','ggdsgsdf','vvvv','vvvvvvvvvvvvvvvv','vvvvvvvvvvvvvvvvvvvvvvv','vvvvvvvvvvvvvvvvvvvvvvvvvvvv','1','initiated'),(12,'11111','Maha','2014-04-07',22222,'sdfsfs',2,'sdfsfsdf','Daily,Decreasing','Sexual,Emotional','yes','no','no','ggdsgsdf','vvvv','vvvvvvvvvvvvvvvv','vvvvvvvvvvvvvvvvvvvvvvv','vvvvvvvvvvvvvvvvvvvvvvvvvvvv','1','initiated'),(13,'11111','Maha','2014-04-07',22222,'sdfsfs',2,'sdfsfsdf','Daily,Decreasing','Sexual,Emotional','yes','no','no','ggdsgsdf','vvvv','vvvvvvvvvvvvvvvv','vvvvvvvvvvvvvvvvvvvvvvv','vvvvvvvvvvvvvvvvvvvvvvvvvvvv','1','initiated'),(14,'11111','Maha','2014-04-07',22222,'sdfsfs',2,'sdfsfsdf','Daily,Decreasing','Sexual,Emotional','yes','no','no','ggdsgsdf','vvvv','vvvvvvvvvvvvvvvv','vvvvvvvvvvvvvvvvvvvvvvv','vvvvvvvvvvvvvvvvvvvvvvvvvvvv','1','initiated'),(15,'11111','Maha','2014-04-07',22222,'sdfsfs',2,'sdfsfsdf','Daily,Decreasing','Sexual,Emotional','yes','no','no','ggdsgsdf','vvvv','vvvvvvvvvvvvvvvv','vvvvvvvvvvvvvvvvvvvvvvv','vvvvvvvvvvvvvvvvvvvvvvvvvvvv','1','initiated'),(16,'11111','Maha','2014-04-07',22222,'sdfsfs',2,'sdfsfsdf','Daily,Decreasing','Sexual,Emotional','yes','no','no','ggdsgsdf','vvvv','vvvvvvvvvvvvvvvv','vvvvvvvvvvvvvvvvvvvvvvv','vvvvvvvvvvvvvvvvvvvvvvvvvvvv','1','initiated'),(17,'11111','Maha','2014-04-07',22222,'sdfsfs',2,'sdfsfsdf','Daily,Decreasing','Sexual,Emotional','yes','no','no','ggdsgsdf','vvvv','vvvvvvvvvvvvvvvv','vvvvvvvvvvvvvvvvvvvvvvv','vvvvvvvvvvvvvvvvvvvvvvvvvvvv','1','initiated'),(18,'11111','Maha','2014-04-07',22222,'sdfsfs',2,'sdfsfsdf','Daily,Decreasing','Sexual,Emotional','yes','no','no','ggdsgsdf','vvvv','vvvvvvvvvvvvvvvv','vvvvvvvvvvvvvvvvvvvvvvv','vvvvvvvvvvvvvvvvvvvvvvvvvvvv','1','initiated'),(20,'11111','Maha','2014-04-07',22222,'sdfsfs',2,'sdfsfsdf','Daily,Decreasing','Sexual,Emotional','yes','no','no','ggdsgsdf','vvvv','vvvvvvvvvvvvvvvv','vvvvvvvvvvvvvvvvvvvvvvv','vvvvvvvvvvvvvvvvvvvvvvvvvvvv','1','initiated'),(21,'11111','Maha','2014-04-07',22222,'sdfsfs',3,'sdfsfsdf','Daily,Decreasing','Sexual,Emotional','yes','no','no','ggdsgsdf','vvvv','vvvvvvvvvvvvvvvv','vvvvvvvvvvvvvvvvvvvvvvv','vvvvvvvvvvvvvvvvvvvvvvvvvvvv','1','initiated'),(22,'11111','Maha','2014-04-07',22222,'sdfsfs',3,'sdfsfsdf','Daily,Decreasing','Sexual,Emotional','yes','no','no','ggdsgsdf','vvvv','vvvvvvvvvvvvvvvv','vvvvvvvvvvvvvvvvvvvvvvv','vvvvvvvvvvvvvvvvvvvvvvvvvvvv','1','initiated'),(23,'11111','Maha','2014-04-07',22222,'sdfsfs',3,'sdfsfsdf','Daily,Decreasing','Sexual,Emotional','yes','no','no','ggdsgsdf','vvvv','vvvvvvvvvvvvvvvv','vvvvvvvvvvvvvvvvvvvvvvv','vvvvvvvvvvvvvvvvvvvvvvvvvvvv','1','initiated');
/*!40000 ALTER TABLE `report_init` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-04-24 17:30:36
