package com.example.aula7;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aula7.R;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView img1;
    TextView txt1;
    Button btn1;
    // váriaveis para efeitos sonoros e música
    SoundPool snd;
    MediaPlayer musica;
    boolean tocar = true;
    int click;
    String frases[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.btn1);
        img1 = findViewById(R.id.img1);
        txt1 = findViewById(R.id.txt1);
        frases = new String[]
                {"A vida trará coisas boas se tiver paciência.",
                "Demonstre amor e alegria em todas as oportunidades e verá que a paz nasce dentro de si.",
                "Não compense na ira o que lhe falta na razão.",
               "Defeitos e virtudes são apenas dois lados da mesma moeda.",
                "A maior de todas as torres começa no solo.",
                "Não há que ser forte. Há que ser flexível."};
        //Efeitos Sonoros
        snd = new SoundPool(4, AudioManager.STREAM_MUSIC,8);
        click = snd.load(MainActivity.this, R.raw.click, 3);
        //Musica
        musica = MediaPlayer.create(MainActivity.this,R.raw.musica);
        musica.start();

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tocar){
                    musica.pause();
                    img1.setImageResource(R.drawable.semsom);
                }
                else{
                    musica.start();
                    img1.setImageResource(R.drawable.som);
                }
                tocar = !tocar;
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random val= new Random();
                int valor = val.nextInt(5);
                txt1.setText(frases[valor]);
                snd.play(click,1,1,1,0,1);
            }
        });
    }
}