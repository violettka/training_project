package values;

import utils.DateUtils;

import java.time.LocalDate;
import java.time.Period;

public class ChildTestInformationStep1Values {

    public static LocalDate childBirthDate;
    public static String educationalStartDate;

    public static String getChildBirthDateString() {
        return DateUtils.getStringRepresentation(childBirthDate, "ddMMyyyy");
    }
    public static String getChildBirthDateStringRequestPage() {
        return DateUtils.getStringRepresentation(childBirthDate, "dd.MM.yyyy");
    }

    public static void setBirthDateYears(int years) {
        childBirthDate = LocalDate.now().minus(Period.ofYears(years));
    }
}
