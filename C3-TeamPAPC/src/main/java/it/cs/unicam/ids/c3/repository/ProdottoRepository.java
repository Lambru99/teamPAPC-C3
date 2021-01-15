package it.cs.unicam.ids.c3.repository;

import it.cs.unicam.ids.c3.entity.ProdottoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdottoRepository extends JpaRepository<ProdottoEntity,Long> {
}