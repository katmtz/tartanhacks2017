package com.fitbit.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by kat on 2/11/17.
 */

public class HR_Intraday {

    @SerializedName("dataset")
    @Expose
    private HR_Dataset dataset;
    @SerializedName("datasetInterval")
    @Expose
    private Integer interval;
    @SerializedName("datasetType")
    @Expose
    private String type;

    public HR_Dataset getDataset() {
        return dataset;
    }

    public void setDataset(HR_Dataset dataset) {
        this.dataset = dataset;
    }

    public Integer getInterval() {
        return interval;
    }

    public void setInterval(Integer interval) {
        this.interval = interval;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
