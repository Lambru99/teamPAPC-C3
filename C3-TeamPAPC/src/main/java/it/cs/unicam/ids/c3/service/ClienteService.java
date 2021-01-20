package it.cs.unicam.ids.c3.service;

import it.cs.unicam.ids.c3.entity.*;
import it.cs.unicam.ids.c3.repository.ClienteRepository;
import it.cs.unicam.ids.c3.repository.LockerRepository;
import it.cs.unicam.ids.c3.repository.NegozioRepository;
import it.cs.unicam.ids.c3.repository.ProdottoRepository;
import it.cs.unicam.ids.c3.util.ConcreteCreatoreOrdine;
import it.cs.unicam.ids.c3.util.CreatoreOrdine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private NegozioRepository negozioRepository;
    @Autowired
    private ProdottoRepository prodottoRepository;
    @Autowired
    private LockerRepository lockerRepository;

    private CreatoreOrdine creatoreOrdine;

    public ClienteService() {
        this.creatoreOrdine = new ConcreteCreatoreOrdine();
    }

    public NegozioEntity setEmittenteOrdine(long idNegozio){
        if (this.negozioRepository.findAll().stream().noneMatch(negozioEntity -> negozioEntity.getId()==idNegozio))
            throw new NullPointerException("id negozio inesistente");
        NegozioEntity n = negozioRepository.getOne(idNegozio);
        this.creatoreOrdine.setEmittente(n);
        return n;
    }

    public LockerEntity setDestinazioneOrdine(long idLocker){
        if (this.lockerRepository.findAll().stream().noneMatch(lockerEntity -> lockerEntity.getId()==idLocker))
            throw new NullPointerException("id negozio inesistente");
        LockerEntity l = lockerRepository.getOne(idLocker);
        this.creatoreOrdine.setDestinazione(l);
        return l;
    }

    public ProdottoEntity setProdottoOrdine(long idProdotto, int number){
        if(this.creatoreOrdine.getEmittente().getProdotti().stream().noneMatch(prodottoEntity -> prodottoEntity.getId()==idProdotto))
            throw new NullPointerException("nessun Prodotto con questo Id");
        ProdottoEntity prodotto = this.prodottoRepository.getOne(idProdotto);
        ProdottoEntity prodottoIn;
        if(this.creatoreOrdine.getProdotti().stream().anyMatch(prodottoEntity -> prodottoEntity.getSerialCode()==prodotto.getSerialCode())){
            prodottoIn = this.creatoreOrdine.getProdottoBySerialCode(prodotto.getSerialCode());
            prodottoIn.setNumero(prodottoIn.getNumero()+number);
        }else {
            prodottoIn = new ProdottoEntity(prodotto.getNome(),prodotto.getDescrizione(),prodotto.getPrezzo());
            prodottoIn.setSerialCode(prodotto.getSerialCode());
            this.creatoreOrdine.addProdotto(prodottoIn,number);
        }
        if(prodottoIn.getNumero()>prodotto.getNumero())throw new IllegalArgumentException("numero maggiore del disponibile");
        return prodottoIn;
    }

    public ClienteEntity getClienteById(long id){
        if(this.clienteRepository.findAll().stream().noneMatch(clienteEntity -> clienteEntity.getId()==id))throw
                new NullPointerException("nessun Cliente con questo Id");
        else
            return this.clienteRepository.getOne(id);
    }

    public OrdineEntity addOrdineToCliente(long id){
        if (this.clienteRepository.findAll().stream().noneMatch(clienteEntity -> clienteEntity.getId()==id))
            throw new NullPointerException("cliente con questo id inesistente");
        ClienteEntity cliente = getClienteById(id);
        if(negozioRepository.findAll().stream().noneMatch(negozioEntity -> negozioEntity.getId()==creatoreOrdine.getEmittente().getId()))
            throw new NullPointerException("negozio inesistente");
        NegozioEntity negozioEntity = this.negozioRepository.getOne(creatoreOrdine.getEmittente().getId());
        LockerEntity lockerEntity = this.lockerRepository.getOne(creatoreOrdine.getDestinazione().getId());
        creatoreOrdine.getProdotti().forEach(prodottoOrdine-> {
            negozioEntity.getProdotti().stream()
                    .filter(prodottoNegozio -> prodottoNegozio.getSerialCode()==prodottoOrdine.getSerialCode())
                    .forEach(p -> {
                        if(prodottoOrdine.getNumero()<=p.getNumero())
                            p.setNumero(p.getNumero()-prodottoOrdine.getNumero());
                        else throw new IllegalArgumentException("numero maggiore del disponibile");
                    });
        });
        this.creatoreOrdine.setEmittente(negozioEntity);
        this.creatoreOrdine.setDestinazione(lockerEntity);
        OrdineEntity ordine = this.creatoreOrdine.creaOrdine();
        clearCreatore();
        cliente.getOrdini().add(ordine);
        this.negozioRepository.save(negozioEntity);
        this.lockerRepository.save(lockerEntity);
        this.clienteRepository.save(cliente);
        return ordine;
    }

    public void clearCreatore(){
        this.creatoreOrdine.setEmittente(null);
        this.creatoreOrdine.setDestinazione(null);
        this.creatoreOrdine.getProdotti().clear();
    }
}
