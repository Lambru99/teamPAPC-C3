package it.cs.unicam.ids.c3.chiamata;


public class Chiamata implements ControllerChiamataInterface{
    private String info;
    private long id;
    private String stato;

    public Chiamata(String info, long id ) {
        setInfo(info);
        setId(id);
        this.stato="in sospeso";
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
