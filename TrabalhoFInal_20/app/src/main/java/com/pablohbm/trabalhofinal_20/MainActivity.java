package com.pablohbm.trabalhofinal_20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button fecharMain, infoMain, pedidosMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fecharMain = findViewById(R.id.fecharMain);
        infoMain = findViewById(R.id.infoMain);
        pedidosMain = findViewById(R.id.pedidosMain);

        fecharMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        infoMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Info.class);
                startActivity(i);
                finish();
            }
        });

        pedidosMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Pedidos.class);
                startActivity(i);
                finish();
            }
        });
    }
}