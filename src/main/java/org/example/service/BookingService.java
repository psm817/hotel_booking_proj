package org.example.service;

import org.example.container.Container;
import org.example.dao.BookingDao;
import org.example.dto.Booking;
import org.example.dto.Room;

import java.util.List;

public class BookingService {
    private BookingDao bookingDao;

    public BookingService() {
        bookingDao = Container.bookingDao;
    }

    public Room getRoomsByNum(int roomNum) {
        return bookingDao.getRoomsByNum(roomNum);
    }

    public int getRoomsIndexByNum(int roomNum) {
        return bookingDao.getRoomsIndexByNum(roomNum);
    }

    public int getBookingsByName(String name) {
        return bookingDao.getBookingsByName(name);
    }

    public List<Booking> getForPrintBookings() {
        return bookingDao.getForPrintBookings();
    }

    public void add(Booking booking) {
        bookingDao.add(booking);
    }
}
