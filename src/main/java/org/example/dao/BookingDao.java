package org.example.dao;

import org.example.container.Container;
import org.example.controller.Session;
import org.example.dto.Booking;
import org.example.dto.Guest;
import org.example.dto.Room;

import java.util.ArrayList;
import java.util.List;

public class BookingDao extends Dao {
    public List<Booking> bookings;
    private Session session;

    public BookingDao() {
        bookings = new ArrayList<>();
        session = Container.getSession();
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
        // 로그인 된 게스트 가져오기
        Guest loginedGuest = session.getLoginedGuest();

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
