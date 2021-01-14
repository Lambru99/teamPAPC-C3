package it.cs.unicam.ids.c3.Cliente;

import it.cs.unicam.ids.c3.Ordine.OrdineInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cliente implements ClienteInterface {

    private String nome;
    private String cognome;
    private String email;
    private long cellulare;
    private final long id;
    private String password;
    private List<OrdineInterface> listaOrdine;


    public Cliente(){
        this.id = new Random().nextInt(999999);
        this.listaOrdine=new ArrayList<>();
    }

    public Cliente(String nome, String cognome, String email,String password) {
        this();
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        setPassword(password);
    }

    public Cliente (String nome, String cognome, String email, Long cellulare){
        this();
        this.nome = nome;
        this.cognome = cognome;
        this.email= email;
        this.cellulare = cellulare;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public List<OrdineInterface> getListaOrdine() {
        return listaOrdine;
    }

    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public String getCognome() {
        return this.cognome;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public long getCellulare() {
        return this.cellulare;
    }

    @Override
    public void setCellulare(long cellulare) {

    }


}
