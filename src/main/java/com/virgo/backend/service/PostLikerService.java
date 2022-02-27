package com.virgo.backend.service;

import com.virgo.backend.controller.dto.LikeDto;
import com.virgo.backend.exception.LikerException;
import com.virgo.backend.exception.PostException;
import com.virgo.backend.exception.UtenteException;
import com.virgo.backend.model.*;
import com.virgo.backend.model.compoundkeys.PostLikerCompounKey;
import com.virgo.backend.repository.PostCrudRepository;
import com.virgo.backend.repository.PostLikerCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("postLikerService")
@Transactional
public class PostLikerService {

    @Autowired
    private PostLikerCrudRepository postLikerCrudRepository;

    @Autowired
    private PostService postService;

    public PostLiker addLikeToPost(LikeDto data, Liker likeEntity) throws PostException, LikerException {
        Post postToLike = postService.getSinglePost(data.getIdPost());

        if(postToLike != null){
            if(!postToLike.getIdProprietario().getUsername().equals(data.getUsername())){
                if(likeEntity != null){
                    return postLikerCrudRepository.save(new PostLiker(
                            new PostLikerCompounKey(postToLike.getIdPost(), likeEntity.getIdLike())
                            ,postToLike, likeEntity));
                }else{
                    throw new LikerException("Problemi interni per la creazione del like!");
                }
            }else{
                throw new PostException("L'utente non può mettere like al suo stesso post!");
            }

        }else{
            throw new PostException("Il post che si sta cercando non esiste");
        }

    }
}
