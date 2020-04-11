package com.example.brianyoung.galactica.Entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Mass {

    @SerializedName("massValue")
    @Expose
    private Double massValue;
    @SerializedName("massExponent")
    @Expose
    private Integer massExponent;

    /**
     * No args constructor for use in serialization
     *
     */
    public Mass() {
    }

    /**
     *
     * @param massExponent
     * @param massValue
     */
    public Mass(Double massValue, Integer massExponent) {
        super();
        this.massValue = massValue;
        this.massExponent = massExponent;
    }

    public Double getMassValue() {
        return massValue;
    }

    public void setMassValue(Double massValue) {
        this.massValue = massValue;
    }

    public Integer getMassExponent() {
        return massExponent;
    }

    public void setMassExponent(Integer massExponent) {
        this.massExponent = massExponent;
    }

}