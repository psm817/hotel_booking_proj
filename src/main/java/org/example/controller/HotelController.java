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
        System.out.println("객실 구성 : 각 층별로 10개");
        System.out.println("객실 종류 : 싱글 / 더블");
        System.out.println("객실 최대 수용 인원 : 싱글(2인) / 더블(4인)");
        System.out.println("객실 요금 : 싱글(150,000원) / 더블(250,000원) ");
        System.out.println("**객실 예약은 일주일 단위로 가능합니다.**");
        System.out.println("**인원 추가 시 20,000원 추가**");
        System.out.println("**부대시설 워터파크(2층)와 노래방(6층)은 예약 시 이용 가능합니다.**");
        System.out.println("===========================");
        System.out.printf("\n");
    }

}
