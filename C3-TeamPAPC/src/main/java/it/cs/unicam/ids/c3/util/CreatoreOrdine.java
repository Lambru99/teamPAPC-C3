package it.cs.unicam.ids.c3.util;

import it.cs.unicam.ids.c3.entity.LockerEntity;
import it.cs.unicam.ids.c3.entity.NegozioEntity;
import it.cs.unicam.ids.c3.entity.OrdineEntity;
import it.cs.unicam.ids.c3.entity.ProdottoEntity;

import java.util.List;

public interface CreatoreOrdine {
    void setEmittente(NegozioEntity emittente);
    void addProdotto(ProdottoEntity prodotto, int numero);

    LockerEntity getDestinazione();

    void setDestinazione(LockerEntity destinazione);

    List<ProdottoEntity> getProdotti();
    ProdottoEntity getProdottoBySerialCode(long code);
    OrdineEntity creaOrdine();
    NegozioEntity getEmittente();
}
