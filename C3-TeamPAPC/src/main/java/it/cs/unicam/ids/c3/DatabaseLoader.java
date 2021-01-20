package it.cs.unicam.ids.c3;

import it.cs.unicam.ids.c3.entity.*;
import it.cs.unicam.ids.c3.repository.ClienteRepository;
import it.cs.unicam.ids.c3.repository.LockerRepository;
import it.cs.unicam.ids.c3.repository.NegozioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseLoader {

    @Bean
    CommandLineRunner initDatabase(ClienteRepository clienteRepository,
                                   NegozioRepository negozioRepository,
                                   LockerRepository lockerRepository){
        return args -> {
            ClienteEntity cliente = new ClienteEntity("Mario","Rossi","mario.rossi@gmail.com","mariorossi");
            cliente.initUsername();
            clienteRepository.save(cliente);
            NegozioEntity negozio = new NegozioEntity("ferramenta","ferramenta","Via Roma 10","Chiuso Sabato e Domenica");
            lockerRepository.save(new LockerEntity("locker1","via mazzini 23","tutti i giorni dalle 8 alle 21"));
            ProdottoEntity p = new ProdottoEntity("vite","vite 5mm al pezzo",0.02,10);
            negozio.getProdotti().add(p);
            negozio.getProdotti().add(new ProdottoEntity("tubo","tubo ferro 32 mm diametro al Kg",6.55,22));
            ProdottoEntity p1 = new ProdottoEntity("carta vetrata","carta vetrata 100",1.25,105);
            negozio.getProdotti().add(p1);
            negozioRepository.save(negozio);
        };
    }
}
