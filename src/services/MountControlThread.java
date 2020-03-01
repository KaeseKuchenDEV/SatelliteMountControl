package services;

import dto.SatellitePosition;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Queue;

public class MountControlThread extends Thread{

    private Queue<SatellitePosition> positions;

    public MountControlThread(Queue<SatellitePosition> positions){
        this.positions = positions;
    }

    public void run(){
        SatellitePosition currentPos = positions.remove();

        if(!currentPos.getTimeStamp().after(new Date())){
            boolean executed = false;

            Calendar positionCalendar = Calendar.getInstance();
            positionCalendar.setTime(currentPos.getTimeStamp());

            while (!executed){
                if(LocalDateTime.now().getHour() == positionCalendar.HOUR_OF_DAY &&
                    LocalDateTime.now().getMinute() == positionCalendar.MINUTE &&
                    LocalDateTime.now().getSecond() == positionCalendar.SECOND){

                }
            }
        }
    }

}
