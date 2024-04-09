package org.example.service;

import org.example.container.Container;
import org.example.dao.RoomDao;
import org.example.dto.Room;

import java.util.List;

public class RoomService {
    private RoomDao roomDao;

    public RoomService() {
        roomDao = Container.roomDao;
    }

    public List<Room> getRooms() {
        return roomDao.getRooms();
    }

    public Room getBookingAbleRoom(int floor, int number, String bookingDate) {
        return roomDao.getBookingAbleRoom(floor, number, bookingDate);
    }

    public int setBookingComplete(int floor, int number, String bookingDate) {
        return roomDao.setBookingComplete(floor, number, bookingDate);
    }
}
