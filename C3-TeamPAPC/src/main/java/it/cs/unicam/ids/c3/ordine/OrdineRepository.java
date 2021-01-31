package it.cs.unicam.ids.c3.ordine;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * repository che contiene una lista di tutti gl'ordini registrati
 */
@Repository
public interface OrdineRepository extends JpaRepository<OrdineEntity,Long> {
}
