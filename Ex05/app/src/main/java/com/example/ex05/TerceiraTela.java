package com.example.ex05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TerceiraTela extends AppCompatActivity {
    TextView txt2;
    Button T3btn1;
    MediaPlayer musica;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terceira_tela);
        txt2 = findViewById(R.id.T3txt2);
        Intent receberDados = getIntent();
        txt2.setText("TOTAL DE TENTATIVAS: " + "    " + receberDados.getIntExtra("tentativas",0));
        T3btn1 = findViewById(R.id.T3btn1);
        musica = MediaPlayer.create(TerceiraTela.this,R.raw.ayrton_teme);
        musica.start();
        T3btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                musica.stop();
                finish();
            }
        });
    }
}