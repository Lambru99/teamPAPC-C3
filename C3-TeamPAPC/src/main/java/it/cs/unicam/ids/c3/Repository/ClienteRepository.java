package it.cs.unicam.ids.c3.Repository;

import it.cs.unicam.ids.c3.Cliente.ClienteInterface;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {
    private List<ClienteInterface> clienti;

    public ClienteRepository() {
        this.clienti = new ArrayList<>();
    }
    public void addCliente(ClienteInterface cliente){
        this.clienti.add(cliente);
    }
    public void delCliente(ClienteInterface cliente)throws IllegalArgumentException{
        if (this.clienti.contains(cliente)){
            this.clienti.remove(cliente);
        }else {
            throw new IllegalArgumentException("Cliente inesistente");
        }
    }
    public List<ClienteInterface> getClienti(){
        return this.clienti;
    }
}
