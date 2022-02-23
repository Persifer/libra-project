package com.virgo.backend.controller;

import com.virgo.backend.exception.PostException;
import com.virgo.backend.exception.UtenteException;
import com.virgo.backend.model.Post;
import com.virgo.backend.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/post", consumes = "application/json")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/create")
    public ResponseEntity<String> pubblicaPost(@RequestHeader HttpHeaders header, @RequestBody Post post){
        try {
            String username = header.getFirst("username");
            String password = header.getFirst("password");

            postService.publishPost(username, password, post);

            return new ResponseEntity<String>("Post pubblicato correttamente", HttpStatus.CREATED);
        }catch (UtenteException error){

            return new ResponseEntity<String>(error.getMessage(), HttpStatus.BAD_REQUEST);
        }catch (Exception error){

            return new ResponseEntity<String>(error.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public List<Post> getProfilePost(){
        return null;
    }


}
