package com.example.truco;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    private Jogador j1, j2;
    private Baralho baralho  = new Baralho();

    public void definirNomes(View view){
        mostrarNomes();
    }
    public void sortear(View view){
        sortearCartas();
        mostrarSorteadas();
        jogo();
    }
    private void mudarBotaoStart(){
        Button start = findViewById(R.id.bt_iniciar);
        start.setText("Reiniciar");
    }
    private void mostrarNomes(){
        TextView j1 = findViewById(R.id.tv_nomeJ1);
        TextView j2 = findViewById(R.id.tv_nomeJ2);
        EditText ET_J1 = findViewById(R.id.et_nomeJ1);
        EditText ET_J2 = findViewById(R.id.et_nomeJ2);
        String nomeJ1 = ET_J1.getText().toString();
        String nomeJ2 = ET_J2.getText().toString();
        j1.setText(nomeJ1);
        j2.setText(nomeJ2);
        this.j1 = new Jogador(nomeJ1);
        this.j2 = new Jogador(nomeJ2);
    }
    private void sortearCartas(){
        this.baralho.shuffle();
        j1.resetar();
        j1.addCarta((Carta) this.baralho.getCarta(1));
        j1.addCarta(this.baralho.getCarta(3));
        j1.addCarta(this.baralho.getCarta(5));

        j2.resetar();
        j2.addCarta(this.baralho.getCarta(2));
        j2.addCarta(this.baralho.getCarta(4));
        j2.addCarta(this.baralho.getCarta(6));
    }
    private void mostrarSorteadas(){
        /*
        TextView cartas = findViewById(R.id.tv_mostraCartas);
        Carta c1, c2, c3, c4, c5, c6;
        c1 = j1.getCarta(0);
        c2 = j1.getCarta(1);
        c3 = j1.getCarta(2);

        c4 = j2.getCarta(0);
        c5 = j2.getCarta(1);
        c6 = j2.getCarta(2);
        cartas.setText("\nCartas J1:\n "+c1.getId()+"\n "+c2.getId()+"\n "+c3.getId()+"\nJ2:\n "+c4.getId()+"\n "+c5.getId()+"\n "+c6.getId()+"\n ");
        */
        Carta temp;
        int id;
        ImageView c1j1 = findViewById(R.id.iv_c1j1);
        temp = j1.getCarta(0);
        id = this.getResources().getIdentifier(temp.getId(), "drawable", getPackageName());
        c1j1.setImageResource(id);
        ImageView c2j1 = findViewById(R.id.iv_c2j1);
        temp = j1.getCarta(1);
        id = this.getResources().getIdentifier(temp.getId(), "drawable", getPackageName());
        c2j1.setImageResource(id);
        ImageView c3j1 = findViewById(R.id.iv_c3j1);
        temp = j1.getCarta(2);
        id = this.getResources().getIdentifier(temp.getId(), "drawable", getPackageName());
        c3j1.setImageResource(id);

        ImageView c1j2 = findViewById(R.id.iv_c1j2);
        temp = j2.getCarta(0);
        id = this.getResources().getIdentifier(temp.getId(), "drawable", getPackageName());
        c1j2.setImageResource(id);
        ImageView c2j2 = findViewById(R.id.iv_c2j2);
        temp = j2.getCarta(1);
        id = this.getResources().getIdentifier(temp.getId(), "drawable", getPackageName());
        c2j2.setImageResource(id);
        ImageView c3j2 = findViewById(R.id.iv_c3j2);
        temp = j2.getCarta(2);
        id = this.getResources().getIdentifier(temp.getId(), "drawable", getPackageName());
        c3j2.setImageResource(id);
    }
    private void jogo(){
        int vencedor = vencedor();
        String tp1, tp2;
        TextView infoVencedor = findViewById(R.id.tv_mostraCartas);
        if(j1.isFlor() == true){
            tp1 = "flor";
        }else{
            tp1 = "invido";
        }
        if(j2.isFlor() == true){
            tp2 = "flor";
        }else{
            tp2 = "invido";
        }
        if(vencedor == 1){
            infoVencedor.setText(j1.getNome()+" ganhou com "+tp1+" e "+j1.getPontos()+" pontos.\n"+j2.getNome()+" perdeu com "+tp2+" e "+j2.getPontos()+" pontos.\n");
        }else if(vencedor == 2){
            infoVencedor.setText(j2.getNome()+" ganhou com "+tp2+" e "+j2.getPontos()+" pontos.\n"+j1.getNome()+" perdeu com "+tp1+" e "+j1.getPontos()+" pontos.\n");
        }else{
            infoVencedor.setText(j1.getNome()+" empardou com "+j2.getNome()+" com "+tp1+" e "+j1.getPontos()+" pontos.\n");
        }
    }
    private int vencedor(){
        int p1, p2, vencedor;
        vencedor = 0;
        p1 = j1.calcularPontos();
        p2 = j2.calcularPontos();
        if(j1.isFlor() == true){
            if(j2.isFlor() == true){
                if(p1 > p2){
                    vencedor = 1;
                }else if(p2 > p1){
                    vencedor = 2;
                }else{
                    vencedor = 3;
                }
            }else{
                vencedor = 1;
            }
        }else if(j2.isFlor() == true){
            if(j1.isFlor() == true){
                if(p2 > p1){
                    vencedor = 2;
                }else if(p1 > p2){
                    vencedor = 1;
                }else{
                    vencedor = 3;
                }
            }else{
                vencedor = 2;
            }
        }else{
            if(p1 > p2){
                vencedor = 1;
            }else if(p2 > p1){
                vencedor = 2;
            }else{
                vencedor = 3;
            }
        }
        return vencedor;
    }
}
