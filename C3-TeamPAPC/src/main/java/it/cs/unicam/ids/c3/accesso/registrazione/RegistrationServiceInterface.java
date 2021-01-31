package it.cs.unicam.ids.c3.accesso.registrazione;

import it.cs.unicam.ids.c3.commerciante.CommercianteEntity;
import it.cs.unicam.ids.c3.negozi.NegozioEntity;
import org.springframework.stereotype.Service;

@Service
public interface RegistrationServiceInterface {
    void registerCommerciante(CommercianteEntity commercianteEntity, NegozioEntity negozioEntity);
    void registerClienteCorriere(String nome, String cognome, String email, String password, String type);
}
