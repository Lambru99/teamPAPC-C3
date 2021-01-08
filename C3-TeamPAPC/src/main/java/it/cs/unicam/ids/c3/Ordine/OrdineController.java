package it.cs.unicam.ids.c3.Ordine;

import it.cs.unicam.ids.c3.Ordine.Ordine;
import it.cs.unicam.ids.c3.PuntoRitiro;
import it.cs.unicam.ids.c3.chiamata.Chiamata;
import it.cs.unicam.ids.c3.chiamata.ControllerChiamata;

import java.util.List;

public class OrdineController {
    private List<Ordine> listaOrdine;


    public void addOrdine(Ordine ordine){
        PuntoRitiro filtOrdine = ordine.getPuntoRitiro();
        if (filtOrdine != null){
        listaOrdine.add(ordine);
        }
    }

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
