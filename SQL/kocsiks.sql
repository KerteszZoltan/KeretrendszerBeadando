-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Gép: 127.0.0.1
-- Létrehozás ideje: 2020. Dec 12. 22:54
-- Kiszolgáló verziója: 10.4.17-MariaDB
-- PHP verzió: 8.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Adatbázis: `kocsiks`
--

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `kocsidb`
--


DROP table IF EXISTS `kocsidb`;

CREATE TABLE `kocsidb` (
  `id` varchar(255) NOT NULL,
  `tipus` varchar(255) DEFAULT NULL,
  `keszult` date DEFAULT NULL,
  `keszultdb` int(11) DEFAULT NULL,
  `telephe` varchar(255) DEFAULT NULL,
  `kategoria` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- A tábla adatainak kiíratása `kocsidb`
--

INSERT INTO `kocsidb` (`id`, `tipus`, `keszult`, `keszultdb`, `telephe`, `kategoria`) VALUES
('034095df-f3e6-407f-8859-39545c61eeb3', 'C220', '2020-12-10', 3, 'Münshein', 'C'),
('0e8d4dac-e44c-4f48-9abe-19183bfa2634', '270', '2020-12-11', 3, 'Münshein', 'E'),
('1786c28c-0304-4839-b4a7-280fc25c2d4d', '240', '2001-02-07', 20, 'Prage', 'A'),
('7a4f221e-3c8b-463d-b456-fb47f8e40011', '120', '2001-03-08', 20, 'Peru', 'B');

--
-- Indexek a kiírt táblákhoz
--

--
-- A tábla indexei `kocsidb`
--
ALTER TABLE `kocsidb`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
