package it.cs.unicam.ids.c3.repository;

import it.cs.unicam.ids.c3.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * repository che contiene una lista di tutti i clienti registrati
 */
@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity,Long> {
}
