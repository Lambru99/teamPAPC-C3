package it.cs.unicam.ids.c3.prova;

import it.cs.unicam.ids.c3.entity.LockerEntity;
import it.cs.unicam.ids.c3.entity.NegozioEntity;
import it.cs.unicam.ids.c3.entity.OrdineEntity;
import it.cs.unicam.ids.c3.entity.ProdottoEntity;
import it.cs.unicam.ids.c3.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/prova")
public class ProvaController {
    @Autowired
    private ProvaService provaService;
    @PostMapping("/setEmittente")
    public NegozioEntity setEmittenteOrdine(@RequestParam long idNegozio){
        return this.provaService.setNegozio(idNegozio);
    }
/*    @PostMapping("/setDestinazione")
    public String setDestinazioneOrdine(@RequestParam long idLocker){
        LockerEntity l = this.clienteService.setDestinazioneOrdine(idLocker);
        if (Objects.isNull(l)) return "nessun Negozio con questo Id";
        else return l.toString();
    }*/

    @PostMapping("/setProdotto")
    public ProdottoEntity setProdottoOrdine(@RequestParam long idProdotto, @RequestParam int number){
        return this.provaService.setProdotto(idProdotto,number);
    }

    @PostMapping("/{id}/aggiungiOrdine")
    public void addOrdineToCliente(@PathVariable long id){
        this.provaService.addOrdineToCliente(id);
    }
}
