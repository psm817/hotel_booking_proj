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
        String loginId = null;
        String loginPw = null;
        String loginPwConfirm = null;

        // ID 검사
        while(true) {
            System.out.print("ID : ");
            loginId = sc.nextLine();

            if(isJoinableLoginId(loginId) == false) {
                System.out.printf("%s는 이미 사용 중인 ID 입니다. 다시 입력해 주세요.\n", loginId);
                continue;
            }

            break;
        }

        // PW 검사
        while(true) {
            System.out.print("PW : ");
            loginPw = sc.nextLine();

            System.out.print("PW 확인 : ");
            loginPwConfirm = sc.nextLine();

            if(loginPw.equals(loginPwConfirm) == false) {
                System.out.println("비밀번호가 일치하지 않습니다.");
                continue;
            }

            break;
        }

        // 나머지 항목 입력 후 배열에 추가
        System.out.print("이름 : ");
        String name = sc.nextLine();
        System.out.print("이메일 : ");
        String email = sc.nextLine();
        System.out.print("전화번호 : ");
        String phoneNum = sc.nextLine();

        Guest guest = new Guest(id, regDate, loginId, loginPw, name, email, phoneNum);
        guests.add(guest);

        System.out.println("회원가입이 완료되었습니다. 환영합니다!!");

    }

    public void doLogin() {
        System.out.print("ID : ");
        String loginId = sc.nextLine();
        System.out.print("PW : ");
        String loginPw = sc.nextLine();


    }

    public void doLogout() {
    }

    private boolean isJoinableLoginId(String loginId) {
        int index = getGuestIndexByLoginId(loginId);

        if(index == -1) {
            return true;
        }

        return false;
    }

    private int getGuestIndexByLoginId(String loginId) {
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
