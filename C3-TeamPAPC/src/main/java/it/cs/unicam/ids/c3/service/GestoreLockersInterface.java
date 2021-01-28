package it.cs.unicam.ids.c3.service;

import it.cs.unicam.ids.c3.entity.LockerEntity;
import it.cs.unicam.ids.c3.entity.OrdineEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GestoreLockersInterface {
    List<LockerEntity> getLockers();

    LockerEntity getLockerById(long id);

    List<OrdineEntity> getOrdiniLocker(long id);

    void addOrUpdatesLocker(LockerEntity locker);
}
