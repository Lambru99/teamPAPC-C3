package it.cs.unicam.ids.c3.ClientePack;

import it.cs.unicam.ids.c3.OrdinePack.OrdineInterface;

import java.util.List;

public interface ClienteInterface {
    List<OrdineInterface> getListaOrdine();
    String getNome();
    String getCognome();
    String getEmail();
    void setNome(String nome);
    void setCognome(String cognome);
    void setEmail(String email);
    long getCellulare();
    void setCellulare(long cellulare);
    long getId();
}
    
    

