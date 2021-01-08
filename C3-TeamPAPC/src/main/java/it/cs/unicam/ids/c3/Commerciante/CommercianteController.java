package it.cs.unicam.ids.c3.Commerciante;

import it.cs.unicam.ids.c3.Ordine.Ordine;
import it.cs.unicam.ids.c3.Ordine.OrdineController;

public class CommercianteController {
    public OrdineController oController;

    public String stampaOrdini(){
        return oController.printOrdini();
    }
    public void scegliOrdini(long id){
        oController.preparaChiamata(id);
    }
    public void consegnaOrdine(Ordine ordine){ordine.setStato("Pronto per il ritiro");}

}
