package datetime;

import java.time.LocalDate;

/**
 * Created by danawacomputer on 2017-04-18.
 */
public class CountDday {
    public static void main(String[] args) {
        LocalDate baseDay = LocalDate.of(2016, 4, 3);
        LocalDate fiftyDay = baseDay.plusDays(49);
        LocalDate oneHundredDay = baseDay.plusDays(99);
        LocalDate twoHundredDay = baseDay.plusDays(199);
        LocalDate fiveHundredDay = baseDay.plusDays(499);
        LocalDate oneThousandDay = baseDay.plusDays(999);
        System.out.println(fiftyDay);
        System.out.println(oneHundredDay);
        System.out.println(twoHundredDay);
        System.out.println(fiveHundredDay);
        System.out.println(oneThousandDay);

    }
}
