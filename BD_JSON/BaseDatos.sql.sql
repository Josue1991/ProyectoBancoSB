-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: banco
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `ID_CLIENTE` int NOT NULL AUTO_INCREMENT,
  `ID_PERSONA` int DEFAULT NULL,
  `CONTRASENA_CLIENTE` varchar(100) DEFAULT NULL,
  `ESTADO_CLIENTE` int DEFAULT NULL,
  PRIMARY KEY (`ID_CLIENTE`),
  KEY `FK_RELATIONSHIP_3` (`ID_PERSONA`),
  CONSTRAINT `FK_RELATIONSHIP_3` FOREIGN KEY (`ID_PERSONA`) REFERENCES `persona` (`ID_PERSONA`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cuenta`
--

DROP TABLE IF EXISTS `cuenta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cuenta` (
  `ID_CUENTA` int NOT NULL AUTO_INCREMENT,
  `ID_CLIENTE` int DEFAULT NULL,
  `NUMERO_CUENTA` int DEFAULT NULL,
  `TIPO_CUENTA` int DEFAULT NULL,
  `SALDO_INICIAL_CUENTA` float(10,2) DEFAULT NULL,
  `ESTADO_CUENTA` int DEFAULT NULL,
  PRIMARY KEY (`ID_CUENTA`),
  KEY `FK_RELATIONSHIP_2` (`ID_CLIENTE`),
  CONSTRAINT `FK_RELATIONSHIP_2` FOREIGN KEY (`ID_CLIENTE`) REFERENCES `cliente` (`ID_CLIENTE`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `estado`
--

DROP TABLE IF EXISTS `estado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estado` (
  `ID_ESTADO` int NOT NULL AUTO_INCREMENT,
  `DESCRIPCION_ESTADO` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID_ESTADO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `movimiento`
--

DROP TABLE IF EXISTS `movimiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movimiento` (
  `ID_MOVIMIENTO` int NOT NULL AUTO_INCREMENT,
  `ID_CUENTA` int DEFAULT NULL,
  `FECHA_MOVIMIENTO` datetime DEFAULT NULL,
  `TIPO_MOVIMIENTO` varchar(100) DEFAULT NULL,
  `SALDO_MOVIMIENTO` float(10,2) DEFAULT NULL,
  `ESTADO_MOVIMIENTO` int DEFAULT NULL,
  `DESCRIPCION_MOVIMIENTO` varchar(200) DEFAULT NULL,
  `SALDO_ACTUAL_MOVIMIENTO` float(10,2) DEFAULT NULL,
  PRIMARY KEY (`ID_MOVIMIENTO`),
  KEY `FK_REFERENCE_3` (`ID_CUENTA`),
  CONSTRAINT `FK_REFERENCE_3` FOREIGN KEY (`ID_CUENTA`) REFERENCES `cuenta` (`ID_CUENTA`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `persona` (
  `ID_PERSONA` int NOT NULL AUTO_INCREMENT,
  `NOMBRE_PERSONA` varchar(200) DEFAULT NULL,
  `EDAD_PERSONA` int DEFAULT NULL,
  `IDENTIFICACION_PERSONA` varchar(13) DEFAULT NULL,
  `DIRRECCION_PERSONA` varchar(200) DEFAULT NULL,
  `TELEFONO_PERSONA` varchar(13) DEFAULT NULL,
  `GENERO_PERSONA` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID_PERSONA`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tipocuenta`
--

DROP TABLE IF EXISTS `tipocuenta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipocuenta` (
  `ID_TIPOCUENTA` int NOT NULL AUTO_INCREMENT,
  `DESCRIPCION_TIPOCUENTA` varchar(100) DEFAULT NULL,
  `ESTADO_TIPOCUENTA` int DEFAULT NULL,
  PRIMARY KEY (`ID_TIPOCUENTA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-28  4:26:43
