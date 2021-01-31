package it.cs.unicam.ids.c3.prodotti;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * repository che contiene una lista di tutti i prodotti registrati
 */
@Repository
public interface ProdottoRepository extends JpaRepository<ProdottoEntity,Long> {
}