package it.cs.unicam.ids.c3.chiamata;

import java.util.List;

public class ControllerChiamata{
     List<Chiamata> chiamataList;

    public void aggiungiChiamata(Chiamata chiamata){
        this.chiamataList.add((int)chiamata.getId(),chiamata);
    }
    public String visualizzaChiamate(){
        return chiamataList.toString();
    }
    public void scegliChiamata(int id){
        chiamataList.get(id).setStato("Sta per partire");
    }
}
