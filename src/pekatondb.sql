-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Czas generowania: 04 Cze 2016, 17:28
-- Wersja serwera: 10.1.10-MariaDB
-- Wersja PHP: 5.6.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `pekaton`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `login` varchar(50) NOT NULL,
  `haslo` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `admin`
--

INSERT INTO `admin` (`id`, `login`, `haslo`) VALUES
(1, 'admin', 'admin');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `pracownik`
--

CREATE TABLE `pracownik` (
  `id` int(11) NOT NULL,
  `login` varchar(50) NOT NULL,
  `haslo` varchar(50) NOT NULL,
  `stanowisko` varchar(50) NOT NULL,
  `doswiadczenie` int(11) NOT NULL,
  `data_zatrudnienia` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `pracownik`
--

INSERT INTO `pracownik` (`id`, `login`, `haslo`, `stanowisko`, `doswiadczenie`, `data_zatrudnienia`) VALUES
(1, 'Nadia Romanov', 'nadia', 'Testowe', 0, '2016-06-04 15:27:58'),
(2, 'YasiuEDITEDIT', 'yasiu', 'Java Full Stack Developer with A lot of MoneyEDIT', 99, '2016-06-04 15:27:58'),
(3, 'Mateosz', 'mateosz', 'tester', 98, '2016-06-04 15:27:58'),
(4, 'Mateosz', 'mateosz', 'tester', 98, '2016-06-04 15:27:58'),
(6, 'Mateosz', 'mateosz', 'tester', 98, '2016-06-04 15:27:58'),
(7, 'Mateosz', 'mateosz', 'tester', 98, '2016-06-04 15:27:58'),
(8, 'Mateosz', 'mateosz', 'tester', 98, '2016-06-04 15:27:58'),
(9, 'Mateosz', 'mateosz', 'tester', 98, '2016-06-04 15:27:58'),
(10, 'Mateosz', 'mateosz', 'tester', 98, '2016-06-04 15:27:58');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `zadanie`
--

CREATE TABLE `zadanie` (
  `id` int(11) NOT NULL,
  `opis` varchar(255) NOT NULL,
  `doswiadczenie` int(11) NOT NULL,
  `zleceniodawca` varchar(50) NOT NULL,
  `id_pracownika` int(11) DEFAULT NULL,
  `status` int(11) NOT NULL,
  `data_utworzenia` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `data_zakończenia` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `zadanie`
--

INSERT INTO `zadanie` (`id`, `opis`, `doswiadczenie`, `zleceniodawca`, `id_pracownika`, `status`, `data_utworzenia`, `data_zakończenia`) VALUES
(1, 'Pierwsze zadanie testowe. Idz do kuchni i zrob mi kanapke!', 2, 'Mateusz', 1, 0, '2016-06-04 15:26:49', NULL),
(3, '123', 123, '113', 3, 0, '2016-06-04 15:26:49', NULL),
(4, '23123123', 69, 'Matius', 4, 1, '2016-06-04 15:26:49', NULL),
(5, 'Opis Testowy', 2, 'Krzyzszof', NULL, 0, '2016-06-04 15:26:49', NULL),
(12, 'Opis Testowy', 2, 'Krzyzszof', 6, 0, '2016-06-04 15:26:49', NULL),
(13, 'Opis Testowy', 2, 'Krzyzszof', NULL, 0, '2016-06-04 15:26:49', NULL),
(14, 'Opis Testowy', 2, 'Krzyzszof', 6, 0, '2016-06-04 15:26:49', NULL),
(15, 'Opis Testowy', 2, 'Krzyzszof', NULL, 0, '2016-06-04 15:26:49', NULL),
(16, 'Opis Testowy', 2, 'Krzyzszof', NULL, 0, '2016-06-04 15:26:49', NULL),
(17, 'Opis Testowy', 2, 'Krzyzszof', NULL, 0, '2016-06-04 15:26:49', NULL),
(18, 'Opis Testowy', 2, 'Krzyzszof', NULL, 0, '2016-06-04 15:26:49', NULL),
(19, 'Opis Testowy', 2, 'Krzyzszof', NULL, 0, '2016-06-04 15:26:49', NULL);

--
-- Indeksy dla zrzutów tabel
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pracownik`
--
ALTER TABLE `pracownik`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `zadanie`
--
ALTER TABLE `zadanie`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_pracownika` (`id_pracownika`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT dla tabeli `pracownik`
--
ALTER TABLE `pracownik`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT dla tabeli `zadanie`
--
ALTER TABLE `zadanie`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `zadanie`
--
ALTER TABLE `zadanie`
  ADD CONSTRAINT `zadanie_ibfk_1` FOREIGN KEY (`id_pracownika`) REFERENCES `pracownik` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
