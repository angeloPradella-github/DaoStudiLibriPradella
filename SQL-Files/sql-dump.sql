
-- es_libri.autori definition

CREATE TABLE `autori` (
  `codiceA` int NOT NULL,
  `nomeA` varchar(100) DEFAULT NULL,
  `cognomeA` varchar(100) DEFAULT NULL,
  `annoN` int DEFAULT NULL,
  `annoM` int DEFAULT NULL,
  `sesso` char(1) DEFAULT NULL,
  `nazione` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`codiceA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- es_libri.editori definition

CREATE TABLE `editori` (
  `codiceE` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  `sede` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`codiceE`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- es_libri.generi definition

CREATE TABLE `generi` (
  `codiceG` int NOT NULL AUTO_INCREMENT,
  `descrizione` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`codiceG`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- es_libri.libri definition

CREATE TABLE `libri` (
  `codiceR` int NOT NULL AUTO_INCREMENT,
  `codiceA` int DEFAULT NULL,
  `titolo` varchar(255) DEFAULT NULL,
  `numPag` int DEFAULT NULL,
  `anno` int DEFAULT NULL,
  `codiceG` int DEFAULT NULL,
  `codiceE` int DEFAULT NULL,
  PRIMARY KEY (`codiceR`),
  KEY `codiceA` (`codiceA`),
  KEY `codiceG` (`codiceG`),
  KEY `codiceE` (`codiceE`),
  CONSTRAINT `libri_ibfk_1` FOREIGN KEY (`codiceA`) REFERENCES `autori` (`codiceA`),
  CONSTRAINT `libri_ibfk_2` FOREIGN KEY (`codiceG`) REFERENCES `generi` (`codiceG`),
  CONSTRAINT `libri_ibfk_3` FOREIGN KEY (`codiceE`) REFERENCES `editori` (`codiceE`)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



-- Rimuozione del vincolo esistente
ALTER TABLE `libri` 
DROP FOREIGN KEY `libri_ibfk_1`;

-- Aggiunta del vincolo con ON DELETE CASCADE
ALTER TABLE `libri` 
ADD CONSTRAINT `libri_ibfk_1` FOREIGN KEY (`codiceA`) REFERENCES `autori` (`codiceA`) ON DELETE CASCADE;



