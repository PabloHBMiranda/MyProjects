package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SensorAct extends AppCompatActivity implements SensorEventListener {
    Button btnVoltar;
    TextView titulo, texto;
    long timeUpdate;
    SensorManager sensorManager;
    boolean trocaCor = false;
    View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);
        btnVoltar = findViewById(R.id.voltar);
        titulo = findViewById(R.id.titulo);
        texto = findViewById(R.id.texto);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        timeUpdate = System.currentTimeMillis();
        view = findViewById(R.id.view);

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent o = new Intent(SensorAct.this, MainActivity.class);
                startActivity(o);
                finish();
            }
        });
    }

    private void getAcelerometro(SensorEvent event, TextView txt){
        float[] valores =  event.values;
        float x = valores[0];
        float y = valores[1];
        float z = valores[2];

        float equacao = (float) (( (x*x) + (y*y) + (z*z))/(Math.pow(SensorManager.GRAVITY_EARTH,2)));
        long horaAtual = event.timestamp;

        if(equacao >= 2){
            if(horaAtual - timeUpdate < 200){
                return;
            }
            timeUpdate = horaAtual;
            if(trocaCor){
                texto.setTextColor(Color.RED);
                titulo.setTextColor(Color.RED);
                view.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
            }
            else{
                texto.setTextColor(Color.BLUE);
                titulo.setTextColor(Color.BLUE);
                view.setBackgroundColor(getResources().getColor(android.R.color.white));
            }
            trocaCor = !trocaCor;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this,
                sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if(sensorEvent.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
            getAcelerometro(sensorEvent, texto);
            getAcelerometro(sensorEvent, titulo);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {}
}