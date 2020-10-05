package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {
    public static String getStringRepresentation(LocalDate date, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return date.format(formatter);
    }
    public static LocalDate getDateRepresentation(String date, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDate.parse(date, formatter);
    }

    public static String calculateMinimumBirthDate(String startDate) {
        LocalDate educationalYearStartDate = DateUtils.getDateRepresentation(startDate, "dd.MM.yyyy");
        return DateUtils.getStringRepresentation(educationalYearStartDate.minusYears(6).minusMonths(5), "ddMMyyyy");
    }

    public static String calculateMinimumBirthDateWithDots(String startDate) {
        LocalDate educationalYearStartDate = DateUtils.getDateRepresentation(startDate, "dd.MM.yyyy");
        return DateUtils.getStringRepresentation(educationalYearStartDate.minusYears(6).minusMonths(5), "dd.MM.yyyy");
    }
}
