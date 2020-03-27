package com.example.brianyoung.galactica;

import java.util.ArrayList;

public class Planet {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Planet(String name){
        this.name = name;
    }

    public static ArrayList<Planet> getPlanets(){
        ArrayList<Planet> planets = new ArrayList<>();
        planets.add(new Planet("Earth"));
        planets.add(new Planet("Jupiter"));
        planets.add(new Planet("Saturn"));
        planets.add(new Planet("Mars"));
        planets.add(new Planet("Neptune"));
        planets.add(new Planet("Uranus"));
        planets.add(new Planet("Venus"));
        planets.add(new Planet("Mercury"));
        return planets;
    }




}
