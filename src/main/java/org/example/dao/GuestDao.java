package org.example.dao;

import org.example.dto.Guest;

import java.util.ArrayList;
import java.util.List;

public class GuestDao extends Dao {
    public List<Guest> guests;

    public GuestDao() {
        guests = new ArrayList<>();
    }
}
