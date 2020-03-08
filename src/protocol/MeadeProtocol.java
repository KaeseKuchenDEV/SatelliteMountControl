package protocol;

import serialport.SerialPortConnection;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class MeadeProtocol {

    private SerialPortConnection spc;
    private boolean isPortOpened;
    private String longitude;
    private String latitude;

    public MeadeProtocol(String portName, String longitude, String latitude){
        spc = new SerialPortConnection(portName);
        isPortOpened = false;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public void moveToObject(String rightAscension, String declination){
        // Set the rightAscension(":Sr HH:MM:SS#")
        spc.writeToPort(":Sr " + rightAscension + "#");
        // Set the declination(":Sd sDD*MM:SS#")
        spc.writeToPort(":Sd " + declination + "#");
        // Set the offset from Greenwich
        // TODO: currently static to the timezone of germany!!!
        spc.writeToPort(":SG +01#");
        // Set the observer´s longitude
        spc.writeToPort(":Sg " + longitude + "#");
        // Set the observer´s latitude
        spc.writeToPort(":St " + latitude + "#");

        // Set the current time and date:
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yy");
        LocalDateTime now = LocalDateTime.now();

        spc.writeToPort(":SL " + timeFormatter.format(now) + "#");
        spc.writeToPort(":SC " + dateFormatter.format(now) + "#");

        //Slew:
        spc.writeToPort(":CM#");
        spc.writeToPort(":MS#");
        System.out.println("Slewing to " + rightAscension + " " + declination);
    }

    public void openPort(){
        isPortOpened = spc.openPort();
    }

    public void closePort(){
        isPortOpened = spc.closePort();
    }

}
