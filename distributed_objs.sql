-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 02, 2020 at 09:32 AM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.3.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `distributed_objs`
--

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `StdID` int(5) NOT NULL,
  `Full_Name` varchar(10) NOT NULL,
  `Age` int(2) NOT NULL,
  `Course` varchar(10) NOT NULL,
  `Current_year` int(1) NOT NULL,
  `YearofGraduation` year(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`StdID`, `Full_Name`, `Age`, `Course`, `Current_year`, `YearofGraduation`) VALUES
(99761, 'Jane Doe', 19, 'Hospitalit', 2, 2023),
(100052, 'Kelsey Mak', 21, 'Computer S', 4, 2021),
(100231, 'John Doe', 21, 'Law', 4, 2021),
(100292, 'Marvin Gay', 20, 'Financial ', 3, 2022),
(102231, 'Mary Jane', 21, 'Electrical', 4, 2021);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`StdID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
