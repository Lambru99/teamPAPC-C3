package it.cs.unicam.ids.c3.controller;

import it.cs.unicam.ids.c3.entity.ProdottoEntity;
import it.cs.unicam.ids.c3.repository.ProdottoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller rest dei prodotti
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/prodotti")
public class ProdottoRestController {
    @Autowired
    private ProdottoRepository prodottoRepository;

    public ProdottoRestController() {
    }

    @GetMapping
    public List<ProdottoEntity> getProdotti() {
        return this.prodottoRepository.findAll();
    }

    public ProdottoRepository getProdottoRepository() {
        return prodottoRepository;
    }

    @GetMapping("/{id}")
    public ProdottoEntity getProdottoById(@PathVariable long id) {
        return this.prodottoRepository.findById(id).orElseThrow();
    }

}
