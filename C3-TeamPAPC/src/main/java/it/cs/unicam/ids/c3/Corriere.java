package it.cs.unicam.ids.c3;


import it.cs.unicam.ids.c3.chiamata.ControllerChiamata;

public class Corriere implements CorriereInterface{
        public  Corriere (String nome, String cognome, String email, Long cellulare, Boolean disposizione){
            super();
            setNome(nome);
            setCognome(cognome);
            setEmail(email);
            this.cellulare = cellulare; // Da cambiare dopo aver finito a fare il metodo del metodo
            setDisposizione(disposizione);
        }
        private String nome;
        private String cognome;
        private String email;
        private Long cellulare;
        private Boolean disposizione;
        public ControllerChiamata cChiamata = new ControllerChiamata();
    
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

    /**
     * Questi due metodi sono stati creati per il caso d'uso
     * visualizza chiamata che permette al Corriere di scegliere una chiamata
     * tra una lista di chiamate disponibili
     */
    public void visuallizzaListaChiamate(){cChiamata.visualizzaChiamate();}
    public void scegliChiamata(long index){cChiamata.scegliChiamata(index);}

    /**
     *
     *
     *
     */


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
    

