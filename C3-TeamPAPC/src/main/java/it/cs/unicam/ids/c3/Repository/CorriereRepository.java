package it.cs.unicam.ids.c3.Repository;

import it.cs.unicam.ids.c3.Corriere.CorriereInterface;

import java.util.ArrayList;
import java.util.List;

public class CorriereRepository {
    private List<CorriereInterface>corrieri;

    public CorriereRepository(){
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


