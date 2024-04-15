package org.example.service;

import org.example.container.Container;
import org.example.dao.GuestDao;
import org.example.dto.Guest;

public class GuestService {
    private GuestDao guestDao;

    public GuestService() {
        guestDao = Container.guestDao;
    }

    public int add(String regDate, String loginId, String loginPw, String name, String email, String phoneNum) {
        Guest guest = new Guest(regDate, loginId, loginPw, name, email, phoneNum);
        return guestDao.add(guest);
    }

    public int getNewId() {
        return guestDao.getNewId();
    }

    public Guest getGuestByLoginId(String loginId) {
        return guestDao.getGuestByLoginId(loginId);
    }

    public Guest getGuestByName(String guestName) {
        return guestDao.getGuestByName(guestName);
    }
}
