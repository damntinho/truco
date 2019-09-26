package com.example.truco;

public class Carta {
    private String id;
    private String naipe;
    private int numero;
    private int forca = 0;

    public Carta(String id, String naipe, int numero, int forca) {
        this.id = id;
        this.naipe = naipe;
        this.numero = numero;
        this.forca = forca;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNaipe() {
        return naipe;
    }

    public void setNaipe(String naipe) {
        this.naipe = naipe;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
