package org.example.dao;

import org.example.container.Container;
import org.example.db.DBConnection;
import org.example.dto.Review;

import java.util.ArrayList;
import java.util.List;

public class ReviewDao extends Dao {
    public List<Review> reviews;
    private DBConnection dbConnection;

    public ReviewDao() {
        reviews = new ArrayList<>();
        dbConnection = Container.getDBConnection();
    }

    public int doWrite(int answerId, int guestId, String reviewBody, double score) {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("INSERT INTO review "));
        sb.append(String.format("SET regDate = NOW(), "));
        sb.append(String.format("bookingId = %d, ", answerId));
        sb.append(String.format("guestId = %d, ", guestId));
        sb.append(String.format("`body` = '%s', ", reviewBody));
        sb.append(String.format("score = '%1$f' ", score));

        return dbConnection.insert(sb.toString());
    }
}
