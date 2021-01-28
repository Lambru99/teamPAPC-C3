package it.cs.unicam.ids.c3.service;

import it.cs.unicam.ids.c3.entity.*;
import it.cs.unicam.ids.c3.util.CreatoreOrdine;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;

@Service
public interface GestoreOrdiniInterface {

    OrdineEntity getOrdineById(long id);

    CreatoreOrdine getCreatore();

    List<OrdineEntity> filtraOrdini(List<OrdineEntity> ordiniPosseduti, Predicate<OrdineEntity> filtro);

    List<OrdineEntity> getOrdini();

    NegozioEntity setEmittenteOrdine(long idEmittente);

    LockerEntity setDestinazione(long idDestinazione);

    ProdottoEntity setProdottoOrdine(long idProdotto, int numero);

    OrdineEntity creaOrdine();

    void clearCreatore();

    String getInformazioni(long id);

    void cambiaStatoOrdine(long idOrdine, StatoOrdine statoDaSettare);
}
