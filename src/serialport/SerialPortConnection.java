package serialport;

import jssc.SerialPort;
import jssc.SerialPortException;

public class SerialPortConnection {

    private SerialPort serialPort;

    public SerialPortConnection(String portName){
        serialPort = new SerialPort(portName);
    }

    public boolean openPort(){
        if(!serialPort.isOpened()){
            try{
                serialPort.openPort();
                System.out.println("The port has been opened");
                serialPort.setParams(9600, 8, 1, 0);
                return true;
            }catch (SerialPortException ex){
                System.out.println("There was an error thrown, when opening the port!");
                System.out.println(ex.getMessage());
                return false;
            }
        }
        return false;
    }

    public void writeToPort(String message) throws SerialPortException{
        if(serialPort.isOpened()){
                serialPort.writeBytes(message.getBytes());
                System.out.println("Sent message: " + message);
        }else {
            System.out.println("The serial port has to be opened, before writing to it!");
        }
    }

    public boolean closePort(){
        if(serialPort.isOpened()){
            try{
                serialPort.closePort();
                System.out.println("The port has been closed!");
                return false;
            }catch (SerialPortException ex){
                System.out.println("There was an error thrown, when closing the port!");
                System.out.println(ex.getMessage());
                return true;
            }
        }
        return true;
    }



}
