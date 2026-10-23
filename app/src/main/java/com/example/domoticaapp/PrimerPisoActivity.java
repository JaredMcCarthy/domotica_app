package com.example.domoticaapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class PrimerPisoActivity extends AppCompatActivity {

    ImageButton focoSalaComedor, enchufePp;
    Button btnVolver;
    DomoticaState state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primer_piso);

        state = DomoticaState.getInstance();

        focoSalaComedor = findViewById(R.id.foco_sala_comedor);
        enchufePp = findViewById(R.id.imageButton3);
        btnVolver = findViewById(R.id.btn_volver_menu);

        focoSalaComedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                state.focoPp = !state.focoPp;
                actualizarUI();
            }
        });

        enchufePp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                state.enchufePp = !state.enchufePp;
                actualizarUI();
            }
        });

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PrimerPisoActivity.this, PantallaPrincipalActivity.class);
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
        if (state.focoPp) {
            focoSalaComedor.setImageResource(R.drawable.foco_encendido);
        } else {
            focoSalaComedor.setImageResource(R.drawable.foco_apagado);
        }

        if (state.enchufePp) {
            enchufePp.setImageResource(R.drawable.on);
        } else {
            enchufePp.setImageResource(R.drawable.off);
        }
    }
}
