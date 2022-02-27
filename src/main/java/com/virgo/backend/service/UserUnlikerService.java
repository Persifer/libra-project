package com.virgo.backend.service;

import com.virgo.backend.controller.dto.LikeDto;
import com.virgo.backend.exception.UnlikerException;
import com.virgo.backend.exception.UtenteException;
import com.virgo.backend.model.Unlike;
import com.virgo.backend.model.UserUnliker;
import com.virgo.backend.model.Utente;
import com.virgo.backend.model.compoundkeys.UserUnlikerComposedKey;
import com.virgo.backend.repository.UserUnlikerCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userUnlikerServie")
@Transactional
public class UserUnlikerService {

    @Autowired
    private UserUnlikerCrudRepository userUnlikerCrudRepository;

    @Autowired
    private UtenteService utenteService;

    @Autowired
    private UnlikeService unlikeService;

    public UserUnliker addUnlike(LikeDto data) throws UtenteException {

        Utente loggedUser = utenteService.login(new Utente(data.getUsername(), data.getPassword()));

        if(loggedUser != null){
            Unlike newUnlike = unlikeService.createLike();

            if(newUnlike != null){
                return userUnlikerCrudRepository.save(
                        new UserUnliker(
                                new UserUnlikerComposedKey(loggedUser.getIdUtente(), newUnlike.getIdUnlike()),
                                loggedUser, newUnlike
                        )
                );
            }else{
                throw new UtenteException("An unkown error occurred. Contact the admin");
            }
        }else{
            throw new UtenteException("L'utente inserito non esiste");
        }

    }
}
