package it.cs.unicam.ids.c3;

public class Commerciante implements CommercianteInterface{
    private String nome;
    private String cognome;
    private String email;
    private String negozio;
    private long cellulare;

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return this.cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNegozio() {
        return this.negozio;
    }

    public void setNegozio(String negozio) {
        this.negozio = negozio;
    }

    public long getCellulare() {
        return this.cellulare;
    }

    public void setCellulare(long cellulare) {
        this.cellulare = cellulare;
    }

    @Override
    public void aggiungiProdotto() {

    }

    @Override
    public void rimuoviProdotto() {

    }

    @Override
    public void modificaProdotto() {

    }

    @Override
    public void visualizzaProdotto() {

    }

    @Override
    public void visualizzaOrdine() {

    }

    @Override
    public void confermaOrdine() {

    }

    @Override
    public void chiamaCorriere() {

    }

    
}
