package it.cs.unicam.ids.c3.repository;

import it.cs.unicam.ids.c3.entity.NegozioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * repository che contiene una lista di tutti i negozi registrati
 */
@Repository
public interface NegozioRepository extends JpaRepository<NegozioEntity,Long> {
}
