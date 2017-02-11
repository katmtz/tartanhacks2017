package com.fitbit.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by kat on 2/11/17.
 *
 * For Fitbit's Intraday Heart Rate Time Series
 */

public class HeartRate {

    @SerializedName("activities-heart")
    @Expose
    private HR_TimeSeries timeSeries;
    @SerializedName("activities-heart-intraday")
    @Expose
    private HR_Intraday intraday;

    public HR_TimeSeries getTimeSeries() {
        return timeSeries;
    }

    public void setTimeSeries(HR_TimeSeries timeSeries) {
        this.timeSeries = timeSeries;
    }

    public HR_Intraday getIntraday() {
        return intraday;
    }

    public void setIntraday(HR_Intraday intraday) {
        this.intraday = intraday;
    }
}
