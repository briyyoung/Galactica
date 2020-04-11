package com.example.brianyoung.galactica.Entities;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SolarSystem {

    @SerializedName("bodies")
    @Expose
    private List<Body> bodies = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public SolarSystem() {
    }

    /**
     *
     * @param bodies
     */
    public SolarSystem(List<Body> bodies) {
        super();
        this.bodies = bodies;
    }

    public List<Body> getBodies() {
        return bodies;
    }

    public void setBodies(List<Body> bodies) {
        this.bodies = bodies;
    }

}