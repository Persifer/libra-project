package com.virgo.backend.repository;

import com.virgo.backend.model.Unlike;
import com.virgo.backend.model.UserUnliker;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UnlikeCrudRepository extends CrudRepository<Unlike, Integer> {


    public Long deleteByIdUnlike(Integer idUnlike);
    
}
