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
