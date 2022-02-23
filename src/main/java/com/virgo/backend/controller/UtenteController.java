package com.virgo.backend.controller;

import com.virgo.backend.model.Utente;
import com.virgo.backend.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpRequest;
import java.util.List;


@RestController
@RequestMapping(path = "/user", produces = "application/json")
public class UtenteController {

    @Autowired
    private UtenteService utenteService;

    @GetMapping("/getAll")
    public List<Utente> getAllUser(){
        return utenteService.getAllUsers();
    }

    @PostMapping("/insert")
    public HttpStatus registration(@RequestBody Utente newUtente){
        return utenteService.registration(newUtente);
    }

    @GetMapping("/login")
    public HttpStatus loginHandler(@RequestBody Utente user){
        return utenteService.login(user);

    }
}
