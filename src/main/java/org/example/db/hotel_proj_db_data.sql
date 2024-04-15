/*
SQLyog Community v13.2.1 (64 bit)
MySQL - 10.4.32-MariaDB : Database - hotel_proj
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`hotel_proj` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;

USE `hotel_proj`;

/*Table structure for table `booking` */

DROP TABLE IF EXISTS `booking`;

CREATE TABLE `booking` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `checkInDate` date NOT NULL,
  `checkOutDate` date NOT NULL,
  `roomId` int(10) unsigned NOT NULL,
  `guestName` char(100) NOT NULL,
  `guestPhone` char(100) NOT NULL,
  `roomType` int(10) unsigned NOT NULL,
  `bookingPay` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `booking` */

insert  into `booking`(`id`,`checkInDate`,`checkOutDate`,`roomId`,`guestName`,`guestPhone`,`roomType`,`bookingPay`) values 
(1,'2024-04-13','2024-04-16',405,'김철수','010-1224-5838',1,450000),
(2,'2024-04-12','2024-04-13',501,'박영희','010-1234-9998',1,150000);

/*Table structure for table `guest` */

DROP TABLE IF EXISTS `guest`;

CREATE TABLE `guest` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `regDate` datetime NOT NULL,
  `loginId` char(100) NOT NULL,
  `loginPw` char(100) NOT NULL,
  `name` char(100) NOT NULL,
  `email` char(100) NOT NULL,
  `phoneNum` char(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `loginId` (`loginId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `guest` */

insert  into `guest`(`id`,`regDate`,`loginId`,`loginPw`,`name`,`email`,`phoneNum`) values 
(1,'2024-04-11 15:44:04','admin','admin','관리자','admin@gmail.com','010-1234-5678'),
(2,'2024-04-11 15:44:04','user1','user1','김철수','user1@gmail.com','010-1224-5838'),
(3,'2024-04-11 15:44:04','user2','user2','박영희','user2@gmail.com','010-1234-9998'),
(4,'2024-04-11 15:44:53','user3','user3','최박사','user3@gmail.com','010-4315-3246');

/*Table structure for table `review` */

DROP TABLE IF EXISTS `review`;

CREATE TABLE `review` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `regDate` datetime NOT NULL,
  `bookingId` int(10) unsigned NOT NULL,
  `guestId` int(10) unsigned NOT NULL,
  `body` text NOT NULL,
  `score` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `review` */

/*Table structure for table `room` */

DROP TABLE IF EXISTS `room`;

CREATE TABLE `room` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `roomNum` int(10) unsigned NOT NULL,
  `floor` int(10) unsigned NOT NULL,
  `type` int(10) unsigned NOT NULL,
  `checkInDate` char(100) DEFAULT NULL,
  `checkOutDate` char(100) DEFAULT NULL,
  `booked` char(100) NOT NULL,
  `dayOfSelect` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=121 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `room` */

insert  into `room`(`id`,`roomNum`,`floor`,`type`,`checkInDate`,`checkOutDate`,`booked`,`dayOfSelect`) values 
(1,1,3,1,NULL,NULL,'예약가능','2024-04-15'),
(2,2,3,2,NULL,NULL,'예약가능','2024-04-15'),
(3,3,3,1,NULL,NULL,'예약가능','2024-04-15'),
(4,4,3,2,NULL,NULL,'예약가능','2024-04-15'),
(5,5,3,1,NULL,NULL,'예약가능','2024-04-15'),
(6,1,4,1,NULL,NULL,'예약가능','2024-04-15'),
(7,2,4,2,NULL,NULL,'예약가능','2024-04-15'),
(8,3,4,1,NULL,NULL,'예약가능','2024-04-15'),
(9,4,4,2,NULL,NULL,'예약가능','2024-04-15'),
(10,5,4,1,NULL,NULL,'예약가능','2024-04-15'),
(11,1,5,1,NULL,NULL,'예약가능','2024-04-15'),
(12,2,5,2,NULL,NULL,'예약가능','2024-04-15'),
(13,3,5,1,NULL,NULL,'예약가능','2024-04-15'),
(14,4,5,2,NULL,NULL,'예약가능','2024-04-15'),
(15,5,5,1,NULL,NULL,'예약가능','2024-04-15'),
(16,1,3,1,NULL,NULL,'예약가능','2024-04-16'),
(17,2,3,2,NULL,NULL,'예약가능','2024-04-16'),
(18,3,3,1,NULL,NULL,'예약가능','2024-04-16'),
(19,4,3,2,NULL,NULL,'예약가능','2024-04-16'),
(20,5,3,1,NULL,NULL,'예약가능','2024-04-16'),
(21,1,4,1,NULL,NULL,'예약가능','2024-04-16'),
(22,2,4,2,NULL,NULL,'예약가능','2024-04-16'),
(23,3,4,1,NULL,NULL,'예약가능','2024-04-16'),
(24,4,4,2,NULL,NULL,'예약가능','2024-04-16'),
(25,5,4,1,NULL,NULL,'예약가능','2024-04-16'),
(26,1,5,1,NULL,NULL,'예약가능','2024-04-16'),
(27,2,5,2,NULL,NULL,'예약가능','2024-04-16'),
(28,3,5,1,NULL,NULL,'예약가능','2024-04-16'),
(29,4,5,2,NULL,NULL,'예약가능','2024-04-16'),
(30,5,5,1,NULL,NULL,'예약가능','2024-04-16'),
(31,1,3,1,NULL,NULL,'예약가능','2024-04-17'),
(32,2,3,2,NULL,NULL,'예약가능','2024-04-17'),
(33,3,3,1,NULL,NULL,'예약가능','2024-04-17'),
(34,4,3,2,NULL,NULL,'예약가능','2024-04-17'),
(35,5,3,1,NULL,NULL,'예약가능','2024-04-17'),
(36,1,4,1,NULL,NULL,'예약가능','2024-04-17'),
(37,2,4,2,NULL,NULL,'예약가능','2024-04-17'),
(38,3,4,1,NULL,NULL,'예약가능','2024-04-17'),
(39,4,4,2,NULL,NULL,'예약가능','2024-04-17'),
(40,5,4,1,NULL,NULL,'예약가능','2024-04-17'),
(41,1,5,1,NULL,NULL,'예약가능','2024-04-17'),
(42,2,5,2,NULL,NULL,'예약가능','2024-04-17'),
(43,3,5,1,NULL,NULL,'예약가능','2024-04-17'),
(44,4,5,2,NULL,NULL,'예약가능','2024-04-17'),
(45,5,5,1,NULL,NULL,'예약가능','2024-04-17'),
(46,1,3,1,NULL,NULL,'예약가능','2024-04-18'),
(47,2,3,2,NULL,NULL,'예약가능','2024-04-18'),
(48,3,3,1,NULL,NULL,'예약가능','2024-04-18'),
(49,4,3,2,NULL,NULL,'예약가능','2024-04-18'),
(50,5,3,1,NULL,NULL,'예약가능','2024-04-18'),
(51,1,4,1,NULL,NULL,'예약가능','2024-04-18'),
(52,2,4,2,NULL,NULL,'예약가능','2024-04-18'),
(53,3,4,1,NULL,NULL,'예약가능','2024-04-18'),
(54,4,4,2,NULL,NULL,'예약가능','2024-04-18'),
(55,5,4,1,NULL,NULL,'예약가능','2024-04-18'),
(56,1,5,1,NULL,NULL,'예약가능','2024-04-18'),
(57,2,5,2,NULL,NULL,'예약가능','2024-04-18'),
(58,3,5,1,NULL,NULL,'예약가능','2024-04-18'),
(59,4,5,2,NULL,NULL,'예약가능','2024-04-18'),
(60,5,5,1,NULL,NULL,'예약가능','2024-04-18'),
(61,1,3,1,NULL,NULL,'예약가능','2024-04-19'),
(62,2,3,2,NULL,NULL,'예약가능','2024-04-19'),
(63,3,3,1,NULL,NULL,'예약가능','2024-04-19'),
(64,4,3,2,NULL,NULL,'예약가능','2024-04-19'),
(65,5,3,1,NULL,NULL,'예약가능','2024-04-19'),
(66,1,4,1,NULL,NULL,'예약가능','2024-04-19'),
(67,2,4,2,NULL,NULL,'예약가능','2024-04-19'),
(68,3,4,1,NULL,NULL,'예약가능','2024-04-19'),
(69,4,4,2,NULL,NULL,'예약가능','2024-04-19'),
(70,5,4,1,NULL,NULL,'예약가능','2024-04-19'),
(71,1,5,1,NULL,NULL,'예약가능','2024-04-19'),
(72,2,5,2,NULL,NULL,'예약가능','2024-04-19'),
(73,3,5,1,NULL,NULL,'예약가능','2024-04-19'),
(74,4,5,2,NULL,NULL,'예약가능','2024-04-19'),
(75,5,5,1,NULL,NULL,'예약가능','2024-04-19'),
(76,1,3,1,NULL,NULL,'예약가능','2024-04-20'),
(77,2,3,2,NULL,NULL,'예약가능','2024-04-20'),
(78,3,3,1,NULL,NULL,'예약가능','2024-04-20'),
(79,4,3,2,NULL,NULL,'예약가능','2024-04-20'),
(80,5,3,1,NULL,NULL,'예약가능','2024-04-20'),
(81,1,4,1,NULL,NULL,'예약가능','2024-04-20'),
(82,2,4,2,NULL,NULL,'예약가능','2024-04-20'),
(83,3,4,1,NULL,NULL,'예약가능','2024-04-20'),
(84,4,4,2,NULL,NULL,'예약가능','2024-04-20'),
(85,5,4,1,NULL,NULL,'예약가능','2024-04-20'),
(86,1,5,1,NULL,NULL,'예약가능','2024-04-20'),
(87,2,5,2,NULL,NULL,'예약가능','2024-04-20'),
(88,3,5,1,NULL,NULL,'예약가능','2024-04-20'),
(89,4,5,2,NULL,NULL,'예약가능','2024-04-20'),
(90,5,5,1,NULL,NULL,'예약가능','2024-04-20'),
(91,1,3,1,NULL,NULL,'예약가능','2024-04-21'),
(92,2,3,2,NULL,NULL,'예약가능','2024-04-21'),
(93,3,3,1,NULL,NULL,'예약가능','2024-04-21'),
(94,4,3,2,NULL,NULL,'예약가능','2024-04-21'),
(95,5,3,1,NULL,NULL,'예약가능','2024-04-21'),
(96,1,4,1,NULL,NULL,'예약가능','2024-04-21'),
(97,2,4,2,NULL,NULL,'예약가능','2024-04-21'),
(98,3,4,1,NULL,NULL,'예약가능','2024-04-21'),
(99,4,4,2,NULL,NULL,'예약가능','2024-04-21'),
(100,5,4,1,NULL,NULL,'예약가능','2024-04-21'),
(101,1,5,1,NULL,NULL,'예약가능','2024-04-21'),
(102,2,5,2,NULL,NULL,'예약가능','2024-04-21'),
(103,3,5,1,NULL,NULL,'예약가능','2024-04-21'),
(104,4,5,2,NULL,NULL,'예약가능','2024-04-21'),
(105,5,5,1,NULL,NULL,'예약가능','2024-04-21'),
(106,1,3,1,NULL,NULL,'예약가능','2024-04-22'),
(107,2,3,2,NULL,NULL,'예약가능','2024-04-22'),
(108,3,3,1,NULL,NULL,'예약가능','2024-04-22'),
(109,4,3,2,NULL,NULL,'예약가능','2024-04-22'),
(110,5,3,1,NULL,NULL,'예약가능','2024-04-22'),
(111,1,4,1,NULL,NULL,'예약가능','2024-04-22'),
(112,2,4,2,NULL,NULL,'예약가능','2024-04-22'),
(113,3,4,1,NULL,NULL,'예약가능','2024-04-22'),
(114,4,4,2,NULL,NULL,'예약가능','2024-04-22'),
(115,5,4,1,NULL,NULL,'예약가능','2024-04-22'),
(116,1,5,1,NULL,NULL,'예약가능','2024-04-22'),
(117,2,5,2,NULL,NULL,'예약가능','2024-04-22'),
(118,3,5,1,NULL,NULL,'예약가능','2024-04-22'),
(119,4,5,2,NULL,NULL,'예약가능','2024-04-22'),
(120,5,5,1,NULL,NULL,'예약가능','2024-04-22');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
