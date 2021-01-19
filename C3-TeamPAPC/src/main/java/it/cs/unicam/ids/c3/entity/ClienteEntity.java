package it.cs.unicam.ids.c3.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clienti")
public class ClienteEntity implements ClienteEntityInterface{
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) long id;
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
    @Override
    public List<OrdineEntity> getOrdini() {
        return ordini;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String getNome() {
        return nome;
    }
    @Override
    public void setNome(String name) {
        this.nome = name;
    }
    @Override
    public String getCognome() {
        return cognome;
    }
    @Override
    public void setCognome(String surname) {
        this.cognome = surname;
    }
    @Override
    public String getUsername() {
        return username;
    }
    @Override
    public void setUsername(String username) {
        this.username = username;
    }
}
