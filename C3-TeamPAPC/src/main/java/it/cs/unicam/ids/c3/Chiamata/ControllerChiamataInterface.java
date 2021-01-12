package it.cs.unicam.ids.c3.Chiamata;

import it.cs.unicam.ids.c3.Ordine.Ordine;

public interface ControllerChiamataInterface {

    Ordine getOrdineAssociato();
    void setOrdineAssociato(Ordine ordineAssociato);
    long getId();
}
