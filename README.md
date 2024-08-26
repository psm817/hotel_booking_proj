## 🚀프로젝트 명 : BookingTel
- DB PORT : 3306
- DB username : sbsst
- 데이터베이스 이름 : hotel_proj

## 📢 프로젝트 개요
- Java를 이용한 콘솔 프로그램 제작
- 호텔 숙박 예약 및 관리(확인, 예약 취소) 기능 제공
- 숙박 후 객실에 대한 리뷰 작성 기능 제공

## ⏱️개발 기간
- 전체 개발 기간 : 2024-04-03 ~ 2024-04-23
- 기능 구현 : 2024-04-03 ~ 2024-04-23

## ⚙ 개발 환경
- 운영체제 : Windows 11
- 통합개발환경(IDE) : IntelliJ
- JDK 버전 : JDK 21
- 데이터베이스 : MySQL


## 🔌 Dependencies
- Lombok
- mysql-connector


## 💻 기술 스택
- 백엔드
    - Java
- 데이터베이스
    - MariaDB, MySQL Workbench
    - MySQL, SQLyog, DBeaver


## 🛠 DB 설계
- guest (손님)
- room (객실)
- booking (예약목록)
- review (리뷰)

<br>

| guest 테이블                                                                |
|--------------------------------------------------------------------------|
| <img src="src/main/resources/static/images/capture/apollon_ERD_최종찐.png"> |


| room 테이블                                                                 |
|--------------------------------------------------------------------------|
| <img src="src/main/resources/static/images/capture/apollon_ERD_최종찐.png"> |


| booking 테이블                                                              |
|--------------------------------------------------------------------------|
| <img src="src/main/resources/static/images/capture/apollon_ERD_최종찐.png"> |


| review 테이블                                                               |
|--------------------------------------------------------------------------|
| <img src="src/main/resources/static/images/capture/apollon_ERD_최종찐.png"> |

<br>

## 🧑‍🏫 역할 분담 (개인 프로젝트)

### 🚅 박상민
- **기능**
    - 호텔 예약 관리 프로그램 전체 서비스 모음집 제공
    - 아스키 아트를 이용한 호텔 형상 표시
    - 객실 조회, 예약 기능 구현
    - 개인별 숙박 예약 확인 및 취소 기능 구현
    - ID, PW만을 이용한 회원가입 및 로그인/로그아웃 구현
    - 리뷰 조회 및 리뷰 작성 기능 구현
    - 숙박 리뷰를 html로 추출해서 확인 가능

<br>

## 프로젝트 전체 구조

```
├── README.md
├── build.gradle
├── .gitignore
├── gradlew.bat
├── gradlew
│
└── src.main
     ├── java.org.example
           ├── App.java
           ├── Main.java
                  ├── container
                          ├── Container.java
                  ├── controller
                          ├── BookingController.java
                          ├── Controller.java
                          ├── ExportController.java
                          ├── GuestController.java
                          ├── HotelController.java
                          ├── ReviewController.java
                          ├── RoomController.java
                          ├── Session.java
                  ├── dao
                          ├── BookingDao.java
                          ├── Dao.java
                          ├── GuestDao.java
                          ├── ReviewDao.java
                          ├── RoomDao.java
                  ├── db
                          ├── db.sql
                          ├── DBConnection.java
                          ├── hotel_proj_db_data.sql
                  ├── dto
                          ├── Booking.java
                          ├── Dto.java
                          ├── Guest.java
                          ├── Review.java
                          ├── Room.java
                  ├── service
                          ├── BookingService.java
                          ├── ExportService.java
                          ├── GuestService.java
                          ├── ReviewService.java
                          ├── RoomService.java
                  ├── util
                          ├── Util.java
```

## 기능 상세 소개

### [프로그램 시작 및 호텔 소개]
- 프로그램 시작
    - 시작과 동시에 서비스 모음집 제공
    - 원하는 서비스를 콘솔에 입력 가능
    - 서비스 모음집을 다시 보고 싶다면 'service' 입력
- 호텔 소개
    - 서비스 명령어 : hotel introduce
    - 로그인 여부와 관계없이 모두 열람 가능
    - 호탤의 상호명, 위치, 전화번호, 영업시간, 객실 정보, 호텔 정책 등 간단한 정보 제공
    - 아스키 아트를 활용한 객실 배치도 제공

| 프로그램 시작 및 호텔 소개                                               |
|---------------------------------------------------------------|
| <img src="src/main/resources/static/images/capture/메인화면.png"> |

<br>

### [회원가입]
- 서비스 명령어 : guest join
- 로그아웃 상태에서만 서비스 이용 가능
- 회원가입 시 필요한 ID와 PW 입력
- 입력한 ID가 등록한 회원의 ID와 중복될 시 회원가입 실패
- PW 입력 시 PW 확인 진행하며 두 PW가 일치하지 않을 시 회원가입 실패
- 회원가입 성공 시 회원목록에 해당 회원이 추가

| 회원가입                                                               |
|--------------------------------------------------------------------|
| <img src="src/main/resources/static/images/capture/회원가입-약관동의.png"> |

<br>

### [로그인/로그아웃]
- 서비스 명령어 : guest login / guest logout
- 로그아웃 상태에서만 서비스 이용 가능
- 회원가입 시 입력한 ID, PW 입력
- 등록된 회원 중 ID가 존재하지 않거나 PW가 일치하지 않으면 로그인 실패
- 로그아웃은 로그인 상태에서만 이용 가능

| 로그인                                                          |
|--------------------------------------------------------------|
| <img src="src/main/resources/static/images/capture/로그인.png"> |

<br>

### [객실 조회]
- 서비스 명령어 : room list
- 로그인 여부와 관계없이 모두 객실 조회 가능
- 호텔에 배치된 모든 객실의 예약 상태를 조회
- 원하는 날짜 및 층별로 조회 가능
- 날짜 입력은 현재 날짜를 기준으로 일주일 간의 날짜만 입력 가능
- 조회가 가능한 층 수는 3~5층

| 객실 조회                                                          |
|----------------------------------------------------------------|
| <img src="src/main/resources/static/images/capture/마이페이지.png"> |

<br>

### [객실 예약]
- 서비스 명령어 : booking room
- 로그인 상태에서만 예약 서비스 이용 가능
- 숙박을 원하는 날짜 기간과 객실번호를 입력
- 예약 가능한 날짜 기간은 현재 날짜를 기준으로 일주일 내만 가능
- 해당 객실이 '예약불가' 상태면 서비스 종료
- '예약가능' 상태면 총 인원 체크와 함께 예상 결제 금액 계산
- 예약이 완료되면 해당 날짜 기간에 해당하는 객실의 예약여부를 '예약불가' 상태로 변경 및 예약목록 추가

| 객실 예약                                                         |
|---------------------------------------------------------------|
| <img src="src/main/resources/static/images/capture/로그아웃.png"> |

<br>

### [예약 확인]
- 서비스 명령어 : booking check
- 로그인 상태에서만 예약 확인 서비스 이용 가능
- 서비스 입력과 동시에 총 몇 건의 예약이 있는지 안내
- 관리자의 경우, 모든 회원의 예약 이력을 표시
- 일반 회원의 경우, 본인의 모든 예약 이력을 표시
- 1건 이상의 예약 목록이 있는 경우, 상세보기를 원하는 지 질문
- 상세보기를 원한다면 해당 회원이 예약한 객실 정보와 예상 결제 금액을 표시

| 예약 확인                                                              |
|--------------------------------------------------------------------|
| <img src="src/main/resources/static/images/capture/차트목록-탑100.png"> |

<br>

### [예약 취소]
- 서비스 명령어 : booking delete
- 로그인 상태에서만 예약 취소 서비스 이용 가능
- 서비스 입력과 동시에 총 몇 건의 취소 가능한 예약이 있는지 안내
- 현재 날짜를 기준으로 숙박을 진행 중이거나 완료한 예약 건은 표시되지 않음
- 관리자의 경우, 모든 회원의 예약 취소 기능 부여
- 일반 회원인 경우, 본인이 예약한 목록만 취소 가능
- 1건 이상의 취소 가능한 예약 목록이 있는 경우, 해당 예약 목록을 표시
- 예약 취소를 진행하면 해당 날짜 기간에 해당하는 객실의 예약여부를 '예약가능' 상태로 변경 및 예약목록에서 제거

| 예약 취소                                                          |
|----------------------------------------------------------------|
| <img src="src/main/resources/static/images/capture/음악 검색.png"> |

<br>

### [리뷰 조회]
- 서비스 명령어 : review list
- 로그인 여부와 관계없이 모두 조회 가능
- 평균 평점 및 전체 리뷰 목록 표시

| 리뷰 조회                                                           |
|-----------------------------------------------------------------|
| <img src="src/main/resources/static/images/capture/플레이리스트.png"> |

<br>

### [리뷰 작성]
- 서비스 명령어 : review write
- 로그인 상태에서만 서비스 이용 가능
- 서비스 입력과 동시에 총 몇 건의 리뷰 작성 가능한 예약이 있는지 안내
- 현재 날짜를 기준으로 숙박이 예정되어 있거나, 숙박 진행 중인 예약 건은 표시되지 않음
- 1건 이상의 리뷰 작성이 가능한 예약 목록이 있는 경우, 해당 예약 목록을 표시
- 리뷰 작성을 원하면 평점 부여와 리뷰 내용 작성 진행
- 리뷰 작성이 끝나면 리뷰 목록에 추가

| 리뷰 작성                                                         |
|---------------------------------------------------------------|
| <img src="src/main/resources/static/images/capture/커뮤니티.png"> |

<br>

### [html 추출]
- 서비스 명령어 : export html
- 로그인 여부와 관계없이 모두 조회 가능
- 전체 리뷰 목록에 대해서 건 당 html 파일을 하나씩 추출

| html 추출                                                       |
|---------------------------------------------------------------|
| <img src="src/main/resources/static/images/capture/스튜디오.png"> |

<br>

## 트러블 슈팅

- 객실을 예약하거나 취소 또는 조회할 때 현재 서버 시간을 기준으로 일주일 전 후의 시간만 가능하도록 조회하는 데 어려움을 겪었지만, util 패키지에 날짜와 관련된 메서드를 활용해서 문제를 해결함

<br>

## 프로젝트를 마치며..

### 🚅 박상민

Java라는 프로그래밍 언어를 거의 처음 접하고 난 뒤의 진행한 첫 개인 프로젝트여서 남들이 보기엔 단순한 기능일지라도 주어진 시간 안에 완성할 수 있을까 라는 생각이 들었습니다.
걱정과는 다르게 원할하게 기능 구현이 진행되었던 것 같고, 구현을 하는 내내 만약 내가 이 프로그램의 사용자라면 어떤 기능일 필요헀을까를 생각하면서 최대한 섬세하게 작업에 임했습니다.
비록 아직은 콘솔로만 기능을 볼 수 있다는 한계점이 있지만, 이 프로젝트를 시작으로 Java를 비롯한 웹 프레임워크를 탄탄하게 익혀서 하루 빨리 웹 프로그래밍을 구현하고 싶어졌습니다.
개발 기간동안 코딩에 대한 흥미를 잃을까봐 걱정도 했지만 너무 재밌게 진행한 것 같아서 스스로에게 뿌듯하고, 팀 프로젝트도 하루빨리 진행해보고 싶습니다.

<br>

## 🔗Link

[프로젝트 완성 및 시연 영상](https://web-app-programmer.tistory.com/142)

