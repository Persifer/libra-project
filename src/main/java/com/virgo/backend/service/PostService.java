package com.virgo.backend.service;

import com.virgo.backend.controller.dto.DeletePostDto;
import com.virgo.backend.controller.dto.ModifyPostDto;
import com.virgo.backend.exception.PostException;
import com.virgo.backend.exception.UtenteException;
import com.virgo.backend.model.Post;
import com.virgo.backend.model.Utente;
import com.virgo.backend.repository.PostCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
            postBetween = postRepo.getAllPostBetweeen(start, end);
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

    public List<Post> getPostWord(String username, String password, String word) throws UtenteException{
        Utente user = utenteService.login(new Utente(username, password));
        List<Post> postBetween = null;

        if(user != null){
            postBetween = postRepo.getPostWithWords(word);
            return postBetween;
        }else{
            throw new UtenteException("L'utente che sta provando a pubblicare il post non esiste");
        }
    }

    public List<Post> getPostWordForUser(String username, String password, String word) throws UtenteException{
        Utente user = utenteService.login(new Utente(username, password));
        List<Post> postBetween = null;

        if(user != null){
            System.out.println("Utente: " + user.getUsername() + " Id: "+ user.getIdUtente());
            postBetween = postRepo.getPostWithWordsForUser(user.getIdUtente(), word);
            return postBetween;
        }else{
            throw new UtenteException("L'utente che sta provando a pubblicare il post non esiste");
        }
    }

    public Post modifyPost(ModifyPostDto data) throws UtenteException, PostException, Exception {
        Utente user = utenteService.login(new Utente(data.getUsername(), data.getPassword()));
        if(user != null){

            Optional<Post> updatedPost = postRepo.findById(data.getIdPost());

            if(updatedPost.isPresent()){
                if(Objects.equals(user.getIdUtente(), updatedPost.get().getIdProprietario().getIdUtente())){

                    if(!data.getDescrizione().equals("")){
                        updatedPost.get().setDescrizione(data.getDescrizione());
                    }

                    if(!data.getTitolo().equals("")){
                        updatedPost.get().setTitolo(data.getTitolo());
                    }

                    postRepo.save(updatedPost.get());

                    return updatedPost.get();
                }else{
                    throw new UtenteException("L'utente inserito non è il proprietraio del post!");
                }
            }else{
                throw new UtenteException("Il post selezionato non esiste!");
            }
        }else{
            throw new UtenteException("L'utente inserito non esiste!");
        }
    }

    public Post deletePost(DeletePostDto data) throws UtenteException {
        Utente loggedUser = utenteService.login(new Utente(data.getUsername(),data.getPassword()));

        if(loggedUser != null){
            return null;
        }else{
            throw new UtenteException("L'utente inserito non esiste!");
        }
    }


}
