package com.pablohbm.aed;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class TelaJogo extends AppCompatActivity {

    public static final String MyPREFERENCES = "MyPrefs" ;
    public final String plv = "plvKey";
    public static final int jogou = 0;
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
        for (i = 0; i < listaLetras.size(); i++) {
            palavraTela += listaLetras.get(i);
        }
        return possuiLetra;
    }

    public int MudaForca() {
        if (erros == 0) {
            cabeca.setVisibility(View.VISIBLE);
            erros++;
        } else {
            if (erros == 1) {
                tronco.setVisibility(View.VISIBLE);
                erros++;
            } else {
                if (erros == 2) {
                    bdireito.setVisibility(View.VISIBLE);
                    erros++;
                } else {
                    if (erros == 3) {
                        besquerdo.setVisibility(View.VISIBLE);
                        erros++;
                    } else {
                        if (erros == 4) {
                            pesquerdo.setVisibility(View.VISIBLE);
                            erros++;
                        } else {
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
    Button btnLetra, btnPalavra, menuJogo, btnDica;
    ListView listaJogo;
    ImageView cabeca, tronco, bdireito, besquerdo, pesquerdo, pdireito, forca;
    TextView palavraJogo, ultimaPalavra;
    String palavraJogada = "", palavraTela = "", ultimaPlv;
    String dicaJogada = "";
    int i, erros = 0;
    ArrayList listaLetras = new ArrayList();
    ArrayList jogadasErradas = new ArrayList();
    ArrayAdapter adapter;
    String sorteioPalavras[];
    String sorteioDicas[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telajogo);
        menuJogo = findViewById(R.id.menuJogo);
        edLetra = findViewById(R.id.edLetra);
        edjogoPalavra = findViewById(R.id.edjogoPalavra);
        btnLetra = findViewById(R.id.btnLetra);
        btnPalavra = findViewById(R.id.btnPalavra);
        btnDica = findViewById(R.id.jogoDica);
        listaJogo = findViewById(R.id.listaJogo);
        palavraJogo = findViewById(R.id.palavraJogo);
        ultimaPalavra = findViewById(R.id.ultimaPalavra);

        adapter = new ArrayAdapter(TelaJogo.this, android.R.layout.simple_list_item_1, jogadasErradas);
        listaJogo.setAdapter(adapter);

        SharedPreferences pref = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = pref.edit();

        //boneco
        cabeca = findViewById(R.id.cabeca);
        tronco = findViewById(R.id.tronco);
        bdireito = findViewById(R.id.bdireito);
        besquerdo = findViewById(R.id.besquerdo);
        pesquerdo = findViewById(R.id.pesquerdo);
        pdireito = findViewById(R.id.pdireito);
        forca = findViewById(R.id.forca);
        //boneco

        ultimaPlv = pref.getString(plv,"");
        ultimaPalavra.setText("ULTIMA PALAVRA: " + ultimaPlv);

        Intent receberDados = getIntent();

        int opc;
        opc = receberDados.getIntExtra("OPC", 0);


        if (opc == 0) {
            Random r = new Random();
            int x = r.nextInt(10);
            sorteioPalavras = new String[]
                    {"MOUSE", "CADEIRA", "CABELO", "ANTENA", "OLEO MOTOR", "PAO DE HAMBURGUER", "PERFUME", "AÇAI", "BOMBA DE GASOLINA", "QUADRA DE FUTEBOL"};
            palavraJogada = sorteioPalavras[x];
            sorteioDicas = new String[]
                    {"Tem pra computador e pra um desenho ai chamado T e J.",
                            "Você pode estar em cima dela nesse momento.",
                            "Você concerteza tem, mas não em todos os lugares de VOCÊ.",
                            "As 'coisas' chegam por ela, tem em cima das casas ou não.",
                            "Deixa o carro bem 'lisinho'.",
                            "Ele completa a felicidade, pois está acima e abaixo ao mesmo tempo.",
                            "Muito conhecido por melhorar o 'ambiente' da França.",
                            "Já foi patente JAPONESA, como é que pode isso?",
                            "Nós brasileiros não gostamos muito de colocar isso, por conta do alto custo, mas é necessário para andarmos grandes distâncias.",
                            "O bagulho é COPA, mas em proporções reduzidas."};
            dicaJogada = sorteioDicas[x];
        }
        else{
            palavraJogada = receberDados.getStringExtra("PALAVRA").toUpperCase();
            dicaJogada = receberDados.getStringExtra("DICA");

        }




        for (i = 0; i < palavraJogada.length(); i++) {
            if (' ' == (palavraJogada.charAt(i))) {
                listaLetras.add(" ");
            } else {
                listaLetras.add("_");
            }

        }

        for (i = 0; i < listaLetras.size(); i++) {
            palavraTela += listaLetras.get(i);
        }

        palavraJogo.setText(palavraTela);


        btnDica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(TelaJogo.this);
                builder1.setTitle("DICA!");
                builder1.setMessage(dicaJogada);
                builder1.show();
            }
        });

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
                if (!edLetra.getText().toString().equals("")) {
                    String jogouLetra = edLetra.getText().toString().toUpperCase();
                    if (TesteLetra(jogouLetra) == 1) {
                        palavraJogo.setText(palavraTela);
                        if (palavraTela.equals(palavraJogada)) {
                            ed.putString(plv, palavraJogada);
                            ed.apply();
                            Intent i = new Intent(TelaJogo.this, Venceu.class);
                            i.putExtra("PALAVRA",palavraJogada);
                            startActivity(i);
                            finish();
                        }
                        edLetra.setText("");
                    } else {
                        jogadasErradas.add(jogouLetra);
                        adapter.notifyDataSetChanged();
                        if (MudaForca() > 5) {
                            ed.putString(plv, palavraJogada);
                            ed.apply();
                            Intent i = new Intent(TelaJogo.this, Venceu.class);
                            i.putExtra("PALAVRA",palavraJogada);
                            startActivity(i);
                            finish();
                        }
                        edLetra.setText("");
                    }
                } else {
                    Toast.makeText(TelaJogo.this, "Campo Vazio", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnPalavra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!edjogoPalavra.getText().toString().equals("")) {
                    String jogouPalavra = edjogoPalavra.getText().toString().toUpperCase();
                    if (jogouPalavra.equals(palavraJogada)) {
                        ed.putString(plv, palavraJogada);
                        ed.apply();
                        Intent i = new Intent(TelaJogo.this, Venceu.class);
                        i.putExtra("PALAVRA",palavraJogada);
                        startActivity(i);
                        finish();
                    } else {
                        jogadasErradas.add(jogouPalavra);
                        adapter.notifyDataSetChanged();
                        if (MudaForca() > 5) {
                            ed.putString(plv, palavraJogada);
                            ed.apply();
                            Intent i = new Intent(TelaJogo.this, Venceu.class);
                            i.putExtra("PALAVRA",palavraJogada);
                            startActivity(i);
                            finish();
                        }
                        edjogoPalavra.setText("");
                    }
                } else {
                    Toast.makeText(TelaJogo.this, "Campo Vazio", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}