package it.cs.unicam.ids.c3.repository;

import it.cs.unicam.ids.c3.CorrierePack.CorriereInterface;

import java.util.ArrayList;
import java.util.List;

public class CorriereRep {
    private List<CorriereInterface>corrieri;

    public CorriereRep(){
        this.corrieri= new ArrayList<>();
    }
    public void addCorriere(CorriereInterface corriere){
        this.corrieri.add(corriere);
    }
    public void delCorriere(CorriereInterface corriere)throws IllegalArgumentException{
        if(this.corrieri.contains(corriere)){
            this.corrieri.remove(corriere);
        }else {
            throw new IllegalArgumentException("Corriere non trovato");
        }
    }
    public List<CorriereInterface> getCorrieri(){
        return this.corrieri;
    }

}


