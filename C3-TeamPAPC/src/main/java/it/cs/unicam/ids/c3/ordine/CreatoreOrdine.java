package it.cs.unicam.ids.c3.ordine;

import it.cs.unicam.ids.c3.locker.LockerEntity;
import it.cs.unicam.ids.c3.negozi.NegozioEntity;
import it.cs.unicam.ids.c3.prodotti.ProdottoEntity;

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
