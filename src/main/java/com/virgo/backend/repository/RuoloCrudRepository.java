package com.virgo.backend.repository;

import com.virgo.backend.model.Ruolo;
import org.springframework.data.repository.CrudRepository;

public interface RuoloCrudRepository extends CrudRepository<Ruolo, Integer> {

    public Ruolo findByNome(String nome);

}
