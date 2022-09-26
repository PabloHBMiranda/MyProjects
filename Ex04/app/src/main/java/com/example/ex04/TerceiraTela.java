package com.example.ex04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class TerceiraTela extends AppCompatActivity {
    ImageView img1;
    TextView TTtxt1, TTtxt2, TTtxt3;
    String criticas[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terceira_tela);
        TTtxt1 = findViewById(R.id.TTtxt1);
        TTtxt2 = findViewById(R.id.TTtxt2);
        TTtxt3 = findViewById(R.id.TTtxt3);
        img1 = findViewById(R.id.img1);
        criticas = new String[]
        {
                "Filme muito divertido.",
                "Filme muito legal.",
                "Filme muito interessante.",
                "Filme incrível.",
                "Filme sensacional."
        };
        Intent dadosRecebidos = getIntent();
        TTtxt1.setText(dadosRecebidos.getStringExtra("nome"));

        Random val= new Random();
        int valor = val.nextInt(5);
        TTtxt2.setText(criticas[valor]);
        valor = val.nextInt(10);
        TTtxt3.setText("NOTA: " + valor);
        switch (valor){
            case 1:
                img1.setImageResource(R.drawable.img1);
                break;
            case 2:
                img1.setImageResource(R.drawable.img2);
                break;
            case 3:
                img1.setImageResource(R.drawable.img3);
                break;
            case 4:
                img1.setImageResource(R.drawable.img4);
                break;
            case 5:
                img1.setImageResource(R.drawable.img5);
                break;
            case 6:
                img1.setImageResource(R.drawable.img6);
                break;
            case 7:
                img1.setImageResource(R.drawable.img7);
                break;
            case 8:
                img1.setImageResource(R.drawable.img8);
                break;
            case 9:
                img1.setImageResource(R.drawable.img9);
                break;
            default:
                img1.setImageResource(R.drawable.img10);
                break;
        }
    }
}