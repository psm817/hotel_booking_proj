package org.example.controller;

import org.example.Container;
import org.example.dto.Guest;
import org.example.dto.Room;

import java.util.ArrayList;
import java.util.List;

public abstract class Controller {
    public static Guest loginedGuest;

    public static boolean isLogined() {
        return loginedGuest != null;
    }

    public abstract void doAction(String cmd, String actionMethodName);
}
