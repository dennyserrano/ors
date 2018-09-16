-- MySQL dump 10.13  Distrib 5.7.22, for Linux (x86_64)
--
-- Host: localhost    Database: orsdb
-- ------------------------------------------------------
-- Server version	5.7.22-0ubuntu0.16.04.1

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
-- Table structure for table `dataset_criteria`
--

DROP TABLE IF EXISTS `dataset_criteria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dataset_criteria` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dataset_head_id` bigint(20) NOT NULL,
  `filter_type` smallint(6) NOT NULL,
  `left_element_id` bigint(20) NOT NULL,
  `operator` varchar(10) NOT NULL,
  `value_type` varchar(20) DEFAULT NULL,
  `right_element_id` bigint(20) DEFAULT NULL,
  `date_created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created_by` varchar(50) NOT NULL,
  `date_updated` timestamp NULL DEFAULT NULL,
  `updated_by` varchar(50) DEFAULT NULL,
  `filter_name` varchar(50) NOT NULL,
  `input_type` smallint(6) NOT NULL,
  `visible` tinyint(3) NOT NULL,
  `label` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dataset_criteria`
--

LOCK TABLES `dataset_criteria` WRITE;
/*!40000 ALTER TABLE `dataset_criteria` DISABLE KEYS */;
INSERT INTO `dataset_criteria` VALUES (8,8,0,308,'EQ','tinyint',NULL,'2016-10-19 04:04:47','SYSTEM',NULL,NULL,'sp_region',1,1,'Region'),(9,8,0,309,'EQ','int',NULL,'2016-10-19 04:04:47','SYSTEM',NULL,NULL,'sp_division',1,1,'Division'),(10,8,0,310,'EQ','smallint',NULL,'2016-10-19 04:04:47','SYSTEM',NULL,NULL,'sp_schoolType',1,1,'School Type'),(11,8,0,311,'EQ','smallint',NULL,'2016-10-19 04:04:47','SYSTEM',NULL,NULL,'sp_sector',1,1,'Sector'),(12,8,0,312,'EQ','smallint',NULL,'2016-10-19 04:04:47','SYSTEM',NULL,NULL,'sp_level',1,1,'General Curricular Offering'),(15,8,0,266,'EQ','smallint',NULL,'2016-10-19 04:04:47','SYSTEM',NULL,NULL,'sp_sy_from',1,1,'School Year'),(16,8,0,267,'EQ','varchar',NULL,'2016-10-19 04:05:42','SYSTEM',NULL,NULL,'sp_schoolName',0,1,'School Name'),(17,8,2,10936,'IN','varchar',NULL,'2016-12-26 18:33:25','',NULL,NULL,'sp_subsector',2,1,''),(18,8,2,10937,'IN','smallint',NULL,'2016-12-26 18:33:25','',NULL,NULL,'sp_sublevel',3,1,''),(19,8,0,11237,'EQ','tinyint',NULL,'2016-12-26 18:33:25','SYSTEM',NULL,NULL,'sp_district',1,1,'District'),(22,8,0,11238,'EQ','tinyint',NULL,'2016-12-26 18:33:25','SYSTEM',NULL,NULL,'sp_province',1,1,'Province'),(23,8,0,11236,'EQ','tinyint',NULL,'2016-12-26 18:33:25','SYSTEM','2016-12-26 18:33:25',NULL,'sp_municipality',1,1,'Municipality'),(24,8,0,11239,'EQ','tinyint',NULL,'2016-12-26 18:33:25','SYSTEM','2016-12-26 18:33:25',NULL,'sp_legislative',1,1,'Legislative');
/*!40000 ALTER TABLE `dataset_criteria` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-09-16 12:01:02
