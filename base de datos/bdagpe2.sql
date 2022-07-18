-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 18-07-2022 a las 22:35:54
-- Versión del servidor: 10.4.21-MariaDB
-- Versión de PHP: 7.4.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bdagpe2`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `ADDADMIN` (`dni` INT(8), `sbase` DOUBLE, `nom` VARCHAR(30), `ape` VARCHAR(30), `sex` VARCHAR(9), `tel` INT(9), `gestud` VARCHAR(30), `corr` VARCHAR(30), `dir` VARCHAR(100), `fnac` VARCHAR(10), `fcont` VARCHAR(10), `seg` CHAR(3), `dnac` VARCHAR(60), `npues` VARCHAR(60))  begin
declare CODE char(5); 
declare NRO int; 
select IFNULL(RIGHT(max(codEmp),4),0)+1 into NRO from empleado
order by codEmp; 
SET CODE=CONCAT("E",LPAD(NRO,4,"0")); 
INSERT INTO empleado (codEmp,dniEmp,sbaseEmp,nomEmp,apeEmp,sexEmp,telEmp,estuEmp,correoEmp,dircEmp,fecNaEmp,fecContEmp,segEmp,DnacEmp,NpuestoEmp,tEmp)
VALUES (CODE,dni,sbase,nom,ape,sex,tel,gestud,corr,dir,fnac,fcont,seg,dnac,npues,'Administrativo');
INSERT INTO administrativo (Empleado_codEmp)
VALUES (CODE);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `addasis` (IN `cod_emp` VARCHAR(11), IN `fecha` VARCHAR(10))  begin 
declare coda char(5); 
declare nro int; 
 
select IFNULL(RIGHT(max(IDASIS),4),0)+1 into NRO from asistencia
order by IDASIS; 
SET CODA=CONCAT("A",LPAD(NRO,4,"0")); 
insert into asistencia values(CODA,cod_emp,fecha); 
select CODA; 
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ADDVEND` (`dni` INT(8), `sbase` DOUBLE, `nom` VARCHAR(30), `ape` VARCHAR(30), `sex` VARCHAR(9), `tel` INT(9), `gestud` VARCHAR(30), `corr` VARCHAR(30), `dir` VARCHAR(100), `fnac` VARCHAR(10), `fcont` VARCHAR(10), `seg` CHAR(3), `dnac` VARCHAR(60), `npues` VARCHAR(60))  begin
declare CODE char(5); 
declare NRO int; 
select IFNULL(RIGHT(max(codEmp),4),0)+1 into NRO from empleado
order by codEmp; 
SET CODE=CONCAT("E",LPAD(NRO,4,"0")); 
INSERT INTO empleado (codEmp,dniEmp,sbaseEmp,nomEmp,apeEmp,sexEmp,telEmp,estuEmp,correoEmp,dircEmp,fecNaEmp,fecContEmp,segEmp,DnacEmp,NpuestoEmp,tEmp)
VALUES (CODE,dni,sbase,nom,ape,sex,tel,gestud,corr,dir,fnac,fcont,seg,dnac,npues,'Ventas');
INSERT INTO vendedor (Empleado_codEmp)
VALUES (CODE);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `GRABABON` (`mbon` DOUBLE)  begin
SET @variable1 = (SELECT codSueldo FROM sueldo ORDER BY codSueldo DESC LIMIT 1);
INSERT INTO suedodetalle(montBonif,Sueldo_codSueldo)
VALUES (mbon,@variable1);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `GRABACTS` (`tsue` DOUBLE, `fces` VARCHAR(10), `mlab` INT, `mcts` DOUBLE, `fec` VARCHAR(10))  begin
SET @variable1 = (SELECT codSueldo FROM sueldo ORDER BY codSueldo DESC LIMIT 1);
UPDATE sueldo
SET totalSueldos=tsue,fcese=fces
WHERE codSueldo=@variable1;
UPDATE suedodetalle
SET totalMesesLab=mlab,montCTS=mcts,fecha=fec
WHERE Sueldo_codSueldo=@variable1;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `GRABADES` (`mdes` DOUBLE)  begin
SET @variable1 = (SELECT codSueldo FROM sueldo ORDER BY codSueldo DESC LIMIT 1);
UPDATE suedodetalle
SET monTotDes=mdes
WHERE Sueldo_codSueldo=@variable1;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `GRABASD` (`mdesc` DOUBLE, `totd` INT, `mvac` DOUBLE, `mcts` DOUBLE, `frep` VARCHAR(10), `mbon` DOUBLE, `totp` DOUBLE)  begin
SET @variable1 = (SELECT codSueldo FROM sueldo ORDER BY codSueldo DESC LIMIT 1);
INSERT INTO suedodetalle(monTotDes,totalDiasLab,montVacaTrun,montCTS,Sueldo_codSueldo,fecha,montBonif,TotalPago)
VALUES (mdesc,totd,mvac,mcts,@variable1,frep,mbon,totp);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `GRABATOT` (`mtot` DOUBLE)  begin
SET @variable1 = (SELECT codSueldo FROM sueldo ORDER BY codSueldo DESC LIMIT 1);
UPDATE suedodetalle
SET TotalPago=mtot
WHERE Sueldo_codSueldo=@variable1;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `GRABAVAC` (`mvac` DOUBLE)  begin
SET @variable1 = (SELECT codSueldo FROM sueldo ORDER BY codSueldo DESC LIMIT 1);
UPDATE suedodetalle
SET montVacaTrun=mvac
WHERE Sueldo_codSueldo=@variable1;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `MODADMIN` (`code` VARCHAR(11), `dni` INT(8), `sbase` DOUBLE, `nom` VARCHAR(30), `ape` VARCHAR(30), `sex` VARCHAR(9), `tel` INT(9), `gestud` VARCHAR(30), `corr` VARCHAR(30), `dir` VARCHAR(100), `fnac` VARCHAR(10), `fcont` VARCHAR(10), `seg` CHAR(3), `dnac` VARCHAR(60), `npues` VARCHAR(60))  begin
UPDATE empleado
SET dniEmp=dni,sbaseEmp=sbase,nomEmp=nom,apeEmp=ape,sexEmp=sex,telEmp=tel,estuEmp=gestud,correoEmp=corr,dircEmp=dir,fecNaEmp=fnac,fecContEmp=fcont,segEmp=seg,DnacEmp=dnac,NpuestoEmp=npues,tEmp='Administrativo'
WHERE codEmp=code;
INSERT IGNORE INTO administrativo (Empleado_codEmp)
VALUES (code);
DELETE IGNORE from vendedor
WHERE Empleado_codEmp=code;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `MODVENT` (`code` VARCHAR(11), `dni` INT(8), `sbase` DOUBLE, `nom` VARCHAR(30), `ape` VARCHAR(30), `sex` VARCHAR(9), `tel` INT(9), `gestud` VARCHAR(30), `corr` VARCHAR(30), `dir` VARCHAR(100), `fnac` VARCHAR(10), `fcont` VARCHAR(10), `seg` CHAR(3), `dnac` VARCHAR(60), `npues` VARCHAR(60))  begin
UPDATE empleado
SET dniEmp=dni,sbaseEmp=sbase,nomEmp=nom,apeEmp=ape,sexEmp=sex,telEmp=tel,estuEmp=gestud,correoEmp=corr,dircEmp=dir,fecNaEmp=fnac,fecContEmp=fcont,segEmp=seg,DnacEmp=dnac,NpuestoEmp=npues,tEmp='Ventas'
WHERE codEmp=code;
INSERT IGNORE INTO vendedor (Empleado_codEmp)
VALUES (code);
DELETE IGNORE from administrativo
WHERE Empleado_codEmp=code;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administrativo`
--

CREATE TABLE `administrativo` (
  `Empleado_codEmp` varchar(11) NOT NULL,
  `hextras` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `administrativo`
--

INSERT INTO `administrativo` (`Empleado_codEmp`, `hextras`) VALUES
('E0001', 4),
('E0006', 20),
('E0008', 0),
('E0010', 0),
('E0011', 50),
('E0014', 50);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asistencia`
--

CREATE TABLE `asistencia` (
  `idAsis` varchar(11) NOT NULL,
  `Empleado_codEmp` varchar(11) NOT NULL,
  `fechaEntra` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `asistencia`
--

INSERT INTO `asistencia` (`idAsis`, `Empleado_codEmp`, `fechaEntra`) VALUES
('2', 'E0001', '10-07-2022'),
('3', 'E0002', '17-07-2022'),
('A0004', 'E0005', '2022-07-18'),
('A0005', 'E0002', '18-07-2022'),
('A0006', 'E0007', '18-07-2022'),
('A0007', 'E0002', '18-07-2022'),
('A0008', 'E0010', '18-07-2022'),
('A0009', 'E0011', '18-07-2022'),
('A0010', 'E0002', '18-07-2022');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `codEmp` varchar(11) NOT NULL,
  `dniEmp` int(11) NOT NULL,
  `sbaseEmp` double(10,2) NOT NULL,
  `nomEmp` varchar(30) NOT NULL,
  `apeEmp` varchar(30) NOT NULL,
  `sexEmp` varchar(9) NOT NULL,
  `telEmp` int(11) NOT NULL,
  `estuEmp` varchar(30) NOT NULL,
  `correoEmp` varchar(30) NOT NULL,
  `dircEmp` varchar(100) NOT NULL,
  `fecNaEmp` varchar(10) NOT NULL,
  `fecContEmp` varchar(10) NOT NULL,
  `segEmp` char(3) NOT NULL,
  `DnacEmp` varchar(60) NOT NULL,
  `NpuestoEmp` varchar(60) NOT NULL,
  `tEmp` varchar(14) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`codEmp`, `dniEmp`, `sbaseEmp`, `nomEmp`, `apeEmp`, `sexEmp`, `telEmp`, `estuEmp`, `correoEmp`, `dircEmp`, `fecNaEmp`, `fecContEmp`, `segEmp`, `DnacEmp`, `NpuestoEmp`, `tEmp`) VALUES
('E0001', 8886541, 1450.00, 'John', 'Jones', 'Masculino', 998456123, 'Tecnico', 'jwick@correo.com', 'Av. Wilson', '30-11-1990', '10-01-2021', 'AFP', 'Los Olivos', 'Asistente administrativo', 'Administrativo'),
('E0002', 70879865, 800.00, 'Luana', 'Fernandez', 'Femenino', 2222222, 'Tecnico', 'vend@utp.edu.pe', 'Los Nogales', '02-01-1985', '02-12-2020', 'AFP', 'SMP', 'nosesabe', 'Ventas'),
('E0005', 8886541, 1450.00, 'Raquel', 'Perez', 'Femenino', 998456123, 'Tecnico', 'jwick@correo.com', 'Av. Wilson', '30-11-1990', '10-01-2021', 'AFP', 'Los Olivos', 'Asistente de ventas', 'Ventas'),
('E0006', 46554466, 3000.50, 'Sonia', 'Perez', 'Femenino', 998456123, 'Universitario', 'rperez@correo.com', 'Av. Elmer Faucett', '30-11-1975', '10-05-2021', 'AFP', 'San Miguel', 'Asistente de finanzas', 'Administrativo'),
('E0007', 44224466, 1500.00, 'Rodrigo', 'Suazo', 'Masculino', 998456123, 'Universitario', 'rperez@correo.com', 'Av. Elmer Faucett', '30-11-1975', '10-07-2021', 'ONP', 'San Miguel', 'Finanzas', 'Ventas'),
('E0008', 45345348, 2000.00, 'Lopez', 'Rodolfo', 'Masculino', 999555666, 'Secundaria', 'correo@empresa.com', 'Las flores', '19-01-1969', '19-12-2020', 'AFP', 'SMP', 'Analista de RRHH', 'Administrativo'),
('E0009', 8845695, 4000.00, 'Graciela', 'Hernandez', 'Femenino', 4896523, 'Universitario', 'ghernandez@empresa.com', 'Ventanilla', '04-04-1982', '02-05-2020', 'AFP', 'Miraflores', 'Jefe de Ventas', 'Ventas'),
('E0010', 45876921, 1200.00, 'Nolberto', 'Sifuentes', 'Masculino', 987456321, 'Tecnico', 'correo@papyros.com', 'Las frutas 398', '11-12-1989', '12-05-2021', 'ONP', 'Surquillo', 'Auxiliar de contabilidad', 'Administrativo'),
('E0011', 5587965, 1800.00, 'Patricia', 'Lozano', 'Femenino', 7896541, 'Tecnico', 'patricia@hotmail.com', 'Gamarra 456', '05-10-1995', '01-01-2021', 'AFP', 'SMP', 'Asistente de contabilidad', 'Administrativo'),
('E0012', 87956321, 930.00, 'Luis', 'Hualpa', 'Masculino', 999888777, 'Universitario', 'correo@papyros.com', 'Los Geranios', '05-08-1980', '12-12-2021', 'AFP', 'Comas', 'Practicante de ventas', 'Ventas'),
('E0013', 87543215, 5000.00, 'Jorge', 'Perez', 'Masculino', 999882235, 'Universitario', 'sad@correo.com', 'Calle Chinchon', '05-06-1986', '02-08-2021', 'AFP', 'San Isidro', 'Jefe de ventas', 'Ventas'),
('E0014', 78965874, 1500.00, 'Edmundo', 'Marruecos', 'Masculino', 4789600, 'Universitario', 'emarruecos@papyros.com', 'Av. La Mar 123', '18-04-1993', '12-01-2020', 'ONP', 'Magdalena', 'Asistente de Sistemas', 'Administrativo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `suedodetalle`
--

CREATE TABLE `suedodetalle` (
  `idSD` int(11) NOT NULL,
  `monTotDes` double(10,2) NOT NULL,
  `totalMesesLab` int(8) NOT NULL,
  `montVacaTrun` double(10,2) NOT NULL,
  `montCTS` double(10,2) NOT NULL,
  `Sueldo_codSueldo` int(11) NOT NULL,
  `fecha` varchar(10) NOT NULL,
  `montBonif` double NOT NULL,
  `TotalPago` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `suedodetalle`
--

INSERT INTO `suedodetalle` (`idSD`, `monTotDes`, `totalMesesLab`, `montVacaTrun`, `montCTS`, `Sueldo_codSueldo`, `fecha`, `montBonif`, `TotalPago`) VALUES
(1, 431.00, 241, 200.00, 2100.00, 1, '10-07-2022', 131.5, 15000),
(6, 1909.22, 11, 1345.28, 16896.53, 5, '17-07-2022', 667.12, 16413.95),
(7, 1909.22, 11, 1345.28, 16896.53, 5, '17-07-2022', 72.2, 16413.95),
(8, 1909.22, 11, 1345.28, 16896.53, 5, '17-07-2022', 55.89, 16413.95),
(9, 1909.22, 11, 1345.28, 16896.53, 5, '17-07-2022', 55.89, 16413.95),
(10, 0.00, 0, 0.00, 0.00, 5, '', 80.35, 16413.95),
(11, 150.00, 0, 0.00, 0.00, 6, '', 47.73, 16381.32),
(12, 0.00, 0, 0.00, 0.00, 7, '', 31.42, 16365.01),
(13, 532.80, 0, 0.00, 0.00, 8, '', 1503.12, 0),
(14, 0.00, 7, 985.88, 2294.44, 9, '17-07-2022', 335.06, 356196.44),
(15, 0.00, 0, 0.00, 0.00, 10, '', 504.75, 11967.99),
(16, 0.00, 0, 0.00, 0.00, 11, '', 250.85, 6176.59),
(17, 0.00, 0, 0.00, 0.00, 12, '', 420.63, 18606.63);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sueldo`
--

CREATE TABLE `sueldo` (
  `codSueldo` int(11) NOT NULL,
  `Empleado_codEmp` varchar(11) NOT NULL,
  `totalSueldos` double(10,2) NOT NULL DEFAULT 0.00,
  `Fcese` varchar(10) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `sueldo`
--

INSERT INTO `sueldo` (`codSueldo`, `Empleado_codEmp`, `totalSueldos`, `Fcese`) VALUES
(1, 'E0001', 12000.50, '05-12-2022'),
(5, 'E0006', 15950.00, '12-12-2021'),
(6, 'E0001', 15950.00, '12-12-2021'),
(7, 'E0001', 15950.00, '24-12-2021'),
(8, 'E0007', 0.00, '0'),
(9, 'E0006', 12000.00, '24-12-2021'),
(10, 'E0011', 10800.00, '18-07-2021'),
(11, 'E0012', 5580.00, '18-06-2022'),
(12, 'E0014', 18000.00, '12-01-2021');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `idUsu` int(11) NOT NULL,
  `usuario` varchar(20) NOT NULL,
  `clave` varchar(20) NOT NULL,
  `Empleado_codEmp` varchar(11) NOT NULL,
  `rolUsu` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`idUsu`, `usuario`, `clave`, `Empleado_codEmp`, `rolUsu`) VALUES
(1, 'acastellanos', '1234', 'E0001', 'administrador');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vendedor`
--

CREATE TABLE `vendedor` (
  `Empleado_codEmp` varchar(11) NOT NULL,
  `montoVent` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `vendedor`
--

INSERT INTO `vendedor` (`Empleado_codEmp`, `montoVent`) VALUES
('E0002', 432),
('E0005', 555),
('E0007', 0),
('E0009', 0),
('E0012', 565),
('E0013', 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `administrativo`
--
ALTER TABLE `administrativo`
  ADD PRIMARY KEY (`Empleado_codEmp`);

--
-- Indices de la tabla `asistencia`
--
ALTER TABLE `asistencia`
  ADD PRIMARY KEY (`idAsis`),
  ADD KEY `Asistencia_Empleado` (`Empleado_codEmp`);

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`codEmp`);

--
-- Indices de la tabla `suedodetalle`
--
ALTER TABLE `suedodetalle`
  ADD PRIMARY KEY (`idSD`),
  ADD KEY `SuedoDetalle_Sueldo` (`Sueldo_codSueldo`);

--
-- Indices de la tabla `sueldo`
--
ALTER TABLE `sueldo`
  ADD PRIMARY KEY (`codSueldo`),
  ADD KEY `Informe_Pago_Empleado` (`Empleado_codEmp`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idUsu`),
  ADD KEY `usuario_Empleado` (`Empleado_codEmp`);

--
-- Indices de la tabla `vendedor`
--
ALTER TABLE `vendedor`
  ADD PRIMARY KEY (`Empleado_codEmp`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `suedodetalle`
--
ALTER TABLE `suedodetalle`
  MODIFY `idSD` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT de la tabla `sueldo`
--
ALTER TABLE `sueldo`
  MODIFY `codSueldo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `idUsu` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `administrativo`
--
ALTER TABLE `administrativo`
  ADD CONSTRAINT `Administrativo_Empleado` FOREIGN KEY (`Empleado_codEmp`) REFERENCES `empleado` (`codEmp`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `asistencia`
--
ALTER TABLE `asistencia`
  ADD CONSTRAINT `Asistencia_Empleado` FOREIGN KEY (`Empleado_codEmp`) REFERENCES `empleado` (`codEmp`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `suedodetalle`
--
ALTER TABLE `suedodetalle`
  ADD CONSTRAINT `SueldoDetalle_Sueldo` FOREIGN KEY (`Sueldo_codSueldo`) REFERENCES `sueldo` (`codSueldo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `sueldo`
--
ALTER TABLE `sueldo`
  ADD CONSTRAINT `Informe_Pago_Empleado` FOREIGN KEY (`Empleado_codEmp`) REFERENCES `empleado` (`codEmp`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `usuario_Empleado` FOREIGN KEY (`Empleado_codEmp`) REFERENCES `empleado` (`codEmp`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `vendedor`
--
ALTER TABLE `vendedor`
  ADD CONSTRAINT `Vendedor_Empleado` FOREIGN KEY (`Empleado_codEmp`) REFERENCES `empleado` (`codEmp`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
