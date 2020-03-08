package dto;

import org.json.JSONObject;
import services.UnixTimeConverter;

import java.util.Date;

public class SatellitePosition {

    private float rightAscension;
    private float declination;

    private Date timeStamp;

    public static SatellitePosition fromJSONObject(JSONObject object){
        float rightAscension = object.getFloat("ra");
        float declination = object.getFloat("dec");
        Date timeStamp = UnixTimeConverter.getDateFromUnixTimestamp(object.getInt("timestamp"));

        return new SatellitePosition(rightAscension, declination, timeStamp);
    }

    public SatellitePosition(float rightAscension, float declination, Date timeStamp) {
        this.rightAscension = rightAscension;
        this.declination = declination;
        this.timeStamp = timeStamp;
    }

    public String getCalculatedRightAscensionString(){
        // format is HH:MM:SS
        StringBuilder raBuilder = new StringBuilder();
        int hours = (int) rightAscension;
        // i.e. 57.07 has an amount of minutes of 4.2 but the 0.2 is the amount for the seconds
        float wholeMinutes = (rightAscension - hours);
        int minutes = (int) (wholeMinutes * 60);
        float wholeSeconds = (wholeMinutes - minutes);
        int seconds = (int) (wholeSeconds * 60);

        // String building
        if(hours < 10){
            raBuilder.append(0);
        }
        raBuilder.append(hours).append(":");

        if(minutes < 10){
            raBuilder.append(0);
        }
        raBuilder.append(minutes).append(":");

        if(seconds < 10){
            raBuilder.append("0");
        }
        raBuilder.append(seconds);

        return raBuilder.toString();
    }

    public String getCalculatedDeclinationString(){
        // Format: sDD*MM:SS (s = omen)
        StringBuilder decBuilder = new StringBuilder();

        // While the right ascension cannot be negative, the declination can be
        float absoluteDeclination = Math.abs(declination);
        int days = (int) absoluteDeclination;
        float wholeMinutes = (absoluteDeclination - days);
        int minutes = (int) (wholeMinutes * 60);
        float wholeSeconds = (wholeMinutes - minutes);
        int seconds = (int) (wholeSeconds * 60);

        // String building
        if(absoluteDeclination != declination){
            decBuilder.append("-");
        }else {
            decBuilder.append("+");
        }

        if(days < 10){
            decBuilder.append(0);
        }
        decBuilder.append(days).append("*");

        if(minutes < 10){
            decBuilder.append(0);
        }
        decBuilder.append(minutes).append(":");

        if(seconds < 10){
            decBuilder.append("0");
        }
        decBuilder.append(seconds);

        return decBuilder.toString();
    }

    public float getRightAscension() {
        return rightAscension;
    }

    public void setRightAscension(float rightAscension) {
        this.rightAscension = rightAscension;
    }

    public float getDeclination() {
        return declination;
    }

    public void setDeclination(float declination) {
        this.declination = declination;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
}
