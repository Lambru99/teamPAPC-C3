package it.cs.unicam.ids.c3;

import java.util.HashSet;
import java.util.Set;

public class ClientiRepository {
    private Set<ClienteInterface> clienti;

    public ClientiRepository() {
        this.clienti = new HashSet<>();
    }

    public Set<ClienteInterface> getClienti() {
        return clienti;
    }

    private boolean isPresent(long id){
        return getClienti().stream().anyMatch(clienteInterface -> clienteInterface.getId() == id);
    }

    public ClienteInterface getClienteById(long id){
        return getClienti().stream().filter(clienteInterface -> clienteInterface.getId()==id).findFirst()
                .orElseThrow(NullPointerException::new);
    }
}
