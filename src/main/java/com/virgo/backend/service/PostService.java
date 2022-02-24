package com.virgo.backend.service;

import com.virgo.backend.exception.UtenteException;
import com.virgo.backend.model.Post;
import com.virgo.backend.model.Utente;
import com.virgo.backend.repository.PostCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.List;

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


    public List<Post> getProfilePost(String username, String password, Post post) throws UtenteException, Exception{
        Utente user = utenteService.login(new Utente(username, password));
        List<Post> profilePost = null;
        if(user != null){
            profilePost = postRepo.getPostByIdProprietario(user);
            return profilePost;
        }else{
            throw new UtenteException("L'utente che sta provando a pubblicare il post non esiste");
        }
    }

    public List<Post> getPostBetween(String username, String password, String start, String end) throws UtenteException{
        Utente user = utenteService.login(new Utente(username, password));
        List<Post> postBetween = null;

        if(user != null){
            postBetween = postRepo.getAllPostBetweeen(user.getIdUtente(),start, end);
            return postBetween;
        }else{
            throw new UtenteException("L'utente che sta provando a pubblicare il post non esiste");
        }
    }

    public List<Post> getLastUpdateBetween(String username, String password, String start, String end) throws UtenteException{
        Utente user = utenteService.login(new Utente(username, password));
        List<Post> postBetween = null;

        if(user != null){
            postBetween = postRepo.getAllLastUpdateBetweenByUser(user.getIdUtente(),start, end);
            return postBetween;
        }else{
            throw new UtenteException("L'utente che sta provando a pubblicare il post non esiste");
        }
    }
}
