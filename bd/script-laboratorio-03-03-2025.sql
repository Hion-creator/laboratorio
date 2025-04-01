-- MySQL Script generated by MySQL Workbench
-- Tue Mar  4 01:52:54 2025
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema laboratorio
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema laboratorio
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `laboratorio` DEFAULT CHARACTER SET utf8 ;
USE `laboratorio` ;

-- -----------------------------------------------------
-- Table `laboratorio`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `laboratorio`.`usuario` (
  `id_usuario` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `apellido` VARCHAR(45) NULL,
  `usuario` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  PRIMARY KEY (`id_usuario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `laboratorio`.`solicitud_produccion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `laboratorio`.`solicitud_produccion` (
  `id_solicitud_produccion` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(45) NULL,
  `observacion` VARCHAR(100) NULL,
  `fecha_solicitud` DATETIME NOT NULL,
  `fecha_actualizacion` DATETIME NOT NULL,
  `estado` VARCHAR(12) NOT NULL,
  `id_usuario` INT NOT NULL,
  PRIMARY KEY (`id_solicitud_produccion`),
  INDEX `fk_solicitud_produccion_usuario1_idx` (`id_usuario` ASC) VISIBLE,
  CONSTRAINT `fk_solicitud_produccion_usuario1`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `laboratorio`.`usuario` (`id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `laboratorio`.`producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `laboratorio`.`producto` (
  `id_producto` INT NOT NULL,
  `descripcion` VARCHAR(45) NOT NULL,
  `observacion` VARCHAR(100) NULL,
  `estado` VARCHAR(12) NOT NULL,
  `tipo` VARCHAR(12) NULL,
  PRIMARY KEY (`id_producto`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `laboratorio`.`detalle_solicitud`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `laboratorio`.`detalle_solicitud` (
  `id_producto` INT NOT NULL,
  `id_solicitud_produccion` INT NOT NULL,
  `cantidad` INT NOT NULL,
  `estado` VARCHAR(12) NOT NULL,
  PRIMARY KEY (`id_producto`, `id_solicitud_produccion`),
  INDEX `fk_producto_has_solicitud_produccion_solicitud_produccion1_idx` (`id_solicitud_produccion` ASC) VISIBLE,
  INDEX `fk_producto_has_solicitud_produccion_producto_idx` (`id_producto` ASC) VISIBLE,
  CONSTRAINT `fk_producto_has_solicitud_produccion_producto`
    FOREIGN KEY (`id_producto`)
    REFERENCES `laboratorio`.`producto` (`id_producto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_producto_has_solicitud_produccion_solicitud_produccion1`
    FOREIGN KEY (`id_solicitud_produccion`)
    REFERENCES `laboratorio`.`solicitud_produccion` (`id_solicitud_produccion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `laboratorio`.`inventario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `laboratorio`.`inventario` (
  `id_inventario_produccion` INT NOT NULL AUTO_INCREMENT,
  `cantidad` INT NOT NULL,
  `estado` VARCHAR(12) NOT NULL,
  `id_producto` INT NOT NULL,
  PRIMARY KEY (`id_inventario_produccion`),
  INDEX `fk_inventario_produccion_producto1_idx` (`id_producto` ASC) VISIBLE,
  CONSTRAINT `fk_inventario_produccion_producto1`
    FOREIGN KEY (`id_producto`)
    REFERENCES `laboratorio`.`producto` (`id_producto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `laboratorio`.`certificacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `laboratorio`.`certificacion` (
  `id_certificacion` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(45) NULL,
  `observacion` VARCHAR(100) NULL,
  `estado` VARCHAR(12) NOT NULL,
  PRIMARY KEY (`id_certificacion`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `laboratorio`.`certificacion_solicitud`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `laboratorio`.`certificacion_solicitud` (
  `id_producto` INT NOT NULL,
  `id_solicitud_produccion` INT NOT NULL,
  `id_certificacion` INT NOT NULL,
  `cantidad_certificada` INT NOT NULL,
  `estado` VARCHAR(12) NOT NULL,
  PRIMARY KEY (`id_producto`, `id_solicitud_produccion`, `id_certificacion`),
  INDEX `fk_detalle_solicitud_has_certificacion_certificacion1_idx` (`id_certificacion` ASC) VISIBLE,
  INDEX `fk_detalle_solicitud_has_certificacion_detalle_solicitud1_idx` (`id_producto` ASC, `id_solicitud_produccion` ASC) VISIBLE,
  CONSTRAINT `fk_detalle_solicitud_has_certificacion_detalle_solicitud1`
    FOREIGN KEY (`id_producto` , `id_solicitud_produccion`)
    REFERENCES `laboratorio`.`detalle_solicitud` (`id_producto` , `id_solicitud_produccion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_detalle_solicitud_has_certificacion_certificacion1`
    FOREIGN KEY (`id_certificacion`)
    REFERENCES `laboratorio`.`certificacion` (`id_certificacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `laboratorio`.`table1`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `laboratorio`.`table1` (
)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
