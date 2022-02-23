package com.virgo.backend.configuration;

import com.virgo.backend.model.Ruolo;
import com.virgo.backend.repository.RuoloCrudRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

import static com.virgo.backend.utils.Constants.ADMINROLE;
import static com.virgo.backend.utils.Constants.USEROLE;

@Configuration
public class RuoloConfiguration {

    @Bean
    CommandLineRunner commandLineRunner(RuoloCrudRepository ruoloRepo){
        return args -> {
            Ruolo role = ruoloRepo.findByNome(ADMINROLE);
            if(role == null) {
                ruoloRepo.save(new Ruolo("admin", "permette di fare tutto "));
            }

            role = ruoloRepo.findByNome(USEROLE);
            if(role == null) {
                ruoloRepo.save(new Ruolo("user", "permette di interagire normamente con la piattaforma"));
            }
        };
    }

}
