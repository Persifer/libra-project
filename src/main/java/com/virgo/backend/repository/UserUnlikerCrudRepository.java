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



    public Long deleteUserUnlikerById_IdUtenteAndId_IdUnlike(Integer idUtente, Integer idUnlike);

}
