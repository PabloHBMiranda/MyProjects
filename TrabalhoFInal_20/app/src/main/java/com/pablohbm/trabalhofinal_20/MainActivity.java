package com.pablohbm.trabalhofinal_20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    SQLiteDatabase bancoDados;

    public void criarBancoDados(){
        try{
            bancoDados = openOrCreateDatabase("AppPokemonQD", MODE_PRIVATE, null);
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS pedido(rua VARCHAR)");
            bancoDados.close();
            trabalho.setText("AALALALA");

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    Button fecharMain, infoMain, pedidosMain, btnListaPedido;

    TextView trabalho;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fecharMain = findViewById(R.id.fecharMain);
        infoMain = findViewById(R.id.infoMain);
        pedidosMain = findViewById(R.id.pedidosMain);
        btnListaPedido = findViewById(R.id.btnListaPedido);
        trabalho = findViewById(R.id.trabalho);

        criarBancoDados();

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

        btnListaPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, PedidosFeitos.class);
                startActivity(i);
                finish();
            }
        });
    }
}