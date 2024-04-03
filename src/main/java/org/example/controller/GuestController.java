package org.example.controller;

import java.util.Scanner;

public class GuestController extends Controller {
    private Scanner sc;
    private String cmd;

    public GuestController() {
        sc = new Scanner(System.in);
    }
    public void doAction(String cmd, String actionMethodName) {
        this.cmd = cmd;
    }
}
