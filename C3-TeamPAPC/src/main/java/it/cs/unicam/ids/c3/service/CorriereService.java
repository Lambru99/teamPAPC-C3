package it.cs.unicam.ids.c3.service;

import it.cs.unicam.ids.c3.entity.ChiamataEntity;
import it.cs.unicam.ids.c3.entity.CorriereEntity;
import it.cs.unicam.ids.c3.entity.OrdineEntity;
import it.cs.unicam.ids.c3.entity.StatoOrdine;
import it.cs.unicam.ids.c3.repository.CorriereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.function.Predicate;

@Service
public class CorriereService {
    @Autowired
    private CorriereRepository corriereRepository;
    @Autowired
    private GestoreChiamate gestoreChiamate;
    @Autowired
    private GestoreOrdini gestoreOrdini;

    public CorriereService() {
    }

    public List<ChiamataEntity> getChiamate(){
        return this.gestoreChiamate.getChiamate();
    }

    public void accettaChiamata(long id, long idChiamata){
        CorriereEntity corriere = getCorriereById(id);
        ChiamataEntity chiamata = this.gestoreChiamate.getChiamataById(idChiamata);
        corriere.getOrdini().add(chiamata.getOrdine());
        this.gestoreChiamate.deleteChiamataById(idChiamata);
        updateCorriere(corriere);
    }

    public String getInfoOrdine(long id,long idOrdine){
        if(getOrdini(id,ordineEntity -> true).stream().noneMatch(o->o.getId()==idOrdine))return null;
        else return this.gestoreOrdini.getInformazioni(idOrdine);
    }

    public void cambiaStatoOrdine(long id,long idOrdine,StatoOrdine stato){
        if (getCorriereById(id).getOrdini().stream().anyMatch(o->o.getId()==idOrdine))
            this.gestoreOrdini.cambiaStatoOrdine(idOrdine,stato);
        else throw new NullPointerException("nessun ordine con questo id");
    }

    public CorriereEntity getCorriereById(long id){
        return this.corriereRepository.findById(id)
                .orElseThrow(() -> new NullPointerException("corriere con questo id inesistente"));
    }

    public List<CorriereEntity> getCorrieri(){
        return this.corriereRepository.findAll();
    }

    public void updateCorriere(CorriereEntity corriere){
        this.corriereRepository.save(corriere);
    }

    public List<OrdineEntity> getOrdini(long id, Predicate<OrdineEntity> predicate){
        return this.gestoreOrdini.filtraOrdini(getCorriereById(id).getOrdini(),predicate);
    }
}
