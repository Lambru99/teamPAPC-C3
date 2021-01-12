package it.cs.unicam.ids.c3.Corriere;


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

        public String getPassword() {
        return password;
    }
        public void setPassword(String password) {
        this.password = password;
    }
        public String  getNome(){
             return this.nome;
        }
        public String getCognome(){
            return this.cognome;
        }
        public String getEmail(){
            return this.email;
        }
        public long getCellulare(){
            return this.cellulare;
        }
        public Boolean getDisposizione(){
            return this.disposizione;
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
        public void setCellulare(long cellulare){
            this.cellulare = cellulare;
        }
        public void setDisposizione(){
            this.disposizione= !this.disposizione;
        }


    
    }
    

