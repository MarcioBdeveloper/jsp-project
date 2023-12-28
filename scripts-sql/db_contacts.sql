CREATE DATABASE IF NOT EXISTS db_contacts

DROP TABLE IF EXISTS `contact`;

CREATE TABLE `contact` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `fone` varchar(15) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `adress` varchar(100) DEFAULT NULL,
  `zip_code` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;