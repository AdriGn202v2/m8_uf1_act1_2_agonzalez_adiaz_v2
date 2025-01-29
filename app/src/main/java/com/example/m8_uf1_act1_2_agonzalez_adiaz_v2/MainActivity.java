package com.example.m8_uf1_act1_2_agonzalez_adiaz_v2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openAddCitaActivity(View view) {
        Intent intent = new Intent(this, AddCitaActivity.class);
        startActivity(intent);
    }

    public void openListCitesActivity(View view) {
        Intent intent = new Intent(this, ListCitesActivity.class);
        startActivity(intent);
    }
}
