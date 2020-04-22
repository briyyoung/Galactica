package com.example.brianyoung.galactica.Entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SolarSystem {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("englishName")
    @Expose
    private String englishName;
    @SerializedName("eccentricity")
    @Expose
    private Double eccentricity;
    @SerializedName("mass")
    @Expose
    private Mass mass;
    @SerializedName("vol")
    @Expose
    private Vol vol;
    @SerializedName("density")
    @Expose
    private Double density;
    @SerializedName("gravity")
    @Expose
    private Double gravity;
    @SerializedName("meanRadius")
    @Expose
    private Double meanRadius;
    @SerializedName("equaRadius")
    @Expose
    private Double equaRadius;
    @SerializedName("dimension")
    @Expose
    private String dimension;
    @SerializedName("aroundPlanet")
    @Expose
    private Object aroundPlanet;
    private String discoveredBy;
    @SerializedName("discoveryDate")
    @Expose
    private String discoveryDate;

    /**
     * No args constructor for use in serialization
     *
     */
    public SolarSystem() {
    }

    /**
     *
     * @param meanRadius
     * @param englishName
     * @param semimajorAxis
     * @param mass
     * @param discoveredBy
     * @param isPlanet
     * @param perihelion
     * @param aphelion
     * @param sideralRotation
     * @param vol
     * @param id
     * @param aroundPlanet
     * @param alternativeName
     * @param escape
     * @param dimension
     * @param inclination
     * @param polarRadius
     * @param sideralOrbit
     * @param density
     * @param flattening
     * @param eccentricity
     * @param equaRadius
     * @param discoveryDate
     * @param gravity
     * @param name
     */
    public SolarSystem(String id, String name, String englishName, Boolean isPlanet, Long semimajorAxis, Integer perihelion, Integer aphelion, Double eccentricity, Integer inclination, Mass mass, Vol vol, Double density, Double gravity, Double escape, Double meanRadius, Double equaRadius, Double polarRadius, Double flattening, String dimension, Double sideralOrbit, Double sideralRotation, Object aroundPlanet, String discoveredBy, String discoveryDate, String alternativeName) {
        super();
        this.id = id;
        this.name = name;
        this.englishName = englishName;
        this.eccentricity = eccentricity;
        this.mass = mass;
        this.vol = vol;
        this.density = density;
        this.gravity = gravity;
        this.meanRadius = meanRadius;
        this.equaRadius = equaRadius;
        this.dimension = dimension;
        this.aroundPlanet = aroundPlanet;
        this.discoveredBy = discoveredBy;
        this.discoveryDate = discoveryDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public Double getEccentricity() {
        return eccentricity;
    }

    public void setEccentricity(Double eccentricity) {
        this.eccentricity = eccentricity;
    }

    public Mass getMass() {
        return mass;
    }

    public void setMass(Mass mass) {
        this.mass = mass;
    }

    public Vol getVol() {
        return vol;
    }

    public void setVol(Vol vol) {
        this.vol = vol;
    }

    public Double getDensity() {
        return density;
    }

    public void setDensity(Double density) {
        this.density = density;
    }

    public Double getGravity() {
        return gravity;
    }

    public void setGravity(Double gravity) {
        this.gravity = gravity;
    }

    public Double getMeanRadius() {
        return meanRadius;
    }

    public void setMeanRadius(Double meanRadius) {
        this.meanRadius = meanRadius;
    }

    public Double getEquaRadius() {
        return equaRadius;
    }

    public void setEquaRadius(Double equaRadius) {
        this.equaRadius = equaRadius;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public Object getAroundPlanet() {
        return aroundPlanet;
    }

    public void setAroundPlanet(Object aroundPlanet) {
        this.aroundPlanet = aroundPlanet;
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