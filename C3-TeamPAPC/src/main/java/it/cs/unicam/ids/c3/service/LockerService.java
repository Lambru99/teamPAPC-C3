package it.cs.unicam.ids.c3.service;

import it.cs.unicam.ids.c3.entity.LockerEntity;
import it.cs.unicam.ids.c3.entity.OrdineEntity;
import it.cs.unicam.ids.c3.repository.LockerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LockerService {
    @Autowired
    private LockerRepository lockerRepository;
    @Autowired
    private GestoreOrdini gestoreOrdini;

    public LockerService() {
    }

    public List<LockerEntity> getLockers(){
        return this.lockerRepository.findAll();
    }

    public LockerEntity getLockerById(long id){
        return this.lockerRepository.findById(id).orElseThrow(()
                -> new NullPointerException("nessun locker con questo id"));
    }

    public List<OrdineEntity> getOrdiniLocker(long id){
        return gestoreOrdini.filtraOrdini(this.gestoreOrdini.getOrdini(),o->o.getDestinazione().getId()==id);
    }
}
