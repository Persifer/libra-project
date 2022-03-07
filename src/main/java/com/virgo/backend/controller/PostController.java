package com.virgo.backend.controller;

import com.virgo.backend.controller.dto.DeletePostDto;
import com.virgo.backend.controller.dto.ModifyPostDto;
import com.virgo.backend.controller.dto.PostDto;
import com.virgo.backend.exception.PostException;
import com.virgo.backend.exception.UtenteException;
import com.virgo.backend.model.Post;
import com.virgo.backend.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/post")
@CrossOrigin(origins = "*")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping(value="/create", consumes = MediaType.APPLICATION_JSON_VALUE)
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
                listOfPost.add(new PostDto(elem.getTitolo(), elem.getPhotoPath(), elem.getDescrizione(), elem.getDataPublicazione(),
                        elem.getIdProprietario().getUsername()));
            }
        }

        return listOfPost;

    }

    @GetMapping(value = "/getProfilePost", consumes = MediaType.APPLICATION_JSON_VALUE)
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

    @GetMapping("/getPostBetween/{start}/{end}")
    public ResponseEntity<List<PostDto>> getPostBetween(@PathVariable("start") String startDate,
                                                        @PathVariable("end") String endDate,
                                                        @RequestHeader HttpHeaders header){
        try{
            String username = header.getFirst("username");
            String password = header.getFirst("password");


            List<Post> postList = postService.getPostBetween(username, password, startDate, endDate);

            List<PostDto> finalList = createPostDto(postList);

            if(finalList.isEmpty()){
                return new ResponseEntity<List<PostDto>>(finalList, HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<List<PostDto>>(finalList, HttpStatus.OK);
        }catch (UtenteException error){
            return new ResponseEntity<List<PostDto>>((List<PostDto>) null, HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/getLastUpdate/{start}/{end}")
    public ResponseEntity<List<PostDto>> getLastUpdateBetween(@PathVariable("start") String startDate,
                                                        @PathVariable("end") String endDate,
                                                        @RequestHeader HttpHeaders header){
        try{
            String username = header.getFirst("username");
            String password = header.getFirst("password");


            List<Post> postList = postService.getLastUpdateBetween(username, password, startDate, endDate);

            List<PostDto> finalList = createPostDto(postList);

            if(finalList.isEmpty()){
                return new ResponseEntity<List<PostDto>>(finalList, HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<List<PostDto>>(finalList, HttpStatus.OK);
        }catch (UtenteException error){
            return new ResponseEntity<List<PostDto>>((List<PostDto>) null, HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/getPostWord/{word}")
    public ResponseEntity<List<PostDto>> getPostWithWord(@PathVariable("word") String word,
                                                         @RequestHeader HttpHeaders header){
        try {
            String username = header.getFirst("username");
            String password = header.getFirst("password");

            System.out.println(word);

            List<Post> findedPost = postService.getPostWord(username, password, word);

            List<PostDto> finalList = createPostDto(findedPost);

            if(finalList.isEmpty()){
                return new ResponseEntity<List<PostDto>>(finalList, HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<List<PostDto>>(finalList, HttpStatus.OK);

        }catch (UtenteException e) {
            return new ResponseEntity<List<PostDto>>((List<PostDto>) null, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<List<PostDto>>((List<PostDto>) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/getPostWordForUser/{word}")
    public ResponseEntity<List<PostDto>> getPostWithWordForUser(@PathVariable("word") String word,
                                                         @RequestHeader HttpHeaders header){
        try {
            String username = header.getFirst("username");
            String password = header.getFirst("password");

            List<Post> findedPost = postService.getPostWordForUser(username, password, word);

            List<PostDto> finalList = createPostDto(findedPost);

            if(finalList.isEmpty()){
                return new ResponseEntity<List<PostDto>>(finalList, HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<List<PostDto>>(finalList, HttpStatus.OK);

        }catch (UtenteException e) {
            return new ResponseEntity<List<PostDto>>((List<PostDto>) null, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<List<PostDto>>((List<PostDto>) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping(value = "/modify", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> modifyPost(@RequestBody ModifyPostDto data){
        try{

            System.out.println("Posted data\n"+
                    "Titolo: "+data.getTitolo()+"\n Descrizione: "+data.getDescrizione());

            Post post = postService.modifyPost(data);

            return new ResponseEntity<String>( "Post pubblicato correttamente", HttpStatus.BAD_REQUEST);
        }catch (UtenteException | PostException error){

            return new ResponseEntity<String>(error.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception error){

            return new ResponseEntity<String>(error.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @PutMapping(value = "/delete", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deletePost(@RequestBody DeletePostDto data){
        try{
            Post deletedPost = postService.deletePost(data);
            if(deletedPost!= null){
                return new ResponseEntity<String>("Post cancellato correttamente", HttpStatus.OK);
            }else{
                return new ResponseEntity<String>("Non si è creata l'entità post", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }catch (Exception error){
            return new ResponseEntity<String>(error.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


}
