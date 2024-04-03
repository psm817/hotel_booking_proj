package org.example.controller;

import org.example.dto.Room;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class RoomController extends Controller {
    private Scanner sc;
    private String cmd;
    List<Room> rooms;

    public RoomController() {
        sc = new Scanner(System.in);
        rooms = new ArrayList<>();
    }

    public void doAction(String cmd, String actionMethodName) {
        this.cmd = cmd;

        switch(actionMethodName) {
            case "list" :
                showList();
                break;
            case "booking" :
                doBooking();
                break;
            default :
                System.out.println("존재하지 않는 서비스입니다.");
                break;
        }
    }

    private void showList() {
        System.out.print("층 수를 입력해주세요) ");
        int floor = sc.nextInt();
        sc.nextLine();

        if(floor == 3) {
            List<Room> forPrintRooms = rooms;

            System.out.println("============= 3층 객실 현황 =============");
            System.out.println("객실 호수 | 객실 타입 | 예약 날짜 | 예약 상태");

            for(int i = 0; i < forPrintRooms.size(); i++) {
                Room room = forPrintRooms.get(i);
                System.out.printf("30%d | %s | %s | %s", room.id, room.type, room.bookingDate, room.booked);
            }
        }

        else if(floor == 4) {
            List<Room> forPrintRooms = rooms;

            System.out.println("============= 4층 객실 현황 =============");
            System.out.println("객실 호수 | 객실 타입 | 예약 날짜 | 예약 상태");

            for(int i = 0; i < forPrintRooms.size(); i++) {
                Room room = forPrintRooms.get(i);
                System.out.printf("40%d | %s | %s | %s", room.id, room.type, room.bookingDate, room.booked);
            }
        }

        else if(floor == 5) {
            List<Room> forPrintRooms = rooms;

            System.out.println("============= 5층 객실 현황 =============");
            System.out.println("객실 호수 | 객실 타입 | 예약 날짜 | 예약 상태");

            for(int i = 0; i < forPrintRooms.size(); i++) {
                Room room = forPrintRooms.get(i);
                System.out.printf("50%d | %s | %s | %s", room.id, room.type, room.bookingDate, room.booked);
            }
        }

        else {
            System.out.println("층 수를 잘못 입력하셨습니다.");
        }
    }

    private void doBooking() {
    }
}
