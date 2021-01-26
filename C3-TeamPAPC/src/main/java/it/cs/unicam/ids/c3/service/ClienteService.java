package it.cs.unicam.ids.c3.service;

import it.cs.unicam.ids.c3.entity.*;
import it.cs.unicam.ids.c3.repository.ClienteRepository;
import it.cs.unicam.ids.c3.util.CreatoreOrdine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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

    /*public void ritiraOrdine(long id,long idOrdine){
        OrdineEntity o = this.gestoreOrdini.getOrdineById(idOrdine);
        if(getOrdiniCliente(id,or ->or.getStatoOrdine()==StatoOrdine.CONSEGNATO||
                or.getStatoOrdine()==StatoOrdine.RITIRO_NEGOZIO).contains(o))
            this.gestoreOrdini.cambiaStatoOrdine(idOrdine,StatoOrdine.COMPLETATO);
    }*/
    public void cambiaStatoOrdine(long id,long idOrdine,StatoOrdine stato){
        if (getClienteById(id).getOrdini().stream().anyMatch(o->o.getId()==idOrdine))
            this.gestoreOrdini.cambiaStatoOrdine(idOrdine,stato);
        else throw new NullPointerException("nessun ordine con questo id");
    }

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
