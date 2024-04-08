package org.example.controller;

import org.example.service.GuestService;
import org.example.util.Util;
import org.example.dto.Guest;
import org.example.container.Container;

import java.util.Scanner;

public class GuestController extends Controller {
    private Scanner sc;
    private String cmd;
    private GuestService guestService;

    public GuestController() {
        sc = new Scanner(System.in);
        guestService = Container.guestService;
    }

    public void makeTestGuest() {
        guestService.add(new Guest(Container.guestDao.getNewId(), Util.getTodayDate(), "admin", "admin", "관리자", "admin@gmail.com", "010-1234-5678"));
        guestService.add(new Guest(Container.guestDao.getNewId(), Util.getTodayDate(), "user1", "user1", "홍길동", "user1@gmail.com", "010-1234-5678"));
        guestService.add(new Guest(Container.guestDao.getNewId(), Util.getTodayDate(), "user2", "user2", "임꺽정", "user2@gmail.com", "010-1234-5678"));
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
        int id = Container.guestDao.getNewId();
        String regDate = Util.getTodayDate();
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
        guestService.add(guest);

        System.out.println("회원가입이 완료되었습니다. 환영합니다!!");

    }

    public void doLogin() {
        System.out.print("ID : ");
        String loginId = sc.nextLine();
        System.out.print("PW : ");
        String loginPw = sc.nextLine();

        Guest guest = guestService.getGuestByLoginId(loginId);

        if(guest == null) {
            System.out.println("입력하신 ID는 등록되지 않은 ID입니다.");
            return;
        }

        if(guest.loginPw.equals(loginPw) == false) {
            System.out.println("비밀번호를 잘못 입력하셨습니다.");
            return;
        }

        loginedGuest = guest;
        System.out.printf("로그인 완료!! %s님 환영합니다.\n", loginedGuest.name);

    }

    public void doLogout() {
        loginedGuest = null;
        System.out.println("로그아웃 완료!!");
    }

    public boolean isJoinableLoginId(String loginId) {
        int index = guestService.getGuestIndexByLoginId(loginId);

        if(index == -1) {
            return true;
        }

        return false;
    }
}
