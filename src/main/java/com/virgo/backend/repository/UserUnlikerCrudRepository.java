package com.virgo.backend.repository;

import com.virgo.backend.model.UserUnliker;
import com.virgo.backend.model.compoundkeys.UserUnlikerComposedKey;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserUnlikerCrudRepository extends CrudRepository<UserUnliker, UserUnlikerComposedKey> {

    @Query(
            value = "SELECT * FROM user_unliker u WHERE u.id_utente = ?1",
            nativeQuery = true
    )
    public Optional<UserUnliker> getByUtente(Integer idUtente);


    @Query(
            value = "DELETE FROM user_unliker u WHERE u.id_utente = ?1 AND u.id_unlike = ?2",
            nativeQuery = true
    )
    public void deleteElement(Integer idUtente, Integer idUnlike);

}
