package cn.hn.others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by huangning on 2018/4/10.
 */
public class WebPageResource {
    public static String getPageResource(String pageUrl, String encode) {
        StringBuffer buffer = new StringBuffer();
        BufferedReader reader = null;
        try {
            URL url = new URL(pageUrl);
            reader = new BufferedReader(new InputStreamReader(url.openStream(), encode));
            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
                buffer.append("\n");
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        String pageUrl = "http://localhost:8080/education/#/login";
        String encode = "UTF-8";
        System.out.println(WebPageResource.getPageResource(pageUrl, encode));


    }
}
