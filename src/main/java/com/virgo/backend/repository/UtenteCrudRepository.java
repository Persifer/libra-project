package com.virgo.backend.repository;

import com.virgo.backend.model.Utente;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UtenteCrudRepository extends CrudRepository<Utente, Integer> {

    public List<Utente> findByUsername(String nome);

}
