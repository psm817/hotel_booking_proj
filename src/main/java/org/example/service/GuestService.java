package org.example.service;

import org.example.container.Container;
import org.example.dao.GuestDao;
import org.example.dto.Guest;

public class GuestService {
    private GuestDao guestDao;

    public GuestService() {
        guestDao = Container.guestDao;
    }

    public void add(Guest guest) {
        guestDao.add(guest);
    }

    public Guest getGuestByLoginId(String loginId) {
        return guestDao.getGuestByLoginId(loginId);
    }

    public int getGuestIndexByLoginId(String loginId) {
        return guestDao.getGuestIndexByLoginId(loginId);
    }
}
