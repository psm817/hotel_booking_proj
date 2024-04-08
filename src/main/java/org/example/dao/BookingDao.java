package org.example.dao;

import org.example.dto.Booking;
import org.example.dto.Guest;

import java.util.ArrayList;
import java.util.List;

public class BookingDao {
    public List<Booking> bookings;

    public BookingDao() {
        bookings = new ArrayList<>();
    }
}
