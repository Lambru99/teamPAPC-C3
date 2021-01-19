package it.cs.unicam.ids.c3.Chiamata;


import it.cs.unicam.ids.c3.repository.ChiamataRep;

import java.util.List;

public class ControllerChiamata{
    private ChiamataRep lista;
    public void aggiungiChiamata(Chiamata chiamata){
        lista.getListaChiamate().add(chiamata);
    }

    public List<ControllerChiamataInterface> visualizzaChiamate(){
        return lista.getListaChiamate();
    }

    public void scegliChiamata(long id){
        ControllerChiamataInterface cDaEliminare = getChiamatabyID(id);
        lista.getListaChiamate().remove(cDaEliminare);
    }

    public ControllerChiamataInterface getChiamatabyID(long id){
        return lista.getListaChiamate().stream().filter(chiamata -> chiamata.getId()==id).findFirst().orElseThrow(NullPointerException::new);

    }
}
