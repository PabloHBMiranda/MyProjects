package com.pablohbm.aed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import java.util.ArrayList;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;



public class TelaJogo extends AppCompatActivity {

    public int TesteLetra(String letraEditText) {
        char letra = letraEditText.charAt(0);
        int possuiLetra = 0;
        for (i = 0; i < palavraJogada.length(); i++) {
            if (letra == palavraJogada.charAt(i)) {
                listaLetras.set(i, letra);
                possuiLetra = 1;
            }
        }
        palavraTela = "";
        for (i = 0 ; i < listaLetras.size(); i++) {
            palavraTela += listaLetras.get(i);
        }
        return possuiLetra;
    }

    public int MudaForca(){
        if(erros == 0){
            cabeca.setVisibility(View.VISIBLE);
            erros++;
        }
        else{
            if(erros == 1){
                tronco.setVisibility(View.VISIBLE);
                erros++;
            }
            else{
                if(erros == 2){
                    bdireito.setVisibility(View.VISIBLE);
                    erros++;
                }
                else{
                    if(erros == 3){
                        besquerdo.setVisibility(View.VISIBLE);
                        erros++;
                    }
                    else{
                        if(erros==4){
                            pesquerdo.setVisibility(View.VISIBLE);
                            erros++;
                        }
                        else{
                            pdireito.setVisibility(View.VISIBLE);
                            erros++;
                        }
                    }
                }
            }
        }
        return erros;
    }


    EditText edLetra, edjogoPalavra;
    Button btnLetra, btnPalavra, menuJogo, jogoDica;
    ListView listaJogo;
    ImageView cabeca, tronco, bdireito, besquerdo, pesquerdo, pdireito;
    TextView palavraJogo;
    String palavraJogada, palavraTela;
    String dicaJogada;
    int i, erros = 0;
    ArrayList listaLetras = new ArrayList();

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

        for (i = 0; i < palavraJogada.length(); i++) {
            if (' ' == (palavraJogada.charAt(i))) {
                listaLetras.add(" ");
            } else {
                listaLetras.add("_");
            }

        }

        for(i = 0; i < listaLetras.size(); i++){
            palavraTela+=listaLetras.get(i);
        }

        palavraJogo.setText(palavraTela);

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
                if (!edLetra.getText().equals("")) {
                    String letraJogada = edLetra.getText().toString();
                    if(TesteLetra(letraJogada) == 1){
                        palavraJogo.setText(palavraTela);
                    }
                    else{
                        if(MudaForca() > 5){
                            Intent i = new Intent(TelaJogo.this, GameOver.class);
                        }
                    }
                } else {
                    Toast.makeText(TelaJogo.this, "Campo Vazio", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}