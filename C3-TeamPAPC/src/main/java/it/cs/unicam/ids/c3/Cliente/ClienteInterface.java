package it.cs.unicam.ids.c3.Cliente;

import it.cs.unicam.ids.c3.Ordine.OrdineInterface;

import java.util.List;

public interface ClienteInterface {
    List<OrdineInterface> getListaOrdine();

    public String getNome();
        public String getCognome();
        public String getEmail();
        public void setNome(String nome);
        public void setCognome(String cognome);
        public void setEmail(String email);
        long getCellulare();
        public void setCellulare(long cellulare);
        public long getId();
}
    
    

