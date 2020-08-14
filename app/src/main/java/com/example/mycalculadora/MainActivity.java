package com.example.mycalculadora;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calcular(View view) {
        final EditText etn1 = (EditText) findViewById(R.id.etnum1);
        final EditText etn2 = (EditText) findViewById(R.id.etnum2);
        final RadioButton suma = (RadioButton) findViewById(R.id.rbsuma);
        final RadioButton resta = (RadioButton) findViewById(R.id.rbresta);
        final RadioButton multi = (RadioButton) findViewById(R.id.rbmulti);
        final RadioButton div = (RadioButton) findViewById(R.id.rbdivision);
        final RadioButton porciento = (RadioButton) findViewById(R.id.rbporcentaje);
        final RadioButton modulo = (RadioButton) findViewById(R.id.rbreciduo);
        final RadioButton exponente = (RadioButton) findViewById(R.id.rbexponenciaion);

        if (suma.isChecked()) {
            if (!etn1.getText().toString().isEmpty() && !etn2.getText().toString().isEmpty()) {
                suma(etn1.getText().toString(), etn2.getText().toString());

            } else {

                Toast.makeText(getApplicationContext(), "No deje los campos vacios", Toast.LENGTH_SHORT).show();
            }

        } else if (resta.isChecked()) {
            if (!etn1.getText().toString().isEmpty() && !etn2.getText().toString().isEmpty()) {
                resta(etn1.getText().toString(), etn2.getText().toString());
            } else {
                Toast.makeText(getApplicationContext(), "No deje los campos vacios", Toast.LENGTH_SHORT).show();
            }

        } else if (multi.isChecked()) {
            if (!etn1.getText().toString().isEmpty() && !etn2.getText().toString().isEmpty()) {
                multiplicacion(etn1.getText().toString(), etn2.getText().toString());
            } else {
                Toast.makeText(getApplicationContext(), "No deje los campos vacios", Toast.LENGTH_SHORT).show();
            }
        } else if (div.isChecked()) {
            if (!etn1.getText().toString().isEmpty() && !etn2.getText().toString().isEmpty()) {
                divicion(etn1.getText().toString(), etn2.getText().toString());
            } else {
                Toast.makeText(getApplicationContext(), "No deje los campos vacios", Toast.LENGTH_SHORT).show();
            }
        } else if (porciento.isChecked()) {
            if (!etn1.getText().toString().isEmpty() && !etn2.getText().toString().isEmpty()) {
                porcentaje(etn1.getText().toString(), etn2.getText().toString());
            } else {
                Toast.makeText(getApplicationContext(), "No deje los campos vacios", Toast.LENGTH_SHORT).show();
            }
        } else if (modulo.isChecked()) {
            if (!etn1.getText().toString().isEmpty() && !etn2.getText().toString().isEmpty()) {
                Modulo(etn1.getText().toString(), etn2.getText().toString());
            } else {
                Toast.makeText(getApplicationContext(), "No deje los campos vacios", Toast.LENGTH_SHORT).show();
            }
        } else if (exponente.isChecked()) {
            if (!etn1.getText().toString().isEmpty() && !etn2.getText().toString().isEmpty()) {
                exponenciacion(etn1.getText().toString(), etn2.getText().toString());
            } else {
                Toast.makeText(getApplicationContext(), "No deje los campos vacios", Toast.LENGTH_SHORT).show();
            }
        } else {

            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("Debes seleciconar una Operacion")
                    .setCancelable(false)
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
            AlertDialog dialog = builder.create();
            dialog.setIcon(R.drawable.ic_baseline_error_24);
            dialog.setTitle("UPS");
            dialog.show();

        }

    }


    private void suma(String etn1, String etn2) {
        int num1 = Integer.parseInt(etn1);
        int num2 = Integer.parseInt(etn2);
        Integer result;

        result = num1 + num2;
        Toast.makeText(getApplicationContext(), "Resultado de la Operación: " + result.toString(), Toast.LENGTH_SHORT).show();
    }


    private void resta(String n1, String n2) {
        int num1 = Integer.parseInt(n1);
        int num2 = Integer.parseInt(n2);

        Integer result = num1 - num2;
        Toast.makeText(getApplicationContext(), "Resultado de la Operación: " + result.toString(), Toast.LENGTH_SHORT).show();
    }

    private void multiplicacion(String n1, String n2) {
        int num1 = Integer.parseInt(n1);
        int num2 = Integer.parseInt(n2);

        Integer result = num1 * num2;
        Toast.makeText(getApplicationContext(), "Resultado de la Operación: " + result.toString(), Toast.LENGTH_SHORT).show();
    }

    private void divicion(String n1, String n2) {
        int num1 = Integer.parseInt(n1);
        int num2 = Integer.parseInt(n2);

        Integer result = num1 / num2;
        Toast.makeText(getApplicationContext(), "Resultado de la Operación: " + result.toString(), Toast.LENGTH_SHORT).show();

    }

    private void porcentaje(String n1, String n2) {
        Double num1 = Double.parseDouble(n1);
        Double num2 = Double.parseDouble(n2);

        Double result = (num1 / num2) * 100;
        Double data = Double.valueOf(Math.round(result));
        Toast.makeText(getApplicationContext(), "El Porcentaje es: " + data.toString(), Toast.LENGTH_SHORT).show();
    }

    private void Modulo(String n1, String n2) {
        Double num1 = Double.parseDouble(n1);
        Double num2 = Double.parseDouble(n2);

        Double result = num1 % num2;
        Toast.makeText(getApplicationContext(), "El Modulo es: " + result.toString(), Toast.LENGTH_SHORT).show();
    }

    private void exponenciacion(String n1, String n2) {
        int num1 = Integer.parseInt(n1);
        int num2 = Integer.parseInt(n2);

        Double result = Math.pow(num1, num2);
        String data = result.toString();
        Toast.makeText(getApplicationContext(), "La Exponenciacion es:" + data, Toast.LENGTH_SHORT).show();
    }

}