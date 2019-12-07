import api.ApiRequest;
import org.json.JSONArray;
import org.json.JSONObject;

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
        for(int i = 0; i < arr.length(); i++){
            float rightAscension = arr.getJSONObject(i).getFloat("ra");
            // Prints i.e "86.75657"
            System.out.println(rightAscension);
        }

    }
}
