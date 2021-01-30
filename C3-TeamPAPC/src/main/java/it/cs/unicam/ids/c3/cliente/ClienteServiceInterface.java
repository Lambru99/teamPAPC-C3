package it.cs.unicam.ids.c3.cliente;

import it.cs.unicam.ids.c3.locker.LockerEntity;
import it.cs.unicam.ids.c3.negozi.NegozioEntity;
import it.cs.unicam.ids.c3.ordine.CreatoreOrdine;
import it.cs.unicam.ids.c3.ordine.OrdineEntity;
import it.cs.unicam.ids.c3.prodotti.ProdottoEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;

@Service
public interface ClienteServiceInterface {
    CreatoreOrdine getCreatoreOrdineInCorso();

    void cancellaOrdine();

    void cambiaStatoOrdine(long id, long idOrdine);

    String getInfoOrdine(long id, long idOrdine);

    List<OrdineEntity> getOrdiniCliente(long id, Predicate<OrdineEntity> predicate);

    NegozioEntity setEmittenteOrdine(long idNegozio);

    LockerEntity setDestinazioneOrdine(long idLocker);

    ProdottoEntity setProdottoOrdine(long idProdotto, int number);

    OrdineEntity addOrdineToCliente(long id);

    ClienteEntity getClienteById(long id);

}
