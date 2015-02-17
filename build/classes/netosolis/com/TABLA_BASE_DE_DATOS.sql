
CREATE TABLE IF NOT EXISTS `peliculas` (
`id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `nombre` varchar(200) NOT NULL,
  `genero` varchar(200) NOT NULL,
  `anio` smallint(6) NOT NULL,
  `actor` varchar(200) NOT NULL,
  `pais` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;