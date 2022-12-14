package exercise;

import java.util.List;

// BEGIN
public class App {
    public static long getCountOfFreeEmails(List<String> emails) {
        return emails.stream()
                .filter(email -> email.contains("@"))
                .map(email -> email.split("@"))
                .map(array -> array[1])
                .filter(email -> email.equals("gmail.com") || email.equals("yandex.ru") || email.equals("hotmail.com"))
                .count();
    }
}
// END
