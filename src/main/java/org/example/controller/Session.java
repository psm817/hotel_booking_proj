package org.example.controller;

import org.example.dto.Guest;


// 현재 사용자가 이용중인 정보
// 해당 정보는 사용자가 프로그램을 사용할 때 동안 계속 유지됨.
public class Session {
    public Guest loginedGuest;

    public Guest getLoginedGuest() {
        return loginedGuest;
    }

    public void setLoginedGuest(Guest loginedGuest) {
        this.loginedGuest = loginedGuest;
    }

    public boolean isLogined() {
        return loginedGuest != null;
    }
}
