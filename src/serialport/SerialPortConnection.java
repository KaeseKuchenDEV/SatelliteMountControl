package me.hendrikloewe.mtc.serialport;

import jssc.SerialPort;
import jssc.SerialPortException;

public class SerialPortConnection {

    private SerialPort serialPort;

    public SerialPortConnection(String portName){
        serialPort = new SerialPort(portName);
    }

    public void openPort(){
        if(!serialPort.isOpened()){
            try{
                serialPort.openPort();
                System.out.println("The port has been opened");
                serialPort.setParams(9600, 8, 1, 0);
            }catch (SerialPortException ex){
                System.out.println("There was an error thrown, when opening the port!");
                System.out.println(ex.getMessage());
            }
        }
    }

    public void writeToPort(String message){
        if(serialPort.isOpened()){
            try{
                serialPort.writeBytes(message.getBytes());
                System.out.println("Sent message: " + message);
            }catch (SerialPortException ex){
                System.out.println("There was an error thrown, when writing to the port!");
                System.out.println(ex.getMessage());
            }
        }else {
            System.out.println("The serial port has to be opened, before writing to it!");
        }
    }

    public void closePort(){
        if(serialPort.isOpened()){
            try{
                serialPort.closePort();
                System.out.println("The port has been closed!");
            }catch (SerialPortException ex){
                System.out.println("There was an error thrown, when closing the port!");
                System.out.println(ex.getMessage());
            }
        }
    }



}
