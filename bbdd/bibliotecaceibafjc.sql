-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 25-01-2020 a las 21:53:20
-- Versión del servidor: 10.1.36-MariaDB
-- Versión de PHP: 7.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bibliotecaceibafjc`
--
CREATE DATABASE IF NOT EXISTS `bibliotecaceibafjc` DEFAULT CHARACTER SET utf16 COLLATE utf16_bin;
USE `bibliotecaceibafjc`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libro`
--

DROP TABLE IF EXISTS `libro`;
CREATE TABLE `libro` (
  `id` int(10) NOT NULL,
  `isbn` varchar(30) COLLATE utf16_bin NOT NULL,
  `nombre` varchar(30) COLLATE utf16_bin NOT NULL,
  `estado` varchar(20) COLLATE utf16_bin NOT NULL,
  `ejemplar` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf16 COLLATE=utf16_bin;

--
-- Volcado de datos para la tabla `libro`
--

INSERT INTO `libro` (`id`, `isbn`, `nombre`, `estado`, `ejemplar`) VALUES
(2001, 'AAAAA11111', 'La Iliada', 'disponible', 1),
(2002, 'AAAAA22222', 'Don Quijote', 'disponible', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `opcion`
--

DROP TABLE IF EXISTS `opcion`;
CREATE TABLE `opcion` (
  `id` int(10) NOT NULL,
  `nombre` varchar(30) COLLATE utf16_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf16 COLLATE=utf16_bin;

--
-- Volcado de datos para la tabla `opcion`
--

INSERT INTO `opcion` (`id`, `nombre`) VALUES
(3001, 'crearLibro'),
(3002, 'modificarLibro'),
(3003, 'consultarLibro'),
(3004, 'eliminarLibro'),
(3005, 'prestarLibro'),
(3006, 'devolverLibro'),
(3007, 'crearUsuario'),
(3008, 'consultarUsuario'),
(3009, 'modificarLibro'),
(3010, 'eliminarLibro');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `perfil`
--

DROP TABLE IF EXISTS `perfil`;
CREATE TABLE `perfil` (
  `id` int(1) NOT NULL,
  `nombre` varchar(30) COLLATE utf16_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf16 COLLATE=utf16_bin;

--
-- Volcado de datos para la tabla `perfil`
--

INSERT INTO `perfil` (`id`, `nombre`) VALUES
(1, 'bibliotecario'),
(2, 'lector');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `permisos`
--

DROP TABLE IF EXISTS `permisos`;
CREATE TABLE `permisos` (
  `id` int(10) NOT NULL,
  `idPerfil` int(1) NOT NULL,
  `idOpcion` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf16 COLLATE=utf16_bin;

--
-- Volcado de datos para la tabla `permisos`
--

INSERT INTO `permisos` (`id`, `idPerfil`, `idOpcion`) VALUES
(401, 1, 3001),
(402, 1, 3002),
(403, 1, 3003),
(404, 1, 3004),
(405, 1, 3005),
(406, 1, 3006),
(407, 1, 3007),
(408, 1, 3008),
(409, 1, 3009),
(410, 1, 3010),
(411, 2, 3005),
(412, 2, 3006);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prestamo`
--

DROP TABLE IF EXISTS `prestamo`;
CREATE TABLE `prestamo` (
  `id` int(2) NOT NULL,
  `idUsuario` int(10) NOT NULL,
  `idLibro` int(10) NOT NULL,
  `fechaPrestamo` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `fechaEntrega` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf16 COLLATE=utf16_bin;

--
-- Volcado de datos para la tabla `prestamo`
--

INSERT INTO `prestamo` (`id`, `idUsuario`, `idLibro`, `fechaPrestamo`, `fechaEntrega`) VALUES
(5001, 1001, 2001, '2020-01-25 20:49:57', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE `usuarios` (
  `id` int(10) NOT NULL,
  `nombre` varchar(30) COLLATE utf16_bin NOT NULL,
  `pass` varchar(80) COLLATE utf16_bin NOT NULL,
  `idPerfil` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf16 COLLATE=utf16_bin;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `nombre`, `pass`, `idPerfil`) VALUES
(1001, 'Bibliotecario uno', '111', 1),
(2001, 'Lector Uno', '222', 2);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `libro`
--
ALTER TABLE `libro`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `opcion`
--
ALTER TABLE `opcion`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `perfil`
--
ALTER TABLE `perfil`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `permisos`
--
ALTER TABLE `permisos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_idPerfil` (`idPerfil`),
  ADD KEY `fk_idOpcion` (`idOpcion`);

--
-- Indices de la tabla `prestamo`
--
ALTER TABLE `prestamo`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_idUsuario` (`idUsuario`),
  ADD KEY `fk_idLibro` (`idLibro`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_idPerfil` (`idPerfil`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `permisos`
--
ALTER TABLE `permisos`
  ADD CONSTRAINT `fk_idOpcion` FOREIGN KEY (`idOpcion`) REFERENCES `opcion` (`id`);

--
-- Filtros para la tabla `prestamo`
--
ALTER TABLE `prestamo`
  ADD CONSTRAINT `fk_idLibro` FOREIGN KEY (`idLibro`) REFERENCES `libro` (`id`),
  ADD CONSTRAINT `fk_idUsuario` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`id`);

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `fk_idPerfil` FOREIGN KEY (`idPerfil`) REFERENCES `perfil` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
