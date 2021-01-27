package it.cs.unicam.ids.c3.prova;


import it.cs.unicam.ids.c3.entity.ClienteEntity;
import it.cs.unicam.ids.c3.entity.NegozioEntity;
import it.cs.unicam.ids.c3.entity.OrdineEntity;
import it.cs.unicam.ids.c3.entity.ProdottoEntity;
import it.cs.unicam.ids.c3.repository.ClienteRepository;
import it.cs.unicam.ids.c3.repository.NegozioRepository;
import it.cs.unicam.ids.c3.repository.OrdineRepository;
import it.cs.unicam.ids.c3.util.ConcreteCreatoreOrdine;
import it.cs.unicam.ids.c3.util.CreatoreOrdine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProvaService {
    @Autowired
    private ClienteRepository clienteRepository;
    private CreatoreOrdine creatoreOrdine;
    @Autowired
    private NegozioRepository negozioRepository;

    public ProvaService() {
        this.creatoreOrdine = new ConcreteCreatoreOrdine();
    }

    public NegozioEntity setNegozio(long idNegozio){
        this.creatoreOrdine.setEmittente(negozioRepository.findById(idNegozio).orElseThrow(NullPointerException::new));
        return creatoreOrdine.getEmittente();
    }
    public ProdottoEntity setProdotto(long idProdotto,int numero){
        ProdottoEntity prodotto = this.creatoreOrdine.getEmittente().getProdotti().stream().filter(p->p.getId()==idProdotto)
                .findFirst().orElseThrow();
        ProdottoEntity p = new ProdottoEntity(prodotto.getNome(),prodotto.getDescrizione(),prodotto.getPrezzo());
        p.setSerialCode(prodotto.getSerialCode());
        this.creatoreOrdine.addProdotto(p,numero);
        return p;
    }
    public void addOrdineToCliente(long idCliente){
        ClienteEntity cliente = clienteRepository.findById(idCliente).orElseThrow();
        long idNegozio = creatoreOrdine.getEmittente().getId();
        //NegozioEntity n = this.negozioRepository.findById(idNegozio).orElseThrow();
        for (ProdottoEntity prodottoOrdine: creatoreOrdine.getProdotti()) {
            creatoreOrdine.getEmittente().getProdotti().stream().filter(p-> p.getSerialCode()==prodottoOrdine.getSerialCode())
                    .forEach(p -> p.setNumero(p.getNumero()-prodottoOrdine.getNumero()));
        }
        this.negozioRepository.save(creatoreOrdine.getEmittente());
        NegozioEntity n = this.negozioRepository.findById(idNegozio).orElseThrow();
        creatoreOrdine.setEmittente(n);
        OrdineEntity o = creatoreOrdine.creaOrdine();
        creatoreOrdine.setEmittente(null);
        creatoreOrdine.getProdotti().clear();
        //this.negozioRepository.saveAndFlush(n);
        cliente.getOrdini().add(o);
        this.clienteRepository.saveAndFlush(cliente);
    }

}
