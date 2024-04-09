package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class Room extends Dto {
    public int roomNum;     // 호수
    public int floor;       // 층
    public int type;        // 싱글, 더블
    public String bookingDate;      // 예약한 날짜
    public String booked;           // 예약 여부
    public String dayOfSelect;      // 선택 날짜

    public Room(Map<String, Object> row) {
        super(row);
        this.roomNum = (int) row.get("roomNum");
        this.floor = (int) row.get("floor");
        this.type = (int) row.get("type");
        this.bookingDate = (String) row.get("bookingDate");
        this.dayOfSelect = row.get("dayOfSelect").toString();
        this.booked = (String) row.get("booked");
    }
}
