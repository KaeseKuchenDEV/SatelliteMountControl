package protocol;

import jssc.SerialPortException;
import serialport.SerialPortConnection;

public class MeadeProtocol {

    private SerialPortConnection spc;
    private boolean isPortOpened;


    public MeadeProtocol(String portName){
        spc = new SerialPortConnection(portName);
        isPortOpened = false;
    }

    public void moveToObject(float righAscension, float declination){

    }

    public void openPort(){
        isPortOpened = spc.openPort();
    }

    public void closePort(){
        isPortOpened = spc.closePort();
    }

}
