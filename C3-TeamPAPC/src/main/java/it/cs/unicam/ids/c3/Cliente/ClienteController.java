package it.cs.unicam.ids.c3.Cliente;


import it.cs.unicam.ids.c3.Negozio.NegozioInterface;
import it.cs.unicam.ids.c3.Ordine.ConcreteOrdineCreator;
import it.cs.unicam.ids.c3.Ordine.OrdineController;
import it.cs.unicam.ids.c3.ProdottoInterface;
import it.cs.unicam.ids.c3.PuntoRitiro;

public class ClienteController {
    OrdineController controller;
    ConcreteOrdineCreator concreteOrdineCreator;

    public void addProdotto(ProdottoInterface p){
        concreteOrdineCreator.getProdotti().add(p);
    }
    public void setEmittente(NegozioInterface emittente){
        concreteOrdineCreator.setEmittente(emittente);
    }
    public void setDestinazione(PuntoRitiro destinazione){
        concreteOrdineCreator.setDestinazione(destinazione);
    }
    public void creaOrdine(){
    concreteOrdineCreator.createOrdine();
    }

}
