package it.cs.unicam.ids.c3.corriere;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * repository che contiene una lista di tutti i corrieri registrati
 */
@Repository
public interface CorriereRepository extends JpaRepository<CorriereEntity,Long> {
}
