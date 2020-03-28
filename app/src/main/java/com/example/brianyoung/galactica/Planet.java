package com.example.brianyoung.galactica;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Planet {

    private String name;
    private int picture;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    //constructor for planet
    public Planet(String name, int picture){
        this.name = name;
        this.picture = picture;
    }

    //create method that would go get you one planet.
    public static Planet getPlanet(String name){
        for (Planet planet : getPlanets()){
            if(planet.getName().equals(name)){
                return planet;
            }
        }
        return null;
    }

    public static ArrayList<Planet> getPlanets(){
        ArrayList<Planet> planets = new ArrayList<>();
        planets.add(new Planet("Mercury",1));
        planets.add(new Planet("Venus",2));
        planets.add(new Planet("Earth",3));
        planets.add(new Planet("Mars",4));
        planets.add(new Planet("Jupiter",5));
        planets.add(new Planet("Saturn",6));
        planets.add(new Planet("Uranus",7));
        planets.add(new Planet("Neptune",8));
        planets.add(new Planet("Pluto",9));
        return planets;
    }






}
