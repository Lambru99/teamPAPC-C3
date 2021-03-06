package it.cs.unicam.ids.c3.corriere;

import it.cs.unicam.ids.c3.chiamate.GestoreChiamateInterface;
import it.cs.unicam.ids.c3.ordine.GestoreOrdiniInterface;
import it.cs.unicam.ids.c3.ordine.OrdineEntity;
import it.cs.unicam.ids.c3.ordine.StatoOrdine;
import it.cs.unicam.ids.c3.chiamate.ChiamataEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.function.Predicate;

/**
 * servizio che permette di gestire le operazioni di un corriere
 */
@Service
public class CorriereService implements CorriereServiceInterface{
    @Autowired
    private CorriereRepository corriereRepository;
    @Autowired
    private GestoreChiamateInterface gestoreChiamate;
    @Autowired
    private GestoreOrdiniInterface gestoreOrdini;

    public CorriereService() {
    }

    /**
     * permette di visualizzare tutte le chimate disponibili
     * @return chiamate disponibili
     */
    @Override
    public List<ChiamataEntity> getChiamate(){
        return this.gestoreChiamate.getChiamate();
    }

    /**
     * permette di accettare una chiamata da parte di un corriere
     * @param id id del corriere che deve accettare la chiamata
     * @param idChiamata id della chiamata da accettare
     */
    @Override
    public void accettaChiamata(long id, long idChiamata){
        CorriereEntity corriere = getCorriereById(id);
        ChiamataEntity chiamata = this.gestoreChiamate.getChiamataById(idChiamata);
        corriere.getOrdini().add(chiamata.getOrdine());
        this.gestoreChiamate.deleteChiamataById(idChiamata);
        this.corriereRepository.save(corriere);
    }

    /**
     * usando il servizio associato agli ordini, permette ad un corriere di ottenere le informazioni di un ordine
     * associato ad un id
     * @param id del corriere
     * @param idOrdine dell'ordine da cui ottenere le informazioni
     * @return le informazioni dell'ordine
     */
    @Override
    public String getInfoOrdine(long id,long idOrdine){
        if(getOrdini(id,ordineEntity -> true).stream().noneMatch(o->o.getId()==idOrdine))return null;
        else return this.gestoreOrdini.getInformazioni(idOrdine);
    }

    /**
     * permette di cambiare lo stato dell'ordine da parte di un corriere usando il servizio GestoreOrdini
     * @param id del corriere
     * @param idOrdine dell'ordine a cui cambiare stato
     * @param stato stato da settare
     */
    @Override
    public void cambiaStatoOrdine(long id, long idOrdine, StatoOrdine stato){
        if(stato.equals(StatoOrdine.IN_TRASPORTO)) controlloPerRitiro(id,idOrdine);
        if (stato.equals(StatoOrdine.CONSEGNATO)) controlloPerConsegna(id,idOrdine);
    }

    private void controlloPerRitiro(long id, long idOrdine){
        if (getOrdini(id,o->o.getStatoOrdine()==StatoOrdine.ESEGUITO).stream().anyMatch(o->o.getId()==idOrdine))
            this.gestoreOrdini.cambiaStatoOrdine(idOrdine,StatoOrdine.IN_TRASPORTO);
        else throw new NullPointerException("nessun ordine con questo id o pronto per essere ritirato");
    }

    private void controlloPerConsegna(long id, long idOrdine){
        if (getOrdini(id,o->o.getStatoOrdine()==StatoOrdine.IN_TRASPORTO).stream().anyMatch(o->o.getId()==idOrdine))
            this.gestoreOrdini.cambiaStatoOrdine(idOrdine,StatoOrdine.CONSEGNATO);
        else throw new NullPointerException("nessun ordine con questo id o pronto per essere consegnato");
    }

    @Override
    public CorriereEntity getCorriereById(long id){
        return this.corriereRepository.findById(id)
                .orElseThrow(() -> new NullPointerException("corriere con questo id inesistente"));
    }

    @Override
    public List<CorriereEntity> getCorrieri(){
        return this.corriereRepository.findAll();
    }

    @Override
    public List<OrdineEntity> getOrdini(long id, Predicate<OrdineEntity> predicate){
        return this.gestoreOrdini.filtraOrdini(getCorriereById(id).getOrdini(),predicate);
    }
}
