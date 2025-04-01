-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: localhost    Database: laboratorio
-- ------------------------------------------------------
-- Server version	8.0.41

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
-- Table structure for table `certificacion`
--

DROP TABLE IF EXISTS `certificacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `certificacion` (
  `id_certificacion` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  `observacion` varchar(100) DEFAULT NULL,
  `estado` varchar(12) NOT NULL,
  PRIMARY KEY (`id_certificacion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `certificacion`
--

LOCK TABLES `certificacion` WRITE;
/*!40000 ALTER TABLE `certificacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `certificacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `certificacion_solicitud`
--

DROP TABLE IF EXISTS `certificacion_solicitud`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `certificacion_solicitud` (
  `id_producto` int NOT NULL,
  `id_solicitud_produccion` int NOT NULL,
  `id_certificacion` int NOT NULL,
  `cantidad_certificada` int NOT NULL,
  `estado` varchar(12) NOT NULL,
  PRIMARY KEY (`id_producto`,`id_solicitud_produccion`,`id_certificacion`),
  KEY `fk_detalle_solicitud_has_certificacion_certificacion1_idx` (`id_certificacion`),
  KEY `fk_detalle_solicitud_has_certificacion_detalle_solicitud1_idx` (`id_producto`,`id_solicitud_produccion`),
  CONSTRAINT `fk_detalle_solicitud_has_certificacion_certificacion1` FOREIGN KEY (`id_certificacion`) REFERENCES `certificacion` (`id_certificacion`),
  CONSTRAINT `fk_detalle_solicitud_has_certificacion_detalle_solicitud1` FOREIGN KEY (`id_producto`, `id_solicitud_produccion`) REFERENCES `detalle_solicitud` (`id_producto`, `id_solicitud_produccion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `certificacion_solicitud`
--

LOCK TABLES `certificacion_solicitud` WRITE;
/*!40000 ALTER TABLE `certificacion_solicitud` DISABLE KEYS */;
/*!40000 ALTER TABLE `certificacion_solicitud` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_solicitud`
--

DROP TABLE IF EXISTS `detalle_solicitud`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalle_solicitud` (
  `id_producto` int NOT NULL,
  `id_solicitud_produccion` int NOT NULL,
  `cantidad` int NOT NULL,
  `estado` varchar(12) NOT NULL,
  PRIMARY KEY (`id_producto`,`id_solicitud_produccion`),
  KEY `fk_producto_has_solicitud_produccion_solicitud_produccion1_idx` (`id_solicitud_produccion`),
  KEY `fk_producto_has_solicitud_produccion_producto_idx` (`id_producto`),
  CONSTRAINT `fk_producto_has_solicitud_produccion_producto` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id_producto`),
  CONSTRAINT `fk_producto_has_solicitud_produccion_solicitud_produccion1` FOREIGN KEY (`id_solicitud_produccion`) REFERENCES `solicitud_produccion` (`id_solicitud_produccion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_solicitud`
--

LOCK TABLES `detalle_solicitud` WRITE;
/*!40000 ALTER TABLE `detalle_solicitud` DISABLE KEYS */;
INSERT INTO `detalle_solicitud` VALUES (1,1,55,'Inicial');
/*!40000 ALTER TABLE `detalle_solicitud` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventario`
--

DROP TABLE IF EXISTS `inventario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inventario` (
  `id_inventario_produccion` int NOT NULL AUTO_INCREMENT,
  `cantidad` int NOT NULL,
  `estado` varchar(12) NOT NULL,
  `id_producto` int NOT NULL,
  PRIMARY KEY (`id_inventario_produccion`),
  KEY `fk_inventario_produccion_producto1_idx` (`id_producto`),
  CONSTRAINT `fk_inventario_produccion_producto1` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id_producto`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventario`
--

LOCK TABLES `inventario` WRITE;
/*!40000 ALTER TABLE `inventario` DISABLE KEYS */;
INSERT INTO `inventario` VALUES (1,20,'activo',1);
/*!40000 ALTER TABLE `inventario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto` (
  `id_producto` int NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  `observacion` varchar(100) DEFAULT NULL,
  `estado` varchar(12) NOT NULL,
  `tipo` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`id_producto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (1,'hoja','hoja data','activo','producto');
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `solicitud_produccion`
--

DROP TABLE IF EXISTS `solicitud_produccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `solicitud_produccion` (
  `id_solicitud_produccion` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  `observacion` varchar(100) DEFAULT NULL,
  `fecha_solicitud` datetime NOT NULL,
  `fecha_actualizacion` datetime NOT NULL,
  `estado` varchar(12) NOT NULL,
  `id_usuario` int NOT NULL,
  PRIMARY KEY (`id_solicitud_produccion`),
  KEY `fk_solicitud_produccion_usuario1_idx` (`id_usuario`),
  CONSTRAINT `fk_solicitud_produccion_usuario1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `solicitud_produccion`
--

LOCK TABLES `solicitud_produccion` WRITE;
/*!40000 ALTER TABLE `solicitud_produccion` DISABLE KEYS */;
INSERT INTO `solicitud_produccion` VALUES (1,'esta es una prueba','con observacion','2025-03-04 02:26:10','2025-03-04 02:26:10','Inicial',1151937845);
/*!40000 ALTER TABLE `solicitud_produccion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id_usuario` int NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `usuario` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1151937845,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-03-04  2:28:10
