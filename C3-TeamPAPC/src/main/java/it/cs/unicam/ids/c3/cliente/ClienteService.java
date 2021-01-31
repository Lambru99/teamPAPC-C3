package it.cs.unicam.ids.c3.cliente;

import it.cs.unicam.ids.c3.locker.LockerEntity;
import it.cs.unicam.ids.c3.negozi.NegozioEntity;
import it.cs.unicam.ids.c3.ordine.CreatoreOrdine;
import it.cs.unicam.ids.c3.ordine.GestoreOrdiniInterface;
import it.cs.unicam.ids.c3.ordine.OrdineEntity;
import it.cs.unicam.ids.c3.ordine.StatoOrdine;
import it.cs.unicam.ids.c3.prodotti.ProdottoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;

/**
 * servizio che permette di gestire le operazioni di un cliente
 */
@Service
public class ClienteService implements ClienteServiceInterface{
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private GestoreOrdiniInterface gestoreOrdini;

    public ClienteService() {
    }
    @Override
    public CreatoreOrdine getCreatoreOrdineInCorso(){
        return this.gestoreOrdini.getCreatore();
    }

    @Override
    public void cancellaOrdine(){
        this.gestoreOrdini.clearCreatore();
    }

    /**
     * permette al cliente di settare un ordine come completato poiché ritirato
     * @param id del cliente
     * @param idOrdine dell'ordine da ritirare
     */
    @Override
    public void cambiaStatoOrdine(long id,long idOrdine){
        if (getOrdiniCliente(id,o->o.getStatoOrdine()== StatoOrdine.CONSEGNATO||
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
    @Override
    public String getInfoOrdine(long id,long idOrdine){
        if(getOrdiniCliente(id,o->true).stream().noneMatch(o->o.getId()==idOrdine))return null;
        else return this.gestoreOrdini.getInformazioni(idOrdine);
    }

    /**
     * Metodo che permette di avere tutti gli ordini che un cliente ha eseguito
     * @param id id del cliente
     * @param predicate filtro da applicare alla lista
     * @return ordini esegiuti dal cliente
     */
    @Override
    public List<OrdineEntity> getOrdiniCliente(long id, Predicate<OrdineEntity> predicate){
        return this.gestoreOrdini.filtraOrdini(getClienteById(id).getOrdini(),predicate);
    }

    @Override
    public NegozioEntity setEmittenteOrdine(long idNegozio){
        return this.gestoreOrdini.setEmittenteOrdine(idNegozio);
    }

    @Override
    public LockerEntity setDestinazioneOrdine(long idLocker){
        return this.gestoreOrdini.setDestinazione(idLocker);
    }

    @Override
    public ProdottoEntity setProdottoOrdine(long idProdotto, int number){
        return this.gestoreOrdini.setProdottoOrdine(idProdotto,number);
    }

    /**
     * crea ed effettua un ordine da porte di un cliente
     * @param id del cliente
     * @return l'ordine effettuato
     */
    @Override
    public OrdineEntity addOrdineToCliente(long id) {
        if (this.clienteRepository.findAll().stream().noneMatch(clienteEntity -> clienteEntity.getId() == id))
            throw new NullPointerException("cliente con questo id inesistente");
        ClienteEntity cliente = getClienteById(id);
        OrdineEntity o = this.gestoreOrdini.creaOrdine();
        this.gestoreOrdini.clearCreatore();
        cliente.getOrdini().add(o);
        this.clienteRepository.save(cliente);
        return o;
    }

    /**
     *  Permette di risalire ad un cliente tramite un Id
     * @param id id del cliente da ricercare
     * @return Il cliente con l'id dato in input
     */
    @Override
    public ClienteEntity getClienteById(long id){
        if(this.clienteRepository.findAll().stream().noneMatch(clienteEntity -> clienteEntity.getId()==id))throw
                new NullPointerException("nessun Cliente con questo Id");
        else
            return this.clienteRepository.getOne(id);
    }

}
