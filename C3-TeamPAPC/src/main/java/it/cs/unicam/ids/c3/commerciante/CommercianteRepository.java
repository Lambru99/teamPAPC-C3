package it.cs.unicam.ids.c3.commerciante;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * repository che contiene una lista di tutti i commercianti registrati
 */
@Repository
public interface CommercianteRepository extends JpaRepository<CommercianteEntity,Long> {
}