package org.example.controller;

import org.example.Container;
import org.example.service.RoomService;
import org.example.util.Util;
import org.example.dto.Room;

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

    public void makeTestData() {
        roomService.add(new Room(Container.roomDao.getNewId(), 1, 3, 1, null, "2024-04-08", "예약가능"));
        roomService.add(new Room(Container.roomDao.getNewId(), 2, 3, 2, null, "2024-04-08", "예약가능"));
        roomService.add(new Room(Container.roomDao.getNewId(), 3, 3, 1, null, "2024-04-08", "예약가능"));
        roomService.add(new Room(Container.roomDao.getNewId(), 4, 3, 2, null, "2024-04-08", "예약가능"));
        roomService.add(new Room(Container.roomDao.getNewId(), 5, 3, 1, "2020-01-01", "2024-04-08", "예약불가"));

        roomService.add(new Room(Container.roomDao.getNewId(), 1, 4, 1, null, "2024-04-08", "예약가능"));
        roomService.add(new Room(Container.roomDao.getNewId(), 2, 4, 2, null, "2024-04-08", "예약가능"));
        roomService.add(new Room(Container.roomDao.getNewId(), 3, 4, 1, null, "2024-04-08", "예약가능"));
        roomService.add(new Room(Container.roomDao.getNewId(), 4, 4, 2, null, "2024-04-08", "예약가능"));
        roomService.add(new Room(Container.roomDao.getNewId(), 5, 4, 1, "2020-01-01", "2024-04-08", "예약불가"));

        roomService.add(new Room(Container.roomDao.getNewId(), 1, 5, 1, null, "2024-04-08", "예약가능"));
        roomService.add(new Room(Container.roomDao.getNewId(), 2, 5, 2, null, "2024-04-08", "예약가능"));
        roomService.add(new Room(Container.roomDao.getNewId(), 3, 5, 1, null, "2024-04-08", "예약가능"));
        roomService.add(new Room(Container.roomDao.getNewId(), 4, 5, 2, null, "2024-04-08", "예약가능"));
        roomService.add(new Room(Container.roomDao.getNewId(), 5, 5, 1, "2020-01-01", "2024-04-08", "예약불가"));
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
        String[] cmdBits = cmd.split(" ");
        if(cmdBits.length > 2) {
            System.out.println("존재하지 않는 서비스입니다.");
            return;
        }

        System.out.print("확인하시고 싶은 날짜를 입력해주세요) ");
        String checkDate = sc.nextLine();

        if(Util.checkWeekDate(checkDate) == false) {
            System.out.println("오늘 날짜부터 7일간 조회 가능합니다.");
            return;
        }

        System.out.print("층 수를 입력(숫자만) : ");
        int floor = sc.nextInt();
        sc.nextLine();

        if(floor > 5 || floor < 3) {
            System.out.println("층 수를 잘못 입력하셨습니다.");
            System.out.println("3, 4, 5층 중 하나를 입력해주세요.");
        }
        else {
            List<Room> forListRooms = Container.roomDao.rooms;

            System.out.printf("==== [%s] %d층 객실 현황 ====\n", checkDate, floor);
            System.out.println("호수 | 객실타입 | 상태");

            for(int i = 0; i < forListRooms.size(); i++) {
                Room room = forListRooms.get(i);

                if(room.dayOfSelect.equals(checkDate)) {
                    if(room.floor == floor) {
                        System.out.printf("%d  | %8s | %s\n", (room.floor * 100 +room.roomNum), room.type, room.booked);
                    }
                }

                else {
                    System.out.println("조회된 객실이 없습니다.");
                    return;
                }
            }

            System.out.println("====================================");
        }
    }
}
