package com.example.aula_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class segundatela extends AppCompatActivity {
    Button voltar_1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundatela);
        voltar_1 = findViewById(R.id.btn_2);
        voltar_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent md1 = new Intent(segundatela.this, MainActivity.class);
                startActivity(md1);
            }
        });
    }
}