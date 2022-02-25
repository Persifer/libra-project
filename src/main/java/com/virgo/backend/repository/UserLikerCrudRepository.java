package com.virgo.backend.repository;


import com.virgo.backend.model.UserLiker;
import com.virgo.backend.model.compoundkeys.UserLikeComposedKey;
import org.springframework.data.repository.CrudRepository;

public interface UserLikerCrudRepository extends CrudRepository<UserLiker, UserLikeComposedKey> {
}
