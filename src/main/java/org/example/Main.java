package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("호텔 예약 관리 시스템에 오신 것을 환영합니다.");
        System.out.println("=== 서비스 모음 ===");

        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.print("서비스 번호를 입력해주세요) ");
            String cmd = sc.nextLine();
            cmd = cmd.trim();

            if(cmd.length() == 0) {
                continue;
            }

            if(cmd.equals("exit")) {
                break;
            }


        }

        sc.close();
        System.out.println("감사합니다. 다음에 또 방문해주세요.");
    }
}