package it.cs.unicam.ids.c3.locker;

import it.cs.unicam.ids.c3.ordine.StatoOrdine;
import it.cs.unicam.ids.c3.ordine.GestoreOrdiniInterface;
import it.cs.unicam.ids.c3.ordine.OrdineEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * servizio che si occupa di gestire i lockers in alcune operazioni,come la visualizzazione della lista degli ordini
 * questo servizio verrà utilizzato da altri servizi
 */
@Service
public class GestoreLockers implements GestoreLockersInterface{
    @Autowired
    private LockerRepository lockerRepository;
    @Autowired
    private GestoreOrdiniInterface gestoreOrdini;

    public GestoreLockers() {
    }

    @Override
    public List<LockerEntity> getLockers(){
        return this.lockerRepository.findAll();
    }

    /**
     * Permette di avere un locker dato il suo ID
     * @param id Id del locker da ricercare
     * @return locker che ha come id quello passato per input
     */
    @Override
    public LockerEntity getLockerById(long id){
        return this.lockerRepository.findAll().stream().filter(n -> n.getId()==id).findFirst()
                .orElseThrow(()->new NullPointerException("loker con questo id inesistente"));
    }

    @Override
    public List<OrdineEntity> getOrdiniLocker(long id){
        return gestoreOrdini.filtraOrdini(this.gestoreOrdini.getOrdini(),o->
                o.getDestinazione().getId()==id&&o.getStatoOrdine()== StatoOrdine.CONSEGNATO);
    }

    @Override
    public void addOrUpdatesLocker(LockerEntity locker){
        this.lockerRepository.save(locker);
    }

}