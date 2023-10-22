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

    private static double IVA = 0.19;
    private EditText peso, altura;
    private Button calcular,eliminar;
    private TextView imc,descripcion,pesoalturarecomendado,miBoton;
    private Intent intent;


    public static double getIVA() {
        return IVA;
    }

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

    public static double getProduct(double veces, double multiplicador) {
        double H = 1;
        if (multiplicador == H)
            return veces;
        else
            return getProduct(veces, multiplicador -1) + veces;
    }




    public void operar(View view)
    {
        double npeso=ParseStringtoDouble(peso.getText().toString());
        double naltura=ParseStringtoDouble(altura.getText().toString());
        double idealpesohom = getProduct(npeso,naltura);
        pesoalturarecomendado.setText("Total Bruto: " +String.format("%.2f",idealpesohom));
        double resultadoimc =  getProduct( IVA, idealpesohom);
        imc.setText("Impuesto del IVA: " +String.format("%.2f",resultadoimc));
        double resultadosuma = resultadoimc+idealpesohom;
        descripcion.setText("Total Bruto + IVA: "+String.format("%.2f",resultadosuma));
    }

    public double ParseStringtoDouble(String str){
        return Double.parseDouble(str);
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