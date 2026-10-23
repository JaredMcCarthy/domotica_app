package com.example.domoticaapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class SegundoPisoActivity extends AppCompatActivity {

    ImageButton focoSp, enchufeSp;
    Button btnVolver;
    DomoticaState state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo_piso);

        state = DomoticaState.getInstance();

        focoSp = findViewById(R.id.imageButton2);
        enchufeSp = findViewById(R.id.imageButton5);
        btnVolver = findViewById(R.id.btn_volver_menu);

        focoSp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                state.focoSp = !state.focoSp;
                actualizarUI();
            }
        });

        enchufeSp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                state.enchufeSp = !state.enchufeSp;
                actualizarUI();
            }
        });

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SegundoPisoActivity.this, PantallaPrincipalActivity.class);
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
        if (state.focoSp) {
            focoSp.setImageResource(R.drawable.foco_encendido);
        } else {
            focoSp.setImageResource(R.drawable.foco_apagado);
        }

        if (state.enchufeSp) {
            enchufeSp.setImageResource(R.drawable.on);
        } else {
            enchufeSp.setImageResource(R.drawable.off);
        }
    }
}
