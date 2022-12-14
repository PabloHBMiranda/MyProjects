package com.pablohbm.trabalhofinal_20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class PedidosFeitos extends AppCompatActivity {


    public void excluir(int i){
        //Toast.makeText(this, "AAAA", Toast.LENGTH_SHORT).show();
        try{
            bancoDados = openOrCreateDatabase("AppPokemonQD", MODE_PRIVATE, null);
            String sql = "DELETE FROM pedido WHERE id =?";
            SQLiteStatement stmt = bancoDados.compileStatement(sql);
            stmt.bindLong(1,arrayIds.get(i));
            stmt.executeUpdateDelete();
            Toast.makeText(this, "Pedido Deletado", Toast.LENGTH_SHORT).show();
            listarDados();
            bancoDados.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    SQLiteDatabase bancoDados;
    public void listarDados(){
        try{
            arrayIds = new ArrayList<>();
            bancoDados = openOrCreateDatabase("AppPokemonQD", MODE_PRIVATE, null);
            Cursor meuCursor = bancoDados.rawQuery("SELECT * FROM pedido", null);
            ArrayList<String> linhas = new ArrayList<String>();
            ArrayAdapter meuAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, android.R.id.text1, linhas);
            listaDePedidos.setAdapter(meuAdapter);
            meuCursor.moveToFirst();
            while (meuCursor!=null){
                linhas.add(meuCursor.getString(1));
                arrayIds.add(meuCursor.getInt(0));
                meuCursor.moveToNext();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    ListView listaDePedidos;
    Button btnPedidoFeitosVoltar;
    public ArrayList<Integer> arrayIds;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedidos_feitos);
        listaDePedidos = findViewById(R.id.listaDePedidos);
        btnPedidoFeitosVoltar = findViewById(R.id.btnPedidoFeitosVoltar);

        listarDados();

        btnPedidoFeitosVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PedidosFeitos.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        listaDePedidos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                excluir(i);
                return true;
            }
        });


    }
}