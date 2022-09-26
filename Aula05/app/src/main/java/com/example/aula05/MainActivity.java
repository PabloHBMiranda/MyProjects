package com.example.aula05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText ed01;
    Button btn01;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed01 = findViewById(R.id.ed01);
        btn01 = findViewById(R.id.btn01);
        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String texto = ed01.getText() == null ?/*if*/ "Sem nome" :/*else*/ ed01.getText().toString();
                Intent btnroll = new Intent(MainActivity.this, Segundatela.class);
                btnroll.putExtra("texto", texto);
                btnroll.putExtra("dado", (int) ((Math.random() * (6-1)) + 1));
                startActivity(btnroll);
                finish();
            }
        });
    }
}