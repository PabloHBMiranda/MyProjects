package com.pablohbm.aed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class TelaJogo extends AppCompatActivity {
    public void TesteLetra(String letra){
        int i, j;
        for(i = 0; i < letra.length(); i++){

        }
    }


    EditText edLetra, edjogoPalavra;
    Button btnLetra, btnPalavra, menuJogo, jogoDica;
    ListView listaJogo;
    ImageView cabeca, tronco, bdireito, besquerdo, pesquerdo, pdireito;
    TextView palavraJogo;
    String palavraJogada;
    String dicaJogada;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telajogo);
        menuJogo = findViewById(R.id.menuJogo);
        edLetra = findViewById(R.id.edLetra);
        edjogoPalavra = findViewById(R.id.edjogoPalavra);
        btnLetra = findViewById(R.id.btnLetra);
        btnPalavra = findViewById(R.id.btnPalavra);
        jogoDica = findViewById(R.id.jogoDica);
        listaJogo = findViewById(R.id.listaJogo);
        palavraJogo = findViewById(R.id.palavraJogo);

        //boneco
        cabeca = findViewById(R.id.cabeca);
        tronco = findViewById(R.id.tronco);
        bdireito = findViewById(R.id.bdireito);
        besquerdo = findViewById(R.id.besquerdo);
        pesquerdo = findViewById(R.id.pesquerdo);
        pdireito = findViewById(R.id.pdireito);
        //boneco

        menuJogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TelaJogo.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        btnLetra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!edLetra.getText().equals("")){

                }
                else{
                    Toast.makeText(TelaJogo.this, "Campo Vazio", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}