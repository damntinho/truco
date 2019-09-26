package com.example.truco;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baralho {
    private ArrayList<Carta> baralho;

    public Baralho() {
        baralho = new ArrayList<Carta>();
        String nomeNaipe, nomeId;
        nomeNaipe=nomeId=" ";
        int poder, numero, naipe;
        poder = numero = naipe = 0;
        for(numero = 1; numero<=12; numero++){
            if(numero == 8 || numero ==9){
                continue;
            }
            for(naipe = 0; naipe<=3; naipe++){
                if(naipe == 0){
                    nomeNaipe = "Espadas";
                    nomeId = "e"+numero;
                    poder = numero;
                    if(numero == 1){
                        poder = 19;
                    }else if(poder == 7){
                        poder = 17;
                    }else if(poder == 3){
                        poder = 15;
                    }else if(poder == 2){
                        poder = 14;
                    }
                }
                if(naipe == 1){
                    nomeNaipe = "Bastos";
                    nomeId = "b"+numero;
                    poder = numero;
                    if(numero == 1){
                        poder = 18;
                    }else if(poder == 3){
                        poder = 15;
                    }else if(poder == 2){
                        poder = 14;
                    }
                }

                if(naipe == 2){
                    nomeNaipe = "Ouros";
                    nomeId = "o"+numero;
                    poder = numero;
                    if(numero == 7){
                        poder = 16;
                    }else if(numero == 1){
                        poder = 13;
                    }else if(poder == 3){
                        poder = 15;
                    }else if(poder == 2){
                        poder = 14;
                    }
                }

                if(naipe == 3){
                    nomeNaipe = "Copas";
                    nomeId = "c"+numero;
                    poder = numero;
                    if(numero == 1){
                        poder = 13;
                    }else if(poder == 3){
                        poder = 15;
                    }else if(poder == 2){
                        poder = 14;
                    }
                }
                Carta criar = new Carta(nomeId, nomeNaipe, numero, poder);
                this.baralho.add(criar);
            }
        }
    }

    public void addCarta(Carta nova){
        baralho.add(nova);
    }
    public int find(Carta carta, int func){
        String encontrar = carta.getId();
        Carta temp;
        for(int i=0; i<baralho.size(); i++){
            temp = (Carta) baralho.get(i);
            if(temp.getId() == encontrar){
                if(func == 0){
                    baralho.remove(i);
                    return 1;
                }
            }
        }
        return 0;
    }
    public void remove(Carta carta){
        int removeStatus = find(carta, 0);
    }
    public Carta getCarta(int pos){
        Carta selecionada = (Carta) baralho.get(pos);
        return selecionada;
    }
    public void shuffle(){
        Collections.shuffle((List <Carta>) baralho);
    }
}
