package it.cs.unicam.ids.c3.Commerciante;

import it.cs.unicam.ids.c3.Negozio.Negozio;
import it.cs.unicam.ids.c3.Negozio.NegozioInterface;
import it.cs.unicam.ids.c3.Prodotto.ProdottoInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Commerciante implements CommercianteInterface {
    private String nome;
    private String cognome;
    private String email;
    private NegozioInterface negozio;
    private long cellulare;
    private String password;
    private long id;
    private List<ProdottoInterface>prodotti;

    public Commerciante(){
        this.id = new Random().nextInt(999999);
        prodotti=new ArrayList<>();
    }

    public Commerciante(String nome, String cognome, String email, long cellulare, String password) {
        super();
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.cellulare = cellulare;
        this.password = password;
    }
    @Override
    public List<ProdottoInterface> getProdotti() {
        return prodotti;
    }
    @Override
    public void setProdotti(List<ProdottoInterface> prodotti) {
        this.prodotti = prodotti;
    }

    @Override
    public String getNome() {
        return nome;
    }
    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }
    @Override
    public String getCognome() {
        return cognome;
    }
    @Override
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    @Override
    public String getEmail() {
        return email;
    }
    @Override
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public NegozioInterface getNegozio() {
        return negozio;
    }

    public void setNegozio(String nomeNegozio,String indirizzoNegozio,String orario,long recapito) {
        this.negozio= new Negozio(nomeNegozio,indirizzoNegozio,orario,recapito,
                this.id,getNome(),getCognome(),getEmail(),prodotti);
    }
    @Override
    public long getCellulare() {
        return cellulare;
    }
    @Override
    public void setCellulare(long cellulare) {
        this.cellulare = cellulare;
    }
    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public void setPassword(String password) {
        this.password = password;
    }
}
