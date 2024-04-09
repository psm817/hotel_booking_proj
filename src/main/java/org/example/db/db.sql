--/* 데이터베이스 만들기 */
DROP DATABASE IF EXISTS hotel_proj;
CREATE DATABASE hotel_proj;
USE hotel_proj;

SHOW TABLES;

--/* booking 테이블 만들기 */
CREATE TABLE `booking` (
id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
regDate DATE,
roomId INT(10) UNSIGNED NOT NULL,
guestName CHAR(100),
guestPhone CHAR(100),
roomType INT(10) UNSIGNED NOT NULL,
bookingPay INT UNSIGNED NOT NULL
)

SELECT * FROM booking;
DESC booking;


--/* guest 테이블 및 샘플 만들기 */
CREATE TABLE `guest` (
id int(10) unsigned not null primary key auto_increment,
regDate datetime not null,
loginId char(100) not null unique,
loginPw char(100) not null,
`name` char(100) not null,
email char(100) not null,
phoneNum char(100) not null
)

select * from guest;
desc guest;

insert into guest set regDate = now(), loginId = 'admin', loginPw = 'admin', `name` = '관리자', email = 'admin@gmail.com', phoneNum = '010-1234-5678';
INSERT INTO guest SET regDate = NOW(), loginId = 'user1', loginPw = 'user1', `name` = '김철수', email = 'user1@gmail.com', phoneNum = '010-1224-5838';
INSERT INTO guest SET regDate = NOW(), loginId = 'user2', loginPw = 'user2', `name` = '박영희', email = 'user2@gmail.com', phoneNum = '010-1234-9998';


--/* room 테이블 및 일주일치 방 생성 */
create table room (
id int(10) unsigned not null primary key auto_increment,
roomNum int unsigned not null,
`floor` int unsigned not null,
`type` int unsigned not null,
bookingDate date,
booked char(100) not null,
dayOfSelect date not null
)

select * from room;
desc room;

--1일치 분량, 총 일주일 치 만들어야함
insert into room set roomNum = 1, `floor` = 3, `type` = 1, booked = "예약가능", dayOfSelect = curdate();
INSERT INTO room SET roomNum = 2, `floor` = 3, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE();
INSERT INTO room SET roomNum = 3, `floor` = 3, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE();
INSERT INTO room SET roomNum = 4, `floor` = 3, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE();
INSERT INTO room SET roomNum = 5, `floor` = 3, `type` = 1, booked = "예약불가", dayOfSelect = CURDATE();
INSERT INTO room SET roomNum = 1, `floor` = 4, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE();
INSERT INTO room SET roomNum = 2, `floor` = 4, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE();
INSERT INTO room SET roomNum = 3, `floor` = 4, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE();
INSERT INTO room SET roomNum = 4, `floor` = 4, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE();
INSERT INTO room SET roomNum = 5, `floor` = 4, `type` = 1, booked = "예약불가", dayOfSelect = CURDATE();
INSERT INTO room SET roomNum = 1, `floor` = 5, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE();
INSERT INTO room SET roomNum = 2, `floor` = 5, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE();
INSERT INTO room SET roomNum = 3, `floor` = 5, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE();
INSERT INTO room SET roomNum = 4, `floor` = 5, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE();
INSERT INTO room SET roomNum = 5, `floor` = 5, `type` = 1, booked = "예약불가", dayOfSelect = CURDATE();

INSERT INTO room SET roomNum = 1, `floor` = 3, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + interval 1 day;
INSERT INTO room SET roomNum = 2, `floor` = 3, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 1 DAY;
INSERT INTO room SET roomNum = 3, `floor` = 3, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 1 DAY;
INSERT INTO room SET roomNum = 4, `floor` = 3, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 1 DAY;
INSERT INTO room SET roomNum = 5, `floor` = 3, `type` = 1, booked = "예약불가", dayOfSelect = CURDATE() + INTERVAL 1 DAY;
INSERT INTO room SET roomNum = 1, `floor` = 4, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 1 DAY;
INSERT INTO room SET roomNum = 2, `floor` = 4, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 1 DAY;
INSERT INTO room SET roomNum = 3, `floor` = 4, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 1 DAY;
INSERT INTO room SET roomNum = 4, `floor` = 4, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 1 DAY;
INSERT INTO room SET roomNum = 5, `floor` = 4, `type` = 1, booked = "예약불가", dayOfSelect = CURDATE() + INTERVAL 1 DAY;
INSERT INTO room SET roomNum = 1, `floor` = 5, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 1 DAY;
INSERT INTO room SET roomNum = 2, `floor` = 5, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 1 DAY;
INSERT INTO room SET roomNum = 3, `floor` = 5, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 1 DAY;
INSERT INTO room SET roomNum = 4, `floor` = 5, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 1 DAY;
INSERT INTO room SET roomNum = 5, `floor` = 5, `type` = 1, booked = "예약불가", dayOfSelect = CURDATE() + INTERVAL 1 DAY;

INSERT INTO room SET roomNum = 1, `floor` = 3, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 2 DAY;
INSERT INTO room SET roomNum = 2, `floor` = 3, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 2 DAY;
INSERT INTO room SET roomNum = 3, `floor` = 3, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 2 DAY;
INSERT INTO room SET roomNum = 4, `floor` = 3, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 2 DAY;
INSERT INTO room SET roomNum = 5, `floor` = 3, `type` = 1, booked = "예약불가", dayOfSelect = CURDATE() + INTERVAL 2 DAY;
INSERT INTO room SET roomNum = 1, `floor` = 4, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 2 DAY;
INSERT INTO room SET roomNum = 2, `floor` = 4, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 2 DAY;
INSERT INTO room SET roomNum = 3, `floor` = 4, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 2 DAY;
INSERT INTO room SET roomNum = 4, `floor` = 4, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 2 DAY;
INSERT INTO room SET roomNum = 5, `floor` = 4, `type` = 1, booked = "예약불가", dayOfSelect = CURDATE() + INTERVAL 2 DAY;
INSERT INTO room SET roomNum = 1, `floor` = 5, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 2 DAY;
INSERT INTO room SET roomNum = 2, `floor` = 5, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 2 DAY;
INSERT INTO room SET roomNum = 3, `floor` = 5, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 2 DAY;
INSERT INTO room SET roomNum = 4, `floor` = 5, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 2 DAY;
INSERT INTO room SET roomNum = 5, `floor` = 5, `type` = 1, booked = "예약불가", dayOfSelect = CURDATE() + INTERVAL 2 DAY;

INSERT INTO room SET roomNum = 1, `floor` = 3, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 3 DAY;
INSERT INTO room SET roomNum = 2, `floor` = 3, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 3 DAY;
INSERT INTO room SET roomNum = 3, `floor` = 3, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 3 DAY;
INSERT INTO room SET roomNum = 4, `floor` = 3, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 3 DAY;
INSERT INTO room SET roomNum = 5, `floor` = 3, `type` = 1, booked = "예약불가", dayOfSelect = CURDATE() + INTERVAL 3 DAY;
INSERT INTO room SET roomNum = 1, `floor` = 4, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 3 DAY;
INSERT INTO room SET roomNum = 2, `floor` = 4, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 3 DAY;
INSERT INTO room SET roomNum = 3, `floor` = 4, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 3 DAY;
INSERT INTO room SET roomNum = 4, `floor` = 4, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 3 DAY;
INSERT INTO room SET roomNum = 5, `floor` = 4, `type` = 1, booked = "예약불가", dayOfSelect = CURDATE() + INTERVAL 3 DAY;
INSERT INTO room SET roomNum = 1, `floor` = 5, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 3 DAY;
INSERT INTO room SET roomNum = 2, `floor` = 5, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 3 DAY;
INSERT INTO room SET roomNum = 3, `floor` = 5, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 3 DAY;
INSERT INTO room SET roomNum = 4, `floor` = 5, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 3 DAY;
INSERT INTO room SET roomNum = 5, `floor` = 5, `type` = 1, booked = "예약불가", dayOfSelect = CURDATE() + INTERVAL 3 DAY;

INSERT INTO room SET roomNum = 1, `floor` = 3, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 4 DAY;
INSERT INTO room SET roomNum = 2, `floor` = 3, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 4 DAY;
INSERT INTO room SET roomNum = 3, `floor` = 3, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 4 DAY;
INSERT INTO room SET roomNum = 4, `floor` = 3, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 4 DAY;
INSERT INTO room SET roomNum = 5, `floor` = 3, `type` = 1, booked = "예약불가", dayOfSelect = CURDATE() + INTERVAL 4 DAY;
INSERT INTO room SET roomNum = 1, `floor` = 4, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 4 DAY;
INSERT INTO room SET roomNum = 2, `floor` = 4, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 4 DAY;
INSERT INTO room SET roomNum = 3, `floor` = 4, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 4 DAY;
INSERT INTO room SET roomNum = 4, `floor` = 4, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 4 DAY;
INSERT INTO room SET roomNum = 5, `floor` = 4, `type` = 1, booked = "예약불가", dayOfSelect = CURDATE() + INTERVAL 4 DAY;
INSERT INTO room SET roomNum = 1, `floor` = 5, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 4 DAY;
INSERT INTO room SET roomNum = 2, `floor` = 5, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 4 DAY;
INSERT INTO room SET roomNum = 3, `floor` = 5, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 4 DAY;
INSERT INTO room SET roomNum = 4, `floor` = 5, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 4 DAY;
INSERT INTO room SET roomNum = 5, `floor` = 5, `type` = 1, booked = "예약불가", dayOfSelect = CURDATE() + INTERVAL 4 DAY;

INSERT INTO room SET roomNum = 1, `floor` = 3, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 5 DAY;
INSERT INTO room SET roomNum = 2, `floor` = 3, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 5 DAY;
INSERT INTO room SET roomNum = 3, `floor` = 3, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 5 DAY;
INSERT INTO room SET roomNum = 4, `floor` = 3, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 5 DAY;
INSERT INTO room SET roomNum = 5, `floor` = 3, `type` = 1, booked = "예약불가", dayOfSelect = CURDATE() + INTERVAL 5 DAY;
INSERT INTO room SET roomNum = 1, `floor` = 4, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 5 DAY;
INSERT INTO room SET roomNum = 2, `floor` = 4, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 5 DAY;
INSERT INTO room SET roomNum = 3, `floor` = 4, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 5 DAY;
INSERT INTO room SET roomNum = 4, `floor` = 4, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 5 DAY;
INSERT INTO room SET roomNum = 5, `floor` = 4, `type` = 1, booked = "예약불가", dayOfSelect = CURDATE() + INTERVAL 5 DAY;
INSERT INTO room SET roomNum = 1, `floor` = 5, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 5 DAY;
INSERT INTO room SET roomNum = 2, `floor` = 5, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 5 DAY;
INSERT INTO room SET roomNum = 3, `floor` = 5, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 5 DAY;
INSERT INTO room SET roomNum = 4, `floor` = 5, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 5 DAY;
INSERT INTO room SET roomNum = 5, `floor` = 5, `type` = 1, booked = "예약불가", dayOfSelect = CURDATE() + INTERVAL 5 DAY;

INSERT INTO room SET roomNum = 1, `floor` = 3, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 6 DAY;
INSERT INTO room SET roomNum = 2, `floor` = 3, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 6 DAY;
INSERT INTO room SET roomNum = 3, `floor` = 3, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 6 DAY;
INSERT INTO room SET roomNum = 4, `floor` = 3, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 6 DAY;
INSERT INTO room SET roomNum = 5, `floor` = 3, `type` = 1, booked = "예약불가", dayOfSelect = CURDATE() + INTERVAL 6 DAY;
INSERT INTO room SET roomNum = 1, `floor` = 4, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 6 DAY;
INSERT INTO room SET roomNum = 2, `floor` = 4, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 6 DAY;
INSERT INTO room SET roomNum = 3, `floor` = 4, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 6 DAY;
INSERT INTO room SET roomNum = 4, `floor` = 4, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 6 DAY;
INSERT INTO room SET roomNum = 5, `floor` = 4, `type` = 1, booked = "예약불가", dayOfSelect = CURDATE() + INTERVAL 6 DAY;
INSERT INTO room SET roomNum = 1, `floor` = 5, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 6 DAY;
INSERT INTO room SET roomNum = 2, `floor` = 5, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 6 DAY;
INSERT INTO room SET roomNum = 3, `floor` = 5, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 6 DAY;
INSERT INTO room SET roomNum = 4, `floor` = 5, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 6 DAY;
INSERT INTO room SET roomNum = 5, `floor` = 5, `type` = 1, booked = "예약불가", dayOfSelect = CURDATE() + INTERVAL 6 DAY;

INSERT INTO room SET roomNum = 1, `floor` = 3, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 7 DAY;
INSERT INTO room SET roomNum = 2, `floor` = 3, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 7 DAY;
INSERT INTO room SET roomNum = 3, `floor` = 3, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 7 DAY;
INSERT INTO room SET roomNum = 4, `floor` = 3, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 7 DAY;
INSERT INTO room SET roomNum = 5, `floor` = 3, `type` = 1, booked = "예약불가", dayOfSelect = CURDATE() + INTERVAL 7 DAY;
INSERT INTO room SET roomNum = 1, `floor` = 4, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 7 DAY;
INSERT INTO room SET roomNum = 2, `floor` = 4, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 7 DAY;
INSERT INTO room SET roomNum = 3, `floor` = 4, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 7 DAY;
INSERT INTO room SET roomNum = 4, `floor` = 4, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 7 DAY;
INSERT INTO room SET roomNum = 5, `floor` = 4, `type` = 1, booked = "예약불가", dayOfSelect = CURDATE() + INTERVAL 7 DAY;
INSERT INTO room SET roomNum = 1, `floor` = 5, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 7 DAY;
INSERT INTO room SET roomNum = 2, `floor` = 5, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 7 DAY;
INSERT INTO room SET roomNum = 3, `floor` = 5, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 7 DAY;
INSERT INTO room SET roomNum = 4, `floor` = 5, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 7 DAY;
INSERT INTO room SET roomNum = 5, `floor` = 5, `type` = 1, booked = "예약불가", dayOfSelect = CURDATE() + INTERVAL 7 DAY;