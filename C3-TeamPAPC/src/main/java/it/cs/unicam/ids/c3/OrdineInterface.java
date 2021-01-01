package it.cs.unicam.ids.c3;

import java.util.List;

public interface OrdineInterface {
    public List<ProdottoInterface> getProdotti();
    public NegozioInterface getEmittente();
    public PuntoRitiro getPuntoRitiro();
    public long getNumero();
    public long getId();
    public void setEmittente(NegozioInterface emittente);
    public void setDestinazione(PuntoRitiro destinazione);
}
