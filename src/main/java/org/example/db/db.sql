--/* 데이터베이스 만들기 */
DROP DATABASE IF EXISTS hotel_proj;
CREATE DATABASE hotel_proj;
USE hotel_proj;

SHOW TABLES;

--/* booking 테이블 만들기 */
CREATE TABLE `booking` (
id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
checkInDate DATE NOT NULL,
checkOutDate DATE NOT NULL,
roomId INT(10) UNSIGNED NOT NULL,
guestName CHAR(100) NOT NULL,
guestPhone CHAR(100) NOT NULL,
roomType INT(10) UNSIGNED NOT NULL,
bookingPay INT UNSIGNED NOT NULL
);

SELECT * FROM booking;
DESC booking;

DROP TABLE booking;


--/* guest 테이블 및 샘플 만들기 */
CREATE TABLE `guest` (
id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
regDate DATETIME NOT NULL,
loginId CHAR(100) NOT NULL UNIQUE,
loginPw CHAR(100) NOT NULL,
`name` CHAR(100) NOT NULL,
email CHAR(100) NOT NULL,
phoneNum CHAR(100) NOT NULL
);

SELECT * FROM guest;
DESC guest;

DROP TABLE guest;

INSERT INTO guest SET regDate = NOW(), loginId = 'admin', loginPw = 'admin', `name` = '관리자', email = 'admin@gmail.com', phoneNum = '010-1234-5678';
INSERT INTO guest SET regDate = NOW(), loginId = 'user1', loginPw = 'user1', `name` = '김철수', email = 'user1@gmail.com', phoneNum = '010-1224-5838';
INSERT INTO guest SET regDate = NOW(), loginId = 'user2', loginPw = 'user2', `name` = '박영희', email = 'user2@gmail.com', phoneNum = '010-1234-9998';



--/* review 테이블 생성 */
CREATE TABLE review (
id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
regDate DATETIME NOT NULL,
bookingId INT UNSIGNED NOT NULL,
guestId INT UNSIGNED NOT NULL,
`body` TEXT NOT NULL,
score INT UNSIGNED NOT NULL
);

SELECT * FROM review;
DESC review;

DROP TABLE review;


--/* room 테이블 및 일주일치 방 생성 */
CREATE TABLE room (
id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
roomNum INT UNSIGNED NOT NULL,
`floor` INT UNSIGNED NOT NULL,
`type` INT UNSIGNED NOT NULL,
checkInDate CHAR(100),
checkOutDate CHAR(100),
booked CHAR(100) NOT NULL,
dayOfSelect DATE NOT NULL
);

SELECT * FROM room;
SELECT COUNT(*) FROM room;
DESC room;

DROP TABLE room;

--/* 1일치 분량, 총 일주일 치 만들어야함 */
INSERT INTO room SET roomNum = 1, `floor` = 3, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE();
INSERT INTO room SET roomNum = 2, `floor` = 3, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE();
INSERT INTO room SET roomNum = 3, `floor` = 3, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE();
INSERT INTO room SET roomNum = 4, `floor` = 3, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE();
INSERT INTO room SET roomNum = 5, `floor` = 3, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE();
INSERT INTO room SET roomNum = 1, `floor` = 4, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE();
INSERT INTO room SET roomNum = 2, `floor` = 4, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE();
INSERT INTO room SET roomNum = 3, `floor` = 4, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE();
INSERT INTO room SET roomNum = 4, `floor` = 4, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE();
INSERT INTO room SET roomNum = 5, `floor` = 4, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE();
INSERT INTO room SET roomNum = 1, `floor` = 5, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE();
INSERT INTO room SET roomNum = 2, `floor` = 5, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE();
INSERT INTO room SET roomNum = 3, `floor` = 5, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE();
INSERT INTO room SET roomNum = 4, `floor` = 5, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE();
INSERT INTO room SET roomNum = 5, `floor` = 5, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE();

INSERT INTO room SET roomNum = 1, `floor` = 3, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 1 DAY;
INSERT INTO room SET roomNum = 2, `floor` = 3, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 1 DAY;
INSERT INTO room SET roomNum = 3, `floor` = 3, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 1 DAY;
INSERT INTO room SET roomNum = 4, `floor` = 3, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 1 DAY;
INSERT INTO room SET roomNum = 5, `floor` = 3, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 1 DAY;
INSERT INTO room SET roomNum = 1, `floor` = 4, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 1 DAY;
INSERT INTO room SET roomNum = 2, `floor` = 4, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 1 DAY;
INSERT INTO room SET roomNum = 3, `floor` = 4, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 1 DAY;
INSERT INTO room SET roomNum = 4, `floor` = 4, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 1 DAY;
INSERT INTO room SET roomNum = 5, `floor` = 4, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 1 DAY;
INSERT INTO room SET roomNum = 1, `floor` = 5, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 1 DAY;
INSERT INTO room SET roomNum = 2, `floor` = 5, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 1 DAY;
INSERT INTO room SET roomNum = 3, `floor` = 5, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 1 DAY;
INSERT INTO room SET roomNum = 4, `floor` = 5, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 1 DAY;
INSERT INTO room SET roomNum = 5, `floor` = 5, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 1 DAY;

INSERT INTO room SET roomNum = 1, `floor` = 3, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 2 DAY;
INSERT INTO room SET roomNum = 2, `floor` = 3, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 2 DAY;
INSERT INTO room SET roomNum = 3, `floor` = 3, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 2 DAY;
INSERT INTO room SET roomNum = 4, `floor` = 3, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 2 DAY;
INSERT INTO room SET roomNum = 5, `floor` = 3, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 2 DAY;
INSERT INTO room SET roomNum = 1, `floor` = 4, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 2 DAY;
INSERT INTO room SET roomNum = 2, `floor` = 4, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 2 DAY;
INSERT INTO room SET roomNum = 3, `floor` = 4, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 2 DAY;
INSERT INTO room SET roomNum = 4, `floor` = 4, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 2 DAY;
INSERT INTO room SET roomNum = 5, `floor` = 4, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 2 DAY;
INSERT INTO room SET roomNum = 1, `floor` = 5, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 2 DAY;
INSERT INTO room SET roomNum = 2, `floor` = 5, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 2 DAY;
INSERT INTO room SET roomNum = 3, `floor` = 5, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 2 DAY;
INSERT INTO room SET roomNum = 4, `floor` = 5, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 2 DAY;
INSERT INTO room SET roomNum = 5, `floor` = 5, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 2 DAY;

INSERT INTO room SET roomNum = 1, `floor` = 3, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 3 DAY;
INSERT INTO room SET roomNum = 2, `floor` = 3, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 3 DAY;
INSERT INTO room SET roomNum = 3, `floor` = 3, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 3 DAY;
INSERT INTO room SET roomNum = 4, `floor` = 3, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 3 DAY;
INSERT INTO room SET roomNum = 5, `floor` = 3, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 3 DAY;
INSERT INTO room SET roomNum = 1, `floor` = 4, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 3 DAY;
INSERT INTO room SET roomNum = 2, `floor` = 4, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 3 DAY;
INSERT INTO room SET roomNum = 3, `floor` = 4, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 3 DAY;
INSERT INTO room SET roomNum = 4, `floor` = 4, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 3 DAY;
INSERT INTO room SET roomNum = 5, `floor` = 4, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 3 DAY;
INSERT INTO room SET roomNum = 1, `floor` = 5, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 3 DAY;
INSERT INTO room SET roomNum = 2, `floor` = 5, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 3 DAY;
INSERT INTO room SET roomNum = 3, `floor` = 5, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 3 DAY;
INSERT INTO room SET roomNum = 4, `floor` = 5, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 3 DAY;
INSERT INTO room SET roomNum = 5, `floor` = 5, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 3 DAY;

INSERT INTO room SET roomNum = 1, `floor` = 3, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 4 DAY;
INSERT INTO room SET roomNum = 2, `floor` = 3, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 4 DAY;
INSERT INTO room SET roomNum = 3, `floor` = 3, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 4 DAY;
INSERT INTO room SET roomNum = 4, `floor` = 3, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 4 DAY;
INSERT INTO room SET roomNum = 5, `floor` = 3, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 4 DAY;
INSERT INTO room SET roomNum = 1, `floor` = 4, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 4 DAY;
INSERT INTO room SET roomNum = 2, `floor` = 4, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 4 DAY;
INSERT INTO room SET roomNum = 3, `floor` = 4, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 4 DAY;
INSERT INTO room SET roomNum = 4, `floor` = 4, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 4 DAY;
INSERT INTO room SET roomNum = 5, `floor` = 4, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 4 DAY;
INSERT INTO room SET roomNum = 1, `floor` = 5, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 4 DAY;
INSERT INTO room SET roomNum = 2, `floor` = 5, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 4 DAY;
INSERT INTO room SET roomNum = 3, `floor` = 5, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 4 DAY;
INSERT INTO room SET roomNum = 4, `floor` = 5, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 4 DAY;
INSERT INTO room SET roomNum = 5, `floor` = 5, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 4 DAY;

INSERT INTO room SET roomNum = 1, `floor` = 3, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 5 DAY;
INSERT INTO room SET roomNum = 2, `floor` = 3, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 5 DAY;
INSERT INTO room SET roomNum = 3, `floor` = 3, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 5 DAY;
INSERT INTO room SET roomNum = 4, `floor` = 3, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 5 DAY;
INSERT INTO room SET roomNum = 5, `floor` = 3, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 5 DAY;
INSERT INTO room SET roomNum = 1, `floor` = 4, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 5 DAY;
INSERT INTO room SET roomNum = 2, `floor` = 4, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 5 DAY;
INSERT INTO room SET roomNum = 3, `floor` = 4, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 5 DAY;
INSERT INTO room SET roomNum = 4, `floor` = 4, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 5 DAY;
INSERT INTO room SET roomNum = 5, `floor` = 4, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 5 DAY;
INSERT INTO room SET roomNum = 1, `floor` = 5, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 5 DAY;
INSERT INTO room SET roomNum = 2, `floor` = 5, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 5 DAY;
INSERT INTO room SET roomNum = 3, `floor` = 5, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 5 DAY;
INSERT INTO room SET roomNum = 4, `floor` = 5, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 5 DAY;
INSERT INTO room SET roomNum = 5, `floor` = 5, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 5 DAY;

INSERT INTO room SET roomNum = 1, `floor` = 3, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 6 DAY;
INSERT INTO room SET roomNum = 2, `floor` = 3, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 6 DAY;
INSERT INTO room SET roomNum = 3, `floor` = 3, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 6 DAY;
INSERT INTO room SET roomNum = 4, `floor` = 3, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 6 DAY;
INSERT INTO room SET roomNum = 5, `floor` = 3, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 6 DAY;
INSERT INTO room SET roomNum = 1, `floor` = 4, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 6 DAY;
INSERT INTO room SET roomNum = 2, `floor` = 4, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 6 DAY;
INSERT INTO room SET roomNum = 3, `floor` = 4, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 6 DAY;
INSERT INTO room SET roomNum = 4, `floor` = 4, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 6 DAY;
INSERT INTO room SET roomNum = 5, `floor` = 4, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 6 DAY;
INSERT INTO room SET roomNum = 1, `floor` = 5, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 6 DAY;
INSERT INTO room SET roomNum = 2, `floor` = 5, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 6 DAY;
INSERT INTO room SET roomNum = 3, `floor` = 5, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 6 DAY;
INSERT INTO room SET roomNum = 4, `floor` = 5, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 6 DAY;
INSERT INTO room SET roomNum = 5, `floor` = 5, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 6 DAY;


INSERT INTO room SET roomNum = 1, `floor` = 3, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 7 DAY;
INSERT INTO room SET roomNum = 2, `floor` = 3, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 7 DAY;
INSERT INTO room SET roomNum = 3, `floor` = 3, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 7 DAY;
INSERT INTO room SET roomNum = 4, `floor` = 3, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 7 DAY;
INSERT INTO room SET roomNum = 5, `floor` = 3, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 7 DAY;
INSERT INTO room SET roomNum = 1, `floor` = 4, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 7 DAY;
INSERT INTO room SET roomNum = 2, `floor` = 4, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 7 DAY;
INSERT INTO room SET roomNum = 3, `floor` = 4, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 7 DAY;
INSERT INTO room SET roomNum = 4, `floor` = 4, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 7 DAY;
INSERT INTO room SET roomNum = 5, `floor` = 4, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 7 DAY;
INSERT INTO room SET roomNum = 1, `floor` = 5, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 7 DAY;
INSERT INTO room SET roomNum = 2, `floor` = 5, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 7 DAY;
INSERT INTO room SET roomNum = 3, `floor` = 5, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 7 DAY;
INSERT INTO room SET roomNum = 4, `floor` = 5, `type` = 2, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 7 DAY;
INSERT INTO room SET roomNum = 5, `floor` = 5, `type` = 1, booked = "예약가능", dayOfSelect = CURDATE() + INTERVAL 7 DAY;
