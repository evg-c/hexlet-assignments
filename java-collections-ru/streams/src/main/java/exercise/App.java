package exercise;

//import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;
//import java.util.stream.Stream;

// BEGIN
public class App {

    public static void main(String[] args) {
        String[] emails = {
            "info@gmail.com",
            "info@yandex.ru",
            "mk@host.com",
            "support@hexlet.io",
            "info@hotmail.com",
            "support.yandex.ru@host.com"
        };
        List<String> emailsList = Arrays.asList(emails);
        System.out.println(App.getCountOfFreeEmails(emailsList)); // 3
    }

    public static int getCountOfFreeEmails(List<String> emails) {
        String[] domains = {
            "gmail.com",
            "yandex.ru",
            "hotmail.com"
        };
//        List<String> domainList = new ArrayList<>();
//        domainList = Stream.of("gmail.com", "yandex.ru", "hotmail.com")
//                .collect(Collectors.toList());
//        int countEmails = 0;
        List<String> domainList = Arrays.asList(domains);
//        for (String email: emails) {
//            int posDomain = email.indexOf("@");
//            if (posDomain == -1) {
//                continue;
//            }
//            String domainCurrentEmail = email.substring(posDomain + 1);
//            if (!domainList.contains(domainCurrentEmail)) {
//                continue;
//            }
//            countEmails++;
//        }
//        return countEmails;
        List<String> mails = emails.stream()
                .filter(mail -> mail.indexOf("@") > 0)
                .map(mail -> mail.substring(mail.indexOf("@") + 1))
                .collect(Collectors.toList());
//        System.out.println(mails);
//        return (int) mails.count();
        mails.retainAll(domainList);
        return mails.size();
    }
}
// END
