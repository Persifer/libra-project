package com.virgo.backend.service;

import com.virgo.backend.repository.PostCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("postService")
@Transactional
public class PostService {

    @Autowired
    private PostCrudRepository postRepo;


}
