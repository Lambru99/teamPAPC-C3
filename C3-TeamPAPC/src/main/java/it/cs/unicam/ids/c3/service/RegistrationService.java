package it.cs.unicam.ids.c3.service;

import it.cs.unicam.ids.c3.entity.ClienteEntity;
import it.cs.unicam.ids.c3.entity.CommercianteEntity;
import it.cs.unicam.ids.c3.entity.CorriereEntity;
import it.cs.unicam.ids.c3.entity.NegozioEntity;
import it.cs.unicam.ids.c3.repository.ClienteRepository;
import it.cs.unicam.ids.c3.repository.CommercianteRepository;
import it.cs.unicam.ids.c3.util.MyUserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private CommercianteRepository commercianteRepository;
    @Autowired
    private CorriereService corriereService;

    public RegistrationService(){}

    public void addCommerciante(CommercianteEntity commercianteEntity, NegozioEntity negozioEntity){
        commercianteEntity.initUsername();
        commercianteEntity.setNegozio(negozioEntity);
        this.commercianteRepository.save(commercianteEntity);
    }

    private void createCliente(String nome, String cognome, String email, String password){
        ClienteEntity cl = new ClienteEntity(nome,cognome,email,password);
        cl.initUsername();
        this.clienteRepository.save(cl);
    }
    /*public void createCommerciante(String nome, String cognome, String email, String password){
        CommercianteEntity cl = new CommercianteEntity(nome,cognome,email,password);
        commercianteRepository.save(cl);
    }*/
    private void createCorriere(String nome, String cognome, String email, String password){
        CorriereEntity cl = new CorriereEntity(nome,cognome,email,password);
        cl.initUsername();
        this.corriereService.updateCorriere(cl);
    }

    public void register(String nome, String cognome, String email, String password,String type){
        MyUserType u = MyUserType.valueOf(type.toUpperCase());
        switch (u) {
            case CLIENTE: createCliente(nome,cognome,email,password);break;
            case CORRIERE: createCorriere(nome,cognome,email,password);break;
            //case COMMERCIANTE: createCommerciante(nome, cognome,email,password);break;
        }
    }
}
