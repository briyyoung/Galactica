package com.example.brianyoung.galactica.Entities;

import java.util.List;
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
//    @SerializedName("isPlanet")
//    @Expose
//    private Boolean isPlanet;
//    @SerializedName("moons")
//    @Expose
//    private List<Moon> moons = null;
//    @SerializedName("semimajorAxis")
//    @Expose
//    private Long semimajorAxis;
//    @SerializedName("perihelion")
//    @Expose
//    private Integer perihelion;
//    @SerializedName("aphelion")
//    @Expose
//    private Integer aphelion;
    @SerializedName("eccentricity")
    @Expose
    private Double eccentricity;
//    @SerializedName("inclination")
//    @Expose
//    private Integer inclination;
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
//    @SerializedName("escape")
//    @Expose
//    private Double escape;
    @SerializedName("meanRadius")
    @Expose
    private Double meanRadius;
    @SerializedName("equaRadius")
    @Expose
    private Double equaRadius;
//    @SerializedName("polarRadius")
//    @Expose
//    private Double polarRadius;
//    @SerializedName("flattening")
//    @Expose
//    private Double flattening;
    @SerializedName("dimension")
    @Expose
    private String dimension;
//    @SerializedName("sideralOrbit")
//    @Expose
//    private Double sideralOrbit;
//    @SerializedName("sideralRotation")
//    @Expose
//    private Double sideralRotation;
    @SerializedName("aroundPlanet")
    @Expose
    private Object aroundPlanet;
//    @SerializedName("discoveredBy")
//    @Expose
    private String discoveredBy;
    @SerializedName("discoveryDate")
    @Expose
    private String discoveryDate;
//    @SerializedName("alternativeName")
//    @Expose
//    private String alternativeName;

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
        //this.isPlanet = isPlanet;
        //this.moons = moons;
//        this.semimajorAxis = semimajorAxis;
//        this.perihelion = perihelion;
//        this.aphelion = aphelion;
        this.eccentricity = eccentricity;
        //this.inclination = inclination;
        this.mass = mass;
        this.vol = vol;
        this.density = density;
        this.gravity = gravity;
       // this.escape = escape;
        this.meanRadius = meanRadius;
        this.equaRadius = equaRadius;
//        this.polarRadius = polarRadius;
//        this.flattening = flattening;
        this.dimension = dimension;
//        this.sideralOrbit = sideralOrbit;
//        this.sideralRotation = sideralRotation;
        this.aroundPlanet = aroundPlanet;
        this.discoveredBy = discoveredBy;
        this.discoveryDate = discoveryDate;
       // this.alternativeName = alternativeName;
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

//    public Boolean getIsPlanet() {
//        return isPlanet;
//    }

   // public void setIsPlanet(Boolean isPlanet) {
//        this.isPlanet = isPlanet;
//    }

    //public List<Moon> getMoons() {
//        return moons;
//    }

    //public void setMoons(List<Moon> moons) {
//        this.moons = moons;
//    }

//    public Long getSemimajorAxis() {
//        return semimajorAxis;
//    }
//
//    public void setSemimajorAxis(Long semimajorAxis) {
//        this.semimajorAxis = semimajorAxis;
//    }
//
//    public Integer getPerihelion() {
//        return perihelion;
//    }
//
//    public void setPerihelion(Integer perihelion) {
//        this.perihelion = perihelion;
//    }
//
//    public Integer getAphelion() {
//        return aphelion;
//    }
//
//    public void setAphelion(Integer aphelion) {
//        this.aphelion = aphelion;
//    }

    public Double getEccentricity() {
        return eccentricity;
    }

    public void setEccentricity(Double eccentricity) {
        this.eccentricity = eccentricity;
    }

//    public Integer getInclination() {
//        return inclination;
//    }
//
//    public void setInclination(Integer inclination) {
//        this.inclination = inclination;
//    }

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

//    public Double getEscape() {
//        return escape;
//    }
//
//    public void setEscape(Double escape) {
//        this.escape = escape;
//    }

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

//    public Double getPolarRadius() {
//        return polarRadius;
//    }
//
//    public void setPolarRadius(Double polarRadius) {
//        this.polarRadius = polarRadius;
//    }
//
//    public Double getFlattening() {
//        return flattening;
//    }
//
//    public void setFlattening(Double flattening) {
//        this.flattening = flattening;
//    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

//    public Double getSideralOrbit() {
//        return sideralOrbit;
//    }
//
//    public void setSideralOrbit(Double sideralOrbit) {
//        this.sideralOrbit = sideralOrbit;
//    }
//
//    public Double getSideralRotation() {
//        return sideralRotation;
//    }

//    public void setSideralRotation(Double sideralRotation) {
//        this.sideralRotation = sideralRotation;
//    }

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

 //   public String getAlternativeName() {
//        return alternativeName;
//    }

//    public void setAlternativeName(String alternativeName) {
//        this.alternativeName = alternativeName;
//    }

}