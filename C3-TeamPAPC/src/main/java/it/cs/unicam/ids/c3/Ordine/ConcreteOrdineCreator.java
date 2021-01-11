package it.cs.unicam.ids.c3.Ordine;

import it.cs.unicam.ids.c3.Negozio.NegozioInterface;
import it.cs.unicam.ids.c3.Prodotto;
import it.cs.unicam.ids.c3.ProdottoInterface;
import it.cs.unicam.ids.c3.PuntoRitiro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConcreteOrdineCreator implements OrdineCreator{
    private NegozioInterface emittente;
    private PuntoRitiro destinazione;
    private List<ProdottoInterface> prodotti;

    public ConcreteOrdineCreator(){
        this.prodotti = new ArrayList<>();
        this.emittente = null;
        this.destinazione = null;
    }


    @Override
    public void setEmittente(NegozioInterface emittente) {
        this.emittente = emittente;
    }

    @Override
    public void setDestinazione(PuntoRitiro destinazione) {
        this.destinazione = destinazione;
    }

    @Override
    public List<ProdottoInterface> getProdotti() {
        return this.prodotti;
    }


    public NegozioInterface getEmittente() {
        return this.emittente;
    }


    public PuntoRitiro getDestinazione() {
        return this.destinazione;
    }

    @Override
    public void createOrdine() {
    if (getDestinazione()==null){
        newOrdine(getEmittente());
    }else{
        newOrdine(getDestinazione(),getEmittente());
    }
    }
    public OrdineInterface newOrdine(PuntoRitiro destinazione,NegozioInterface emittente){
        OrdineInterface ordine = new Ordine(destinazione,emittente);
        Collections.addAll(ordine.getProdotti(),getProdotti().toArray(ProdottoInterface[]::new));
        return ordine;
    }
    public OrdineInterface newOrdine(NegozioInterface emittente) {
        OrdineInterface ordine = new Ordine(emittente);
        Collections.addAll(ordine.getProdotti(),getProdotti().toArray(ProdottoInterface[]::new));
        return ordine;
    }
}
