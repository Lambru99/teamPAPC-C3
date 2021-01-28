package it.cs.unicam.ids.c3.service;

import it.cs.unicam.ids.c3.entity.*;
import it.cs.unicam.ids.c3.util.CreatoreOrdine;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;

@Service
public interface ClienteServiceInterface {
    CreatoreOrdine getCreatoreOrdineInCorso();

    void cancellaOrdine();

    void cambiaStatoOrdine(long id, long idOrdine);

    String getInfoOrdine(long id, long idOrdine);

    List<OrdineEntity> getOrdiniCliente(long id, Predicate<OrdineEntity> predicate);

    NegozioEntity setEmittenteOrdine(long idNegozio);

    LockerEntity setDestinazioneOrdine(long idLocker);

    ProdottoEntity setProdottoOrdine(long idProdotto, int number);

    OrdineEntity addOrdineToCliente(long id);

    ClienteEntity getClienteById(long id);

}
