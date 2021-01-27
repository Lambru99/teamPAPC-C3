package it.cs.unicam.ids.c3.service;

import it.cs.unicam.ids.c3.entity.*;
import it.cs.unicam.ids.c3.repository.CommercianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * servizio che permette di gestire le operazioni di un commerciante
 */
@Service
public class CommercianteService {
    @Autowired
    private CommercianteRepository commercianteRepository;
    @Autowired
    private GestoreOrdini gestoreOrdini;
    @Autowired
    private GestoreChiamate gestoreChiamate;
    @Autowired
    private GestoreNegozi gestoreNegozi;

    public CommercianteEntity getCommercianteById(long id){
        if(this.commercianteRepository.findAll().stream().noneMatch(commercianteEntity -> commercianteEntity.getId()==id))throw
                new NullPointerException("nessun Commerciante con questo Id");
        else
            return this.commercianteRepository.getOne(id);
    }

    /**
     * permette di cambiare lo stato dell'ordine da parte di un commerciante usando il servizio GestoreOrdini
     * @param id del commerciante
     * @param idOrdine dell'ordine a cui cambiare stato
     * @param stato stato da settare
     */
    public void cambiaStatoOrdine(long id, long idOrdine, StatoOrdine stato){
        if (getOrdiniCommerciante(id,o->true).stream().anyMatch(o->o.getId()==idOrdine))
            this.gestoreOrdini.cambiaStatoOrdine(idOrdine,stato);
        else throw new NullPointerException("nessun ordine con questo id");
    }

    /**
     * usando il servizio associato agli ordini, permette ad un commerciante di ottenere le informazioni di un ordine
     * associato ad un id
     * @param id del commerciante
     * @param idOrdine dell'ordine da cui ottenere le informazioni
     * @return le informazioni dell'ordine
     */
    public String getInfoOrdine(long id,long idOrdine){
        if(getOrdiniCommerciante(id,ordineEntity -> true).stream().noneMatch(o->o.getId()==idOrdine))return null;
        else return this.gestoreOrdini.getInformazioni(idOrdine);
    }

    /**
     * permette di modificare il numero della quantità di uin certo prodotto contentuto all'interno del negozio
     * associato ad un commerciante
     * se aggiunta è true allora il numero verrà aggiunto al numero del prodotto, altrimenti tolto.
     * se il numero che si vuole togliere è maggiore del numero corrente allora viene settato a 0
     * @param idCommerciante id del commerciante
     * @param idProdotto id del prodotto a cui effettuare la modifica
     * @param numero numero da aggiungere/togliere
     * @param aggiunta boolean di controllo per l'aggiunta o rimozione.
     * @return prodotto aggiunto.
     */
    public ProdottoEntity modificaNumeroProdotto(long idCommerciante,long idProdotto,int numero,boolean aggiunta){
        Predicate<ProdottoEntity> predicate = p ->p.getId()==idProdotto;
        ProdottoEntity p = getProdottiNegozio(idCommerciante).stream().filter(predicate).findFirst()
                .orElseThrow(()->new NullPointerException("prodotto con questo Id inesistente"));
        if (aggiunta) p.setNumero(p.getNumero()+numero);
        else {
            if(p.getNumero()<=numero)p.setNumero(0);
            else p.setNumero(p.getNumero()-numero);
        }
        this.gestoreNegozi.addOrUpdateNegozio(getCommercianteById(idCommerciante).getNegozio());
        return p;
    }

    /**
     * permette di aggiungere un nuovo prodotto all'interno del negozio associato ad un commerciante
     * @param idCommerciante id del commerciante
     * @param prodotto prodotto che si vuol aggiungere
     */
    public void aggiungiProdotto(long idCommerciante,ProdottoEntity prodotto){
        NegozioEntity n = this.getCommercianteById(idCommerciante).getNegozio();
        n.getProdotti().add(prodotto);
        this.gestoreNegozi.addOrUpdateNegozio(n);
    }

    /**
     * permette di eliminare un prodotto
     * @param idCommerciante id commerciante
     * @param idProdotto id porodotto da rimuovere
     */
    public void deleteProdotto(long idCommerciante,long idProdotto){
        NegozioEntity n = getCommercianteById(idCommerciante).getNegozio();
        this.gestoreNegozi.deleteProdotto(n.getId(),idProdotto);
    }

    public List<ProdottoEntity> getProdottiNegozio(long id){
        return getCommercianteById(id).getNegozio().getProdotti();
    }

    public List<OrdineEntity> getOrdiniCommerciante(long id,Predicate<OrdineEntity> predicate){
        return this.gestoreOrdini.filtraOrdini(this.gestoreOrdini.getOrdini().stream().filter(ordineEntity ->
                ordineEntity.getEmittente().getId()==getCommercianteById(id).getNegozio().getId())
                        .collect(Collectors.toList()),predicate);
    }

    /**
     * permette ad un commerciante di effettuare una chiamata per un certo ordine
     * @param id
     * @param idOrdine
     */
    public void effettuaChiamata(long id,long idOrdine){
        CommercianteEntity commerciante = getCommercianteById(id);
        OrdineEntity ordine = getOrdiniCommerciante(id, o -> o.getStatoOrdine()==StatoOrdine.ESEGUITO).stream().filter(o -> o.getId()==idOrdine)
                .findFirst().orElseThrow(()-> new NullPointerException("nessun ordine valido in questo negozio con questi parametri"));
        this.gestoreChiamate.addChiamata(this.gestoreChiamate.createChiamata(commerciante.getNegozio(),ordine));
    }
}
