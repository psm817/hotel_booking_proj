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

    public void add(Room room) {
        roomDao.add(room);
    }

    public List<Room> getRooms() {
        return roomDao.getRooms();
    }
}
