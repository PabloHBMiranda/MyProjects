
package com.pablohbm.aed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button jogar1, jogar2, encerrar, info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jogar1 = findViewById(R.id.jogar1);
        jogar2 = findViewById(R.id.jogar2);
        encerrar = findViewById(R.id.encerrarMain);
        info = findViewById(R.id.info);

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Info.class);
                startActivity(i);
                finish();
            }
        });

        encerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        jogar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, TelaJogo.class);
                int opc = 0;
                i.putExtra("OPC",opc);
                startActivity(i);
                finish();
            }
        });

        jogar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Jogar2.class);
                startActivity(i);
                finish();
            }
        });
    }
}