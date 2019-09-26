package com.example.truco;

import java.util.*;

public class Jogador {
    private String nome;
    private ArrayList mao;
    private boolean flor;
    private int pontos;

    public Jogador(String nome) {
        this.nome = nome;
        mao = new ArrayList();
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void addCarta(Carta nova){
        mao.add(nova);
    }
    public Carta getCarta(int pos){
        Carta selecionada = (Carta) mao.get(pos);
        return (Carta) selecionada;
    }
    public void resetar(){
        mao = new ArrayList();
    }
    public int calcularPontos() {
        Carta temp1, temp2, temp3;
        int pontos=0;
        this.pontos=0;
        this.flor=false;

        temp1 = (Carta) mao.get(0);
        temp2 = (Carta) mao.get(1);
        temp3 = (Carta) mao.get(2);
            //As 3 do mesmo naipe
        if(temp1.getNaipe().equals(temp2.getNaipe()) && temp2.getNaipe().equals(temp3.getNaipe())) {
            this.flor = true;
            pontos+= 20;
            if (temp1.getNumero() < 10){
                pontos += temp1.getNumero();
            }
            if(temp2.getNumero() < 10){
                pontos += temp2.getNumero();
            }
            if(temp3.getNumero() < 10){
                pontos += temp3.getNumero();
            }
            //Carta 1 e 2 mesmo naipe
        }else if(temp1.getNaipe().equals(temp2.getNaipe())){
            this.flor = false;
            pontos+= 20;
            if (temp1.getNumero() < 10){
                pontos += temp1.getNumero();
            }
            if(temp2.getNumero() < 10){
                pontos += temp2.getNumero();
            }
            //Carta 2 e 3 mesmo naipe
        }else if(temp2.getNaipe().equals(temp3.getNaipe())){
            this.flor = false;
            pontos+= 20;
            if(temp2.getNumero() < 10){
                pontos += temp2.getNumero();
            }
            if(temp3.getNumero() < 10){
                pontos += temp3.getNumero();
            }
            //Carta 3 e 1 mesmo naipe
        }else if(temp3.getNaipe().equals(temp1.getNaipe())){
            this.flor = false;
            pontos+= 20;
            if (temp1.getNumero() < 10){
                pontos += temp1.getNumero();
            }
            if(temp3.getNumero() < 10){
                pontos += temp3.getNumero();
            }
        }else{
            this.flor = false;
            pontos = temp1.getNumero();
            if(pontos > 10){
                pontos = 0;
            }
            if(pontos < temp2.getNumero() && temp2.getNumero() < 10){
                pontos = temp2.getNumero();
            }
            if(pontos < temp3.getNumero() && temp3.getNumero() < 10){
                pontos = temp3.getNumero();
            }
        }
        this.pontos = pontos;
        return pontos;
    }

    public boolean isFlor() {
        return flor;
    }

    public int getPontos() {
        return pontos;
    }

    public String getNome() {
        return nome;
    }
}
