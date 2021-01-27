package it.cs.unicam.ids.c3.controller;

import it.cs.unicam.ids.c3.entity.NegozioEntity;
import it.cs.unicam.ids.c3.entity.ProdottoEntity;
import it.cs.unicam.ids.c3.service.GestoreNegozi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller rest del negozio
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/negozi")
public class NegozioRestController {
    @Autowired
    private GestoreNegozi gestoreNegozi;

    public NegozioRestController() {
    }

    @GetMapping
    public List<NegozioEntity> getNegozi(){
        return this.gestoreNegozi.getNegozi();
    }

    @GetMapping("/{id}")
    public NegozioEntity getNegozioById(@PathVariable long id){
        return this.gestoreNegozi.getNegozioById(id);
    }

    @GetMapping("/negozio/{id}")
    public List<ProdottoEntity> getProdottiNegozio(@PathVariable long id){
        return this.gestoreNegozi.getNegozioById(id).getProdotti();
    }

    @GetMapping("/negozio/{id}/{idProdotto}")
    public ProdottoEntity getProdottoById(@PathVariable long id, @PathVariable long idProdotto){
        return this.gestoreNegozi.getNegozioById(id).getProdotti().stream().filter(prodotto -> prodotto.getId()==idProdotto).findFirst().orElse(null);
    }

    /**
     * Permette di aggiungere un nuovo prodotto al negozio
     * @param id
     * @param prodotto
     */
    @PostMapping("/negozio/{id}")
    public void addNewProdotto(@PathVariable long id,@RequestBody ProdottoEntity prodotto){
        NegozioEntity n = this.gestoreNegozi.getNegozioById(id);
        n.getProdotti().add(prodotto);
        this.gestoreNegozi.addOrUpdateNegozio(n);
    }
}
