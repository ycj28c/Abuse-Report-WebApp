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
-- Table structure for table `attachment`
--

DROP TABLE IF EXISTS `attachment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attachment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `newname` varchar(100) NOT NULL,
  `oldname` varchar(100) NOT NULL,
  `path` varchar(100) NOT NULL,
  `userid` varchar(30) NOT NULL,
  `reportid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=143 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attachment`
--

LOCK TABLES `attachment` WRITE;
/*!40000 ALTER TABLE `attachment` DISABLE KEYS */;
INSERT INTO `attachment` VALUES (1,'5764e778-141f-4907-ae9d-8815bb7a0ede.exe','chrome.exe','upload\\\\2014\\03\\11\\5764e778-141f-4907-ae9d-8815bb7a0ede.exe','11111',218),(2,'00f5aa57-a20c-40d0-85f8-2933dcf99ec5.exe','AcroRd32.exe','upload\\\\2014\\03\\11\\00f5aa57-a20c-40d0-85f8-2933dcf99ec5.exe','11111',218),(3,'f0c66c88-0196-4f47-9588-c050bc0e1b0a.exe','chrome.exe','upload\\\\2014\\03\\11\\f0c66c88-0196-4f47-9588-c050bc0e1b0a.exe','11111',219),(4,'3bd613c6-a3b1-4c4c-a1a2-9039c4424633.exe','GFExperience.exe','upload\\\\2014\\03\\11\\3bd613c6-a3b1-4c4c-a1a2-9039c4424633.exe','11111',219),(6,'c436ea66-abed-4c54-8ebd-ce8aa7734be9.exe','chrome.exe','upload\\\\2014\\03\\11\\c436ea66-abed-4c54-8ebd-ce8aa7734be9.exe','11111',220),(92,'b03502ac-9cea-41b8-9d9f-86b643c7b63a.exe','chrome.exe','upload\\\\2014\\03\\12\\b03502ac-9cea-41b8-9d9f-86b643c7b63a.exe','11111',225),(93,'c13bee1a-a9ef-44e4-b0b2-6a8305ae61d1.jpg','Lighthouse.jpg','upload\\\\2014\\03\\12\\c13bee1a-a9ef-44e4-b0b2-6a8305ae61d1.jpg','11111',229),(94,'727e83f4-1d33-43d9-a41c-ac1b68bdd220.jpg','Lighthouse.jpg','upload\\\\2014\\03\\12\\727e83f4-1d33-43d9-a41c-ac1b68bdd220.jpg','11111',230),(95,'3fc42b6f-ad01-474b-b8d4-2b0eae5cc4f0.exe','GFExperience.exe','upload\\\\2014\\03\\12\\3fc42b6f-ad01-474b-b8d4-2b0eae5cc4f0.exe','11111',233),(96,'934b8e50-6bf9-4758-b5d5-739f7f67e2c0.exe','Hearthstone Beta Launcher.exe','upload\\\\2014\\03\\12\\934b8e50-6bf9-4758-b5d5-739f7f67e2c0.exe','11111',235),(97,'f3523407-972a-49a4-aca6-8cd85ef36375.txt','端口映射.txt','upload\\\\2014\\03\\12\\f3523407-972a-49a4-aca6-8cd85ef36375.txt','11111',235),(98,'341aa2d5-3814-4343-bcf1-57842c4e2fc0.exe','Hearthstone Beta Launcher.exe','upload\\\\2014\\03\\12\\341aa2d5-3814-4343-bcf1-57842c4e2fc0.exe','11111',236),(99,'543745e6-7892-450e-b859-4f3a367579e2.exe','AcroRd32.exe','upload\\\\2014\\03\\12\\543745e6-7892-450e-b859-4f3a367579e2.exe','11111',237),(100,'2175be90-765c-4a3d-8367-4506ecc651aa.exe','GFExperience.exe','upload\\\\2014\\03\\12\\2175be90-765c-4a3d-8367-4506ecc651aa.exe','11111',238),(101,'b5fd4e99-9fc5-4b03-ae0d-ec18c508e9fa.exe','GitHub.exe','upload\\\\2014\\03\\12\\b5fd4e99-9fc5-4b03-ae0d-ec18c508e9fa.exe','11111',239),(103,'5a610989-24f7-499f-a839-80a47f12bf01.jpg','Penguins.jpg','upload\\\\2014\\03\\12\\5a610989-24f7-499f-a839-80a47f12bf01.jpg','11111',1),(104,'2df9e59e-7804-42e0-9eae-264b15e1347d.jpg','Lighthouse.jpg','upload\\\\2014\\03\\12\\2df9e59e-7804-42e0-9eae-264b15e1347d.jpg','11111',1),(105,'667c6338-fb4c-4c5d-a083-914524d24872.jpg','Penguins.jpg','upload\\\\2014\\03\\12\\667c6338-fb4c-4c5d-a083-914524d24872.jpg','11111',1),(114,'ae678776-933b-4bda-a08b-6cca1fc90795.jpg','Penguins.jpg','upload\\\\2014\\03\\12\\ae678776-933b-4bda-a08b-6cca1fc90795.jpg','11111',240),(115,'595e376a-0254-4d0e-a055-b68ee2b49fa8.jpg','Penguins.jpg','upload\\\\2014\\03\\12\\595e376a-0254-4d0e-a055-b68ee2b49fa8.jpg','11111',241),(116,'1e500a87-03fb-4472-9da5-88e6584bfabd.jpg','Penguins.jpg','upload\\\\2014\\03\\12\\1e500a87-03fb-4472-9da5-88e6584bfabd.jpg','11111',242),(118,'409b06ab-a115-4965-b8c8-adeb1340b49e.exe','chrome.exe','upload\\\\2014\\03\\12\\409b06ab-a115-4965-b8c8-adeb1340b49e.exe','11111',243),(119,'df15c32d-f8ab-4cda-a272-6267ff255f13.exe','AcroRd32.exe','upload\\\\2014\\03\\12\\df15c32d-f8ab-4cda-a272-6267ff255f13.exe','11111',244),(120,'57f2cc40-70f5-4745-82fa-58a00ef88fc2.jpg','Tulips.jpg','upload\\\\2014\\03\\12\\57f2cc40-70f5-4745-82fa-58a00ef88fc2.jpg','11111',245),(121,'68ab5aa8-13c0-4470-8b16-a73c6499fb53.jpg','Jellyfish.jpg','upload\\\\2014\\03\\12\\68ab5aa8-13c0-4470-8b16-a73c6499fb53.jpg','11111',245),(124,'691978a8-4de7-4445-936f-cca1d44d0f81.txt','changelog.txt','upload\\\\2014\\03\\14\\691978a8-4de7-4445-936f-cca1d44d0f81.txt','11111',16),(125,'848a4036-a873-4e27-9ee1-bd0008ca4ab4.txt','changelog.txt','upload\\\\2014\\03\\14\\848a4036-a873-4e27-9ee1-bd0008ca4ab4.txt','11111',11),(126,'ec4c346a-ded0-48cf-9681-d0c5bd7bc48d.js','jquery.validate.js','upload\\\\2014\\03\\14\\ec4c346a-ded0-48cf-9681-d0c5bd7bc48d.js','11111',107),(138,'ee3578bd-9ecd-40f2-89ed-e4908836252c.dll','A3DUtils.dll','upload\\\\2014\\03\\30\\ee3578bd-9ecd-40f2-89ed-e4908836252c.dll','11111',3),(140,'5c3bfdfb-a01d-4da2-9df2-cd5137da7e4e.dll','AdobeLinguistic.dll','upload\\\\2014\\03\\30\\5c3bfdfb-a01d-4da2-9df2-cd5137da7e4e.dll','11111',2),(141,'ca9e0e13-b819-43a9-aae3-ec59588ef562.dll','sqlite.dll','upload\\\\2014\\03\\30\\ca9e0e13-b819-43a9-aae3-ec59588ef562.dll','11111',2),(142,'67380673-51f3-4837-9354-3e21e98bcb69.txt','status.txt','upload\\\\2014\\04\\21\\67380673-51f3-4837-9354-3e21e98bcb69.txt','11111',5);
/*!40000 ALTER TABLE `attachment` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-04-21 19:33:47
