package com.pablohbm.trabalhofinal_20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class FazerPedidos extends AppCompatActivity {

    Button voltarFazerPedido, comprarFazerPedido;
    ImageView imagemDoPedido;
    TextView descricaoObra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fazer_pedidos);
        voltarFazerPedido = findViewById(R.id.voltarFazerPedido);
        comprarFazerPedido = findViewById(R.id.comprarFazerPedido);
        descricaoObra = findViewById(R.id.descricaoObra);
        imagemDoPedido = findViewById(R.id.imagemDoPedido);

        Intent pegardados = getIntent();

        int opc = pegardados.getIntExtra("opc",0);

        if(opc == 1){
            imagemDoPedido.setImageResource(R.drawable.pikachux);
            descricaoObra.setText("Uma das mais conhecidas, “PikachuX”. A pintura é considerada uma representação completa e dinâmica de retratos da força do Pokemon mais famoso.\nDimensões: 82 × 114\nTécnica: Óleo sobre tela");
        }
        else{
            if(opc == 2){
                imagemDoPedido.setImageResource(R.drawable.ratataprincesa);
                descricaoObra.setText("“RatataPrincesa” é uma pintura que retrata a fraqueza desse Pokemon.\nDimensões: 82 × 114\nTécnica: Óleo sobre tela");
            }
            else{
                imagemDoPedido.setImageResource(R.drawable.bulbatree);
                descricaoObra.setText("“BulbaTree” trata-se de uma narrativa. A obra conta uma história através da imagem, capturando o instante no qual a vida Pokemon está prestes a mudar.\nDimensões: 82 × 114\nTécnica: Óleo sobre tela");
            }
        }

        voltarFazerPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FazerPedidos.this, Pedidos.class);
                startActivity(i);
                finish();
            }
        });

        comprarFazerPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FazerPedidos.this, ConcluindoPedido.class);
                startActivity(i);
                finish();
            }
        });
    }
}