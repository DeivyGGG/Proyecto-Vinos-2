-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.10.1-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para vinos_base
CREATE DATABASE IF NOT EXISTS `vinos_base` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `vinos_base`;

-- Volcando estructura para tabla vinos_base.compra
CREATE TABLE IF NOT EXISTS `compra` (
  `id` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `fecha` datetime NOT NULL,
  PRIMARY KEY (`id`,`username`,`fecha`) USING BTREE,
  KEY `FK__usuarios` (`username`),
  CONSTRAINT `FK__usuarios` FOREIGN KEY (`username`) REFERENCES `usuarios` (`username`),
  CONSTRAINT `FK__vino` FOREIGN KEY (`id`) REFERENCES `vino` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla vinos_base.compra: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `compra` DISABLE KEYS */;
/*!40000 ALTER TABLE `compra` ENABLE KEYS */;

-- Volcando estructura para tabla vinos_base.usuarios
CREATE TABLE IF NOT EXISTS `usuarios` (
  `username` varchar(100) NOT NULL,
  `contrasena` varchar(100) DEFAULT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `apellidos` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `saldo` double(22,2) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla vinos_base.usuarios: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` (`username`, `contrasena`, `nombre`, `apellidos`, `email`, `saldo`) VALUES
	('goku', '1234', 'kakaroto', 'raditz', 'gokulol@gmail.com', 1000.00);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;

-- Volcando estructura para tabla vinos_base.vino
CREATE TABLE IF NOT EXISTS `vino` (
  `id` int(11) NOT NULL,
  `nombre_vino` varchar(100) DEFAULT NULL,
  `anos_anejado` int(11) DEFAULT NULL,
  `pais_procedencia` varchar(100) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `novedad` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla vinos_base.vino: ~10 rows (aproximadamente)
/*!40000 ALTER TABLE `vino` DISABLE KEYS */;
INSERT INTO `vino` (`id`, `nombre_vino`, `anos_anejado`, `pais_procedencia`, `cantidad`, `novedad`) VALUES
	(1, 'Aubert Pinot Noir Sonoma Coast', 0, 'Guillermo del Toro', 5, 0),
	(2, 'Aubert Pinot Noir Sonoma Coast', 0, 'Guillermo del Toro', 6, 1),
	(3, 'Aubert Pinot Noir Sonoma Coast', 0, 'Guillermo del Toro', 7, 0),
	(4, 'El orfanato', 0, 'Juan Antonio Bayona', 2, 0),
	(5, 'El Hobbit: Un viaje inesperado', 0, 'Peter Jackson', 10, 1),
	(6, 'Splice: experimento mortal', 0, 'Vincenzo Natali', 6, 0),
	(7, 'Depredador: La presa', 0, 'Dan Trachtenberg', 10, 0),
	(8, 'Candyman: El Dominio de la Mente', 0, 'Bernard Rose', 4, 0),
	(9, 'Candyman: Farewell to the Flesh', 0, 'Bill Condon', 8, 1),
	(10, 'Hellraiser III: Hell on Earth', 0, 'Anthony Hickox', 4, 0);
/*!40000 ALTER TABLE `vino` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
