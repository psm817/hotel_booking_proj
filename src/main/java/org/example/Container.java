package org.example;

import org.example.dao.BookingDao;
import org.example.dao.GuestDao;
import org.example.dao.RoomDao;
import org.example.service.BookingService;
import org.example.service.RoomService;

public class Container {
    public static BookingDao bookingDao;
    public static RoomDao roomDao;
    public static GuestDao guestDao;
    public static BookingService bookingService;
    public static RoomService roomService;

    static {
        bookingDao = new BookingDao();
        roomDao = new RoomDao();
        guestDao = new GuestDao();
        bookingService = new BookingService();
        roomService = new RoomService();
    }
}
