package com.example.brianyoung.galactica.Entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Body {

    @SerializedName("englishName")
    @Expose
    private String englishName;
    @SerializedName("moons")
    @Expose
    private Object moons;
    @SerializedName("inclination")
    @Expose
    private Integer inclination;
    @SerializedName("mass")
    @Expose
    private Mass mass;
    @SerializedName("vol")
    @Expose
    private Object vol;
    @SerializedName("density")
    @Expose
    private Integer density;
    @SerializedName("gravity")
    @Expose
    private Integer gravity;
    @SerializedName("meanRadius")
    @Expose
    private Integer meanRadius;
    @SerializedName("flattening")
    @Expose
    private Integer flattening;
    @SerializedName("dimension")
    @Expose
    private String dimension;
    @SerializedName("discoveredBy")
    @Expose
    private String discoveredBy;
    @SerializedName("discoveryDate")
    @Expose
    private String discoveryDate;

    /**
     * No args constructor for use in serialization
     *
     */
    public Body() {
    }

    /**
     *
     * @param inclination
     * @param meanRadius
     * @param englishName
     * @param vol
     * @param discoveryDate
     * @param density
     * @param flattening
     * @param moons
     * @param gravity
     * @param mass
     * @param discoveredBy
     * @param dimension
     */
    public Body(String englishName, Object moons, Integer inclination, Mass mass, Object vol, Integer density, Integer gravity, Integer meanRadius, Integer flattening, String dimension, String discoveredBy, String discoveryDate) {
        super();
        this.englishName = englishName;
        this.moons = moons;
        this.inclination = inclination;
        this.mass = mass;
        this.vol = vol;
        this.density = density;
        this.gravity = gravity;
        this.meanRadius = meanRadius;
        this.flattening = flattening;
        this.dimension = dimension;
        this.discoveredBy = discoveredBy;
        this.discoveryDate = discoveryDate;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public Object getMoons() {
        return moons;
    }

    public void setMoons(Object moons) {
        this.moons = moons;
    }

    public Integer getInclination() {
        return inclination;
    }

    public void setInclination(Integer inclination) {
        this.inclination = inclination;
    }

    public Mass getMass() {
        return mass;
    }

    public void setMass(Mass mass) {
        this.mass = mass;
    }

    public Object getVol() {
        return vol;
    }

    public void setVol(Object vol) {
        this.vol = vol;
    }

    public Integer getDensity() {
        return density;
    }

    public void setDensity(Integer density) {
        this.density = density;
    }

    public Integer getGravity() {
        return gravity;
    }

    public void setGravity(Integer gravity) {
        this.gravity = gravity;
    }

    public Integer getMeanRadius() {
        return meanRadius;
    }

    public void setMeanRadius(Integer meanRadius) {
        this.meanRadius = meanRadius;
    }

    public Integer getFlattening() {
        return flattening;
    }

    public void setFlattening(Integer flattening) {
        this.flattening = flattening;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getDiscoveredBy() {
        return discoveredBy;
    }

    public void setDiscoveredBy(String discoveredBy) {
        this.discoveredBy = discoveredBy;
    }

    public String getDiscoveryDate() {
        return discoveryDate;
    }

    public void setDiscoveryDate(String discoveryDate) {
        this.discoveryDate = discoveryDate;
    }

}