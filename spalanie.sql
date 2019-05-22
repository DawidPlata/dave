-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 22 Maj 2019, 22:20
-- Wersja serwera: 10.1.40-MariaDB
-- Wersja PHP: 7.3.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `raporty`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `spalanie`
--

CREATE TABLE `spalanie` (
  `id` int(11) NOT NULL,
  `ilosc_paliwa` double DEFAULT NULL,
  `przebieg` double DEFAULT NULL,
  `srednie_spalanie` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `spalanie`
--

INSERT INTO `spalanie` (`id`, `ilosc_paliwa`, `przebieg`, `srednie_spalanie`) VALUES
(35, 40, 1500, NULL),
(36, 1, 40, 2.5),
(37, 45, 560, 8.03571),
(38, 60, 1235, 4.8583),
(39, 40, 1568, 2.55102),
(40, 60, 2153, 2.78681),
(41, 65.23, 2679, 2.43486),
(42, 60, 3251, 267800),
(43, 70, 3689, -15.9817),
(44, 70, 4135, 15.6951),
(45, 70, 5078, 7.42312),
(46, 70, 5923, 8.28402),
(47, 70, 6893, 7.2165),
(48, 70, 7305, 16.9903),
(49, 70, 7961, 10.6707);

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `spalanie`
--
ALTER TABLE `spalanie`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `spalanie`
--
ALTER TABLE `spalanie`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=50;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
