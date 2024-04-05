package org.example.controller;

import org.example.dto.Guest;

public abstract class Controller {
    public static Guest loginedGuest;

    public abstract void doAction(String cmd, String actionMethodName);

    public static boolean isLogined() {
        return loginedGuest != null;
    }
}
