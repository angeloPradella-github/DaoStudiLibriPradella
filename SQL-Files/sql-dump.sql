
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

-- INSERT AUTORI
INSERT INTO autori (id, nome, cognome, anno_nascita, anno_morte, sesso, nazione)
VALUES 
(1, 'Alessandro', 'Manzoni', 1785, 1873, 'M', 'Italia'),
(2, 'Lev', 'Tolstoj', 1828, 1910, 'M', 'Russia'),
(3, 'Bruno', 'Vespa', 1944, NULL, 'M', 'Italia'),
(4, 'Stephen', 'King', 1947, NULL, 'M', 'Stati Uniti'),
(5, 'Ernest', 'Hemingway', 1899, 1961, 'M', 'Stati Uniti'),
(6, 'Umberto', 'Eco', 1966, 2016, 'M', 'Italia'),
(7, 'Susanna', 'Tamaro', 1957, NULL, 'F', 'Italia'),
(8, 'Virginia', 'Woolf', 1882, 1941, 'F', 'Regno Unito'),
(9, 'Agatha', 'Christie', 1890, 1976, 'F', 'Regno Unito');

-- editori
INSERT INTO editori (id, nome, sede)
VALUES 
(1, 'Mondadori - Nuovo', 'Milano'),
(2, 'Rizzoli', 'Roma'),
(7, 'Einaudi', 'Torino'),
(8, 'Einaudi', 'Torino'),
(9, 'Einaudi', 'Torino'),
(10, 'Einaudi', 'Torino'),
(11, 'Einaudi', 'Torino'),
(12, 'Einaudi', 'Torino');

-- generi 

INSERT INTO generi (id, genere)
VALUES 
(1, 'Giallo'),
(2, 'horror'),
(3, 'storico'),
(4, 'romanzo');


-- libri 
INSERT INTO libri (id, id_autore, titolo, pagine, anno, id_genere, id_editore)
VALUES 
(1, 1, 'Il libro aggiornato', 300, 2023, 1, 1),
(2, 1, 'Storia della colonna infame', 700, 1843, 3, 1),
(3, 2, 'Guerra e pace', 600, 1876, 3, 1),
(4, 2, 'Anna Karenina', 700, 1877, 4, 2),
(5, 3, 'Donne al potere', 600, 2022, 4, 1),
(6, 3, 'La grande tempesta', 700, 2022, 1, 2),
(7, 4, 'Misery', 670, 1987, 2, 1),
(8, 4, 'IT', 600, 1986, 2, 2),
(9, 4, 'Shining', 670, 1977, 2, 1),
(10, 5, 'Il vecchio e il mare', 760, 1952, 4, 2),
(11, 5, 'Per chi suona la campana', 700, 1940, 4, 1),
(12, 5, 'Fiesta', 700, 1926, 4, 2),
(13, 6, 'Il nome della rosa', 600, 1980, 3, 1),
(14, 6, 'Il pendolo di Foucault', 670, 1988, 3, 2),
(15, 7, 'Va dove ti porta il cuore', 760, 1944, 4, 1),
(16, 8, 'Gita al faro', 600, 1927, 4, 2),
(17, 8, 'Orlando', 700, 1928, 4, 1),
(18, 9, 'Assassinio sull Orient Express', 670, 1934, 1, 2),
(19, 9, 'Sipario', 760, 1975, 1, 1);


