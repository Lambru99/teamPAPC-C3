package it.cs.unicam.ids.c3.accesso.registrazione;

import it.cs.unicam.ids.c3.commerciante.CommercianteEntity;
import it.cs.unicam.ids.c3.negozi.NegozioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Controller rest della registrazione
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/register")
public class RegistrationRestController {

    @Autowired
    RegistrationServiceInterface registrationService;
    public RegistrationRestController(){}

    /**
     * Registrazione del commerciante diversa da quella del cliente e quella de corriere perché associa un negozio al commerciante appena creato
     * @param nome
     * @param cognome
     * @param email
     * @param password
     * @param nomeNegozio
     * @param descrizione
     * @param indirizzo
     * @param orario
     */
    @PostMapping("/registrationCommerciante")
    public void doRegistrationCommerciante(@RequestParam String nome,@RequestParam String cognome,
                                           @RequestParam String email,@RequestParam String password,@RequestParam String nomeNegozio,
                                           @RequestParam String descrizione,@RequestParam String indirizzo,
                                           @RequestParam String orario ){
        this.registrationService.registerCommerciante(new CommercianteEntity(nome,cognome,email,password),
                new NegozioEntity(nomeNegozio,descrizione,indirizzo,orario));
    }

    /**
     * Registrazione del cliente e del commerciante
     * @param nome
     * @param cognome
     * @param email
     * @param password
     * @param type
     */
    @PostMapping("/registrationCliCor")
    public void register(@RequestParam String nome, @RequestParam String cognome,
                         @RequestParam String email,@RequestParam String password,@RequestParam String type){
        this.registrationService.registerClienteCorriere(nome,cognome,email,password,type);
    }
}
