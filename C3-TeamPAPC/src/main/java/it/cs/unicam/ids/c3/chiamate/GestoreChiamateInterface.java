package it.cs.unicam.ids.c3.chiamate;

import it.cs.unicam.ids.c3.negozi.NegozioEntity;
import it.cs.unicam.ids.c3.cliente.ChiamataEntity;
import it.cs.unicam.ids.c3.ordine.OrdineEntity;
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
