package com.virgo.backend.service;

import com.virgo.backend.controller.UserLikerController;
import com.virgo.backend.controller.dto.LikeDto;
import com.virgo.backend.exception.LikerException;
import com.virgo.backend.exception.PostException;
import com.virgo.backend.exception.UtenteException;
import com.virgo.backend.model.Liker;
import com.virgo.backend.model.Post;
import com.virgo.backend.model.UserLiker;
import com.virgo.backend.model.Utente;
import com.virgo.backend.model.compoundkeys.UserLikeComposedKey;
import com.virgo.backend.repository.UserLikerCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userLikerService")
@Transactional
public class UserLikerService {

    @Autowired
    private UserLikerCrudRepository userLikerCrudRepository;

    @Autowired
    private UtenteService utenteService;

    @Autowired
    private LikerService likerService;

    @Autowired
    private PostService postService;

    public UserLiker addLikeToUser(LikeDto data) throws UtenteException, LikerException {
        Utente loggedUser = utenteService.login(new Utente(data.getUsername(), data.getPassword()));

        if(loggedUser != null){

            Liker newLike = likerService.createNewLike();

            if(newLike != null){
                return userLikerCrudRepository.save(new UserLiker(
                        new UserLikeComposedKey(loggedUser.getIdUtente(), newLike.getIdLike())
                        ,loggedUser, newLike));
            }else{
                throw new LikerException("Problemi interni per la creazione del like!");
            }

        }else{
            throw new UtenteException("L'utente che sta provando a mettere il like non esiste");
        }

    }


}
