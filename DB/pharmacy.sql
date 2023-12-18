-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 18, 2023 at 10:08 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pharmacy`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `id` int(10) UNSIGNED ZEROFILL NOT NULL COMMENT 'id consist of 10 digits',
  `name` varchar(255) NOT NULL COMMENT 'name should be unique',
  `address` varchar(255) NOT NULL,
  `phone` varchar(13) NOT NULL COMMENT 'phone number should be in english and unique'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `drug`
--

CREATE TABLE `drug` (
  `id` int(10) NOT NULL,
  `name` varchar(255) NOT NULL COMMENT 'should be in english and unique',
  `price` int(10) UNSIGNED NOT NULL,
  `type` enum('liquid','capsule','tablet','injection') NOT NULL COMMENT '''liquid'',''capsule'',''tablet'',''injection''',
  `number_of_blisters` tinyint(3) UNSIGNED DEFAULT NULL,
  `current_quantity` tinyint(3) UNSIGNED NOT NULL,
  `min_quantity` tinyint(3) UNSIGNED NOT NULL,
  `drug_class` enum('A','B','C','D','E','F','G','H','I','J','K','L') DEFAULT NULL COMMENT '''A'',''B'',''C'',''D'',''E'',''F'',''G'',''H'',''I'',''J'',''K'',''L''',
  `supplier_id` int(10) UNSIGNED ZEROFILL NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `employer`
--

CREATE TABLE `employer` (
  `id` int(5) UNSIGNED ZEROFILL NOT NULL,
  `name` varchar(255) NOT NULL COMMENT 'name can by with any language',
  `username` varchar(255) NOT NULL COMMENT 'username should be in English',
  `password` varchar(255) NOT NULL COMMENT 'password should be hashed by SHA1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `employer`
--

INSERT INTO `employer` (`id`, `name`, `username`, `password`) VALUES
(00001, 'Mohamed Appis', 'appis', '7110eda4d09e062aa5e4a390b0a572ac0d2c0220'),
(00002, 'Amr Mohamed', 'amr', 'ab165cb90d19598f610a669dfe4798f4cd049a6a'),
(00003, 'Gipreel Islam', 'gipreel', 'b9add70531519c256186579d20bc7cec509b4bd3'),
(00004, 'Mohamed Sherif', 'mohamed', 'd5f12e53a182c062b6bf30c1445153faff12269a'),
(00005, 'Zein Ahmed', 'zein', 'cf217d30e8b6734c61d5367049dec6207e80018e'),
(00006, 'Hussien Mohsen', 'hussien', '1b251f64571dbb68522f1a08d3fffde0e855a306'),
(00007, 'Abdel Rahman Sayed', 'abdo', '1f29b440d44e5201a52f561f6a193ddffc718b41');

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `id` int(10) UNSIGNED ZEROFILL NOT NULL,
  `cost` int(11) UNSIGNED NOT NULL,
  `paid` tinyint(1) NOT NULL DEFAULT 1 COMMENT 'the default of the payment is paid',
  `employer_id` int(5) UNSIGNED ZEROFILL NOT NULL,
  `customer_id` int(10) UNSIGNED ZEROFILL NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `id` int(10) UNSIGNED ZEROFILL NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `drug`
--
ALTER TABLE `drug`
  ADD PRIMARY KEY (`id`),
  ADD KEY `drug_supplier` (`supplier_id`);

--
-- Indexes for table `employer`
--
ALTER TABLE `employer`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`id`),
  ADD KEY `payment_customer` (`customer_id`),
  ADD KEY `payment_employer` (`employer_id`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `id` int(10) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT COMMENT 'id consist of 10 digits';

--
-- AUTO_INCREMENT for table `drug`
--
ALTER TABLE `drug`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `employer`
--
ALTER TABLE `employer`
  MODIFY `id` int(5) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `id` int(10) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `supplier`
--
ALTER TABLE `supplier`
  MODIFY `id` int(10) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `drug`
--
ALTER TABLE `drug`
  ADD CONSTRAINT `drug_supplier` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `payment`
--
ALTER TABLE `payment`
  ADD CONSTRAINT `payment_customer` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `payment_employer` FOREIGN KEY (`employer_id`) REFERENCES `employer` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
