package it.cs.unicam.ids.c3.Ordine;

import it.cs.unicam.ids.c3.Negozio.NegozioInterface;
import it.cs.unicam.ids.c3.Prodotto.ProdottoInterface;
import it.cs.unicam.ids.c3.Ritiro.PuntoRitiro;
import it.cs.unicam.ids.c3.entity.StatoOrdine;

import java.util.List;

public interface OrdineInterface {
    List<ProdottoInterface> getProdotti();
    void calcoloSoldi();
    long getNumeroOrdine();

    void setNumeroOrdine(long numeroOrdine);

    PuntoRitiro getDestinazione();

    NegozioInterface getEmittente();

    StatoOrdine getStatoOrdine();

    void setSoldi(double soldi);

    void setStatoOrdine(StatoOrdine statoOrdine);

    public long getId();
    public void setEmittente(NegozioInterface emittente);
    public void setDestinazione(PuntoRitiro destinazione);
    public String getStato();
    public void setStato(String stato);
}
