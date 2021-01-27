package it.cs.unicam.ids.c3.service;

import it.cs.unicam.ids.c3.entity.LockerEntity;
import it.cs.unicam.ids.c3.entity.OrdineEntity;
import it.cs.unicam.ids.c3.entity.StatoOrdine;
import it.cs.unicam.ids.c3.repository.LockerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * servizio che si occupa di gestire i lockers in alcune operazioni,come la visualizzazione della lista degli ordini
 * questo servizio verrà utilizzato da altri servizi
 */
@Service
public class GestoreLockers {
    @Autowired
    private LockerRepository lockerRepository;
    @Autowired
    private GestoreOrdini gestoreOrdini;

    public GestoreLockers() {
    }

    public List<LockerEntity> getLockers(){
        return this.lockerRepository.findAll();
    }

    public LockerEntity getLockerById(long id){
        return this.lockerRepository.findAll().stream().filter(n -> n.getId()==id).findFirst()
                .orElseThrow(()->new NullPointerException("loker con questo id inesistente"));
    }

    public List<OrdineEntity> getOrdiniLocker(long id){
        return gestoreOrdini.filtraOrdini(this.gestoreOrdini.getOrdini(),o->
                o.getDestinazione().getId()==id&&o.getStatoOrdine()== StatoOrdine.CONSEGNATO);
    }
}