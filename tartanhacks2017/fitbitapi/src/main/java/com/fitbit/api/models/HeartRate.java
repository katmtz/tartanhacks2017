package com.fitbit.api.models;

import android.util.ArrayMap;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kat on 2/11/17.
 */

public class HeartRate {

    /** The numerical time interval  */
    private String interval = "1";
    /** The units of the time interval */
    private String type = "second";
    /** The duration of collection times */
    private String duration = "0";
    /** The dataset of time-heartrate data */
    private List<String> intradayData = new ArrayList<>();

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public String getInterval() {
        return interval;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDuration() {
        return duration;
    }

    /** Returns an array of recently collected heart rates */
    public String[] getHeartRates() {
        return (String[]) intradayData.toArray();
    }

    public void setHeartRates(String[] values) {
        // clear old heart-rates
        intradayData.clear();
        for (String value : values) {
            intradayData.add(value);
        }
    }
}
