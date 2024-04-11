package org.example.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class Booking extends Dto {
    public int roomId;
    public String checkInDate;
    public String checkOutDate;
    public String guestName;
    public String guestPhone;
    public int roomType;
    public int bookingPay;

    public Booking(int roomId, String checkInDate, String checkOutDate, String guestName, String guestPhone, int roomType, int bookingPay) {
        this.id = id;
        this.roomId = roomId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.guestName = guestName;
        this.guestPhone = guestPhone;
        this.roomType = roomType;
        this.bookingPay = bookingPay;
    }

    public Booking(Map<String, Object> row) {
        super(row);
        this.roomId = (int) row.get("roomId");
        this.checkInDate = row.get("checkInDate").toString();
        this.checkOutDate = row.get("checkOutDate").toString();
        this.guestName = (String) row.get("guestName");
        this.guestPhone = (String) row.get("guestPhone");
        this.roomType = (int) row.get("roomType");
        this.bookingPay = (int) row.get("bookingPay");
    }
}
