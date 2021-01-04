package it.cs.unicam.ids.c3;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ordine implements OrdineInterface{
    private final long id;
    private final long numeroRitiro;
    private PuntoRitiro destinazione;
    private NegozioInterface emittente;
    private List<ProdottoInterface> prodotti;
    private String stato;

    public Ordine(){
        this.id = new Random().nextInt(999999);
        this.numeroRitiro = new Random().nextInt(9999);
        this.prodotti = new ArrayList<>();
    }

    public Ordine(PuntoRitiro destinazione, NegozioInterface emittente) {
        this();
        this.destinazione = destinazione;
        this.emittente = emittente;
    }

    @Override
    public List<ProdottoInterface> getProdotti() {
        return this.prodotti;
    }

    @Override
    public long getNumero() {
        return this.numeroRitiro;
    }

    @Override
    public NegozioInterface getEmittente() {
        return this.emittente;
    }

    @Override
    public PuntoRitiro getPuntoRitiro() {
        return this.destinazione;
    }

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public void setEmittente(NegozioInterface emittente) {
        this.emittente = emittente;
    }

    @Override
    public void setDestinazione(PuntoRitiro destinazione) {
        this.destinazione = destinazione;
    }
}
