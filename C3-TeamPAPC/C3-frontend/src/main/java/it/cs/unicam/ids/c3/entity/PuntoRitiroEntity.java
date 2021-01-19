package it.cs.unicam.ids.c3.entity;

import java.util.List;

public interface PuntoRitiroEntity {
    String getIndirizzo();
    String getOrario();
    String getNome();
    List<OrdineEntity> getOrdini();
}
