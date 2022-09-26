package com.example.ex05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn1;
    SoundPool snd;
    int click;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.T1btn1);
        snd = new SoundPool(4, AudioManager.STREAM_MUSIC,8);
        click = snd.load(MainActivity.this,R.raw.pickupcoin,3);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, SegundaTela.class);
                snd.play(click,1,1,1,0,1);
                startActivity(i);
                finish();
            }
        });
    }
}