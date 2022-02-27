package com.virgo.backend.repository;

import com.virgo.backend.model.PostUnliker;
import com.virgo.backend.model.compoundkeys.PostUnlikerComposedKey;
import org.springframework.data.repository.CrudRepository;

public interface PostUnlikerCrudRepository extends CrudRepository<PostUnliker, PostUnlikerComposedKey> {
}
