package it.cs.unicam.ids.c3.Commerciante;


import it.cs.unicam.ids.c3.Ordine.OrdineController;
import it.cs.unicam.ids.c3.Ordine.OrdineInterface;
import it.cs.unicam.ids.c3.Prodotto.ProdottoInterface;

public class CommercianteController {
    public OrdineController oController;

    public String stampaOrdini(){
        return oController.printOrdini();
    }
    public void scegliOrdini(long id){
        oController.preparaChiamata(id);
    }
    public void consegnaOrdine(OrdineInterface ordine){ordine.setStato("Pronto per il ritiro");}
    public void addProdotti(CommercianteInterface commerciante, ProdottoInterface prodotto){
        commerciante.getProdotti().add(prodotto);
    }
    public void delProdotti(CommercianteInterface commerciante, ProdottoInterface prodotto)throws IllegalArgumentException{
        if(commerciante.getProdotti().contains(prodotto)){
            commerciante.getProdotti().remove(prodotto);
        }else throw new IllegalArgumentException("Prodotto non presente");
    }

}
