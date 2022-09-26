package com.example.ex05;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class SegundaTela extends AppCompatActivity {

    public void chamaButton(Button btn, int valbtn){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = valbtn;
                if(x == localBomba){
                    Intent i = new Intent(SegundaTela.this, TerceiraTela.class);
                    i.putExtra("tentativas",tentativas + 1);
                    snd.play(click2,1,1,1,0,1);
                    startActivity(i);
                    finish();
                }
                else{
                    tentativas++;
                    snd.play(click,1,1,1,0,1);
                    btn.setBackgroundColor(Color.parseColor("#FF8E0E0E"));
                    T2txt2.setText("TENTATIVAS:  " + tentativas);
                    btn.setClickable(false);
                }
            }
        });
    }

    TextView T2txt2;
    int tentativas = 0;
    int localBomba;
    SoundPool snd;
    int click, click2;
    int i;
    Button[] btn = new Button[64];
    int[] nomewBtn = {R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8,
            R.id.btn9, R.id.btn10, R.id.btn11, R.id.btn12, R.id.btn13, R.id.btn14, R.id.btn15, R.id.btn16,
            R.id.btn17, R.id.btn18, R.id.btn19, R.id.btn20, R.id.btn21, R.id.btn22, R.id.btn23, R.id.btn24,
            R.id.btn25, R.id.btn26, R.id.btn27, R.id.btn28, R.id.btn29, R.id.btn30, R.id.btn31, R.id.btn32,
            R.id.btn33, R.id.btn34, R.id.btn35, R.id.btn36, R.id.btn37, R.id.btn38, R.id.btn39, R.id.btn40,
            R.id.btn41, R.id.btn42, R.id.btn43, R.id.btn44, R.id.btn45, R.id.btn46, R.id.btn47, R.id.btn48,
            R.id.btn49, R.id.btn50, R.id.btn51, R.id.btn52, R.id.btn53, R.id.btn54, R.id.btn55, R.id.btn56,
            R.id.btn57, R.id.btn58, R.id.btn59, R.id.btn60, R.id.btn61, R.id.btn62, R.id.btn63, R.id.btn64};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_tela);
        T2txt2 = findViewById(R.id.T2txt2);
        T2txt2.setText("TENTATIVAS:  " + tentativas);
        Random r = new Random();
        snd = new SoundPool(4, AudioManager.STREAM_MUSIC,8);
        click = snd.load(SegundaTela.this,R.raw.pickupcoin,3);
        click2 = snd.load(SegundaTela.this,R.raw.explosion,3);
        localBomba = r.nextInt(63);
        for( i = 0; i < 64; i++){
            btn[i] = findViewById(nomewBtn[i]);
            chamaButton(btn[i],i+1);
        }
    }
}