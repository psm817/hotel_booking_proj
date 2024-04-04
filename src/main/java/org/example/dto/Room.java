package org.example.dto;

public class Room {
    public int id;          // 호수
    public int floor;       // 층
    public int type;        // 싱글, 더블
    public String bookingDate;      // 예약한 날짜
    public String booked;           // 예약 여부
    public String nowDate;          // 당일 날짜

    public Room(int id, int floor, int type, String bookingDate, String nowDate, String booked) {
        this.id = id;
        this.floor = floor;
        this.type = type;
        this.bookingDate = bookingDate;
        this.nowDate = nowDate;
        this.booked = booked;
    }
}
