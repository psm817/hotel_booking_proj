package org.example.controller;

import org.example.Util;
import org.example.dto.Booking;
import org.example.dto.Guest;
import org.example.dto.Room;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class BookingController extends Controller {
    private Scanner sc;
    private String cmd;
    private List<Booking> bookings;
    public Room bookingAbleRoom;

    public BookingController() {
        sc = new Scanner(System.in);
        bookings = new ArrayList<>();
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

        System.out.print("예약할 객실 호수 입력(숫자만) : ");
        int roomNum = sc.nextInt();
        sc.nextLine();


        // 날짜 입력 및 7일간 날짜 판단
        System.out.print("예약 날짜 입력) ");
        String bookingDate = sc.nextLine();
        bookingDate = bookingDate.trim();

        if(Util.checkWeekDate(bookingDate) == false) {
            System.out.println("오늘 날짜부터 7일간 조회 가능합니다.");
            return;
        }

        // 예약가능한 객실 가져오기
        bookingAbleRoom = getRoomsByNum(roomNum);

        // 객실이 없거나, 예약불가 처리
        if(bookingAbleRoom == null || bookingAbleRoom.booked.equals("예약불가")) {
            System.out.println("예약이 불가능한 객실입니다.");
            return;
        }

        // 요금 안내
        int payment = 150000;
        int count = 0;
        int plusPay = 20000;

        // 객실 타입 안내
        if(roomNum % 2 == 1) {
//            System.out.printf("*** %d호 객실의 타입은 [%d] ***\n", roomNum, bookingAbleRoom.type);
            System.out.print("인원은 몇 명 이신가요?) ");
            int peopleNum = sc.nextInt();
            sc.nextLine();

            if(peopleNum > 2) {
                count = peopleNum - 2;
                System.out.println("[싱글] 정원 2명을 초과하셨습니다!!");
                System.out.println("추가 인원 당 20,000원의 추가 요금이 발생합니다!!");
            }
        }
        else if(roomNum % 2 == 0) {
            payment += 100000;
            System.out.print("인원은 몇 명 이신가요?) ");
            int peopleNum = sc.nextInt();
            sc.nextLine();

            if(peopleNum > 4) {
                count = peopleNum - 4;
                System.out.println("[더블] 정원 4명을 초과하셨습니다!!");
                System.out.println("추가 인원 당 20,000원의 추가 요금이 발생합니다!!");
            }
        }

        Booking booking = null;

        while(true) {
            int id = bookings.size() + 1;
            System.out.print("예약을 진행할까요?) ");
            String answer = sc.nextLine();
            answer = answer.trim();

            if(answer.equals("yes")) {
                // booking 배열 추가
                booking = new Booking(id, bookingDate, loginedGuest.name, loginedGuest.phoneNum, bookingAbleRoom.type);
                bookings.add(booking);

                // 로그인된 회원의 이름으로 예약 성공
                System.out.printf("%s님 예약 성공하셨습니다!!\n", booking.guestName);
                System.out.printf("총 금액은 %d입니다. 결제는 당일 카운터에서 진행 부탁드립니다!\n", (payment+(count*plusPay)));

                break;
            }

            else if(answer.equals("no")) {
                System.out.println("예약을 중단합니다.");
                break;
            }

            else {
                System.out.println("\'yes\' 또는 \'no\'를 입력해주세요");
                continue;
            }
        }

        // room 상태를 예약불가로 변경
        bookingAbleRoom.booked = "예약불가";
        bookingAbleRoom.bookingDate = bookingDate;
    }

    public void doCheckBooking() {
    }

    public void doModifyBooking() {
    }

    public void doDeleteBooking() {
    }

    public void doWriteReview() {
    }

    public Room getRoomsByNum(int roomNum) {
        int index = getRoomsIndexByNum(roomNum);

        if(index != -1) {
            return rooms.get(index);
        }

        return null;
    }

    public int getRoomsIndexByNum(int roomNum) {
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
