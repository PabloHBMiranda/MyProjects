package com.example.aula6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText ed01, ed02, ed03;
    ListView lista1;
    Button btn01;
    List<String> nomes;
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //conexão com o XML
        lista1 = findViewById(R.id.lista1);
        ed01 = findViewById(R.id.ed01);
        ed02 = findViewById(R.id.ed02);
        btn01 = findViewById(R.id.btn01);
        ed03 = findViewById(R.id.ed03);
        nomes = new ArrayList<>();
        nomes.add("Jorge - +01 33 1234");
        nomes.add("André - +55 16 993751412");
        nomes.add("Gustavo - +55 11 986741256");
        nomes.add("Kaio Alencar - +55 17 984724532");
        adapter = new ArrayAdapter(MainActivity.this,
                android.R.layout.simple_expandable_list_item_1,
                nomes);
        lista1.setAdapter(adapter);
        ed01.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                (MainActivity.this).adapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });
        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ed02.getText().toString().isEmpty() && ed03.getText().toString().isEmpty()){
                    Toast.makeText(
                            MainActivity.this,
                            "Campos Não podem ficar vazios",
                            Toast.LENGTH_SHORT
                    ).show();
                }
                else{
                    String texto = ed02.getText().toString()
                    + " - "
                    + ed03.getText().toString();
                    nomes.add(texto);
                    adapter.notifyDataSetChanged();
                    lista1.setAdapter(adapter);
                    ed02.setText("");
                    ed03.setText("");
                }
            }
        });
        lista1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String valor = adapter.getItem(i).toString();
                String nome = valor.split("-")[0];
                String telefone = valor.split("-")[1];
                Intent tela1 = new Intent(MainActivity.this, SegundaTela.class);
                tela1.putExtra("nome", nome);
                tela1.putExtra("telefone",telefone);
                //Toast.makeText(MainActivity.this,nome,Toast.LENGTH_SHORT).show();
                startActivity(tela1);
                finish();
            }
        });
    }
}