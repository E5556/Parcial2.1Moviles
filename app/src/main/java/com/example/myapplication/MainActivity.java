package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText peso, altura;
    private Button calcular,eliminar;
    private TextView imc,descripcion,pesoalturarecomendado,miBoton;
    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        peso= findViewById(R.id.txtpeso);
        altura= findViewById(R.id.txtaltura);

        calcular=findViewById(R.id.btncalcular);
        eliminar=findViewById(R.id.btneliminar);

        imc=findViewById(R.id.txtimc);
        descripcion=findViewById(R.id.txtdescripcion);
        pesoalturarecomendado=findViewById(R.id.txtideal);



        miBoton=findViewById(R.id.button);
        miBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), MainActivity2.class);


                // Obtén los valores de IMC, Descripción y Peso/Altura recomendado
                String imcData = imc.getText().toString();
                String descripcionData = descripcion.getText().toString();
                String pesoAlturaData = pesoalturarecomendado.getText().toString();

                // Agrega estos valores como extras al intent
                intent.putExtra("IMC", imcData);
                intent.putExtra("Descripcion", descripcionData);
                intent.putExtra("PesoAltura", pesoAlturaData);


                startActivity(intent);

            }
        });






    }

    public void operar(View view)
    {
        RadioButton radioButton1 = findViewById(R.id.radioButton);
        RadioButton radioButton2 = findViewById(R.id.radioButton2);




        double npeso=Double.parseDouble(peso.getText().toString());
        double naltura=Double.parseDouble(altura.getText().toString());

        double idealpesohom = ((naltura*100)-100)*0.90;
        double idealpesomuj = ((naltura*100)-100)*0.85;

        if (radioButton1.isChecked()){
            pesoalturarecomendado.setText("peso ideal Mujer: " +String.format("%.2f",idealpesomuj));

        }
        if (radioButton2.isChecked()){
            pesoalturarecomendado.setText("peso ideal Hombre: " +String.format("%.2f",idealpesohom));

        }



        double resultadoimc = npeso/(naltura*naltura);

        imc.setText("IMC: " +String.format("%.2f",resultadoimc));


        if (resultadoimc<18.5) {
            descripcion.setText("Bajo Peso");

        }
        else
        if (resultadoimc>=18.5 && resultadoimc<=24.9)
            descripcion.setText("Peso Normal");
        else
        if (resultadoimc>=25 && resultadoimc<=29.9)
            descripcion.setText("Sobrepeso");
        else
        if (resultadoimc>=30 && resultadoimc<=34.9)
            descripcion.setText("Obesidad I");
        else
        if (resultadoimc>=35 && resultadoimc<=39.9)
            descripcion.setText("Obesidad II");

        else
        if (resultadoimc>=40 && resultadoimc<=49.9)
            descripcion.setText("Obesidad III");
        else
        if (resultadoimc>50)
            descripcion.setText("Obesidad IV");

    }
    public void borrar(View v)
    {
        peso.setText("");
        altura.setText("");
        imc.setText("");
        descripcion.setText("");
        pesoalturarecomendado.setText("");
    }

}