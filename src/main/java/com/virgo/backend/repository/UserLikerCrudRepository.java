package com.virgo.backend.repository;


import com.virgo.backend.model.UserLiker;
import com.virgo.backend.model.compoundkeys.UserLikeComposedKey;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserLikerCrudRepository extends CrudRepository<UserLiker, UserLikeComposedKey> {

    @Query(
            value = "SELECT * FROM user_liker u WHERE u.id_utente = ?1",
            nativeQuery = true
    )
    public Optional<UserLiker> getByUtente(Integer idUtente);
}
