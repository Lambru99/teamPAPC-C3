package it.cs.unicam.ids.c3.chiamata;

import it.cs.unicam.ids.c3.Ordine;

public interface ControllerChiamataInterface {
    String getStato();
    void setStato(String stato);
    Ordine getOrdineAssociato();
    void setOrdineAssociato(Ordine ordineAssociato);
    long getId();
}
