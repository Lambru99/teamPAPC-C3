package it.cs.unicam.ids.c3;


public class Ordine {
    private long numero;
    private String destinazione;
    private String emittente;

    public long getNumero() {
        return this.numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public String getDestinazione() {
        return this.destinazione;
    }

    public void setDestinazione(String destinazione) {
        this.destinazione = destinazione;
    }

    public String getEmittente() {
        return this.emittente;
    }

    public void setEmittente(String emittente) {
        this.emittente = emittente;
    }
    
}
