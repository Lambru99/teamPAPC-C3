package it.cs.unicam.ids.c3.Commerciante;

import java.util.Random;

public class Commerciante implements CommercianteInterface {
    private String nome;
    private String cognome;
    private String email;
    private String negozio;
    private long cellulare;
    private String password;
    private long id;

    public Commerciante(){
        this.id = new Random().nextInt(999999);
    }

    public Commerciante(String nome, String cognome, String email, String negozio, long cellulare, String password) {
        super();
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.negozio = negozio;
        this.cellulare = cellulare;
        this.password = password;
    }

    @Override
    public String getNome() {
        return nome;
    }
    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }
    @Override
    public String getCognome() {
        return cognome;
    }
    @Override
    public void setCognome(String cognome) {
        this.cognome = cognome;
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
    public String getNegozio() {
        return negozio;
    }
    @Override
    public void setNegozio(String negozio) {
        this.negozio = negozio;
    }
    @Override
    public long getCellulare() {
        return cellulare;
    }
    @Override
    public void setCellulare(long cellulare) {
        this.cellulare = cellulare;
    }
    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public void setPassword(String password) {
        this.password = password;
    }
}
