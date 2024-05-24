-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1
-- Время создания: Май 24 2024 г., 20:24
-- Версия сервера: 10.4.32-MariaDB
-- Версия PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `meeting_agency`
--

-- --------------------------------------------------------

--
-- Структура таблицы `archive`
--

CREATE TABLE `archive` (
  `ID` int(11) NOT NULL,
  `date_info` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Структура таблицы `characters`
--

CREATE TABLE `characters` (
  `ID` int(11) NOT NULL,
  `Trait` tinytext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Дамп данных таблицы `characters`
--

INSERT INTO `characters` (`ID`, `Trait`) VALUES
(1, 'test trait');

-- --------------------------------------------------------

--
-- Структура таблицы `character_list`
--

CREATE TABLE `character_list` (
  `ID` int(11) NOT NULL,
  `User ID` int(11) NOT NULL,
  `Character ID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Дамп данных таблицы `character_list`
--

INSERT INTO `character_list` (`ID`, `User ID`, `Character ID`) VALUES
(1, 1, 1);

-- --------------------------------------------------------

--
-- Структура таблицы `chat`
--

CREATE TABLE `chat` (
  `ID` int(11) NOT NULL,
  `User_1_ID` int(11) NOT NULL,
  `User_2_ID` int(11) NOT NULL,
  `Creation date` datetime NOT NULL,
  `message` tinytext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Структура таблицы `client`
--

CREATE TABLE `client` (
  `id` int(11) NOT NULL,
  `name` tinytext NOT NULL,
  `surname` tinytext NOT NULL,
  `aboutYourself` tinytext NOT NULL,
  `age` int(11) DEFAULT NULL,
  `sex` text DEFAULT NULL,
  `birthdate` date DEFAULT NULL,
  `photo` blob DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Дамп данных таблицы `client`
--

INSERT INTO `client` (`id`, `name`, `surname`, `aboutYourself`, `age`, `sex`, `birthdate`, `photo`) VALUES
(1, 'Kostya', 'U', 'student', 19, '0', '2004-05-01', 0x30),
(2, 'Danya', 'M', 'student', 19, '0', '2004-04-29', 0x31),
(3, 'John', 'Doe', 'About John', 30, '0', '1994-05-07', NULL),
(4, 'Jane', 'Smith', 'About Jane', 25, '0', '1999-10-15', NULL),
(5, 'Alice', 'Johnson', 'About Alice', 40, '0', '1984-03-22', NULL),
(6, 'John', 'Smith', 'About John', 30, '0', '1994-05-07', NULL),
(7, 'Jane', 'Smith', 'About Jane', 25, '0', '1999-10-15', NULL),
(8, 'Alice', 'Johnson', 'About Alice', 40, '0', '1984-03-22', NULL),
(9, 'Michael', 'Brown', 'About Michael', 35, '0', '1989-07-18', NULL),
(10, 'Emily', 'Davis', 'About Emily', 28, '0', '1996-12-03', NULL),
(11, 'David', 'Martinez', 'About David', 45, '0', '1979-09-29', NULL),
(12, 'Sarah', 'Garcia', 'About Sarah', 22, '0', '2002-02-14', NULL),
(13, 'Robert', 'Anderson', 'About Robert', 33, '0', '1991-11-26', NULL),
(14, 'Jennifer', 'Wilson', 'About Jennifer', 38, '0', '1986-08-09', NULL),
(15, 'William', 'Taylor', 'About William', 31, '0', '1993-04-30', NULL),
(16, 'John', 'Doe', 'About John', 30, '0', '1994-05-07', NULL),
(17, 'Jane', 'Smith', 'About Jane', 25, '0', '1999-10-15', NULL),
(18, 'Alice', 'Johnson', 'About Alice', 40, '0', '1984-03-22', NULL),
(19, 'Michael', 'Brown', 'About Michael', 35, '0', '1989-07-18', NULL),
(20, 'Emily', 'Davis', 'About Emily', 28, '0', '1996-12-03', NULL),
(21, 'David', 'Martinez', 'About David', 45, '0', '1979-09-29', NULL),
(23, 'Robert', 'Anderson', 'About Robert', 33, '0', '1991-11-26', NULL),
(24, 'Jennifer', 'Wilson', 'About Jennifer', 38, '0', '1986-08-09', NULL),
(25, 'William', 'Taylor', 'About William', 31, '0', '1993-04-30', NULL),
(26, 'John', 'Doe', 'About John', 30, '0', '1994-05-07', NULL),
(27, 'Jane', 'Smith', 'About Jane', 25, '0', '1999-10-15', NULL),
(28, 'Alice', 'Johnson', 'About Alice', 40, '0', '1984-03-22', NULL),
(29, 'Michael', 'Brown', 'About Michael', 35, '0', '1989-07-18', NULL),
(30, 'Emily', 'Davis', 'About Emily', 28, '0', '1996-12-03', NULL),
(31, 'David', 'Martinez', 'About David', 45, '0', '1979-09-29', NULL),
(32, 'Sarah', 'Garcia', 'About Sarah', 22, '0', '2002-02-14', NULL),
(33, 'Robert', 'Anderson', 'About Robert', 33, '0', '1991-11-26', NULL),
(34, 'Jennifer', 'Wilson', 'About Jennifer', 38, '0', '1986-08-09', NULL),
(35, 'William', 'Taylor', 'About William', 31, '0', '1993-04-30', NULL),
(36, 'John', 'Doe', 'about john', 30, '0', '2024-05-07', ''),
(37, 'Jane', 'Smith', 'about Jane', 25, '0', '2019-01-07', NULL),
(42, 'Test', 'Testovich', 'It\'s test', 20, 'male', '2004-05-22', NULL),
(44, 'Test', 'Testovich', 'It\'s test', 1, 'male', '2024-05-23', NULL),
(45, 'Vlado4ka', 'Berkunskaya', 'Ne lubit Danyu', 20, 'female', '2004-01-01', NULL);

-- --------------------------------------------------------

--
-- Структура таблицы `country`
--

CREATE TABLE `country` (
  `ID` int(11) NOT NULL,
  `Country_name` tinytext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Дамп данных таблицы `country`
--

INSERT INTO `country` (`ID`, `Country_name`) VALUES
(1, 'Ukraine'),
(2, 'USA'),
(3, 'Poland');

-- --------------------------------------------------------

--
-- Структура таблицы `dating_table`
--

CREATE TABLE `dating_table` (
  `ID` int(11) NOT NULL,
  `User_1_ID` int(11) NOT NULL,
  `User_2_ID` int(11) NOT NULL,
  `Date` datetime DEFAULT NULL,
  `Registration_country` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Дамп данных таблицы `dating_table`
--

INSERT INTO `dating_table` (`ID`, `User_1_ID`, `User_2_ID`, `Date`, `Registration_country`) VALUES
(1, 1, 2, '2024-05-01 10:47:22', 1),
(2, 31, 4, '2024-05-07 16:24:18', 3),
(3, 2, 7, '2024-05-07 17:56:21', 1),
(5, 2, 7, '2024-05-08 10:16:54', 3),
(7, 7, 21, '2024-05-08 10:55:37', 2),
(8, 5, 31, '2024-05-08 12:45:20', 2),
(10, 5, 15, '2024-05-08 12:45:51', 2),
(11, 31, 10, '2024-05-08 12:46:52', 2),
(16, 9, 10, '2024-05-20 16:25:05', 1),
(17, 4, 10, '2024-05-19 19:28:00', 1),
(18, 6, 7, '2024-05-20 19:29:00', 1),
(19, 6, 1, '2024-06-01 19:36:00', 1),
(20, 6, 10, '2024-05-20 22:00:00', 1),
(21, 2, 4, '2024-05-21 17:55:00', 1),
(22, 10, 1, '2024-05-21 19:00:00', 1),
(23, 8, 6, '2024-05-21 17:00:00', 2),
(25, 1, 2, '2024-05-25 12:30:00', 1),
(26, 2, 45, '2024-05-25 13:30:00', 1);

-- --------------------------------------------------------

--
-- Структура таблицы `hobbies`
--

CREATE TABLE `hobbies` (
  `ID` int(11) NOT NULL,
  `Hobby` tinytext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Дамп данных таблицы `hobbies`
--

INSERT INTO `hobbies` (`ID`, `Hobby`) VALUES
(1, 'Computer games'),
(2, 'Apple'),
(3, 'Coding'),
(4, 'Reading'),
(5, 'Gardening'),
(6, 'Cooking');

-- --------------------------------------------------------

--
-- Структура таблицы `hobbylist`
--

CREATE TABLE `hobbylist` (
  `ID` int(11) NOT NULL,
  `User ID` int(11) DEFAULT NULL,
  `Hobby ID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Дамп данных таблицы `hobbylist`
--

INSERT INTO `hobbylist` (`ID`, `User ID`, `Hobby ID`) VALUES
(3, 2, 2),
(4, 31, 1),
(5, 7, 2),
(6, 10, 1),
(7, 15, 2),
(8, 3, 5),
(9, 4, 4),
(10, 5, 6),
(11, 6, 3),
(12, 8, 5),
(15, 9, 4),
(16, 11, 3),
(17, 1, 1),
(20, 42, 1),
(22, 44, 1),
(23, 45, 6);

-- --------------------------------------------------------

--
-- Структура таблицы `requirements`
--

CREATE TABLE `requirements` (
  `ID` int(11) NOT NULL,
  `requirement` tinytext DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Дамп данных таблицы `requirements`
--

INSERT INTO `requirements` (`ID`, `requirement`) VALUES
(1, 'test req'),
(2, 'Clever');

-- --------------------------------------------------------

--
-- Структура таблицы `requirements_list`
--

CREATE TABLE `requirements_list` (
  `ID` int(11) NOT NULL,
  `User_ID` int(11) NOT NULL,
  `requirement_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Дамп данных таблицы `requirements_list`
--

INSERT INTO `requirements_list` (`ID`, `User_ID`, `requirement_id`) VALUES
(1, 18, 1),
(2, 1, 1),
(3, 2, 1),
(4, 31, 1),
(5, 7, 1),
(8, 10, 1),
(9, 15, 1),
(10, 4, 1),
(11, 5, 2),
(12, 8, 2),
(13, 9, 1),
(15, 3, 1),
(19, 6, 1),
(20, 11, 1),
(24, 42, 1),
(26, 44, 1),
(27, 45, 2);

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `archive`
--
ALTER TABLE `archive`
  ADD PRIMARY KEY (`ID`);

--
-- Индексы таблицы `characters`
--
ALTER TABLE `characters`
  ADD PRIMARY KEY (`ID`);

--
-- Индексы таблицы `character_list`
--
ALTER TABLE `character_list`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `User ID` (`User ID`),
  ADD KEY `Character ID` (`Character ID`);

--
-- Индексы таблицы `chat`
--
ALTER TABLE `chat`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `User_1_ID` (`User_1_ID`),
  ADD KEY `User_2_ID` (`User_2_ID`);

--
-- Индексы таблицы `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`),
  ADD KEY `id_2` (`id`);

--
-- Индексы таблицы `country`
--
ALTER TABLE `country`
  ADD PRIMARY KEY (`ID`);

--
-- Индексы таблицы `dating_table`
--
ALTER TABLE `dating_table`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `User_1_ID` (`User_1_ID`),
  ADD KEY `User_2_ID` (`User_2_ID`),
  ADD KEY `Registration_country` (`Registration_country`);

--
-- Индексы таблицы `hobbies`
--
ALTER TABLE `hobbies`
  ADD PRIMARY KEY (`ID`);

--
-- Индексы таблицы `hobbylist`
--
ALTER TABLE `hobbylist`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `User ID` (`User ID`),
  ADD KEY `Hobby ID` (`Hobby ID`);

--
-- Индексы таблицы `requirements`
--
ALTER TABLE `requirements`
  ADD PRIMARY KEY (`ID`);

--
-- Индексы таблицы `requirements_list`
--
ALTER TABLE `requirements_list`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `User_ID` (`User_ID`),
  ADD KEY `requirement_id` (`requirement_id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `characters`
--
ALTER TABLE `characters`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT для таблицы `client`
--
ALTER TABLE `client`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=47;

--
-- AUTO_INCREMENT для таблицы `dating_table`
--
ALTER TABLE `dating_table`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT для таблицы `hobbylist`
--
ALTER TABLE `hobbylist`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT для таблицы `requirements_list`
--
ALTER TABLE `requirements_list`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `character_list`
--
ALTER TABLE `character_list`
  ADD CONSTRAINT `Character key` FOREIGN KEY (`Character ID`) REFERENCES `characters` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `User key` FOREIGN KEY (`User ID`) REFERENCES `client` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Ограничения внешнего ключа таблицы `chat`
--
ALTER TABLE `chat`
  ADD CONSTRAINT `User 1 id` FOREIGN KEY (`User_1_ID`) REFERENCES `client` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `User 2 id` FOREIGN KEY (`User_2_ID`) REFERENCES `client` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Ограничения внешнего ключа таблицы `dating_table`
--
ALTER TABLE `dating_table`
  ADD CONSTRAINT `reg country` FOREIGN KEY (`Registration_country`) REFERENCES `country` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `usr id 1` FOREIGN KEY (`User_1_ID`) REFERENCES `client` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `usr id 2` FOREIGN KEY (`User_2_ID`) REFERENCES `client` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Ограничения внешнего ключа таблицы `hobbylist`
--
ALTER TABLE `hobbylist`
  ADD CONSTRAINT `hobby id key` FOREIGN KEY (`Hobby ID`) REFERENCES `hobbies` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `used id key` FOREIGN KEY (`User ID`) REFERENCES `client` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Ограничения внешнего ключа таблицы `requirements_list`
--
ALTER TABLE `requirements_list`
  ADD CONSTRAINT `client id key` FOREIGN KEY (`User_ID`) REFERENCES `client` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `requirement id` FOREIGN KEY (`requirement_id`) REFERENCES `requirements` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
