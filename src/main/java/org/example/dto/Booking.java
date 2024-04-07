package org.example.dto;

public class Booking extends Dto {
    public int roomId;
    public String regDate;
    public String guestName;
    public String guestPhone;
    public int roomType;
    public int bookingPay;

    public Booking(int id, int roomId, String regDate, String guestName, String guestPhone, int roomType, int bookingPay) {
        this.id = id;
        this.roomId = roomId;
        this.regDate = regDate;
        this.guestName = guestName;
        this.guestPhone = guestPhone;
        this.roomType = roomType;
        this.bookingPay = bookingPay;
    }
}
