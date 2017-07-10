-- MySQL dump 10.13  Distrib 5.7.18, for Linux (x86_64)
--
-- Host: localhost    Database: orsdb
-- ------------------------------------------------------
-- Server version	5.7.18-0ubuntu0.16.04.1

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
-- Dumping data for table `table_metadata`
--
-- WHERE:  table_id in (35,36,7,2)

LOCK TABLES `table_metadata` WRITE;
/*!40000 ALTER TABLE `table_metadata` DISABLE KEYS */;
INSERT INTO `table_metadata` VALUES (2,2,'sisdbtest','school_profile_history','school_profile_history',61,675554,NULL,'2014-09-25 16:00:00','SYSTEM',NULL,NULL),(7,2,'sisdbtest','ref_region','National/Official Regions Physical database table.',6,17,NULL,'2014-11-06 16:00:00','SYSTEM',NULL,NULL),(35,2,'sisdbtest','ref_baranggay','ref baranggay',0,0,NULL,'2017-04-03 16:00:00','SYSTEM','2017-04-03 16:00:00','SYSTEM'),(36,2,'sisdbtest','ref_municipality','ref_municipality',0,0,NULL,'2017-04-03 16:00:00','SYSTEM','2017-04-03 16:00:00','SYSTEM');
/*!40000 ALTER TABLE `table_metadata` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-10 11:54:00