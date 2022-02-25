package com.virgo.backend.repository;

import com.virgo.backend.model.Liker;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface LikeCrudRepository extends CrudRepository<Liker, Integer> {


}
