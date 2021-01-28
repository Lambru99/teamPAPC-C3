package it.cs.unicam.ids.c3.service;

import it.cs.unicam.ids.c3.entity.ChiamataEntity;
import it.cs.unicam.ids.c3.entity.NegozioEntity;
import it.cs.unicam.ids.c3.entity.OrdineEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GestoreChiamateInterface {
    List<ChiamataEntity> getChiamate();

    ChiamataEntity getChiamataById(long idChiamata);

    void addChiamata(ChiamataEntity chiamata);

    ChiamataEntity createChiamata(NegozioEntity negozioChiamante, OrdineEntity ordineContenente);

    void deleteChiamataById(long id);
}
