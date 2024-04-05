package org.example.dto;

public class Booking extends Dto {
    public String regDate;
    public String guestName;
    public String guestPhone;
    public int roomType;

    public Booking(int id, String regDate, String guestName, String guestPhone, int roomType) {
        this.id = id;
        this.regDate = regDate;
        this.guestName = guestName;
        this.guestPhone = guestPhone;
        this.roomType = roomType;
    }
}
