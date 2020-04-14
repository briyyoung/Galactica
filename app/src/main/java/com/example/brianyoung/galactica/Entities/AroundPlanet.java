package com.example.brianyoung.galactica.Entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AroundPlanet {

    @SerializedName("planet")
    @Expose
    private String planet;
    @SerializedName("rel")
    @Expose
    private String rel;

    /**
     * No args constructor for use in serialization
     *
     */
    public AroundPlanet() {
    }

    /**
     *
     * @param planet
     * @param rel
     */
    public AroundPlanet(String planet, String rel) {
        super();
        this.planet = planet;
        this.rel = rel;
    }

    public String getPlanet() {
        return planet;
    }

    public void setPlanet(String planet) {
        this.planet = planet;
    }

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

}