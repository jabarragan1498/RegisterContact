package com.espe.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetalleRegister extends AppCompatActivity {

    private TextView tvNombre;
    private TextView tvFecha;
    private TextView tvTelefono;
    private TextView tvEmail;
    private TextView tvDescripcion;

    private String nom;
    private String fech;
    private String tel;
    private String ema;
    private String des;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_register);

        Bundle parametros = getIntent().getExtras();
        final String nombre = parametros.getString(getResources().getString(R.string.keyNombre));
        String fecha = parametros.getString(getResources().getString(R.string.keyFecha));
        final String telefono = parametros.getString(getResources().getString(R.string.keyTelefono));
        final String email = parametros.getString(getResources().getString(R.string.keyEmail));
        final String descripcion = parametros.getString(getResources().getString(R.string.keyDescripcion));

        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvFecha = (TextView) findViewById(R.id.tvFecha);
        tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvDescripcion = (TextView) findViewById(R.id.tvDescripcion);

        tvNombre.setText(nombre);
        tvFecha.setText(fecha);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
        tvDescripcion.setText(descripcion);

        Button btnEditarDatos = (Button) findViewById(R.id.buttonEditar);
        btnEditarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nom = tvNombre.getText().toString();
                tel = tvTelefono.getText().toString();
                fech = tvFecha.getText().toString();
                ema = tvEmail.getText().toString();
                des = tvDescripcion.getText().toString();

                Intent intent = new Intent(DetalleRegister.this, MainActivity.class);
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

}