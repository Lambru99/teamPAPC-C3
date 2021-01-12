package it.cs.unicam.ids.c3.Ordine;

import it.cs.unicam.ids.c3.Negozio.NegozioInterface;
import it.cs.unicam.ids.c3.Prodotto.ProdottoInterface;
import it.cs.unicam.ids.c3.Ritiro.PuntoRitiro;

import java.util.List;

public interface OrdineInterface {
    public List<ProdottoInterface> getProdotti();
    public NegozioInterface getEmittente();
    public PuntoRitiro getPuntoRitiro();
    public long getNumero();
    public long getId();
    public void setEmittente(NegozioInterface emittente);
    public void setDestinazione(PuntoRitiro destinazione);
    public String getStato();
    public void setStato(String stato);
}
