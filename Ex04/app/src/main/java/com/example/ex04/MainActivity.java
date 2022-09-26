package com.example.ex04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btn1;
    EditText ed1, ed2, ed3, ed4, ed5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.btn1);
        ed1 = findViewById(R.id.ed1);
        ed2 = findViewById(R.id.ed2);
        ed3 = findViewById(R.id.ed3);
        ed4 = findViewById(R.id.ed4);
        ed5 = findViewById(R.id.ed5);

       btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!(ed1.getText().length()==0) && !(ed2.getText().length()==0) && !(ed3.getText().length()==0) &&
                !(ed4.getText().length()==0) && !(ed5.getText().length()==0)){
                    Intent main = new Intent(MainActivity.this, SegundaTela.class);
                    main.putExtra("filme1", ed1.getText().toString());
                    main.putExtra("filme2", ed2.getText().toString());
                    main.putExtra("filme3", ed3.getText().toString());
                    main.putExtra("filme4", ed4.getText().toString());
                    main.putExtra("filme5", ed5.getText().toString());
                    startActivity(main);
                    finish();
                }
                else{
                    Toast.makeText(MainActivity.this,
                            "Não pode ter campo vazio. Digite.",
                            Toast.LENGTH_SHORT
                    ).show();
                }
            }
        });
    }
}