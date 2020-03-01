package services;

import java.util.Date;

public class UnixTimeConverter {

    public static Date getDateFromUnixTimestamp(int timestamp){
        return new Date((long)timestamp * 1000);
    }
}
