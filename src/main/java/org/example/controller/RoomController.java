package org.example.controller;

import org.example.Util;
import org.example.dto.Room;

import java.time.format.DateTimeParseException;
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

    public void makeTestData() {
        rooms.add(new Room(1, 3, 1, null, "2024-04-04", "예약가능"));
        rooms.add(new Room(2, 3, 2, "2020-01-01", "2024-04-04", "예약불가"));
        rooms.add(new Room(3, 3, 1, "2020-01-01", "2024-04-04", "예약불가"));
        rooms.add(new Room(4, 3, 2, null, "2024-04-04", "예약가능"));
        rooms.add(new Room(5, 3, 1, "2020-01-01", "2024-04-04", "예약가능"));
        rooms.add(new Room(6, 3, 2, null, "2024-04-04", "예약가능"));
        rooms.add(new Room(7, 3, 1, "2020-01-01", "2024-04-04", "예약불가"));
        rooms.add(new Room(8, 3, 2, "2020-01-01", "2024-04-04", "예약불가"));
        rooms.add(new Room(9, 3, 1, null, "2024-04-04", "예약가능"));
        rooms.add(new Room(10, 3, 2, null, "2024-04-04", "예약가능"));

        rooms.add(new Room(1, 4, 1, null, "2024-04-04", "예약가능"));
        rooms.add(new Room(2, 4, 2, "2020-01-01", "2024-04-04", "예약불가"));
        rooms.add(new Room(3, 4, 1, "2020-01-01", "2024-04-04", "예약불가"));
        rooms.add(new Room(4, 4, 2, null, "2024-04-04", "예약가능"));
        rooms.add(new Room(5, 4, 1, "2020-01-01", "2024-04-04", "예약불가"));
        rooms.add(new Room(6, 4, 2, null, "2024-04-04", "예약가능"));
        rooms.add(new Room(7, 4, 1, "2020-01-01", "2024-04-04", "예약불가"));
        rooms.add(new Room(8, 4, 2, "2020-01-01", "2024-04-04", "예약불가"));
        rooms.add(new Room(9, 4, 1, "2020-01-01", "2024-04-04", "예약불가"));
        rooms.add(new Room(10, 4, 2, null, "2024-04-04", "예약가능"));

        rooms.add(new Room(1, 5, 1, null, "2024-04-04", "예약가능"));
        rooms.add(new Room(2, 5, 2, "2020-01-01", "2024-04-04", "예약불가"));
        rooms.add(new Room(3, 5, 1, "2020-01-01", "2024-04-04", "예약불가"));
        rooms.add(new Room(4, 5, 2, null, "2024-04-04", "예약가능"));
        rooms.add(new Room(5, 5, 1, "2020-01-01", "2024-04-04", "예약불가"));
        rooms.add(new Room(6, 5, 2, null, "2024-04-04", "예약가능"));
        rooms.add(new Room(7, 5, 1, "2020-01-01", "2024-04-04", "예약불가"));
        rooms.add(new Room(8, 5, 2, "2020-01-01", "2024-04-04", "예약불가"));
        rooms.add(new Room(9, 5, 1, null, "2024-04-04", "예약가능"));
        rooms.add(new Room(10, 5, 2, "2020-01-01", "2024-04-04", "예약불가"));
    }

    public void doAction(String cmd, String actionMethodName) {
        this.cmd = cmd;

        switch(actionMethodName) {
            case "list" :
                showList();
                break;
            default :
                System.out.println("존재하지 않는 서비스입니다.");
                break;
        }
    }

    private void showList() {
        System.out.print("확인하시고 싶은 날짜를 입력해주세요) ");
        String checkDate = sc.nextLine();

        if(Util.checkWeekDate(checkDate) == false) {
            System.out.println("현재 날짜 기준으로 일주일만 조회 가능합니다.");
            return;
        }

        System.out.print("층 수를 입력해주세요) ");
        String floor = sc.nextLine();

        List<Room> forPrintRooms = rooms;

        if(floor.equals("3")) {
            System.out.printf("==== [%s] 3층 객실 현황 ====\n", checkDate);
            System.out.println("호수 | 객실타입 | 상태");

            for(int i = 0; i < forPrintRooms.size(); i++) {
                Room room = forPrintRooms.get(i);

                if(room.dayOfSelect.equals(checkDate)) {
                    if(room.floor == 3) {
                        if(room.id != 10) {
                            System.out.printf("30%d  | %8s | %s\n", room.id, room.type, room.booked);
                        }
                        else {
                            System.out.printf("3%d  | %8s | %s\n", room.id, room.type, room.booked);
                        }
                    }
                }
                else {
                    System.out.println("조회된 객실이 없습니다.");
                    return;
                }
            }
        }

        else if(floor.equals("4")) {
            System.out.printf("==== [%s] 4층 객실 현황 ====\n", checkDate);
            System.out.println("호수 | 객실타입 | 상태");

            for(int i = 0; i < forPrintRooms.size(); i++) {
                Room room = forPrintRooms.get(i);

                if(room.dayOfSelect.equals(checkDate)) {
                    if(room.floor == 4) {
                        if(room.id != 10) {
                            System.out.printf("40%d  | %8s | %s\n", room.id, room.type, room.booked);
                        }
                        else {
                            System.out.printf("4%d  | %8s | %s\n", room.id, room.type, room.booked);
                        }
                    }
                }
                else {
                    System.out.println("조회된 객실이 없습니다.");
                    return;
                }
            }
        }

        else if(floor.equals("5")) {
            System.out.printf("==== [%s] 5층 객실 현황 ====\n", checkDate);
            System.out.println("호수 | 객실타입 | 상태");

            for(int i = 0; i < forPrintRooms.size(); i++) {
                Room room = forPrintRooms.get(i);

                if(room.dayOfSelect.equals(checkDate)) {
                    if(room.floor == 5) {
                        if(room.id != 10) {
                            System.out.printf("50%d  | %8s | %s\n", room.id, room.type, room.booked);
                        }
                        else {
                            System.out.printf("5%d  | %8s | %s\n", room.id, room.type, room.booked);
                        }
                    }
                }
                else {
                    System.out.println("조회된 객실이 없습니다.");
                    return;
                }
            }
        }

        else {
            System.out.println("층 수를 잘못 입력하셨습니다.");
        }
    }
}
