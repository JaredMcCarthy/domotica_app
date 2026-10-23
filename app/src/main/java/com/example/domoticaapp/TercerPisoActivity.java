package com.example.domoticaapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class TercerPisoActivity extends AppCompatActivity {

    ImageButton focoTp, enchufeTp;
    Button btnVolver;
    DomoticaState state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercer_piso);

        state = DomoticaState.getInstance();

        focoTp = findViewById(R.id.imageButton4);
        enchufeTp = findViewById(R.id.imageButton6);
        btnVolver = findViewById(R.id.btn_volver_menu);

        focoTp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                state.focoTp = !state.focoTp;
                actualizarUI();
            }
        });

        enchufeTp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                state.enchufeTp = !state.enchufeTp;
                actualizarUI();
            }
        });

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TercerPisoActivity.this, PantallaPrincipalActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        actualizarUI();
    }

    private void actualizarUI() {
        if (state.focoTp) {
            focoTp.setImageResource(R.drawable.foco_encendido);
        } else {
            focoTp.setImageResource(R.drawable.foco_apagado);
        }

        if (state.enchufeTp) {
            enchufeTp.setImageResource(R.drawable.on);
        } else {
            enchufeTp.setImageResource(R.drawable.off);
        }
    }
}
