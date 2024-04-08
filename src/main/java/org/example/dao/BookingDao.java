package org.example.dao;

import org.example.Container;
import org.example.dto.Booking;
import org.example.dto.Room;

import java.util.ArrayList;
import java.util.List;

import static org.example.controller.Controller.loginedGuest;

public class BookingDao extends Dao {
    public List<Booking> bookings;

    public BookingDao() {
        bookings = new ArrayList<>();
    }

    public void add(Booking booking) {
        bookings.add(booking);
        lastId++;
    }

    public Room getRoomsByNum(int roomNum) {
        int index = getRoomsIndexByNum(roomNum);

        if(index != -1) {
            return Container.roomDao.rooms.get(index);
        }

        return null;
    }

    public int getRoomsIndexByNum(int roomNum) {
        int i = 0;

        for(Room room : Container.roomDao.rooms) {
            if((room.floor * 100 + room.id) == roomNum) {
                return i;
            }
            i++;
        }

        return -1;
    }

    public int getBookingsByName(String name) {
        int sum = 0;

        for(Booking booking : bookings) {
            if(booking.guestName.equals(name)) {
                sum++;
            }
        }

        return sum;
    }

    public List<Booking> getForPrintBookings() {
        List<Booking> forPrintBookings = new ArrayList<>();

        for (Booking bookedAllRoom : bookings) {
            for (int j = 0; j < Container.roomDao.rooms.size(); j++) {
                Room foundAllRoom = Container.roomDao.rooms.get(j);
                int roomId = foundAllRoom.floor * 100 + foundAllRoom.id;

                if (bookedAllRoom.regDate.equals(foundAllRoom.bookingDate) && bookedAllRoom.roomId == roomId && loginedGuest.name.equals(bookedAllRoom.guestName)) {
                    forPrintBookings.add(bookedAllRoom);
                }
            }
        }

        return forPrintBookings;
    }
}
