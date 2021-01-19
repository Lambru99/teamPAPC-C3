package it.cs.unicam.ids.c3.repository;

import it.cs.unicam.ids.c3.CommerciantePack.CommercianteInterface;

import java.util.ArrayList;
import java.util.List;

public class CommercianteRep {

    private List<CommercianteInterface> commercianti;

    public CommercianteRep(){
        this.commercianti= new ArrayList<>();
    }
    public void addCommerciante(CommercianteInterface commerciante){
        this.commercianti.add(commerciante);
    }
    public void delCommerciante (CommercianteInterface commerciante)throws IllegalArgumentException{
        if(this.commercianti.contains(commerciante)){
            this.commercianti.remove(commerciante);
        }else {
            throw new IllegalArgumentException("Commeciante non trovato");
        }
    }
    public List<CommercianteInterface> getCommercianti()throws IllegalArgumentException{
        return this.commercianti;
    }
}
