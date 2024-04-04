package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Util {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static LocalDate getTodayDate() {
        LocalDate now = LocalDate.now();

        return now;
    }

    public static boolean checkWeekDate(String inputDate) {
        LocalDate currentDate = getTodayDate();
        LocalDate inputLocalDate;

        try {
            inputLocalDate = LocalDate.parse(inputDate);
        } catch (DateTimeParseException e) {
            System.out.println("날짜 형식이 잘못 입력되었습니다. \\'yyyy-dd-mm\\' 형태로 입력해주세요.");
            return false;
        }

        // 현재 날짜와 입력한 날짜 사이의 차이 계산
        int difference = Math.abs((int) (currentDate.toEpochDay() - inputLocalDate.toEpochDay()));

        // 입력한 날짜가 현재 날짜 기준으로 일주일 내에 있는지 확인
        return difference <= 7;
    }
}
