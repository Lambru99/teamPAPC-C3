package it.cs.unicam.ids.c3.service;


import it.cs.unicam.ids.c3.repository.ClienteRepository;
import it.cs.unicam.ids.c3.repository.CommercianteRepository;
import it.cs.unicam.ids.c3.repository.CorriereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    public static String ruolo;
    @Autowired
    private ClienteRepository listaClienti;
    @Autowired
    private CommercianteRepository listaCommerciante;
    @Autowired
    private CorriereRepository listaCorriere;

    public LoginService() {
    }

    public LoginService(String ruolo, String email, String password) {
        this();
        LoginService.ruolo=ruolo.toLowerCase();
        switch (LoginService.ruolo) {
            case "cliente": loginCliente(email,password);break;
            case "commerciante": loginCommerciante(email,password);break;
            case "corriere": loginCorriere(email,password);break;
            default:throw new IllegalArgumentException("Ruolo inesistente");
        }
        LoginService.ruolo =ruolo;
    }

    public void loginCliente(String email,String password){
        listaClienti.findAll().stream().filter(clienteEntity -> (clienteEntity.getEmail().equals(email)&&clienteEntity
                .getPassword().equals(password))).findFirst().orElseThrow();
    }
    public void loginCommerciante(String email,String password){
        listaCommerciante.findAll().stream().filter(commercianteEntity-> (commercianteEntity.getEmail()
                .equals(email)&&commercianteEntity.getPassword().equals(password))).findFirst().orElseThrow();
    }
    public void loginCorriere(String email,String password){
        listaCorriere.findAll().stream().filter(corriereEntity-> (corriereEntity.getEmail()
                .equals(email)&&corriereEntity.getPassword().equals(password))).findFirst().orElseThrow();
    }

}
