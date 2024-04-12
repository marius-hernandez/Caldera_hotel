-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 12, 2023 at 05:15 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 8.0.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `caldera_hotel_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `CustomerID` int(11) NOT NULL,
  `FullName` varchar(255) DEFAULT NULL,
  `Age` int(11) DEFAULT NULL,
  `Gender` varchar(255) DEFAULT NULL,
  `ContactNo` varchar(255) DEFAULT NULL,
  `Address` varchar(255) DEFAULT NULL,
  `ValidId` varchar(255) DEFAULT NULL,
  `PaymentType` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`CustomerID`, `FullName`, `Age`, `Gender`, `ContactNo`, `Address`, `ValidId`, `PaymentType`) VALUES
(3, 'Marius Jacob S Hernandez', 18, '', '09491904133', 'Tambobong ', '', ''),
(4, 'Marius S Hernandez', 19, 'Male', '09491904133', 'Tambobong Rd.', 'National ID', 'Pay in Cash'),
(5, 'ere rer rere', 18, 'Female', '4343', 'rere', 'Postal ID', 'Pay in Cash'),
(6, 'marius sas sasa', 20, 'Male', '4343', 'dsdsd', 'National ID', 'Pay in Cash'),
(7, 'dsds dsds dsds', 20, 'Male', '434343', 'fdfdf', 'National ID', 'GCash'),
(8, '  ', 18, '', '', '', '', ''),
(9, 'dsds dsds dsds', 18, '', '', '', '', 'Pay in Cash'),
(10, 'dsd dsds sds', 19, 'Non-binary', '3434', 'dsds', 'TIN ID', 'Online Bank'),
(11, '  ', 18, '', '', '', '', ''),
(12, 'fdfd fdfdfd fdf', 18, '', '434343', 'ffdfdff', 'National ID', ''),
(13, 'fdfd fdff fdfd', 18, 'Male', '4545', 'fdf', 'National ID', 'Pay in Cash'),
(14, 'MAAMAMA SSS HERR', 19, 'Male', '09491904133', 'address', 'National ID', 'Pay in Cash'),
(15, '  ', 18, '', '', '', '', ''),
(16, '  ', 18, '', '', '', '', ''),
(17, '  ', 18, '', '', '', '', ''),
(18, 'Marius S Hernandez', 19, 'Male', '09491904133', 'sta rita karsada', 'National ID', 'GCash');

-- --------------------------------------------------------

--
-- Table structure for table `reservation`
--

CREATE TABLE `reservation` (
  `ReservationID` int(11) NOT NULL,
  `CustomerID` int(11) DEFAULT NULL,
  `DateIn` varchar(255) DEFAULT NULL,
  `DateOut` varchar(255) DEFAULT NULL,
  `TimeIn` varchar(255) NOT NULL,
  `TimeOut` varchar(255) NOT NULL,
  `RoomAccommodated` int(11) DEFAULT NULL,
  `NoOfPeople` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `reservation`
--

INSERT INTO `reservation` (`ReservationID`, `CustomerID`, `DateIn`, `DateOut`, `TimeIn`, `TimeOut`, `RoomAccommodated`, `NoOfPeople`) VALUES
(2, NULL, '0000-00-00 00:00:00.000000', '0000-00-00 00:00:00.000000', '', '', 10, 2),
(3, NULL, '0000-00-00 00:00:00.000000', '0000-00-00 00:00:00.000000', '', '', 10, 2),
(4, 7, '2023-05-09', '2023-05-09', '1:00 am', '1:00 am', 2, 1),
(5, 8, '2023-05-09', '2023-05-09', '1:00 am', '1:00 am', 6, 2),
(6, 9, '2023-05-09', '2023-05-09', '1:00 am', '1:00 am', 3, 1),
(7, 10, '2023-05-09', '2023-05-09', '1:00 am', '1:00 am', 2, 3),
(8, 11, '2023-05-09', '2023-05-09', '1:00 am', '1:00 am', 14, 1),
(9, 12, '2023-05-09', '2023-05-09', '1:00 am', '1:00 am', 22, 1),
(10, 13, '2023-05-09', '2023-05-09', '1:00 am', '1:00 am', 23, 1),
(11, 14, '2023-07-03', '2023-08-10', '3:00 pm', '4:00 am', 40, 2),
(12, 15, '2023-05-10', '2023-05-10', '1:00 am', '1:00 am', 6, 0),
(13, 16, '2023-05-10', '2023-05-10', '1:00 am', '1:00 am', 1, 0),
(14, 17, '2023-05-10', '2023-05-10', '1:00 am', '1:00 am', 23, 0),
(15, 18, '2023-05-30', '2023-06-01', '6:00 am', '6:00 am', 7, 0);

-- --------------------------------------------------------

--
-- Table structure for table `room`
--

CREATE TABLE `room` (
  `RoomNumber` int(11) NOT NULL,
  `Classification` varchar(255) DEFAULT NULL,
  `Size` varchar(255) DEFAULT NULL,
  `Price` varchar(255) NOT NULL,
  `isOccupied` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `room`
--

INSERT INTO `room` (`RoomNumber`, `Classification`, `Size`, `Price`, `isOccupied`) VALUES
(1, 'Deluxe Suite', '2-3', '10500', 'Yes'),
(2, 'Superior Executive', '3-4', '15000', ''),
(3, 'Superior Executive', '3-4', '15500', ''),
(4, 'Family', '5-7', '5000', ''),
(5, 'Deluxe Suite', '2-3', '12500', ''),
(6, 'Standard', '1-2', '2100', 'Yes'),
(7, 'Standard', '1-2', '2400', 'Yes'),
(8, 'Family', '5-7', '6000', ''),
(9, 'Family', '5-7', '5750', ''),
(10, 'Standard', '1-2', '2100', ''),
(11, 'Deluxe Suite', '2-3', '12000', ''),
(12, 'Standard', '1-2', '2500', ''),
(13, 'Family', '5-7', '6000', ''),
(14, 'Superior Executive', '3-4', '16500', ''),
(15, 'Family', '5-7', '5750', ''),
(16, 'Standard', '1-2', '2400', ''),
(17, 'Standard', '1-2', '2000', ''),
(18, 'Deluxe Suite', '2-3', '11500', ''),
(19, 'Standard', '1-2', '2500', ''),
(20, 'Deluxe Suite', '2-3', '10500', ''),
(21, 'Deluxe Suite', '2-3', '11000', ''),
(22, 'Superior Executive', '3-4', '16500', ''),
(23, 'Superior Executive', '3-4', '16500', 'Yes'),
(24, 'Family', '5-7', '5750', ''),
(25, 'Deluxe Suite', '2-3', '10500', ''),
(26, 'Standard', '1-2', '2400', ''),
(27, 'Standard', '1-2', '2300', ''),
(28, 'Family', '5-7', '5250', ''),
(29, 'Family', '5-7', '5500', ''),
(30, 'Standard', '1-2', '2300', ''),
(31, 'Deluxe Suite', '2-3', '12500', ''),
(32, 'Standard', '1-2', '2100', ''),
(33, 'Family', '5-7', '5000', ''),
(34, 'Superior Executive', '3-4', '16000', ''),
(35, 'Family', '5-7', '6000', ''),
(36, 'Standard', '1-2', '2400', ''),
(37, 'Standard', '1-2', '2500', ''),
(38, 'Deluxe Suite', '2-3', '10500', ''),
(39, 'Standard', '1-2', '2500', ''),
(40, 'Superior Executive', '3-4', '17500', '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`CustomerID`);

--
-- Indexes for table `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`ReservationID`);

--
-- Indexes for table `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`RoomNumber`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `CustomerID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `reservation`
--
ALTER TABLE `reservation`
  MODIFY `ReservationID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
