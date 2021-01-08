package it.cs.unicam.ids.c3;

import it.cs.unicam.ids.c3.Commerciante.CommercianteInterface;

import java.util.List;

public interface NegozioInterface extends PuntoRitiro{
    public void aggiungiProdotto();
    public void rimuoviProdotto();
    public Prodotto cercaProdotto();
    public String getNome();
    public void setNome(String nome);
    public void setProprietario(CommercianteInterface proprietario);
    public CommercianteInterface getProprietario();
    public List<ProdottoInterface> getProdotti();
}
