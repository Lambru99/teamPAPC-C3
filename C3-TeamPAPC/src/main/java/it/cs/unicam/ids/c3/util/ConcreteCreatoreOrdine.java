package it.cs.unicam.ids.c3.util;

import it.cs.unicam.ids.c3.entity.LockerEntity;
import it.cs.unicam.ids.c3.entity.NegozioEntity;
import it.cs.unicam.ids.c3.entity.OrdineEntity;
import it.cs.unicam.ids.c3.entity.ProdottoEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * classe che crea un ordine secondo alcuni parametri
 * Questa classe si occupa di creare effettivamente l'ordine solo quando è stato confermato dal cliente
 */
public class ConcreteCreatoreOrdine implements CreatoreOrdine{
    private NegozioEntity emittente;
    private LockerEntity destinazione;
    private List<ProdottoEntity> prodotti;

    public ConcreteCreatoreOrdine() {
        this.emittente = null;
        this.destinazione = null;
        this.prodotti = new ArrayList<>();
    }
    @Override
    public NegozioEntity getEmittente() {
        return this.emittente;
    }
    @Override
    public void setEmittente(NegozioEntity emittente) {
        this.emittente = emittente;
    }

    /**
     * aggiunge un prodotto alla lista del creatore:
     * se l'emittenete contiene questo prodotto aggiunge il prodotto con una quantità
     * se questo prodotto era già stato aggiunto allora aumenta il numero
     * altrimenti lo aggunge con il numero richiesto
     * se il prodotto aggiunta ha un numero maggiore del numero del prodotto corrispondente al negozio,
     * lancia un'eccezione.
     * @param prodotto da aggiungere al creatore
     * @param numero da aggiungere
     */
    @Override
    public void addProdotto(ProdottoEntity prodotto, int numero){
        if(numero==0)numero =1;
        Predicate<ProdottoEntity> predicate = prodottoEntity -> prodottoEntity.getSerialCode()==prodotto.getSerialCode();
        ProdottoEntity prodottoNegozio = getEmittente().getProdotti().stream().filter(predicate)
                .findFirst().orElseThrow(NullPointerException::new);
        if (this.prodotti.stream().anyMatch(predicate)){
            ProdottoEntity prodottoIn = this.prodotti.stream().filter(predicate).findFirst().orElseThrow(NullPointerException::new);
            prodottoIn.setNumero(prodottoIn.getNumero()+numero);
            if (prodottoIn.getNumero()>prodottoNegozio.getNumero())
                throw new IllegalArgumentException("numero superiore da quello disponibile");
            //this.prodotti.add(prodottoIn);
        } else{
            prodotto.setNumero(numero);
            if (prodotto.getNumero()>prodottoNegozio.getNumero())
                throw new IllegalArgumentException("numero superiore da quello disponibile");
            this.prodotti.add(prodotto);
        }
    }



    @Override
    public LockerEntity getDestinazione(){
        return this.destinazione;
    }
    @Override
    public void setDestinazione(LockerEntity destinazione) {
        this.destinazione = destinazione;
    }

    @Override
    public List<ProdottoEntity> getProdotti(){
        return this.prodotti;
    }

    @Override
    public ProdottoEntity getProdottoBySerialCode(long code) {
        return this.prodotti.stream().filter(prodottoEntity -> prodottoEntity.getSerialCode()==code)
                .findAny().orElseThrow(NullPointerException::new);
    }

    /**
     * Se la destinazione è settata a null allora il ritiro è al negozio
     * altrimenti è sul locker corrispondente
     * @return un ordine con i parametri passati dal creatore
     */
    @Override
    public OrdineEntity creaOrdine() {
        OrdineEntity o = new OrdineEntity();
        if(this.destinazione!=null){
            o.setEmittente(this.emittente);
            o.setDestinazione(this.destinazione);
        }
        else {
            o.setEmittente(this.emittente);
        }
        //gestisciProdottoEmittente();
        if(!this.prodotti.isEmpty()) {
            o.setProdotti(this.prodotti);
            o.calcoloSoldi();
        }
        return o;
    }

    /**
     * gestisce i prodotti all'interno del creatore e modifica le quantità dei prodotti all'interno dell'emittente
     */
    private void gestisciProdottoEmittente(){
        for (ProdottoEntity prodottoOrdine: getProdotti()) {
            getEmittente().getProdotti().stream().filter(p-> p.getSerialCode()==prodottoOrdine.getSerialCode())
                    .forEach(p -> p.setNumero(p.getNumero()-prodottoOrdine.getNumero()));
        }
    }

}
