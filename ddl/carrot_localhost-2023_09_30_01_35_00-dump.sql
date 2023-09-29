-- MariaDB dump 10.19-11.1.2-MariaDB, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: carrot
-- ------------------------------------------------------
-- Server version	11.1.2-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `address` (
  `address_id` int(11) NOT NULL AUTO_INCREMENT,
  `country_fk` int(11) NOT NULL,
  `municipality_fk` int(11) NOT NULL,
  `city_fk` int(11) NOT NULL,
  `user_fk` int(11) NOT NULL,
  `street` varchar(64) DEFAULT NULL,
  `number` varchar(8) DEFAULT NULL,
  `last_modified_date` timestamp NULL DEFAULT current_timestamp(),
  `last_modified_by` varchar(128) DEFAULT 'system',
  `created_date` timestamp NULL DEFAULT current_timestamp(),
  `record_status` int(11) DEFAULT 1,
  PRIMARY KEY (`address_id`),
  KEY `fk_address_country` (`country_fk`),
  KEY `fk_address_municipality` (`municipality_fk`),
  KEY `fk_address_city` (`city_fk`),
  KEY `fk_address_user` (`user_fk`),
  CONSTRAINT `fk_address_city` FOREIGN KEY (`city_fk`) REFERENCES `city` (`city_id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_address_country` FOREIGN KEY (`country_fk`) REFERENCES `country` (`country_id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_address_municipality` FOREIGN KEY (`municipality_fk`) REFERENCES `municipality` (`municipality_id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_address_user` FOREIGN KEY (`user_fk`) REFERENCES `user` (`user_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES
(1,3,2,1,3,'Pionirska','6','2023-09-28 21:10:40','system','2023-09-28 21:10:40',1),
(2,3,2,1,9,'Knjazevacka','31','2023-09-28 22:28:43','system','2023-09-28 22:28:43',1),
(3,4,4,4,9,'Test','1','2023-09-28 22:29:04','system','2023-09-28 22:29:04',1);
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL,
  `last_modified_date` timestamp NULL DEFAULT current_timestamp(),
  `last_modified_by` varchar(128) DEFAULT 'system',
  `created_date` timestamp NULL DEFAULT current_timestamp(),
  `record_status` int(11) DEFAULT 1,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES
(1,'Laptops','2023-09-29 22:30:42','system',NULL,1),
(3,'PC Components','2023-09-29 22:30:36','system','2023-09-29 22:30:36',1);
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `city` (
  `city_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  `zip_code` varchar(16) DEFAULT NULL,
  `country_fk` int(11) DEFAULT NULL,
  `last_modified_date` timestamp NULL DEFAULT current_timestamp(),
  `last_modified_by` varchar(128) DEFAULT 'system',
  `created_date` timestamp NULL DEFAULT current_timestamp(),
  `record_status` int(11) DEFAULT 1,
  PRIMARY KEY (`city_id`),
  KEY `fk_city_country` (`country_fk`),
  CONSTRAINT `fk_city_country` FOREIGN KEY (`country_fk`) REFERENCES `country` (`country_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES
(1,'Niš','18000',3,'2023-09-28 20:25:44','system','2023-09-28 20:25:44',1),
(2,'Beograd','11000',3,'2023-09-28 20:37:39','system',NULL,1),
(4,'Zagreb','10000',4,'2023-09-28 22:29:50','system',NULL,1);
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment` (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_fk` int(11) NOT NULL,
  `user_fk` int(11) NOT NULL,
  `content` text DEFAULT NULL,
  `last_modified_date` timestamp NULL DEFAULT current_timestamp(),
  `last_modified_by` varchar(128) DEFAULT 'system',
  `created_date` timestamp NULL DEFAULT current_timestamp(),
  `record_status` int(11) DEFAULT 1,
  PRIMARY KEY (`comment_id`),
  KEY `fk_comment_product` (`product_fk`),
  KEY `fk_comment_user` (`user_fk`),
  CONSTRAINT `fk_comment_product` FOREIGN KEY (`product_fk`) REFERENCES `product` (`product_id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_comment_user` FOREIGN KEY (`user_fk`) REFERENCES `user` (`user_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `country` (
  `country_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  `last_modified_date` timestamp NULL DEFAULT current_timestamp(),
  `last_modified_by` varchar(128) DEFAULT 'system',
  `created_date` timestamp NULL DEFAULT current_timestamp(),
  `record_status` int(11) DEFAULT 1,
  PRIMARY KEY (`country_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` VALUES
(3,'Srbija','2023-09-27 23:46:17','system','2023-09-27 23:46:17',1),
(4,'Hrvatska','2023-09-28 21:51:24','system','2023-09-28 21:51:24',1);
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `municipality`
--

DROP TABLE IF EXISTS `municipality`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `municipality` (
  `municipality_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  `city_fk` int(11) DEFAULT NULL,
  `last_modified_date` timestamp NULL DEFAULT current_timestamp(),
  `last_modified_by` varchar(128) DEFAULT 'system',
  `created_date` timestamp NULL DEFAULT current_timestamp(),
  `record_status` int(11) DEFAULT 1,
  PRIMARY KEY (`municipality_id`),
  KEY `fk_municipality_city` (`city_fk`),
  CONSTRAINT `fk_municipality_city` FOREIGN KEY (`city_fk`) REFERENCES `city` (`city_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `municipality`
--

LOCK TABLES `municipality` WRITE;
/*!40000 ALTER TABLE `municipality` DISABLE KEYS */;
INSERT INTO `municipality` VALUES
(2,'Pantelej',1,'2023-09-28 20:39:54','system','2023-09-28 20:39:54',1),
(3,'Palilula',1,'2023-09-28 20:51:10','system',NULL,1),
(4,'Maksimir',4,'2023-09-28 22:24:53','system','2023-09-28 22:24:53',1);
/*!40000 ALTER TABLE `municipality` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_fk` int(11) NOT NULL,
  `total_price` float DEFAULT NULL,
  `last_modified_date` timestamp NULL DEFAULT current_timestamp(),
  `last_modified_by` varchar(128) DEFAULT 'system',
  `created_date` timestamp NULL DEFAULT current_timestamp(),
  `record_status` int(11) DEFAULT 1,
  PRIMARY KEY (`order_id`),
  KEY `fk_order_user` (`user_fk`),
  CONSTRAINT `fk_order_user` FOREIGN KEY (`user_fk`) REFERENCES `user` (`user_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` VALUES
(1,1,1,'2021-10-15 14:04:35','system','2021-10-15 14:04:35',1);
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) DEFAULT NULL,
  `product_brand_fk` int(11) DEFAULT NULL,
  `product_model_fk` int(11) DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `discount_price` float DEFAULT NULL,
  `ean` varchar(32) DEFAULT NULL COMMENT 'Barcode',
  `sub_category_fk` int(11) DEFAULT NULL,
  `last_modified_date` timestamp NULL DEFAULT current_timestamp(),
  `last_modified_by` varchar(128) DEFAULT 'system',
  `created_date` timestamp NULL DEFAULT current_timestamp(),
  `record_status` int(11) DEFAULT 1,
  PRIMARY KEY (`product_id`),
  KEY `fk_product_brand` (`product_brand_fk`),
  KEY `fk_product_model` (`product_model_fk`),
  KEY `fk_product_sub_category` (`sub_category_fk`),
  CONSTRAINT `fk_product_brand` FOREIGN KEY (`product_brand_fk`) REFERENCES `product_brand` (`product_brand_id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_product_model` FOREIGN KEY (`product_model_fk`) REFERENCES `product_model` (`product_model_id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_product_sub_category` FOREIGN KEY (`sub_category_fk`) REFERENCES `sub_category` (`sub_category_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES
(1,'Laptop Asus VivoBook',1,1,120,900,900,'2141242155125',4,'2021-10-15 14:04:06','system','2021-10-15 14:04:06',1);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_brand`
--

DROP TABLE IF EXISTS `product_brand`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_brand` (
  `product_brand_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `last_modified_date` timestamp NULL DEFAULT current_timestamp(),
  `last_modified_by` varchar(128) DEFAULT 'system',
  `created_date` timestamp NULL DEFAULT current_timestamp(),
  `record_status` int(11) DEFAULT 1,
  PRIMARY KEY (`product_brand_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_brand`
--

LOCK TABLES `product_brand` WRITE;
/*!40000 ALTER TABLE `product_brand` DISABLE KEYS */;
INSERT INTO `product_brand` VALUES
(1,'ASUS','2021-10-15 14:02:18','system','2021-10-15 14:02:18',1),
(2,'LENOVO','2023-09-29 22:23:30','system',NULL,1);
/*!40000 ALTER TABLE `product_brand` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_image`
--

DROP TABLE IF EXISTS `product_image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_image` (
  `product_image_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_fk` int(11) NOT NULL,
  `uri` varchar(256) DEFAULT NULL,
  `last_modified_date` timestamp NULL DEFAULT current_timestamp(),
  `last_modified_by` varchar(128) DEFAULT 'system',
  `created_date` timestamp NULL DEFAULT current_timestamp(),
  `record_status` int(11) DEFAULT 1,
  PRIMARY KEY (`product_image_id`),
  KEY `fk_product_image_product` (`product_fk`),
  CONSTRAINT `fk_product_image_product` FOREIGN KEY (`product_fk`) REFERENCES `product` (`product_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_image`
--

LOCK TABLES `product_image` WRITE;
/*!40000 ALTER TABLE `product_image` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_model`
--

DROP TABLE IF EXISTS `product_model`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_model` (
  `product_model_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `product_brand_fk` int(11) DEFAULT NULL,
  `last_modified_date` timestamp NULL DEFAULT current_timestamp(),
  `last_modified_by` varchar(128) DEFAULT 'system',
  `created_date` timestamp NULL DEFAULT current_timestamp(),
  `record_status` int(11) DEFAULT 1,
  PRIMARY KEY (`product_model_id`),
  KEY `fk_model_brand` (`product_brand_fk`),
  CONSTRAINT `fk_model_brand` FOREIGN KEY (`product_brand_fk`) REFERENCES `product_brand` (`product_brand_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_model`
--

LOCK TABLES `product_model` WRITE;
/*!40000 ALTER TABLE `product_model` DISABLE KEYS */;
INSERT INTO `product_model` VALUES
(1,'VivoBook',1,'2021-10-15 14:02:33','system','2021-10-15 14:02:33',1),
(2,'IdeaPad',2,'2023-09-29 22:28:42','system',NULL,1);
/*!40000 ALTER TABLE `product_model` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_order`
--

DROP TABLE IF EXISTS `product_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_order` (
  `product_order_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_fk` int(11) NOT NULL,
  `order_fk` int(11) NOT NULL,
  `quantity` int(11) DEFAULT 1,
  `last_modified_date` timestamp NULL DEFAULT current_timestamp(),
  `last_modified_by` varchar(128) DEFAULT 'system',
  `created_date` timestamp NULL DEFAULT current_timestamp(),
  `record_status` int(11) DEFAULT 1,
  PRIMARY KEY (`product_order_id`),
  KEY `product_order_product` (`product_fk`),
  KEY `product_order_order` (`order_fk`),
  CONSTRAINT `product_order_order` FOREIGN KEY (`order_fk`) REFERENCES `order` (`order_id`) ON UPDATE CASCADE,
  CONSTRAINT `product_order_product` FOREIGN KEY (`product_fk`) REFERENCES `product` (`product_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_order`
--

LOCK TABLES `product_order` WRITE;
/*!40000 ALTER TABLE `product_order` DISABLE KEYS */;
INSERT INTO `product_order` VALUES
(2,1,1,1,'2021-10-15 14:04:37','system','2021-10-15 14:04:37',1);
/*!40000 ALTER TABLE `product_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_specification`
--

DROP TABLE IF EXISTS `product_specification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_specification` (
  `product_specification_id` int(11) NOT NULL AUTO_INCREMENT,
  `key` varchar(32) DEFAULT NULL,
  `value` varchar(32) DEFAULT NULL,
  `product_fk` int(11) DEFAULT NULL,
  `last_modified_date` timestamp NULL DEFAULT current_timestamp(),
  `last_modified_by` varchar(128) DEFAULT 'system',
  `created_date` timestamp NULL DEFAULT current_timestamp(),
  `record_status` int(11) DEFAULT 1,
  PRIMARY KEY (`product_specification_id`),
  KEY `fk_product_specification_product` (`product_fk`),
  CONSTRAINT `fk_product_specification_product` FOREIGN KEY (`product_fk`) REFERENCES `product` (`product_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_specification`
--

LOCK TABLES `product_specification` WRITE;
/*!40000 ALTER TABLE `product_specification` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_specification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `last_modified_date` timestamp NULL DEFAULT current_timestamp(),
  `last_modified_by` varchar(128) DEFAULT 'system',
  `created_date` timestamp NULL DEFAULT current_timestamp(),
  `record_status` int(11) DEFAULT 1,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES
(1,'ADMIN','2021-10-15 12:49:49','system','2021-10-15 12:49:49',1),
(2,'CUSTOMER','2023-09-27 20:55:39','system','2023-09-27 20:55:39',1);
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sub_category`
--

DROP TABLE IF EXISTS `sub_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sub_category` (
  `sub_category_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  `category_fk` int(11) NOT NULL,
  `last_modified_date` timestamp NULL DEFAULT current_timestamp(),
  `last_modified_by` varchar(128) DEFAULT 'system',
  `created_date` timestamp NULL DEFAULT current_timestamp(),
  `record_status` int(11) DEFAULT 1,
  PRIMARY KEY (`sub_category_id`),
  KEY `fk_sub_category_category` (`category_fk`),
  CONSTRAINT `fk_sub_category_category` FOREIGN KEY (`category_fk`) REFERENCES `category` (`category_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sub_category`
--

LOCK TABLES `sub_category` WRITE;
/*!40000 ALTER TABLE `sub_category` DISABLE KEYS */;
INSERT INTO `sub_category` VALUES
(1,'CPU',3,'2021-10-15 14:04:00','system','2021-10-15 14:04:00',1),
(2,'GPU',3,'2023-09-29 22:46:15','system','2023-09-29 22:46:15',1),
(4,'Laptop',1,'2023-09-29 23:11:06','system','2023-09-29 23:11:06',1);
/*!40000 ALTER TABLE `sub_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(64) NOT NULL,
  `last_name` varchar(64) NOT NULL,
  `phone` varchar(16) DEFAULT NULL,
  `birth_date` date DEFAULT NULL,
  `email` varchar(32) NOT NULL,
  `username` varchar(32) NOT NULL,
  `password` varchar(64) DEFAULT NULL,
  `last_modified_date` timestamp NULL DEFAULT current_timestamp(),
  `last_modified_by` varchar(128) DEFAULT 'system',
  `created_date` timestamp NULL DEFAULT current_timestamp(),
  `record_status` int(11) DEFAULT 1,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES
(1,'Ad','Min','0648332673',NULL,'admin@carrot.rs','admin','$2a$12$skxmUryn199UdIoBjfYs9.RF5DbbIUuJCeRvh6L6n3OQSCNSFcIcG','2021-10-15 12:50:30','system','2021-10-15 12:50:30',1),
(3,'Tomislav','Živadinović','0648332673',NULL,'zivadinovictomislav@gmail.com','tzivadinovic',NULL,'2023-09-27 22:24:19','system',NULL,1),
(9,'Marko','Markovic','+38164625514',NULL,'marko@gmail.com','mare',NULL,'2023-09-27 22:25:02','system',NULL,1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `user_role_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_fk` int(11) NOT NULL,
  `role_fk` int(11) NOT NULL,
  `last_modified_date` timestamp NULL DEFAULT current_timestamp(),
  `last_modified_by` varchar(128) DEFAULT 'system',
  `created_date` timestamp NULL DEFAULT current_timestamp(),
  `record_status` int(11) DEFAULT 1,
  PRIMARY KEY (`user_role_id`),
  KEY `fk_user_user_role` (`user_fk`),
  KEY `fk_role_user_role` (`role_fk`),
  CONSTRAINT `fk_role_user_role` FOREIGN KEY (`role_fk`) REFERENCES `role` (`role_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_user_user_role` FOREIGN KEY (`user_fk`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES
(1,1,1,'2021-10-15 12:50:37','system','2021-10-15 12:50:37',1);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-09-30  1:35:00
