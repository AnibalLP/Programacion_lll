package com.example.dosactivitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.content.Intent;
import android.widget.TextView;

public class Determinar extends AppCompatActivity {
Integer estado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_determinar);

        TextView Nombre=(TextView)findViewById(R.id.tvNombreReci);
        TextView Edad=(TextView)findViewById(R.id.tvEdadReci);
        TextView Estado=(TextView)findViewById(R.id.tvEstado);
        Button bVolver=(Button)findViewById(R.id.btVolver);

        Bundle datosRecibidos  = this.getIntent().getExtras();
        String nombre=datosRecibidos.getString("pNombre");
        String edad=datosRecibidos.getString("pEdad");

        Nombre.setText("tu nombre es: " + nombre);
        Edad.setText("tu edad es: " + edad);

        estado=Integer.parseInt(edad);

        if (estado < 18){
            Estado.setText("eres menor de edad");
        }else{
            Estado.setText("eres mayor de edad");
        }
        bVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Vuelva = new
                        Intent(Determinar.this, MainActivity.class);
                startActivity(Vuelva);
            }
        });
    }
}