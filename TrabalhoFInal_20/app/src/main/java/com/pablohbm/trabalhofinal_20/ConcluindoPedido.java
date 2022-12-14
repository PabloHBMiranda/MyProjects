package com.pablohbm.trabalhofinal_20;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

public class ConcluindoPedido extends AppCompatActivity {

    public void cadastrar() {

        if (!rua.getText().toString().equals("") && !bairro.getText().toString().equals("") && !num.getText().toString().equals("") &&
                !comple.getText().toString().equals("") && !cep.getText().toString().equals("")) {
            try {
                bancoDados = openOrCreateDatabase("AppPokemonQD", MODE_PRIVATE, null);
                String sql = "INSERT INTO pedido(rua) VALUES(?)";

                numped.setText("ENTROU!");

                String texto = 1 + " - "+ rua.getText().toString() + ", " + num.getText().toString() + ", " +
                        comple.getText().toString() + ", " + bairro.getText().toString() + ", " + cep.getText().toString();
                SQLiteStatement stmt = bancoDados.compileStatement(sql);
                stmt.bindString(1,texto);
                stmt.executeInsert();
                bancoDados.close();
                Intent i = new Intent(ConcluindoPedido.this, MainActivity.class);
                startActivity(i);
                finish();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            Toast.makeText(this, "Campo Vazio", Toast.LENGTH_SHORT).show();
        }

    }


    EditText rua, num, comple, bairro, cep;
    TextView numped;
    Button btnConcPed, btnVoltarConcPed;
    SQLiteDatabase bancoDados;
    NotificationManagerCompat notificationManagerCompat;
    Notification notification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concluindo_pedido);

        numped = findViewById(R.id.numped);

        rua = findViewById(R.id.rua);
        num = findViewById(R.id.num);
        comple = findViewById(R.id.comple);
        cep = findViewById(R.id.cep);
        bairro = findViewById(R.id.bairro);

        btnConcPed = findViewById(R.id.btnConcPed);
        btnVoltarConcPed = findViewById(R.id.btnVoltarConcPed);

        btnConcPed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cadastrar();
            }
        });

        /*if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("MyCh","My Channel",NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,"myCh").setSmallIcon(android.R.drawable.stat_notify_sync).
                setContentTitle("ATENÇÃO").
                setContentText("Pedido Realizado");

        notification = builder.build();
        notificationManagerCompat = NotificationManagerCompat.from(this);*/

        btnVoltarConcPed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ConcluindoPedido.this, FazerPedidos.class);
                startActivity(i);
                finish();
            }
        });

    }
}