package it.cs.unicam.ids.c3.NegozioPack;

import it.cs.unicam.ids.c3.ProdottoPack.Prodotto;
import it.cs.unicam.ids.c3.ProdottoPack.ProdottoInterface;
import it.cs.unicam.ids.c3.RitiroPack.PuntoRitiro;

import java.util.List;

public interface NegozioInterface extends PuntoRitiro {
    public void aggiungiProdotto();
    public void rimuoviProdotto();
    public Prodotto cercaProdotto();
    public String getNome();
    public void setNome(String nome);
    public List<ProdottoInterface> getProdotti();
}
