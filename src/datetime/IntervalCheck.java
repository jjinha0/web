package datetime;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

/**
 * Created by danawacomputer on 2017-04-18.
 */
public class IntervalCheck {
    public static void main(String[] args) {
        Instant start = Instant.now();
        someAlgorithm();
        Instant end = Instant.now();

        System.out.println((long)Duration.between(start, end).toMillis());

        //탄핵날짜구하기
        LocalDate impeachDay = LocalDate.of(2017,3,10);
        LocalDate toDay = LocalDate.now();
        Period pe = Period.between(impeachDay, toDay);
        System.out.println(pe.getMonths()+"개월 "+ pe.getDays()+"일 지났습니다.");


        LocalDate now = LocalDate.now();
        Period period = impeachDay.until(now);
        int days = period.getDays();
        int months = period.getMonths();

        //다음 수요일 구하기
        LocalDate nextWed = now.with(TemporalAdjusters.next(DayOfWeek.WEDNESDAY));
        System.out.println(nextWed);

        //오늘로부터 이틀 후 구하기
        LocalDate theDay = now.with(new DayAfterTomorrow());
        System.out.println(theDay);

    }
    public static void someAlgorithm() {
        long acc = 0L;
        for(int i=0; i<10000; i++) {
            acc += i;
        }
    }
}
