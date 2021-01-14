package it.cs.unicam.ids.c3.Cliente;


import it.cs.unicam.ids.c3.Negozio.NegozioInterface;
import it.cs.unicam.ids.c3.Ordine.ConcreteOrdineCreator;
import it.cs.unicam.ids.c3.Ordine.Ordine;
import it.cs.unicam.ids.c3.Ordine.OrdineInterface;
import it.cs.unicam.ids.c3.Prodotto.Prodotto;
import it.cs.unicam.ids.c3.Ritiro.PuntoRitiro;

import java.util.List;

public class ClienteController {
    ConcreteOrdineCreator concreteOrdineCreator;

    public void addProdotto(Prodotto p, long n){
        concreteOrdineCreator.addProdotto(p,n);
    }
    public void setEmittente(NegozioInterface emittente){
        concreteOrdineCreator.setEmittente(emittente);
    }
    public void setDestinazione(PuntoRitiro destinazione){
        concreteOrdineCreator.setDestinazione(destinazione);
    }
    public void creaOrdine(ClienteInterface cliente){
    Ordine ordine = (Ordine) concreteOrdineCreator.createOrdine();
    cliente.getListaOrdine().add(ordine);
    }
    public List<OrdineInterface> viewProdotti(ClienteInterface cliente){
        return cliente.getListaOrdine();
    }
    public void ritiraProdotto(long id,ClienteInterface cliente){
        cliente.getListaOrdine().stream().filter(chiamata -> chiamata.getId()==id).findFirst().orElseThrow(NullPointerException::new).setStato("Ritirato");
    }
}
