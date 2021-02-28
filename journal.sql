-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1
-- Время создания: Фев 28 2021 г., 16:16
-- Версия сервера: 10.4.8-MariaDB
-- Версия PHP: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `journal`
--

-- --------------------------------------------------------

--
-- Структура таблицы `attendance`
--

CREATE TABLE `attendance` (
  `attendance_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `date` date NOT NULL,
  `lesson_id` int(11) NOT NULL,
  `presence` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Структура таблицы `groups`
--

CREATE TABLE `groups` (
  `group_id` int(11) NOT NULL,
  `name` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `groups`
--

INSERT INTO `groups` (`group_id`, `name`) VALUES
(1, 'ПИ-1-17-1'),
(2, 'ПИ-1-18-1'),
(3, 'ПИ-1-19-1'),
(4, 'ПИ-1-20-1'),
(5, 'ИС-1-17-1'),
(6, 'ИС-1-18-1'),
(7, 'ИС-1-19-1'),
(8, 'ИС-1-20-1'),
(9, 'БИ-1-17-1'),
(10, 'БИ-1-18-1'),
(11, 'БИ-1-19-1'),
(12, 'БИ-1-20-1'),
(13, 'ИСп-1-17-1'),
(14, 'ИСп-1-18-1'),
(15, 'ИСп-1-19-1'),
(16, 'ИСп-1-20-1');

-- --------------------------------------------------------

--
-- Структура таблицы `lessons`
--

CREATE TABLE `lessons` (
  `lesson_id` int(11) NOT NULL,
  `name` text NOT NULL,
  `hours` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `lessons`
--

INSERT INTO `lessons` (`lesson_id`, `name`, `hours`) VALUES
(1, 'История', 144),
(2, 'Философия', 144),
(3, 'Иностранный язык', 360),
(4, 'Математический анализ', 468),
(5, 'Дискретная математика', 144),
(6, 'Теория автоматов и формальных языков', 108),
(7, 'Математическая логика и теория алгоритмов', 180),
(8, 'Алгебра и геометрия', 252),
(9, 'Теория вероятностей и математическая статистика', 180),
(10, 'Безопасность жизнедеятельности', 144),
(11, 'Информатика и программирование', 144),
(12, 'Алгоритмы и структуры данных', 108),
(13, 'Базы данных', 144),
(14, 'Операционные системы и сети', 144),
(15, 'Архитектура вычислительных систем', 108),
(16, 'Культурология', 144),
(17, 'Введение в программную инженерию', 180),
(18, 'Экономика', 144),
(19, 'Психология и педагогика', 72),
(20, 'Русский язык и культура речи', 108),
(21, 'Правоведение', 108),
(22, 'Экономика программной инженерии', 108),
(23, 'Политология', 108),
(24, 'Основы управленческой деятельности', 72),
(25, 'Физическая культура и спорт', 72),
(26, 'Конструирование программного обеспечения', 144),
(27, 'Проектирование человеко-машинного интерфейса', 144),
(28, 'Разработка и анализ требований', 108),
(29, 'Проектирование и архитектура программных систем', 144),
(30, 'Теория языков программирования и методы трансляции', 216),
(31, 'Теория вычислительных процессов', 216),
(32, 'Тестирование программного обеспечения', 144),
(33, 'Теория принятия решений', 144),
(34, 'Языки высокого уровня', 180),
(35, 'Функциональное и логическое программирование', 180),
(36, 'Объектно-ориентированный анализ и программирование', 144),
(37, 'Надежность программного обеспечения', 216),
(38, 'Управление качеством программного обеспечения', 144),
(39, 'Разработка защищенных программных систем', 144),
(40, 'Технологии обработки и хранения информации', 180),
(41, 'Системы электронного документооборота', 144),
(42, 'Управление программными проектами', 108),
(43, 'Математические модели в расчетах на ЭВМ', 108),
(44, 'Пакеты программ для инженерных расчетов', 108),
(45, 'Теория информации', 108),
(46, 'Теоретическая информатика', 108),
(47, 'Теоретические основы искусственного интеллекта', 108),
(48, 'Представление знаний в программных системах', 108),
(49, 'Планирование эксперимента', 72),
(50, 'Технологии поиска информации', 72),
(51, 'Командная разработка программных систем', 108),
(52, 'Технологии работы с технической документацией', 108),
(53, 'Сетевые операционные системы', 108),
(54, 'Сетевые технологии', 108),
(55, 'Теория автоматического управления', 108),
(56, 'Основы теории управления', 108),
(57, 'Инноватика в программной инженерии', 72),
(58, 'Моделирование программных систем', 72),
(59, 'Эксплуатация программного обеспечения', 108),
(60, 'Верификация программного обеспечения', 108),
(61, 'Мультимедиа технологии', 72),
(62, 'Периферийные устройства ЭВМ', 72),
(63, 'Разработка системного программного обеспечения', 108),
(64, 'Машинно-ориентированное программирование', 108),
(65, 'Вычислительная математика', 108),
(66, 'Разностные схемы решения дифференциальных уравнений', 108),
(67, 'Моделирование систем', 72),
(68, 'Математические основы моделирования', 72);

-- --------------------------------------------------------

--
-- Структура таблицы `marks`
--

CREATE TABLE `marks` (
  `mark_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `mark` int(11) NOT NULL,
  `date` date NOT NULL,
  `lesson_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Структура таблицы `roles`
--

CREATE TABLE `roles` (
  `role_id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `roles`
--

INSERT INTO `roles` (`role_id`, `name`) VALUES
(1, 'user'),
(2, 'admin');

-- --------------------------------------------------------

--
-- Структура таблицы `schedule`
--

CREATE TABLE `schedule` (
  `schedule_id` int(11) NOT NULL,
  `day` int(11) NOT NULL,
  `lesson_id` int(11) NOT NULL,
  `auditorium` text NOT NULL,
  `time` time NOT NULL,
  `teacher_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Структура таблицы `students`
--

CREATE TABLE `students` (
  `student_id` int(11) NOT NULL,
  `second_name` text NOT NULL,
  `name` text NOT NULL,
  `patronymic` text NOT NULL,
  `group_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `students`
--

INSERT INTO `students` (`student_id`, `second_name`, `name`, `patronymic`, `group_id`) VALUES
(201, 'Платонов', 'Никита', 'Сергеевич', 1),
(202, 'Brennan', 'Blossom', 'Zachery', 12),
(203, 'Deleon', 'Kyra', 'Victor', 10),
(204, 'Benson', 'Amir', 'Stuart', 3),
(205, 'Gallegos', 'Joel', 'Malachi', 10),
(206, 'Hines', 'Vladimir', 'Bevis', 15),
(207, 'Hahn', 'Kaye', 'Geoffrey', 11),
(208, 'Schwartz', 'Jane', 'Nash', 10),
(209, 'Terry', 'Beverly', 'Andrew', 14),
(210, 'Stewart', 'Yoko', 'Orson', 11),
(211, 'Wilkins', 'Flavia', 'Matthew', 12),
(212, 'Willis', 'Jennifer', 'Blake', 5),
(213, 'Boyer', 'Jasper', 'Mannix', 5),
(214, 'Benjamin', 'Amy', 'Harper', 3),
(215, 'Reed', 'Emily', 'Ray', 9),
(216, 'Mccullough', 'Leah', 'Chancellor', 15),
(217, 'Roman', 'Mariam', 'Hector', 2),
(218, 'Callahan', 'Silas', 'Dennis', 6),
(219, 'Gregory', 'Cara', 'Zane', 7),
(220, 'Curry', 'Cally', 'Brock', 4),
(221, 'Phelps', 'Coby', 'Curran', 5),
(222, 'Cote', 'Brady', 'Bevis', 5),
(223, 'Flynn', 'Lee', 'Mark', 14),
(224, 'Lee', 'Moses', 'Dominic', 15),
(225, 'Mckenzie', 'Brynne', 'Sawyer', 10),
(226, 'Valentine', 'Micah', 'Knox', 11),
(227, 'Joseph', 'Winifred', 'Nigel', 15),
(228, 'Allen', 'Lacey', 'Martin', 14),
(229, 'Downs', 'Aaron', 'Kennan', 11),
(230, 'Holland', 'Noel', 'Jack', 1),
(231, 'Dale', 'Eleanor', 'Ulysses', 1),
(232, 'Neal', 'Sierra', 'Carl', 10),
(233, 'Evans', 'Dominique', 'Gareth', 10),
(234, 'Dotson', 'Carla', 'Conan', 9),
(235, 'Russell', 'Kasimir', 'Carlos', 10),
(236, 'Mack', 'Ezra', 'Robert', 4),
(237, 'Dodson', 'Clarke', 'Lee', 11),
(238, 'Deleon', 'Allegra', 'Lewis', 8),
(239, 'Ferguson', 'Elton', 'Cooper', 9),
(240, 'Meyers', 'Noel', 'Guy', 12),
(241, 'Moss', 'Guy', 'Hall', 2),
(242, 'Holman', 'Troy', 'Yoshio', 3),
(243, 'Dotson', 'Mason', 'Cooper', 14),
(244, 'Stokes', 'Baxter', 'Tiger', 5),
(245, 'Burks', 'Coby', 'Lawrence', 11),
(246, 'Jordan', 'Chancellor', 'Gil', 9),
(247, 'Santiago', 'Fatima', 'Dorian', 1),
(248, 'Zimmerman', 'Jasper', 'Harper', 10),
(249, 'Nielsen', 'Cedric', 'Ryder', 11),
(250, 'Little', 'Yardley', 'Zephania', 12),
(251, 'Pope', 'Beatrice', 'Jesse', 7),
(252, 'Salas', 'Omar', 'Kadeem', 7),
(253, 'Caldwell', 'Preston', 'Emery', 3),
(254, 'Knowles', 'Odysseus', 'Tucker', 14),
(255, 'Duran', 'Merritt', 'Griffith', 13),
(256, 'Hudson', 'Nomlanga', 'Kelly', 16),
(257, 'Alvarado', 'Molly', 'Burke', 5),
(258, 'Ferrell', 'Hope', 'Dillon', 5),
(259, 'Monroe', 'Grant', 'Abbot', 13),
(260, 'Winters', 'Basil', 'Dexter', 2),
(261, 'Holder', 'Shannon', 'Dieter', 5),
(262, 'Sparks', 'Emi', 'Jonah', 14),
(263, 'Gallegos', 'John', 'Blake', 3),
(264, 'Ford', 'Kasper', 'Carson', 3),
(265, 'Ewing', 'Erin', 'Tad', 8),
(266, 'Garza', 'Nadine', 'Emery', 6),
(267, 'Mosley', 'Illiana', 'Nathan', 4),
(268, 'Whitfield', 'Shannon', 'Chaim', 14),
(269, 'Holcomb', 'Whilemina', 'Declan', 15),
(270, 'Hurley', 'Phoebe', 'Vincent', 2),
(271, 'Cote', 'Risa', 'Silas', 9),
(272, 'Calhoun', 'Portia', 'Ronan', 9),
(273, 'Hicks', 'Otto', 'Micah', 13),
(274, 'Combs', 'Mallory', 'Upton', 12),
(275, 'Reynolds', 'Reuben', 'Channing', 13),
(276, 'Munoz', 'Nasim', 'Jason', 15),
(277, 'Holman', 'Walker', 'Solomon', 7),
(278, 'Duffy', 'Anastasia', 'Thane', 4),
(279, 'Knox', 'Yvonne', 'Timon', 4),
(280, 'Park', 'India', 'Dean', 6),
(281, 'Nguyen', 'Allistair', 'Craig', 12),
(282, 'Bishop', 'Allen', 'Otto', 7),
(283, 'Mcintyre', 'Carl', 'Garrison', 7),
(284, 'Whitley', 'Gabriel', 'Brock', 13),
(285, 'Pruitt', 'Gemma', 'Dante', 4),
(286, 'Bruce', 'Farrah', 'Ryder', 4),
(287, 'Skinner', 'Elliott', 'Ignatius', 16),
(288, 'Stout', 'Galvin', 'Jack', 15),
(289, 'Mcintosh', 'Jada', 'Linus', 10),
(290, 'Cortez', 'Isadora', 'Lyle', 9),
(291, 'Kinney', 'Tasha', 'Yardley', 9),
(292, 'Mcbride', 'Chadwick', 'Mohammad', 13),
(293, 'Duran', 'Skyler', 'Joel', 8),
(294, 'Flowers', 'Benedict', 'Brenden', 1),
(295, 'Bright', 'Howard', 'Nicholas', 12),
(296, 'Pacheco', 'Melodie', 'Hamish', 11),
(297, 'Sandoval', 'Magee', 'Levi', 8),
(298, 'Barker', 'Ross', 'Dane', 7),
(299, 'Wiley', 'Reed', 'Harrison', 16),
(300, 'Hendricks', 'Plato', 'Vincent', 10),
(301, 'Matthews', 'Erasmus', 'Davis', 5);

-- --------------------------------------------------------

--
-- Структура таблицы `teachers`
--

CREATE TABLE `teachers` (
  `teacher_id` int(11) NOT NULL,
  `second_name` varchar(255) DEFAULT NULL,
  `name` text NOT NULL,
  `patronymic` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `teachers`
--

INSERT INTO `teachers` (`teacher_id`, `second_name`, `name`, `patronymic`) VALUES
(1, 'Абасова', 'Наталья', 'Иннокентьевна'),
(2, 'Алексеева', 'Татьяна', 'Леонидовна'),
(3, 'Аршинский', 'Леонид', 'Вадимович'),
(4, 'Банина', 'Нина', 'Валерьевна'),
(5, 'Бобылева', 'Ольга', 'Михайловна'),
(6, 'Гозбенко', 'Валерий', 'Ерофеевич'),
(7, 'Данеев', 'Алексей', 'Васильевич'),
(8, 'Афанасова', 'Елена', 'Николаевна'),
(9, 'Ермаков', 'Анатолий', 'Анатольевич'),
(10, 'Кашковский', 'Виктор', 'Владимирович'),
(11, 'Краковский', 'Юрий', 'Мечеславович'),
(12, 'Куценко', 'Надежда', 'Юрьевна'),
(13, 'Линова', 'Тамара', 'Анатольевна'),
(14, 'Лучников', 'Владимир', 'Александрович'),
(15, 'Манченко', 'Наталья', 'Васильевна'),
(16, 'Михаэлис', 'Владимир', 'Вячеславович'),
(17, 'Носков', 'Сергей', 'Иванович'),
(18, 'Панасенко', 'Александр', 'Николаевич'),
(19, 'Пасховер', 'Ирина', 'Леонидовна'),
(20, 'Сергеева', 'Ирина', 'Альбертовна'),
(21, 'Сизых', 'Виктор', 'Николаевич'),
(22, 'Синеговская', 'Татьяна', 'Сергеевна'),
(23, 'Тирских', 'Владимир', 'Викторович'),
(24, 'Федоров', 'Вячеслав', 'Викторович'),
(25, 'Шлаустас', 'Ромас', 'Юргевич'),
(26, 'Курганская', 'Ольга', 'Викторовна');

-- --------------------------------------------------------

--
-- Структура таблицы `users`
--

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL,
  `login` text NOT NULL,
  `password` text NOT NULL,
  `teacher_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `users`
--

INSERT INTO `users` (`user_id`, `login`, `password`, `teacher_id`) VALUES
(1, 'test1', 'pass1', 1),
(2, 'test2', 'pass2', 2);

-- --------------------------------------------------------

--
-- Структура таблицы `user_roles`
--

CREATE TABLE `user_roles` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `user_roles`
--

INSERT INTO `user_roles` (`user_id`, `role_id`) VALUES
(1, 1),
(2, 2);

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `attendance`
--
ALTER TABLE `attendance`
  ADD PRIMARY KEY (`attendance_id`),
  ADD KEY `StudentID` (`student_id`),
  ADD KEY `LessonID` (`lesson_id`);

--
-- Индексы таблицы `groups`
--
ALTER TABLE `groups`
  ADD PRIMARY KEY (`group_id`);

--
-- Индексы таблицы `lessons`
--
ALTER TABLE `lessons`
  ADD PRIMARY KEY (`lesson_id`);

--
-- Индексы таблицы `marks`
--
ALTER TABLE `marks`
  ADD PRIMARY KEY (`mark_id`),
  ADD KEY `StudentID` (`student_id`),
  ADD KEY `LessonID` (`lesson_id`);

--
-- Индексы таблицы `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`role_id`);

--
-- Индексы таблицы `schedule`
--
ALTER TABLE `schedule`
  ADD PRIMARY KEY (`schedule_id`),
  ADD KEY `LessonID` (`lesson_id`),
  ADD KEY `TeacherID` (`teacher_id`);

--
-- Индексы таблицы `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`student_id`),
  ADD KEY `GroupID` (`group_id`);

--
-- Индексы таблицы `teachers`
--
ALTER TABLE `teachers`
  ADD PRIMARY KEY (`teacher_id`);

--
-- Индексы таблицы `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`),
  ADD KEY `TeacherID` (`teacher_id`);

--
-- Индексы таблицы `user_roles`
--
ALTER TABLE `user_roles`
  ADD KEY `user_id` (`user_id`),
  ADD KEY `role_id` (`role_id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `attendance`
--
ALTER TABLE `attendance`
  MODIFY `attendance_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT для таблицы `groups`
--
ALTER TABLE `groups`
  MODIFY `group_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT для таблицы `lessons`
--
ALTER TABLE `lessons`
  MODIFY `lesson_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=69;

--
-- AUTO_INCREMENT для таблицы `marks`
--
ALTER TABLE `marks`
  MODIFY `mark_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT для таблицы `roles`
--
ALTER TABLE `roles`
  MODIFY `role_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT для таблицы `schedule`
--
ALTER TABLE `schedule`
  MODIFY `schedule_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT для таблицы `students`
--
ALTER TABLE `students`
  MODIFY `student_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=302;

--
-- AUTO_INCREMENT для таблицы `teachers`
--
ALTER TABLE `teachers`
  MODIFY `teacher_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT для таблицы `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `attendance`
--
ALTER TABLE `attendance`
  ADD CONSTRAINT `attendance_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `students` (`student_id`),
  ADD CONSTRAINT `attendance_ibfk_2` FOREIGN KEY (`lesson_id`) REFERENCES `lessons` (`lesson_id`);

--
-- Ограничения внешнего ключа таблицы `marks`
--
ALTER TABLE `marks`
  ADD CONSTRAINT `marks_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `students` (`student_id`),
  ADD CONSTRAINT `marks_ibfk_2` FOREIGN KEY (`lesson_id`) REFERENCES `lessons` (`lesson_id`);

--
-- Ограничения внешнего ключа таблицы `schedule`
--
ALTER TABLE `schedule`
  ADD CONSTRAINT `schedule_ibfk_1` FOREIGN KEY (`lesson_id`) REFERENCES `lessons` (`lesson_id`),
  ADD CONSTRAINT `schedule_ibfk_2` FOREIGN KEY (`teacher_id`) REFERENCES `teachers` (`teacher_id`);

--
-- Ограничения внешнего ключа таблицы `students`
--
ALTER TABLE `students`
  ADD CONSTRAINT `students_ibfk_1` FOREIGN KEY (`group_id`) REFERENCES `groups` (`group_id`);

--
-- Ограничения внешнего ключа таблицы `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `users_ibfk_1` FOREIGN KEY (`teacher_id`) REFERENCES `teachers` (`teacher_id`);

--
-- Ограничения внешнего ключа таблицы `user_roles`
--
ALTER TABLE `user_roles`
  ADD CONSTRAINT `user_roles_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  ADD CONSTRAINT `user_roles_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
