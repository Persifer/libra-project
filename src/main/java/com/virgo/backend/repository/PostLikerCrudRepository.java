package com.virgo.backend.repository;

import com.virgo.backend.model.PostLiker;
import com.virgo.backend.model.compoundkeys.PostLikerCompounKey;
import org.springframework.data.repository.CrudRepository;

public interface PostLikerCrudRepository extends CrudRepository<PostLiker, PostLikerCompounKey> {

}
