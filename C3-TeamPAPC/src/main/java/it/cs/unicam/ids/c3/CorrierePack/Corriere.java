package it.cs.unicam.ids.c3.CorrierePack;


import java.util.Random;

public class Corriere implements CorriereInterface {
    private String nome;
    private String cognome;
    private String email;
    private Long cellulare;
    private boolean disposizione;
    private String password;
    private long id;

    public Corriere(){
        this.disposizione=false;
        this.id = new Random().nextInt(999999);
    }

    public  Corriere (String nome, String cognome, String email, Long cellulare,String password){
        this();
        setPassword(password);
        setNome(nome);
        setCognome(cognome);
        setEmail(email);
        setCellulare(cellulare);
    }
    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String  getNome(){
        return this.nome;
    }
    @Override
    public String getCognome(){
        return this.cognome;
    }
    @Override
    public String getEmail(){
        return this.email;
    }
    @Override
    public long getCellulare(){
        return this.cellulare;
    }
    @Override
    public boolean getDisposizione(){
        return this.disposizione;
    }
    @Override
    public void setNome(String nome){
        this.nome = nome;
    }
    @Override
    public void setCognome(String cognome){
        this.cognome = cognome;
    }
    @Override
    public void setEmail(String email){
        this.email = email;
    }
    @Override
    public void setCellulare(long cellulare){
        this.cellulare = cellulare;
    }
    @Override
    public void setDisposizione(){
        this.disposizione= !this.disposizione;
    }

}
    

