import api.ApiRequest;
import dto.SatellitePosition;
import org.json.JSONArray;
import org.json.JSONObject;
import services.UnixTimeConverter;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        // Example to execute API request:
        String response = ApiRequest.getSatellitePosition(25544, (float)51.256214, (float)7.150764,
                            350, 2, "ENTER-API-KEY-HERE");

        JSONObject obj = new JSONObject(response);
        String satName = obj.getJSONObject("info").getString("satname");
        // Prints "SPACE STATION"
        System.out.println(satName);

        JSONArray arr = obj.getJSONArray("positions");
        Queue<SatellitePosition> positionQueue = new LinkedList<>();

        // A small buffer of 10 positions
        for(int i = 10; i < arr.length(); i++){
            positionQueue.add(SatellitePosition.fromJSONObject(arr.getJSONObject(i)));
        }


    }
}
