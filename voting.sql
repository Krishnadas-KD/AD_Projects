-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 23, 2022 at 11:04 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `voting`
--

-- --------------------------------------------------------

--
-- Table structure for table `chairman`
--

CREATE TABLE `chairman` (
  `name` varchar(50) NOT NULL,
  `votes` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `chairman`
--

INSERT INTO `chairman` (`name`, `votes`) VALUES
('hi', 0);

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `User` varchar(50) NOT NULL,
  `pass` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`User`, `pass`) VALUES
('new', '123'),
('admin', '123');

-- --------------------------------------------------------

--
-- Table structure for table `lvc`
--

CREATE TABLE `lvc` (
  `name` varchar(50) NOT NULL,
  `votes` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `meditor`
--

CREATE TABLE `meditor` (
  `name` varchar(50) NOT NULL,
  `votes` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `meditor`
--

INSERT INTO `meditor` (`name`, `votes`) VALUES
('hi', 0),
('hi', 0);

-- --------------------------------------------------------

--
-- Table structure for table `pvc`
--

CREATE TABLE `pvc` (
  `name` varchar(50) NOT NULL,
  `votes` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pvc`
--

INSERT INTO `pvc` (`name`, `votes`) VALUES
('hi', 0);

-- --------------------------------------------------------

--
-- Table structure for table `wisechairman`
--

CREATE TABLE `wisechairman` (
  `name` varchar(50) NOT NULL,
  `votes` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `wisechairman`
--

INSERT INTO `wisechairman` (`name`, `votes`) VALUES
('hi', 0);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
