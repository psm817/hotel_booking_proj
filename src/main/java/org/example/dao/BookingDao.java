package org.example.dao;

import org.example.container.Container;
import org.example.controller.Session;
import org.example.db.DBConnection;
import org.example.dto.Booking;
import org.example.dto.Guest;
import org.example.dto.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookingDao extends Dao {
    public List<Booking> bookings;
    private Session session;
    private DBConnection dbConnection;

    public BookingDao() {
        bookings = new ArrayList<>();
        session = Container.getSession();
        dbConnection = Container.getDBConnection();
    }

    public int add(Booking booking) {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("INSERT INTO `booking` "));
        sb.append(String.format("SET roomId = %d,", booking.roomId));
        sb.append(String.format("checkInDate = '%s', ", booking.checkInDate));
        sb.append(String.format("checkOutDate = '%s', ", booking.checkOutDate));
        sb.append(String.format("guestName = '%s', ", booking.guestName));
        sb.append(String.format("guestPhone = '%s', ", booking.guestPhone));
        sb.append(String.format("roomType = %d, ", booking.roomType));
        sb.append(String.format("bookingPay = %d ", booking.bookingPay));

        return dbConnection.insert(sb.toString());
    }

    public List<Booking> getForPrintBookings(String name) {
        // 로그인 된 게스트 가져오기
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("SELECT * "));
        sb.append(String.format("FROM booking "));
        sb.append(String.format("WHERE guestName = '%s' ", name));

        List<Booking> bookings = new ArrayList<>();
        List<Map<String, Object>> rows = dbConnection.selectRows(sb.toString());

        for(Map<String, Object> row : rows) {
            bookings.add(new Booking(row));
        }

        return bookings;
    }

    public List<Booking> getForPrintBookings() {
        // 로그인 된 게스트 가져오기
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("SELECT * FROM booking "));

        List<Booking> bookings = new ArrayList<>();
        List<Map<String, Object>> rows = dbConnection.selectRows(sb.toString());

        for(Map<String, Object> row : rows) {
            bookings.add(new Booking(row));
        }

        return bookings;
    }

    public Booking getForPrintBooking(int answerId) {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("SELECT * "));
        sb.append(String.format("FROM `booking` "));
        sb.append(String.format("WHERE id = %d ", answerId));

        Map<String, Object> row = dbConnection.selectRow(sb.toString());

        if(row.isEmpty()) {
            return null;
        }

        return new Booking(row);
    }

    public int deleteBooking(int answerId) {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("DELETE FROM `booking` "));
        sb.append(String.format("WHERE id = %d ", answerId));

        return dbConnection.delete(sb.toString());
    }
}
