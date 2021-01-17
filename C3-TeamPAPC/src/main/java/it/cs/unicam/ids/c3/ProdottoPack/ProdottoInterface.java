package it.cs.unicam.ids.c3.ProdottoPack;

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
    void setNumero(int numero);
    int getNumero();
}
