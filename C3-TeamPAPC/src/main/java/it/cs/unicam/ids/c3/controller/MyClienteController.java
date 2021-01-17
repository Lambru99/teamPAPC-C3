package it.cs.unicam.ids.c3.controller;

import it.cs.unicam.ids.c3.entity.*;
import it.cs.unicam.ids.c3.repository.ClienteRepository;
import it.cs.unicam.ids.c3.repository.LockerRepository;
import it.cs.unicam.ids.c3.repository.NegozioRepository;
import it.cs.unicam.ids.c3.repository.ProdottoRepository;
import it.cs.unicam.ids.c3.service.OrderCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class MyClienteController implements MyClienteControllerInterface{

    @Autowired
    private OrderCreator orderCreator;
    @Autowired
    private NegozioRepository negozioRepository;
    @Autowired
    private ProdottoRepository prodottoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private LockerRepository lockerRepository;

    @Override
    public String setEmittenteOrdine(long idNegozio){
        if (this.negozioRepository.findAll().stream().noneMatch(negozioEntity -> negozioEntity.getId()==idNegozio))
            throw new NullPointerException("id negozio inesistente");
        NegozioEntity n = negozioRepository.getOne(idNegozio);
        this.orderCreator.setEmittente(n);
        return n.toString();
    }

    @Override
    public String setDestinazioneOrdine(long idLocker){
        if (this.lockerRepository.findAll().stream().noneMatch(negozioEntity -> negozioEntity.getId()==idLocker))
            throw new NullPointerException("id negozio inesistente");
        LockerEntity l = lockerRepository.getOne(idLocker);
        this.orderCreator.setDestinazione(l);
        return l.toString();
    }

    @Override
    public String setProdottoOrdine(long idProdotto, int number){
        if(this.orderCreator.getEmittente().getProdotti().stream().noneMatch(prodottoEntity -> prodottoEntity.getId()==idProdotto))
            return "nessun Prodotto con questo Id";
        ProdottoEntity prodotto = this.prodottoRepository.getOne(idProdotto);
        ProdottoEntity prodottoIn;
        if(this.orderCreator.getProdotti().stream().anyMatch(prodottoEntity -> prodottoEntity.getSerialCode()==prodotto.getSerialCode())){
            prodottoIn = this.orderCreator.getProdottoBySerialCode(prodotto.getSerialCode());
            prodottoIn.setNumero(prodottoIn.getNumero()+number);
        }else {
            prodottoIn = new ProdottoEntity(prodotto.getNome(),prodotto.getDescrizione(),prodotto.getPrezzo());
            prodottoIn.setSerialCode(prodotto.getSerialCode());
            this.orderCreator.addProdotto(prodottoIn,number);
        }
        return prodottoIn.toString();
    }

    @Override
    public List<OrdineEntity> addOrdineToCliente(long id){
        if (this.clienteRepository.findAll().stream().noneMatch(clienteEntity -> clienteEntity.getId()==id))
            throw new NullPointerException("cliente con questo id inesistente");
        ClienteEntity cliente = getClienteById(id);
        if(negozioRepository.findAll().stream().noneMatch(negozioEntity ->
                negozioEntity.getId()==orderCreator.getEmittente().getId()))
            throw new NullPointerException("negozio inesistente");
        NegozioEntity negozioEntity = this.negozioRepository.getOne(orderCreator.getEmittente().getId());
        orderCreator.getProdotti().forEach(prodottoOrdine-> {
            negozioEntity.getProdotti().stream()
                    .filter(prodottoNegozio -> prodottoNegozio.getSerialCode()==prodottoOrdine.getSerialCode())
                    .forEach(p -> p.setNumero(p.getNumero()-prodottoOrdine.getNumero()));
        });
        this.orderCreator.setEmittente(negozioEntity);
        OrdineEntity ordine = this.orderCreator.creaOrdine();
        cliente.getOrdini().add(ordine);
        this.negozioRepository.save(negozioEntity);
        this.clienteRepository.save(cliente);
        return cliente.getOrdini();
    }

    @Override
    public void addCliente(String nome, String cognome, String email, String password){
        ClienteEntity clienteEntity = new ClienteEntity(nome,cognome,email,password);
        clienteEntity.initUsername();
        this.clienteRepository.save(clienteEntity);
    }

    @Override
    public ClienteEntity getClienteById(long id){
        return this.clienteRepository.getOne(id);
    }
}
