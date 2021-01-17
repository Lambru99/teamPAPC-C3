package it.cs.unicam.ids.c3.OrdinePack;


import it.cs.unicam.ids.c3.ProdottoPack.ProdottoInterface;
import it.cs.unicam.ids.c3.RitiroPack.PuntoRitiro;
import it.cs.unicam.ids.c3.NegozioPack.NegozioInterface;
import it.cs.unicam.ids.c3.entity.StatoOrdine;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ordine implements OrdineInterface {
    private final long id;
    private final long numeroOrdine;
    private PuntoRitiro destinazione;
    private NegozioInterface emittente;
    private List<ProdottoInterface> prodotti;
    private String stato;

    public Ordine(){
        this.id = new Random().nextInt(999999);
        this.numeroOrdine = new Random().nextInt(9999);
        this.prodotti = new ArrayList<>();
    }

    public Ordine(NegozioInterface emittente){
        this();
        this.destinazione = null;
        this.emittente = emittente;
    }

    public Ordine(PuntoRitiro destinazione, NegozioInterface emittente) {
        this(emittente);
        this.destinazione = destinazione;
    }


    @Override
    public String getStato() {
        return stato;
    }

    @Override
    public void setStato(String stato) {
        this.stato = stato;
    }

    @Override
    public void setProdotti(List<ProdottoInterface> prodotti) {

    }

    @Override
    public List<ProdottoInterface> getProdotti() {
        return this.prodotti;
    }

    @Override
    public void calcoloSoldi() {

    }

    @Override
    public long getNumeroOrdine() {
        return this.numeroOrdine;
    }

    @Override
    public void setNumeroOrdine(long numeroOrdine) {

    }

    @Override
    public NegozioInterface getEmittente() {
        return this.emittente;
    }

    @Override
    public StatoOrdine getStatoOrdine() {
        return null;
    }

    @Override
    public void setSoldi(double soldi) {

    }

    @Override
    public void setStatoOrdine(StatoOrdine statoOrdine) {

    }

    @Override
    public PuntoRitiro getDestinazione() {
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
