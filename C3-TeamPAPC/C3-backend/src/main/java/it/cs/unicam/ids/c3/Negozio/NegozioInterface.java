package it.cs.unicam.ids.c3.Negozio;

import it.cs.unicam.ids.c3.Commerciante.CommercianteInterface;
import it.cs.unicam.ids.c3.Prodotto.Prodotto;
import it.cs.unicam.ids.c3.Prodotto.ProdottoInterface;
import it.cs.unicam.ids.c3.Ritiro.PuntoRitiro;

import java.util.List;

public interface NegozioInterface extends PuntoRitiro {
    public void aggiungiProdotto();
    public void rimuoviProdotto();
    public Prodotto cercaProdotto();
    public String getNome();
    public void setNome(String nome);
    public List<ProdottoInterface> getProdotti();
}