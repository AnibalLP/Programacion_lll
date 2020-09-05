package com.example.Reproductor_Musical;

import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

// AQUI SE PIDE IMPLEMENTAR ... PEDIR METODO
public class Reproductor_Musical extends AppCompatActivity  {
    //variables a utilizar con la vista del activity
    Button play_pause,btn_repetir;
    MediaPlayer mp;
    ImageView iv;
    //para determinar cual cancion sigue
    int repetir=2,posicion=0;
    //esta es una matriz para almacenar las canciones
    MediaPlayer vectormp[] = new MediaPlayer[3];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    //Todos los enlaces
        play_pause =(Button)findViewById(R.id.btn_play);
        btn_repetir=(Button)findViewById(R.id.btn_repetir);
        iv=(ImageView)findViewById(R.id.imageView);
        //lista de canciones , aunque se pueden agregar mas
        vectormp[0]=MediaPlayer.create(this,R.raw.epilogo);
        vectormp[1]=MediaPlayer.create(this,R.raw.locos);
        vectormp[2]=MediaPlayer.create(this,R.raw.cielo);
    }
    public void play(View view){
        if (vectormp[posicion].isPlaying()){
            vectormp[posicion].pause();
            play_pause.setBackgroundResource(R.drawable.play);
            Toast.makeText(this,"Pause",Toast.LENGTH_SHORT).show();
        }else {
            vectormp[posicion].start();
            play_pause.setBackgroundResource(R.drawable.pause);
            Toast.makeText(this,"play",Toast.LENGTH_SHORT).show();
        }
    }
    //metodo para el boton de stop
    public void stop(View view){
        if (vectormp[posicion] != null){
            vectormp[posicion].stop();

            vectormp[0]=MediaPlayer.create(this,R.raw.epilogo);
            vectormp[1]=MediaPlayer.create(this,R.raw.locos);
            vectormp[2]=MediaPlayer.create(this,R.raw.cielo);
            posicion=0;
            play_pause.setBackgroundResource(R.drawable.play);
            iv.setImageResource(R.drawable.i1);
            Toast.makeText(this,"stop",Toast.LENGTH_SHORT).show();
        }
    }
    //metodo de repetir pista
    public void repetir(View view){
        if (repetir==1){
            btn_repetir.setBackgroundResource(R.drawable.repeat);
            Toast.makeText(this,"Not repeat",Toast.LENGTH_SHORT).show();
            vectormp[posicion].setLooping((false));
            repetir=2;
        }else {
            btn_repetir.setBackgroundResource(R.drawable.repeat);
            Toast.makeText(this,"repetir",Toast.LENGTH_SHORT).show();
            vectormp[posicion].setLooping((true));
            repetir=1;
        }
    }
    public void siguiente(View view){
        if (posicion<vectormp.length-1){
            if (vectormp[posicion].isPlaying()){
                vectormp[posicion].stop();
                posicion++;
                vectormp[posicion].start();
                if (posicion==0){
                    iv.setImageResource(R.drawable.i1);
                }else if(posicion==1){
                    iv.setImageResource(R.drawable.i2);
                }else if (posicion==2){
                    iv.setImageResource(R.drawable.i3);
                }
                else {
                    posicion++;
                    if (posicion==0){
                        iv.setImageResource(R.drawable.i1);
                    }else if (posicion==1){
                        iv.setImageResource(R.drawable.i2);
                    }else if (posicion==2){
                        iv.setImageResource(R.drawable.i3);
                    }
                }
            }else {
                Toast.makeText(this,"no hay mas canciones",Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void anterior(View view){
        if (posicion>=1){
            if (vectormp[posicion].isPlaying()){
                vectormp[posicion].stop();
                vectormp[0]=MediaPlayer.create(this,R.raw.epilogo);
                vectormp[1]=MediaPlayer.create(this,R.raw.locos);
                vectormp[2]=MediaPlayer.create(this,R.raw.cielo);
                posicion--;

                if (posicion==0){
                    iv.setImageResource(R.drawable.i1);
                }else if (posicion==1){
                    iv.setImageResource(R.drawable.i2);
                }else if (posicion==2){
                    iv.setImageResource(R.drawable.i3);
                }
                vectormp[posicion].start();
            }else {
                posicion--;
                if (posicion==0){
                    iv.setImageResource(R.drawable.i1);
                }else if (posicion==1){
                    iv.setImageResource(R.drawable.i1);
                }else if (posicion==2){
                    iv.setImageResource(R.drawable.i1);
                }
            }
        }else {
            Toast.makeText(this,"no hay mas canciones",Toast.LENGTH_SHORT).show();
        }
    }
}