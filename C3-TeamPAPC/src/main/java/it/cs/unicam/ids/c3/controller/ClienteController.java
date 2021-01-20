package it.cs.unicam.ids.c3.controller;

import it.cs.unicam.ids.c3.entity.LockerEntity;
import it.cs.unicam.ids.c3.entity.NegozioEntity;
import it.cs.unicam.ids.c3.entity.OrdineEntity;
import it.cs.unicam.ids.c3.entity.ProdottoEntity;

public interface ClienteController {
    void clearOrdineInCorso();
    NegozioEntity setEmittenteOrdine(long idNegozio);
    LockerEntity setDestinazioneOrdine(long idLocker);
    ProdottoEntity setProdottoOrdine(long idProdotto,int number);
    OrdineEntity addOrdineToCliente(long id);
}
