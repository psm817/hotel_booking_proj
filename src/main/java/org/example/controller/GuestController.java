package org.example.controller;

import org.example.Util;
import org.example.dto.Guest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GuestController extends Controller {
    private Scanner sc;
    private String cmd;
    private List<Guest> guests;

    public GuestController() {
        sc = new Scanner(System.in);
        guests = new ArrayList<>();
    }
    public void doAction(String cmd, String actionMethodName) {
        this.cmd = cmd;
        
        switch(actionMethodName) {
            case "join" :
                doJoin();
                break;
            case "login" :
                doLogin();
                break;
            case "logout" :
                doLogout();
                break;
            default :
                System.out.println("존재하지 않는 서비스입니다.");
                break;
        }
    }

    public void doJoin() {
        int id = guests.size() + 1;
        String regDate = String.valueOf(Util.getTodayDate());

        while(true) {
            System.out.print("ID : ");
            String loginId = sc.nextLine();

            System.out.print("PW : ");
            String loginPw = sc.nextLine();

            System.out.print("PW 확인 : ");
            String loginPwConfirm = sc.nextLine();

            if(loginPw.equals(loginPwConfirm) == false) {
                System.out.println("비밀번호가 일치하지 않습니다.");
                continue;
            }

            break;
        }

    }

    public void doLogin() {
    }

    public void doLogout() {
    }
}
