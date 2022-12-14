package com.pablohbm.trabalhofinal_20;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;

public class ConcluindoPedido extends AppCompatActivity {

    public void cadastrar() {

        if (!rua.getText().toString().equals("") && !bairro.getText().toString().equals("") && !num.getText().toString().equals("") &&
                !comple.getText().toString().equals("") && !cep.getText().toString().equals("")) {
            try {
                bancoDados = openOrCreateDatabase("AppPokemonQD", MODE_PRIVATE, null);
                String sql = "INSERT INTO pedido(rua) VALUES(?)";



                String texto = "N° PEDIDO: " + x + "\n" + rua.getText().toString() + "; " + num.getText().toString() + "; " +
                        comple.getText().toString() + "; " + bairro.getText().toString() + "; " + cep.getText().toString()
                        + "\nOBRA: " + produtoEscolhido;
                SQLiteStatement stmt = bancoDados.compileStatement(sql);
                stmt.bindString(1, texto);
                stmt.executeInsert();
                bancoDados.close();
                Intent i = new Intent(ConcluindoPedido.this, MainActivity.class);
                startActivity(i);
                finish();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Toast.makeText(this, "Campo Vazio", Toast.LENGTH_SHORT).show();
        }

    }


    EditText rua, num, comple, bairro, cep;
    TextView numped;
    Button btnConcPed, btnVoltarConcPed, buscar;
    SQLiteDatabase bancoDados;
    Random r = new Random();
    int x = r.nextInt(10000);

    String produtoEscolhido = "";

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
        buscar = findViewById(R.id.buscar);

        numped.setText("N° PEDIDO: " + x);

        Intent pegardados = getIntent();

        int opc = pegardados.getIntExtra("opc",0);

        if (opc == 1) {
            produtoEscolhido = "PikachuX";
        }
        else{
            if(opc == 2){
                produtoEscolhido = "RatataPrincesa";
            }
            else{
                produtoEscolhido = "BulbaTree";
            }
        }

        btnConcPed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cadastrar();
            }
        });


        btnVoltarConcPed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ConcluindoPedido.this, FazerPedidos.class);
                i.putExtra("opc", opc);
                startActivity(i);
                finish();
            }
        });

        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!cep.getText().toString().equals("")) {
                    Tarefa tarefa = new Tarefa();
                    tarefa.execute("https://viacep.com.br/ws/" + cep.getText().toString() + "/json/");
                    rua.setVisibility(View.VISIBLE);
                    comple.setVisibility(View.VISIBLE);
                    bairro.setVisibility(View.VISIBLE);
                    num.setVisibility(View.VISIBLE);
                }

            }
        });

    }

    private class Tarefa extends AsyncTask<String, String, String> {


        @Override
        protected String doInBackground(String... strings) {
            String retorno = Conexao.getDados(strings[0]);
            return retorno;
        }

        @Override
        protected void onPostExecute(String s) {
            AlertDialog.Builder builder1 = new AlertDialog.Builder(ConcluindoPedido.this);
            builder1.setTitle("DADOS ENDEREÇO:");
            builder1.setMessage(s);
            builder1.show();
        }

    }
}