package it.cs.unicam.ids.c3.Ordine;

import it.cs.unicam.ids.c3.Chiamata.Chiamata;
import it.cs.unicam.ids.c3.Chiamata.ControllerChiamata;

import java.util.List;

public class OrdineController {
    private List<Ordine> listaOrdine;

    public String printOrdini(){
        return listaOrdine.toString();
    }

    public void preparaChiamata(long id){
        Chiamata chiamata = new Chiamata(getOrdineByID(id));
        ControllerChiamata cChiamata = new ControllerChiamata();
        cChiamata.aggiungiChiamata(chiamata);
        listaOrdine.remove(getOrdineByID(id));
    }

    public Ordine getOrdineByID(long id){
    return listaOrdine.stream().filter(ordine -> ordine.getId()==id).findFirst().orElseThrow(NullPointerException::new);
    }

}
