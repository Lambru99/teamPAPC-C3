package it.cs.unicam.ids.c3.Prodotto;

public interface ProdottoInterface {
    String getNome();
    String getDescrizione();
    double getPrezzo();
    int getId();
    int getNegozioId();
    void setNome(String nome);
    void setDescrizione(String descrizione);
    void setPrezzo(double prezzo);
    void setId(int id);
    void setNegozioId(int negozioId);
    long getSerialCode();
    void setSerialCode(long serialCode);
}
