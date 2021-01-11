package it.cs.unicam.ids.c3.Ordine;

import it.cs.unicam.ids.c3.Negozio.NegozioInterface;
import it.cs.unicam.ids.c3.Prodotto;
import it.cs.unicam.ids.c3.ProdottoInterface;
import it.cs.unicam.ids.c3.PuntoRitiro;
import it.cs.unicam.ids.c3.chiamata.Chiamata;
import it.cs.unicam.ids.c3.chiamata.ControllerChiamata;

import java.util.Collections;
import java.util.List;

public class OrdineController {
    private List<Ordine> listaOrdine;

    public List<ProdottoInterface> prodotti;

    public void creaOrdine(NegozioInterface emittente){
        Ordine ordine = new Ordine(emittente);
        Collections.addAll(ordine.getProdotti(),this.prodotti.toArray(ProdottoInterface[]::new));
    }
    public void creaOrdine(PuntoRitiro destinazione, NegozioInterface emittente){
        Ordine ordine = new Ordine(destinazione,emittente);
        Collections.addAll(ordine.getProdotti(),this.prodotti.toArray(ProdottoInterface[]::new));
    }
    public List<ProdottoInterface> addProdotto(Prodotto prodotto){
        this.prodotti.add(prodotto);
        return this.prodotti;
    }

    public void addOrdine(Ordine ordine){
        PuntoRitiro filtOrdine = ordine.getPuntoRitiro();
        if (filtOrdine != null){
        listaOrdine.add(ordine);
        }
    }

    public String printOrdini(){
        return listaOrdine.toString();
    }

    public void preparaChiamata(long id){
        Chiamata chiamata = new Chiamata(getOrdineByID(id));
        ControllerChiamata cChiamata = new ControllerChiamata();
        cChiamata.aggiungiChiamata(chiamata);
        listaOrdine.remove(getOrdineByID(id));
    }

    public Ordine getOrdineByID(long id){
    return listaOrdine.stream().filter(ordine -> ordine.getId()==id).findFirst().orElseThrow(NullPointerException::new);
    }

}
