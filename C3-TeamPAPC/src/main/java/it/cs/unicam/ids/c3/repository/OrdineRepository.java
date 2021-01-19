package it.cs.unicam.ids.c3.repository;

import it.cs.unicam.ids.c3.entity.OrdineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdineRepository extends JpaRepository<OrdineEntity,Long> {
}
