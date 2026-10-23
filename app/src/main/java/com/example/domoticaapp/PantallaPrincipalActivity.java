package com.example.domoticaapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class PantallaPrincipalActivity extends AppCompatActivity {

    ImageButton logoUjcv;
    Button botonHogar, botonPp, botonSp, botonTp, botonGaraje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_principal);

        logoUjcv = findViewById(R.id.imageButton);
        botonHogar = findViewById(R.id.boton_hogar);
        botonPp = findViewById(R.id.boton_pp);
        botonSp = findViewById(R.id.boton_sp);
        botonTp = findViewById(R.id.boton_tp);
        botonGaraje = findViewById(R.id.boton_garaje);

        // Requisito: Imagen de la UJCV que al dar click largo abra una ventana emergente con info
        logoUjcv.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                new AlertDialog.Builder(PantallaPrincipalActivity.this)
                        .setTitle("Información de la App")
                        .setMessage("Imagen logo_ujcv.png\n\nDomotica App Versión 1.0\nCreado por: Jared Lopez McCarthy - 2025110610\nClase Programación Dispositivos Móviles\nUJCV, 2026")
                        .setPositiveButton("Aceptar", null)
                        .show();
                return true;
            }
        });

        botonHogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PantallaPrincipalActivity.this, MainActivity.class));
            }
        });

        botonPp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PantallaPrincipalActivity.this, PrimerPisoActivity.class));
            }
        });

        botonSp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PantallaPrincipalActivity.this, SegundoPisoActivity.class));
            }
        });

        botonTp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PantallaPrincipalActivity.this, TercerPisoActivity.class));
            }
        });

        botonGaraje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PantallaPrincipalActivity.this, ExteriorGarajeActivity.class));
            }
        });
    }
}
