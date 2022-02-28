package com.virgo.backend.repository;

import com.virgo.backend.model.Unlike;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UnlikeCrudRepository extends CrudRepository<Unlike, Integer> {


    public void deleteByIdUnlike( Integer idUnlike);
    
}
