package apiexample;

import java.io.*;



/**
 * Created by danawacomputer on 2017-04-17.
  */

//1.파일에서 한 라인씩 읽어온다. 2.라인을 파파고 번역서비스에 번역 요청한다. 3. 결과JSON을 파싱하여 콘솔에 출력한다.
public class JsonDemo {

    public static void main(String[] args) {

        try {
            BufferedReader fbr = new BufferedReader(new FileReader("closer.txt"));
            String line = "";

            while ((line = fbr.readLine()) != null) {

                if (line.trim().equals("")) {
                    continue;
                }


                String result = NaverApiAgent.translate("en", "ko", line);
                System.out.println(result);

            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
                 catch (Exception e) {
                    System.out.println(e);
                }


            }


    }
