package it.cs.unicam.ids.c3.prodotti;

import org.springframework.stereotype.Service;

@Service
public interface GestoreProdottiInterface {
    ProdottoEntity getProdottoById(long id);

    void deleteProdotto(long idProdotto);
}
