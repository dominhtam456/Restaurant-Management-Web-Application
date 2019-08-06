-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: quanlynhahang
-- ------------------------------------------------------
-- Server version	8.0.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ban`
--

DROP TABLE IF EXISTS `ban`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ban` (
  `BAN_ID` int(11) NOT NULL AUTO_INCREMENT,
  `BAN_NO` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `BAN_STATUS` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`BAN_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ban`
--

LOCK TABLES `ban` WRITE;
/*!40000 ALTER TABLE `ban` DISABLE KEYS */;
/*!40000 ALTER TABLE `ban` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chucvu`
--

DROP TABLE IF EXISTS `chucvu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chucvu` (
  `CHUCVU_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CHUCVU_NAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `CHUCVU_DES` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_vietnamese_ci,
  PRIMARY KEY (`CHUCVU_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chucvu`
--

LOCK TABLES `chucvu` WRITE;
/*!40000 ALTER TABLE `chucvu` DISABLE KEYS */;
INSERT INTO `chucvu` VALUES (1,'Phục vụ',NULL),(2,'Thu ngân',NULL),(3,'Bếp',NULL);
/*!40000 ALTER TABLE `chucvu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `country_master`
--

DROP TABLE IF EXISTS `country_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `country_master` (
  `country_id` int(11) NOT NULL,
  `country_lang` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `country_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `country_population` int(11) DEFAULT NULL,
  PRIMARY KEY (`country_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country_master`
--

LOCK TABLES `country_master` WRITE;
/*!40000 ALTER TABLE `country_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `country_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (9),(9);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hoadon`
--

DROP TABLE IF EXISTS `hoadon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hoadon` (
  `HOADON_ID` int(11) NOT NULL AUTO_INCREMENT,
  `HOADON_NO` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `HOADON_DATE` datetime DEFAULT CURRENT_TIMESTAMP,
  `HOADON_STATUS` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `HOADON_TAX` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `KHACHHANG_KHACHHANG_ID` int(11) NOT NULL,
  `BAN_BAN_ID` int(11) NOT NULL,
  `NHANVIEN_NHANVIEN_ID` int(11) NOT NULL,
  PRIMARY KEY (`HOADON_ID`),
  KEY `fk_HOADON_KHACHHANG1_idx` (`KHACHHANG_KHACHHANG_ID`),
  KEY `fk_HOADON_BAN1_idx` (`BAN_BAN_ID`),
  KEY `fk_HOADON_NHANVIEN1_idx` (`NHANVIEN_NHANVIEN_ID`),
  CONSTRAINT `fk_HOADON_BAN1` FOREIGN KEY (`BAN_BAN_ID`) REFERENCES `ban` (`BAN_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_HOADON_KHACHHANG1` FOREIGN KEY (`KHACHHANG_KHACHHANG_ID`) REFERENCES `khachhang` (`KHACHHANG_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_HOADON_NHANVIEN1` FOREIGN KEY (`NHANVIEN_NHANVIEN_ID`) REFERENCES `nhanvien` (`NHANVIEN_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoadon`
--

LOCK TABLES `hoadon` WRITE;
/*!40000 ALTER TABLE `hoadon` DISABLE KEYS */;
/*!40000 ALTER TABLE `hoadon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hoadonchitiet`
--

DROP TABLE IF EXISTS `hoadonchitiet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hoadonchitiet` (
  `HOADONCHITIET_PRICE` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `HOADONCHITIET_SOLUONG` int(11) DEFAULT NULL,
  `HOADON_HOADON_ID` int(11) NOT NULL,
  `MONAN_MONAN_ID` int(11) NOT NULL,
  PRIMARY KEY (`HOADON_HOADON_ID`,`MONAN_MONAN_ID`),
  KEY `fk_HOADONCHITIET_MONAN1_idx` (`MONAN_MONAN_ID`),
  CONSTRAINT `fk_HOADONCHITIET_HOADON1` FOREIGN KEY (`HOADON_HOADON_ID`) REFERENCES `hoadon` (`HOADON_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_HOADONCHITIET_MONAN1` FOREIGN KEY (`MONAN_MONAN_ID`) REFERENCES `monan` (`MONAN_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoadonchitiet`
--

LOCK TABLES `hoadonchitiet` WRITE;
/*!40000 ALTER TABLE `hoadonchitiet` DISABLE KEYS */;
/*!40000 ALTER TABLE `hoadonchitiet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khachhang`
--

DROP TABLE IF EXISTS `khachhang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khachhang` (
  `KHACHHANG_ID` int(11) NOT NULL AUTO_INCREMENT,
  `KHACHHANG_NO` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `KHACHHANG_NAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `KHACHHANG_ADD` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `KHACHHANG_PHONE` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `KHACHHANG_EMAIL` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`KHACHHANG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khachhang`
--

LOCK TABLES `khachhang` WRITE;
/*!40000 ALTER TABLE `khachhang` DISABLE KEYS */;
/*!40000 ALTER TABLE `khachhang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loaimonan`
--

DROP TABLE IF EXISTS `loaimonan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loaimonan` (
  `LOAIMONAN_ID` int(11) NOT NULL AUTO_INCREMENT,
  `LOAIMONAN_NAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `LOAIMONAN_DES` longtext COLLATE utf8_unicode_ci,
  PRIMARY KEY (`LOAIMONAN_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loaimonan`
--

LOCK TABLES `loaimonan` WRITE;
/*!40000 ALTER TABLE `loaimonan` DISABLE KEYS */;
/*!40000 ALTER TABLE `loaimonan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loainguyenlieu`
--

DROP TABLE IF EXISTS `loainguyenlieu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loainguyenlieu` (
  `LOAINGUYENLIEU_ID` int(11) NOT NULL AUTO_INCREMENT,
  `LOAINGUYENLIEU_NAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `LOAINGUYENLIEU_UNIT` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`LOAINGUYENLIEU_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loainguyenlieu`
--

LOCK TABLES `loainguyenlieu` WRITE;
/*!40000 ALTER TABLE `loainguyenlieu` DISABLE KEYS */;
INSERT INTO `loainguyenlieu` VALUES (1,'Thịt','Kg'),(2,'Rau, củ, quả','Kg'),(3,'Sữa','Ml'),(4,'Nước','Lít'),(5,'Trứng','Hộp'),(6,'Gia vị','Kg');
/*!40000 ALTER TABLE `loainguyenlieu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `monan`
--

DROP TABLE IF EXISTS `monan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `monan` (
  `MONAN_ID` int(11) NOT NULL AUTO_INCREMENT,
  `MONAN_NAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `MONAN_PRICE` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `MONAN_UNIT` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `MONAN_STATUS` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `MONAN_COL` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `LOAIMONAN_LOAIMONAN_ID` int(11) NOT NULL,
  PRIMARY KEY (`MONAN_ID`),
  KEY `fk_MONAN_LOAIMONAN1_idx` (`LOAIMONAN_LOAIMONAN_ID`),
  CONSTRAINT `fk_MONAN_LOAIMONAN1` FOREIGN KEY (`LOAIMONAN_LOAIMONAN_ID`) REFERENCES `loaimonan` (`LOAIMONAN_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `monan`
--

LOCK TABLES `monan` WRITE;
/*!40000 ALTER TABLE `monan` DISABLE KEYS */;
/*!40000 ALTER TABLE `monan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `monanchitiet`
--

DROP TABLE IF EXISTS `monanchitiet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `monanchitiet` (
  `MONANCHITIET_SOLUONG` float DEFAULT NULL,
  `MONAN_MONAN_ID` int(11) NOT NULL,
  `NGUYENLIEU_NGUYENLIEU_ID` int(11) NOT NULL,
  PRIMARY KEY (`MONAN_MONAN_ID`,`NGUYENLIEU_NGUYENLIEU_ID`),
  KEY `fk_MONANCHITIET_NGUYENLIEU1_idx` (`NGUYENLIEU_NGUYENLIEU_ID`),
  CONSTRAINT `fk_MONANCHITIET_MONAN1` FOREIGN KEY (`MONAN_MONAN_ID`) REFERENCES `monan` (`MONAN_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_MONANCHITIET_NGUYENLIEU1` FOREIGN KEY (`NGUYENLIEU_NGUYENLIEU_ID`) REFERENCES `nguyenlieu` (`NGUYENLIEU_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `monanchitiet`
--

LOCK TABLES `monanchitiet` WRITE;
/*!40000 ALTER TABLE `monanchitiet` DISABLE KEYS */;
/*!40000 ALTER TABLE `monanchitiet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nguyenlieu`
--

DROP TABLE IF EXISTS `nguyenlieu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nguyenlieu` (
  `NGUYENLIEU_ID` int(11) NOT NULL AUTO_INCREMENT,
  `NGUYENLIEU_NO` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `NGUYENLIEU_NAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `NGUYENLIEU_PRICE` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `NGUYENLIEU_DATE` date DEFAULT NULL,
  `NGUYENLIEU_IMG` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `LOAINGUYENLIEU_LOAINGUYENLIEU_ID` int(11) NOT NULL,
  PRIMARY KEY (`NGUYENLIEU_ID`),
  KEY `fk_NGUYENLIEU_LOAINGUYENLIEU1_idx` (`LOAINGUYENLIEU_LOAINGUYENLIEU_ID`),
  CONSTRAINT `fk_NGUYENLIEU_LOAINGUYENLIEU1` FOREIGN KEY (`LOAINGUYENLIEU_LOAINGUYENLIEU_ID`) REFERENCES `loainguyenlieu` (`LOAINGUYENLIEU_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nguyenlieu`
--

LOCK TABLES `nguyenlieu` WRITE;
/*!40000 ALTER TABLE `nguyenlieu` DISABLE KEYS */;
INSERT INTO `nguyenlieu` VALUES (1,'1tb','Thịt bò','280.000','2019-09-02',NULL,1),(2,'1thd','Thịt heo đùi','80.000','2019-09-02',NULL,1),(3,'2rd','Rau dền','10.000','2019-09-02',NULL,2),(4,'2rcv','Rau chân vịt','9.000','2019-09-02',NULL,2),(6,'2kt','Khoai tây','22.000','2019-09-02',NULL,2),(7,'3stvm','Sữa Tươi Vinamilk 100% Có Đường - Hộp 900ml','34.000','2020-09-02',NULL,3),(8,'6d','Đường','9000','2020-09-02',NULL,6);
/*!40000 ALTER TABLE `nguyenlieu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhanvien`
--

DROP TABLE IF EXISTS `nhanvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhanvien` (
  `NHANVIEN_ID` int(11) NOT NULL AUTO_INCREMENT,
  `NHANVIEN_NO` varchar(10) DEFAULT NULL,
  `NHANVIEN_NAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `NHANVIEN_PHONE` varchar(10) DEFAULT NULL,
  `NHANVIEN_EMAIL` varchar(50) DEFAULT NULL,
  `NHANVIEN_PASSWORD` varchar(50) DEFAULT NULL,
  `NHANVIEN_LOAI` smallint(3) DEFAULT NULL,
  `CHUCVU_CHUCVU_ID` int(11) NOT NULL,
  PRIMARY KEY (`NHANVIEN_ID`),
  KEY `fk_NHANVIEN_CHUCVU_idx` (`CHUCVU_CHUCVU_ID`),
  CONSTRAINT `fk_NHANVIEN_CHUCVU` FOREIGN KEY (`CHUCVU_CHUCVU_ID`) REFERENCES `chucvu` (`CHUCVU_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhanvien`
--

LOCK TABLES `nhanvien` WRITE;
/*!40000 ALTER TABLE `nhanvien` DISABLE KEYS */;
INSERT INTO `nhanvien` VALUES (2,'001','VIETDEPTRAI','0904716299','nguyenthanhviet31031998@gmail.com','1234567',2,2),(3,'002','HIEP','1234567890','nguyenvanhiep1998@gmail.com','1234567',1,1),(4,'003','TAM','0987654321','dominhtam1998@gmail.com','1234567',2,2),(5,'004','DANH','0908771234','buingocdanh123@gmail.com','',NULL,3),(6,'005','KHANG','1239874561','dinhkhang1998@gmail.com','1234567',1,1);
/*!40000 ALTER TABLE `nhanvien` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-08-06 22:14:59
