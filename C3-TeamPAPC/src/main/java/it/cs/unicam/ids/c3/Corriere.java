package it.cs.unicam.ids.c3;


    public class Corriere implements CorriereInterface{
        public  Corriere (String nome, String cognome, String email, Long cellulare, Boolean disposizione){
            super();
            this.nome = nome;
            this.cognome = cognome;
            this.email= email;
            this.cellulare = cellulare;
            this.disposizione = disposizione;
        }
        private String nome;
        private String cognome;
        private String email;
        private Long cellulare;
        private Boolean disposizione;
    
        public Corriere(){}
    

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
        public void setCellulare(Long cellulare){
            this.cellulare = cellulare;
        }
        public void setDisposizione(Boolean disposizione){
            this.disposizione = disposizione;
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
    

