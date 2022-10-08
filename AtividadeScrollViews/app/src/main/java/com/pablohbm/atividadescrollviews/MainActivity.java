package com.pablohbm.atividadescrollviews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText nome, cpf, dastanasc, telefone, celular, email, buscar;
    ListView lista;
    Button btn;
    ArrayAdapter adapter;
    ArrayList<String> dados;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dados = new ArrayList<>();
        btn = findViewById(R.id.btn);
        nome = findViewById(R.id.nome);
        cpf = findViewById(R.id.cpf);
        dastanasc = findViewById(R.id.datanasc);
        telefone = findViewById(R.id.telefone);
        celular = findViewById(R.id.celular);
        email = findViewById(R.id.email);
        buscar = findViewById(R.id.buscar);
        lista = findViewById(R.id.lista);

        adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, dados);
        lista.setAdapter(adapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!cpf.getText().toString().isEmpty() && !nome.getText().toString().isEmpty()
                && !dastanasc.getText().toString().isEmpty() && !telefone.getText().toString().isEmpty()
                && !celular.getText().toString().isEmpty() && !email.getText().toString().isEmpty()){
                    String adc = nome.getText().toString() + " - " + cpf.getText().toString() + " - "
                            + dastanasc.getText().toString() + " - " + telefone.getText().toString()
                            + celular.getText().toString() + " - " + email.getText().toString();
                    dados.add(adc);
                    adapter.notifyDataSetChanged();
                    lista.setAdapter(adapter);
                    cpf.setText("");
                    nome.setText("");
                    dastanasc.setText("");
                    telefone.setText("");
                    celular.setText("");
                    email.setText("");
                }
                else{
                    Toast.makeText(MainActivity.this,
                            "Não pode ter campo vazio. Digite.",
                            Toast.LENGTH_SHORT
                    ).show();
                }
            }
        });

        buscar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                (MainActivity.this).adapter.getFilter().filter(charSequence);
                lista.setAdapter(adapter);
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });


        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,
                        "Removeu: " + dados.get(i),
                        Toast.LENGTH_SHORT).show();
                dados.remove(i);
                adapter.notifyDataSetChanged();
                lista.setAdapter(adapter);
            }
        });
    }
}