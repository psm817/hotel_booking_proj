package org.example.controller;

import org.example.Util;
import org.example.dto.Guest;
import org.example.dto.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookingController extends Controller {
    private Scanner sc;
    private String cmd;
    private List<Room> rooms;

    public BookingController() {
        sc = new Scanner(System.in);
        rooms = new ArrayList<>();
    }

    public void makeTestData() {
        rooms.add(new Room(1, 3, 1, null, "2024-04-04", "예약가능"));
        rooms.add(new Room(2, 3, 2, "2020-01-01", "2024-04-04", "예약불가"));
        rooms.add(new Room(3, 3, 1, "2020-01-01", "2024-04-04", "예약불가"));
        rooms.add(new Room(4, 3, 2, null, "2024-04-04", "예약가능"));
        rooms.add(new Room(5, 3, 1, "2020-01-01", "2024-04-04", "예약가능"));

        rooms.add(new Room(1, 4, 1, null, "2024-04-04", "예약가능"));
        rooms.add(new Room(2, 4, 2, "2020-01-01", "2024-04-04", "예약불가"));
        rooms.add(new Room(3, 4, 1, "2020-01-01", "2024-04-04", "예약불가"));
        rooms.add(new Room(4, 4, 2, null, "2024-04-04", "예약가능"));
        rooms.add(new Room(5, 4, 1, "2020-01-01", "2024-04-04", "예약불가"));

        rooms.add(new Room(1, 5, 1, null, "2024-04-04", "예약가능"));
        rooms.add(new Room(2, 5, 2, "2020-01-01", "2024-04-04", "예약불가"));
        rooms.add(new Room(3, 5, 1, "2020-01-01", "2024-04-04", "예약불가"));
        rooms.add(new Room(4, 5, 2, null, "2024-04-04", "예약가능"));
        rooms.add(new Room(5, 5, 1, "2020-01-01", "2024-04-04", "예약불가"));
    }

    public void doAction(String cmd, String actionMethodName) {
        this.cmd = cmd;
        
        switch(actionMethodName) {
            case "room" :
                doBooking();
                break;
            case "check" :
                doCheckBooking();
                break;
            case "modify" :
                doModifyBooking();
                break;
            case "delete" :
                doDeleteBooking();
                break;
            case "reply" :
                doWriteReview();
                break;
            default :
                System.out.println("존재하지 않는 서비스입니다.");
                break;
        }
    }

    public void doBooking() {
        String[] cmdBits = cmd.split(" ");
        if(cmdBits.length > 2) {
            System.out.println("존재하지 않는 서비스입니다.");
            return;
        }

        System.out.print("예약할 객실 호수 입력) ");
        int roomNum = sc.nextInt();
        sc.nextLine();

        // 예약가능한 객실 가져오기
        Room bookingAbleRoom = getRoomsByNum(roomNum);

        // 객실이 없거나, 예약불가 처리
        if(bookingAbleRoom == null || bookingAbleRoom.booked.equals("예약불가")) {
            System.out.println("예약이 불가능한 객실입니다.");
            return;
        }

        // 객실 타입 안내
        if(roomNum % 2 == 1) {
            System.out.printf("*** %d호 객실의 타입은 [%d] ***\n", roomNum, bookingAbleRoom.type);
        }
        else if(roomNum % 2 == 0) {
            System.out.printf("*** %s호 객실의 타입은 [%s] ***\n", roomNum, bookingAbleRoom.type);
        }

        // 날짜 입력 및 7일간 날짜 판단
        System.out.print("예약 날짜 입력) ");
        String bookingDate = sc.nextLine();

        if(Util.checkWeekDate(bookingDate) == false) {
            System.out.println("오늘 날짜부터 7일간 조회 가능합니다.");
            return;
        }

        System.out.println("%s님 예약 성공하셨습니다!!");

    }

    public void doCheckBooking() {
    }

    public void doModifyBooking() {
    }

    public void doDeleteBooking() {
    }

    public void doWriteReview() {
    }

    private Room getRoomsByNum(int roomNum) {
        int index = getRoomsIndexByNum(roomNum);

        if(index != -1) {
            return rooms.get(index);
        }

        return null;
    }

    private int getRoomsIndexByNum(int roomNum) {
        int i = 0;

        for(Room room : rooms) {
            if((room.floor * 100 + room.id) == roomNum) {
                return i;
            }
            i++;
        }

        return -1;
    }
}
