package com.virgo.backend.service;

import com.virgo.backend.controller.dto.LikeDto;
import com.virgo.backend.exception.PostException;
import com.virgo.backend.exception.UtenteException;
import com.virgo.backend.model.Liker;
import com.virgo.backend.model.Post;
import com.virgo.backend.model.Utente;
import com.virgo.backend.repository.LikeCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("likerService")
@Transactional
public class LikerService {

    @Autowired
    private LikeCrudRepository likeRepo;

    @Autowired
    private UtenteService utenteService;

    @Autowired
    private PostService postService;

    public Liker addLikeAtPost(LikeDto liker) throws UtenteException, PostException {
        Utente user = utenteService.login(new Utente(liker.getUsername(), liker.getPassword()));

        if(user != null){
            Post post = postService.getSinglePost(liker.getIdPost());

            if(post != null){
                if(!post.getIdProprietario().getIdUtente().equals(user.getIdUtente())){
                    return null;
                }else{
                    throw new UtenteException("L'utente non può mettere like ad un suo post!");
                }
            }else{
                throw new PostException("Il post selezionato non esiste!");
            }
        }else{
            throw new UtenteException("L'utente non esiste!");
        }
    }


}
