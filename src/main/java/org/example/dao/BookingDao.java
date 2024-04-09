package org.example.dao;

import org.example.container.Container;
import org.example.controller.Session;
import org.example.db.DBConnection;
import org.example.dto.Booking;
import org.example.dto.Guest;
import org.example.dto.Room;

import java.util.ArrayList;
import java.util.List;

public class BookingDao extends Dao {
    public List<Booking> bookings;
    private Session session;
    private DBConnection dbConnection;

    public BookingDao() {
        bookings = new ArrayList<>();
        session = Container.getSession();
        dbConnection = Container.getDBConnection();
    }

    public int add(Booking booking) {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("INSERT INTO `booking` "));
        sb.append(String.format("SET roomId = %d,", booking.roomId));
        sb.append(String.format("regDate = '%s', ", booking.regDate));
        sb.append(String.format("guestName = '%s', ", booking.guestName));
        sb.append(String.format("guestPhone = '%s', ", booking.guestPhone));
        sb.append(String.format("roomType = %d, ", booking.roomType));
        sb.append(String.format("bookingPay = %d ", booking.bookingPay));

        return dbConnection.insert(sb.toString());
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
