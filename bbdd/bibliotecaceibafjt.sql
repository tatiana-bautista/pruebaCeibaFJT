-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 26-01-2020 a las 02:28:09
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
-- Base de datos: `bibliotecaceibafjt`
--
CREATE DATABASE IF NOT EXISTS `bibliotecaceibafjt` DEFAULT CHARACTER SET utf16 COLLATE utf16_bin;
USE `bibliotecaceibafjt`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libro`
--

CREATE TABLE `libro` (
  `id` int(10) NOT NULL,
  `isbn` varchar(30) COLLATE utf16_bin NOT NULL,
  `nombre` varchar(30) COLLATE utf16_bin NOT NULL,
  `estado` varchar(20) COLLATE utf16_bin DEFAULT 'disponible',
  `ejemplar` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf16 COLLATE=utf16_bin;

--
-- Truncar tablas antes de insertar `libro`
--

TRUNCATE TABLE `libro`;
--
-- Volcado de datos para la tabla `libro`
--

INSERT INTO `libro` (`id`, `isbn`, `nombre`, `estado`, `ejemplar`) VALUES
(2001, '123A321', 'Clean Code-Robert Martin', 'disponible', 1),
(2002, '234A599', 'Dont Make Me Think-Steve Krug', 'disponible', 1),
(2003, '123A322', 'Soft Skills-John Sonmez', 'disponible', 1),
(2004, '123A322', 'Soft Skills-John Sonmez', 'disponible', 2),
(2005, '123A322', 'Soft Skills-John Sonmez', 'disponible', 3),
(2006, '123A322', 'Soft Skills-John Sonmez', 'disponible', 4),
(2007, '123A699', 'Programming Pearls-Joe Bentley', 'disponible', 1),
(2008, '12BCD21', 'Cracking the Coding Interview', 'disponible', 1),
(2009, '999B999', 'The Mythical Man-Month', 'disponible', 1),
(2010, '123A321', 'CODE The Hidden Language', 'disponible', 1),
(2011, '123A323', 'The Pragmatic Programmer', 'disponible', 1),
(2012, '123A323', 'The Pragmatic Programmer', 'disponible', 2),
(2013, '123A323', 'The Pragmatic Programmer', 'disponible', 3),
(2014, '123A323', 'The Pragmatic Programmer', 'disponible', 4),
(2015, '123A321', 'Working Effectively with LCode', 'disponible', 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `opcion`
--

CREATE TABLE `opcion` (
  `id` int(10) NOT NULL,
  `nombre` varchar(30) COLLATE utf16_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf16 COLLATE=utf16_bin;

--
-- Truncar tablas antes de insertar `opcion`
--

TRUNCATE TABLE `opcion`;
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

CREATE TABLE `perfil` (
  `id` int(1) NOT NULL,
  `nombre` varchar(30) COLLATE utf16_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf16 COLLATE=utf16_bin;

--
-- Truncar tablas antes de insertar `perfil`
--

TRUNCATE TABLE `perfil`;
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

CREATE TABLE `permisos` (
  `id` int(10) NOT NULL,
  `idPerfil` int(1) NOT NULL,
  `idOpcion` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf16 COLLATE=utf16_bin;

--
-- Truncar tablas antes de insertar `permisos`
--

TRUNCATE TABLE `permisos`;
--
-- Volcado de datos para la tabla `permisos`
--

INSERT INTO `permisos` (`id`, `idPerfil`, `idOpcion`) VALUES
(4001, 1, 3001),
(4002, 1, 3002),
(4003, 1, 3003),
(4004, 1, 3004),
(4005, 1, 3005),
(4006, 1, 3006),
(4007, 1, 3007),
(4008, 1, 3008),
(4009, 1, 3009),
(4010, 1, 3010),
(4011, 2, 3005),
(4012, 2, 3006);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prestamo`
--

CREATE TABLE `prestamo` (
  `id` int(2) NOT NULL,
  `idUsuario` int(10) NOT NULL,
  `idLibro` int(10) NOT NULL,
  `fechaPrestamo` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `fechaEntregaMaxima` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf16 COLLATE=utf16_bin;

--
-- Truncar tablas antes de insertar `prestamo`
--

TRUNCATE TABLE `prestamo`;
--
-- Volcado de datos para la tabla `prestamo`
--

INSERT INTO `prestamo` (`id`, `idUsuario`, `idLibro`, `fechaPrestamo`, `fechaEntregaMaxima`) VALUES
(5001, 1002, 2003, '2020-01-26 01:10:33', NULL),
(5002, 1002, 2008, '2020-01-26 01:12:07', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(10) NOT NULL,
  `nombre` varchar(30) COLLATE utf16_bin NOT NULL,
  `pass` varchar(80) COLLATE utf16_bin NOT NULL,
  `idPerfil` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf16 COLLATE=utf16_bin;

--
-- Truncar tablas antes de insertar `usuarios`
--

TRUNCATE TABLE `usuarios`;
--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `nombre`, `pass`, `idPerfil`) VALUES
(1001, 'Bibliotecario uno', '111', 1),
(1002, 'Lector Dos', '222', 2),
(1003, 'Lector Tres', '333', 2),
(1004, 'Lector Cuatro', '444', 2),
(1005, 'Lector Cinco', '555', 2),
(1006, 'Bibliotecario Seis', '666', 1);

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
  ADD KEY `fk_idOpcion` (`idOpcion`),
  ADD KEY `fk_idPerfilPres` (`idPerfil`);

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
  ADD CONSTRAINT `fk_idOpcion` FOREIGN KEY (`idOpcion`) REFERENCES `opcion` (`id`),
  ADD CONSTRAINT `fk_idPerfilPres` FOREIGN KEY (`idPerfil`) REFERENCES `perfil` (`id`);

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
