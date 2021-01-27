package it.cs.unicam.ids.c3.controller;

import it.cs.unicam.ids.c3.entity.CommercianteEntity;
import it.cs.unicam.ids.c3.entity.NegozioEntity;
import it.cs.unicam.ids.c3.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/register")
public class RegistrationRestController {

    @Autowired
    RegistrationService registrationService;
    public RegistrationRestController(){}

    @PostMapping("/registrationCommerciante")
    public void doRegistrationCommerciante(@RequestParam String nome,@RequestParam String cognome,
                                           @RequestParam String email,@RequestParam String password,@RequestParam String nomeNegozio,
                                           @RequestParam String descrizione,@RequestParam String indirizzo,
                                           @RequestParam String orario ){
        this.registrationService.registerCommerciante(new CommercianteEntity(nome,cognome,email,password),
                new NegozioEntity(nomeNegozio,descrizione,indirizzo,orario));
    }

    @PostMapping("/registrationCliCor")
    public void register(@RequestParam String nome, @RequestParam String cognome,
                         @RequestParam String email,@RequestParam String password,@RequestParam String type){
        this.registrationService.registerClienteCorriere(nome,cognome,email,password,type);
    }
}
