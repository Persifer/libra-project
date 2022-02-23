package com.virgo.backend.repository;

import com.virgo.backend.model.Liker;
import org.springframework.data.repository.CrudRepository;

public interface LikeCrudRepository extends CrudRepository<Liker, Integer> {
}
