package com.espe.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText nombre;
    private DatePicker fecha;
    private TextInputEditText telefono;
    private TextInputEditText email;
    private TextInputEditText descripcion;

    private String nom;
    private String fech;
    private String tel;
    private String ema;
    private String des;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = (TextInputEditText) findViewById(R.id.tieNombre);
        telefono = (TextInputEditText) findViewById(R.id.tieTelefono);
        fecha = (DatePicker) findViewById(R.id.datePicker);
        email = (TextInputEditText) findViewById(R.id.tieEmail);
        descripcion = (TextInputEditText) findViewById(R.id.tieDescripcion);

        Button btnSiguiente = (Button) findViewById(R.id.buttonSiguiente);
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                nom = nombre.getText().toString();
                tel = telefono.getText().toString();
                fech = getFecha();
                ema = email.getText().toString();
                des = descripcion.getText().toString();

                Intent intent = new Intent(MainActivity.this, DetalleRegister.class);
                intent.putExtra(getResources().getString(R.string.keyNombre), nom);
                intent.putExtra(getResources().getString(R.string.keyFecha), fech);
                intent.putExtra(getResources().getString(R.string.keyTelefono), tel);
                intent.putExtra(getResources().getString(R.string.keyEmail), ema);
                intent.putExtra(getResources().getString(R.string.keyDescripcion), des);
                startActivity(intent);
                finish();

            }
        });
    }
    public String getFecha() {

        int day   = fecha.getDayOfMonth();
        int month = fecha.getMonth()+1;  // here I added 1 to the month
        int year  = fecha.getYear();
        StringBuilder fechaElegida = new StringBuilder();
        fechaElegida.append("Fecha Nacimiento: " + day + "/" + month + "/" + year);
        return fechaElegida.toString();

    }
}