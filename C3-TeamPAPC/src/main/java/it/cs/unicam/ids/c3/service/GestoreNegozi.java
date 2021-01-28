package it.cs.unicam.ids.c3.service;

import it.cs.unicam.ids.c3.entity.NegozioEntity;
import it.cs.unicam.ids.c3.entity.ProdottoEntity;
import it.cs.unicam.ids.c3.repository.NegozioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * servizio che si occupa di gestire i negozi in alcune operazioni,poiché
 * la responsabilità di gestire un negozio è del commerciante
 * questo servizio verrà utilizzato da altri servizi
 */
@Service
public class GestoreNegozi implements GestoreNegoziInterface{
    @Autowired
    private NegozioRepository negozioRepository;
    @Autowired
    private GestoreProdottiInterface gestoreProdotti;

    public GestoreNegozi() {
    }

    @Override
    public NegozioEntity getNegozioById(long id){
        return this.negozioRepository.findAll().stream().filter(n -> n.getId()==id).findFirst()
                .orElseThrow(()->new NullPointerException("negozio con questo id inesistente"));
    }

    /**
     * elimina un prodotto da un negozio
     * @param idNegozio id negozio su cui eliminare un prodotto
     * @param idProdotto id del prodotto da eliminare
     */
    @Override
    public void deleteProdotto(long idNegozio,long idProdotto){
        NegozioEntity n =getNegozioById(idNegozio);
        if(n.getProdotti().stream().anyMatch(p->p.getId()==idProdotto)) {
            ProdottoEntity p = this.gestoreProdotti.getProdottoById(idProdotto);
            n.getProdotti().remove(p);
            addOrUpdateNegozio(n);
            gestoreProdotti.deleteProdotto(idProdotto);
        }
        else throw new NullPointerException("prodotto in questo negozio non esistente");
    }

    @Override
    public List<NegozioEntity> getNegozi(){
        return this.negozioRepository.findAll();
    }

    @Override
    public void addOrUpdateNegozio(NegozioEntity negozio){
        this.negozioRepository.save(negozio);
    }


}
