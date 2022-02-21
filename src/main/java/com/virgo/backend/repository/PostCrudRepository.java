package com.virgo.backend.repository;

import com.virgo.backend.model.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostCrudRepository extends CrudRepository<Post, Integer> {
}
