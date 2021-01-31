package it.cs.unicam.ids.c3;

import it.cs.unicam.ids.c3.cliente.ClienteEntity;
import it.cs.unicam.ids.c3.cliente.ClienteRepository;
import it.cs.unicam.ids.c3.commerciante.CommercianteEntity;
import it.cs.unicam.ids.c3.commerciante.CommercianteRepository;
import it.cs.unicam.ids.c3.corriere.CorriereEntity;
import it.cs.unicam.ids.c3.corriere.CorriereRepository;
import it.cs.unicam.ids.c3.locker.LockerEntity;
import it.cs.unicam.ids.c3.locker.LockerRepository;
import it.cs.unicam.ids.c3.negozi.NegozioEntity;
import it.cs.unicam.ids.c3.prodotti.ProdottoEntity;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseLoader {

    @Bean
    CommandLineRunner initDatabase(ClienteRepository clienteRepository,
                                   LockerRepository lockerRepository,
                                   CommercianteRepository commercianteRepository,
                                   CorriereRepository corriereRepository){
        return args -> {
            ClienteEntity cliente = new ClienteEntity("a","a","a@gmail.com","a");
            cliente.initUsername();
            clienteRepository.save(cliente);
            CorriereEntity corriere = new CorriereEntity("gianni","francati","g@gmail.com","a");
            corriere.initUsername();
            corriereRepository.save(corriere);
            CommercianteEntity commercianteEntity = new CommercianteEntity("matteo","minzi",
                    "mm@gmail.com","1234");
            commercianteEntity.initUsername();
            NegozioEntity negozio = new NegozioEntity("ferramenta","ferramenta","Via Roma 10","Chiuso Sabato e Domenica");
            negozio.getProdotti().add(new ProdottoEntity("vite","vite 5mm al pezzo",0.02,10));
            commercianteEntity.setNegozio(negozio);
            commercianteRepository.save(commercianteEntity);
            lockerRepository.save(new LockerEntity("locker1","via mazzini 23","tutti i giorni dalle 8 alle 21"));
        };
    }
}
