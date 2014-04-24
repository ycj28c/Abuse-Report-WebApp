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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `userid` varchar(30) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `telephone` varchar(45) DEFAULT NULL,
  `mandated` varchar(45) DEFAULT NULL,
  `SSN` varchar(45) DEFAULT NULL,
  `DOB` varchar(45) DEFAULT NULL,
  `groupid` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('11111','Wenxin Zhao','11111','222 main street apt333, worcester, ma 01608','22222222','no','354234','11/20/2000','1'),('22222','Yichen Lin','22222','444 main street apt333, worcester, ma 01608','33333333','yes','643564','10/22/2000','2'),('33333','Mohammed Ayub','33333','333 main street apt333, worcester, ma 01608','227777222','yes','345345','12/20/2000','2'),('44444','Qiukun Lin','44444','555 main street apt333, worcester, ma 01608','44444444','no','345345','10/23/2000','1'),('55555','Rundong Yu','55555','666 main street apt333, worcester, ma 01608','55555555','yes','854566','10/24/2000','2'),('66666','Chengjiao Yang','66666','111 main street apt333, worcester, ma 01608','11111111','yes','234234','10/20/2000','1'),('77777','Rui Jin','77777','666 main street apt333, worcester, ma 01608','77777777','yes','345234','10/24/2000','2');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-04-24 16:03:30
