package utils;

import utils.enums.TestingType;
import values.ChildTestInformationStep2Values;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.*;

public class TestMail {

    public static void check(String checkName, TestingType diagnostickTest, String reference, String support, String link) throws InterruptedException, MessagingException, IOException {
        String host = "pop.mail.ru";// change accordingly
        String storeType = "pop3";
        String user = "testmail.distantisotm@mail.ru";// change accordingly
        String password = "password";// change accordingly


        //create properties field
        Properties properties = new Properties();

        properties.put("mail.pop3.host", host);
        properties.put("mail.pop3.port", "995");
        properties.put("mail.pop3.starttls.enable", "true");
        Session emailSession = Session.getDefaultInstance(properties);

        //create the POP3 store object and connect with the pop server
        Store store = null;
        Folder emailFolder = null;

        Message message = null;

        for (int i = 0; i < 30; i++) {
            store = emailSession.getStore("pop3s");
            store.connect(host, user, password);

            //create the folder object and open it
            emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);

            // retrieve the messages from the folder in an array and print it
            Message[] messages = emailFolder.getMessages();

            for (int j = 0; j < messages.length; j++) {
                Message messageTemp = messages[j];
                if (messageTemp.getSubject().contains(GenerateRandomNumber.getRandomNumber())) {
                    message = messageTemp;
                    break;
                }
            }
            if (message != null) {
                break;
            }
            Thread.sleep(5000);
        }

        if (message == null) {
            System.out.println("Письмо не найдено " + GenerateRandomNumber.getRandomNumber());
            assert false;
        }

        Multipart mp = (Multipart) message.getContent();
        BodyPart bp = mp.getBodyPart(0);
        String mailBody = bp.getContent().toString();

        if (checkName != null) {
            assert mailBody.contains(GenerateRandomNumber.getRandomNumber() + " " + checkName);
        }
        if (diagnostickTest != null) {
        assert mailBody.contains(diagnostickTest.getName());
        if(diagnostickTest.equals(TestingType.DIAG_TESTING))
            determinateMailDiaglist(mailBody, "<li>(.*?)</li>");
        if(diagnostickTest.equals(TestingType.ENTRANCE_TESTING))
            determinateMailDiaglist(mailBody, "</a>\\R.*\\((.*)\\)\\R.*</li>");
        }
        if (reference != null) {
            assert mailBody.contains(reference);
        }
        if (support != null) {
            assert mailBody.contains(support);
        }
        /*if (link != null) {
            assert mailBody.contains(link);
        }*/

        emailFolder.close(false);
        store.close();

    }

    public static void determinateMailDiaglist(String mailBody, String patternString) {
        List<String> diagTestMailList = new ArrayList<>();
        Pattern pattern = Pattern.compile(patternString);
        Matcher m = pattern.matcher(mailBody);
        while (m.find()) {
            String subject = m.group(1);
            diagTestMailList.add(subject);
        }

        List<String> digTestListRequest = ChildTestInformationStep2Values.diagTestsList;

        assert diagTestMailList.size() == digTestListRequest.size();

        for (int i = 0; i < digTestListRequest.size(); i++) {
            assert digTestListRequest.get(i).equals(diagTestMailList.get(i));
        }
    }
}
