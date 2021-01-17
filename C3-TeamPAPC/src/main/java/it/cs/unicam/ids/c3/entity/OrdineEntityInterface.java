package it.cs.unicam.ids.c3.entity;

import java.util.List;

public interface OrdineEntityInterface {
    StatoOrdine getStatoOrdine();

    void setSoldi(double soldi);

    void setStatoOrdine(StatoOrdine statoOrdine);

    long getId();

    void calcoloSoldi();

    long getNumeroOrdine();

    void setNumeroOrdine(long numeroOrdine);

    PuntoRitiroEntity getDestinazione();

    void setDestinazione(PuntoRitiroEntity destinazione);

    NegozioEntity getEmittente();

    void setEmittente(NegozioEntityInterface emittente);

    List<ProdottoEntity> getProdotti();

    void setProdotti(List<ProdottoEntity> prodotti);

    double getSoldi();

    void setId(long id);
}
