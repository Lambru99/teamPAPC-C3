package it.cs.unicam.ids.c3.Repository;

import it.cs.unicam.ids.c3.Chiamata.ControllerChiamataInterface;

import java.util.ArrayList;
import java.util.List;

public class ChiamataRepository {
    private List<ControllerChiamataInterface> listaChiamate;

    public ChiamataRepository() {
        this.listaChiamate=new ArrayList<>();
    }

    public List<ControllerChiamataInterface> getListaChiamate() {
        return listaChiamate;
    }

}
