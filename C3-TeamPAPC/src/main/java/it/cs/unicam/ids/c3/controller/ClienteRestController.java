package it.cs.unicam.ids.c3.controller;

import it.cs.unicam.ids.c3.entity.*;
import it.cs.unicam.ids.c3.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/clienti")
public class ClienteRestController{
    @Autowired
    private ClienteService clienteService;

    public ClienteRestController() {
    }

    @PostMapping("/annullaOrdine")
    public String clearOrdineInCorso(){
        this.clienteService.cancellaOrdine();
        return "ordine annullato";
    }

    @PostMapping("/setEmittente")
    public String setEmittenteOrdine(@RequestParam long idNegozio){
        NegozioEntity n = this.clienteService.setEmittenteOrdine(idNegozio);
        if (Objects.isNull(n)) return "nessun Negozio con questo Id";
        else return n.toString();
    }

    @PostMapping("/setDestinazione")
    public String setDestinazioneOrdine(@RequestParam long idLocker){
        LockerEntity l = this.clienteService.setDestinazioneOrdine(idLocker);
        if (Objects.isNull(l)) return "nessun Negozio con questo Id";
        else return l.toString();
    }


    @PostMapping("/setProdotto")
    public String setProdottoOrdine(@RequestParam long idProdotto, @RequestParam int number){
        String s ="";
        ProdottoEntity p = this.clienteService.setProdottoOrdine(idProdotto,number);
        if(Objects.isNull(p)) s= "nessun Prodotto con questo Id";
        else {
            if(this.clienteService.getCreatoreOrdineInCorso().getEmittente().getProdotti()
                    .stream().filter(pr->pr.getId()==idProdotto).anyMatch(pr->p.getNumero()>pr.getNumero())){
                s = "numero superiore da quello disponibile";
                clearOrdineInCorso();
            }else
                s = p.toString();
        }
        return s;
    }

    @GetMapping("/{id}/ordini/informazioni")
    public String getOrdineInfo(@PathVariable long id,@RequestParam long idOrdine){
        String s = this.clienteService.getInfoOrdine(id,idOrdine);
        if(s == null) return "nessun ordine con questo id";
        else return s;
    }

    @PostMapping("/{id}/aggiungiOrdine")
    public String addOrdineToCliente(@PathVariable long id){
        OrdineEntity o = this.clienteService.addOrdineToCliente(id);
        if(Objects.isNull(o)) return "nessun Ordine con questo Id";
        else return o.toString();
    }

    @GetMapping("/{id}/ordini")
    public List<OrdineEntity> getOrdiniCliente(@PathVariable long id){
        return this.clienteService.getOrdiniCliente(id,o -> true);
    }

    @GetMapping("/{id}/ordiniNonCompletati")
    public List<OrdineEntity> getOrdiniClienteNonCompletati(@PathVariable long id){
        return this.clienteService.getOrdiniCliente(id,o ->o.getStatoOrdine()!= StatoOrdine.COMPLETATO);
    }
    @GetMapping("/{id}/ordiniDaRitirare")
    public List<OrdineEntity> getOrdiniClienteDaRitirare(@PathVariable long id) {
        return this.clienteService.getOrdiniCliente(id,o ->o.getStatoOrdine()==StatoOrdine.CONSEGNATO||
                o.getStatoOrdine()==StatoOrdine.RITIRO_NEGOZIO);
    }

    @PatchMapping("/{id}/ritiraOrdine/{idOrdine}")
    public void ritiraOrdine(@PathVariable long id,@PathVariable long idOrdine){
        this.clienteService.cambiaStatoOrdine(id,idOrdine,StatoOrdine.COMPLETATO);
    }
}