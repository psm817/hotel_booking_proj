package org.example.controller;

import org.example.dto.Guest;
import org.example.dto.Room;

import java.util.ArrayList;
import java.util.List;

public abstract class Controller {
    public static Guest loginedGuest;

    // rooms을 static으로 해야 공공재로 쓸 수 있음
    public static List<Room> rooms;

    public Controller() {
        rooms = new ArrayList<>();
    }

    public abstract void doAction(String cmd, String actionMethodName);

    public static boolean isLogined() {
        return loginedGuest != null;
    }

    public static void makeTestData() {
        rooms.add(new Room(1, 3, 1, null, "2024-04-05", "예약가능"));
        rooms.add(new Room(2, 3, 2, "2020-01-01", "2024-04-05", "예약불가"));
        rooms.add(new Room(3, 3, 1, "2020-01-01", "2024-04-05", "예약불가"));
        rooms.add(new Room(4, 3, 2, null, "2024-04-05", "예약가능"));
        rooms.add(new Room(5, 3, 1, "2020-01-01", "2024-04-05", "예약가능"));

        rooms.add(new Room(1, 4, 1, null, "2024-04-05", "예약가능"));
        rooms.add(new Room(2, 4, 2, "2020-01-01", "2024-04-05", "예약불가"));
        rooms.add(new Room(3, 4, 1, "2020-01-01", "2024-04-05", "예약불가"));
        rooms.add(new Room(4, 4, 2, null, "2024-04-05", "예약가능"));
        rooms.add(new Room(5, 4, 1, "2020-01-01", "2024-04-05", "예약불가"));

        rooms.add(new Room(1, 5, 1, null, "2024-04-05", "예약가능"));
        rooms.add(new Room(2, 5, 2, "2020-01-01", "2024-04-05", "예약불가"));
        rooms.add(new Room(3, 5, 1, "2020-01-01", "2024-04-05", "예약불가"));
        rooms.add(new Room(4, 5, 2, null, "2024-04-05", "예약가능"));
        rooms.add(new Room(5, 5, 1, "2020-01-01", "2024-04-05", "예약불가"));
    }
}
