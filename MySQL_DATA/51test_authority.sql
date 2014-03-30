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
-- Table structure for table `authority`
--

DROP TABLE IF EXISTS `authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `authority` (
  `PK_authority` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `role_id` varchar(45) NOT NULL,
  `url` varchar(200) DEFAULT NULL,
  `role_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`PK_authority`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authority`
--

LOCK TABLES `authority` WRITE;
/*!40000 ALTER TABLE `authority` DISABLE KEYS */;
INSERT INTO `authority` VALUES (1,'New Report','8','jsp/PrepareNewReport','staff-gp1'),(2,'Report List(person)','8','jsp/ReportListServlet?pageindex=1','staff-gp1'),(3,'Report List(group)','9','jsp/SupervisorReportListServlet?roleid=9&pageindex=1','supervior-gp1'),(4,'Waiting List','9','javascript:void(0)','supervior-gp1'),(5,'Finish List','9','javascript:void(0)','supervior-gp1'),(6,'Track Investn(group)','9','javascript:void(0)','supervior-gp1'),(8,'Manage Patient','1','jsp/newpatient.jsp','administrator'),(9,'Manage User','1','javascript:void(0)','administrator'),(10,'Report List(all)','2','jsp/SuperAdminReportListServlet?pageindex=1','super admin'),(11,'Set Authority','2','javascript:void(0)','super admin'),(12,'Set Group','2','javascript:void(0)','super admin'),(13,'Access Control','2','javascript:void(0)','super admin'),(14,'Investigation List(all)','2','javascript:void(0)','super admin'),(15,'List Report(all initial)','3','javascript:void(0)','HRC-chairman'),(16,'List Investigation(all)','3','javascript:void(0)','HRC-chairman'),(17,'New appeal','3','javascript:void(0)','HRC-chairman'),(18,'Calender Display','3','javascript:void(0)','HRC-chairman'),(19,'New Investigation','6','javascript:void(0)','investigator'),(20,'List Investigation(all)','6','javascript:void(0)','investigator'),(21,'Report List(group)','7','jsp/SupervisorReportListServlet?roleid=7&pageindex=1','human-resource-gp2'),(22,'Waiting List','7','javascript:void(0)','human-resource-gp2'),(23,'Finish List','7','javascript:void(0)','human-resource-gp2'),(24,'Track Investn(group)','7','javascript:void(0)','human-resource-gp2');
/*!40000 ALTER TABLE `authority` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-03-29 21:05:43
