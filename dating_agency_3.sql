-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1
-- Время создания: Дек 16 2024 г., 11:37
-- Версия сервера: 10.4.32-MariaDB
-- Версия PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `dating_agency_3`
--

-- --------------------------------------------------------

--
-- Структура таблицы `archive`
--

CREATE TABLE `archive` (
  `ID` int(11) NOT NULL,
  `date_info` tinytext NOT NULL,
  `Country` tinytext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Дамп данных таблицы `archive`
--

INSERT INTO `archive` (`ID`, `date_info`, `Country`) VALUES
(12, 'Test Testovich, Test Testovich, 2024-06-06', 'Poland'),
(13, 'David Martinez, Michael Brown, 2024-07-06', 'Poland'),
(14, 'David Martinez, William Taylor, 2024-06-21', 'USA'),
(15, 'Alice Johnson, David Martinez, 2024-07-10', 'USA'),
(16, 'Alice Johnson, John Smith, 2024-05-21', 'USA');

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
(1, 'test trait'),
(2, 'Clever');

-- --------------------------------------------------------

--
-- Структура таблицы `characters_list`
--

CREATE TABLE `characters_list` (
  `User_ID` int(11) NOT NULL,
  `Character_ID` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Дамп данных таблицы `characters_list`
--

INSERT INTO `characters_list` (`User_ID`, `Character_ID`) VALUES
(1, 1),
(2, 2),
(3, 1),
(4, 1),
(5, 1),
(6, 1),
(7, 1),
(8, 1),
(9, 1),
(10, 1),
(11, 1),
(15, 1),
(31, 1),
(42, 1),
(44, 1),
(45, 1);

-- --------------------------------------------------------

--
-- Структура таблицы `chat`
--

CREATE TABLE `chat` (
  `ID` int(11) NOT NULL,
  `User_1_ID` int(11) NOT NULL,
  `User_2_ID` int(11) NOT NULL,
  `Creation_date` datetime DEFAULT current_timestamp(),
  `Message` tinytext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Дамп данных таблицы `chat`
--

INSERT INTO `chat` (`ID`, `User_1_ID`, `User_2_ID`, `Creation_date`, `Message`) VALUES
(1, 2, 1, '2024-05-31 00:02:00', 'Hi'),
(2, 1, 2, '2024-05-31 00:01:00', 'Hello'),
(3, 2, 9, '2024-05-31 00:00:00', 'Hello'),
(4, 1, 2, '2024-05-31 00:03:00', 'Acho'),
(6, 2, 7, '2024-05-31 00:00:00', 'What\'s up'),
(21, 2, 1, '2024-06-02 23:29:45', '?'),
(23, 8, 2, '2024-06-03 10:04:56', '123');

-- --------------------------------------------------------

--
-- Структура таблицы `client`
--

CREATE TABLE `client` (
  `id` int(11) NOT NULL,
  `name` tinytext NOT NULL,
  `surname` tinytext NOT NULL,
  `aboutYourself` tinytext NOT NULL,
  `age` int(11) DEFAULT timestampdiff(YEAR,`birthdate`,curdate()),
  `sex` text DEFAULT NULL,
  `birthdate` date DEFAULT NULL,
  `photo` text DEFAULT 'images/client_photo.jpg'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Дамп данных таблицы `client`
--

INSERT INTO `client` (`id`, `name`, `surname`, `aboutYourself`, `age`, `sex`, `birthdate`, `photo`) VALUES
(1, 'John', 'Johnson', 'Abou John', 20, 'male', '2004-05-01', 'images/kostya.png'),
(2, 'Alice', 'Doe', 'About Alice', 20, 'female', '2004-04-29', 'images/client_photo.jpg'),
(3, 'John', 'Doe', 'About John', 30, 'male', '1994-05-07', 'images/client_photo.jpg'),
(4, 'Jane', 'Smith', 'About Jane', 25, 'female', '1999-10-15', 'images/client_photo.jpg'),
(5, 'Alice', 'Johnson', 'About Alice', 40, 'female', '1984-03-22', 'images/client_photo.jpg'),
(6, 'John', 'Smith', 'About John', 30, 'male', '1994-05-07', 'images/client_photo.jpg'),
(7, 'Jane', 'Smith', 'About Jane', 24, 'female', '1999-10-15', 'images/client_photo.jpg'),
(8, 'Alice', 'Johnson', 'About Alice', 40, 'female', '1984-03-22', 'images/client_photo.jpg'),
(9, 'Michael', 'Brown', 'About Michael', 35, 'male', '1989-07-18', 'images/client_photo.jpg'),
(10, 'Emily', 'Davis', 'About Emily', 28, 'female', '1996-12-03', 'images/client_photo.jpg'),
(11, 'David', 'Martinez', 'About David', 45, 'male', '1979-09-29', 'images/client_photo.jpg'),
(15, 'William', 'Taylor', 'About William', 31, 'male', '1993-04-30', 'images/client_photo.jpg'),
(31, 'David', 'Martinez', 'About David', 45, 'male', '1979-09-29', 'images/client_photo.jpg'),
(42, 'Test', 'Testovich', 'It\'s test', 20, 'male', '2004-05-22', 'images/client_photo.jpg'),
(44, 'Test', 'Testovich', 'It\'s test', 0, 'male', '2024-05-23', 'images/client_photo.jpg'),
(45, 'Vlado4ka', 'Berkunskaya', 'Ne lubit Danyu', 20, 'female', '2004-01-01', 'images/client_photo.jpg');

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
(3, 'Poland'),
(4, 'Hungary');

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
(25, 1, 2, '2024-05-25 12:30:00', 1),
(26, 2, 45, '2024-05-25 13:30:00', 1),
(27, 2, 15, '2024-05-25 11:03:00', 2),
(28, 44, 42, '2024-05-31 14:00:00', 4),
(29, 44, 42, '2024-06-02 13:00:00', 3),
(31, 2, 10, '2024-06-07 06:15:00', 3),
(32, 2, 10, '2024-06-13 12:05:00', 4),
(38, 8, 1, '2024-06-28 03:20:00', 2),
(40, 8, 7, '2024-03-14 12:50:00', 1),
(41, 8, 1, '2024-07-12 21:50:00', 1),
(42, 8, 1, '2024-07-18 10:50:00', 1);

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
  `User_ID` int(11) NOT NULL,
  `Hobby_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Дамп данных таблицы `hobbylist`
--

INSERT INTO `hobbylist` (`User_ID`, `Hobby_ID`) VALUES
(1, 6),
(2, 3),
(3, 5),
(4, 4),
(5, 6),
(6, 3),
(7, 2),
(8, 5),
(9, 4),
(10, 1),
(11, 3),
(15, 2),
(31, 1),
(42, 1),
(44, 1),
(45, 6);

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
(2, 'Clever'),
(3, 'Carefull');

-- --------------------------------------------------------

--
-- Структура таблицы `requirements_list`
--

CREATE TABLE `requirements_list` (
  `User_ID` int(11) NOT NULL,
  `requirement_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Дамп данных таблицы `requirements_list`
--

INSERT INTO `requirements_list` (`User_ID`, `requirement_id`) VALUES
(1, 1),
(2, 2),
(3, 1),
(4, 1),
(5, 2),
(6, 1),
(7, 1),
(8, 2),
(9, 1),
(10, 1),
(11, 1),
(15, 1),
(31, 1),
(42, 1),
(44, 3),
(45, 2);

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
-- Индексы таблицы `characters_list`
--
ALTER TABLE `characters_list`
  ADD PRIMARY KEY (`User_ID`,`Character_ID`),
  ADD KEY `User ID` (`User_ID`) USING BTREE,
  ADD KEY `Character ID` (`Character_ID`) USING BTREE;

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
  ADD PRIMARY KEY (`User_ID`,`Hobby_ID`),
  ADD KEY `User ID` (`User_ID`) USING BTREE,
  ADD KEY `Hobby ID` (`Hobby_ID`) USING BTREE;

--
-- Индексы таблицы `requirements`
--
ALTER TABLE `requirements`
  ADD PRIMARY KEY (`ID`);

--
-- Индексы таблицы `requirements_list`
--
ALTER TABLE `requirements_list`
  ADD PRIMARY KEY (`User_ID`,`requirement_id`) USING BTREE,
  ADD KEY `requirement_id` (`requirement_id`),
  ADD KEY `User_ID` (`User_ID`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `archive`
--
ALTER TABLE `archive`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT для таблицы `characters`
--
ALTER TABLE `characters`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT для таблицы `chat`
--
ALTER TABLE `chat`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT для таблицы `client`
--
ALTER TABLE `client`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;

--
-- AUTO_INCREMENT для таблицы `dating_table`
--
ALTER TABLE `dating_table`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `characters_list`
--
ALTER TABLE `characters_list`
  ADD CONSTRAINT `Character key` FOREIGN KEY (`Character_ID`) REFERENCES `characters` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `User key` FOREIGN KEY (`User_ID`) REFERENCES `client` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Ограничения внешнего ключа таблицы `chat`
--
ALTER TABLE `chat`
  ADD CONSTRAINT `User 1 id` FOREIGN KEY (`User_1_ID`) REFERENCES `client` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `User 2 id` FOREIGN KEY (`User_2_ID`) REFERENCES `client` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION;

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
  ADD CONSTRAINT `hobby id key` FOREIGN KEY (`Hobby_ID`) REFERENCES `hobbies` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `used id key` FOREIGN KEY (`User_ID`) REFERENCES `client` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

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
