package com.pablohbm.aed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameOver extends AppCompatActivity {

    Button perdeuMenu;
    TextView txtPerdeu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        perdeuMenu = findViewById(R.id.perdeuMenu);
        txtPerdeu = findViewById(R.id.txtPerdeu);

        Intent pegarDados = getIntent();

        txtPerdeu.setText("PALAVRA: " + pegarDados.getStringExtra("PALAVRA").toUpperCase());

        perdeuMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(GameOver.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}