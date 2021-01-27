package it.cs.unicam.ids.c3.repository;

import it.cs.unicam.ids.c3.entity.LockerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * repository che contiene una lista di tutti i locker registrati
 */
@Repository
public interface LockerRepository extends JpaRepository<LockerEntity,Long> {

}
