package com.virgo.backend.controller;

import com.virgo.backend.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/post", consumes = "application/json")
public class PostController {

    @Autowired
    private PostService postService;


}
