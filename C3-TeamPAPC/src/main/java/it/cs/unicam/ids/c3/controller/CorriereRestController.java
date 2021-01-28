package it.cs.unicam.ids.c3.controller;

import it.cs.unicam.ids.c3.entity.ChiamataEntity;
import it.cs.unicam.ids.c3.entity.CorriereEntity;
import it.cs.unicam.ids.c3.entity.OrdineEntity;
import it.cs.unicam.ids.c3.entity.StatoOrdine;
import it.cs.unicam.ids.c3.service.CorriereServiceInterface;
import it.cs.unicam.ids.c3.service.GestoreChiamateInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller rest del Corriere
 */
@RestController
@RequestMapping("/corrieri")
@CrossOrigin(origins = "*")
public class CorriereRestController {
    @Autowired
    private CorriereServiceInterface corriereService;
    @Autowired
    private GestoreChiamateInterface gestoreChiamate;

    public CorriereRestController() {
    }

    @GetMapping
    public List<CorriereEntity> getCorrieri(){
        return this.corriereService.getCorrieri();
    }

    @GetMapping("/{id}")
    public CorriereEntity getCorriereById(@PathVariable long id){
        return this.corriereService.getCorriereById(id);
    }


    @GetMapping("/chiamate")
    public List<ChiamataEntity> getListaChiamate(){
        return this.gestoreChiamate.getChiamate();
    }

    /**
     * Permette al corriere di accettare delle chiamate
     * @param id
     * @param idChiamata
     */
    @DeleteMapping("/{id}/accettaChiamata")
    public void accettaChiamata(@PathVariable long id,@RequestParam long idChiamata){
        this.corriereService.accettaChiamata(id,idChiamata);
    }

    /**
     * Setta l'ordine come in trasporto
     * @param id
     * @param idOrdine
     */
    @PatchMapping("{id}/ordini/ritiraOrdine")
    public void ritiraOrdine(@PathVariable long id,@RequestParam long idOrdine){
        this.corriereService.cambiaStatoOrdine(id,idOrdine,StatoOrdine.IN_TRASPORTO);
    }

    /**
     * Setta l'ordine come Consegnato
     * @param id
     * @param idOrdine
     */
    @PostMapping("{id}/ordini/consegnaOrdine")
    public void consegnaOrdine(@PathVariable long id,@RequestParam long idOrdine){
        this.corriereService.cambiaStatoOrdine(id,idOrdine,StatoOrdine.CONSEGNATO);
    }

    @GetMapping("/{id}/ordini")
    public List<OrdineEntity> getOrdini(@PathVariable long id){
        return this.corriereService.getOrdini(id,o -> true);
    }
    @GetMapping("/{id}/ordini/daRitirare")
    public List<OrdineEntity> getOrdiniDaRitirare(@PathVariable long id){
        return this.corriereService.getOrdini(id,o->o.getStatoOrdine()== StatoOrdine.ESEGUITO);
    }
    @GetMapping("/{id}/ordini/inConsegna")
    public List<OrdineEntity> getOrdiniInConsegna(@PathVariable long id){
        return this.corriereService.getOrdini(id,o->o.getStatoOrdine()== StatoOrdine.IN_TRASPORTO);
    }
    @GetMapping("/{id}/ordini/consegnati")
    public List<OrdineEntity> getOrdiniConsegnati(@PathVariable long id){
        return this.corriereService.getOrdini(id,o->o.getStatoOrdine()== StatoOrdine.CONSEGNATO);
    }
    @GetMapping("/{id}/ordini/completati")
    public List<OrdineEntity> getOrdiniCompletati(@PathVariable long id){
        return this.corriereService.getOrdini(id,o->o.getStatoOrdine()== StatoOrdine.COMPLETATO);
    }

    @GetMapping("/{id}/ordini/informazioni")
    public String getOrdineInfo(@PathVariable long id,@RequestParam long idOrdine){
        String s = this.corriereService.getInfoOrdine(id,idOrdine);
        if(s == null) return "nessun ordine con questo id";
        else return s;
    }

}

