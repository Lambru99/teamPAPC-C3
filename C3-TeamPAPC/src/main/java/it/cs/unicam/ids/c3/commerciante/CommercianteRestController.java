package it.cs.unicam.ids.c3.commerciante;

import it.cs.unicam.ids.c3.negozi.NegozioEntity;
import it.cs.unicam.ids.c3.ordine.OrdineEntity;
import it.cs.unicam.ids.c3.ordine.StatoOrdine;
import it.cs.unicam.ids.c3.prodotti.ProdottoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * Controller rest del Commerciante
 */
@RestController
@RequestMapping("/commercianti")
@CrossOrigin(origins = "*")
public class CommercianteRestController {
    @Autowired
    private CommercianteServiceInterface commercianteService;

    public CommercianteRestController() {
    }

    @GetMapping("/{id}")
    public CommercianteEntity getCommercinateById(@PathVariable long id){
        return this.commercianteService.getCommercianteById(id);
    }
    /**
     * Permette di settare una destinazione all'ordine
     * @param idOrdine id ordine
     * @param id id commerciante
     */
    @PatchMapping("/{id}/ordini/ritiroInNegozio")
    public void setOrdineRitiroInNegozio(@PathVariable long id,@RequestParam long idOrdine){
        this.commercianteService.cambiaStatoOrdine(id,idOrdine);
    }

    @GetMapping("/{id}/negozio")
    public NegozioEntity getNegozioCommerciante(@PathVariable long id){
        return getCommercinateById(id).getNegozio();
    }

    @GetMapping("/{id}/ordini/getInfo")
    public String getInfoOrdine(@PathVariable long id,@RequestParam long idOrdine){
        return this.commercianteService.getInfoOrdine(id,idOrdine);
    }

    @GetMapping("/{id}/prodotti")
    public List<ProdottoEntity> getProdottiNegozio(@PathVariable long id){
        return this.commercianteService.getProdottiNegozio(id);
    }

    /**
     * Permette di modificare la quantità di un prodotto
     * @param id negozio
     * @param idProdotto prodotto
     * @param numero quantita
     * @param aggiunta aggiungere o togliere
     * @return il nuovo prodotto
     */
    @PatchMapping("/{id}/modificaProdotto")
    public ProdottoEntity modificaProdotto(@PathVariable long id,@RequestParam long idProdotto,@RequestParam int numero,
                                           @RequestParam boolean aggiunta){
        return this.commercianteService.modificaNumeroProdotto(id,idProdotto,numero,aggiunta);
    }

    /**
     * ermette di creare un nuovo prodotto
     * @param id commerciante
     * @param nome
     * @param descrizione
     * @param prezzo
     * @param numero
     */
    @PostMapping("/{id}/aggiungiProdotto")
    public void addProdotto(@PathVariable long id,@RequestParam String nome,@RequestParam String descrizione,
                            @RequestParam double prezzo,@RequestParam int numero){
        ProdottoEntity p = new ProdottoEntity(nome,descrizione,prezzo);
        if (numero>0) p.setNumero(numero);
        this.commercianteService.aggiungiProdotto(id,p);
    }

    /**
     * Permette di eliminare un prodotto
     * @param id commerciante
     * @param idProdotto prodotto
     */
    @DeleteMapping("/{id}/eliminaProdotto")
    public void deleteProdotto(@PathVariable long id,@RequestParam long idProdotto){
        this.commercianteService.deleteProdotto(id,idProdotto);
    }

    @GetMapping("/{id}/ordiniInNegozio")
    public List<OrdineEntity> getOrdiniCommerciante(@PathVariable long id){
        return this.commercianteService.getOrdiniCommerciante(id,o->true);
    }
    @GetMapping("/{id}/ordiniInNegozioPerRitiro")
    public List<OrdineEntity> getOrdiniCommercianteInRitiro(@PathVariable long id){
        return this.commercianteService.getOrdiniCommerciante(id,ordineEntity ->
                ordineEntity.getStatoOrdine()== StatoOrdine.RITIRO_NEGOZIO);
    }
    @GetMapping("/{id}/ordiniInNegozioNonCompletati")
    public List<OrdineEntity> getOrdiniCommercianteNonCompletati(@PathVariable long id){
        return this.commercianteService.getOrdiniCommerciante(id,ordineEntity ->
                ordineEntity.getStatoOrdine()!= StatoOrdine.COMPLETATO);
    }

    @GetMapping("/{id}/ordiniDaSoddisfare")
    public List<OrdineEntity> getOrdiniDaSoddisfare(@PathVariable long id){
        return this.commercianteService.getOrdiniCommerciante(id,ordineEntity ->
                ordineEntity.getStatoOrdine()==StatoOrdine.ESEGUITO);
    }

    /**
     * Permette al commerciante di effettuare una chiamata
     * @param id
     * @param idOrdine
     */
    @PostMapping("/{id}/inviaChiamata")
    public void effettuaChiamata(@PathVariable long id,@RequestParam long idOrdine){
        this.commercianteService.effettuaChiamata(id,idOrdine);
    }

}

