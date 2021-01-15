package it.cs.unicam.ids.c3.Ordine;


import it.cs.unicam.ids.c3.Negozio.NegozioInterface;


import it.cs.unicam.ids.c3.Prodotto.Prodotto;
import it.cs.unicam.ids.c3.Prodotto.ProdottoInterface;
import it.cs.unicam.ids.c3.Ritiro.PuntoRitiro;
import it.cs.unicam.ids.c3.entity.OrdineEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

@Service
public class ConcreteCreatoreOrdine implements CreatoreOrdine{
    private NegozioInterface emittente;
    private PuntoRitiro destinazione;
    private List<ProdottoInterface> prodotti;

    public ConcreteCreatoreOrdine() {
        this.emittente = null;
        this.destinazione = null;
        this.prodotti = new ArrayList<>();
    }
    @Override
    public NegozioInterface getEmittente() {
        return this.emittente;
    }
    @Override
    public void setEmittente(NegozioInterface emittente) {
        this.emittente = emittente;
    }
    @Override
    public void addProdotto(ProdottoInterface prodotto) {
        this.prodotti.add(prodotto);
    }

    @Override
    public void addProdotto(ProdottoInterface prodotto, int numero){
        Predicate<ProdottoInterface> predicate = prodottoEntity -> prodottoEntity.getSerialCode()==prodotto.getSerialCode();
        if (this.prodotti.stream().anyMatch(predicate)){
            ProdottoInterface prodottoIn = this.prodotti.stream().filter(predicate).findFirst().orElseThrow(NullPointerException::new);
            prodottoIn.setNumero(prodottoIn.getNumero()+numero);
            this.prodotti.add(prodottoIn);
        } else{
            prodotto.setNumero(numero);
            this.prodotti.add(prodotto);
        }
    }

    @Override
    public PuntoRitiro getDestinazione(){
        return this.destinazione;
    }
    @Override
    public void setDestinazione(PuntoRitiro destinazione) {
        this.destinazione = destinazione;
    }

    @Override
    public List<ProdottoInterface> getProdotti(){
        return this.prodotti;
    }

    @Override
    public ProdottoInterface getProdottoBySerialCode(long code) {
        return this.prodotti.stream().filter(prodottoEntity -> prodottoEntity.getSerialCode()==code)
                .findAny().orElseThrow(NullPointerException::new);
    }

    @Override
    public OrdineInterface creaOrdine() {
        OrdineInterface o = new OrdineEntity();
        if(this.destinazione!=null){
            o.setEmittente(this.emittente);
            o.setDestinazione(this.destinazione);
        }
        else {
            o.setEmittente(this.emittente);
        }
        if(!this.prodotti.isEmpty()) {
            o.setProdotti(this.prodotti);
            o.calcoloSoldi();
        }
        this.clear();
        return o;
    }

    private void clear() {
        setEmittente(null);
        setDestinazione(null);
        this.prodotti.clear();
    }

}