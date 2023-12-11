-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- 主機： 127.0.0.1
-- 產生時間： 2023-12-11 18:50:46
-- 伺服器版本： 10.4.28-MariaDB
-- PHP 版本： 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 資料庫： `front`
--

-- --------------------------------------------------------

--
-- 資料表結構 `audio`
--

CREATE TABLE `audio` (
  `id` int(11) NOT NULL,
  `class_id` int(11) NOT NULL,
  `audio_id` int(11) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  `text` varchar(140) NOT NULL,
  `path` varchar(140) NOT NULL,
  `feature_token` varchar(140) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- 傾印資料表的資料 `audio`
--

INSERT INTO `audio` (`id`, `class_id`, `audio_id`, `user_id`, `text`, `path`, `feature_token`) VALUES
(16, 5, NULL, 12, 'thank you very much', 'C:\\Users\\Xunhaoz\\IdeaProjects\\front\\target\\front-1.0-SNAPSHOT\\\\audio\\JMUgnhyeP0.wav', 'BWlcVybXtx5f'),
(17, 5, 16, 11, 'thank you very much', 'C:\\Users\\Xunhaoz\\IdeaProjects\\front\\target\\front-1.0-SNAPSHOT\\\\audio\\0xmjCo76eH.wav', NULL),
(18, 5, 16, 11, 'thank you very much', 'C:\\Users\\Xunhaoz\\IdeaProjects\\front\\target\\front-1.0-SNAPSHOT\\\\audio\\txY0VkJELD.wav', NULL),
(19, 5, 16, 11, 'thank you very much', 'C:\\Users\\Xunhaoz\\IdeaProjects\\front\\target\\front-1.0-SNAPSHOT\\\\audio\\rTjazTEFkO.wav', NULL),
(20, 5, 16, 11, 'thank you very much', 'C:\\Users\\Xunhaoz\\IdeaProjects\\front\\target\\front-1.0-SNAPSHOT\\\\audio\\xOvwN3I5I3.wav', NULL),
(21, 5, 16, 11, 'thank you very much', 'C:\\Users\\Xunhaoz\\IdeaProjects\\front\\target\\front-1.0-SNAPSHOT\\\\audio\\7xoeoVPhab.wav', NULL),
(22, 5, 16, 11, 'thank you very much', 'C:\\Users\\Xunhaoz\\IdeaProjects\\front\\target\\front-1.0-SNAPSHOT\\\\audio\\eIhagoj9BR.wav', NULL),
(23, 5, 16, 11, 'thank you very much', 'C:\\Users\\Xunhaoz\\IdeaProjects\\front\\target\\front-1.0-SNAPSHOT\\\\audio\\SaXnSqlG0p.wav', NULL),
(24, 5, 16, 11, 'thank you very much', 'C:\\Users\\Xunhaoz\\IdeaProjects\\front\\target\\front-1.0-SNAPSHOT\\\\audio\\JzlfMcziLZ.wav', NULL),
(25, 5, 16, 11, 'thank you very much', 'C:\\Users\\Xunhaoz\\IdeaProjects\\front\\target\\front-1.0-SNAPSHOT\\\\audio\\zpmi0HPBNp.wav', NULL),
(26, 5, 16, 11, 'thank you very much', 'C:\\Users\\Xunhaoz\\IdeaProjects\\front\\target\\front-1.0-SNAPSHOT\\\\audio\\CLThLoK0TR.wav', NULL),
(27, 5, 16, 11, 'thank you very much', 'C:\\Users\\Xunhaoz\\IdeaProjects\\front\\target\\front-1.0-SNAPSHOT\\\\audio\\2GsoGtDiz1.wav', NULL),
(28, 5, 16, 11, 'thank you very much', 'C:\\Users\\Xunhaoz\\IdeaProjects\\front\\target\\front-1.0-SNAPSHOT\\\\audio\\F0y6SzJN2O.wav', NULL),
(29, 5, 16, 11, 'thank you very much', 'C:\\Users\\Xunhaoz\\IdeaProjects\\front\\target\\front-1.0-SNAPSHOT\\\\audio\\XLxfd4ifvG.wav', NULL),
(30, 5, 16, 11, 'thank you very much', 'C:\\Users\\Xunhaoz\\IdeaProjects\\front\\target\\front-1.0-SNAPSHOT\\\\audio\\T7XyPPhasi.wav', NULL),
(31, 5, 16, 11, 'thank you very much', 'C:\\Users\\Xunhaoz\\IdeaProjects\\front\\target\\front-1.0-SNAPSHOT\\\\audio\\EWQPzpKi8u.wav', NULL),
(32, 5, 16, 11, 'thank you very much', 'C:\\Users\\Xunhaoz\\IdeaProjects\\front\\target\\front-1.0-SNAPSHOT\\\\audio\\Zfn0lqAqf5.wav', NULL);

-- --------------------------------------------------------

--
-- 資料表結構 `course`
--

CREATE TABLE `course` (
  `id` int(11) NOT NULL,
  `title` varchar(140) NOT NULL,
  `teacher` varchar(140) NOT NULL,
  `content` varchar(140) NOT NULL,
  `difficulty` varchar(140) NOT NULL,
  `midterm_time` date NOT NULL,
  `final_time` date NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- 傾印資料表的資料 `course`
--

INSERT INTO `course` (`id`, `title`, `teacher`, `content`, `difficulty`, `midterm_time`, `final_time`, `create_time`) VALUES
(1, 'title', 'teacher', 'content', 'difficulty', '2023-12-13', '2023-12-20', '2023-12-06 21:36:17'),
(3, 'title3', 'teacher3', 'content3', 'difficult', '2023-12-27', '2023-12-25', '2023-12-06 22:36:15'),
(5, 'course_title', 'course_teacher', 'course_content', 'course_difficulty', '2023-12-11', '2023-12-28', '2023-12-09 21:49:56');

-- --------------------------------------------------------

--
-- 資料表結構 `login_log`
--

CREATE TABLE `login_log` (
  `id` int(11) NOT NULL,
  `token` varchar(120) NOT NULL,
  `ip_address` varchar(60) NOT NULL,
  `login_time` timestamp NOT NULL DEFAULT current_timestamp(),
  `browser` varchar(60) NOT NULL,
  `os` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- 傾印資料表的資料 `login_log`
--

INSERT INTO `login_log` (`id`, `token`, `ip_address`, `login_time`, `browser`, `os`) VALUES
(4, 'eyJ0eXAiOiJKV1QiLCJh', '140.115.50.48', '2023-12-06 12:59:00', 'Google Chrome', 'Windows'),
(5, 'eyJ0eXAiOiJKV1QiLCJh', '140.115.50.48', '2023-12-06 13:06:49', 'Google Chrome', 'Windows'),
(6, 'eyJ0eXAiOiJKV1QiLCJh', '140.115.50.48', '2023-12-06 13:06:56', 'Google Chrome', 'Windows'),
(7, 'eyJ0eXAiOiJKV1QiLCJh', '140.115.50.48', '2023-12-06 13:07:16', 'Google Chrome', 'Windows'),
(8, 'eyJ0eXAiOiJKV1QiLCJh', '127.0.0.1', '2023-12-06 13:33:15', 'google', 'windows'),
(9, 'eyJ0eXAiOiJKV1QiLCJh', '140.115.50.48', '2023-12-06 13:57:08', 'Google Chrome', 'Windows'),
(10, 'eyJ0eXAiOiJKV1QiLCJh', '140.115.50.48', '2023-12-06 13:57:57', 'Google Chrome', 'Windows'),
(11, 'eyJ0eXAiOiJKV1QiLCJh', '127.0.0.1', '2023-12-06 13:59:39', 'google', 'windows'),
(14, 'eyJ0eXAiOiJKV1QiLCJh', '140.115.205.27', '2023-12-09 20:44:04', 'Google Chrome', 'Windows'),
(15, 'eyJ0eXAiOiJKV1QiLCJh', '140.115.205.27', '2023-12-09 21:20:57', 'Google Chrome', 'Windows'),
(16, 'eyJ0eXAiOiJKV1QiLCJh', '140.115.205.27', '2023-12-09 22:06:21', 'Google Chrome', 'Windows'),
(17, 'eyJ0eXAiOiJKV1QiLCJh', '140.115.205.27', '2023-12-09 22:06:43', 'Google Chrome', 'Windows'),
(18, 'eyJ0eXAiOiJKV1QiLCJh', '140.115.205.27', '2023-12-09 22:07:36', 'Google Chrome', 'Windows'),
(19, 'eyJ0eXAiOiJKV1QiLCJh', '140.115.205.27', '2023-12-09 22:08:42', 'Google Chrome', 'Windows'),
(20, 'eyJ0eXAiOiJKV1QiLCJh', '140.115.205.27', '2023-12-09 22:09:47', 'Google Chrome', 'Windows'),
(21, 'eyJ0eXAiOiJKV1QiLCJh', '140.115.205.27', '2023-12-10 08:20:08', 'Google Chrome', 'Windows'),
(22, 'eyJ0eXAiOiJKV1QiLCJh', '140.115.205.27', '2023-12-10 08:20:50', 'Google Chrome', 'Windows'),
(23, 'eyJ0eXAiOiJKV1QiLCJh', '140.115.50.48', '2023-12-10 11:53:46', 'Google Chrome', 'Windows'),
(24, 'eyJ0eXAiOiJKV1QiLCJh', '140.115.50.48', '2023-12-10 12:37:59', 'Google Chrome', 'Windows'),
(25, 'eyJ0eXAiOiJKV1QiLCJh', '140.115.50.48', '2023-12-10 12:38:37', 'Google Chrome', 'Windows'),
(26, 'eyJ0eXAiOiJKV1QiLCJh', '140.115.50.48', '2023-12-11 07:25:49', 'Google Chrome', 'Windows'),
(27, 'eyJ0eXAiOiJKV1QiLCJh', '140.115.50.48', '2023-12-11 07:28:34', 'Google Chrome', 'Windows'),
(28, 'eyJ0eXAiOiJKV1QiLCJh', '140.115.50.48', '2023-12-11 15:09:25', 'Google Chrome', 'Windows'),
(29, 'eyJ0eXAiOiJKV1QiLCJh', '140.115.50.48', '2023-12-11 15:10:32', 'Google Chrome', 'Windows'),
(30, 'eyJ0eXAiOiJKV1QiLCJh', '140.115.50.48', '2023-12-11 15:39:15', 'Google Chrome', 'Windows'),
(31, 'eyJ0eXAiOiJKV1QiLCJh', '140.115.50.48', '2023-12-11 15:40:14', 'Google Chrome', 'Windows');

-- --------------------------------------------------------

--
-- 資料表結構 `score`
--

CREATE TABLE `score` (
  `id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `audio_id` int(11) NOT NULL,
  `final_score` int(11) NOT NULL,
  `intonation` int(11) NOT NULL,
  `loudness` int(11) NOT NULL,
  `phrasing` int(11) NOT NULL,
  `pronunciation` int(11) NOT NULL,
  `rhythm` int(11) NOT NULL,
  `speed` int(11) NOT NULL,
  `intonation_command` varchar(140) NOT NULL,
  `loudness_command` varchar(140) NOT NULL,
  `phrasing_command` varchar(140) NOT NULL,
  `pronunciation_command` varchar(140) NOT NULL,
  `rhythm_command` varchar(140) NOT NULL,
  `speed_command` varchar(140) NOT NULL,
  `create_date` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- 傾印資料表的資料 `score`
--

INSERT INTO `score` (`id`, `student_id`, `audio_id`, `final_score`, `intonation`, `loudness`, `phrasing`, `pronunciation`, `rhythm`, `speed`, `intonation_command`, `loudness_command`, `phrasing_command`, `pronunciation_command`, `rhythm_command`, `speed_command`, `create_date`) VALUES
(11, 11, 28, 88, 50, 100, 100, 94, 99, 96, '後段需低調', '發音正確', '斷點位置正確', '音量起伏正確', '節奏快慢正確', '語速正確', '2023-12-12'),
(12, 11, 29, 88, 50, 100, 100, 94, 99, 96, '後段需低調', '發音正確', '斷點位置正確', '音量起伏正確', '節奏快慢正確', '語速正確', '2023-12-12'),
(13, 11, 30, 76, 50, 89, 100, 59, 81, 71, '後段需低調', '發音正確', '斷點位置正確', '音量起伏尚可', '節奏快慢正確', '語速正確', '2023-12-12'),
(14, 11, 31, 88, 50, 100, 100, 94, 99, 96, '後段需低調', '發音正確', '斷點位置正確', '音量起伏正確', '節奏快慢正確', '語速正確', '2023-12-12'),
(15, 11, 32, 76, 50, 89, 100, 59, 81, 71, '後段需低調', '發音正確', '斷點位置正確', '音量起伏尚可', '節奏快慢正確', '語速正確', '2023-12-12');

-- --------------------------------------------------------

--
-- 資料表結構 `student_course`
--

CREATE TABLE `student_course` (
  `id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `course_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- 傾印資料表的資料 `student_course`
--

INSERT INTO `student_course` (`id`, `student_id`, `course_id`) VALUES
(13, 11, 5);

-- --------------------------------------------------------

--
-- 資料表結構 `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(30) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(60) NOT NULL,
  `identity` tinyint(1) NOT NULL,
  `salt` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- 傾印資料表的資料 `user`
--

INSERT INTO `user` (`id`, `first_name`, `last_name`, `email`, `password`, `identity`, `salt`) VALUES
(11, 'John', 'Doe', 'unknowmale@gmail.com', '$2a$10$qlOlHDbsORsQjFWUSr4JZ.oielITtsDmPfxK20LG6UzzhkzONGuXa', 0, '$2a$10$qlOlHDbsORsQjFWUSr4JZ.'),
(12, 'Jane', 'Doe', 'unknowfemale@gmail.com', '$2a$10$YN2BK2Jl5NTKZuA10fLpte/x0GbAEWo/5cQliTi49EFP6E6ZW8/xO', 1, '$2a$10$YN2BK2Jl5NTKZuA10fLpte'),
(13, 'firstName3', 'lastName3', 's92080276@gmail.com', '$2a$10$4XC1dN5y2cr/6yOgixH6zuLvJGYRtwlKpJQkJJt7fXxmjvf1X6Uf6', 0, '$2a$10$4XC1dN5y2cr/6yOgixH6zu');

--
-- 已傾印資料表的索引
--

--
-- 資料表索引 `audio`
--
ALTER TABLE `audio`
  ADD PRIMARY KEY (`id`);

--
-- 資料表索引 `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`id`);

--
-- 資料表索引 `login_log`
--
ALTER TABLE `login_log`
  ADD PRIMARY KEY (`id`);

--
-- 資料表索引 `score`
--
ALTER TABLE `score`
  ADD PRIMARY KEY (`id`);

--
-- 資料表索引 `student_course`
--
ALTER TABLE `student_course`
  ADD PRIMARY KEY (`id`),
  ADD KEY `student_id` (`student_id`),
  ADD KEY `course_id` (`course_id`);

--
-- 資料表索引 `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- 在傾印的資料表使用自動遞增(AUTO_INCREMENT)
--

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `audio`
--
ALTER TABLE `audio`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `course`
--
ALTER TABLE `course`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `login_log`
--
ALTER TABLE `login_log`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `score`
--
ALTER TABLE `score`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `student_course`
--
ALTER TABLE `student_course`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- 已傾印資料表的限制式
--

--
-- 資料表的限制式 `student_course`
--
ALTER TABLE `student_course`
  ADD CONSTRAINT `student_course_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
