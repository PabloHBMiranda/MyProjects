package com.pablohbm.aed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Venceu extends AppCompatActivity {
    Button venceuMenu;
    TextView txtVenceu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venceu);
        venceuMenu = findViewById(R.id.venceuMenu);
        txtVenceu = findViewById(R.id.txtVenceu);

        Intent pegarDados = getIntent();

        txtVenceu.setText("PALAVRA: " + pegarDados.getStringExtra("PALAVRA").toUpperCase());

        venceuMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Venceu.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}