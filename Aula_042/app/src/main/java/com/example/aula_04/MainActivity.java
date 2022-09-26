/*
    Criar uma ListView com Layout a escolha
    Criar um ArrayList que já contenha valores inderidos.
    Permita que possam ser adicionado mais itens a lista, mostrar 3 botões que mostre:
    1. Lista Ordenada Crescente.
    2. Lista Ordenada Descrescente.
    3. Lista Embaralhada.

 */
package com.example.aula_04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {
    ListView lista1;
    Button btn_inserir, btn_cres, btn_decres, btn_embaralhada;
    EditText edit_inserir;
    String inr1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_inserir = findViewById(R.id.btn01);
        edit_inserir = findViewById(R.id.ed01);
        btn_cres = findViewById(R.id.crescente);
        btn_decres = findViewById(R.id.decrescente);
        btn_embaralhada = findViewById(R.id.desordem);
        lista1 = findViewById(R.id.lista);
        ArrayList<String> nomes = new ArrayList();
        nomes.add("Arnold");
        nomes.add("Bruyne");
        nomes.add("Harry");
        nomes.add("Peter");
        nomes.add("Stones");
        nomes.add("Walker");
        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.list_custom, nomes);
        lista1.setAdapter(adapter);
        btn_inserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inr1 = edit_inserir.getText().toString();
                if(!inr1.isEmpty()) {
                    nomes.add(inr1);
                    adapter.notifyDataSetChanged();
                    edit_inserir.setText("");
                    lista1.setAdapter(adapter);
                }
            }
        });
        lista1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,
                        "Removeu: " + nomes.get(i),
                        Toast.LENGTH_SHORT).show();
                nomes.remove(i);
                adapter.notifyDataSetChanged();
                lista1.setAdapter(adapter);
            }
        });
        btn_cres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Collections.sort(nomes);
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this,
                            "Lista Crescente",
                            Toast.LENGTH_SHORT).show();
            }
        });
        btn_decres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Collections.sort(nomes, Collections.reverseOrder());
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this,
                        "Lista Decrescente",
                        Toast.LENGTH_SHORT).show();
            }
        });
        btn_embaralhada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Collections.shuffle(nomes);
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this,
                        "Lista Embaralhada",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}