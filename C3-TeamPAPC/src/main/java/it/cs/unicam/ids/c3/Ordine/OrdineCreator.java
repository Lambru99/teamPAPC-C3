package it.cs.unicam.ids.c3.Ordine;


import it.cs.unicam.ids.c3.Negozio.NegozioInterface;
import it.cs.unicam.ids.c3.Prodotto.ProdottoInterface;
import it.cs.unicam.ids.c3.Ritiro.PuntoRitiro;

import java.util.List;

public interface OrdineCreator {
    void setEmittente(NegozioInterface emittente);
    void setDestinazione(PuntoRitiro destinazione);
    List<ProdottoInterface> getProdotti();
    OrdineInterface createOrdine();
}
