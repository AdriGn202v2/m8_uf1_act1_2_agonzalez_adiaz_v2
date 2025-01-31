package com.example.m8_uf1_act1_2_agonzalez_adiaz_v2;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddCitaActivity extends AppCompatActivity {
    private TextView dia, hora;
    private EditText notari, sala, descripcio;
    private ApiService apiService;
    private Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cita);

        notari = findViewById(R.id.editNotari);
        sala = findViewById(R.id.editSala);
        dia = findViewById(R.id.textDia);
        hora = findViewById(R.id.textHora);
        descripcio = findViewById(R.id.editDescripcio);

        calendar = Calendar.getInstance();

        apiService = RetrofitClient.getClient().create(ApiService.class);
    }

    public void selectDate(View view) {
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePicker = new DatePickerDialog(this, (view1, selectedYear, selectedMonth, selectedDay) -> {
            Calendar selectedDate = Calendar.getInstance();
            selectedDate.set(selectedYear, selectedMonth, selectedDay);

            if (selectedDate.before(Calendar.getInstance())) {
                Toast.makeText(this, "Selecciona una fecha futura", Toast.LENGTH_SHORT).show();
            } else {
                dia.setText(selectedDay + "-" + (selectedMonth + 1) + "-" + selectedYear);
            }
        }, year, month, day);
        datePicker.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
        datePicker.show();
    }

    public void selectTime(View view) {
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePicker = new TimePickerDialog(this, (view12, selectedHour, selectedMinute) -> {
            hora.setText(selectedHour + ":" + String.format("%02d", selectedMinute));
        }, hour, minute, true);
        timePicker.show();
    }

    public void addCita(View view) {
        Cita cita = new Cita(
                notari.getText().toString(),
                sala.getText().toString(),
                dia.getText().toString(),
                hora.getText().toString(),
                descripcio.getText().toString()
        );

        apiService.addCita(cita).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Toast.makeText(AddCitaActivity.this, "Cita afegida!", Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(AddCitaActivity.this, "Error en afegir la cita", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
