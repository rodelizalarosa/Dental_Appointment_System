-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 19, 2025 at 01:23 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dcas_sys`
--

-- --------------------------------------------------------

--
-- Table structure for table `patients`
--

CREATE TABLE `patients` (
  `patient_id` int(20) NOT NULL,
  `user_id` int(20) DEFAULT NULL,
  `first_name` varchar(255) NOT NULL,
  `middle_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) NOT NULL,
  `gender` enum('Male','Female') NOT NULL,
  `dob` date NOT NULL,
  `contact_number` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_id` int(20) NOT NULL,
  `username` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `role` enum('Admin','Patient','Dentist') NOT NULL,
  `status` enum('Pending','Active','Deactivated') NOT NULL,
  `password` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `username`, `email`, `role`, `status`, `password`) VALUES
(1, 'rode', 'rode@gmail.com', 'Admin', 'Active', '3B6X/OvDQV8pvejFq3EPXRO83edXQR5a72N/dI8VXWc='),
(2, 'rasheedlovee', 'tapales.rasheed@gmail.com', 'Dentist', 'Active', 'Md2T17pJCo60AEO/Pv6KErfoODgHt3n3gztIrOvPFpU='),
(4, 'rodeliza', 'rodeliza@gmail.com', 'Admin', 'Active', 'Q61LLm9J1N3LWJnYComviibvp8sMQ5HRg5Vta2RUX90='),
(5, 'admin', 'admin@gmail.com', 'Admin', 'Active', 'A2PP6ZkUYIA6O0LVVH7urjddwqxsAajDB7miYRb4u5o='),
(6, 'Adminn', 'Aadmin@gmail.com', 'Admin', 'Active', 'tXMdgavKY0WxJJlIZNr3zG53DtqsKYvMpEC4KPXMxXg='),
(7, 'Rodelizaa', '2002@gmail.com', 'Admin', 'Active', 'b5731d81abca6345b124994864daf7cc6e770edaac298bcca440b828f5ccc578'),
(8, 'Lovee', 'love.rasheed@gmail.com', 'Dentist', 'Active', '480ca255bf5d78c82913efff0433695b418c85ebf05f4dc5e92e59e951aded36'),
(9, 'ahldeng', 'ahlde@gmail.com', 'Admin', 'Pending', '428ad9b31b88aebb5b1c9c7c56fe540b9c8133fce671ca9d17b5deab496027dd'),
(10, 'ahldeng', 'dsa@gmail.com', 'Admin', 'Pending', 'b5731d81abca6345b124994864daf7cc6e770edaac298bcca440b828f5ccc578');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `patients`
--
ALTER TABLE `patients`
  ADD PRIMARY KEY (`patient_id`),
  ADD UNIQUE KEY `INDEX` (`user_id`) USING BTREE;

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `patients`
--
ALTER TABLE `patients`
  MODIFY `patient_id` int(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `patients`
--
ALTER TABLE `patients`
  ADD CONSTRAINT `patients_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
