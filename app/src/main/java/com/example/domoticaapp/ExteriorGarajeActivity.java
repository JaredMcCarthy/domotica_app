package com.example.domoticaapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ExteriorGarajeActivity extends AppCompatActivity {

    ImageButton focoGaraje, enchufeGaraje;
    Button btnVolver;
    DomoticaState state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exterior_garaje);

        state = DomoticaState.getInstance();

        focoGaraje = findViewById(R.id.imageButton7);
        enchufeGaraje = findViewById(R.id.imageButton8);
        btnVolver = findViewById(R.id.btn_volver_menu);

        focoGaraje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                state.focoGaraje = !state.focoGaraje;
                actualizarUI();
            }
        });

        enchufeGaraje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                state.enchufeGaraje = !state.enchufeGaraje;
                actualizarUI();
            }
        });

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExteriorGarajeActivity.this, PantallaPrincipalActivity.class);
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
        if (state.focoGaraje) {
            focoGaraje.setImageResource(R.drawable.foco_encendido);
        } else {
            focoGaraje.setImageResource(R.drawable.foco_apagado);
        }

        if (state.enchufeGaraje) {
            enchufeGaraje.setImageResource(R.drawable.on);
        } else {
            enchufeGaraje.setImageResource(R.drawable.off);
        }
    }
}
