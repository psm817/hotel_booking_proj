package org.example.controller;

import java.util.Scanner;

public class HotelController extends Controller {
    private Scanner sc;
    private String cmd;

    public HotelController() {
        sc = new Scanner(System.in);
    }
    public void doAction(String cmd, String actionMethodName) {
        this.cmd = cmd;

        switch(actionMethodName) {
            case "introduce" :
                doIntroduce();
                break;
            default :
                System.out.println("존재하지 않는 서비스입니다.");
        }
    }

    private void doIntroduce() {
        System.out.printf("\n");
        System.out.println("======== 호텔 소개 ========");
        System.out.println("호텔명 : 대전 그랜드 호텔");
        System.out.println("호텔 위치 : 대전광역시 서구 청사로 111 (3 ~ 5층)");
        System.out.println("호텔 전화번호 : 042-123-1234");
        System.out.println("카운터 영업시간 : 오전 8시 ~ 오후 12시");
        System.out.println("객실 구성 : 각 층별로 10개씩 구성");
        System.out.println("객실 종류 : 싱글 / 더블");
        System.out.println("객실 최대 수용 인원 : 싱글(2인) / 더블(4인)");
        System.out.println("객실 요금 : 싱글(80,000원) / 더블(120,000원) ");
        System.out.println("*인원 추가 시 20,000원 추가*");
        System.out.println("===========================");
        System.out.printf("\n");
    }

}
