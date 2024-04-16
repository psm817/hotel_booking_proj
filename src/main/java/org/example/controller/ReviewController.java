package org.example.controller;

import org.example.container.Container;
import org.example.dto.Booking;
import org.example.dto.Guest;
import org.example.dto.Review;
import org.example.service.BookingService;
import org.example.service.GuestService;
import org.example.service.ReviewService;
import org.example.util.Util;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ReviewController extends Controller{
    private Scanner sc;
    private ReviewService reviewService;
    private GuestService guestService;
    private BookingService bookingService;
    private Session session;

    public ReviewController() {
        sc = new Scanner(System.in);
        reviewService = Container.reviewService;
        guestService = Container.guestService;
        bookingService = Container.bookingService;
        session = Container.getSession();
    }

    public void doAction(String cmd, String actionMethodName) {
        switch(actionMethodName) {
            case "list" :
                viewList();
                break;
            case "write" :
                doWriteReview();
                break;
            default :
                System.out.println("존재하지 않는 서비스입니다.");
                break;
        }
    }

    public void viewList() {
        List<Review> forPrintReviews = reviewService.getForPrintReviews();
        double sumScore = 0;

        System.out.printf("============= 최근 리뷰 [%d]개 =============\n", forPrintReviews.size());
        for(int i = forPrintReviews.size() - 1; i >= 0; i--) {
            Review review = forPrintReviews.get(i);
            sumScore += review.score;
        }
        System.out.printf("평균 평점 : [%1.1f]점\n", sumScore/forPrintReviews.size());

        System.out.println("번호 | 객실번호 | 평점 | 작성자ID | 내용");
        for(int i = forPrintReviews.size() - 1; i >= 0; i--) {
            Review review = forPrintReviews.get(i);
            Booking replyBooking = bookingService.getForPrintBooking(review.bookingId);
            Guest replyGuest = guestService.getGuestByName(replyBooking.guestName);

            System.out.printf("%4d |   %6d |  %1.1f |   %6s | %s\n", review.id, replyBooking.roomId, review.score, replyGuest.loginId, review.body);
        }

        System.out.println("===========================================");
    }

    public void doWriteReview() {
        // 로그인 된 게스트 가져오기
        Guest loginedGuest = session.getLoginedGuest();

        // 오늘 날짜로 체크아웃이 지난 booking 가져오기 (후기 작성한 예약목록 가져오기)
        List<Booking> forBookingAbleReview = bookingService.getBookingsAbleReview(loginedGuest.name, Util.getTodayDate());

        int foundBookingCount = forBookingAbleReview.size();
        System.out.printf("[%s]님, 총 [%d]건에 대해 리뷰 작성이 가능합니다.\n", loginedGuest.name, foundBookingCount);

        if(foundBookingCount == 0) {
            System.out.println("리뷰 작성할 객실이 없습니다.");
        }

        else {
            System.out.printf("================== [%s]님 숙박 이력 ==================\n", loginedGuest.name);
            System.out.printf("** 오늘 날짜 : %s **\n", Util.getTodayDate());
            System.out.println("예약번호 | 객실 | 체크인날짜 | 체크아웃날짜");

            // 예약한 목록 출력
            for(int i = 0; i < forBookingAbleReview.size(); i++) {
                Booking bookingByGuest = forBookingAbleReview.get(i);

                System.out.printf("    %4d |  %d | %4s |  %4s\n", bookingByGuest.id, bookingByGuest.roomId, bookingByGuest.checkInDate, bookingByGuest.checkOutDate);
            }

            System.out.println("==========================================================");

            while(true) {
                System.out.print("리뷰를 작성하시겠습니까?) ");
                String answer = sc.nextLine();

                if(answer.equals("yes")) {
                    while(true) {
                        System.out.print("작성하고 싶은 예약번호 입력(숫자만) : ");
                        int answerId = sc.nextInt();
                        sc.nextLine();

                        try {
                            // 예약번호에 따른 booking 가져오기
                            Booking forPrintBooking = bookingService.getForPrintBooking(answerId);

                            if(forPrintBooking.guestName.equals(loginedGuest.name)) {
                                while(true) {
                                    System.out.println("** 평점은 총 5점 만점 중 소수점 첫째자리까지 입력 가능 **");
                                    System.out.print("평점 입력) ");
                                    double score = sc.nextDouble();
                                    sc.nextLine();

                                    // 소수 첫째자리 체크
                                    if(score != Math.round(score * 10) / 10.0) {
                                        System.out.println("평점은 소수점 첫째짜리까지만 입력이 가능합니다.");
                                        continue;
                                    }
                                    else if(score > 5) {
                                        System.out.println("평점은 최대 5점 만점입니다.");
                                        continue;
                                    }
                                    else {
                                        System.out.print("리뷰 작성) ");
                                        String reviewBody = sc.nextLine();

                                        reviewService.doWrite(answerId, loginedGuest.id, reviewBody, score);
                                        System.out.println("리뷰가 등록되었습니다!!");
                                        break;
                                    }
                                }

                                break;
                            }
                            // 만약 게스트 이름이 같지 않다면
                            else {
                                System.out.printf("입력하신 예약번호는 [%s]님의 예약 건이 아닙니다.\n", loginedGuest.name);
                                continue;
                            }

                        } catch (NullPointerException | InputMismatchException e) {
                            System.out.println("예약번호를 잘못 입력하셨습니다.");
                            continue;
                        }
                    }

                    break;
                }

                else if(answer.equals("no")) {
                    System.out.println("리뷰 작성을 중단합니다.");
                    break;
                }

                else {
                    System.out.println("\'yes\' 또는 \'no\'를 입력해주세요");
                    continue;
                }
            }
        }
    }
}
