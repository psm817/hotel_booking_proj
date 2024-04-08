package org.example.dao;

import org.example.dto.Guest;

import java.util.ArrayList;
import java.util.List;

public class GuestDao extends Dao {
    public List<Guest> guests;

    public GuestDao() {
        guests = new ArrayList<>();
    }

    public void add(Guest guest) {
        guests.add(guest);
        lastId++;
    }

    public Guest getGuestByLoginId(String loginId) {
        int index = getGuestIndexByLoginId(loginId);

        if(index == -1) {
            return null;
        }

        return guests.get(index);
    }

    public int getGuestIndexByLoginId(String loginId) {
        int i = 0;

        for(Guest guest : guests) {
            if(guest.loginId.equals(loginId)) {
                return i;
            }
            i++;
        }

        return -1;
    }
}
