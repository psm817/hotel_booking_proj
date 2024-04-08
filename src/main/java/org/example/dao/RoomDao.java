package org.example.dao;

import org.example.dto.Room;

import java.util.ArrayList;
import java.util.List;

public class RoomDao extends Dao {
    public List<Room> rooms;

    public RoomDao() {
        rooms = new ArrayList<>();
    }

    public void add(Room room) {
        rooms.add(room);
        lastId++;
    }
}
