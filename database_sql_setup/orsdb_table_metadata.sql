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
-- Table structure for table `table_metadata`
--

DROP TABLE IF EXISTS `table_metadata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `table_metadata` (
  `table_id` int(11) NOT NULL AUTO_INCREMENT,
  `db_id` int(11) NOT NULL,
  `schema_name` varchar(50) DEFAULT NULL,
  `table_name` varchar(50) NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  `col_count` int(11) DEFAULT NULL,
  `row_count` int(11) DEFAULT NULL,
  `location` varchar(100) DEFAULT NULL,
  `date_created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created_by` varchar(50) NOT NULL,
  `date_updated` timestamp NULL DEFAULT NULL,
  `updated_by` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`table_id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `table_metadata`
--

LOCK TABLES `table_metadata` WRITE;
/*!40000 ALTER TABLE `table_metadata` DISABLE KEYS */;
INSERT INTO `table_metadata` VALUES (1,2,'sisdbtest','enrolment_bosy','enrolment',222,630240,NULL,'2014-09-25 16:00:00','SYSTEM',NULL,NULL),(2,2,'sisdbtest','school_profile_history','school_profile_history',61,675554,NULL,'2014-09-25 16:00:00','SYSTEM',NULL,NULL),(3,2,'sisdbtest','personnel_teaching','Nationally-funded Teaching Personnel ',696,530714,NULL,'2014-10-07 16:00:00','SYSTEM',NULL,NULL),(4,2,'sisdbtest','personnel_nonteaching','Nationally-funded Non-Teaching Personnel ',0,0,NULL,'2016-12-21 06:31:29','SYSTEM',NULL,NULL),(5,2,'sisdbtest','enrolment_age','Age Profile Enrolment',0,0,NULL,'2016-12-21 06:31:29','SYSTEM',NULL,NULL),(6,2,'sisdbtest','physical_facility','Physical Facility',392,539065,NULL,'2014-11-04 16:00:00','SYSTEM',NULL,NULL),(7,2,'sisdbtest','ref_region','National/Official Regions Physical database table.',6,17,NULL,'2014-11-06 16:00:00','SYSTEM',NULL,NULL),(8,2,'sisdbtest','personnel_locallyfunded','Locally-funded Personnel',43,0,NULL,'2016-12-21 06:31:29','',NULL,NULL),(9,2,'sisdbtest','personnel_bygradelevel','Personnel by Grade Level',30,0,NULL,'2016-12-21 06:31:29','',NULL,NULL),(10,2,'sisdbtest','personnel_byspecialization','Number of Teachers by Teaching Assignment and by  Area of Specialization',39,0,NULL,'2016-12-21 06:31:29','',NULL,NULL),(11,2,'sisdbtest','disaster_calamities','Disaster Calamities',0,0,NULL,'2016-12-21 06:31:29','SYSTEM',NULL,NULL),(12,2,'sisdbtest','sped','Learners with Exceptionalities',0,0,NULL,'2016-12-21 14:57:38','SYSTEM',NULL,NULL),(13,2,'sisdbtest','mother_tongue','Language used as medium of instructions from Kindergarten to Grade 3 ',0,0,NULL,'2016-12-21 06:31:30','SYSTEM',NULL,NULL),(14,2,'sisdbtest','classroom_furniture','Data on classroom, furniture and toilets',0,0,NULL,'2016-12-21 06:31:30','SYSTEM',NULL,NULL),(15,2,'sisdbtest','computer_internet','Data on Computer and Internet',0,0,NULL,'2016-12-21 06:31:30','SYSTEM',NULL,NULL),(16,2,'sisdbtest','other_school_data','Other School Data',0,0,NULL,'2016-12-21 06:31:30','SYSTEM',NULL,NULL),(17,2,'sisdbtest','water_electricity','Water and Electrical Supply',0,0,NULL,'2016-12-21 06:31:30','SYSTEM',NULL,NULL),(18,2,'sisdbtest','internet_connection','Internet Connection',0,0,NULL,'2016-12-21 06:31:30','SYSTEM',NULL,NULL),(19,2,'sisdbtest','enrolment_program','Learners Data By Program',0,0,NULL,'2016-12-21 06:31:30','SYSTEM',NULL,NULL),(20,2,'sisdbtest','enrolment_tle','Learners Data in Technology and Livelihood Education (TLE)',0,0,NULL,'2016-12-21 06:31:30','SYSTEM',NULL,NULL),(21,2,'sisdbtest','causes_of_dropout','Causes of Dropouts',0,0,NULL,'2016-12-21 06:31:30','SYSTEM',NULL,NULL),(22,2,'sisdbtest','enrolment_kinder_als','Enrolment in Kinder Summer Program and ALS Learners in the School',0,0,NULL,'2016-12-21 06:31:30','SYSTEM',NULL,NULL),(23,2,'sisdbtest','teacher_by_residence','Number of Teachers By Residence',0,0,NULL,'2016-12-21 06:31:30','SYSTEM',NULL,NULL),(24,2,'sisdbtest','school_site','School Site Data',0,0,NULL,'2016-12-21 06:31:30','SYSTEM',NULL,NULL),(25,2,'sisdbtest','other_private_school_data','Other Private School Data',0,0,NULL,'2016-12-21 06:31:30','SYSTEM',NULL,NULL),(26,2,'sisdbtest','nsbi_summary','nsbi summary report',0,0,NULL,'2017-03-27 16:00:00','SYSTEM','2017-03-27 16:00:00','SYSTEM'),(27,2,'sisdbtest','nsbi_specifics','nsbi specifics report',0,0,NULL,'2017-03-27 16:00:00','SYSTEM','2017-03-27 16:00:00','SYSTEM'),(28,2,'sisdbtest','building_structure_type','building_structure_type',0,0,NULL,'2017-03-27 16:00:00','SYSTEM','2017-03-27 16:00:00','SYSTEM'),(29,2,'sisdbtest','ref_code_setting','ref_code_setting',0,0,NULL,'2017-03-27 16:00:00','SYSTEM','2017-03-27 16:00:00','SYSTEM'),(30,2,'sisdbtest','ref_code_setting','ref_code_setting',0,0,NULL,'2017-03-27 16:00:00','SYSTEM','2017-03-27 16:00:00','SYSTEM'),(31,2,'sisdbtest','ref_code_setting','ref_code_setting',0,0,NULL,'2017-03-27 16:00:00','SYSTEM','2017-03-27 16:00:00','SYSTEM'),(32,2,'sisdbtest','ref_code_setting','ref_code_setting',0,0,NULL,'2017-03-27 16:00:00','SYSTEM','2017-03-27 16:00:00','SYSTEM'),(33,2,'sisdbtest','ref_code_setting','ref_code_setting',0,0,NULL,'2017-03-27 16:00:00','SYSTEM','2017-03-27 16:00:00','SYSTEM'),(34,2,'sisdbtest','ref_specific_fund_source','ref_specific_fund_source',0,0,NULL,'2017-04-03 16:00:00','SYSTEM','2017-04-03 16:00:00','SYSTEM'),(35,2,'sisdbtest','ref_baranggay','ref baranggay',0,0,NULL,'2017-04-03 16:00:00','SYSTEM','2017-04-03 16:00:00','SYSTEM'),(36,2,'sisdbtest','ref_municipality','ref_municipality',0,0,NULL,'2017-04-03 16:00:00','SYSTEM','2017-04-03 16:00:00','SYSTEM'),(37,2,'sisdbtest','ref_office','ref_office',0,0,NULL,'2017-04-03 16:00:00','SYSTEM','2017-04-03 16:00:00','SYSTEM'),(39,2,'sisdbtest','ref_legislative','ref_legislative',0,0,NULL,'2017-04-03 16:00:00','SYSTEM','2017-04-03 16:00:00','SYSTEM'),(40,2,'sisdbtest','ref_province','ref_province',0,0,'','2017-04-03 16:00:00','SYSTEM','2017-04-03 16:00:00','SYSTEM'),(41,2,'sisdbtest','shs_enrollment_first_sem','SHS Enrollment First Sem',0,0,NULL,'2017-09-05 16:00:00','SYSTEM','2017-09-05 16:00:00','SYSTEM'),(42,2,'sisdbtest','shs_enrollment_second_sem','SHS Enrollment Second Sem',0,0,NULL,'2017-09-05 16:00:00','SYSTEM','2017-09-05 16:00:00','SYSTEM'),(43,2,'sisdbtest','shs_tvl','SHS TVL',0,0,NULL,'2017-09-28 16:00:00','SYSTEM','2017-09-28 16:00:00','SYSTEM'),(44,2,'sisdbtest','tableA','tableA',0,0,NULL,'2016-12-21 06:31:29','SYSTEM',NULL,NULL);
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

-- Dump completed on 2018-09-16 12:01:02
