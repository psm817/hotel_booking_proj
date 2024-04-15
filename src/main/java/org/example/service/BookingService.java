package org.example.service;

import org.example.container.Container;
import org.example.dao.BookingDao;
import org.example.dto.Booking;
import org.example.dto.Guest;
import org.example.dto.Room;

import java.util.List;

public class BookingService {
    private BookingDao bookingDao;

    public BookingService() {
        bookingDao = Container.bookingDao;
    }

    // 이름으로 회원별 조회 가능한 booking 리스트 가져오기
    public List<Booking> getForPrintBookings(String name) {
        return bookingDao.getForPrintBookings(name);
    }

    // 이름과 오늘 날짜로 예약취소가 가능한 booking 리스트 가져오기
    public List<Booking> getForPrintBookings(String name, String todayDate) {
        return bookingDao.getForPrintBookings(name, todayDate);
    }

    // 리뷰 작성한 리스트 가져오기
    public List<Booking> getBookingsAbleReview(String name, String todayDate) {
        return bookingDao.getBookingsAbleReview(name, todayDate);
    }

    // 전체 booking 리스트 가져오기
    public List<Booking> getForPrintBookings() {
        return bookingDao.getForPrintBookings();
    }

    public int add(int roomNum, String checkInDate, String checkOutDate, String guestName, String guestPhone, int roomType, int bookingPay) {
        Booking booking = new Booking(roomNum, checkInDate, checkOutDate, guestName, guestPhone, roomType, bookingPay);
        return bookingDao.add(booking);
    }

    public Booking getForPrintBooking(int answerId) {
        return bookingDao.getForPrintBooking(answerId);
    }

    public int deleteBooking(int answerId) {
        return bookingDao.deleteBooking(answerId);
    }
}
