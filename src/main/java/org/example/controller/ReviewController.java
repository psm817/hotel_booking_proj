package org.example.controller;

import org.example.container.Container;
import org.example.dto.Booking;
import org.example.dto.Guest;
import org.example.dto.Review;
import org.example.service.BookingService;
import org.example.service.GuestService;
import org.example.service.ReviewService;

import java.util.List;
import java.util.Scanner;

public class ReviewController extends Controller{
    private ReviewService reviewService;
    private GuestService guestService;
    private BookingService bookingService;

    public ReviewController() {
        reviewService = Container.reviewService;
        guestService = Container.guestService;
        bookingService = Container.bookingService;
    }

    public void doAction(String cmd, String actionMethodName) {
        switch(actionMethodName) {
            case "list" :
                viewList();
                break;
            default :
                System.out.println("존재하지 않는 서비스입니다.");
                break;
        }
    }

    public void viewList() {
        List<Review> forPrintReviews = reviewService.getForPrintReviews();

        System.out.printf("============= 최근 리뷰 [%d]개 =============\n", forPrintReviews.size());
        System.out.println("번호 | 객실번호 | 평점 | 작성자ID | 내용");

        for(int i = forPrintReviews.size() - 1; i >= 0; i--) {
            Review review = forPrintReviews.get(i);
            Booking replyBooking = bookingService.getForPrintBooking(review.bookingId);
            Guest replyGuest = guestService.getGuestByName(replyBooking.guestName);

            System.out.printf("%4d |   %6d |  %1.1f |   %6s | %s\n", review.id, replyBooking.roomId, review.score, replyGuest.loginId, review.body);
        }
        System.out.println("===========================================");
    }
}
