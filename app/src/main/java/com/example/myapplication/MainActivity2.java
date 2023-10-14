package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private TextView imcValue, descripcionValue, pesoAlturaValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Vincula las vistas de MainActivity2
        imcValue = findViewById(R.id.textViewIMCValue);
        descripcionValue = findViewById(R.id.textViewDescripcionValue);
        pesoAlturaValue = findViewById(R.id.textViewPesoAlturaValue);

        // Recupera los datos pasados desde MainActivity
        Intent intent = getIntent();
        if (intent != null) {
            String imcData = intent.getStringExtra("IMC");
            String descripcionData = intent.getStringExtra("Descripcion");
            String pesoAlturaData = intent.getStringExtra("PesoAltura");

            // Establece los datos en las vistas correspondientes
            imcValue.setText(imcData);
            descripcionValue.setText(descripcionData);
            pesoAlturaValue.setText(pesoAlturaData);
        }
    }
}
