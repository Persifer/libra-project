package com.virgo.backend.controller;

import com.virgo.backend.controller.dto.LikeDto;
import com.virgo.backend.exception.PostException;
import com.virgo.backend.exception.UtenteException;
import com.virgo.backend.model.PostLiker;
import com.virgo.backend.model.UserLiker;
import com.virgo.backend.service.PostLikerService;
import com.virgo.backend.service.UserLikerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/likeHandler")
public class LikeHandlerController {

    @Autowired
    private UserLikerService userLikerService;

    @Autowired
    private PostLikerService postLikerService;

    @PostMapping(value = "/addLike", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addLikeToPost(@RequestBody LikeDto postToLike){
        try{
            UserLiker userConfirmation =  userLikerService.addLikeToUser(postToLike);
            PostLiker postConfirmation = postLikerService.addLikeToPost(postToLike, userConfirmation.getLiker());

            if( postConfirmation != null ){
                return new ResponseEntity<>("Like inserito correttamente", HttpStatus.OK);
            }else{

                return new ResponseEntity<>("Liker - Unknown error. Contact the administrator", HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }catch (UtenteException | PostException error){
            return new ResponseEntity<>("Liker - " + error.getMessage(), HttpStatus.BAD_REQUEST);
        }
        catch (Exception error){
            return new ResponseEntity<>("Liker - " + error.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
