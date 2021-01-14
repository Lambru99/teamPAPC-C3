package it.cs.unicam.ids.c3.Corriere;

import it.cs.unicam.ids.c3.Chiamata.ControllerChiamata;
import it.cs.unicam.ids.c3.Ordine.OrdineInterface;

public class ControllerCorriere {
    private ControllerChiamata cChiamata;

    public void visuallizzaListaChiamate(){cChiamata.visualizzaChiamate();}
    public void scegliChiamata(long index){cChiamata.scegliChiamata(index);}
    public void cambiaDisponibilita(CorriereInterface corriere){corriere.setDisposizione();}
    public void inizioTrasporto(OrdineInterface ordine){ordine.setStato("In transito");}
    public void consegnaOrdine(OrdineInterface ordine){ordine.setStato("Pronto per il ritiro");}
}
