package webclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by danawacomputer on 2017-04-14.
 */
public class URLNaverMain {

    public static void main(String[] args) {

        try {

            URL url = new URL("http://www.president.go.kr/");
            URLConnection conn = url.openConnection();

            String contentType = conn.getContentType();
            String encoding = conn.getContentEncoding();
            System.out.println(contentType);
            System.out.println(encoding);
//            InputStream is = url.openStream();
//            InputStreamReader isr = new InputStreamReader(url.openStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            List<String> list = new ArrayList<>();
            String line = "";
            while((line = br.readLine()) != null) {

                String[] splitted = line.split(" ");
                for(String e : splitted) {
                    list.add(e);
                }
            }
            System.out.println(list.size());

            //분석
            int count = 0;
            for(String e : list) {
                if(!e.trim().equals("")) { //trim 양쪽에 있는 공백문자 싹 없애버림
                   count++;
                }
            }

            System.out.println(count);




        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
