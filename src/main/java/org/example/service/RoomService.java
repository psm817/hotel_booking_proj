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

    public List<Room> getBookingAbleRoom(int floor, int number, String checkInDate, String checkOutDate) {
        return roomDao.getBookingAbleRoom(floor, number, checkInDate, checkOutDate);
    }

    public int setBookingComplete(int floor, int number, String checkInDate, String checkOutDate) {
        return roomDao.setBookingComplete(floor, number, checkInDate, checkOutDate);
    }

    public int setBookingDelete(int floor, int number, String checkInDate, String checkOutDate) {
        return roomDao.setBookingDelete(floor, number, checkInDate, checkOutDate);
    }

    public int roomDateDelete(String dayOfSelect) {
        return roomDao.roomDateDelete(dayOfSelect);
    }

    public int roomDatePlus(int i, int j) {
        return roomDao.roomDatePlus(i, j);
    }
}
