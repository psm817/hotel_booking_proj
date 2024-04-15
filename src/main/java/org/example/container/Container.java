package org.example.container;

import org.example.controller.Session;
import org.example.dao.BookingDao;
import org.example.dao.GuestDao;
import org.example.dao.ReviewDao;
import org.example.dao.RoomDao;
import org.example.db.DBConnection;
import org.example.service.BookingService;
import org.example.service.GuestService;
import org.example.service.ReviewService;
import org.example.service.RoomService;

public class Container {
    public static Session session;
    public static DBConnection dbConnection;
    public static BookingDao bookingDao;
    public static RoomDao roomDao;
    public static GuestDao guestDao;
    public static ReviewDao reviewDao;
    public static BookingService bookingService;
    public static RoomService roomService;
    public static GuestService guestService;
    public static ReviewService reviewService;

    static {
        bookingDao = new BookingDao();
        roomDao = new RoomDao();
        guestDao = new GuestDao();
        reviewDao = new ReviewDao();
        bookingService = new BookingService();
        roomService = new RoomService();
        guestService = new GuestService();
        reviewService = new ReviewService();
    }

    public static DBConnection getDBConnection() {
        if(dbConnection == null) {
            dbConnection = new DBConnection();
        }

        return dbConnection;
    }

    public static Session getSession() {
        if(session == null) {
            session = new Session();
        }

        return session;
    }
}
