package it.cs.unicam.ids.c3.controller;

import it.cs.unicam.ids.c3.entity.ClienteEntity;
import it.cs.unicam.ids.c3.entity.OrdineEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;

@Controller
public interface MyClienteControllerInterface {
    String setEmittenteOrdine(long idNegozio);

    String setDestinazioneOrdine(long idLocker);

    String setProdottoOrdine(long idProdotto, int number);

    List<OrdineEntity> addOrdineToCliente(long id);

    void addCliente(String nome, String cognome, String email, String password);

    ClienteEntity getClienteById(long id);
}
