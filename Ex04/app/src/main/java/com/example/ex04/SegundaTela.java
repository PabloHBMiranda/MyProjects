package com.example.ex04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class SegundaTela extends AppCompatActivity {

    ListView lista1;
    ArrayList<String> filmes;
    EditText STed1;
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_tela);
        lista1 = findViewById(R.id.lista);
        STed1 = findViewById(R.id.STed1);
        filmes = new ArrayList<>();
        filmes.add("Vingadores: Guerra Infinita");
        filmes.add("Django Livre");
        filmes.add("Corra!");
        filmes.add("Meu Malvado Favorito");
        filmes.add("Senhor dos Anéis: E as duas Torres");

        Intent pegafilme = getIntent();
        filmes.add(pegafilme.getStringExtra("filme1"));
        filmes.add(pegafilme.getStringExtra("filme2"));
        filmes.add(pegafilme.getStringExtra("filme3"));
        filmes.add(pegafilme.getStringExtra("filme4"));
        filmes.add(pegafilme.getStringExtra("filme5"));

        adapter = new ArrayAdapter(SegundaTela.this, android.R.layout.simple_list_item_1, filmes);
        lista1.setAdapter(adapter);

        STed1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                (SegundaTela.this).adapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });
        lista1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String nome = adapter.getItem(i).toString();
                Intent tela2 = new Intent(SegundaTela.this, TerceiraTela.class);
                tela2.putExtra("nome",nome);
                startActivity(tela2);
                finish();
            }
        });
    }
}