package it.cs.unicam.ids.c3.NegozioPack;

import it.cs.unicam.ids.c3.ProdottoPack.Prodotto;
import it.cs.unicam.ids.c3.ProdottoPack.ProdottoInterface;
import it.cs.unicam.ids.c3.entity.OrdineEntity;

import java.util.List;

public class Negozio implements NegozioInterface {

    private String nome;
    private String indirizzo;
    private String orario;
    private long recapito;
    private long idProprietario;
    private List<ProdottoInterface> prodotti;
    private String nomeCommerciante;
    private String cognomeCommerciante;
    private String emailCommerciante;

    public Negozio(){

    }

    public Negozio(String nome, String indirizzo, String orario, long recapito, long idProprietario, String nomeCommerciante,
                   String cognomeCommerciante,String emailCommerciante,List<ProdottoInterface> prodotti) {
        super();
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.orario = orario;
        this.recapito = recapito;
        this.idProprietario = idProprietario;
        this.nomeCommerciante=nomeCommerciante;
        this.cognomeCommerciante=cognomeCommerciante;
        this.emailCommerciante=emailCommerciante;
        this.prodotti = prodotti;
    }

    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public List<OrdineEntity> getOrdini() {
        return null;
    }

    @Override
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
    public List<ProdottoInterface> getProdotti() {
        return this.prodotti;
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
