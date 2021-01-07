package it.cs.unicam.ids.c3.chiamata;


import it.cs.unicam.ids.c3.Ordine.Ordine;

import java.util.Random;

public class Chiamata implements ControllerChiamataInterface{
    private final long id;
    private String stato;
    private Ordine ordineAssociato;

    public Chiamata (){
        this.id= new Random().nextInt(999999);
    }

    public Chiamata(Ordine ordine) {
        this();
        setOrdineAssociato(ordine);
        this.stato="in sospeso";
    }

    public Ordine getOrdineAssociato() {
        return ordineAssociato;
    }

    public void setOrdineAssociato(Ordine ordineAssociato) {
        this.ordineAssociato = ordineAssociato;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public long getId() {
        return id;
    }

}
