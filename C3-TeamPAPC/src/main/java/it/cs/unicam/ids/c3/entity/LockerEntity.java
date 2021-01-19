package it.cs.unicam.ids.c3.entity;


import it.cs.unicam.ids.c3.RitiroPack.PuntoRitiro;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "lockers")
public class LockerEntity implements PuntoRitiro {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "indirizzo")
    private String indirizzo;
    @Column(name = "orario")
    private String orario;
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrdineEntity> ordini;

    public LockerEntity() {
        this.ordini = new ArrayList<>();
    }

    public LockerEntity(String nome, String indirizzo, String orario) {
        this();
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.orario = orario;
    }

    public long getId() {
        return id;
    }

    @Override
    public String getIndirizzo() {
        return this.indirizzo;
    }

    @Override
    public String getOrario() {
        return this.orario;
    }

    @Override
    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    @Override
    public void setOrario(String orario) {
        this.orario = orario;
    }

    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public List<OrdineEntity> getOrdini() {
        return this.ordini;
    }

}