package com.virgo.backend.controller;

import com.virgo.backend.controller.dto.LikeDto;
import com.virgo.backend.exception.PostException;
import com.virgo.backend.exception.UtenteException;
import com.virgo.backend.model.PostUnliker;
import com.virgo.backend.model.UserUnliker;
import com.virgo.backend.service.PostUnlikerService;
import com.virgo.backend.service.UserUnlikerService;
import org.hibernate.event.spi.PostCollectionRecreateEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/unlikeHandler")
public class UnlikeHandlerController {

    @Autowired
    private UserUnlikerService userUnlikerService;

    @Autowired
    private PostUnlikerService postUnlikerService;

    @PostMapping(value = "/addUnlike", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addUnlikeToPost(@RequestBody LikeDto data){

        try{
            UserUnliker userUnlikeEntity = userUnlikerService.addUnlike(data);
            if(userUnlikeEntity != null){
                PostUnliker unlikedEntity = postUnlikerService.addUnlike(data, userUnlikeEntity.getUnlike());

                if(unlikedEntity != null){
                    return new ResponseEntity<String>("Unlike inserito correttamente", HttpStatus.OK);
                }else{
                    return new ResponseEntity<String>("Problema nell'assegnazione del like ad un post",
                            HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }else{
                return new ResponseEntity<String>("Problema nell'assegnazione del like ad un utente",
                        HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }catch (UtenteException | PostException error){
            return new ResponseEntity<String>(error.getMessage(), HttpStatus.BAD_REQUEST);
        }catch (Exception error){
            return new ResponseEntity<String>(error.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
