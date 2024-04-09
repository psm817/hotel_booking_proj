package org.example.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class Booking extends Dto {
    public int roomId;
    public String regDate;
    public String guestName;
    public String guestPhone;
    public int roomType;
    public int bookingPay;

    public Booking(int roomId, String regDate, String guestName, String guestPhone, int roomType, int bookingPay) {
        this.id = id;
        this.roomId = roomId;
        this.regDate = regDate;
        this.guestName = guestName;
        this.guestPhone = guestPhone;
        this.roomType = roomType;
        this.bookingPay = bookingPay;
    }

    public Booking(Map<String, Object> row) {
        super(row);
        this.roomId = (int) row.get("roomId");
        this.regDate = row.get("regDate").toString();
        this.guestName = (String) row.get("guestName");
        this.guestPhone = (String) row.get("guestPhone");
        this.roomType = (int) row.get("roomType");
        this.bookingPay = (int) row.get("bookingPay");
    }
}
