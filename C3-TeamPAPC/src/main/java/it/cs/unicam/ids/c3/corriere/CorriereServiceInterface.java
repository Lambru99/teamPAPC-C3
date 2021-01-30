package it.cs.unicam.ids.c3.corriere;

import it.cs.unicam.ids.c3.ordine.OrdineEntity;
import it.cs.unicam.ids.c3.ordine.StatoOrdine;
import it.cs.unicam.ids.c3.cliente.ChiamataEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;

@Service
public interface CorriereServiceInterface {
    List<ChiamataEntity> getChiamate();

    void accettaChiamata(long id, long idChiamata);

    String getInfoOrdine(long id, long idOrdine);

    void cambiaStatoOrdine(long id, long idOrdine, StatoOrdine stato);

    CorriereEntity getCorriereById(long id);

    List<CorriereEntity> getCorrieri();

    List<OrdineEntity> getOrdini(long id, Predicate<OrdineEntity> predicate);
}
