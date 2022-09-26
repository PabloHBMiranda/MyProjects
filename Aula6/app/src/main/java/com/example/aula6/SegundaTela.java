package com.example.aula6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SegundaTela extends AppCompatActivity {
    TextView nome, telefone;
    Button btn02;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_tela);
        nome = findViewById(R.id.nome);
        telefone = findViewById(R.id.telefone);
        btn02 = findViewById(R.id.btn02);

        //recebendo dados
        Intent dadosRecebidos = getIntent();
        nome.setText("Nome: " + dadosRecebidos.getStringExtra("nome"));
        telefone.setText("Telefone: " + dadosRecebidos.getStringExtra("telefone"));
        btn02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tela2 = new Intent(SegundaTela.this, MainActivity.class);
                startActivity(tela2);
                finish();
            }
        });
    }
}