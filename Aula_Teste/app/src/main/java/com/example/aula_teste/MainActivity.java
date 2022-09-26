package com.example.aula_teste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn01, btn02;
    EditText eTxt1, eTxt2;
    TextView tv1;
    String resul1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn01 = findViewById(R.id.btn01);
        btn02 = findViewById(R.id.btn02);
        eTxt1 = findViewById(R.id.eTxt1);
        eTxt2 = findViewById(R.id.eTxt2);
        tv1 = findViewById(R.id.tv1);
        btn02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resul1 = eTxt1.getText().toString()+eTxt2.getText().toString();
                tv1.setText(resul1);
            }
        });
        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent md1 = new Intent(MainActivity.this, Segundatela.class);
                startActivity(md1);
            }
        });

    }
}