package com.fitbit.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by kat on 2/11/17.
 */

public class HR_Dataset {

    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("value")
    @Expose
    private Integer value;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
