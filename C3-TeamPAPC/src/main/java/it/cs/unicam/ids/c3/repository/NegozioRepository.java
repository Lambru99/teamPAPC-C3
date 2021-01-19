package it.cs.unicam.ids.c3.repository;

import it.cs.unicam.ids.c3.entity.NegozioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NegozioRepository extends JpaRepository<NegozioEntity,Long> {
}
