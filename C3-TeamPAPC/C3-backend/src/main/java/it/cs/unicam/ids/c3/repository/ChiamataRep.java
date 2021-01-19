package it.cs.unicam.ids.c3.repository;

import it.cs.unicam.ids.c3.Chiamata.ControllerChiamataInterface;

import java.util.ArrayList;
import java.util.List;

public class ChiamataRep {
    private List<ControllerChiamataInterface> listaChiamate;
    private static ChiamataRep instance;

    public static ChiamataRep getInstance(){
        if (instance==null){
            instance = new ChiamataRep();
        }return instance;
    }

    public ChiamataRep() {
        this.listaChiamate=new ArrayList<>();
    }

    public List<ControllerChiamataInterface> getListaChiamate() {
        return listaChiamate;
    }

}
