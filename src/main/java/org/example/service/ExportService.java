package org.example.service;

import org.example.container.Container;
import org.example.dto.Booking;
import org.example.dto.Guest;
import org.example.dto.Review;
import org.example.util.Util;

import java.util.List;

public class ExportService {
    BookingService bookingService;
    GuestService guestService;
    ReviewService reviewService;

    public ExportService() {
        bookingService = Container.bookingService;
        guestService = Container.guestService;
        reviewService = Container.reviewService;
    }

    public void makeHtml() {
        List<Review> reviews = reviewService.getForPrintReviews();

        for(int i = reviews.size() - 1; i >= 0; i--) {
            Review review = reviews.get(i);
            Booking replyBooking = bookingService.getForPrintBooking(review.bookingId);
            Guest replyGuest = guestService.getGuestByName(replyBooking.guestName);

            String fileName = review.id + "번 리뷰.html";
            String html = "<meta charset=\"UTF-8\">";
            html += "<h1>리뷰</h1>";
            html += "<div>번호 : " + review.id + "</div>";
            html += "<div>객실번호 : " + replyBooking.roomId + "</div>";
            html += "<div>평점 : " + review.score + "</div>";
            html += "<div>작성자ID : " + replyGuest.loginId + "</div>";
            html += "<div>내용 : " + review.body + "</div>";

            if(review.id > 1) {
                html += "<div><a href=\"" + (review.id - 1) + "번 리뷰.html\">이전글</a></div>";
            }
            html += "<div><a href=\"" + (review.id + 1) + "번 리뷰.html\">다음글</a></div>";

            Util.writeFileContents("exportHtml/" + fileName, html);
        }
    }
}
