package it.cs.unicam.ids.c3.service;

import it.cs.unicam.ids.c3.entity.ClienteEntity;
import it.cs.unicam.ids.c3.entity.CommercianteEntity;
import it.cs.unicam.ids.c3.entity.CorriereEntity;
import it.cs.unicam.ids.c3.repository.ClienteRepository;
import it.cs.unicam.ids.c3.repository.CommercianteRepository;
import it.cs.unicam.ids.c3.repository.CorriereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    LoginService loginService;
    @Autowired
    ClienteRepository listaCliente;
    @Autowired
    CommercianteRepository listaCommerciante;
    @Autowired
    CorriereRepository listaCorriere;

    public RegistrationService() {
    }

    public void creaCliente(String nome, String cognome, String email, String password){
        ClienteEntity nuovoCliente = new ClienteEntity(nome,cognome,email,password);
        this.loginService = new LoginService("cliente",email,password);
        listaCliente.save(nuovoCliente);
    }
    public void creaCommerciante(String nome, String cognome, String email, String password){
        CommercianteEntity nuovoCommerciante=new CommercianteEntity(nome,cognome,email,password);
        this.loginService=new LoginService("commerciante",email,password);
        listaCommerciante.save(nuovoCommerciante);

    }
    public void creaCorriere(String nome, String cognome, String email, String password){
        CorriereEntity nuovoCommerciante=new CorriereEntity(nome,cognome,email,password);
        this.loginService=new LoginService("corriere",email,password);
        listaCorriere.save(nuovoCommerciante);

    }
}
