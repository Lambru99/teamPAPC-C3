package it.cs.unicam.ids.c3.Commerciante;

import it.cs.unicam.ids.c3.Ordine.OrdineInSospesoController;

public class CommercianteController {
    public OrdineInSospesoController oController;

    public String stampaOrdini(){
        return oController.printOrdini();
    }
    public void scegliOrdini(long id){
        oController.preparaChiamata(id);
    }
}
