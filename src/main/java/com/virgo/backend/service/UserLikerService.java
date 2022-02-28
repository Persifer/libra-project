package com.virgo.backend.service;

import com.virgo.backend.controller.dto.LikeDto;
import com.virgo.backend.exception.LikerException;
import com.virgo.backend.exception.UtenteException;
import com.virgo.backend.model.Liker;
import com.virgo.backend.model.UserLiker;
import com.virgo.backend.model.UserUnliker;
import com.virgo.backend.model.Utente;
import com.virgo.backend.model.compoundkeys.UserLikeComposedKey;
import com.virgo.backend.repository.UserLikerCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

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
    private UserUnlikerService userUnlikerService;

    public UserLiker addLikeToUser(LikeDto data) throws UtenteException, LikerException {
        Utente loggedUser = utenteService.login(new Utente(data.getUsername(), data.getPassword()));

        if(loggedUser != null){

            UserUnliker probUnlike = userUnlikerService.isUserInside(loggedUser.getIdUtente());

            if(probUnlike != null){
                if(userUnlikerService.deleteUnlike(probUnlike)){
                    System.out.print("Elemento eliminato con successo");
                }else{
                    System.out.print("Elemento NON eliminato con successo");
                }
            }

            Liker newLike = likerService.createNewLike();

            if(newLike != null){
                return userLikerCrudRepository.save(new UserLiker(
                        new UserLikeComposedKey(loggedUser.getIdUtente(), newLike.getIdLike())
                        ,loggedUser, newLike));
            }else{
                throw new LikerException("UserLikerS -Problemi interni per la creazione del like!");
            }

        }else{
            throw new UtenteException("UserLikerS - L'utente che sta provando a mettere il like non esiste");
        }

    }

    public UserLiker isUserInside(Integer idUtene){
        Optional<UserLiker> foundedId = userLikerCrudRepository.getByUtente(idUtene);
        return foundedId.orElse(null);
    }

    public Boolean deleteLike(UserLiker likeToDel){
        likeToDel.setAttivo(false);
        Long response = userLikerCrudRepository.deleteUserLikerByIdElement_IdUtenteAndIdElement_IdLiker(
                likeToDel.getUtente().getIdUtente(), likeToDel.getLiker().getIdLike()
        );

        return response == 1;
    }


}
