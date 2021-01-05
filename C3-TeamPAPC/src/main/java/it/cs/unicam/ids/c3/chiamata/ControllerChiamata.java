package it.cs.unicam.ids.c3.chiamata;

import java.util.List;

public class ControllerChiamata{
     List<Chiamata> chiamataList;

    public void aggiungiChiamata(Chiamata chiamata){
        this.chiamataList.add(chiamata);
    }

    public String visualizzaChiamate(){
        return chiamataList.toString();
    }

    public void scegliChiamata(long id){
        Chiamata cDaEliminare = getChiamatabyID(id);
        chiamataList.remove(cDaEliminare);
    }

    public Chiamata getChiamatabyID(long id){
        return chiamataList.stream().filter(chiamata -> chiamata.getId()==id).findFirst().orElseThrow(NullPointerException::new);

    }
}
