package com.fitbit.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by kat on 2/11/17.
 * Fitbit Intraday Heart Rate Time Series:
 * Includes HR zones and resting heart rate
 */

public class HR_TimeSeries {

    @SerializedName("customHeartRateZones")
    @Expose
    private HR_Zone[] customZones;
    @SerializedName("dateTime")
    @Expose
    private String dateTime;
    @SerializedName("heartRateZones")
    @Expose
    private HR_Zone[] standardZones;
    @SerializedName("value")
    @Expose
    private String restingHeartRate;

    public String getRestingHeartRate() {
        return restingHeartRate;
    }

    public void setRestingHeartRate(String restingHeartRate) {
        this.restingHeartRate = restingHeartRate;
    }

    public void setStandardZones(HR_Zone[] standardZones) {
        this.standardZones = standardZones;
    }

    public HR_Zone[] getStandardZones() {
        return standardZones;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public HR_Zone[] getCustomZones() {
        return customZones;
    }

    public void setCustomZones(HR_Zone[] customZones) {
        this.customZones = customZones;
    }
}
