package searchjson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by danawacomputer on 2017-04-17.
 */
public class NaverApiAgent2 {

    public static String clientId = "1IU_nqebCJzq8n0oiN_K";
    public static String clientSecret = "VVImcC3JQk";


    public static String searchReturnJson(String searchtext){

        try {
            String text = URLEncoder.encode(searchtext,"UTF-8");
            String apiUrl = "https://openapi.naver.com/v1/search/blog?query="+ text;

            URL url = new URL(apiUrl);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");
            conn.setRequestProperty("X-Naver-Client-Id", clientId);
            conn.setRequestProperty("X-Naver-Client-Secret", clientSecret);
            int responseCode = conn.getResponseCode();
            BufferedReader br;


            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();


            JSONObject obj = new JSONObject(response.toString());

            JSONArray jsonarr= obj.getJSONArray("items");
            String address = jsonarr.getJSONObject(3)
                    .getString("bloggerlink");


            return address;

        } catch (Exception e){
            System.out.println(e);
            return "Error";
        }

    }


    public static List searchReturnIOOJson(String searchText, int max){

        List<String> blogName = new ArrayList<>();

        try {
            String text = URLEncoder.encode(searchText,"UTF-8");
            String apiUrl = "https://openapi.naver.com/v1/search/blog?query="
                    + text + "&display=" + max;

            URL url = new URL(apiUrl);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");

            conn.setRequestProperty("X-Naver-Client-Id", clientId);
            conn.setRequestProperty("X-Naver-Client-Secret", clientSecret);
            int responseCode = conn.getResponseCode();
            BufferedReader br;


            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();

            JSONObject obj = new JSONObject(response.toString());

            JSONArray jsonarr= obj.getJSONArray("items"); //JSONArray "items"를 getJSONArray를 이용해서 jsonarr에 넣는다.

            for(int i = 0; i < max; i++){

                blogName.add(jsonarr.getJSONObject(i).getString("bloggername")); //

            }

            return blogName;


        } catch (Exception e){
            System.out.println(e);
            return null;
        }

    }
}