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

    @Autowired
    private PostUnlikerService postUnlikerService;

    public PostLiker addLikeToPost(LikeDto data, Liker likeEntity) throws PostException, LikerException {
        Post postToLike = postService.getSinglePost(data.getIdPost());

        if(postToLike != null){

            if(!postToLike.getIdProprietario().getUsername().equals(data.getUsername())){

                PostUnliker isUnliked = postUnlikerService.isPostInside(postToLike.getIdPost());

                if(isUnliked != null){
                    if(postUnlikerService.deleteUnlike(isUnliked)){
                        System.out.println("Like post eliminato correttamente");
                    }else{
                        System.out.println("Like post NON eliminato correttamente");
                    }
                }

                if(likeEntity != null){
                    return postLikerCrudRepository.save(new PostLiker(
                            new PostLikerCompounKey(postToLike.getIdPost(), likeEntity.getIdLike())
                            ,postToLike, likeEntity));
                }else{
                    throw new LikerException("PostLikerS - Problemi interni per la creazione del like!");
                }
            }else{
                throw new PostException("PostLikerS - L'utente non può mettere like al suo stesso post!");
            }

        }else{
            throw new PostException("PostLikerS - Il post che si sta cercando non esiste");
        }

    }
}
