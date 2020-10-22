package values;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChildTestInformationStep2Values {

    public static WebElement textTitleStep2;

    public static List<String> diagTestsList = new ArrayList<>();

    public static WebElement buttonSubjectListTab;

    public static String priceTest;

    public static void setDiagTestList(List<WebElement> list) {
        diagTestsList = new ArrayList<>();
        for (WebElement element : list) {
            Pattern pattern = Pattern.compile("\\d*. (.*)");
            Matcher m = pattern.matcher(element.getText());
            if (m.find()) {
                String subject = m.group(1);
                diagTestsList.add(subject);
            }
        }
    }


}
