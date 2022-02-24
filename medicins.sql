-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 23, 2022 at 11:03 PM
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
-- Database: `medicins`
--

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `username` varchar(50) NOT NULL,
  `pass` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`username`, `pass`) VALUES
('new', '123');

-- --------------------------------------------------------

--
-- Table structure for table `medic`
--

CREATE TABLE `medic` (
  `Medicin_Name` varchar(50) NOT NULL,
  `Quantity` int(11) NOT NULL,
  `Price_of_One` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `medic`
--

INSERT INTO `medic` (`Medicin_Name`, `Quantity`, `Price_of_One`) VALUES
('acetaminophen', 79, 8.5),
('aspirin-p', 459, 1.2),
('bolonin', 123, 12),
('decongestants', 718, 8.5),
('ibuprofen', 395, 9.6),
('parsetamol', 488, 2.5),
('telicast-L', 700, 5.5);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `medic`
--
ALTER TABLE `medic`
  ADD PRIMARY KEY (`Medicin_Name`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
