package org.example.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

public class Util {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static String getTodayDate() {
        LocalDate now = LocalDate.now();

        return now.format(formatter);
    }

    public static String getSevenDateLater() {
        LocalDate today = LocalDate.now();
        LocalDate sevenDaysLater = today.plusDays(7);

        String sevenDaysLaterString = sevenDaysLater.format(formatter);

        return sevenDaysLaterString;
    }

    public static boolean checkWeekDate(String inputDate) {
        String currentDateStr = getTodayDate();
        LocalDate currentDate = LocalDate.parse(currentDateStr, formatter);
        LocalDate inputLocalDate;

        try {
            inputLocalDate = LocalDate.parse(inputDate);
        } catch (DateTimeParseException e) {
            System.out.println("날짜 형식이 잘못 입력되었습니다. \'yyyy-dd-mm\' 형태로 입력해주세요.");
            return false;
        }

        if(inputLocalDate.isBefore(currentDate)) {
            return false;
        }

        // 현재 날짜와 입력한 날짜 사이의 차이 계산
        int difference = Math.abs((int) (currentDate.toEpochDay() - inputLocalDate.toEpochDay()));

        // 입력한 날짜가 현재 날짜 기준으로 일주일 내에 있는지 확인
        return difference <= 7;
    }

    // 체크인/체크아웃 사이가 몇 일인지 구하기 (숙박기간)
    public static long getDaysBetween(String checkInDate, String checkOutDate) {
        // 체크인, 체크아웃 문자열을 날짜로 파싱
        LocalDate checkInLocalDate = LocalDate.parse(checkInDate, formatter);
        LocalDate checkOutLocalDate = LocalDate.parse(checkOutDate, formatter);

        // 두 날짜 간의 차이 계산
        long daysBetween = ChronoUnit.DAYS.between(checkInLocalDate, checkOutLocalDate);

        return daysBetween;
    }

    // 체크아웃 하루 전날 뽑아내기
    public static String getBeforeOneDay(String checkOutDate) {
        LocalDate localCheckDate = LocalDate.parse(checkOutDate, formatter);
        LocalDate dayBeforeCheckOutDate = localCheckDate.minusDays(1);

        String checkOutDateBefore = dayBeforeCheckOutDate.format(formatter);

        return checkOutDateBefore;
    }
}
