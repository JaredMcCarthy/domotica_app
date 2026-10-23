package com.example.domoticaapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Master buttons
    ImageButton botonFocosMaster;
    ImageButton botonEnchufesMaster;

    // Focos (Lights)
    ImageButton focoPp, focoSp, focoTp, focoGaraje;
    
    // Enchufes (Plugs)
    ImageButton enchufePp, enchufeSp, enchufeTp, enchufeGaraje;

    Button btnVolver;
    
    DomoticaState state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        state = DomoticaState.getInstance();

        initViews();
        initListeners();
    }

    @Override
    protected void onResume() {
        super.onResume();
        actualizarTodasLasUIs();
    }

    private void initViews() {
        botonFocosMaster = findViewById(R.id.boton_focos);
        botonEnchufesMaster = findViewById(R.id.boton_enchufes);

        focoPp = findViewById(R.id.boton_foco_pp);
        focoSp = findViewById(R.id.boton_foco_sp);
        focoTp = findViewById(R.id.boton_foco_tp);
        focoGaraje = findViewById(R.id.boton_foco_garaje);

        enchufePp = findViewById(R.id.boton_enchufe_pp);
        enchufeSp = findViewById(R.id.boton_enchufe_sp);
        enchufeTp = findViewById(R.id.boton_enchufe_tp);
        enchufeGaraje = findViewById(R.id.boton_enchufe_garaje);

        btnVolver = findViewById(R.id.btn_volver_menu);
    }

    private void initListeners() {
        botonFocosMaster.setOnClickListener(this);
        botonEnchufesMaster.setOnClickListener(this);

        focoPp.setOnClickListener(this);
        focoSp.setOnClickListener(this);
        focoTp.setOnClickListener(this);
        focoGaraje.setOnClickListener(this);

        enchufePp.setOnClickListener(this);
        enchufeSp.setOnClickListener(this);
        enchufeTp.setOnClickListener(this);
        enchufeGaraje.setOnClickListener(this);

        // Requisito: Click largo para regular intensidad y cambiar colores (rojo, blanco, azul)
        focoPp.setOnLongClickListener(v -> { mostrarDialogoIntensidadColor("Foco Primer Piso"); return true; });
        focoSp.setOnLongClickListener(v -> { mostrarDialogoIntensidadColor("Foco Segundo Piso"); return true; });
        focoTp.setOnLongClickListener(v -> { mostrarDialogoIntensidadColor("Foco Tercer Piso"); return true; });
        focoGaraje.setOnLongClickListener(v -> { mostrarDialogoIntensidadColor("Foco Garaje"); return true; });

        if (btnVolver != null) {
            btnVolver.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, PantallaPrincipalActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(intent);
                }
            });
        }
    }

    private void mostrarDialogoIntensidadColor(String nombreFoco) {
        String[] opciones = {"Intensidad: 25%", "Intensidad: 50%", "Intensidad: 75%", "Intensidad: 100%", "Color: Rojo", "Color: Blanco", "Color: Azul"};
        new AlertDialog.Builder(this)
                .setTitle("Ajustar " + nombreFoco)
                .setItems(opciones, (dialog, which) -> {
                    Toast.makeText(this, "Ajustado: " + opciones[which], Toast.LENGTH_SHORT).show();
                })
                .setPositiveButton("Cerrar", null)
                .show();
    }

    private void actualizarTodasLasUIs() {
        actualizarFoco(focoPp, state.focoPp);
        actualizarFoco(focoSp, state.focoSp);
        actualizarFoco(focoTp, state.focoTp);
        actualizarFoco(focoGaraje, state.focoGaraje);

        actualizarEnchufe(enchufePp, state.enchufePp);
        actualizarEnchufe(enchufeSp, state.enchufeSp);
        actualizarEnchufe(enchufeTp, state.enchufeTp);
        actualizarEnchufe(enchufeGaraje, state.enchufeGaraje);
    }

    @Override
    public void onClick(View v) {
        if (v == botonFocosMaster) {
            boolean nuevoEstado = !(state.focoPp && state.focoSp && state.focoTp && state.focoGaraje);
            state.focoPp = nuevoEstado;
            state.focoSp = nuevoEstado;
            state.focoTp = nuevoEstado;
            state.focoGaraje = nuevoEstado;
            actualizarTodasLasUIs();
        } else if (v == botonEnchufesMaster) {
            boolean nuevoEstado = !(state.enchufePp && state.enchufeSp && state.enchufeTp && state.enchufeGaraje);
            state.enchufePp = nuevoEstado;
            state.enchufeSp = nuevoEstado;
            state.enchufeTp = nuevoEstado;
            state.enchufeGaraje = nuevoEstado;
            actualizarTodasLasUIs();
        } else if (v == focoPp) {
            state.focoPp = !state.focoPp;
            actualizarFoco(focoPp, state.focoPp);
        } else if (v == focoSp) {
            state.focoSp = !state.focoSp;
            actualizarFoco(focoSp, state.focoSp);
        } else if (v == focoTp) {
            state.focoTp = !state.focoTp;
            actualizarFoco(focoTp, state.focoTp);
        } else if (v == focoGaraje) {
            state.focoGaraje = !state.focoGaraje;
            actualizarFoco(focoGaraje, state.focoGaraje);
        } else if (v == enchufePp) {
            state.enchufePp = !state.enchufePp;
            actualizarEnchufe(enchufePp, state.enchufePp);
        } else if (v == enchufeSp) {
            state.enchufeSp = !state.enchufeSp;
            actualizarEnchufe(enchufeSp, state.enchufeSp);
        } else if (v == enchufeTp) {
            state.enchufeTp = !state.enchufeTp;
            actualizarEnchufe(enchufeTp, state.enchufeTp);
        } else if (v == enchufeGaraje) {
            state.enchufeGaraje = !state.enchufeGaraje;
            actualizarEnchufe(enchufeGaraje, state.enchufeGaraje);
        }
    }

    private void actualizarFoco(ImageButton boton, boolean encendido) {
        if (encendido) {
            boton.setImageResource(R.drawable.foco_encendido);
        } else {
            boton.setImageResource(R.drawable.foco_apagado);
        }
    }

    private void actualizarEnchufe(ImageButton boton, boolean encendido) {
        if (encendido) {
            boton.setImageResource(R.drawable.on);
        } else {
            boton.setImageResource(R.drawable.off);
        }
    }
}
