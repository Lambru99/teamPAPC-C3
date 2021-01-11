package it.cs.unicam.ids.c3.Cliente;


import it.cs.unicam.ids.c3.Negozio.NegozioInterface;
import it.cs.unicam.ids.c3.Ordine.OrdineController;
import it.cs.unicam.ids.c3.Prodotto;
import it.cs.unicam.ids.c3.PuntoRitiro;

public class ClienteController {
    OrdineController controller;
    private NegozioInterface emittente;
    private PuntoRitiro destinazione;

    public NegozioInterface getEmittente() {
        return emittente;
    }

    public void setEmittente(NegozioInterface emittente) {
        this.emittente = emittente;
    }

    public PuntoRitiro getDestinazione() {
        return destinazione;
    }

    public void setDestinazione(PuntoRitiro destinazione) {
        this.destinazione = destinazione;
    }

    public void aggiungiProdotto(Prodotto p){
        controller.addProdotto(p);
    }
    public void creaOrdine(){
        if(destinazione==null){
            controller.creaOrdine(emittente);
        }else {
            controller.creaOrdine(destinazione,emittente);
        }
    }

}
