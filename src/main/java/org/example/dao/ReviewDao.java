package org.example.dao;

import org.example.container.Container;
import org.example.db.DBConnection;
import org.example.dto.Review;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    public List<Review> getForPrintReviews() {
        StringBuilder sb = new StringBuilder();

//        sb.append(String.format("SELECT B.roomId, "));
//        sb.append(String.format("R.score, "));
//        sb.append(String.format("G.loginId, "));
//        sb.append(String.format("R.body "));
//        sb.append(String.format("FROM booking AS B INNER JOIN review AS R INNER JOIN guest AS G "));
//        sb.append(String.format("WHERE B.id = R.bookingId AND G.name = B.guestName "));

        sb.append(String.format("SELECT * FROM review "));


        List<Review> reviews = new ArrayList<>();
        List<Map<String, Object>> rows = dbConnection.selectRows(sb.toString());

        for(Map<String, Object> row : rows) {
            reviews.add(new Review(row));
        }

        return reviews;
    }
}
