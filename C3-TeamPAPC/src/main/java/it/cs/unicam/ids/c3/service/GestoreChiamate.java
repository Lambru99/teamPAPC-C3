package it.cs.unicam.ids.c3.service;

import it.cs.unicam.ids.c3.entity.ChiamataEntity;
import it.cs.unicam.ids.c3.entity.NegozioEntity;
import it.cs.unicam.ids.c3.entity.OrdineEntity;
import it.cs.unicam.ids.c3.entity.StatoOrdine;
import it.cs.unicam.ids.c3.repository.ChiamataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * servizio che si occupa di gestire le chiamate
 * questo servizio sarà utilizzato da altri servizi
 */

@Service
public class GestoreChiamate implements GestoreChiamateInterface {
    @Autowired
    private ChiamataRepository chiamataRepository;

    public GestoreChiamate() {
    }

    @Override
    public List<ChiamataEntity> getChiamate(){
        return this.chiamataRepository.findAll();
    }

    @Override
    public ChiamataEntity getChiamataById(long idChiamata){
        return this.chiamataRepository.findById(idChiamata)
                .orElseThrow(() -> new NullPointerException("chiamata con questo id inesistente"));
    }

    /**
     * permette di effettuare una chiamata da chi utilizza questo servizio
     * @param chiamata
     */
    @Override
    public void addChiamata(ChiamataEntity chiamata){
        this.chiamataRepository.save(chiamata);
    }

    /**
     * permette di creare una chiamata
     * @param negozioChiamante negozio a cui corrisponde l'ordine
     * @param ordineContenente ordine che è contenuto nella chiamata
     * @return chiamata creata
     */
    @Override
    public ChiamataEntity createChiamata(NegozioEntity negozioChiamante, OrdineEntity ordineContenente){
        if(ordineContenente.getStatoOrdine()== StatoOrdine.ESEGUITO) {
            ChiamataEntity chiamata = new ChiamataEntity();
            chiamata.setNegozio(negozioChiamante);
            chiamata.setOrdine(ordineContenente);
            return chiamata;
        }else throw new IllegalArgumentException("l'ordine non può essere spedito poiché ha uno stato differente da"
        +StatoOrdine.ESEGUITO.toString());
    }

    @Override
    public void deleteChiamataById(long id) {
        this.chiamataRepository.deleteById(id);
    }
}

