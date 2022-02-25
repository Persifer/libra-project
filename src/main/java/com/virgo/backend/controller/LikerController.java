package com.virgo.backend.controller;

import com.virgo.backend.controller.dto.LikeDto;
import com.virgo.backend.exception.PostException;
import com.virgo.backend.exception.UtenteException;
import com.virgo.backend.model.Liker;
import com.virgo.backend.service.LikerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/actions" )
public class LikerController {

    @Autowired
    private LikerService likerService;

    @PostMapping(value="/addLike", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addLike(@RequestBody LikeDto addingLike){
        try{
            Liker liker = likerService.addLikeAtPost(addingLike);

            return new ResponseEntity<String>("Like inserito correttamente", HttpStatus.OK);
        }catch (UtenteException | PostException error){

            return new ResponseEntity<String>(error.getMessage(), HttpStatus.BAD_REQUEST);
        }catch (Exception error){

            return new ResponseEntity<String>(error.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
