package com.example.Uso_Camara;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.provider.MediaStore;
import android.graphics.Bitmap;
import android.content.Intent;

import com.example.Uso_Camara.Uso_Camara;


public class Uso_Camara extends AppCompatActivity {
        //objetos se enlazan con las vistas
    ImageView imageView;
    Button btfoto;
    //administrar la toma de la foto cuando se ejecuta el intent
    static final int REQUEST_IMAGE_CAPTURE=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //enlaces con las vistas
        btfoto =(Button)findViewById(R.id.btTomarFoto);
        imageView=(ImageView)findViewById(R.id.ivMostrarFoto);
        //evento click del boton
        btfoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                llamarIntent();
            }
        });

    }
    private void llamarIntent(){
        Intent takePictureIntent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager())!=null){
            startActivityForResult(takePictureIntent,REQUEST_IMAGE_CAPTURE);
        }
    }
    //Si la foto fue capturada se va para el imagenview

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==REQUEST_IMAGE_CAPTURE && resultCode==RESULT_OK){
            Bundle extras=data.getExtras();
            Bitmap imageBitmap=(Bitmap)extras.get("data");
            imageView.setImageBitmap(imageBitmap);
        }
    }

}