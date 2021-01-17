package it.cs.unicam.ids.c3.service;

import it.cs.unicam.ids.c3.entity.LockerEntity;
import it.cs.unicam.ids.c3.entity.NegozioEntity;
import it.cs.unicam.ids.c3.entity.OrdineEntity;
import it.cs.unicam.ids.c3.entity.ProdottoEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface OrderCreator {
    void setEmittente(NegozioEntity emittente);
    void addProdotto(ProdottoEntity prodotto);

    void addProdotto(ProdottoEntity prodotto, int numero);

    LockerEntity getDestinazione();

    void setDestinazione(LockerEntity destinazione);

    List<ProdottoEntity> getProdotti();
    ProdottoEntity getProdottoBySerialCode(long code);
    OrdineEntity creaOrdine();
    NegozioEntity getEmittente();
}
