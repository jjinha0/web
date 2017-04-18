package secondfourthWeek;

import java.time.LocalDate;
import java.time.temporal.Temporal;
import java.util.Scanner;

/**
 * Created by danawacomputer on 2017-04-18.
 */
public class TheDayMartOff {
    public static void main(String[] args) {
        //오늘날짜 입력받기
        System.out.printf("오늘 날짜를 입력하세요.\n");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] number = line.split("-");
        LocalDate tempday = LocalDate.of(Integer.parseInt(number[0]), Integer.parseInt(number[1]), Integer.parseInt(number[2]));

        LocalDate nextMartOffDay = tempday.with(new TheDayMartOffService());
        System.out.println(nextMartOffDay);

    }
}
