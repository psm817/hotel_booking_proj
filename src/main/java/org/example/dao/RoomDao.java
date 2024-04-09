package org.example.dao;

import org.example.container.Container;
import org.example.db.DBConnection;
import org.example.dto.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RoomDao extends Dao {
    public List<Room> rooms;
    private DBConnection dbConnection;

    public RoomDao() {
        rooms = new ArrayList<>();
        dbConnection = Container.getDBConnection();
    }

    public void add(Room room) {
        rooms.add(room);
        lastId++;
    }

    public List<Room> getRooms() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("SELECT * FROM room"));

        List<Room> rooms = new ArrayList<>();
        List<Map<String, Object>> rows = dbConnection.selectRows(sb.toString());

        for(Map<String, Object> row : rows) {
            rooms.add(new Room(row));
        }

        return rooms;
    }
}
