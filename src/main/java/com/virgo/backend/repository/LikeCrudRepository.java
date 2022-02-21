package com.virgo.backend.repository;

import com.virgo.backend.model.Like;
import org.springframework.data.repository.CrudRepository;

public interface LikeCrudRepository extends CrudRepository<Like, Integer> {
}
