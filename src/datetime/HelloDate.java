package datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;

/**
 * Created by danawacomputer on 2017-04-18.
 */
public class HelloDate {
    public static void main(String[] args) {
        long current = System.currentTimeMillis();
        System.out.println(current);

        LocalDate d = LocalDate.now();
        System.out.println(d);

        LocalTime t = LocalTime.now();
        System.out.println(t);

        LocalDateTime dt = LocalDateTime.now();
        System.out.println(dt);

        ZonedDateTime zdt = ZonedDateTime.now();
        System.out.println(zdt);
    }
}
