package org.example.dto;

public class Room {
    public int id;
    public int floor;
    public int type;
    public String bookingDate;
    public String booked;

    public Room(int id, int floor, int type, String bookingDate, String booked) {
        this.id = id;
        this.floor = floor;
        this.type = type;
        this.bookingDate = bookingDate;
        this.booked = booked;
    }
}
