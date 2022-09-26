package com.fer.aula07_trabalhando_varios_layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg01, rg02, rg03, rg04, rg05;
    RadioButton rb01, rb02, rb03, rb04, rb05;
    Button btnEnviar;
    int calc = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg01 = findViewById(R.id.botoes01);
        rg02 = findViewById(R.id.botoes02);
        rg03 = findViewById(R.id.botoes03);
        rg04 = findViewById(R.id.botoes04);
        rg05 = findViewById(R.id.botoes05);
        btnEnviar = findViewById(R.id.btnEnviar);

        rg01.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int idBtn = rg01.getCheckedRadioButtonId();
                rb01 = findViewById(idBtn);
                if(rb01.getText().equals("Sim")){
                    calc++;
                }
                else{
                    calc--;
                }
                rb01 = findViewById(R.id.bt101);
                rb01.setEnabled(false);
                rb01 = findViewById(R.id.bt102);
                rb01.setEnabled(false);
            }
        });

        rg02.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int idBtn = rg02.getCheckedRadioButtonId();
                rb02 = findViewById(idBtn);
                if(rb02.getText().equals("Sim")){
                    calc++;
                }
                else{
                    calc--;
                }
                rb02 = findViewById(R.id.bt201);
                rb02.setEnabled(false);
                rb02 = findViewById(R.id.bt202);
                rb02.setEnabled(false);

            }
        });

        rg03.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int idBtn = rg03.getCheckedRadioButtonId();
                rb03 = findViewById(idBtn);
                if(rb03.getText().equals("Sim")){
                    calc++;
                }
                else{
                    calc--;
                }
                rb03 = findViewById(R.id.bt301);
                rb03.setEnabled(false);
                rb03 = findViewById(R.id.bt302);
                rb03.setEnabled(false);
            }
        });

        rg04.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int idBtn = rg04.getCheckedRadioButtonId();
                rb04 = findViewById(idBtn);
                if(rb04.getText().equals("Sim")){
                    calc++;
                }
                else{
                    calc--;
                }
                rb04 = findViewById(R.id.bt401);
                rb04.setEnabled(false);
                rb04 = findViewById(R.id.bt402);
                rb04.setEnabled(false);
            }
        });

        rg05.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int idBtn = rg05.getCheckedRadioButtonId();
                rb05= findViewById(idBtn);
                if(rb05.getText().equals("Sim")){
                    calc++;
                }
                else{
                    calc--;
                }
                rb05 = findViewById(R.id.bt501);
                rb05.setEnabled(false);
                rb05 = findViewById(R.id.bt502);
                rb05.setEnabled(false);
            }
        });
    }
}