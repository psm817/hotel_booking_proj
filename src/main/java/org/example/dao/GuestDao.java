package org.example.dao;

import org.example.container.Container;
import org.example.db.DBConnection;
import org.example.dto.Guest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GuestDao extends Dao {
    public List<Guest> guests;
    private DBConnection dbConnection;

    public GuestDao() {
        guests = new ArrayList<>();
        dbConnection = Container.getDBConnection();
    }

    public int add(Guest guest) {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("INSERT INTO `guest` "));
        sb.append(String.format("SET regDate = NOW(), "));
        sb.append(String.format("loginId = '%s', ", guest.loginId));
        sb.append(String.format("loginPw = '%s', ", guest.loginPw));
        sb.append(String.format("name = '%s', ", guest.name));
        sb.append(String.format("email = '%s', ", guest.email));
        sb.append(String.format("phoneNum = '%s' ", guest.phoneNum));

        return dbConnection.insert(sb.toString());
    }

    public Guest getGuestByLoginId(String loginId) {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("SELECT * "));
        sb.append(String.format("FROM `guest` "));
        sb.append(String.format("WHERE loginId = '%s' ", loginId));

        Map<String, Object> guestRow = dbConnection.selectRow((sb.toString()));

        if(guestRow.isEmpty()) {
            return null;
        }

        return new Guest(guestRow);
    }
}
