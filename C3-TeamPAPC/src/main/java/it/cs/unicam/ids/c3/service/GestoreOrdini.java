package it.cs.unicam.ids.c3.service;

import it.cs.unicam.ids.c3.entity.*;
import it.cs.unicam.ids.c3.repository.OrdineRepository;
import it.cs.unicam.ids.c3.util.ConcreteCreatoreOrdine;
import it.cs.unicam.ids.c3.util.CreatoreOrdine;
import it.cs.unicam.ids.c3.util.ObjectStringer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * servizio che si occupa di gestire gli ordini
 * ha la responsabilità di creare e settare i parametri di un ordine
 * e di gestire tutte le operazioni effettuabili sugli ordini
 * servizio che viene utilizzato da altri servizi
 */
@Service
public class GestoreOrdini implements GestoreOrdiniInterface{
    @Autowired
    private OrdineRepository ordineRepository;
    @Autowired
    private GestoreNegoziInterface gestoreNegozi;
    @Autowired
    private GestoreLockersInterface gestoreLockers;

    private CreatoreOrdine creatoreOrdine;

    public GestoreOrdini() {
        this.creatoreOrdine = new ConcreteCreatoreOrdine();
    }

    @Override
    public OrdineEntity getOrdineById(long id){
        return this.ordineRepository.findById(id).orElseThrow(NullPointerException::new);
    }

    @Override
    public CreatoreOrdine getCreatore(){
        return this.creatoreOrdine;
    }

    /**
     * filtra gli ordini da una lista di ordini posseduta da qualcuno(es. Cliente,Commerciante..)
     * @param ordiniPosseduti lista degli ordini di un ente che deve essere filtrata
     * @param filtro filtro che si applica alla lista
     * @return lista deglio ordini filtrati secondo un predicato
     */
    @Override
    public List<OrdineEntity> filtraOrdini(List<OrdineEntity> ordiniPosseduti, Predicate<OrdineEntity> filtro){
        return ordiniPosseduti.stream().filter(filtro).collect(Collectors.toList());
    }

    @Override
    public List<OrdineEntity> getOrdini(){
        return this.ordineRepository.findAll();
    }

    @Override
    public NegozioEntity setEmittenteOrdine(long idEmittente){
        this.creatoreOrdine.setEmittente(this.gestoreNegozi.getNegozioById(idEmittente));
        return this.creatoreOrdine.getEmittente();
    }
    @Override
    public LockerEntity setDestinazione(long idDestinazione){
        this.creatoreOrdine.setDestinazione(this.gestoreLockers.getLockerById(idDestinazione));
        return this.creatoreOrdine.getDestinazione();
    }

    /**
     * setta il prodotto da aggiungere al creatore con una certa quantità
     * @param idProdotto id del prodotto da aggiungere
     * @param numero numero del prodotto da aggiungere
     * @return prodotto aggiunto
     */
    @Override
    public ProdottoEntity setProdottoOrdine(long idProdotto, int numero){
        if(this.creatoreOrdine.getEmittente().getProdotti().stream().noneMatch(prodottoEntity -> prodottoEntity.getId()==idProdotto))
            throw new NullPointerException("nessun Prodotto con questo Id");
        ProdottoEntity prodotto = this.creatoreOrdine.getEmittente().getProdotti().stream().filter(p->p.getId()==idProdotto)
                .findFirst().orElseThrow();
        ProdottoEntity p = new ProdottoEntity(prodotto.getNome(),prodotto.getDescrizione(),prodotto.getPrezzo());
        p.setSerialCode(prodotto.getSerialCode());
        this.creatoreOrdine.addProdotto(p,numero);
        return this.creatoreOrdine.getProdotti().stream().filter(prodottoEntity ->
                prodottoEntity.getSerialCode()==prodotto.getSerialCode()).findFirst().orElseThrow(NullPointerException::new);
    }

    @Override
    public OrdineEntity creaOrdine(){
        this.gestoreNegozi.addOrUpdateNegozio(this.creatoreOrdine.getEmittente());
        this.creatoreOrdine.setEmittente(this.gestoreNegozi
                .getNegozioById(this.creatoreOrdine.getEmittente().getId()));
        if(this.creatoreOrdine.getDestinazione()!=null){
            this.gestoreLockers.addOrUpdatesLocker(this.creatoreOrdine.getDestinazione());
            this.creatoreOrdine.setDestinazione(this.gestoreLockers
                    .getLockerById(this.creatoreOrdine.getDestinazione().getId()));
        }
        return this.creatoreOrdine.creaOrdine();
    }

    /**
     * Una volta creato un ordine, vengono azzerati i parametri del creatore
     */
    @Override
    public void clearCreatore(){
        this.creatoreOrdine.setEmittente(null);
        this.creatoreOrdine.setDestinazione(null);
        this.creatoreOrdine.getProdotti().clear();
    }

    /**
     * viene usato per restituire le informazioni dettagliate di un ordine sotto forma di stringa
     * @param id id dell'ordine a cui si vuole accedere alle informazioni
     * @return le informazioni dell'ordine selezionato
     */
    @Override
    public String getInformazioni(long id){
        String dest="";
        OrdineEntity ordineEntity = getOrdineById(id);
        if(ordineEntity.getDestinazione()==null)dest="ritiro al Negozio: "+ordineEntity.getEmittente().getNome()
                +"; inidirizzo: "+ordineEntity.getEmittente().getIndirizzo()+"; ";
        else dest="ritiro al Locker: "+ordineEntity.getDestinazione().getNome()
                +"; inidirizzo: "+ordineEntity.getDestinazione().getIndirizzo()+"; ";

        ObjectStringer<OrdineEntity> stringer = o -> "id: "+o.getId()+"; numero: "+o.getNumeroOrdine()
                +"; prezzo: "+o.getSoldi()+"; stato: "+o.getStatoOrdine().toString()+"; ";
        ObjectStringer<ProdottoEntity> stringer1 = o->"codice : "+o.getSerialCode()+"; nome : "+o.getNome()+
                "; prezzo al pezzo: "+o.getPrezzo()+"; quantità: "+o.getNumero()+"; ";
        return stringer.objectToString(ordineEntity)+dest+" Prodotti: "+stringer1.objectToString(ordineEntity.getProdotti());
    }

    /**
     * cambia lo stato di un ordine
     * @param idOrdine ordine a cui si vuole cambiare stato
     * @param statoDaSettare lo stata che si vuole settare
     */
    @Override
    public void cambiaStatoOrdine(long idOrdine, StatoOrdine statoDaSettare) {
        OrdineEntity ordineEntity =getOrdineById(idOrdine);
        ordineEntity.setStatoOrdine(statoDaSettare);
        this.ordineRepository.save(ordineEntity);
    }
}
