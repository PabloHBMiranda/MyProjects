package com.pablohbm.trabalhofinal_20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Pedidos extends AppCompatActivity {

    int opc;
    Button voltarPedidos;
    ImageView pikachux, ratataprincesa, bulbatree;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedidos);

        voltarPedidos = findViewById(R.id.voltarPedidos);
        pikachux = findViewById(R.id.pikachux);
        ratataprincesa = findViewById(R.id.ratataprincesa);
        bulbatree = findViewById(R.id.bulbatree);

        voltarPedidos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Pedidos.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        pikachux.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Pedidos.this, FazerPedidos.class);
                opc = 1;
                i.putExtra("opc", opc);
                startActivity(i);
                finish();
            }
        });

        ratataprincesa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Pedidos.this, FazerPedidos.class);
                opc = 2;
                i.putExtra("opc", opc);
                startActivity(i);
                finish();
            }
        });

        bulbatree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Pedidos.this, FazerPedidos.class);
                opc = 3;
                i.putExtra("opc", opc);
                startActivity(i);
                finish();
            }
        });
    }
}