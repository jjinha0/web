package secondfourthWeek;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Scanner;

/**
 * Created by danawacomputer on 2017-04-18.
 */
public class TheDayMartOffService implements TemporalAdjuster{

    public Temporal adjustInto(Temporal temporal) {

        //첫째날 Scanner로 받아서 둘째주 넷째주 구하기
        LocalDate theDay = LocalDate.from(temporal);
        //LocalDate firstDay = tempday.withDayOfMonth(1);
        LocalDate secondWeek = theDay.with(TemporalAdjusters.dayOfWeekInMonth(2,DayOfWeek.THURSDAY));
        LocalDate fourthWeek = theDay.with(TemporalAdjusters.dayOfWeekInMonth(4,DayOfWeek.THURSDAY));


        if(theDay.isBefore(secondWeek)) {
            return secondWeek;
        }
        else
            return fourthWeek;

    }

}
