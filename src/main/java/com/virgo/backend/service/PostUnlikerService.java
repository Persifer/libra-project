package com.virgo.backend.service;

import com.virgo.backend.controller.dto.LikeDto;
import com.virgo.backend.exception.PostException;
import com.virgo.backend.exception.UnlikerException;
import com.virgo.backend.model.Post;
import com.virgo.backend.model.PostUnliker;
import com.virgo.backend.model.Unlike;
import com.virgo.backend.model.compoundkeys.PostUnlikerComposedKey;
import com.virgo.backend.repository.PostUnlikerCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("postUnlikerService")
@Transactional
public class PostUnlikerService {

    @Autowired
    private PostUnlikerCrudRepository postUnlikerCrudRepository;

    @Autowired
    private PostService postService;

    public PostUnliker addUnlike(LikeDto data, Unlike unlikeEntity) throws PostException, UnlikerException {
        Post unlikedPost = postService.getSinglePost(data.getIdPost());

        if(unlikedPost != null){
            if(!unlikedPost.getIdProprietario().getUsername().equals(data.getUsername())){
                if(unlikeEntity != null){
                    return postUnlikerCrudRepository.save(new PostUnliker(
                            new PostUnlikerComposedKey(unlikedPost.getIdPost(), unlikeEntity.getIdUnlike()),
                            unlikedPost, unlikeEntity
                    ));
                }else{
                    throw new UnlikerException("Errore sconosciuto su entità unlike");
                }
            }else{
                throw new PostException("Un utente non può mettersi unlike da solo");
            }
        }else{
            throw new PostException("Il post richiesto non esiste");
        }
    }
}
