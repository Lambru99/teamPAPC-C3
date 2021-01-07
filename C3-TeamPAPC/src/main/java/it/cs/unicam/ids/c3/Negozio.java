package it.cs.unicam.ids.c3;

import it.cs.unicam.ids.c3.Commerciante.CommercianteInterface;

import java.util.List;

public class Negozio implements NegozioInterface {

    private String nome;
    private String indirizzo;
    private String orario;
    private long recapito;
    private CommercianteInterface proprietario;
    private List<ProdottoInterface> prodotti;

    @Override
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
    public void setOrario(String orario) {
        this.orario = orario;
    }

    @Override
    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public long getRecapito() {
        return this.recapito;
    }

    public void setRecapito(long recapito) {
        this.recapito = recapito;
    }

    @Override
    public CommercianteInterface getProprietario() {
        return this.proprietario;
    }

    @Override
    public void setProprietario(CommercianteInterface proprietario) {
        this.proprietario = proprietario;
    }

    @Override
    public List<ProdottoInterface> getProdotti() {
        return this.prodotti;
    }

    public void setProdotti(List<ProdottoInterface> prodotti) {
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
