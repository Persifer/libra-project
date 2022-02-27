package com.virgo.backend.service;

import com.virgo.backend.model.Unlike;
import com.virgo.backend.repository.UnlikeCrudRepository;
import com.virgo.backend.repository.UserUnlikerCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;

@Service("unlikeService")
@Transactional
public class UnlikeService {

    @Autowired
    private UnlikeCrudRepository unlikeCrudRepository;

    public Unlike createLike(){
        return unlikeCrudRepository.save(new Unlike(OffsetDateTime.now()));
    }


}
