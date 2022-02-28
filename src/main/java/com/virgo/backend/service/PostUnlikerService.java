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

import java.util.Optional;

@Service("postUnlikerService")
@Transactional
public class PostUnlikerService {

    @Autowired
    private PostUnlikerCrudRepository postUnlikerCrudRepository;

    @Autowired
    private PostService postService;

    @Autowired
    private UnlikeService unlikeService;

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
                    throw new UnlikerException("PostUnlikerS - Errore sconosciuto su entità unlike");
                }
            }else{
                throw new PostException("PostUnlikerS - Un utente non può mettersi unlike da solo");
            }
        }else{
            throw new PostException("PostUnlikerS - Il post richiesto non esiste");
        }
    }

    public PostUnliker isPostInside(Integer idPost){
        Optional<PostUnliker> isInside = postUnlikerCrudRepository.getPostById(idPost);

        return isInside.orElse(null);
    }

    public Boolean deleteUnlike(PostUnliker postToDelete){
        Integer idUnlike = postToDelete.getUnlike().getIdUnlike();
        Long response = postUnlikerCrudRepository.deleteById_IdPostAndId_IdUnlike(postToDelete.getPost().getIdPost(), postToDelete.getUnlike().getIdUnlike());
        unlikeService.deleteElement(idUnlike);
        return response == 1;
    }
}
