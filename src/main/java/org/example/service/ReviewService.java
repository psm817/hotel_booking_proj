package org.example.service;

import org.example.container.Container;
import org.example.dao.BookingDao;
import org.example.dao.ReviewDao;

public class ReviewService {
    private ReviewDao reviewDao;

    public ReviewService() {
        reviewDao = Container.reviewDao;
    }

    public int doWrite(int answerId, int guestId, String reviewBody, double score) {
        return reviewDao.doWrite(answerId, guestId, reviewBody, score);
    }
}
