package it.cs.unicam.ids.c3.cliente;

import it.cs.unicam.ids.c3.ordine.OrdineEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Questo oggetto è uno dei tre attori del programma, il cliente ha il compito di scegliere un negozio da cui acquistare, un prodotto da acquistare
 * e attendere che il prodotto sia pronto da ritirare. Esso può scegliere due punti di ritiro quali : Ritirare al negozio o ritirare in locker.
 */
@Entity

@Table(name = "clienti")
public class ClienteEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cognome")
    private String cognome;

    @Column(name = "username")
    private String username;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_cliente",referencedColumnName = "id")
    private List<OrdineEntity> ordini;

    public ClienteEntity() {
        this.ordini = new ArrayList<>();
    }

    public ClienteEntity(String nome, String cognome, String email, String password) {
        this();
        this.email = email;
        this.password = password;
        this.nome = nome;
        this.cognome = cognome;
    }

    public void initUsername(){
        this.username = (this.nome+'.'+this.cognome).toLowerCase();
    }

    public List<OrdineEntity> getOrdini() {
        return ordini;
    }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String name) {
        this.nome = name;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String surname) {
        this.cognome = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

