package com.virgo.backend.controller;

import com.virgo.backend.exception.UtenteException;
import com.virgo.backend.model.Utente;
import com.virgo.backend.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/user", produces = "application/json")
public class UtenteController {

    @Autowired
    private UtenteService utenteService;

    // PreAuthorize takes -> hasRole("ROLE_") hasAnyRole("ROLE_") hasAuthority(permissions) hasAnyAuthority(permissions)
    @GetMapping("/getAll")
    // this is the same of the ant matchers but in the controller as annotations
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<Utente> getAllUser(){
        return utenteService.getAllUsers();
    }

    @PostMapping("/insert")
    @PreAuthorize("hasAuthority('admin:read')")
    public ResponseEntity<String> registration(@RequestBody Utente newUtente){
        try{
            Utente registredUser =  utenteService.registration(newUtente);

            return new ResponseEntity<String>("[*] Utente registrato [*] ", HttpStatus.CREATED);
        }catch (UtenteException exception){

            return new ResponseEntity<String>(exception.getMessage(),HttpStatus.BAD_REQUEST);
        }catch (Exception error){

            return new ResponseEntity<String>(error.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/login")
    public ResponseEntity<String> loginHandler(@RequestBody Utente user){
        try{

            utenteService.login(user);
            return new ResponseEntity<String>("[*] Utente loggato correttamente [*] ", HttpStatus.OK);
        }catch (UtenteException error){

            return new ResponseEntity<String>(error.getMessage(), HttpStatus.BAD_REQUEST);
        }catch (Exception error){

            return new ResponseEntity<String>(error.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
