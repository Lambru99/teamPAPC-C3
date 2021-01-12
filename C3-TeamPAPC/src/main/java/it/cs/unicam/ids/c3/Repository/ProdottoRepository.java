package it.cs.unicam.ids.c3.Repository;

import it.cs.unicam.ids.c3.Prodotto.ProdottoInterface;

import java.util.ArrayList;
import java.util.List;

public class ProdottoRepository {
    private List<ProdottoInterface> prodotti;

    public ProdottoRepository (){
        this.prodotti=new ArrayList<>();
    }
    public void addProdotto(ProdottoInterface prodotto){
        this.prodotti.add(prodotto);
    }
    public void dellProdotto(ProdottoInterface prodotto)throws IllegalArgumentException{
        if(this.prodotti.contains(prodotto)){
            this.prodotti.remove(prodotto);
        }else {
            throw new IllegalArgumentException("Prodotto non trovato");
        }
    }
    public List<ProdottoInterface>getProdotti(){
        return this.prodotti;
    }
}
