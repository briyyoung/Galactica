package com.example.brianyoung.galactica;

import java.util.ArrayList;

public class Planet {

    private String name;
    private int picture;
    private String description;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    //constructor for planet
    public Planet(String name, int picture, String description){
        this.name = name;
        this.picture = picture;
        this.description = description;
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
        planets.add(new Planet("Mercury",1, "Mercury is the closest planet to the sun with 88 earth days of orbiting the sun. Having extreme changes in temperature during the day which could be as high up to 450c and very low at night as low as minus 180c. The diameter of Mercury is 4878km."));
        planets.add(new Planet("Venus",2, "Venus is the second planet from the sun with an orbit time of 225 earth days. The average temperature is relatively very high which is 465c and the diameter of Venus is 12,104km. The spin direction is opposite to other planets which are from east to west."));
        planets.add(new Planet("Earth",3, "Earth is the only habitable planet among the solar system. Yes, it is the planet where we live now. The diameter of the earth is 12,760km with an orbit time of 365.24 days which make up one calendar year of our time."));
        planets.add(new Planet("Mars",4, "The fourth planet from the sun with orbit time of 687 earth days, that has a diameter of 6,787km. Mars is covered with iron oxides dust which makes the planet have a red hue. The nickname of Mars is “Red Planet”."));
        planets.add(new Planet("Jupiter",5,"The fifth planet from the sun with orbit time of 11.9 earth days and the Largest planet in our solar system with a diameter of 139,822km. Jupiter has 75 moons orbiting the planet and has swirling clouds which called Great Red Spot."));
        planets.add(new Planet("Saturn",6, "The sixth planet from the sun that has visible ring that made from ice and rock with orbit time of 29.5 earth years. The diameter of the planet is 120,500km."));
        planets.add(new Planet("Uranus",7, "The seventh planet from the sun that has the orbit time of 84 years and diameter  51,120km. The colour of the planet seen from earth is blue-greenish due to the atmosphere built from methane."));
        planets.add(new Planet("Neptune",8, "The eighth planet from the sun that has an orbit time of 165 earth years with a diameter of 49,530 km that similar to Uranus. Neptune has very supersonic strong wind."));
        planets.add(new Planet("Pluto",9, "Pluto description"));
        return planets;
    }






}
