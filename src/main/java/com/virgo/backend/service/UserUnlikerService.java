package com.virgo.backend.service;

import com.virgo.backend.controller.dto.LikeDto;
import com.virgo.backend.exception.UnlikerException;
import com.virgo.backend.exception.UtenteException;
import com.virgo.backend.model.Unlike;
import com.virgo.backend.model.UserLiker;
import com.virgo.backend.model.UserUnliker;
import com.virgo.backend.model.Utente;
import com.virgo.backend.model.compoundkeys.UserUnlikerComposedKey;
import com.virgo.backend.repository.UserUnlikerCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service("userUnlikerService")
@Transactional
public class UserUnlikerService {

    @Autowired
    private UserUnlikerCrudRepository userUnlikerCrudRepository;

    @Autowired
    private UtenteService utenteService;

    @Autowired
    private UnlikeService unlikeService;

    @Autowired
    private UserLikerService userLikerService;

    public UserUnliker addUnlike(LikeDto data) throws UtenteException {

        Utente loggedUser = utenteService.login(new Utente(data.getUsername(), data.getPassword()));

        if(loggedUser != null){

            if (userUnlikerCrudRepository.getByUtente(loggedUser.getIdUtente()).isEmpty()) {
                UserLiker probLike = userLikerService.isUserInside(loggedUser.getIdUtente());

                if(probLike != null){
                    userLikerService.deleteLike(probLike);
                }

                Unlike newUnlike = unlikeService.createLike();

                if(newUnlike != null){
                    return userUnlikerCrudRepository.save(
                            new UserUnliker(
                                    new UserUnlikerComposedKey(loggedUser.getIdUtente(), newUnlike.getIdUnlike()),
                                    loggedUser, newUnlike
                            )
                    );
                }else{
                    throw new UtenteException("UserUnlikerS - An unkown error occurred. Contact the admin");
                }
            } else {
                throw new UtenteException("L'utente ha già messo dislike a questo post");
            }
        }else{
            throw new UtenteException("UserUnlikerS - L'utente inserito non esiste");
        }

    }

    public UserUnliker isUserInside(Integer idUtene){
        Optional<UserUnliker> foundedId = userUnlikerCrudRepository.getByUtente(idUtene);

        return foundedId.orElse(null);
    }

    public Boolean deleteUnlike(UserUnliker unlikeToDel){
        Integer idUnlike = unlikeToDel.getUnlike().getIdUnlike();
        Long response = userUnlikerCrudRepository.deleteUserUnlikerById_IdUtenteAndId_IdUnlike(unlikeToDel.getUtente().getIdUtente(), unlikeToDel.getUnlike().getIdUnlike());
        return response == 1;
    }
}
