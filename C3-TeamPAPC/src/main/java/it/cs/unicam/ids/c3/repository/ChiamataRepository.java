package it.cs.unicam.ids.c3.repository;

import it.cs.unicam.ids.c3.entity.ChiamataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * repository che contiene una lista di tutti le chiamate registrati
 */
@Repository
public interface ChiamataRepository extends JpaRepository<ChiamataEntity,Long> {
}