package it.cs.unicam.ids.c3.Repository;

import it.cs.unicam.ids.c3.Negozio.NegozioInterface;

import java.util.ArrayList;
import java.util.List;

public class NegozioRepository {
    List<NegozioInterface> negozi;

    public NegozioRepository(){
        this.negozi=new ArrayList<>();
    }
    public void addNegozio(NegozioInterface negozio){
        this.negozi.add(negozio);
    }
    public void delNegozio(NegozioInterface negozio)throws IllegalArgumentException{
        if(this.negozi.contains(negozio)){
            this.negozi.remove(negozio);
        }else {
            throw new IllegalArgumentException("Negozio non trovato");
        }
    }
    public List<NegozioInterface> getNegozi(){
        return this.negozi;
    }
}
