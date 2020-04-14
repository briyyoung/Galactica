package com.example.brianyoung.galactica.Entities;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PlanetInterface {
    //User will get the attributes based on planet's name (id)
    @GET("/rest/bodies/{id}")
//    Call<SolarSystem> getPlanetAttributes();
    Call<SolarSystem> getPlanetAttributes(@Path("id") String id);
}
