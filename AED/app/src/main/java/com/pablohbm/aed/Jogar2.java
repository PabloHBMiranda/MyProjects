package com.pablohbm.aed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Jogar2 extends AppCompatActivity {

    Button voltar2, jogar2;
    EditText edDica, edPalavra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogar2);
        voltar2 = findViewById(R.id.voltarTela2);
        jogar2 = findViewById(R.id.iniciarJogo2);
        edDica = findViewById(R.id.edDica);
        edPalavra = findViewById(R.id.edPalavra);

        voltar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Jogar2.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        jogar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!edDica.getText().equals("") && !edPalavra.getText().equals("")){
                    Intent i = new Intent(Jogar2.this, TelaJogo.class);
                    String jogo2Palavra = edPalavra.getText().toString();
                    String jogo2Dica = edDica.getText().toString();
                    int opc = 1;
                    i.putExtra("PALAVRA", jogo2Palavra);
                    i.putExtra("DICA", jogo2Dica);
                    i.putExtra("OPC",opc);
                    startActivity(i);
                    finish();
                }
                else{
                    Toast.makeText(Jogar2.this, "Campo Vazio", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}