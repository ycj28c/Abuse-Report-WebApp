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
-- Table structure for table `report`
--

DROP TABLE IF EXISTS `report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `report` (
  `reportid` int(11) NOT NULL AUTO_INCREMENT,
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
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `report`
--

LOCK TABLES `report` WRITE;
/*!40000 ALTER TABLE `report` DISABLE KEYS */;
INSERT INTO `report` VALUES (2,'11111','wenxin','2014-03-10',14555,'Maha',2,'sdf','Daily,Decreasing','Physical,Omission,Emotional,sds','no','fffffdf','sdfsdf','sdff','fsdfs','sdfsd','fsdf','fffffff','1','initiated'),(4,'11111','wenxin','2014-03-11',22222,'ahah',3,'sdfsd','Weekly,Increasing','Omission,Sexual,dssds','yes','no','sds','cccccccc','ddddddddddddd','eeeeeeeeeeeeeee','euuuuuuuuuuuuu','iiiiiiiiiiiiiicccc','2','created'),(5,'11111','Maha','2014-04-08',22222,'ggg',2,'sdf','Weekly,Decreasing','Omission,Sexual','yes','no','no','sdf','gggg','cvcxvxc','vxcvxcv','xcvxcvxcv','2','initiated'),(6,'11111','Maha','2014-04-08',22222,'dgert',2,'erter','Weekly,Increasing','Omission','yes','no','no','erwer','werdg','dgdf','werwer','wertttt','1','initiated'),(7,'11111','Maha','2014-04-08',22222,'dfs',2,'dfsdf','Weekly,Decreasing','Sexual','yes','no','no','ggggg','gggg','gg','gg','ggg','1','initiated'),(8,'11111','Maha','2014-04-07',22222,'sdfsfs',2,'sdfsfsdf','Daily,Decreasing','Sexual,Emotional','yes','no','no','ggdsgsdf','vvvv','vvvvvvvvvvvvvvvv','vvvvvvvvvvvvvvvvvvvvvvv','vvvvvvvvvvvvvvvvvvvvvvvvvvvv','1','created'),(9,'11111','Maha','2014-04-07',22222,'sdfsfs',2,'sdfsfsdf','Daily,Decreasing','Sexual,Emotional','yes','no','no','ggdsgsdf','vvvv','vvvvvvvvvvvvvvvv','vvvvvvvvvvvvvvvvvvvvvvv','vvvvvvvvvvvvvvvvvvvvvvvvvvvv','1','created'),(10,'11111','Maha','2014-04-07',22222,'sdfsfs',2,'sdfsfsdf','Daily,Decreasing','Sexual,Emotional','yes','no','no','ggdsgsdf','vvvv','vvvvvvvvvvvvvvvv','vvvvvvvvvvvvvvvvvvvvvvv','vvvvvvvvvvvvvvvvvvvvvvvvvvvv','1','created'),(11,'11111','Maha','2014-04-07',22222,'sdfsfs',2,'sdfsfsdf','Daily,Decreasing','Sexual,Emotional','yes','no','no','ggdsgsdf','vvvv','vvvvvvvvvvvvvvvv','vvvvvvvvvvvvvvvvvvvvvvv','vvvvvvvvvvvvvvvvvvvvvvvvvvvv','1','created'),(12,'11111','Maha','2014-04-07',22222,'sdfsfs',2,'sdfsfsdf','Daily,Decreasing','Sexual,Emotional','yes','no','no','ggdsgsdf','vvvv','vvvvvvvvvvvvvvvv','vvvvvvvvvvvvvvvvvvvvvvv','vvvvvvvvvvvvvvvvvvvvvvvvvvvv','1','created'),(13,'11111','Maha','2014-04-07',22222,'sdfsfs',2,'sdfsfsdf','Daily,Decreasing','Sexual,Emotional','yes','no','no','ggdsgsdf','vvvv','vvvvvvvvvvvvvvvv','vvvvvvvvvvvvvvvvvvvvvvv','vvvvvvvvvvvvvvvvvvvvvvvvvvvv','1','created'),(14,'11111','Maha','2014-04-07',22222,'sdfsfs',2,'sdfsfsdf','Daily,Decreasing','Sexual,Emotional','yes','no','no','ggdsgsdf','vvvv','vvvvvvvvvvvvvvvv','vvvvvvvvvvvvvvvvvvvvvvv','vvvvvvvvvvvvvvvvvvvvvvvvvvvv','1','created'),(15,'11111','Maha','2014-04-07',22222,'sdfsfs',2,'sdfsfsdf','Daily,Decreasing','Sexual,Emotional','yes','no','no','ggdsgsdf','vvvv','vvvvvvvvvvvvvvvv','vvvvvvvvvvvvvvvvvvvvvvv','vvvvvvvvvvvvvvvvvvvvvvvvvvvv','1','created'),(16,'11111','Maha','2014-04-07',22222,'sdfsfs',2,'sdfsfsdf','Daily,Decreasing','Sexual,Emotional','yes','no','no','ggdsgsdf','vvvv','vvvvvvvvvvvvvvvv','vvvvvvvvvvvvvvvvvvvvvvv','vvvvvvvvvvvvvvvvvvvvvvvvvvvv','1','created'),(17,'11111','Maha','2014-04-07',22222,'sdfsfs',2,'sdfsfsdf','Daily,Decreasing','Sexual,Emotional','yes','no','no','ggdsgsdf','vvvv','vvvvvvvvvvvvvvvv','vvvvvvvvvvvvvvvvvvvvvvv','vvvvvvvvvvvvvvvvvvvvvvvvvvvv','1','created'),(18,'11111','Maha','2014-04-07',22222,'sdfsfs',2,'sdfsfsdf','Daily,Decreasing','Sexual,Emotional','yes','no','no','ggdsgsdf','vvvv','vvvvvvvvvvvvvvvv','vvvvvvvvvvvvvvvvvvvvvvv','vvvvvvvvvvvvvvvvvvvvvvvvvvvv','1','created'),(20,'11111','Maha','2014-04-07',22222,'sdfsfs',2,'sdfsfsdf','Daily,Decreasing','Sexual,Emotional','yes','no','no','ggdsgsdf','vvvv','vvvvvvvvvvvvvvvv','vvvvvvvvvvvvvvvvvvvvvvv','vvvvvvvvvvvvvvvvvvvvvvvvvvvv','1','created'),(21,'11111','Maha','2014-04-07',22222,'sdfsfs',3,'sdfsfsdf','Daily,Decreasing','Sexual,Emotional','yes','no','no','ggdsgsdf','vvvv','vvvvvvvvvvvvvvvv','vvvvvvvvvvvvvvvvvvvvvvv','vvvvvvvvvvvvvvvvvvvvvvvvvvvv','1','created'),(22,'11111','Maha','2014-04-07',22222,'sdfsfs',3,'sdfsfsdf','Daily,Decreasing','Sexual,Emotional','yes','no','no','ggdsgsdf','vvvv','vvvvvvvvvvvvvvvv','vvvvvvvvvvvvvvvvvvvvvvv','vvvvvvvvvvvvvvvvvvvvvvvvvvvv','1','created'),(23,'11111','Maha','2014-04-07',22222,'sdfsfs',3,'sdfsfsdf','Daily,Decreasing','Sexual,Emotional','yes','no','no','ggdsgsdf','vvvv','vvvvvvvvvvvvvvvv','vvvvvvvvvvvvvvvvvvvvvvv','vvvvvvvvvvvvvvvvvvvvvvvvvvvv','1','created'),(24,'11111','Maha','2014-04-07',22222,'sdfsfs',3,'sdfsfsdf','Daily,Decreasing','Sexual,Emotional','yes','no','no','ggdsgsdf','vvvv','vvvvvvvvvvvvvvvv','vvvvvvvvvvvvvvvvvvvvvvv','vvvvvvvvvvvvvvvvvvvvvvvvvvvv','1','created'),(25,'11111','Maha','2014-04-07',66666,'sdfsfs',3,'sdfsfsdf','Daily,Decreasing','Sexual,Emotional','yes','no','no','ggdsgsdf','vvvv','vvvvvvvvvvvvvvvv','vvvvvvvvvvvvvvvvvvvvvvv','vvvvvvvvvvvvvvvvvvvvvvvvvvvv','1','created'),(26,'22222','Maha','2014-04-08',66666,'fdsf',3,'sdfsdf','Daily,Constant','Omission,Sexual','yes','no','no','sdfsdfsdf','sdfsdf','ggs','dgsdgsdg','sdgsdg','2','initiated'),(27,'22222','Maha','2014-04-08',66666,'dgfgg',3,'ggggsd','Weekly,Decreasing','Omission,Sexual','yes','no','no','sdfsdf','sdgsdg','sdfsdf','sdfsdf','gggg','2','initiated'),(28,'22222','Maha','2014-04-07',77777,'sdfsfs',3,'gggg','Weekly,Decreasing','Sexual,Emotional','yes','no','no','ggg','gds','fsdfs','dfsdfs','dfsdf','2','initiated'),(29,'11111','Maha','2014-04-15',77777,'ggggd',3,'dsfsdf','Daily,Decreasing','Omission,Sexual','yes','no','no','fff','fsdf','sdfs','dfsdf','sdf','1','created'),(30,'11111',NULL,'2014-04-08',NULL,'sdfsdf',NULL,'sdf','Daily,Decreasing','Omission,Sexual','yes','no','no','gg','gg','gg','ggg','fffff','1','created'),(31,'11111',NULL,'2014-04-07',NULL,'fff',NULL,'fff','Weekly,Constant','Sexual','yes','no','no','sdf','sdf','sd','fsdf','sdf','1','initiated'),(32,'11111',NULL,'2014-04-23',11111,'sdf ',2,'sdf','Weekly,Decreasing','Sexual','yes','no','no','sdf','sdf','sdf','sdf','sdf','1','initiated'),(33,'11111','haha','2014-04-14',11111,'ffff',2,'ffff','Weekly,Increasing','Omission,Sexual','yes','no','no','sdf','sdf','sdf','sd','f','1','initiated'),(34,'11111','haha','2014-04-15',22222,'Yichen Lin',2,'Yichen Lin','Episodic,Decreasing','Sexual','yes','no','no','sdf','sdf','fff','ff','fff','1','initiated'),(35,'11111','haha','2014-04-15',11111,'fff',3,'sdfsd','Daily,Constant','Sexual','yes','no','no','ss','fdsdf','sdf','sdfsd','fsdf','1','initiated'),(36,'11111','Wenxin Zhao','2014-04-07',11111,'dffff',2,'fsfsdf','Episodic,Decreasing','Sexual','yes','no','no','sdf','sdfsd','fsdf','sdfsdf','','1','created');
/*!40000 ALTER TABLE `report` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-04-24 17:30:39
