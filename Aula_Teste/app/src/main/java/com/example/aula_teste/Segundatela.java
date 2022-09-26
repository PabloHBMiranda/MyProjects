package com.example.aula_teste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

public class Segundatela extends AppCompatActivity {
    int alt1;
    String xl;
    Button btn03, btn04;
    TextView tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Random r = new Random(100);
        setContentView(R.layout.activity_segundatela);
        btn03 = findViewById(R.id.btn03);
        btn04 = findViewById(R.id.btn04);
        tv2 = findViewById(R.id.tv2);
        btn04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alt1 = r.nextInt(100);
                tv2.setText(Integer.toString(alt1));
            }
        });
        btn03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent md2 = new Intent(Segundatela.this, MainActivity.class);
                startActivity(md2);
                finish();
            }
        });
    }
}