-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema universidad
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema universidad
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `universidad` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `universidad` ;

-- -----------------------------------------------------
-- Table `universidad`.`paises`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `universidad`.`paises` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `universidad`.`provincias`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `universidad`.`provincias` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(50) NULL DEFAULT NULL,
  `idPais` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `idPais` (`idPais` ASC) VISIBLE,
  CONSTRAINT `provincias_ibfk_1`
    FOREIGN KEY (`idPais`)
    REFERENCES `universidad`.`paises` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `universidad`.`localidades`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `universidad`.`localidades` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(50) NULL DEFAULT NULL,
  `idProvincia` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `idProvincia` (`idProvincia` ASC) VISIBLE,
  CONSTRAINT `localidades_ibfk_1`
    FOREIGN KEY (`idProvincia`)
    REFERENCES `universidad`.`provincias` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `universidad`.`admins`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `universidad`.`admins` (
  `dni` INT NOT NULL,
  `nombre` VARCHAR(50) NOT NULL,
  `apellido` VARCHAR(50) NOT NULL,
  `fechaNacimiento` DATE NOT NULL,
  `idNacionalidad` INT NOT NULL,
  `domicilio` VARCHAR(250) NOT NULL,
  `idLocalidad` INT NOT NULL,
  `email` VARCHAR(250) NOT NULL,
  `telefono` INT NOT NULL,
  PRIMARY KEY (`dni`),
  INDEX `idNacionalidad` (`idNacionalidad` ASC) VISIBLE,
  INDEX `idLocalidad` (`idLocalidad` ASC) VISIBLE,
  CONSTRAINT `admins_ibfk_1`
    FOREIGN KEY (`idNacionalidad`)
    REFERENCES `universidad`.`paises` (`id`),
  CONSTRAINT `admins_ibfk_2`
    FOREIGN KEY (`idLocalidad`)
    REFERENCES `universidad`.`localidades` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `universidad`.`alumnos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `universidad`.`alumnos` (
  `dni` INT NOT NULL,
  `legajo` INT NOT NULL,
  `nombre` VARCHAR(50) NOT NULL,
  `apellido` VARCHAR(50) NOT NULL,
  `fechaNacimiento` DATE NOT NULL,
  `idNacionalidad` INT NOT NULL,
  `domicilio` VARCHAR(250) NOT NULL,
  `idLocalidad` INT NOT NULL,
  `email` VARCHAR(250) NOT NULL,
  `telefono` INT NOT NULL,
  `estado` TINYINT NOT NULL DEFAULT '1',
  PRIMARY KEY (`dni`),
  UNIQUE INDEX `legajo` (`legajo` ASC) VISIBLE,
  INDEX `idNacionalidad` (`idNacionalidad` ASC) VISIBLE,
  INDEX `idLocalidad` (`idLocalidad` ASC) VISIBLE,
  CONSTRAINT `alumnos_ibfk_1`
    FOREIGN KEY (`idNacionalidad`)
    REFERENCES `universidad`.`paises` (`id`),
  CONSTRAINT `alumnos_ibfk_2`
    FOREIGN KEY (`idLocalidad`)
    REFERENCES `universidad`.`localidades` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `universidad`.`materias`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `universidad`.`materias` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `universidad`.`docentes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `universidad`.`docentes` (
  `dni` INT NOT NULL,
  `legajo` INT NOT NULL,
  `nombre` VARCHAR(50) NOT NULL,
  `apellido` VARCHAR(50) NOT NULL,
  `fechaNacimiento` DATE NOT NULL,
  `idNacionalidad` INT NOT NULL,
  `domicilio` VARCHAR(250) NOT NULL,
  `idLocalidad` INT NOT NULL,
  `email` VARCHAR(250) NOT NULL,
  `telefono` INT NOT NULL,
  `estado` TINYINT NOT NULL DEFAULT '1',
  PRIMARY KEY (`dni`),
  UNIQUE INDEX `legajo` (`legajo` ASC) VISIBLE,
  INDEX `idNacionalidad` (`idNacionalidad` ASC) VISIBLE,
  INDEX `idLocalidad` (`idLocalidad` ASC) VISIBLE,
  CONSTRAINT `docentes_ibfk_1`
    FOREIGN KEY (`idNacionalidad`)
    REFERENCES `universidad`.`paises` (`id`),
  CONSTRAINT `docentes_ibfk_2`
    FOREIGN KEY (`idLocalidad`)
    REFERENCES `universidad`.`localidades` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `universidad`.`cursos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `universidad`.`cursos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `idMateria` INT NOT NULL,
  `dniDocente` INT NOT NULL,
  `semestre` INT NOT NULL,
  `anio` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `idMateria` (`idMateria` ASC) VISIBLE,
  INDEX `dniDocente` (`dniDocente` ASC) VISIBLE,
  CONSTRAINT `cursos_ibfk_1`
    FOREIGN KEY (`idMateria`)
    REFERENCES `universidad`.`materias` (`id`),
  CONSTRAINT `cursos_ibfk_2`
    FOREIGN KEY (`dniDocente`)
    REFERENCES `universidad`.`docentes` (`dni`))
ENGINE = InnoDB
AUTO_INCREMENT = 100
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `universidad`.`alumnosxcursos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `universidad`.`alumnosxcursos` (
  `dniAlumno` INT NOT NULL,
  `idCurso` INT NOT NULL,
  `parcial_1` DECIMAL(10,0) NULL DEFAULT NULL,
  `parcial_2` DECIMAL(10,0) NULL DEFAULT NULL,
  `recuperatorio_1` DECIMAL(10,0) NULL DEFAULT NULL,
  `recuperatorio_2` DECIMAL(10,0) NULL DEFAULT NULL,
  `estadoAprobacion` TINYINT NULL DEFAULT NULL,
  PRIMARY KEY (`dniAlumno`, `idCurso`),
  INDEX `idCurso` (`idCurso` ASC) VISIBLE,
  CONSTRAINT `alumnosxcursos_ibfk_1`
    FOREIGN KEY (`dniAlumno`)
    REFERENCES `universidad`.`alumnos` (`dni`),
  CONSTRAINT `alumnosxcursos_ibfk_2`
    FOREIGN KEY (`idCurso`)
    REFERENCES `universidad`.`cursos` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `universidad`.`carrera`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `universidad`.`carrera` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `universidad`.`materiasxcarrera`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `universidad`.`materiasxcarrera` (
  `idCarrera` INT NOT NULL,
  `idMateria` INT NOT NULL,
  PRIMARY KEY (`idCarrera`, `idMateria`),
  INDEX `idMateria` (`idMateria` ASC) VISIBLE,
  CONSTRAINT `materiasxcarrera_ibfk_1`
    FOREIGN KEY (`idCarrera`)
    REFERENCES `universidad`.`carrera` (`id`),
  CONSTRAINT `materiasxcarrera_ibfk_2`
    FOREIGN KEY (`idMateria`)
    REFERENCES `universidad`.`materias` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `universidad`.`tiposusuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `universidad`.`tiposusuario` (
  `idTipo` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`idTipo`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `universidad`.`usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `universidad`.`usuarios` (
  `dni` INT NOT NULL,
  `tipoUsuario` INT NOT NULL,
  `pass` VARCHAR(50) NOT NULL,
  `estado` TINYINT NULL DEFAULT '1',
  PRIMARY KEY (`dni`),
  INDEX `tipoUsuario` (`tipoUsuario` ASC) VISIBLE,
  INDEX `usuarios_ibfk_2_idx` (`dni` ASC) VISIBLE,
  CONSTRAINT `usuarios_ibfk_3`
    FOREIGN KEY (`tipoUsuario`)
    REFERENCES `universidad`.`tiposusuario` (`idTipo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

USE `universidad`;

DELIMITER $$
USE `universidad`$$
CREATE
DEFINER=`root`@`localhost`
TRIGGER `universidad`.`usuarios_BEFORE_INSERT`
BEFORE INSERT ON `universidad`.`usuarios`
FOR EACH ROW
BEGIN
	if (new.dni not in (select a.dni from admins a where (new.dni = a.dni)) && new.tipoUsuario = 1)
		then
			call `error en insert usuario - trigger - docente en admin`;
		if new.dni not in (select d.dni from docentes d where (new.dni = d.dni))
			then
			call `error en insert usuario - trigger - no admin, no docente`;
		end if;
    end if;
END$$


DELIMITER ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


