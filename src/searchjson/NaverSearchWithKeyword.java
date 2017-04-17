package searchjson;

import java.util.List;

/**
 * Created by danawacomputer on 2017-04-17.
 */
public class NaverSearchWithKeyword {
    public static void main(String[] args) {

        String search = "자바라";

        String jsonlink = NaverApiAgent2.searchReturnJson(search);

        System.out.println("4번째 블로그의 bloglink : " + jsonlink);

        List<String> json = NaverApiAgent2.searchReturnIOOJson(search, 100);

        int count = 1;
        for (String e : json) {
            System.out.printf("> %d blogName = " + e + "\n", count);
            count++;
        }



    }
}
