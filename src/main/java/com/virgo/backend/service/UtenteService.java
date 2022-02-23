package com.virgo.backend.service;

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

    public HttpStatus registration(Utente newUtente){

        try{

            if(repoUtente.findByEmail(newUtente.getEmail()).isEmpty()){
                if(repoUtente.findByUsername(newUtente.getUsername()).isEmpty()){
                    //TODO -> IMPLEMENTA UN METODO DI HASHING DELLA PASSWORD

                    newUtente.setRuolo(ruoloService.getUserRole());

                    repoUtente.save(newUtente);
                    return HttpStatus.CREATED;
                }else{
                   return HttpStatus.BAD_REQUEST;
                }

            }else{
                throw new IllegalStateException("[!] L'utente che si sta provano ad inserire esiste già [!]");
            }
        }catch (Exception error){
            error.printStackTrace();
            return HttpStatus.BAD_REQUEST;
        }




    }

    public HttpStatus login(Utente user){
        return null;
    }

    public Utente login(String username, String passw) {
        System.out.println("Ciao");
        return null;
    }

    public List<Utente> getAllUsers(){
        return (List<Utente>) repoUtente.findAll();
    }


}
