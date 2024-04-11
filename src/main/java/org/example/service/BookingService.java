package org.example.service;

import org.example.container.Container;
import org.example.dao.BookingDao;
import org.example.dto.Booking;
import org.example.dto.Guest;
import org.example.dto.Room;

import java.util.List;

public class BookingService {
    private BookingDao bookingDao;

    public BookingService() {
        bookingDao = Container.bookingDao;
    }

    public List<Booking> getForPrintBookings(String name) {
        return bookingDao.getForPrintBookings(name);
    }

    public List<Booking> getForPrintBookings() {
        return bookingDao.getForPrintBookings();
    }

    public int add(int roomNum, String checkInDate, String checkOutDate, String guestName, String guestPhone, int roomType, int bookingPay) {
        Booking booking = new Booking(roomNum, checkInDate, checkOutDate, guestName, guestPhone, roomType, bookingPay);
        return bookingDao.add(booking);
    }

    public Booking getForPrintBooking(int answerId) {
        return bookingDao.getForPrintBooking(answerId);
    }

    public int deleteBooking(int answerId) {
        return bookingDao.deleteBooking(answerId);
    }
}
