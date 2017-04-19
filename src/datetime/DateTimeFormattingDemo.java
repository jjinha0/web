package datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by danawacomputer on 2017-04-19.
 */
public class DateTimeFormattingDemo {

    public static void main(String[] args) {
        LocalDate today = LocalDate.now(); //현재날짜
        LocalTime now = LocalTime.now(); //현재시간

        System.out.println(today + " " + now);

        LocalDateTime todayAndNow = LocalDateTime.now();

        //포매팅                              ofPattern("대소문자주의")
        String formatted = DateTimeFormatter.ofPattern("yyyy.MM.dd. HH:mm").format(todayAndNow);
        System.out.println(formatted);
    }
}
