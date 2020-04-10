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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ban`
--

LOCK TABLES `ban` WRITE;
/*!40000 ALTER TABLE `ban` DISABLE KEYS */;
INSERT INTO `ban` VALUES (1,'Bàn 1','Trống'),(2,'Bàn 2','Trống'),(3,'Bàn 3','Trống'),(4,'Bàn 4','Trống'),(5,'Bàn 5','Trống'),(6,'Bàn 6','Trống'),(7,'Bàn 7','Trống'),(8,'Bàn 8','Trống'),(9,'Bàn 9','Trống');
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
-- Table structure for table `hoadon`
--

DROP TABLE IF EXISTS `hoadon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hoadon` (
  `HOADON_ID` int(11) NOT NULL AUTO_INCREMENT,
  `HOADON_NO` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `HOADON_DATE` date DEFAULT NULL,
  `HOADON_STATUS` bit(1) DEFAULT NULL,
  `HOADON_TAX` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `KHACHHANG_KHACHHANG_ID` int(11) DEFAULT NULL,
  `BAN_BAN_ID` int(11) NOT NULL,
  `NHANVIEN_NHANVIEN_ID` int(11) NOT NULL,
  PRIMARY KEY (`HOADON_ID`),
  UNIQUE KEY `HOADON_NO_UNIQUE` (`HOADON_NO`),
  KEY `fk_HOADON_KHACHHANG1_idx` (`KHACHHANG_KHACHHANG_ID`),
  KEY `fk_HOADON_BAN1_idx` (`BAN_BAN_ID`),
  KEY `fk_HOADON_NHANVIEN1_idx` (`NHANVIEN_NHANVIEN_ID`),
  CONSTRAINT `fk_HOADON_BAN1` FOREIGN KEY (`BAN_BAN_ID`) REFERENCES `ban` (`BAN_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_HOADON_KHACHHANG1` FOREIGN KEY (`KHACHHANG_KHACHHANG_ID`) REFERENCES `khachhang` (`KHACHHANG_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_HOADON_NHANVIEN1` FOREIGN KEY (`NHANVIEN_NHANVIEN_ID`) REFERENCES `nhanvien` (`NHANVIEN_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoadon`
--

LOCK TABLES `hoadon` WRITE;
/*!40000 ALTER TABLE `hoadon` DISABLE KEYS */;
INSERT INTO `hoadon` VALUES (13,'HD001','2019-04-04',_binary '',NULL,1,1,1),(14,'HD002','2019-04-04',_binary '',NULL,1,2,1),(18,'HD0018','2019-08-26',_binary '',NULL,1,3,1),(19,'HD0019','2019-08-26',_binary '',NULL,1,1,1),(20,'HD0020','2019-09-04',_binary '',NULL,1,3,1),(21,'HD0021','2019-09-04',_binary '',NULL,1,3,1),(22,'HD0022','2019-09-04',_binary '',NULL,1,2,1),(23,'HD0023','2019-09-04',_binary '',NULL,1,5,1),(24,'HD0024','2019-09-04',_binary '',NULL,1,7,1),(25,'HD0025','2019-09-04',_binary '',NULL,1,2,1),(26,'HD0026','2019-09-04',_binary '',NULL,1,9,1),(27,'HD0027','2019-09-04',_binary '',NULL,1,7,1),(28,'HD0028','2019-09-05',_binary '',NULL,1,3,1),(29,'HD0029','2019-09-05',_binary '',NULL,1,8,1),(31,'HD0030','2019-09-05',_binary '',NULL,1,3,1),(32,'HD0032','2019-09-05',_binary '',NULL,1,5,1),(33,'HD0033','2019-09-05',_binary '',NULL,1,1,1),(34,'HD0034','2019-09-05',_binary '',NULL,1,3,1),(35,'HD0035','2019-09-05',_binary '',NULL,1,5,1),(47,'HD0036','2019-09-06',_binary '',NULL,1,1,1),(50,'HD0050','2019-09-06',_binary '',NULL,1,3,1),(53,'HD0051','2019-09-07',_binary '',NULL,1,3,1),(55,'HD0054','2019-09-07',_binary '',NULL,1,3,1),(56,'HD0056','2019-09-07',_binary '',NULL,1,6,1),(57,'HD0057','2019-09-07',_binary '',NULL,1,4,1),(58,'HD0058','2019-09-07',_binary '',NULL,1,3,1),(60,'HD0059','2019-09-07',_binary '',NULL,1,5,1),(61,'HD0061','2019-09-07',_binary '',NULL,1,3,1),(62,'HD0062','2019-09-07',_binary '',NULL,1,7,1),(63,'HD0063','2019-09-07',_binary '',NULL,1,3,1),(64,'HD0064','2019-09-07',_binary '',NULL,1,3,1),(65,'HD0065','2019-09-07',_binary '',NULL,1,5,1);
/*!40000 ALTER TABLE `hoadon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hoadonchitiet`
--

DROP TABLE IF EXISTS `hoadonchitiet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hoadonchitiet` (
  `HOADON_HOADON_ID` int(11) NOT NULL,
  `MONAN_MONAN_ID` int(11) NOT NULL,
  `HOADONCHITIET_PRICE` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `HOADONCHITIET_SOLUONG` int(11) DEFAULT NULL,
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
INSERT INTO `hoadonchitiet` VALUES (13,1,'50000',2),(13,2,'50000',1),(13,3,'35000',2),(14,7,'30000',1),(14,8,'40000',1),(14,9,'35000',1),(18,1,'50000',1),(18,2,'50000',1),(18,3,'35000',1),(19,1,'50000',1),(19,13,'17000',1),(19,14,'5000',1),(20,1,'50000',3),(20,8,'40000',1),(21,2,'50000',1),(21,3,'35000',2),(21,4,'40000',3),(22,1,'50000',1),(23,1,'50000',2),(23,2,'50000',1),(23,3,'35000',2),(24,1,'50000',1),(24,2,'50000',1),(24,3,'35000',1),(24,7,'30000',1),(24,8,'40000',1),(25,1,'50000',1),(25,2,'50000',1),(25,3,'35000',1),(25,4,'40000',1),(25,8,'40000',1),(26,1,'50000',2),(26,2,'50000',2),(27,2,'50000',1),(27,3,'35000',1),(27,4,'40000',2),(28,1,'50000',1),(29,4,'40000',32),(29,7,'30000',10),(29,8,'40000',1),(31,1,'50000',3),(31,2,'50000',2),(32,4,'40000',1),(32,7,'30000',1),(32,8,'40000',1),(32,12,'18000',1),(32,13,'17000',3),(33,1,'50000',1),(33,2,'50000',1),(33,3,'35000',1),(34,1,'50000',5),(34,2,'50000',1),(34,3,'35000',1),(34,4,'40000',1),(35,5,'25000',1),(35,6,'20000',1),(35,8,'40000',1),(47,1,'50000',2),(47,2,'50000',2),(47,3,'35000',3),(50,3,'35000',2),(50,5,'25000',2),(50,6,'20000',3),(53,1,'50000',1),(53,2,'50000',1),(53,3,'35000',1),(55,1,'50000',1),(55,2,'50000',2),(55,3,'35000',3),(56,12,'18000',2),(56,13,'17000',1),(56,14,'5000',2),(57,5,'25000',1),(57,6,'20000',1),(57,7,'30000',1),(58,1,'50000',3),(58,2,'50000',3),(58,3,'35000',1),(58,5,'25000',2),(60,8,'40000',1),(61,1,'50000',1),(61,2,'50000',2),(61,3,'35000',2),(61,4,'40000',1),(61,5,'25000',1),(62,11,'15000',1),(62,12,'18000',1),(62,13,'17000',2),(62,14,'5000',2),(63,1,'50000',1),(63,2,'50000',1),(63,3,'35000',2),(63,4,'40000',3),(63,5,'25000',1),(64,1,'50000',1),(64,2,'50000',2),(64,3,'35000',2),(65,11,'15000',1),(65,13,'17000',1),(65,14,'5000',2);
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
  `KHACHHANG_NO` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `KHACHHANG_NAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `KHACHHANG_ADD` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `KHACHHANG_PHONE` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `KHACHHANG_EMAIL` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `KHACHHANG_IMG` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`KHACHHANG_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khachhang`
--

LOCK TABLES `khachhang` WRITE;
/*!40000 ALTER TABLE `khachhang` DISABLE KEYS */;
INSERT INTO `khachhang` VALUES (1,NULL,'Khách lẻ',NULL,NULL,NULL,NULL);
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
  `LOAIMONAN_DES` longtext CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  PRIMARY KEY (`LOAIMONAN_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loaimonan`
--

LOCK TABLES `loaimonan` WRITE;
/*!40000 ALTER TABLE `loaimonan` DISABLE KEYS */;
INSERT INTO `loaimonan` VALUES (1,'Món chiên',NULL),(2,'Cơm',NULL),(3,'Món xào',NULL),(4,'Món mặn',NULL),(5,'Món nướng',NULL),(6,'Món tráng miệng',NULL),(7,'Nước',NULL),(8,'Sinh tố',NULL),(9,'Món lẩu',NULL),(10,'Món chay',NULL),(12,'Món Hồng Kong',NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loainguyenlieu`
--

LOCK TABLES `loainguyenlieu` WRITE;
/*!40000 ALTER TABLE `loainguyenlieu` DISABLE KEYS */;
INSERT INTO `loainguyenlieu` VALUES (1,'Thịt','Kg'),(2,'Rau, củ, quả','Kg'),(3,'Sữa','Ml'),(4,'Cá','Kg'),(5,'Trứng','Hộp'),(6,'Nước','Lít');
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
  `MONAN_NO` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `MONAN_NAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `MONAN_PRICE` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `MONAN_UNIT` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `MONAN_STATUS` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `MONAN_IMG` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `LOAIMONAN_LOAIMONAN_ID` int(11) NOT NULL,
  PRIMARY KEY (`MONAN_ID`),
  KEY `fk_MONAN_LOAIMONAN1_idx` (`LOAIMONAN_LOAIMONAN_ID`),
  CONSTRAINT `fk_MONAN_LOAIMONAN1` FOREIGN KEY (`LOAIMONAN_LOAIMONAN_ID`) REFERENCES `loaimonan` (`LOAIMONAN_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `monan`
--

LOCK TABLES `monan` WRITE;
/*!40000 ALTER TABLE `monan` DISABLE KEYS */;
INSERT INTO `monan` VALUES (1,'1bllvktc','Bò lúc lắc với khoai tây chiên','50000','Dĩa','Còn','Bò_lúc_lắc_với_khoai_tây_chiên.jpg',1),(2,'1dhcnm','Đùi heo chiên nước mắm','50000','Dĩa','Còn','Đùi_heo_chiên_nước_mắm.jpg',1),(3,'2ccdc','Cơm chiên dương châu','35000','Dĩa','Còn','Cơm_chiên_dương_châu.jpg',2),(4,'2cchs','Cơm chiên hải sản','40000','Dĩa','Còn','Cơm_chiên_hải_sản.jpg',2),(5,'3rdxt','Rau dền xào tỏi','25000','Dĩa','Không','Rau_dền_xào_tỏi.JPG',3),(6,'3rcvxt','Rau chân vịt xào trứng','20000','Dĩa','Còn','Rau_chân_vịt_xào_trứng.webp',3),(7,'4thq','Thịt heo quay','30000','Dĩa','Còn','Thịt_heo_quay.jpg',4),(8,'4ctkd','Cà tím kho đậu','40000','Dĩa','Còn','Cà_tím_kho_đậu.jpg',4),(9,'5bnxq','Món nướng bò rau xiên que','35000','Dĩa','Còn','Món_nướng_bò_rau_xiên_que.jpg',5),(10,'5ctlns','Cá thác lác nướng sả','35.000','Dĩa','Còn','Cá_thác_lác_nướng_sả.jpg',5),(11,'6rc','Rau câu','15000','Ly','Còn','Rau_câu.jpg',6),(12,'6tctc','Trái cây thập cẩm','18000','Dĩa','Còn','Trái_cây_thập_cẩm.jfif',6),(13,'7cpsd','Cà phê sữa đá','17000','Ly','Còn','Coffee_sữa_đá.jpg',7),(14,'7ns','Nước suối','5000','Chai','Còn','Nước_suối.png',7);
/*!40000 ALTER TABLE `monan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `monanchitiet`
--

DROP TABLE IF EXISTS `monanchitiet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `monanchitiet` (
  `MONAN_MONAN_ID` int(11) NOT NULL,
  `NGUYENLIEU_NGUYENLIEU_ID` int(11) NOT NULL,
  `MONANCHITIET_SOLUONG` float DEFAULT NULL,
  PRIMARY KEY (`MONAN_MONAN_ID`,`NGUYENLIEU_NGUYENLIEU_ID`),
  KEY `fk_MONANCHITIET_NGUYENLIEU1_idx` (`NGUYENLIEU_NGUYENLIEU_ID`),
  CONSTRAINT `FKhdfdfysax86ngb5rw77l59xuq` FOREIGN KEY (`NGUYENLIEU_NGUYENLIEU_ID`) REFERENCES `nguyenlieu` (`NGUYENLIEU_ID`),
  CONSTRAINT `FKlqfxhauugrhfcvxqyt6rb4nfv` FOREIGN KEY (`MONAN_MONAN_ID`) REFERENCES `monan` (`MONAN_ID`),
  CONSTRAINT `fk_MONANCHITIET_MONAN1` FOREIGN KEY (`MONAN_MONAN_ID`) REFERENCES `monan` (`MONAN_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_MONANCHITIET_NGUYENLIEU1` FOREIGN KEY (`NGUYENLIEU_NGUYENLIEU_ID`) REFERENCES `nguyenlieu` (`NGUYENLIEU_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `monanchitiet`
--

LOCK TABLES `monanchitiet` WRITE;
/*!40000 ALTER TABLE `monanchitiet` DISABLE KEYS */;
INSERT INTO `monanchitiet` VALUES (1,1,2),(1,2,1),(1,3,1),(2,2,1),(2,3,0.2),(3,16,0.2);
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
  `NGUYENLIEU_NO` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `NGUYENLIEU_NAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `NGUYENLIEU_PRICE` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `NGUYENLIEU_DATE` date DEFAULT NULL,
  `NGUYENLIEU_IMG` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `LOAINGUYENLIEU_LOAINGUYENLIEU_ID` int(11) DEFAULT NULL,
  `tenloai_nguyenlieu` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`NGUYENLIEU_ID`),
  UNIQUE KEY `NGUYENLIEU_NO_UNIQUE` (`NGUYENLIEU_NO`),
  UNIQUE KEY `UK_md2a2uwajnlju03kcjrn474hx` (`NGUYENLIEU_NAME`),
  KEY `fk_NGUYENLIEU_LOAINGUYENLIEU1_idx` (`LOAINGUYENLIEU_LOAINGUYENLIEU_ID`),
  CONSTRAINT `fk_NGUYENLIEU_LOAINGUYENLIEU1` FOREIGN KEY (`LOAINGUYENLIEU_LOAINGUYENLIEU_ID`) REFERENCES `loainguyenlieu` (`LOAINGUYENLIEU_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nguyenlieu`
--

LOCK TABLES `nguyenlieu` WRITE;
/*!40000 ALTER TABLE `nguyenlieu` DISABLE KEYS */;
INSERT INTO `nguyenlieu` VALUES (1,'1tb','Thịt bò','280.000','2019-10-10','Beef.jpg',1,NULL),(2,'1thd','Thịt heo đùi','80.000','2019-10-10','Pork.jpg',1,NULL),(3,'2rd','Rau dền','10.000','2019-10-10','Rau_den.png',2,NULL),(4,'2rcv','Rau chân vịt','9.000','2019-10-10','Rau_chan_vit.jpg',2,NULL),(6,'2kt','Khoai tây','22.000','2019-10-10','Potato.jpg',2,NULL),(7,'3stvm','Sữa Tươi Vinamilk 100% Có Đường - Hộp 900ml','34.000','2019-10-10','milk.jpg',3,NULL),(8,'4ct','Cá thu','250.000','2019-10-10','Mackerel.jpg',4,NULL),(9,'4ctl','Cá thác lác','220.000','2019-10-10','Cá_thác_lác.jpg',4,NULL),(15,'5tv','Trứng vịt','30000','2019-10-10','Duck\'s_egg.jpg',5,NULL),(16,'5tg','Trứng gà tươi','30000','2019-10-10','Eggs.jpg',5,NULL),(18,'5tc','Trứng cút','28.500','2019-10-10','Trứng_cút.jpg',5,NULL),(25,'5tn','Trứng ngỗng','30000','2019-12-17','Pork.jpg',5,NULL),(26,'5tdd','Trứng đà điễu','32000','2019-12-17','Mackerel.jpg',5,NULL),(28,'rx','Rau xanh sạch','250000','2019-10-05','Rau_den.png',2,NULL);
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
  `NHANVIEN_NO` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `NHANVIEN_NAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `NHANVIEN_PHONE` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `NHANVIEN_EMAIL` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `NHANVIEN_PASSWORD` varchar(150) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `NHANVIEN_LOAI` smallint(3) DEFAULT NULL,
  `NHANVIEN_IMG` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `CHUCVU_CHUCVU_ID` int(11) NOT NULL,
  PRIMARY KEY (`NHANVIEN_ID`),
  KEY `fk_NHANVIEN_CHUCVU_idx` (`CHUCVU_CHUCVU_ID`),
  CONSTRAINT `fk_NHANVIEN_CHUCVU` FOREIGN KEY (`CHUCVU_CHUCVU_ID`) REFERENCES `chucvu` (`CHUCVU_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhanvien`
--

LOCK TABLES `nhanvien` WRITE;
/*!40000 ALTER TABLE `nhanvien` DISABLE KEYS */;
INSERT INTO `nhanvien` VALUES (1,'001','VIETDEPTRAI','0904716299','nguyenthanhviet31031998@gmail.com','$2a$10$0aJcB6Vv7VQMqrC3Vn79u.5dmhLj5lmQRe6hCXjkc3RhXnqqMa2MG',2,NULL,2),(2,'002','HIEP','1234567890','nguyenvanhiep1998@gmail.com','$2a$10$0aJcB6Vv7VQMqrC3Vn79u.5dmhLj5lmQRe6hCXjkc3RhXnqqMa2MG',1,NULL,1),(3,'003','TAM','0987654321','dominhtam1998@gmail.com','$2a$10$0aJcB6Vv7VQMqrC3Vn79u.5dmhLj5lmQRe6hCXjkc3RhXnqqMa2MG',2,NULL,2),(4,'004','DANH','0908771234','buingocdanh123@gmail.com','$2a$10$0aJcB6Vv7VQMqrC3Vn79u.5dmhLj5lmQRe6hCXjkc3RhXnqqMa2MG',1,NULL,3),(5,'005','KHANG','1239874561','dinhkhang1998@gmail.com','$2a$10$0aJcB6Vv7VQMqrC3Vn79u.5dmhLj5lmQRe6hCXjkc3RhXnqqMa2MG',1,NULL,1),(8,'006','ADMIN',NULL,'admin@gmail.com','$2a$10$0aJcB6Vv7VQMqrC3Vn79u.5dmhLj5lmQRe6hCXjkc3RhXnqqMa2MG',1,NULL,1);
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

-- Dump completed on 2019-09-07 21:16:38
