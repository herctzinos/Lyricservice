package service_example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Service_example {

    public static void main(String[] args) throws MalformedURLException, IOException {

        try {
            URL url = new URL("http://api.chartlyrics.com/apiv1.asmx/SearchLyricDirect?artist=tool&song=marie");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed:HTTP error code:" + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            System.out.println(br);
            StringBuilder sb = new StringBuilder();

            String line = null;
            try {
                while ((line = br.readLine()) != null) {
                    sb.append(line + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            } 
            System.out.println(sb);
        }
        finally{}
    }

}
