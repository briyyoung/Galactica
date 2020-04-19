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
        planets.add(new Planet("Mercury",1,
                "Mercury is the closest planet to the Sun with 88 Earth days of orbiting the sun. It has extreme changes in temperature during the day which could be as high as 450 degree celsius and as low as minus 180 degree celsius at night. The diameter of Mercury is 4878km."));
        planets.add(new Planet("Venus",2,
                "Venus is the second closest planet to the sun with an orbit time of 225 Earth days. The average temperature is relatively high ranging to 465 degree celsius. It has a diameter of 12,104km. The spin direction goes in the opposite direction to other planets which usually go from east to west."));
        planets.add(new Planet("Earth",3,
                "The planet we live in, Earth, is the only habitable planet among the solar system. Earth has a diameter of 12,760km with an orbit time of 365.24 days which make up one calendar year of our time."));
        planets.add(new Planet("Mars",4,
                "Mars is the fourth planet from the sun with an orbit time of 687 Earth days, that has a diameter of 6,787km. Mars is covered with iron oxide dust which make the planet gleam with a red hue. Often referred to as the “Red Planet”."));
        planets.add(new Planet("Jupiter",5,
                "The fifth planet from the sun with orbit time of 11.9 Earth days and the Largest planet in our solar system with a diameter of 139,822km. Jupiter has 75 moons orbiting the planet and has swirling clouds called the Great Red Spot."));
        planets.add(new Planet("Saturn",6,
                "The sixth planet from the sun with a visible ring made of ice and rock with an orbit time of 29.5 Earth years. The diameter of the planet is 120,500km."));
        planets.add(new Planet("Uranus",7,
                "The seventh planet from the sun that has the orbit time of 84 years and a diameter of 51,120km. The colour of the planet observed from Earth is blue-greenish due to the atmosphere built from methane."));
        planets.add(new Planet("Neptune",8,
                "The eighth planet from the sun that has an orbit time of 165 Earth years with a diameter of 49,530 km, similar to that of Uranus. Neptune is known for having supersonic strong winds - the strongest winds in the solar system."));
        planets.add(new Planet("Pluto",9,
                "Smaller than Earth's moon, Pluto is known as the \"Dwarf planet\". This planet contains extremely high mountains, and even has red snow."));
        return planets;
    }






}
