package it.cs.unicam.ids.c3.service;

import it.cs.unicam.ids.c3.entity.CommercianteEntity;
import it.cs.unicam.ids.c3.entity.NegozioEntity;
import org.springframework.stereotype.Service;

@Service
public interface RegistrationServiceInterface {
    void registerCommerciante(CommercianteEntity commercianteEntity, NegozioEntity negozioEntity);
    void registerClienteCorriere(String nome, String cognome, String email, String password, String type);
}
