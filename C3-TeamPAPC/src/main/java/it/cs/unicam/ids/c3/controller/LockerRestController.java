package it.cs.unicam.ids.c3.controller;

import it.cs.unicam.ids.c3.entity.LockerEntity;
import it.cs.unicam.ids.c3.entity.OrdineEntity;
import it.cs.unicam.ids.c3.service.GestoreLockers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/lockers")
public class LockerRestController {
    @Autowired
    private GestoreLockers gestoreLockers;

    public LockerRestController() {
    }

    @GetMapping
    public List<LockerEntity> getLockers(){
        return this.gestoreLockers.getLockers();
    }

    @GetMapping("/{id}/ordini")
    public List<OrdineEntity> getOrdiniInLocker(@PathVariable long id){
        return this.gestoreLockers.getOrdiniLocker(id);
    }

}
