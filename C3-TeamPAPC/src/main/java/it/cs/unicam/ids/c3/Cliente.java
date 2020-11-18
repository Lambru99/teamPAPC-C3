package it.cs.unicam.ids.c3;

public class Cliente implements ClienteInterface {
    public  Cliente (String nome, String cognome, String email, Long cellulare, String indirizzo){
        super();
        this.nome = nome;
        this.cognome = cognome;
        this.email= email;
        this.cellulare = cellulare;
        this.indirizzo = indirizzo;
    }
    private String nome;
    private String cognome;
    private String email;
    private Long cellulare;
    private String indirizzo;

    public Cliente(){}


    public String  getNome(){
         return this.nome;
    }
    public String getCognome(){
        return this.cognome;
    }
    public String getEmail(){
        return this.email;
    }
    public Long getCellulare(){
        return this.cellulare;
    }
    public String getIndirizzo(){
        return this.indirizzo;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setCognome(String cognome){
        this.cognome = cognome;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setCellulare(Long cellulare){
        this.cellulare = cellulare;
    }
    public void setIndirizzo(String indirizzo){
        this.indirizzo = indirizzo;
    }

    @Override
    public Long getClellulare() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setcellulare(Long cellulare) {
        // TODO Auto-generated method stub

    }
    
}
