package com.example.m8_uf1_act1_2_agonzalez_adiaz_v2;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.DELETE;
import retrofit2.http.Path;

public interface ApiService {
    /*@POST("addCita.php")
    Call<Void> addCita(@Body Cita cita);*/

    @Headers("Content-Type: application/json")
    @POST("addCita.php")  // Asegúrate de que el endpoint es correcto
    Call<ResponseBody> addCita(@Body Cita cita);

    @GET("getCitas.php")
    Call<List<Cita>> getCitas();

    @DELETE("deleteCita.php/{id}")
    Call<Void> deleteCita(@Path("id") int id);
}
