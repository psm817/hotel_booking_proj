package org.example.controller;

import java.util.Scanner;

public class BookingController extends Controller {
    private Scanner sc;
    private String cmd;

    public BookingController() {
        sc = new Scanner(System.in);
    }
    public void doAction(String cmd, String actionMethodName) {
        this.cmd = cmd;
    }
}
