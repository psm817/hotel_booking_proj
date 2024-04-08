package org.example;

import org.example.dao.BookingDao;
import org.example.dao.GuestDao;
import org.example.dao.RoomDao;

public class Container {
    public static BookingDao bookingDao;
    public static RoomDao roomDao;
    public static GuestDao guestDao;

    static {
        bookingDao = new BookingDao();
        roomDao = new RoomDao();
        guestDao = new GuestDao();
    }
}
