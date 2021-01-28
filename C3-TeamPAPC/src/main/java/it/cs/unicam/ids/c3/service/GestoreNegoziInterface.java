package it.cs.unicam.ids.c3.service;

import it.cs.unicam.ids.c3.entity.NegozioEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GestoreNegoziInterface {
    NegozioEntity getNegozioById(long id);

    void deleteProdotto(long idNegozio, long idProdotto);

    List<NegozioEntity> getNegozi();

    void addOrUpdateNegozio(NegozioEntity negozio);
}
