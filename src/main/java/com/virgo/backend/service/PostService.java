package com.virgo.backend.service;

import com.virgo.backend.exception.PostException;
import com.virgo.backend.exception.UtenteException;
import com.virgo.backend.model.Post;
import com.virgo.backend.model.Utente;
import com.virgo.backend.repository.PostCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;

@Service("postService")
@Transactional
public class PostService {

    @Autowired
    private PostCrudRepository postRepo;

    @Autowired
    private UtenteService utenteService;

    public Post publishPost(String username, String password, Post newPost) throws UtenteException, Exception {
        Utente user = utenteService.login(new Utente(username, password));

        if(user != null){
            newPost.setIdProprietario(user);

            newPost.setDataPublicazione(OffsetDateTime.now());
            newPost.setDataAggiornamento(OffsetDateTime.now());

            postRepo.save(newPost);
            return newPost;
        }else{
            throw new UtenteException("L'utente che sta provando a pubblicare il post non esiste");
        }

    }


}
