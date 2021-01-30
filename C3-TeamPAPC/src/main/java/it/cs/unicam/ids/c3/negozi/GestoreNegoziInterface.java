package it.cs.unicam.ids.c3.negozi;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GestoreNegoziInterface {
    NegozioEntity getNegozioById(long id);

    void deleteProdotto(long idNegozio, long idProdotto);

    List<NegozioEntity> getNegozi();

    void addOrUpdateNegozio(NegozioEntity negozio);
}
