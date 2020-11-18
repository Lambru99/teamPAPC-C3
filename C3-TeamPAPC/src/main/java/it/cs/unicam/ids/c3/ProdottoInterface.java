package it.cs.unicam.ids.c3;

public interface ProdottoInterface {
    public String getNome();
    public String getDescrizione();
    public double getPrezzo();
    public int getId();
    public int getNegozioId();
    public void setNome(String nome);
    public void setDescrizione(String descrizione);
    public void setPrezzo(double prezzo);
    public void setId(int id);
    public void setNegozioId(int negozioId);
}
