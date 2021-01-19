package it.cs.unicam.ids.c3.entity;

import java.util.List;

public interface ClienteEntityInterface {
    List<OrdineEntity> getOrdini();

    long getId();

    String getEmail();

    void setEmail(String email);

    String getPassword();

    void setPassword(String password);

    String getNome();

    void setNome(String name);

    String getCognome();

    void setCognome(String surname);

    String getUsername();

    void setUsername(String username);
}
