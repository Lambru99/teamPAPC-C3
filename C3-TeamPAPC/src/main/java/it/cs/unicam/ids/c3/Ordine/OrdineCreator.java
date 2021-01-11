package it.cs.unicam.ids.c3.Ordine;

import it.cs.unicam.ids.c3.Negozio.NegozioInterface;
import it.cs.unicam.ids.c3.ProdottoInterface;
import it.cs.unicam.ids.c3.PuntoRitiro;

import java.util.List;

public interface OrdineCreator {
    void setEmittente(NegozioInterface emittente);
    void setDestinazione(PuntoRitiro destinazione);
    List<ProdottoInterface> getProdotti();
    void createOrdine();
}
