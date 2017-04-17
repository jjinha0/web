package apiexample;

import org.json.JSONObject;

import java.io.*;
import java.net.*;

/**
 * Created by danawacomputer on 2017-04-17.
 */
public class NaverApiAgent {
    public static String CLIENT_ID = "1IU_nqebCJzq8n0oiN_K";//애플리케이션 클라이언트 아이디값";
    public static String CLIENT_SECRET = "VVImcC3JQk";//애플리케이션 클라이언트 시크릿값";

    public static String translate(String source, String target, String text) {
        try {
            String requestText = URLEncoder.encode(text, "UTF-8");
            String apiURL = "https://openapi.naver.com/v1/language/translate";
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("X-Naver-Client-Id", CLIENT_ID);
            con.setRequestProperty("X-Naver-Client-Secret", CLIENT_SECRET);
            // post request
            String postParams = "source=" + source + "&target="
                    + target + "&text=" + requestText;
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(postParams);
            wr.flush();
            wr.close();
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if (responseCode == 200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            JSONObject obj = new JSONObject(response.toString());

            JSONObject msgObj = obj.getJSONObject("message");
            JSONObject resObj = msgObj.getJSONObject("result");
            String result = resObj.getString("translatedText");


            return result;
        } catch (Exception e) {
            System.out.println(e);
            return "";
        }
    }
}