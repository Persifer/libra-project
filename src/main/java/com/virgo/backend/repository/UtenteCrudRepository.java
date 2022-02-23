package com.virgo.backend.repository;

import com.virgo.backend.model.Utente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UtenteCrudRepository extends CrudRepository<Utente, Integer> {

    public Optional<Utente> findByUsername(String username);

    public Optional<Utente> findByUsernameAndPassword(String username, String passw);

    @Query("SELECT u FROM Utente u WHERE u.email = ?1 AND u.isAttivo = true")
    Optional<Utente> findByEmail(@Param("1") String email);
}
