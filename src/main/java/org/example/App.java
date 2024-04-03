package org.example;

import org.example.controller.*;

import java.util.Scanner;

public class App {
    public void start() {
        System.out.println("호텔 예약 관리 시스템에 오신 것을 환영합니다.");
        System.out.printf("\n");
        System.out.println("=============== 서비스 모음 ===============");
        System.out.println("1. 호텔 소개 : hotel introduce");
        System.out.println("2. 방 조회하기 : room list");
        System.out.println("3. 방 예약하기 : room booking");
        System.out.println("4. 예약 확인하기 : booking check");
        System.out.println("5. 예약정보 수정 : booking modify");
        System.out.println("6. 예약 취소 : booking delete");
        System.out.println("7. 로그인/로그아웃 : guset login/logout");
        System.out.println("8. 회원 가입 : guset join");
        System.out.println("===========================================");
        System.out.printf("\n");

        HotelController hotelController = new HotelController();
        RoomController roomController = new RoomController();
        BookingController bookingController = new BookingController();
        GusetController gusetController = new GusetController();

        Scanner sc = new Scanner(System.in);

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
            else if(controllerName.equals("guset")) {
                controller = gusetController;
            }
            else {
                System.out.println("존재하지 않는 서비스입니다.");
                continue;
            }

            String actionName = controllerName + "/" + actionMethodName;

            switch(actionName) {

            }

        }

        sc.close();
        System.out.println("감사합니다. 다음에 또 방문해주세요.");
    }
}
