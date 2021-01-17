package it.cs.unicam.ids.c3.CommerciantePack;

import it.cs.unicam.ids.c3.NegozioPack.NegozioInterface;
import it.cs.unicam.ids.c3.ProdottoPack.ProdottoInterface;

import java.util.List;

public interface CommercianteInterface {
    List<ProdottoInterface> getProdotti();

    void setProdotti(List<ProdottoInterface> prodotti);

    String getNome();

    void setNome(String nome);

    String getCognome();

    void setCognome(String cognome);

    String getEmail();

    void setEmail(String email);

    NegozioInterface getNegozio();


    long getCellulare();

    void setCellulare(long cellulare);

    String getPassword();

    void setPassword(String password);
}
