package it.cs.unicam.ids.c3;

import java.util.List;

public class Negozio implements NegzioInterface {

    private String nome;
    private String indirizzo;
    private long recapito;
    private Commerciante proprietario;
    private List<Prodotto> prodotti;

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIndirizzo() {
        return this.indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public long getRecapito() {
        return this.recapito;
    }

    public void setRecapito(long recapito) {
        this.recapito = recapito;
    }

    public Commerciante getProprietario() {
        return this.proprietario;
    }

    public void setProprietario(Commerciante proprietario) {
        this.proprietario = proprietario;
    }

    public List<Prodotto> getProdotti() {
        return this.prodotti;
    }

    public void setProdotti(List<Prodotto> prodotti) {
        this.prodotti = prodotti;
    }

    @Override
    public void aggiungiProdotto() {

    }

    @Override
    public void rimuoviProdotto() {

    }

    @Override
    public Prodotto cercaProdotto() {
        return null;
    }
    
}
