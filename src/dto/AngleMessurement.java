package dto;

public class AngleMessurement {

    private int degrees, minutes, seconds;

    public AngleMessurement(){ }

    public AngleMessurement(int degrees, int minutes, int seconds) {
        this.degrees = degrees;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public int getDegrees() {
        return degrees;
    }

    public void setDegrees(int degrees) {
        this.degrees = degrees;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }
}
