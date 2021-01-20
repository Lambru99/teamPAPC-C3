package it.cs.unicam.ids.c3.controller;

import it.cs.unicam.ids.c3.entity.LockerEntity;
import it.cs.unicam.ids.c3.entity.NegozioEntity;
import it.cs.unicam.ids.c3.entity.OrdineEntity;
import it.cs.unicam.ids.c3.entity.ProdottoEntity;
import it.cs.unicam.ids.c3.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Objects;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/clienti")
public class ClienteRestController implements ClienteRestControllerInterface {
    @Autowired
    private ClienteService clienteService;

    public ClienteRestController() {
    }


    @PostMapping("/annullaOrdine")
    @Override
    public String clearOrdineInCorso(){
        this.clienteService.clearCreatore();
        return "ordine annullato";
    }

    @PostMapping("/setEmittente")
    @Override
    public String setEmittenteOrdine(@RequestParam long idNegozio){
        NegozioEntity n = this.clienteService.setEmittenteOrdine(idNegozio);
        if (Objects.isNull(n)) return "nessun Negozio con questo Id";
        else return n.toString();
    }

    @PostMapping("/setDestinazione")
    @Override
    public String setDestinazioneOrdine(@RequestParam long idLocker){
        LockerEntity l = this.clienteService.setDestinazioneOrdine(idLocker);
        if (Objects.isNull(l)) return "nessun Negozio con questo Id";
        else return l.toString();
    }


    @PostMapping("/setProdotto")
    @Override
    public String setProdottoOrdine(@RequestParam long idProdotto, @RequestParam int number){
        ProdottoEntity p = this.clienteService.setProdottoOrdine(idProdotto,number);
        if(Objects.isNull(p)) return "nessun Prodotto con questo Id";
        else return p.toString();
    }

    @PostMapping("/{id}/aggiungiOrdine")
    @Override
    public String addOrdineToCliente(@PathVariable long id){
        OrdineEntity o = this.clienteService.addOrdineToCliente(id);
        if(Objects.isNull(o)) return "nessun Ordine con questo Id";
        else return o.toString();
    }
}