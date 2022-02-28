package com.virgo.backend.repository;

import com.virgo.backend.model.PostUnliker;
import com.virgo.backend.model.UserUnliker;
import com.virgo.backend.model.compoundkeys.PostUnlikerComposedKey;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PostUnlikerCrudRepository extends CrudRepository<PostUnliker, PostUnlikerComposedKey> {

    @Query(
            value = "SELECT * FROM post_unliker u WHERE u.id_post = ?1",
            nativeQuery = true
    )
    public Optional<PostUnliker> getPostById(Integer idPost);


    public Long deleteById_IdPostAndId_IdUnlike(Integer idPost, Integer idUnlike);
}
