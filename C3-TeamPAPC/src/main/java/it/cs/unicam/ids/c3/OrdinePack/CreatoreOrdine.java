package it.cs.unicam.ids.c3.OrdinePack;


import it.cs.unicam.ids.c3.NegozioPack.NegozioInterface;
import it.cs.unicam.ids.c3.ProdottoPack.ProdottoInterface;
import it.cs.unicam.ids.c3.RitiroPack.PuntoRitiro;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CreatoreOrdine {
    void setEmittente(NegozioInterface emittente);
    void addProdotto(ProdottoInterface prodotto);

    void addProdotto(ProdottoInterface prodotto, int numero);

    PuntoRitiro getDestinazione();

    void setDestinazione(PuntoRitiro destinazione);

    List<ProdottoInterface> getProdotti();
    ProdottoInterface getProdottoBySerialCode(long code);
    OrdineInterface creaOrdine();
    NegozioInterface getEmittente();

}