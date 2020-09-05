package com.example.Reproductor_Musical;

import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

// AQUI SE PIDE IMPLEMENTAR ... PEDIR METODO
public class Reproductor_Musical extends AppCompatActivity implements View.OnClickListener {
    Button iniciar,parar;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //aqui se enlazan las variables con la vista del activity
        iniciar=(Button)findViewById(R.id.btIniciar);
        parar=(Button)findViewById(R.id.btDetener);
        mediaPlayer=MediaPlayer.create(this,R.raw.cielo);

        //los botones deben escuchar
        iniciar.setOnClickListener(this);
        parar.setOnClickListener(this);

    }
    //este metodo permite atravez de un selector de casos seleccionar cada accion de los botones
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btIniciar:
                play();
                break;
            case R.id.btDetener:
                stop();
                break;
        }
    }
    private void play(){
            mediaPlayer.start();
    }
    private void stop(){
            mediaPlayer.stop();
    }
}