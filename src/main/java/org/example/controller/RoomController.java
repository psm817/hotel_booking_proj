package org.example.controller;

import org.example.container.Container;
import org.example.dto.Room;
import org.example.service.RoomService;
import org.example.util.Util;

import java.util.List;
import java.util.Scanner;

public class RoomController extends Controller {
    private Scanner sc;
    private String cmd;
    private RoomService roomService;

    public RoomController() {
        sc = new Scanner(System.in);
        roomService = Container.roomService;
    }

    public void doAction(String cmd, String actionMethodName) {
        this.cmd = cmd;

        switch(actionMethodName) {
            case "list" :
                showList();
                break;
            default :
                System.out.println("존재하지 않는 서비스입니다.");
                break;
        }
    }

    public void showList() {
        List<Room> forListRooms = roomService.getRooms();
        System.out.printf("** 오늘 날짜 : %s **\n", Util.getTodayDate());

        String[] cmdBits = cmd.split(" ");
        if(cmdBits.length > 2) {
            System.out.println("존재하지 않는 서비스입니다.");
            return;
        }

        while(true) {
            System.out.print("확인하시고 싶은 날짜 입력) ");
            String checkDate = sc.nextLine();

            if(!Util.checkWeekDate(checkDate)) {
                System.out.println("오늘 날짜부터 7일간 조회 가능합니다.");
                continue;
            }

            // 현재 날짜를 기준으로 일주일 범위에 속하는 날짜의 방을 추가 생성 (15개)
            if(Util.getDaysBetween(Util.getTodayDate(), checkDate) <= 7) {
                if(checkDate.equals(Util.getSevenDateLater())) {
                    for(int i = 3; i <= 5; i++) {
                        for(int j = 1; j <= 5; j++) {
                            roomService.roomDatePlus(i, j);
                        }
                    }
                }
            }

            while(true) {
                System.out.print("층 입력(숫자만) : ");
                int floor = sc.nextInt();
                sc.nextLine();

                if(floor > 5 || floor < 3) {
                    System.out.println("층 수를 잘못 입력하셨습니다.");
                    System.out.println("3, 4, 5층 중 하나를 입력해주세요.");
                    continue;
                }

                else {
                    System.out.printf("======== [%s] %d층 객실 현황 =======\n", checkDate, floor);
                    System.out.println("호수 | 객실타입 | 상태");

                    for(int i = 0; i < forListRooms.size(); i++) {
                        Room room = forListRooms.get(i);

                        // 현재 날짜를 기준으로 지나간 날짜의 방은 삭제
                        if (!Util.checkWeekDate(room.dayOfSelect)) {
                            roomService.roomDateDelete(room.dayOfSelect);
                        }

                        if(room.dayOfSelect.equals(checkDate)) {
                            if(room.floor == floor) {
                                if(room.type == 1) {
                                    System.out.printf("%d  |     싱글 | %s\n", (room.floor * 100 +room.roomNum), room.booked);
                                }
                                else {
                                    System.out.printf("%d  |     더블 | %s\n", (room.floor * 100 +room.roomNum), room.booked);
                                }
                            }
                        }
                    }

                    System.out.println("===========================================");
                    break;
                }
            }

            break;
        }
    }
}
