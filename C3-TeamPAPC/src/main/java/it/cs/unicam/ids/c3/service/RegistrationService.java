package it.cs.unicam.ids.c3.service;

import it.cs.unicam.ids.c3.entity.ClienteEntity;
import it.cs.unicam.ids.c3.entity.CommercianteEntity;
import it.cs.unicam.ids.c3.entity.CorriereEntity;
import it.cs.unicam.ids.c3.entity.NegozioEntity;
import it.cs.unicam.ids.c3.repository.ClienteRepository;
import it.cs.unicam.ids.c3.repository.CommercianteRepository;
import it.cs.unicam.ids.c3.repository.CorriereRepository;
import it.cs.unicam.ids.c3.util.MyUserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * servizio che si occupa di registrate un nuovo utente
 */
@Service
public class RegistrationService implements RegistrationServiceInterface{
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private CommercianteRepository commercianteRepository;
    @Autowired
    private CorriereRepository corriereRepository;

    public RegistrationService(){}

    /**
     * registra un nuovo commerciante
     * @param commercianteEntity commerciante da registrare
     * @param negozioEntity negozio associato al commerciante
     */
    @Override
    public void registerCommerciante(CommercianteEntity commercianteEntity, NegozioEntity negozioEntity){
        commercianteEntity.initUsername();
        commercianteEntity.setNegozio(negozioEntity);
        this.commercianteRepository.save(commercianteEntity);
    }

    private void createCliente(String nome, String cognome, String email, String password){
        ClienteEntity cl = new ClienteEntity(nome,cognome,email,password);
        cl.initUsername();
        this.clienteRepository.save(cl);
    }

    private void createCorriere(String nome, String cognome, String email, String password){
        CorriereEntity cl = new CorriereEntity(nome,cognome,email,password);
        cl.initUsername();
        this.corriereRepository.save(cl);
    }

    /**
     * registra un nuovo corriere o cliente
     * se type==CLIENTE allora registra un nuovo cliente
     * se type ==CORRIERE registra un nuovo corriere
     * @param nome nome del cliente o corriere
     * @param cognome cognome cliente o corriere
     * @param email email cliente o corriere
     * @param password password ciente o corriere
     * @param type condizione di controllo sul tipo cliente/commerciante
     */
    @Override
    public void registerClienteCorriere(String nome, String cognome, String email, String password, String type){
        MyUserType u = MyUserType.valueOf(type.toUpperCase());
        switch (u) {
            case CLIENTE: createCliente(nome,cognome,email,password);break;
            case CORRIERE: createCorriere(nome,cognome,email,password);break;
            //case COMMERCIANTE: createCommerciante(nome, cognome,email,password);break;
        }
    }
}
