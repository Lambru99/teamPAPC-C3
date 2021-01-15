package it.cs.unicam.ids.c3.entity;

import it.cs.unicam.ids.c3.Negozio.NegozioInterface;
import it.cs.unicam.ids.c3.Ordine.OrdineInterface;
import it.cs.unicam.ids.c3.Ritiro.PuntoRitiro;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@Entity
@Table(name = "ordini")
public class OrdineEntity implements OrdineInterface {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "numero_ordine")
    private long numeroOrdine;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "destinazione_id",referencedColumnName = "id")
    private LockerEntity destinazione;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "emittente_id",referencedColumnName = "id")
    private NegozioEntity emittente;
    @OneToMany(cascade = CascadeType.ALL)
    private List<ProdottoEntity> prodotti;
    @Column(name = "soldi")
    private double soldi;
    @Column(name = "stato")
    @Enumerated
    private StatoOrdine statoOrdine;

    public OrdineEntity() {
        this.numeroOrdine = new Random().nextInt(99999999);
        this.prodotti = new ArrayList<>();
        this.soldi = 0;
        this.emittente= null;
        this.destinazione =null;
        this.statoOrdine = StatoOrdine.ESEGUITO;
    }

    public OrdineEntity(NegozioEntity emittente){
        this();
        this.emittente = emittente;
    }

    public OrdineEntity(LockerEntity destinazione, NegozioEntity emittente) {
        this(emittente);
        this.destinazione = destinazione;
    }

    @Override
    public StatoOrdine getStatoOrdine() {
        return statoOrdine;
    }
    @Override
    public void setSoldi(double soldi) {
        this.soldi = soldi;
    }
    @Override
    public void setStatoOrdine(StatoOrdine statoOrdine) {
        this.statoOrdine = statoOrdine;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void calcoloSoldi(){
        for (ProdottoEntity o : this.prodotti) {
            this.soldi +=o.getNumero()*o.getPrezzo();
        }
    }
    @Override
    public long getNumeroOrdine() {
        return numeroOrdine;
    }
    @Override
    public void setNumeroOrdine(long numeroOrdine) {
        this.numeroOrdine = numeroOrdine;
    }
    @Override
    public PuntoRitiro getDestinazione() {
        return destinazione;
    }
    @Override
    public void setDestinazione(PuntoRitiro destinazione) {
        this.destinazione = (LockerEntity) destinazione;
    }
    @Override
    public NegozioInterface getEmittente() {
        return emittente;
    }
    @Override
    public void setEmittente(NegozioEntity emittente) {
        this.emittente = emittente;
    }
    @Override
    public List<ProdottoEntity> getProdotti() {
        return prodotti;
    }
    @Override
    public void setProdotti(List<ProdottoEntity> prodotti) {
        this.prodotti.addAll(prodotti);
    }
    @Override
    public double getSoldi() {
        return soldi;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdineEntity ordine = (OrdineEntity) o;
        return id == ordine.id && numeroOrdine == ordine.numeroOrdine && Double.compare(ordine.soldi, soldi) == 0 && Objects.equals(destinazione, ordine.destinazione) && Objects.equals(emittente, ordine.emittente) && Objects.equals(prodotti, ordine.prodotti);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, numeroOrdine, destinazione, emittente, prodotti, soldi);
    }
    @Override
    public String toString() {
        return "Ordine{" +
                "id=" + getId() +
                ", numeroOrdine=" + getNumeroOrdine() +
                ", destinazione=" + getDestinazione().toString() +
                ", emittente=" + getEmittente().toString() +
                ", prodotti=" + getProdotti() +
                ", soldi=" + getSoldi() +
                ", stato=" + getStatoOrdine().toString() +
                '}';
    }
    @Override
    public void setId(long id) {
        this.id = id;
    }
}

