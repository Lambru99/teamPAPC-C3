package it.cs.unicam.ids.c3.RitiroPack;

import it.cs.unicam.ids.c3.entity.OrdineEntity;

import java.util.List;

public interface PuntoRitiro {
    String getIndirizzo();
    String getOrario();
    void setIndirizzo(String indirizzo);
    void setOrario(String orario);

    String getNome();

    List<OrdineEntity> getOrdini();
}
