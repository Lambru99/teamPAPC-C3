package it.cs.unicam.ids.c3.locker;

import it.cs.unicam.ids.c3.ordine.OrdineEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controllere rest del Locker
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/lockers")
public class LockerRestController {
    @Autowired
    private GestoreLockersInterface gestoreLockers;

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
