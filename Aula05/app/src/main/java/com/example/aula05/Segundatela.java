package com.example.aula05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class Segundatela extends AppCompatActivity {
    String  texto;
    int dado;
    ImageView tossed_dice;
    TextView texto01;
    Button btn02;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundatela);
        btn02 = findViewById(R.id.btn02);
        tossed_dice = findViewById(R.id.tossed_dice);
        texto01 = findViewById(R.id.texto01);
        Intent i = getIntent();
        texto = i.getStringExtra("texto");
        dado = i.getIntExtra("dado",1);
        texto01.setText(texto);
        switch (dado){
            case 1:
                tossed_dice.setImageResource(R.drawable.face01);
                break;
            case 2:
                tossed_dice.setImageResource(R.drawable.face02);
                break;
            case 3:
                tossed_dice.setImageResource(R.drawable.face03);
                break;
            case 4:
                tossed_dice.setImageResource(R.drawable.face04);
                break;
            case 5:
                tossed_dice.setImageResource(R.drawable.face05);
                break;
            case 6:
                tossed_dice.setImageResource(R.drawable.face06);
                break;
            default:
                tossed_dice.setImageResource(R.drawable.face02);
                break;
        }
        btn02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent btnvoltar = new Intent(Segundatela.this, MainActivity.class);
                startActivity(btnvoltar);
                finish();
            }
        });
    }
}