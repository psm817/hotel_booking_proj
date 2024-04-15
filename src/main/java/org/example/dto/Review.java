package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class Review extends Dto {
    public String regDate;
    public int bookingId;
    public int guestId;
    public String body;
    public double score;

public Review(Map<String, Object> row) {
    super(row);
    this.regDate = (String) row.get("regDate");
    this.bookingId = (int) row.get("bookingId");
    this.guestId = (int) row.get("guestId");
    this.body = (String) row.get("body");
    this.score = (double) row.get("score");
    }
}
