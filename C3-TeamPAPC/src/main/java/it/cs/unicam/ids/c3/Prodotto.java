package it.cs.unicam.ids.c3;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Random;

public class Prodotto implements ProdottoInterface{
    //in teoria questo id sarà creato automaticamente nel db
    private @Id @GeneratedValue int id;
    private int negozioId;
    private String nome;
    private String descrizione;
    private double prezzo;
    private long serialCode;

    public Prodotto(){
        this.serialCode= new Random().nextInt(999999999);
    }


    public Prodotto(String nome, String descrizione,double prezzo){
        this();
        this.nome = nome;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
    }

    @Override
    public long getSerialCode() {
        return serialCode;
    }

    @Override
    public void setSerialCode(long serialCode) {
        this.serialCode = serialCode;
    }

    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public String getDescrizione() {
        return this.descrizione;
    }

    @Override
    public double getPrezzo() {
        return this.prezzo;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public int getNegozioId() {
        return this.negozioId;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    @Override
    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void setNegozioId(int negozioId) {
        this.negozioId = negozioId;
    }

}
