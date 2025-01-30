package com.example.m8_uf1_act1_2_agonzalez_adiaz_v2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DeleteCitaActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CitaAdapter adapter;
    private ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_cita);

        recyclerView = findViewById(R.id.recyclerCitas);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        apiService = RetrofitClient.getClient().create(ApiService.class);

        cargarCitas();
    }

    private void cargarCitas() {
        apiService.getCitas().enqueue(new Callback<List<Cita>>() {
            @Override
            public void onResponse(Call<List<Cita>> call, Response<List<Cita>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    adapter = new CitaAdapter(response.body(), apiService);
                    recyclerView.setAdapter(adapter);
                } else {
                    Toast.makeText(DeleteCitaActivity.this, "Error al cargar las citas", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Cita>> call, Throwable t) {
                Toast.makeText(DeleteCitaActivity.this, "Error de conexión", Toast.LENGTH_SHORT).show();
                Log.e("API_ERROR", "Error en la petición", t);
            }
        });
    }
}
