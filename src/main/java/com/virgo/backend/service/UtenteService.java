package com.virgo.backend.service;

import com.virgo.backend.exception.UtenteException;
import com.virgo.backend.model.Utente;
import com.virgo.backend.repository.UtenteCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service("utenteService")
@Transactional
public class UtenteService {

    @Autowired
    private UtenteCrudRepository repoUtente;

    @Autowired
    private RuoloService ruoloService;

    public Utente registration(Utente newUtente) throws UtenteException {



        if(repoUtente.findByEmail(newUtente.getEmail()).isEmpty()){
            // Controllo che due utenti non abbiano lo stesso username
            if(repoUtente.findByUsername(newUtente.getUsername()).isEmpty()){
                //TODO -> IMPLEMENTA UN METODO DI HASHING DELLA PASSWORD

                newUtente.setRuolo(ruoloService.getUserRole());

                return repoUtente.save(newUtente);
            }else{
                // todo eccezione custom

                throw new UtenteException("[!] L'username inserito esiste già [!]");
            }

        }else{
            throw new IllegalStateException("[!] L'utente che si sta provano ad inserire esiste già [!]");
        }


    }

    public Utente login(Utente user) throws UtenteException {
        Utente loggedUser;
            // TODO -> Se implementata la cifratura della password, cifra la password e la controlla con quella nel db
            loggedUser = repoUtente.findByUsernameAndPassword(user.getUsername(), user.getPassword());

            if(loggedUser != null){
                return loggedUser;
            }else{
                throw new UtenteException("[!] L'utente inserito non esiste [!]");
            }

    }

    public Utente login(String username, String passw) {
        System.out.println("Ciao");
        return null;
    }

    public List<Utente> getAllUsers(){
        return (List<Utente>) repoUtente.findAll();
    }


}
