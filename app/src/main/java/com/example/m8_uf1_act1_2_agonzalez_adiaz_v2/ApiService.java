package com.example.m8_uf1_act1_2_agonzalez_adiaz_v2;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.DELETE;
import retrofit2.http.Path;

//hola
public interface ApiService {
    @POST("addCita.php")
    Call<Void> addCita(@Body Cita cita);

    @GET("getCites.php")
    Call<List<Cita>> getCites();

    @DELETE("deleteCita.php/{id}")
    Call<Void> deleteCita(@Path("id") int id);
}