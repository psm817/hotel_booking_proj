package org.example.dao;

import org.example.container.Container;
import org.example.db.DBConnection;
import org.example.dto.Booking;
import org.example.dto.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RoomDao extends Dao {
    public List<Room> rooms;
    private DBConnection dbConnection;

    public RoomDao() {
        rooms = new ArrayList<>();
        dbConnection = Container.getDBConnection();
    }

    public List<Room> getRooms() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("SELECT * FROM room"));

        List<Room> rooms = new ArrayList<>();
        List<Map<String, Object>> rows = dbConnection.selectRows(sb.toString());

        for(Map<String, Object> row : rows) {
            rooms.add(new Room(row));
        }

        return rooms;
    }

    public Room getBookingAbleRoom(int floor, int number, String bookingDate) {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("SELECT * "));
        sb.append(String.format("FROM `room` "));
        sb.append(String.format("WHERE floor = %d AND roomNum = %d AND dayOfSelect = '%s' ", floor, number, bookingDate));

        Map<String, Object> row = dbConnection.selectRow(sb.toString());

        if(row.isEmpty()) {
            return null;
        }

        return new Room(row);
    }

    public int setBookingComplete(int floor, int number, String bookingDate) {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("UPDATE `room` "));
        sb.append(String.format("SET booked = '예약불가', "));
        sb.append(String.format("bookingDate = '%s' ", bookingDate));
        sb.append(String.format("WHERE floor = %d AND roomNum = %d AND dayOfSelect = '%s' ", floor, number, bookingDate));

        return dbConnection.update(sb.toString());
    }

    public int setBookingDelete(int floor, int number) {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("UPDATE `room` "));
        sb.append(String.format("SET booked = '예약가능', "));
        sb.append(String.format("bookingDate = NULL "));
        sb.append(String.format("WHERE floor = %d AND roomNum = %d ", floor, number));

        return dbConnection.update(sb.toString());
    }
}
