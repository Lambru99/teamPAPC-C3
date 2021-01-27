package it.cs.unicam.ids.c3.service;

import it.cs.unicam.ids.c3.entity.*;
import it.cs.unicam.ids.c3.repository.ClienteRepository;
import it.cs.unicam.ids.c3.util.CreatoreOrdine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * servizio che permette di gestire le operazioni di un cliente
 */
@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private GestoreOrdini gestoreOrdini;

    public ClienteService() {
    }

    public CreatoreOrdine getCreatoreOrdineInCorso(){
        return this.gestoreOrdini.getCreatoreOrdine();
    }

    public void cancellaOrdine(){
        this.gestoreOrdini.clearCreatore();
    }

    /**
     * permette al cliente di settare un ordine come completato poiché ritirato
     * @param id del cliente
     * @param idOrdine dell'ordine da ritirare
     */
    public void cambiaStatoOrdine(long id,long idOrdine){
        if (getOrdiniCliente(id,o->o.getStatoOrdine()==StatoOrdine.CONSEGNATO||
                o.getStatoOrdine()==StatoOrdine.RITIRO_NEGOZIO).stream().anyMatch(o->o.getId()==idOrdine))
            this.gestoreOrdini.cambiaStatoOrdine(idOrdine,StatoOrdine.COMPLETATO);
        else throw new NullPointerException("nessun ordine con questo id ritirabile");
    }

    /**
     * usando il servizio associato agli ordini, permette ad un cliente di ottenere le informazioni di un ordine
     * associato ad un id
     * @param id del cliente
     * @param idOrdine dell'ordine da cui ottenere le informazioni
     * @return le informazioni dell'ordine
     */
    public String getInfoOrdine(long id,long idOrdine){
        if(getOrdiniCliente(id,o->true).stream().noneMatch(o->o.getId()==idOrdine))return null;
        else return this.gestoreOrdini.getInformazioni(idOrdine);
    }

    public List<OrdineEntity> getOrdiniCliente(long id, Predicate<OrdineEntity> predicate){
        return this.gestoreOrdini.filtraOrdini(getClienteById(id).getOrdini(),predicate);
    }


    public NegozioEntity setEmittenteOrdine(long idNegozio){
        return this.gestoreOrdini.setEmittenteOrdine(idNegozio);
    }

    public LockerEntity setDestinazioneOrdine(long idLocker){
        return this.gestoreOrdini.setDestinazione(idLocker);
    }

    public ProdottoEntity setProdottoOrdine(long idProdotto,int number){
        return this.gestoreOrdini.setProdottoOrdine(idProdotto,number);
    }

    /**
     * crea ed effettua un ordine da porte di un cliente
     * @param id del cliente
     * @return l'ordine effettuato
     */
    public OrdineEntity addOrdineToCliente(long id) {
        if (this.clienteRepository.findAll().stream().noneMatch(clienteEntity -> clienteEntity.getId() == id))
            throw new NullPointerException("cliente con questo id inesistente");
        ClienteEntity cliente = getClienteById(id);
        OrdineEntity o = this.gestoreOrdini.creaOrdine();
        cliente.getOrdini().add(o);
        this.clienteRepository.save(cliente);
        this.gestoreOrdini.clearCreatore();
        return o;
    }

    public ClienteEntity getClienteById(long id){
        if(this.clienteRepository.findAll().stream().noneMatch(clienteEntity -> clienteEntity.getId()==id))throw
                new NullPointerException("nessun Cliente con questo Id");
        else
            return this.clienteRepository.getOne(id);
    }
}
