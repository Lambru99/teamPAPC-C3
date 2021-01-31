package it.cs.unicam.ids.c3.prodotti;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * gestisce i prodotti all'interno della repository,specialmente per eliminarli
 * poiché i prodotti sono gestiti da un Negozio, poiché ogni prodotto è associato ad un Negozio
 */
@Service
public class GestoreProdotti implements GestoreProdottiInterface {
    @Autowired
    private ProdottoRepository prodottoRepository;

    public GestoreProdotti() {
    }

    /**
     * Permette di avere un prodotto dato il suo ID
     * @param id Id del prodotto da ricercare
     * @return prodotto che ha come id quello passato per input
     */
    @Override
    public ProdottoEntity getProdottoById(long id){
        return this.prodottoRepository.findById(id).orElseThrow(() ->
                new NullPointerException("prodotto con questo id non esistente"));
    }

    @Override
    public void deleteProdotto(long idProdotto){
        if(this.prodottoRepository.existsById(idProdotto))this.prodottoRepository.deleteById(idProdotto);
        else throw new NullPointerException("nessun prodotto con questo id");
    }
}
