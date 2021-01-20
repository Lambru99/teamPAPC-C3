package it.cs.unicam.ids.c3.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface ClienteRestControllerInterface {

    @PostMapping("/annullaOrdine")
    String clearOrdineInCorso();

    @PostMapping("/setEmittente")
    String setEmittenteOrdine(@RequestParam long idNegozio);

    @PostMapping("/setDestinazione")
    String setDestinazioneOrdine(@RequestParam long idLocker);

    @PostMapping("/setProdotto")
    String setProdottoOrdine(@RequestParam long idProdotto, @RequestParam int number);

    @PostMapping("/{id}/aggiungiOrdine")
    String addOrdineToCliente(@PathVariable long id);
}
