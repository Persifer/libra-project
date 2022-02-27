package com.virgo.backend.repository;

import com.virgo.backend.model.UserUnliker;
import com.virgo.backend.model.compoundkeys.UserUnlikerComposedKey;
import org.springframework.data.repository.CrudRepository;

public interface UserUnlikerCrudRepository extends CrudRepository<UserUnliker, UserUnlikerComposedKey> {
}
