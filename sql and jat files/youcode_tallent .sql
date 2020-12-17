-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : jeu. 17 déc. 2020 à 15:32
-- Version du serveur :  10.4.11-MariaDB
-- Version de PHP : 7.4.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `youcode_tallent`
--

-- --------------------------------------------------------

--
-- Structure de la table `admins`
--

CREATE TABLE `admins` (
  `admin_id` bigint(20) NOT NULL,
  `password` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `admins`
--

INSERT INTO `admins` (`admin_id`, `password`) VALUES
(15970010, '0000');

-- --------------------------------------------------------

--
-- Structure de la table `admin_session`
--

CREATE TABLE `admin_session` (
  `Id` bigint(11) NOT NULL,
  `id_admin` bigint(20) NOT NULL,
  `is_connected` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `admin_session`
--

INSERT INTO `admin_session` (`Id`, `id_admin`, `is_connected`) VALUES
(1, 15970010, 1);

-- --------------------------------------------------------

--
-- Structure de la table `categories`
--

CREATE TABLE `categories` (
  `id_category` bigint(20) NOT NULL,
  `category_name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `categories`
--

INSERT INTO `categories` (`id_category`, `category_name`) VALUES
(1, 'The dance'),
(2, 'Singing'),
(3, 'The scene'),
(4, 'The comedy'),
(5, 'Mental arithmetic'),
(6, 'Rubik\'s cube');

-- --------------------------------------------------------

--
-- Structure de la table `participation`
--

CREATE TABLE `participation` (
  `user_id` bigint(20) NOT NULL,
  `id_category` bigint(20) NOT NULL,
  `description` varchar(200) NOT NULL,
  `show_start_time` timestamp NULL DEFAULT NULL,
  `show_end_time` timestamp NULL DEFAULT NULL,
  `attached_file` varchar(200) NOT NULL,
  `is_accepted` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `participation`
--

INSERT INTO `participation` (`user_id`, `id_category`, `description`, `show_start_time`, `show_end_time`, `attached_file`, `is_accepted`) VALUES
(930518771, 1, 'kjqhdqjshd jkqshdjkqsd kjqhdkjsqd qjkqsjd', '2020-12-30 12:00:00', '2020-12-30 12:39:00', 'sdfsdf/sdfdsf/sdfsdf', 1);

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE `users` (
  `user_id` bigint(20) NOT NULL,
  `first_name` varchar(150) NOT NULL,
  `last_name` varchar(150) NOT NULL,
  `email` varchar(150) NOT NULL,
  `phone` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `users`
--

INSERT INTO `users` (`user_id`, `first_name`, `last_name`, `email`, `phone`) VALUES
(15970010, 'Ahmed', 'Mahmoud', 'ahmed.mahmoud.admin@gmail.com', '+212 6 00 00 00 00'),
(930518771, 'Abdellah', 'Daif', 'sketchdotnet@gmail.com', '+212634343434');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `admins`
--
ALTER TABLE `admins`
  ADD PRIMARY KEY (`admin_id`);

--
-- Index pour la table `admin_session`
--
ALTER TABLE `admin_session`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `admin_session_ibfk_1` (`id_admin`);

--
-- Index pour la table `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`id_category`);

--
-- Index pour la table `participation`
--
ALTER TABLE `participation`
  ADD PRIMARY KEY (`user_id`,`id_category`),
  ADD KEY `id_catagory` (`id_category`);

--
-- Index pour la table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `categories`
--
ALTER TABLE `categories`
  MODIFY `id_category` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `admins`
--
ALTER TABLE `admins`
  ADD CONSTRAINT `admins_ibfk_1` FOREIGN KEY (`admin_id`) REFERENCES `users` (`user_id`);

--
-- Contraintes pour la table `admin_session`
--
ALTER TABLE `admin_session`
  ADD CONSTRAINT `admin_session_ibfk_1` FOREIGN KEY (`id_admin`) REFERENCES `admins` (`admin_id`);

--
-- Contraintes pour la table `participation`
--
ALTER TABLE `participation`
  ADD CONSTRAINT `participation_ibfk_1` FOREIGN KEY (`id_category`) REFERENCES `categories` (`id_category`),
  ADD CONSTRAINT `participation_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
