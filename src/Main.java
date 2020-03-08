import api.ApiRequest;
import dto.SatellitePosition;
import org.json.JSONArray;
import org.json.JSONObject;
import protocol.MeadeProtocol;
import services.MountControlThread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static String longitude;
    public static String latitude;
    public static MeadeProtocol mp;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your longitude (DDD*MM:SS)");
        longitude = scanner.nextLine();
        System.out.println("Please enter your latitude (sDD*MM)");
        latitude = scanner.nextLine();

        mp = new MeadeProtocol("COM1", longitude, latitude);
        mp.openPort();

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

        MountControlThread mct = new MountControlThread(positionQueue, mp);
        while(mct.getSize() > 0){
            mct.run();
        }

    }
}
