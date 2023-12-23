-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 23, 2023 at 02:32 PM
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

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`id`, `name`, `address`, `phone`) VALUES
(0000000001, 'Mohamed Zaki', '13 B 206 St. - Degla, NEW MAADI', '201170071765'),
(0000000002, 'Fadheela Shahan', 'Awal May Bldg. 8 El-Nasr St., Nasr City', '201176207555'),
(0000000003, 'Halim Hammoud', '105 Omar Ibn El-Khattab St., Almaza', '201177764807'),
(0000000004, 'Faiqa Hakim', ' Kasr El-Maadi Bldg. 1 El-Mahata Sq., MAADI', '201135838823'),
(0000000005, 'Ahina Qadir', 'General Authority for Investment, Ind. Zone', '201122562554'),
(0000000006, 'Laila Mourad', '43 Anwar El-Sadat St., Miami', '201135437236'),
(0000000007, 'Saddam Zaman', '48 El Caed Gohar St., EL MANSHEYA', '201123620132'),
(0000000008, 'Kaeden Mahdi', '28 Syria St., Rushdi', '201523620345'),
(0000000009, 'Farid Aboud', '57 Mustafa Enahas, P.O. Box: 567', '201233929439'),
(0000000010, 'Dameer Shaikh', '15 Ahmed El-Samman St., Area 8', '201028353828'),
(0000000011, 'Aman Waheed', '6 El-Manial St., Manial', '201522676782'),
(0000000012, 'Hanif Ayub', '217 Abd El-Salam Aref St., El-Saraya', '201135833206'),
(0000000013, 'Hashim Younis', '34 Masged Sultan St., KARMOUZ', '201135838823'),
(0000000014, 'Wajee Mansouri', '28 Mohamed Youssef El-Kady St., Kolleyet El-Banat', '201233937735'),
(0000000015, 'Raaida Salah', '114 El-Tahrir St., Dokki', '201123351157'),
(0000000016, 'Naziah Maroun', ' 20 El Montazah St., ZAMALEK', '201523381179'),
(0000000017, 'Samitah Morad', '11 El-Shahid Sobhi Nasr St., Heliopolis', '201022744410'),
(0000000018, 'Reyhan Zamani', ' 10 Ahmed Yehia Pasha St., Gelim', '201222628720'),
(0000000019, 'Antwan Alli', '39 Gedda St., DOKKI', '201535407557'),
(0000000020, 'Basam Salem', '03 Kamel Moursy St, Heliopolis, Cairo', '201202630758'),
(0000000021, 'Mushin Murad', '6 Abd El-Moneim Riyad St., Gesr El-Suez Ext.', '201028034648'),
(0000000022, 'Noya Badie', '6makhlouf St, Dokky Guiza. Apt. No7, Cairo', '201223654339'),
(0000000023, 'Adira Rehmann', '61 Housing Bank Bldg., El-Dawahi', '201025406310'),
(0000000024, 'Suhaira Zakaria', '134 Mossaset El Zaka St, Ain Shams', '201026231294'),
(0000000025, 'Yasira Ammar', '52 El Nozha St., Masaken Rabaa', '201045320755'),
(0000000026, 'Aretas Agha', 'Gomhouria Tower, Gomhouria and Safia Zaghloul St.', '201022038843'),
(0000000027, 'Mujahid Kader', '13 Tahrir Sq., DOWNTOWN', '201023026949'),
(0000000028, 'Ishaq Jabour', '77 B EL Nasr Rd., NASR CITY', '201025774089'),
(0000000029, 'Rukan Laham', '46 El Iskandar El Akbar St., AZARITA', '201502546310'),
(0000000030, 'Minnah Taheri', ' 3 Ahmed Ammar St., El-Khalafawi', '201246936755');

-- --------------------------------------------------------

--
-- Table structure for table `drug`
--

CREATE TABLE `drug` (
  `id` int(10) NOT NULL,
  `name` varchar(255) NOT NULL COMMENT 'should be in english and unique',
  `price` int(10) UNSIGNED NOT NULL,
  `type` enum('liquid','tablet','injection','capsule') NOT NULL COMMENT '''liquid'',''capsule'',''tablet'',''injection''',
  `number_of_blisters` tinyint(3) UNSIGNED DEFAULT NULL,
  `current_quantity` tinyint(3) UNSIGNED NOT NULL,
  `min_quantity` tinyint(3) UNSIGNED NOT NULL,
  `drug_class` enum('A','B','C','D','E','F','G','H','I','J','K','L') DEFAULT NULL COMMENT '''A'',''B'',''C'',''D'',''E'',''F'',''G'',''H'',''I'',''J'',''K'',''L''',
  `supplier_id` int(10) UNSIGNED ZEROFILL NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `drug`
--

INSERT INTO `drug` (`id`, `name`, `price`, `type`, `number_of_blisters`, `current_quantity`, `min_quantity`, `drug_class`, `supplier_id`) VALUES
(1, 'Flagyl 500 mg', 15, 'tablet', 2, 50, 25, 'A', 0000000001),
(2, 'PANADOL COLD & FLU', 37, 'tablet', 2, 50, 25, 'A', 0000000001),
(3, 'COMTREX ACUTE HEAD COLD', 39, 'tablet', 2, 50, 25, 'B', 0000000001),
(4, 'CLARINASE 14 TAB', 55, 'tablet', 2, 50, 25, 'B', 0000000001),
(5, 'POWERCAPS 20 CAP', 25, 'tablet', 2, 50, 25, 'C', 0000000001),
(6, 'ONE TWO THREE (COLD – FLU)', 20, 'tablet', 2, 50, 25, 'C', 0000000006),
(7, 'OPLEX – N SYRUP 125 ML', 19, 'liquid', 1, 50, 35, 'C', 0000000005),
(8, 'CYRINOL SYRUP 60 ML', 17, 'liquid', 3, 50, 25, 'C', 0000000004),
(9, 'NEO – BRONCHOPHANE SYRUP 125 ML', 19, 'liquid', 2, 50, 25, 'C', 0000000003),
(10, 'CODILAR SYRUP 120 ML', 19, 'liquid', 4, 50, 25, 'C', 0000000005),
(11, 'STOPADOL 500 MG 20 TAB', 13, 'tablet', 2, 50, 35, 'C', 0000000006),
(12, 'BRUFEN 600 MG 30 TAB', 66, 'tablet', 3, 50, 25, 'E', 0000000002),
(13, 'KETOFAN 50 MG 20 CAP', 20, 'tablet', 2, 50, 25, 'E', 0000000001),
(14, 'BRUFEN 600 MG 20 SACHETS', 59, 'tablet', 2, 45, 25, 'E', 0000000001),
(15, 'BRUFEN 400 MG 30 TAB', 51, 'tablet', 3, 45, 25, 'C', 0000000001),
(16, 'galvus 50 Mg', 137, 'tablet', 3, 50, 35, 'C', 0000000004),
(17, 'galvus met 50/500 MG', 105, 'tablet', 3, 45, 25, 'C', 0000000004),
(18, 'GALVUS MET 50/850 MG', 147, 'tablet', 3, 45, 25, 'C', 0000000005),
(19, 'GALVUS MET 50/1000 MG', 180, 'tablet', 3, 20, 25, 'C', 0000000002),
(20, 'VILDAGLUS PLUS 50/1000MG', 101, 'tablet', 3, 20, 35, 'F', 0000000003),
(21, 'VICTOZA 3/18 MG', 1752, 'injection', 1, 20, 35, 'C', 0000000004),
(22, 'TRESIBA', 269, 'injection', 1, 20, 35, 'F', 0000000004),
(23, 'TRAJENTA 5MG', 329, 'tablet', 2, 20, 35, 'C', 0000000004),
(24, 'SAXENDA 3/18 MG', 876, 'injection', 1, 20, 35, 'C', 0000000004),
(25, 'DOLIBRANE', 29, 'tablet', 1, 20, 35, 'C', 0000000004),
(26, 'ZESROKAN', 41, 'tablet', 4, 20, 35, 'G', 0000000004),
(27, 'RETARD', 23, 'tablet', 1, 20, 35, 'H', 0000000004),
(28, 'SYSTANE ORIGINAL', 255, 'liquid', 4, 20, 35, 'J', 0000000004),
(29, 'SYSTANE ALTRA', 290, 'liquid', 1, 20, 35, 'C', 0000000004),
(30, 'CONGESTAL', 20, 'tablet', 3, 20, 35, 'C', 0000000004),
(31, 'CONGESTAL', 17, 'liquid', 3, 34, 35, 'C', 0000000004),
(32, 'METHYLTECHNO', 70, 'tablet', 1, 50, 25, 'C', 0000000004),
(33, 'DELTAVIT', 37, 'tablet', 2, 35, 25, 'I', 0000000008),
(34, 'NASO', 56, 'liquid', 2, 12, 25, 'I', 0000000007),
(35, 'BETOLVEX', 34, 'injection', 2, 32, 30, 'I', 0000000004),
(36, 'MILGA', 56, 'tablet', 2, 32, 35, 'I', 0000000002),
(37, 'NEUROVIT', 14, 'injection', 1, 50, 25, 'I', 0000000004),
(38, 'LIVABION', 54, 'injection', 1, 45, 25, 'I', 0000000006),
(39, 'NEUROTON', 30, 'tablet', 1, 45, 25, 'I', 0000000002),
(40, 'BECOZYME', 63, 'injection', 1, 45, 25, 'C', 0000000005),
(41, 'IMMURAVE ONE', 90, 'tablet', 2, 45, 25, 'D', 0000000004),
(42, 'AVEROZOLID', 47, 'liquid', 3, 45, 25, 'D', 0000000003),
(43, 'KALOBIN ORAL DROPS', 45, 'liquid', 3, 50, 25, 'D', 0000000002),
(44, 'MAB OMEGA SYRUP 120ML', 44, 'liquid', 3, 35, 35, 'D', 0000000004),
(45, 'CALCIONATE', 96, 'injection', 2, 50, 25, 'D', 0000000004),
(46, 'MILLITOFIX', 303, 'tablet', 2, 12, 25, 'C', 0000000004),
(47, 'SOFENACIN 10 MG', 91, 'tablet', 2, 43, 25, 'C', 0000000003),
(48, 'TICANASE PLUS', 63, 'liquid', 2, 23, 35, 'C', 0000000002),
(49, 'CANDEPRESSIN', 48, 'tablet', 2, 54, 25, 'C', 0000000003),
(50, 'Flagyl 1000 mg', 20, 'injection', 30, 20, 15, 'A', 0000000001),
(51, 'sal3ay', 15, 'injection', 1, 5, 10, 'A', 0000000001);

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
(00005, 'Zein Ahmed', 'zein', '93ee12e112bae593edcf7aecca59464c6afcc832'),
(00006, 'Hussien Mohsen', 'hussien', '1b251f64571dbb68522f1a08d3fffde0e855a306'),
(00007, 'Abdel Rahman Sayed', 'abdo', '1f29b440d44e5201a52f561f6a193ddffc718b41');

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `id` int(10) UNSIGNED ZEROFILL NOT NULL,
  `cost` int(11) UNSIGNED NOT NULL,
  `paid` varchar(7) NOT NULL DEFAULT 'paid' COMMENT 'the default of the payment is paid',
  `employer_id` int(5) UNSIGNED ZEROFILL NOT NULL,
  `customer_id` int(10) UNSIGNED ZEROFILL NOT NULL,
  `date_time` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`id`, `cost`, `paid`, `employer_id`, `customer_id`, `date_time`) VALUES
(0000000001, 55, 'paid', 00003, 0000000002, '2023-12-23 13:40:49'),
(0000000002, 75, 'paid', 00001, 0000000001, '2023-12-23 13:42:29'),
(0000000003, 45, 'paid', 00004, 0000000004, '2023-12-23 13:50:10'),
(0000000004, 235, 'paid', 00002, 0000000002, '2023-12-23 14:56:54'),
(0000000005, 234, 'paid', 00004, 0000000001, '2023-12-23 15:02:38');

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `id` int(10) UNSIGNED ZEROFILL NOT NULL,
  `name` varchar(255) NOT NULL,
  `phone_number` varchar(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`id`, `name`, `phone_number`) VALUES
(0000000001, 'Francine Oneill', '201075387257'),
(0000000002, 'Nathaniel Berg', '201077894752'),
(0000000003, 'Diana Bray', '201075387257'),
(0000000004, 'Morton Hansen', '201555803758'),
(0000000005, 'Collin Mejia', '201075325678'),
(0000000006, 'Lillian Shields', '201037812931'),
(0000000007, 'Deana Saunders', '201145324554'),
(0000000008, 'Angelica Poole', '201545326346'),
(0000000009, 'Lupe Owen', '201004312423'),
(0000000010, 'Byron Gregory', '201253425526'),
(0000000011, 'amr shawky', '01025518153');

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
  MODIFY `id` int(10) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT COMMENT 'id consist of 10 digits', AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT for table `drug`
--
ALTER TABLE `drug`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=52;

--
-- AUTO_INCREMENT for table `employer`
--
ALTER TABLE `employer`
  MODIFY `id` int(5) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `id` int(10) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `supplier`
--
ALTER TABLE `supplier`
  MODIFY `id` int(10) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

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
