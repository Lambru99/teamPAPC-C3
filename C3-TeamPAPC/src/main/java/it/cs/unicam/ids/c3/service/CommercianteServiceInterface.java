package it.cs.unicam.ids.c3.service;

import it.cs.unicam.ids.c3.entity.CommercianteEntity;
import it.cs.unicam.ids.c3.entity.OrdineEntity;
import it.cs.unicam.ids.c3.entity.ProdottoEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;

@Service
public interface CommercianteServiceInterface {

    CommercianteEntity getCommercianteById(long id);

    void cambiaStatoOrdine(long id, long idOrdine);

    String getInfoOrdine(long id, long idOrdine);

    ProdottoEntity modificaNumeroProdotto(long idCommerciante, long idProdotto, int numero, boolean aggiunta);

    void aggiungiProdotto(long idCommerciante, ProdottoEntity prodotto);

    void deleteProdotto(long idCommerciante, long idProdotto);

    List<ProdottoEntity> getProdottiNegozio(long id);

    List<OrdineEntity> getOrdiniCommerciante(long id, Predicate<OrdineEntity> predicate);

    void effettuaChiamata(long id, long idOrdine);
}
