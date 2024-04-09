package org.example;

import org.example.container.Container;
import org.example.controller.*;
import org.example.db.DBConnection;
import org.example.util.Util;

import java.util.Scanner;

public class App {
    public App() {
        DBConnection.DB_NAME = "hotel_proj";
        DBConnection.DB_USER = "sbsst";
        DBConnection.DB_PASSWORD = "sbs123414";
        DBConnection.DB_PORT = 3306;

        Container.getDBConnection().connect();
    }
    public void start() {
        callAllServices();

        HotelController hotelController = new HotelController();
        RoomController roomController = new RoomController();
        BookingController bookingController = new BookingController();
        GuestController guestController = new GuestController();

        Scanner sc = new Scanner(System.in);

        roomController.makeTestData();
        guestController.makeTestGuest();

        while(true) {
            System.out.print("서비스를 입력해주세요) ");
            String cmd = sc.nextLine();
            cmd = cmd.trim();

            if(cmd.length() == 0) {
                continue;
            }

            if(cmd.equals("exit")) {
                break;
            }

            if(cmd.equals("service")) {
                callAllServices();
                continue;
            }

            String[] cmdBits = cmd.split(" ");

            if(cmdBits.length == 1) {
                System.out.println("존재하지 않는 서비스입니다.");
                continue;
            }

            String controllerName = cmdBits[0];
            String actionMethodName = cmdBits[1];

            Controller controller = null;

            if(controllerName.equals("hotel")) {
                controller = hotelController;
            }
            else if(controllerName.equals("room")) {
                controller = roomController;
            }
            else if(controllerName.equals("booking")) {
                controller = bookingController;
            }
            else if(controllerName.equals("guest")) {
                controller = guestController;
            }
            else {
                System.out.println("존재하지 않는 서비스입니다.");
                continue;
            }

            String actionName = controllerName + "/" + actionMethodName;

            // 로그인을 요구하는 서비스
            switch(actionName) {
                case "booking/room" :
                case "booking/check" :
                case "booking/delete" :
                case "guest/logout" :
                case "booking/review" :
                    if(Container.getSession().isLogined() == false) {
                        System.out.println("로그인 후 이용가능합니다.");
                        continue;
                    }
                    break;
            }

            // 로그아웃을 요구하는 서비스
            switch(actionName) {
                case "guest/join" :
                case "guest/login" :
                    if(Container.getSession().isLogined()) {
                        System.out.println("로그아웃 후 이용가능합니다.");
                        continue;
                    }
                    break;
            }

            controller.doAction(cmd, actionMethodName);

        }

        sc.close();
        Container.getDBConnection().close();
        System.out.println("감사합니다. 다음에 또 방문해주세요.");
    }

    private void callAllServices() {
        System.out.println("호텔 예약 관리 시스템에 오신 것을 환영합니다.");
        System.out.printf("오늘 날짜 : %s", Util.getTodayDate());
        System.out.printf("\n");
        System.out.println("=============== 서비스 모음 ===============");
        System.out.println("1. 호텔 소개 : hotel introduce (필독바람!!)");
        System.out.println("2. 객실 조회하기 : room list");
        System.out.println("3. 객실 예약하기 : booking room");        // id, roomId, floor, guestName, guestPhone, type, regDate
        System.out.println("4. 예약 확인하기 : booking check");
        System.out.println("5. 예약 취소 : booking delete");
        System.out.println("6. 로그인/로그아웃 : guest login/logout");
        System.out.println("7. 회원 가입 : guest join");
        System.out.println("8. 리뷰 남기기 : booking review");
        System.out.println("9. 서비스 다시보기 : service");
        System.out.println("===========================================");
        System.out.printf("\n");
    }
}
