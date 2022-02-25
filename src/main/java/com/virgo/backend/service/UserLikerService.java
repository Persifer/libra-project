package com.virgo.backend.service;

import com.virgo.backend.controller.UserLikerController;
import com.virgo.backend.controller.dto.LikeDto;
import com.virgo.backend.exception.PostException;
import com.virgo.backend.exception.UtenteException;
import com.virgo.backend.model.Post;
import com.virgo.backend.model.UserLiker;
import com.virgo.backend.model.Utente;
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
    private PostService postService;

    public UserLiker addLikeToPost(LikeDto data) throws UtenteException, PostException {
        Utente loggedUser = utenteService.login(new Utente(data.getUsername(), data.getPassword()));

        if(loggedUser != null){
            Post selectedPost = postService.getSinglePost(data.getIdPost());

            if(selectedPost != null){
                // TODO -> Finisci il metodo
                return null;
            }else{
                throw new PostException("Il post a cui si vuole mettere like non esiste");
            }
        }else{
            throw new UtenteException("L'utente che sta provando a mettere il like non esiste");
        }

    }


}
