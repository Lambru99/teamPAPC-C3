package it.cs.unicam.ids.c3.service;

import it.cs.unicam.ids.c3.entity.ChiamataEntity;
import it.cs.unicam.ids.c3.entity.NegozioEntity;
import it.cs.unicam.ids.c3.entity.OrdineEntity;
import it.cs.unicam.ids.c3.repository.ChiamataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GestoreChiamate {
    @Autowired
    private ChiamataRepository chiamataRepository;

    public GestoreChiamate() {
    }

    public List<ChiamataEntity> getChiamate(){
        return this.chiamataRepository.findAll();
    }

    public ChiamataEntity getChiamataById(long idChiamata){
        return this.chiamataRepository.findById(idChiamata)
                .orElseThrow(() -> new NullPointerException("chiamata con questo id inesistente"));
    }

    public void addChiamata(ChiamataEntity chiamata){
        this.chiamataRepository.save(chiamata);
    }

    public ChiamataEntity createChiamata(NegozioEntity negozioChiamante, OrdineEntity ordineContenente){
        ChiamataEntity chiamata = new ChiamataEntity();
        chiamata.setNegozio(negozioChiamante);
        chiamata.setOrdine(ordineContenente);
        return chiamata;
    }

    public void deleteChiamataById(long id) {
        this.chiamataRepository.deleteById(id);
    }
}

