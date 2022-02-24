-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 24, 2022 at 01:37 AM
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
-- Database: `bloodbank`
--

-- --------------------------------------------------------

--
-- Table structure for table `blood`
--

CREATE TABLE `blood` (
  `type` varchar(10) NOT NULL,
  `stock` int(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `blood`
--

INSERT INTO `blood` (`type`, `stock`) VALUES
('A+', 25),
('B+', 35),
('O+', 43),
('O-', 23);

-- --------------------------------------------------------

--
-- Table structure for table `donerdetails`
--

CREATE TABLE `donerdetails` (
  `fullname` varchar(50) NOT NULL,
  `fathername` varchar(50) NOT NULL,
  `mname` varchar(50) NOT NULL,
  `dob` varchar(50) NOT NULL,
  `mobileno` varchar(50) NOT NULL,
  `gender` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `bloodgroup` varchar(50) NOT NULL,
  `city` varchar(50) NOT NULL,
  `address` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `donerdetails`
--

INSERT INTO `donerdetails` (`fullname`, `fathername`, `mname`, `dob`, `mobileno`, `gender`, `email`, `bloodgroup`, `city`, `address`) VALUES
('hi', 'hi2', 'hi2', 'hi2', 'hi2', 'Female', 'sad', 'fdg', 'fgdh', 'ghfghfghfg');

-- --------------------------------------------------------

--
-- Table structure for table `log`
--

CREATE TABLE `log` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `log`
--

INSERT INTO `log` (`username`, `password`) VALUES
('admin', '123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `blood`
--
ALTER TABLE `blood`
  ADD PRIMARY KEY (`type`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
