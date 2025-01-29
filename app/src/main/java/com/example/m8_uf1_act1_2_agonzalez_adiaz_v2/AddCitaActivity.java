package com.example.m8_uf1_act1_2_agonzalez_adiaz_v2;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddCitaActivity extends AppCompatActivity {
    private EditText notari, sala, dia, hora, descripcio;
    private ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cita);

        notari = findViewById(R.id.editNotari);
        sala = findViewById(R.id.editSala);
        dia = findViewById(R.id.editDia);
        hora = findViewById(R.id.editHora);
        descripcio = findViewById(R.id.editDescripcio);

        apiService = RetrofitClient.getClient().create(ApiService.class);
    }

    public void addCita(View view) {
        Cita cita = new Cita(
                notari.getText().toString(),
                sala.getText().toString(),
                dia.getText().toString(),
                hora.getText().toString(),
                descripcio.getText().toString()
        );

        apiService.addCita(cita).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(AddCitaActivity.this, "Cita afegida!", Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(AddCitaActivity.this, "Error en afegir la cita", Toast.LENGTH_SHORT).show();
            }
        });
    }
}