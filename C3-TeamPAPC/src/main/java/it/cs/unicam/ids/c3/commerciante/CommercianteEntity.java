package it.cs.unicam.ids.c3.commerciante;

import it.cs.unicam.ids.c3.negozi.NegozioEntity;

import javax.persistence.*;

/**
 * Questo oggetto è uno dei tre attori del programma, il commerciante ha il compito di aggiungere il proprio negozio e propri prodotti nella piattaforma al fine di
 * poterli farli acquistare dal cliente. Una volte che proprio prodotto è stato acquistato il commerciante dovrà gestire l'ordine che ne deriva e, se necessario, chiamare un
 * corriere che porti l'ordine al locker scelto dal cliente.
 */
@Entity

@Table(name = "commercianti")
public class CommercianteEntity {
    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) long id;

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "negozio_associato",referencedColumnName = "id")
    private NegozioEntity negozio;

    public CommercianteEntity() {
    }

    public CommercianteEntity(String nome, String cognome, String email, String password) {
        this();
        this.email = email;
        this.password = password;
        this.nome = nome;
        this.cognome = cognome;
    }

    public void initUsername(){
        this.username = (this.nome+'.'+this.cognome).toLowerCase();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public NegozioEntity getNegozio() {
        return negozio;
    }

    public void setNegozio(NegozioEntity negozio) {
        this.negozio = negozio;
    }
}
