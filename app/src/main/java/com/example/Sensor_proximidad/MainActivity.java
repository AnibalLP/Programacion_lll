package com.example.Sensor_proximidad;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SensorManager sensorManager;//para hacer conexion con el hardware del telefono
    Sensor sensor;//para hacer referencia al sensor
    SensorEventListener sensorEventListener;//para que el sensor este atento a las actividades que lo requieren de el
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //enlace de la variable textview con la vista
        final TextView texto=(TextView)findViewById(R.id.tvSensor);
        //aplicando el servicio
        sensorManager=(SensorManager)getSystemService(SENSOR_SERVICE);
        //el tipo de sensor que se utilizara
        sensor=sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        //verificar si el dispositivo tiene el sensor
        //si no lo tiene hay que terminar la accion
        if (sensor==null)finish();

        sensorEventListener=new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent.values[0]<sensor.getMaximumRange()){
                    getWindow().getDecorView().setBackgroundColor(Color.RED);
                    texto.setText("cambiando a color rojo");
                }
                else{
                    getWindow().getDecorView().setBackgroundColor(Color.GREEN);
                    texto.setText("sensor de proximidad activo");
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        }; //agregamos punto y coma
        start();
    }//final de oncreate

    public void start(){
        sensorManager.registerListener(sensorEventListener,sensor,2000*1000);
    }
    public void stop(){
        sensorManager.unregisterListener(sensorEventListener);
    }
    //estos dos metodos se agregaron haciendo clic derecho en este punto
    //y buscando en la lista de metodos
    @Override
    protected void onPause() {
        stop();
        super.onPause();
    }

    @Override
    protected void onResume() {
        start();
        super.onResume();
    }
}
