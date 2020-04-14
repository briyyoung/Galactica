package com.example.brianyoung.galactica.Entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Vol {

    @SerializedName("volValue")
    @Expose
    private Double volValue;
    @SerializedName("volExponent")
    @Expose
    private Integer volExponent;

    /**
     * No args constructor for use in serialization
     *
     */
    public Vol() {
    }

    /**
     *
     * @param volValue
     * @param volExponent
     */
    public Vol(Double volValue, Integer volExponent) {
        super();
        this.volValue = volValue;
        this.volExponent = volExponent;
    }

    public Double getVolValue() {
        return volValue;
    }

    public void setVolValue(Double volValue) {
        this.volValue = volValue;
    }

    public Integer getVolExponent() {
        return volExponent;
    }

    public void setVolExponent(Integer volExponent) {
        this.volExponent = volExponent;
    }

}