package com.example.dosactivitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText eNombres =(EditText)findViewById(R.id.etNombre);
        final EditText eEdad=(EditText)findViewById(R.id.etEdad);
        Button bEnviar=(Button)findViewById(R.id.btEnviarDatos);
        bEnviar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String nombre = eNombres.getText().toString();
                String edad   = eEdad.getText().toString();
                Bundle pasarDatos=new Bundle();
                pasarDatos.putString("pNombre",nombre);
                pasarDatos.putString("pEdad",edad);
                Intent siga = new Intent(MainActivity.this,Determinar.class);
                siga.putExtras(pasarDatos);
                startActivity(siga);
            }

        });
    }
}