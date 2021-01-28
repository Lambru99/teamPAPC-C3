package it.cs.unicam.ids.c3.service;

import it.cs.unicam.ids.c3.entity.ProdottoEntity;
import org.springframework.stereotype.Service;

@Service
public interface GestoreProdottiInterface {
    ProdottoEntity getProdottoById(long id);

    void deleteProdotto(long idProdotto);
}
