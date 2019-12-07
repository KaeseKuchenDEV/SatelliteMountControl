package api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiRequest {

    public static String getSatellitePosition(int satId, float observerLat, float observerLng,
                                              float observerAlt, int seconds, String apiKey){
        try {
            return executeGetRequest("https://www.n2yo.com/rest/v1/satellite/positions/"
                                        + satId + "/" + observerLat + "/" + observerLng
                                        + "/" + observerAlt + "/" + seconds + "&apiKey=" + apiKey);
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String executeGetRequest(String targetUrl) throws IOException {
        HttpURLConnection con = null;
        StringBuilder response = new StringBuilder();

        URL url = new URL(targetUrl);
        con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String line;
        while((line = reader.readLine()) != null){
            response.append(line);
        }
        reader.close();
        return response.toString();
    }

}
