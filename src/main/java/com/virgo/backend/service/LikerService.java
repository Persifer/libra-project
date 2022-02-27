package com.virgo.backend.service;

import com.virgo.backend.model.Liker;
import com.virgo.backend.repository.LikerCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;

@Service("likerService")
@Transactional
public class LikerService {

    @Autowired
    private LikerCrudRepository likerCrudRepository;

    public Liker createNewLike(){

        return likerCrudRepository.save(new Liker(OffsetDateTime.now()));
    }
}
