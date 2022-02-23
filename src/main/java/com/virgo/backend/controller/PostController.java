package com.virgo.backend.controller;

import com.virgo.backend.controller.dto.PostDto;
import com.virgo.backend.exception.PostException;
import com.virgo.backend.exception.UtenteException;
import com.virgo.backend.model.Post;
import com.virgo.backend.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    private List<PostDto> createPostDto(List<Post> posts){
        List<PostDto> listOfPost = new ArrayList<>();

        if(!posts.isEmpty()){
            for(Post elem : posts){
                listOfPost.add(new PostDto(elem.getTitolo(), elem.getDescrizione(), elem.getDataPublicazione(),
                        elem.getIdProprietario().getUsername()));
            }
        }

        return listOfPost;

    }

    @GetMapping("/getProfilePost")
    public ResponseEntity<List<PostDto>> getProfilePost(@RequestHeader HttpHeaders header, @RequestBody Post post){
        try {
            String username = header.getFirst("username");
            String password = header.getFirst("password");

            List<Post> profilePost = postService.getProfilePost(username, password, post);

            List<PostDto> posts = createPostDto(profilePost);

            if(profilePost.isEmpty()){
                return new ResponseEntity<List<PostDto>>(posts, HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);
        }catch (UtenteException error){

            return new ResponseEntity<List<PostDto>>((List<PostDto>) null, HttpStatus.BAD_REQUEST);
        }catch (Exception error){

            return new ResponseEntity<List<PostDto>>((List<PostDto>) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    

}
