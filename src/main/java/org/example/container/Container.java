package org.example.container;

import org.example.controller.Session;
import org.example.dao.BookingDao;
import org.example.dao.GuestDao;
import org.example.dao.RoomDao;
import org.example.service.BookingService;
import org.example.service.GuestService;
import org.example.service.RoomService;

public class Container {
    public static Session session;
    public static BookingDao bookingDao;
    public static RoomDao roomDao;
    public static GuestDao guestDao;
    public static BookingService bookingService;
    public static RoomService roomService;
    public static GuestService guestService;

    static {
        bookingDao = new BookingDao();
        roomDao = new RoomDao();
        guestDao = new GuestDao();
        bookingService = new BookingService();
        roomService = new RoomService();
        guestService = new GuestService();
    }

    public static Session getSession() {
        if(session == null) {
            session = new Session();
        }

        return session;
    }
}
