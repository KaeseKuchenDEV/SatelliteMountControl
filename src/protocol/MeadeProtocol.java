package protocol;

import jssc.SerialPortException;
import serialport.SerialPortConnection;

public class MeadeProtocol {

    private SerialPortConnection spc;
    private boolean isPortOpened;
    private double targetMagnitude, targetDeclination, targetAltitude;


    public MeadeProtocol(String portName){
        spc = new SerialPortConnection(portName);
        isPortOpened = false;
    }

    public void moveToObject(double altitude, double magnitude, double declination){

    }

    public void setTargetMagnitude(double targetMagnitude){
        try {
            spc.writeToPort("");
        } catch (SerialPortException ex) {
            System.out.println("There was an error thrown, when writing to the port!");
            System.out.println(ex.getMessage());
        }
    }

    public void setTargetDeclination(double targetDeclination){

    }

    public void setTargetAltitude(double targetAltitude){

    }

    public void openPort(){
        isPortOpened = spc.openPort();
    }

    public void closePort(){
        isPortOpened = spc.closePort();
    }

}
