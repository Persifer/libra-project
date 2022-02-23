package com.virgo.backend.repository;

import com.virgo.backend.model.Utente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UtenteCrudRepository extends CrudRepository<Utente, Integer> {

    public Optional<Utente> findByUsername(String username);

    @Query("SELECT u FROM Utente u WHERE u.username = ?1 AND u.password = ?2 AND u.isAttivo = true")
    public Utente findByUsernameAndPassword(@Param("1") String username, @Param("2") String passw);

    @Query("SELECT u FROM Utente u WHERE u.email = ?1 AND u.isAttivo = true")
    Optional<Utente> findByEmail(@Param("1") String email);
}
