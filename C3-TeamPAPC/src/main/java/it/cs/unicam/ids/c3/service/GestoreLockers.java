package it.cs.unicam.ids.c3.service;

import it.cs.unicam.ids.c3.entity.LockerEntity;
import it.cs.unicam.ids.c3.repository.LockerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GestoreLockers {
    @Autowired
    private LockerRepository lockerRepository;

    public GestoreLockers() {
    }

    public LockerEntity getLockerById(long id){
        return this.lockerRepository.findAll().stream().filter(n -> n.getId()==id).findFirst()
                .orElseThrow(()->new NullPointerException("loker con questo id inesistente"));
    }
}