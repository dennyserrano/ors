-- MySQL dump 10.13  Distrib 5.6.16, for Linux (x86_64)
--
-- Host: 10.10.2.139    Database: orsdb
-- ------------------------------------------------------
-- Server version       5.6.17-66.0-log

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
-- Dumping data for table `dataset_head`
--
-- WHERE:  name like 'Kinder Summer %'

LOCK TABLES `dataset_head` WRITE;
/*!40000 ALTER TABLE `dataset_head` DISABLE KEYS */;
INSERT INTO `dataset_head` (`id`, `name`, `description`, `owner_id`, `date_created`, `created_by`, `date_updated`, `updated_by`, `visible`, `parent_dataset_head`, `table_id`, `ranking`) VALUES (123,'Kinder Summer Program and ALS Learners in the School','Kinder Summer Program and ALS Learners in the School',1,'2014-12-10 08:25:23','SYSTEM',NULL,NULL,1,1,22,28);
/*!40000 ALTER TABLE `dataset_head` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-21 21:18:51

