package com.example.m8_uf1_act1_2_agonzalez_adiaz_v2;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListCitesActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CitaAdapter citaAdapter;
    private ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_cites);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        apiService = RetrofitClient.getClient().create(ApiService.class);
        getCites();
    }

    private void getCites() {
        apiService.getCites().enqueue(new Callback<List<Cita>>() {
            @Override
            public void onResponse(Call<List<Cita>> call, Response<List<Cita>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    citaAdapter = new CitaAdapter(response.body());
                    recyclerView.setAdapter(citaAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<Cita>> call, Throwable t) {
                Log.e("ListCitesActivity", "Error en obtenir cites", t);
            }
        });
    }
}